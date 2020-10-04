package com.senyint.exercise.controller;

import com.senyint.exercise.aop.annotation.MyLog;
import com.senyint.exercise.contants.Constant;
import com.senyint.exercise.entity.EmpiPatient;
import com.senyint.exercise.service.EmpiPatientService;
import com.senyint.exercise.utils.DataResult;
import com.senyint.exercise.vo.req.PatientReqVO;
import com.senyint.exercise.vo.resp.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @program: springboot-demo
 * @description: 患者信息控制器
 * @author: lidekun
 * @create: 2020-10-01 11:41
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "患者信息接口")
public class EmpiPatientController {
    @Autowired
    private EmpiPatientService empiPatientService;

    @ApiOperation(value = "分页获取所有患者信息编码")
    @GetMapping("/patients")
    @MyLog(title = "患者信息接口", action = "分页获取所有患者信息编码")
    public DataResult<PageVO<EmpiPatient>> getPatients(@RequestParam(value = "page") Integer page,
                                                       @RequestParam(value = "pageSize") Integer pageSize,
                                                       @RequestParam(value = "patientName") String patientName,
                                                       @RequestParam(value = "genderCode") String genderCode,
                                                       @RequestParam(value = "identityType") String identityType,
                                                       @RequestParam(value = "orgCode") String orgCode){
        DataResult result = DataResult.success();
        PatientReqVO vo = new PatientReqVO();
        vo.setPatientName(patientName);
        vo.setGenderCode(genderCode);
        vo.setIdentityType(identityType);
        vo.setOrgCode(orgCode);
        vo.setPageSize(pageSize);
        vo.setPage(page);
        result.setData(empiPatientService.getPatients(vo));
        return result;
    }

    @ApiOperation(value = "添加患者信息")
    @PostMapping("/patient")
    @MyLog(title = "患者信息接口", action = "添加患者信息")
    public DataResult addPatient(@RequestBody @Valid EmpiPatient patient, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        empiPatientService.addPatient(patient, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "更新患者信息")
    @PutMapping("/patient")
    @MyLog(title = "患者信息接口", action = "更新患者信息")
    public DataResult updatePatient(@RequestBody @Valid EmpiPatient patient, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        empiPatientService.updatePatient(patient, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "删除患者信息")
    @DeleteMapping("/patient")
    @MyLog(title = "患者信息接口", action = "删除患者信息")
    public DataResult deletePatient(@RequestBody EmpiPatient patient, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        empiPatientService.deletePatient(patient, accessToken);
        DataResult result = DataResult.success();
        return result;
    }
}
