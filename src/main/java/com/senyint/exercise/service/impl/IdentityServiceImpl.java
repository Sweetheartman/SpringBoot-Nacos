package com.senyint.exercise.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.senyint.exercise.entity.Identity;
import com.senyint.exercise.entity.SysUser;
import com.senyint.exercise.exception.BusinessException;
import com.senyint.exercise.exception.code.BaseResponseCode;
import com.senyint.exercise.mapper.IdentityMapper;
import com.senyint.exercise.mapper.SysUserMapper;
import com.senyint.exercise.service.IdentityService;
import com.senyint.exercise.utils.JwtTokenUtil;
import com.senyint.exercise.utils.PageUtil;
import com.senyint.exercise.vo.req.IdentityPageReqVO;
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
 * @description: 证件类型服务层接口实现类
 * @author: lidekun
 * @create: 2020-10-01 08:37
 **/
@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private IdentityMapper identityMapper;

    /**
     * 分页获取所有的证件类型
     * @param vo
     * @return
     */
    @Override
    public PageVO<Identity> getIdentities(IdentityPageReqVO vo) {
        Example example = new Example(Identity.class);
        Example.Criteria criteria = example.createCriteria();
        /*
            查询未删除的记录
         */
        criteria.andEqualTo("deleteFlag", "0");

        /*
            精确查询证件类型
         */
        if(!StringUtils.isEmpty(vo.getIdentityType()) || vo.getIdentityType() != ""){
            criteria.andEqualTo("identityType", vo.getIdentityType());
        }
        /*
            模糊查询证件名称
         */
        if(!StringUtils.isEmpty(vo.getIdentityName()) || vo.getIdentityName() != ""){
            criteria.andLike("identityName", "%" + vo.getIdentityName() + "%");
        }


        PageHelper.startPage(vo.getPage(), vo.getPageSize());
        List<Identity> identityList = identityMapper.selectByExample(example);
        return PageUtil.getPageVo(identityList);
    }

    /**
     * 不分页获取所有证件类型信息
     * @return
     */
    @Override
    public List<Identity> getIdentities() {
        Example example = new Example(Identity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag","0");
        return identityMapper.selectByExample(example);
    }

    /**
     * 添加证件类型
     * @param identity
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addIdentity(Identity identity, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        identity.setIdentityType(UUID.randomUUID().toString());
        identity.setIdentityName(identity.getIdentityName());
        identity.setCreateBy(sysUser.getUsername());
        identity.setCreateTime(new Date());
        identity.setUpdateCount(0);
        identity.setDeleteFlag("0");
        identityMapper.insertSelective(identity);
    }

    /**
     * 更新证件类型
     * @param identity
     * @param accessToken
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateIdentity(Identity identity, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        更新者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        identity.setUpdateBy(sysUser.getUsername());
        int count = identity.getUpdateCount();
        identity.setUpdateCount(++count);
        identity.setUpdateTime(new Date());
        identityMapper.updateByPrimaryKeySelective(identity);
    }

    /**
     * 删除证件类型
     * @param identity
     * @param accessToken
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteIdentity(Identity identity, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        删除者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        identity.setDeleteBy(sysUser.getUsername());
        identity.setDeleteTime(new Date());
        identity.setDeleteFlag("1");

        identityMapper.updateByPrimaryKeySelective(identity);
    }

    /**
     * 根据证件类型获取证件信息
     * @param identityType
     * @return
     */
    @Override
    public Identity getIdentityByType(String identityType) {
        Example example = new Example(Identity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag","0");
        if(StringUtils.isEmpty(identityType)){
            throw new BusinessException(BaseResponseCode.VALIDATOR_ERROR);
        }
        criteria.andEqualTo("identityType", identityType);
        return identityMapper.selectOneByExample(example);
    }
}
