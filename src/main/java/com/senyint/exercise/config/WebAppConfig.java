package com.senyint.exercise.config;

import com.senyint.exercise.interceptor.TokenInterceptpr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: permission-actual-project
 * @description: MVC配置类(拦截器)
 * @author: lidekun
 * @create: 2020-08-30 17:54
 **/
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * 将自定义验证码拦截器注入容器
     * @return TokenInterceptpr
     */
    @Bean
    public TokenInterceptpr tokenInterceptpr(){
        return new TokenInterceptpr();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> openUrl = new ArrayList<>();
        openUrl.add("/api/user/login");
        openUrl.add("/api/user/info");
        registry.addInterceptor(tokenInterceptpr())
                .addPathPatterns("/api/**")
                .excludePathPatterns(openUrl);
    }
}
