package com.senyint.exercise.interceptor;

import com.senyint.exercise.contants.Constant;
import com.senyint.exercise.exception.BusinessException;
import com.senyint.exercise.exception.code.BaseResponseCode;
import com.senyint.exercise.service.RedisService;
import com.senyint.exercise.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springboot-demo
 * @description: accessToken验证拦截器
 * @author: lidekun
 * @create: 2020-09-26 10:47
 **/
@Slf4j
public class TokenInterceptpr implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /*
        判断用户是否携带凭证
         */
        String accessToken = request.getHeader("accessToken");
        String userId= JwtTokenUtil.getUserId(accessToken);
        log.info("doCredentialsMatch....userId={}",userId);
        if(StringUtils.isEmpty(accessToken)){
            throw new BusinessException(BaseResponseCode.TOKEN_NOT_NULL);
        }

        /*
         * 判断用户是否被删除(删除用户时添加标记)
         * 过期时间为app的refreshToken的过期时间
         */
        if(redisService.hasKey(Constant.DELETED_USER_KEY+userId)){
            throw new BusinessException(BaseResponseCode.ACCOUNT_HAS_DELETED_ERROR);
        }

        /*
         * 判断是否被锁定(编辑用户时添加标记)
         * 无过期时间，解除锁定时删除redis的key
         */
        if(redisService.hasKey(Constant.ACCOUNT_LOCK_KEY+userId)){
            throw new BusinessException(BaseResponseCode.ACCOUNT_LOCK);
        }

        /*
         * 判断用户是否退出登录，退出登录即加入黑名单(用户退出服务层接口添加,用户修改密码时标记)
         * 过期时间分别是accessToken和refreshToken的剩余时间。
         * 用户accessToken过期使用refreshToken刷新换取时也需要检测refreshToken
         * 是否在黑名单中
         */
        if(redisService.hasKey(Constant.JWT_ACCESS_TOKEN_BLACKLIST+accessToken)){
            throw new BusinessException(BaseResponseCode.TOKEN_ERROR);
        }

        /*
        校验token
        1.是否正确
        2.是否过期
         */
        if(!JwtTokenUtil.validateToken(accessToken)){
            throw new BusinessException(BaseResponseCode.TOKEN_PAST_DUE);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
