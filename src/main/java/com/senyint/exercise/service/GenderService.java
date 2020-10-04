package com.senyint.exercise.service;

import com.senyint.exercise.entity.Gender;
import com.senyint.exercise.vo.req.GenderPageReqVO;
import com.senyint.exercise.vo.resp.PageVO;

import java.util.List;

/**
 * @program: springboot-demo
 * @description: 性别编码服务层接口
 * @author: lidekun
 * @create: 2020-09-30 11:10
 **/
public interface GenderService {
    /**
     * 分页获取所有的性别编码信息
     * @param vo
     * @return Gender列表
     */
    PageVO<Gender> getGenders(GenderPageReqVO vo);

    /**
     * 获取所有的性别编码信息
     * @return
     */
    List<Gender> getGenders();

    /**
     * 添加性别编码
     * @param gender
     */
    void addGender(Gender gender, String accessToken);

    /**
     * 更新性别编码
     * @param gender
     * @param accessToken
     */
    void updateGender(Gender gender, String accessToken);

    /**
     * 删除性别编码
     * @param gender
     * @param accessToken
     */
    void deleteGender(Gender gender, String accessToken);

    /**
     * 根据性别编码获取性别信息
     * @param genderCode
     * @return
     */
    Gender getGenderByCode(String genderCode);
}
