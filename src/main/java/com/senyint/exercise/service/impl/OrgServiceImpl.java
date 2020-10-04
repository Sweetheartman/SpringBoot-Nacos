package com.senyint.exercise.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.senyint.exercise.entity.Gender;
import com.senyint.exercise.entity.Org;
import com.senyint.exercise.entity.SysUser;
import com.senyint.exercise.exception.BusinessException;
import com.senyint.exercise.exception.code.BaseResponseCode;
import com.senyint.exercise.mapper.OrgMapper;
import com.senyint.exercise.mapper.SysUserMapper;
import com.senyint.exercise.service.OrgService;
import com.senyint.exercise.utils.JwtTokenUtil;
import com.senyint.exercise.utils.PageUtil;
import com.senyint.exercise.vo.req.OrgPageReqVO;
import com.senyint.exercise.vo.resp.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: springboot-demo
 * @description: 机构编码服务层接口实现类
 * @author: lidekun
 * @create: 2020-09-30 18:46
 **/
@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private OrgMapper orgMapper;

    /**
     * 分页获取所有的机构编码信息
     * @param vo
     * @return Orgs列表
     */
    @Override
    public PageVO<Org> getOrgs(OrgPageReqVO vo) {
        Example example = new Example(Org.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag", "0");
        if(!StringUtils.isEmpty(vo.getOrgName()) || vo.getOrgName() != ""){
            criteria.andLike("orgName", "%" + vo.getOrgName() + "%");
        }

        PageHelper.startPage(vo.getPage(), vo.getPageSize());
        List<Org> orgList = orgMapper.selectByExample(example);
        return PageUtil.getPageVo(orgList);
    }

    /**
     * 不分页获取所有机构编码信息
     * @return
     */
    @Override
    public List<Org> getOrgs() {
        Example example = new Example(Org.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag","0");
        return orgMapper.selectByExample(example);
    }

    /**
     * 添加机构编码
     * @param org
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrg(Org org, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        org.setOrgCode(UUID.randomUUID().toString());
        org.setCreateBy(sysUser.getUsername());
        org.setCreateTime(new Date());
        org.setUpdateCount(0);
        org.setDeleteFlag("0");
        orgMapper.insertSelective(org);
    }

    /**
     * 更新机构编码
     * @param org
     * @param accessToken
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrg(Org org, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        更新者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        org.setUpdateBy(sysUser.getUsername());
        int count = org.getUpdateCount();
        org.setUpdateCount(++count);
        org.setUpdateTime(new Date());
        orgMapper.updateByPrimaryKeySelective(org);
    }

    /**
     * 删除机构编码
     * @param org
     * @param accessToken
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrg(Org org, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        删除者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        org.setDeleteBy(sysUser.getUsername());
        org.setDeleteTime(new Date());
        org.setDeleteFlag("1");

        orgMapper.updateByPrimaryKeySelective(org);
    }

    /**
     * 根据机构编码查询机构信息
     * @param orgCode
     * @return
     */
    @Override
    public Org getOrgByCode(String orgCode) {
        Example example = new Example(Org.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag", "0");
        if(StringUtils.isEmpty(orgCode)){
            throw new BusinessException(BaseResponseCode.VALIDATOR_ERROR);
        }
        criteria.andEqualTo("orgCode", orgCode);
        return orgMapper.selectOneByExample(example);
    }
}
