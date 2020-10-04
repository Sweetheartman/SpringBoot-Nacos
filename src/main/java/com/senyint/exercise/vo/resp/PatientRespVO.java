package com.senyint.exercise.vo.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: springboot-demo
 * @description: 患者信息返回字段
 * @author: lidekun
 * @create: 2020-09-30 10:13
 **/
@Data
public class PatientRespVO {
    @ApiModelProperty(value = "患者主索引")
    private String empiId;
    @ApiModelProperty(value = "机构编码")
    private String orgCode;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "患者姓名")
    private String patientName;
    @ApiModelProperty(value = "性别编码")
    private String genderCode;
    @ApiModelProperty(value = "性别名称")
    private String genderName;
    @ApiModelProperty(value = "出生日期")
    private Date birthDate;
    @ApiModelProperty(value = "身份证号")
    private String socialNo;
    @ApiModelProperty(value = "联系电话")
    private String telecom;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "证件类型")
    private String identityType;
    @ApiModelProperty(value = "证件名称")
    private String identityName;
    @ApiModelProperty(value = "证件号")
    private String identityNo;
    @ApiModelProperty(value = "家庭地址-非结构化地址")
    private String homeFullAddress;
    @ApiModelProperty(value = "家庭地址-省（自治区，直辖市）")
    private String homeAddrProvince;
    @ApiModelProperty(value = "家庭地址-市（地区）")
    private String homeAddrCity;
    @ApiModelProperty(value = "家庭地址-县（区）")
    private String homeAddrCounty;
    @ApiModelProperty(value = "家庭地址-乡（镇，街道办事处）")
    private String homeAddrTown;
    @ApiModelProperty(value = "家庭地址-村（街，路，弄等）")
    private String homeAddrVillage;
    @ApiModelProperty(value = "家庭地址-门牌号码")
    private String homeAddrHouseNo;
    @ApiModelProperty(value = "家庭地址-邮政编码")
    private String homeZipCode;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "创建者")
    private String createBy;
    @ApiModelProperty(value = "更新次数")
    private Integer updateCount;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "更新者")
    private String updateBy;
    @ApiModelProperty(value = "删除标识")
    private String deleteFlag;
    @ApiModelProperty(value = "删除时间")
    private Date deleteTime;
    @ApiModelProperty(value = "删除者")
    private String deleteBy;
}
