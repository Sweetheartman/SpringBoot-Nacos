package com.senyint.exercise.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.senyint.exercise.entity.Gender;
import com.senyint.exercise.entity.SysUser;
import com.senyint.exercise.exception.BusinessException;
import com.senyint.exercise.exception.code.BaseResponseCode;
import com.senyint.exercise.mapper.GenderMapper;
import com.senyint.exercise.mapper.SysUserMapper;
import com.senyint.exercise.service.GenderService;
import com.senyint.exercise.utils.JwtTokenUtil;
import com.senyint.exercise.utils.PageUtil;
import com.senyint.exercise.vo.req.GenderPageReqVO;
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
 * @description: 性别编码服务层接口实现类
 * @author: lidekun
 * @create: 2020-09-30 11:12
 **/
@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderMapper genderMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 分页获取所有的性别编码信息
     * @param vo
     * @return Gender列表
     */
    @Override
    public PageVO<Gender> getGenders(GenderPageReqVO vo) {
        Example example = new Example(Gender.class);
        example.createCriteria().andEqualTo("deleteFlag", "0");
        PageHelper.startPage(vo.getPage(), vo.getPageSize());
        List<Gender> genderList = genderMapper.selectByExample(example);
        return PageUtil.getPageVo(genderList);
    }

    /**
     * 获取所有的性别编码信息
     * @return
     */
    @Override
    public List<Gender> getGenders() {
        Example example = new Example(Gender.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag","0");
        return genderMapper.selectByExample(example);
    }

    /**
     * 添加性别编码
     * @param gender
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addGender(Gender gender, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        gender.setGenderCode(UUID.randomUUID().toString());
        gender.setCreateTime(new Date());
        gender.setCreateBy(sysUser.getUsername());
        gender.setUpdateCount(0);
        gender.setDeleteFlag("0");
        genderMapper.insertSelective(gender);
    }

    /**
     * 更新性别编码
     * @param gender
     * @param accessToken
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGender(Gender gender, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        更新者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        gender.setUpdateBy(sysUser.getUsername());
        int count = gender.getUpdateCount();
        gender.setUpdateCount(++count);
        gender.setUpdateTime(new Date());

        genderMapper.updateByPrimaryKeySelective(gender);
    }

    /**
     * 删除性别编码
     * @param gender
     * @param accessToken
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteGender(Gender gender, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        删除者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        gender.setDeleteBy(sysUser.getUsername());
        gender.setDeleteTime(new Date());
        gender.setDeleteFlag("1");

        genderMapper.updateByPrimaryKeySelective(gender);
    }

    /**
     * 根据性别编码获取性别信息
     * @param genderCode
     * @return
     */
    @Override
    public Gender getGenderByCode(String genderCode) {
        Example example = new Example(Gender.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag", "0");
        if(StringUtils.isEmpty(genderCode)){
            throw new BusinessException(BaseResponseCode.VALIDATOR_ERROR);
        }
        criteria.andEqualTo("genderCode", genderCode);
        return genderMapper.selectOneByExample(example);
    }
}
