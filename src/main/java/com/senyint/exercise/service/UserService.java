package com.senyint.exercise.service;

import com.senyint.exercise.entity.SysUser;
import com.senyint.exercise.vo.req.LoginReqVO;
import com.senyint.exercise.vo.req.UserUpdatePwdReqVO;
import com.senyint.exercise.vo.resp.LoginRespVO;

/**
 * @program: springboot-demo
 * @description: 用户相关服务层接口
 * @author: lidekun
 * @create: 2020-09-26 11:35
 **/
public interface UserService {
    LoginRespVO login(LoginReqVO vo);

    /**
     * 通过accessToken获取用户信息
     * @param accessToken
     * @return
     */
    SysUser getUserInfoByAccessToken(String accessToken);

    /**
     * 用户退出登录
     * @param accessToken
     * @param refreshToken
     */
    void logout(String accessToken, String refreshToken);

    /**
     * 刷新accessToken接口
     * @param refreshToken
     * @return
     */
    String refreshToken(String refreshToken);

    /**
     * 用户修改密码接口
     * @param vo
     * @param accessToken
     * @param refreshToken
     */
    void userUpdatePwd(UserUpdatePwdReqVO vo, String accessToken, String refreshToken);
}
