package com.senyint.exercise.vo.req;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: springboot-demo
 * @description: 分页请求字段
 * @author: lidekun
 * @create: 2020-09-30 11:09
 **/
@Data
public class GenderPageReqVO {
    @ApiModelProperty(value = "页码")
    private Integer page = 1;
    @ApiModelProperty(value = "每页显示的记录数")
    private Integer pageSize = 5;

}
