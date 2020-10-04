package com.senyint.exercise.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: springboot-demo
 * @description: 证件类型请求字段
 * @author: lidekun
 * @create: 2020-10-01 08:32
 **/
@Data
public class IdentityPageReqVO {
    @ApiModelProperty(value = "页码")
    private Integer page = 1;
    @ApiModelProperty(value = "每页显示的记录数")
    private Integer pageSize = 5;
    @ApiModelProperty(value = "证件类型")
    private String identityType;
    @ApiModelProperty(value = "证件名称")
    private String identityName;
}
