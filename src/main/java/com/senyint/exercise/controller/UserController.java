package com.senyint.exercise.controller;

import cn.shuibo.annotation.Decrypt;
import com.senyint.exercise.aop.annotation.MyLog;
import com.senyint.exercise.contants.Constant;
import com.senyint.exercise.entity.SysUser;
import com.senyint.exercise.service.UserService;
import com.senyint.exercise.utils.DataResult;
import com.senyint.exercise.vo.req.LoginReqVO;
import com.senyint.exercise.vo.req.UserUpdatePwdReqVO;
import com.senyint.exercise.vo.resp.LoginRespVO;
import com.senyint.exercise.vo.resp.UserInfoRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-demo
 * @description: 系统用户控制器
 * @author: lidekun
 * @create: 2020-09-26 11:33
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "用户接口")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录接口")
    @PostMapping("/user/login")
    @Decrypt
    @MyLog(title = "用户接口", action = "用户登录接口")
    public DataResult<LoginRespVO> login(@RequestBody @Valid LoginReqVO vo){
        DataResult result = DataResult.success();
        result.setData(userService.login(vo));
        return result;
    }

    @ApiOperation(value = "根据AccessToken获取用户信息接口")
    @GetMapping("/user/info")
    @MyLog(title = "用户接口", action = "根据AccessToken获取用户信息接口")
    public DataResult<UserInfoRespVO> getUserInfoByAccessToken(@RequestParam String access_token){
        DataResult result = DataResult.success();
        SysUser sysUser = userService.getUserInfoByAccessToken(access_token);
        UserInfoRespVO vo = new UserInfoRespVO();
        BeanUtils.copyProperties(sysUser, vo);
        List<String> roles = new ArrayList<>(1);
        roles.add("admin");
        vo.setRoles(roles);
        result.setData(vo);
        return result;
    }

    @PostMapping("/user/logout")
    @ApiOperation(value = "用户退出登录接口")
    @MyLog(title = "用户接口", action = "用户退出登录接口")
    public DataResult logout(HttpServletRequest request){

        String accessToken=request.getHeader(Constant.ACCESS_TOKEN);
        String refreshToken=request.getHeader(Constant.REFRESH_TOKEN);
        userService.logout(accessToken,refreshToken);
        return DataResult.success();
    }

    @GetMapping("/user/token")
    @ApiOperation(value = "刷新accessToken接口")
    @MyLog(title = "用户接口", action = "刷新accessToken接口")
    public DataResult<String> refreshAccessToken(@RequestParam String refreshToken){
        String newAccessToken = userService.refreshToken(refreshToken);
        DataResult result = DataResult.success();
        result.setData(newAccessToken);
        return result;
    }

    @PutMapping("/user/pwd")
    @ApiOperation(value = "修改个人密码接口")
    @MyLog(title = "用户接口", action = "修改个人密码接口")
    @Decrypt
    public DataResult updatePwd(@RequestBody @Valid UserUpdatePwdReqVO vo, HttpServletRequest request){

        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
        userService.userUpdatePwd(vo, accessToken, refreshToken);
        return DataResult.success();
    }
}
