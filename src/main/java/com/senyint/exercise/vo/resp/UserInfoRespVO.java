package com.senyint.exercise.vo.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: springboot-demo
 * @description: 返回获取用户信息
 * @author: lidekun
 * @create: 2020-09-26 23:18
 **/
@Data
public class UserInfoRespVO {
    @ApiModelProperty(value = "用户ID")
    private String id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户真实姓名")
    private String realName;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "角色信息")
    private List<String> roles;
    @ApiModelProperty(value = "默认头像")
    private String avatar = "http://blog.spirit-guy.com/upload/image/icon.jpg";
}
