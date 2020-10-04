package com.senyint.exercise.controller;

import com.senyint.exercise.aop.annotation.MyLog;
import com.senyint.exercise.contants.Constant;
import com.senyint.exercise.entity.Gender;
import com.senyint.exercise.service.GenderService;
import com.senyint.exercise.utils.DataResult;
import com.senyint.exercise.vo.req.GenderPageReqVO;
import com.senyint.exercise.vo.resp.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @program: springboot-demo
 * @description: 性别编码控制层
 * @author: lidekun
 * @create: 2020-09-30 11:27
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "性别编码接口")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @ApiOperation(value = "分页获取所有性别编码")
    @GetMapping("/genders/page")
    @MyLog(title = "性别编码接口", action = "分页获取所有性别编码")
    public DataResult<PageVO<Gender>> getGendersPage(GenderPageReqVO vo){
        DataResult result = DataResult.success();
        result.setData(genderService.getGenders(vo));
        return result;
    }

    @ApiOperation(value = "不分页获取所有的性别编码信息")
    @GetMapping("/genders")
    @MyLog(title = "性别编码接口", action = "不分页获取所有的性别编码信息")
    public DataResult<List<Gender>> getGenders(){
        DataResult result = DataResult.success();
        result.setData(genderService.getGenders());
        return result;
    }

    @ApiOperation(value = "添加性别编码")
    @PostMapping("/gender")
    @MyLog(title = "性别编码接口", action = "添加性别编码")
    public DataResult addGender(@RequestBody @Valid Gender gender, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        genderService.addGender(gender, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "更新性别编码")
    @PutMapping("/gender")
    @MyLog(title = "性别编码接口", action = "更新性别编码")
    public DataResult updateGender(@RequestBody @Valid Gender gender, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        genderService.updateGender(gender, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "删除性别编码")
    @DeleteMapping("/gender")
    @MyLog(title = "性别编码接口", action = "删除性别编码")
    public DataResult deleteGender(@RequestBody Gender gender, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        genderService.deleteGender(gender, accessToken);
        DataResult result = DataResult.success();
        return result;
    }
}
