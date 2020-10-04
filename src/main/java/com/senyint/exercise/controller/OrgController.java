package com.senyint.exercise.controller;

import com.senyint.exercise.aop.annotation.MyLog;
import com.senyint.exercise.contants.Constant;
import com.senyint.exercise.entity.Org;
import com.senyint.exercise.service.OrgService;
import com.senyint.exercise.utils.DataResult;
import com.senyint.exercise.vo.req.OrgPageReqVO;
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
 * @description: 机构编码控制器
 * @author: lidekun
 * @create: 2020-09-30 19:14
 **/
@RestController
@RequestMapping("/api")
@Api(tags = "机构编码接口")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @ApiOperation(value = "分页获取所有机构编码")
    @GetMapping("/orgs/page")
    @MyLog(title = "机构编码接口", action = "分页获取所有机构编码")
    public DataResult<PageVO<Org>> getOrgsPage(@RequestParam(value = "page", required = false) Integer page,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                           @RequestParam(value = "orgName", required = false) String orgName){
        DataResult result = DataResult.success();
        OrgPageReqVO vo = new OrgPageReqVO();
        vo.setOrgName(orgName);
        vo.setPageSize(pageSize);
        vo.setPage(page);
        result.setData(orgService.getOrgs(vo));
        return result;
    }

    @ApiOperation(value = "不分页获取所有机构编码")
    @GetMapping("/orgs")
    @MyLog(title = "机构编码接口", action = "不分页获取所有机构编码")
    public DataResult<List<Org>> getOrgs(){
        DataResult result = DataResult.success();
        result.setData(orgService.getOrgs());
        return result;
    }

    @ApiOperation(value = "添加机构编码")
    @PostMapping("/org")
    @MyLog(title = "机构编码接口", action = "添加机构编码")
    public DataResult addOrg(@RequestBody @Valid Org org, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        orgService.addOrg(org, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "更新机构编码")
    @PutMapping("/org")
    @MyLog(title = "机构编码接口", action = "更新机构编码")
    public DataResult updateOrg(@RequestBody @Valid Org org, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        orgService.updateOrg(org, accessToken);
        DataResult result = DataResult.success();
        return result;
    }

    @ApiOperation(value = "删除机构编码")
    @DeleteMapping("/org")
    @MyLog(title = "机构编码接口", action = "删除机构编码")
    public DataResult deleteOrg(@RequestBody Org org, HttpServletRequest request){
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        orgService.deleteOrg(org, accessToken);
        DataResult result = DataResult.success();
        return result;
    }
}
