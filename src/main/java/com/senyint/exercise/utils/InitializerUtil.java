package com.senyint.exercise.utils;

import org.springframework.stereotype.Component;

/**
 * @program: permission-actual-project
 * @description: JWT的代理类，构造方法接收将从配置文件读取到的信息，然后调用JWT的工具类中的静态方法设置
 *               JWT工具类的静态变量
 * @author: lidekun
 * @create: 2020-08-22 11:46
 **/
@Component
public class InitializerUtil {

    public InitializerUtil(TokenSetting tokenSetting) {
        JwtTokenUtil.setJwtProperties(tokenSetting);
    }
}
