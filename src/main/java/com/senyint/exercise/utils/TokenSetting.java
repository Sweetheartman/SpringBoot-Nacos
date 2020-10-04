package com.senyint.exercise.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @ClassName:       TokenSettiing
 *                   从配置文件读取JWT的配置信息
 * @Author:          lidekun
 * @CreateDate:      2020/8/20 13:44
 * @UpdateUser:      lidekun
 * @UpdateDate:      2020/8/20 13:44
 * @Version:         0.0.1
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class TokenSetting {
    private String secretKey;
    private Duration accessTokenExpireTime;
    private Duration refreshTokenExpireTime;
    private Duration refreshTokenExpireAppTime;
    private String issuer;
}
