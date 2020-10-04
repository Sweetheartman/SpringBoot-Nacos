package com.senyint.exercise.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: springboot-demo
 * @description: 患者请求参数字段
 * @author: lidekun
 * @create: 2020-10-01 09:48
 **/
@Data
public class PatientReqVO {
    @ApiModelProperty(value = "页码")
    private Integer page = 1;
    @ApiModelProperty(value = "每页显示的记录数")
    private Integer pageSize = 5;
    @ApiModelProperty(value = "患者姓名")
    private String patientName;
    @ApiModelProperty(value = "性别编码")
    private String genderCode;
    @ApiModelProperty(value = "证件类型编码")
    private String identityType;
    @ApiModelProperty(value = "机构编码")
    private String orgCode;

}
