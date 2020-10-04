package com.senyint.exercise.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: springboot-demo
 * @description: 机构列表入参字段
 * @author: lidekun
 * @create: 2020-09-30 18:44
 **/
@Data
public class OrgPageReqVO {
    @ApiModelProperty(value = "页码")
    private Integer page = 1;
    @ApiModelProperty(value = "每页显示的记录数")
    private Integer pageSize = 5;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
}
