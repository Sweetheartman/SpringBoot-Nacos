package com.senyint.exercise.service;

import com.senyint.exercise.entity.Org;
import com.senyint.exercise.vo.req.OrgPageReqVO;
import com.senyint.exercise.vo.resp.PageVO;

import java.util.List;

/**
 * @program: springboot-demo
 * @description: 机构编码服务层接口
 * @author: lidekun
 * @create: 2020-09-30 18:39
 **/
public interface OrgService {
    /**
     * 分页获取所有的机构编码信息
     * @param vo
     * @return Orgs列表
     */
    PageVO<Org> getOrgs(OrgPageReqVO vo);

    /**
     * 不分页获取所有机构编码信息
     * @return
     */
    List<Org> getOrgs();
    /**
     * 添加机构编码
     * @param org
     */
    void addOrg(Org org, String accessToken);

    /**
     * 更新机构编码
     * @param org
     * @param accessToken
     */
    void updateOrg(Org org, String accessToken);

    /**
     * 删除机构编码
     * @param org
     * @param accessToken
     */
    void deleteOrg(Org org, String accessToken);

    /**
     * 根据机构编码查询机构信息
     * @param orgCode
     * @return
     */
    Org getOrgByCode(String orgCode);
}
