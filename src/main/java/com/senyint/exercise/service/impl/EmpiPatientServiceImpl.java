package com.senyint.exercise.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.senyint.exercise.entity.*;
import com.senyint.exercise.mapper.EmpiPatientMapper;
import com.senyint.exercise.mapper.SysUserMapper;
import com.senyint.exercise.service.EmpiPatientService;
import com.senyint.exercise.service.GenderService;
import com.senyint.exercise.service.IdentityService;
import com.senyint.exercise.service.OrgService;
import com.senyint.exercise.utils.JwtTokenUtil;
import com.senyint.exercise.utils.PageUtil;
import com.senyint.exercise.vo.req.PatientReqVO;
import com.senyint.exercise.vo.resp.PageVO;
import com.senyint.exercise.vo.resp.PatientRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: springboot-demo
 * @description: 患者信息服务层接口实现类
 * @author: lidekun
 * @create: 2020-10-01 09:46
 **/
@Service
public class EmpiPatientServiceImpl implements EmpiPatientService {

    @Autowired
    private EmpiPatientMapper empiPatientMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private OrgService orgService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private GenderService genderService;

    /**
    * @Description: 分页获取所有患者的信息（未删除和条件查询）
    * @Param: [vo]
    * @return: com.senyint.exercise.vo.resp.PageVO<com.senyint.exercise.vo.resp.PatientRespVO>
    * @Author: LiDeKun
    * @Date: 2020/10/11  
    */
    @Override
    public PageVO<PatientRespVO> getPatients(PatientReqVO vo) {
        Example example = new Example(EmpiPatient.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleteFlag", "0");
        if(!StringUtils.isEmpty(vo.getPatientName()) || vo.getPatientName() != ""){
            criteria.andLike("patientName", "%" + vo.getPatientName() + "%");
        }
        if(!StringUtils.isEmpty(vo.getGenderCode()) || vo.getGenderCode() != ""){
            criteria.andEqualTo("genderCode", vo.getGenderCode());
        }
        if(!StringUtils.isEmpty(vo.getOrgCode()) || vo.getOrgCode() != ""){
            criteria.andEqualTo("orgCode", vo.getOrgCode());
        }
        if(!StringUtils.isEmpty(vo.getIdentityType()) || vo.getIdentityType() != ""){
            criteria.andEqualTo("identityType",  vo.getIdentityType());
        }

        PageHelper.startPage(vo.getPage(), vo.getPageSize());
        List<EmpiPatient> empiPatientsList = empiPatientMapper.selectByExample(example);
        return PageUtil.getPageVo(empiPatientsList);
    }

    /**
    * @Description: 添加患者信息
    * @Param: [empiPatient, accessToken]
    * @return: void
    * @Author: LiDeKun
    * @Date: 2020/10/11  
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPatient(EmpiPatient empiPatient, String accessToken) {
        /*
        添加者
         */
        String userId = JwtTokenUtil.getUserId(accessToken);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        /*
          机构名称
         */
        Org org = orgService.getOrgByCode(empiPatient.getOrgCode());
        empiPatient.setOrgName(org.getOrgName());

        /*
         * 证件名称
         */
        Identity identity = identityService.getIdentityByType(empiPatient.getIdentityType());
        empiPatient.setIdentityName(identity.getIdentityName());

        /*
           性别名称
         */
        Gender gender = genderService.getGenderByCode(empiPatient.getGenderCode());
        empiPatient.setGenderName(gender.getGenderName());

        empiPatient.setEmpiId(UUID.randomUUID().toString());
        empiPatient.setCreateBy(sysUser.getUsername());
        empiPatient.setCreateTime(new Date());
        empiPatient.setUpdateCount(0);
        empiPatient.setDeleteFlag("0");
        empiPatientMapper.insertSelective(empiPatient);
    }

    /**
    * @Description: 更新患者信息
    * @Param: [empiPatient, accessToken]
    * @return: void
    * @Author: LiDeKun
    * @Date: 2020/10/11
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePatient(EmpiPatient empiPatient, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        更新者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);

         /*
          机构名称
         */
        Org org = orgService.getOrgByCode(empiPatient.getOrgCode());
        empiPatient.setOrgName(org.getOrgName());

        /*
         * 证件名称
         */
        Identity identity = identityService.getIdentityByType(empiPatient.getIdentityType());
        empiPatient.setIdentityType(identity.getIdentityType());

        /*
           性别名称
         */
        Gender gender = genderService.getGenderByCode(empiPatient.getGenderCode());
        empiPatient.setGenderName(gender.getGenderName());

        empiPatient.setUpdateBy(sysUser.getUsername());
        int count = empiPatient.getUpdateCount();
        empiPatient.setUpdateCount(++count);
        empiPatient.setUpdateTime(new Date());
        empiPatientMapper.updateByPrimaryKeySelective(empiPatient);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePatient(EmpiPatient empiPatient, String accessToken) {
        String userId = JwtTokenUtil.getUserId(accessToken);
        /*
        删除者
         */
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        empiPatient.setDeleteBy(sysUser.getUsername());
        empiPatient.setDeleteTime(new Date());
        empiPatient.setDeleteFlag("1");

        empiPatientMapper.updateByPrimaryKeySelective(empiPatient);
    }
}
