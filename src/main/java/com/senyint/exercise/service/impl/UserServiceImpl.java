package com.senyint.exercise.service.impl;

import com.senyint.exercise.contants.Constant;
import com.senyint.exercise.entity.SysUser;
import com.senyint.exercise.exception.BusinessException;
import com.senyint.exercise.exception.code.BaseResponseCode;
import com.senyint.exercise.mapper.SysUserMapper;
import com.senyint.exercise.service.RedisService;
import com.senyint.exercise.service.UserService;
import com.senyint.exercise.utils.JwtTokenUtil;
import com.senyint.exercise.utils.PasswordUtils;
import com.senyint.exercise.vo.req.LoginReqVO;
import com.senyint.exercise.vo.req.UserUpdatePwdReqVO;
import com.senyint.exercise.vo.resp.LoginRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: springboot-demo
 * @description: 用户服务层接口实现类
 * @author: lidekun
 * @create: 2020-09-26 11:36
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public LoginRespVO login(LoginReqVO vo) {
        SysUser sysUser = sysUserMapper.selectByUsername(vo.getUsername());
        if(sysUser==null){
            throw new BusinessException(BaseResponseCode.ACCOUNT_ERROR);
        }
        if(sysUser.getStatus() == 2){
            throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK_TIP);
        }
        if(!PasswordUtils.matches(sysUser.getSalt(),vo.getPassword(),sysUser.getPassword())){
            throw new BusinessException(BaseResponseCode.ACCOUNT_PASSWORD_ERROR);
        }

        Map<String,Object> claims=new HashMap<>();
        claims.put(Constant.JWT_USER_NAME,sysUser.getUsername());
        claims.put(Constant.JWT_USER_ID,sysUser.getId());
        String accessToken= JwtTokenUtil.getAccessToken(sysUser.getId(),claims);
        log.info("accessToken={}",accessToken);

        Map<String,Object> refreshTokenClaims=new HashMap<>();
        refreshTokenClaims.put(Constant.JWT_USER_NAME,sysUser.getUsername());
        refreshTokenClaims.put(Constant.JWT_USER_ID,sysUser.getId());
        String refreshToken=JwtTokenUtil.getRefreshToken(sysUser.getId(),refreshTokenClaims);;

        log.info("refreshToken={}",refreshToken);
        LoginRespVO loginRespVO=new LoginRespVO();
        loginRespVO.setUserId(sysUser.getId());
        loginRespVO.setRefreshToken(refreshToken);
        loginRespVO.setAccessToken(accessToken);
        return loginRespVO;
    }

    @Override
    public SysUser getUserInfoByAccessToken(String accessToken) {
        if(StringUtils.isEmpty(accessToken)){
            throw new BusinessException(BaseResponseCode.TOKEN_NOT_NULL);
        }
        if(!JwtTokenUtil.validateToken(accessToken)){
            throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE);
        }
        String userId = JwtTokenUtil.getUserId(accessToken);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        if(sysUser == null){
            throw new BusinessException(BaseResponseCode.ACCOUNT_ERROR);
        }
        return sysUser;
    }

    /**
     * 用户退出登录
     * @param accessToken
     * @param refreshToken
     */
    @Override
    public void logout(String accessToken, String refreshToken) {
        if(StringUtils.isEmpty(accessToken)|| StringUtils.isEmpty(refreshToken)){
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        String userId=JwtTokenUtil.getUserId(accessToken);
        /**
         * 把accessToken 加入黑名单
         */
        redisService.set(Constant.JWT_ACCESS_TOKEN_BLACKLIST+accessToken,userId,JwtTokenUtil.getRemainingTime(accessToken), TimeUnit.MILLISECONDS);

        /**
         * 把refreshToken 加入黑名单
         */
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST+refreshToken,userId,JwtTokenUtil.getRemainingTime(refreshToken),TimeUnit.MILLISECONDS);
    }

    /**
     * 刷新accessToken接口
     * @param refreshToken
     * @return
     */
    @Override
    public String refreshToken(String refreshToken) {
        // 校验refreshToken是否有效
        // 校验refreshToken是否过期以及主动退出以后进入黑名单
        if(!JwtTokenUtil.validateToken(refreshToken) || redisService.hasKey(Constant.JWT_REFRESH_TOKEN_BLACKLIST+refreshToken)){
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        // 重新生成accessToken，重新设置负载信息(用户名，角色，权限)
        String username = JwtTokenUtil.getUserName(refreshToken);

        SysUser sysUser = sysUserMapper.selectByUsername(username);

        Map<String,Object> claims=new HashMap<>();
        claims.put(Constant.JWT_USER_NAME,sysUser.getUsername());
        claims.put(Constant.JWT_USER_ID,sysUser.getId());
        String newAccessToken= JwtTokenUtil.getAccessToken(sysUser.getId(),claims);
        log.info("newAccessToken={}",newAccessToken);

        return newAccessToken;
    }

    /**
     * 用户修改密码接口
     * @param vo
     * @param accessToken
     * @param refreshToken
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userUpdatePwd(UserUpdatePwdReqVO vo, String accessToken, String refreshToken) {
        // 校验旧密码
        String userId = JwtTokenUtil.getUserId(accessToken);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        if(sysUser == null){
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }
        if(!PasswordUtils.matches(sysUser.getSalt(), vo.getOldPwd(), sysUser.getPassword())){
            throw new BusinessException(BaseResponseCode.OLD_PASSWORD_ERROR);
        }
        // 旧密码匹配成功
        String newPwd = PasswordUtils.encode(vo.getNewPwd(), sysUser.getSalt());
        sysUser.setPassword(newPwd);
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
        if(i != 1){
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        // 之前签发的token失效
        redisService.set(Constant.JWT_REFRESH_TOKEN_BLACKLIST+accessToken, userId, JwtTokenUtil.getRemainingTime(accessToken), TimeUnit.MILLISECONDS);
        redisService.set(Constant.JWT_ACCESS_TOKEN_BLACKLIST+refreshToken,userId,JwtTokenUtil.getRemainingTime(refreshToken),TimeUnit.MILLISECONDS);

    }
}
