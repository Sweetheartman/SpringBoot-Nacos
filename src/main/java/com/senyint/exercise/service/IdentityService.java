package com.senyint.exercise.service;

import com.senyint.exercise.entity.Identity;
import com.senyint.exercise.vo.req.IdentityPageReqVO;
import com.senyint.exercise.vo.resp.PageVO;

import java.util.List;

/**
 * @program: springboot-demo
 * @description: 证件类型服务层接口
 * @author: lidekun
 * @create: 2020-10-01 08:31
 **/
public interface IdentityService {
    /**
     * 分页获取所有的证件类型
     * @param vo
     * @return
     */
    PageVO<Identity> getIdentities(IdentityPageReqVO vo);

    /**
     * 不分页获取所有证件类型信息
     * @return
     */
    List<Identity> getIdentities();

    /**
     * 添加证件类型
     * @param identity
     */
    void addIdentity(Identity identity, String accessToken);

    /**
     * 更新证件类型
     * @param identity
     * @param accessToken
     */
    void updateIdentity(Identity identity, String accessToken);

    /**
     * 删除证件类型
     * @param identity
     * @param accessToken
     */
    void deleteIdentity(Identity identity, String accessToken);

    /**
     * 根据证件类型获取证件信息
     * @param identityType
     * @return
     */
    Identity getIdentityByType(String identityType);
}
