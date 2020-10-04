package com.senyint.exercise.controller;

import com.senyint.exercise.aop.annotation.MyLog;
import com.senyint.exercise.utils.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: springboot-demo
 * @description: Api版本控制器(测试接口)
 * @author: lidekun
 * @create: 2020-09-26 00:38
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "Api版本信息接口")
public class ApiVersionController {
    @Autowired
    @Value("${api.version}")
    private String apiVersion;

    @GetMapping("/version")
    @ApiOperation(value = "查询当前接口的版本")
    @MyLog(title = "Api版本信息接口", action = "查询当前接口的版本")
    public DataResult<String> getAllDept(){
        DataResult result = DataResult.success();
        result.setData("当前Api版本" + apiVersion);
        return result;
    }
}
