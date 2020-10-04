package com.senyint.exercise.controller;

import com.senyint.exercise.aop.annotation.MyLog;
import com.senyint.exercise.contants.Constant;
import com.senyint.exercise.entity.Identity;
import com.senyint.exercise.service.IdentityService;
import com.senyint.exercise.utils.DataResult;
import com.senyint.exercise.vo.req.IdentityPageReqVO;
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
 * @description: 证件类型控制器
 * @author: lidekun
 * @create: 2020-10-01 09:04
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "证件类型编码接口")
public class IdentityController {

    @Autowired
    private IdentityService identityService;

    @ApiOperation(value = "分页获取所有证件类型编码")
    @GetMapping("/identities/page")
    @MyLog(title = "证件类型编码接口", action = "分页获取所有证件类型编码")
    public DataResult<PageVO<Identity>> getIdentitiesPage(@RequestParam(value = "page") Integer page,
                                                @RequestParam(value = "pageSize") Integer pageSize,
                                                @RequestParam(value="identityName") String identityName){
        DataResult result = DataResult.success();
        IdentityPageReqVO vo = new IdentityPageReqVO();
        vo.setIdentityName(identityName);
        vo.setPageSize(pageSize);
        vo.setPage(page);
        result.setData(identityService.getIdentities(vo));
        return result;
    }

    @ApiOperation(value = "不分页获取所有证件类型")
    @GetMapping("/identities")
    @MyLog(title = "证件类型编码接口", action = "不分页获取所有证件类型")
    public DataResult<List<Identity>> getIdentities(){
        DataResult result = DataResult.success();
        result.setData(identityService.getIdentities());
        return result;
    }

    @ApiOperation(value = "添加证件类型编码")
    @PostMapping("/identity")
    @MyLog(title = "证件类型编码接口", action = "添加证件类型编码")
    public DataResult addIdentity(@RequestBody @Valid Identity identity, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        identityService.addIdentity(identity, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "更新证件类型编码")
    @PutMapping("/identity")
    @MyLog(title = "证件类型编码接口", action = "更新证件类型编码")
    public DataResult updateIdentity(@RequestBody @Valid Identity identity, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        identityService.updateIdentity(identity, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "删除证件类型编码")
    @DeleteMapping("/identity")
    @MyLog(title = "证件类型编码接口", action = "删除证件类型编码")
    public DataResult deleteIdentity(@RequestBody Identity identity, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        identityService.deleteIdentity(identity, accessToken);
        DataResult result = DataResult.success();
        return result;
    }
}
