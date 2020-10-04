package com.senyint.exercise.service;

import com.senyint.exercise.entity.EmpiPatient;
import com.senyint.exercise.vo.req.PatientReqVO;
import com.senyint.exercise.vo.resp.PageVO;
import com.senyint.exercise.vo.resp.PatientRespVO;

/**
 * @program: springboot-demo
 * @description: 患者信息接口层
 * @author: lidekun
 * @create: 2020-09-30 10:12
 **/
public interface EmpiPatientService {

    /**
     * 分页获取所有患者的信息（未删除和条件查询）
     * @param vo
     * @return
     */
    PageVO<PatientRespVO> getPatients(PatientReqVO vo);

    /**
     * 添加患者信息
     * @param empiPatient
     * @param accessToken
     */
    void addPatient(EmpiPatient empiPatient, String accessToken);

    /**
     * 更新患者信息
     * @param empiPatient
     * @param accessToken
     */
    void updatePatient(EmpiPatient empiPatient, String accessToken);

    /**
     * 删除患者信息
     * @param empiPatient
     * @param accessToken
     */
    void deletePatient(EmpiPatient empiPatient, String accessToken);
}
