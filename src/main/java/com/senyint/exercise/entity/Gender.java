package com.senyint.exercise.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "GENDER")
public class Gender {
    @Id
    @Column(name = "GENDER_ID")
    private Integer genderId;

    /**
     * 性别编码
     */
    @Column(name = "GENDER_CODE")
    private String genderCode;

    /**
     * 性别名称
     */
    @Column(name = "GENDER_NAME")
    @NotBlank(message = "性别名称不能为空")
    @ApiModelProperty(value = "性别名称--必填")
    private String genderName;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建者
     */
    @Column(name = "CREATE_BY")
    private String createBy;

    /**
     * 更新次数
     */
    @Column(name = "UPDATE_COUNT")
    private Integer updateCount;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 更新者
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;

    /**
     * 删除标识
     */
    @Column(name = "DELETE_FLAG")
    private String deleteFlag;

    /**
     * 删除时间
     */
    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    /**
     * 删除者
     */
    @Column(name = "DELETE_BY")
    private String deleteBy;

    /**
     * @return GENDER_ID
     */
    public Integer getGenderId() {
        return genderId;
    }

    /**
     * @param genderId
     */
    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    /**
     * 获取性别编码
     *
     * @return GENDER_CODE - 性别编码
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * 设置性别编码
     *
     * @param genderCode 性别编码
     */
    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode == null ? null : genderCode.trim();
    }

    /**
     * 获取性别名称
     *
     * @return GENDER_NAME - 性别名称
     */
    public String getGenderName() {
        return genderName;
    }

    /**
     * 设置性别名称
     *
     * @param genderName 性别名称
     */
    public void setGenderName(String genderName) {
        this.genderName = genderName == null ? null : genderName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建者
     *
     * @return CREATE_BY - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取更新次数
     *
     * @return UPDATE_COUNT - 更新次数
     */
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     * 设置更新次数
     *
     * @param updateCount 更新次数
     */
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新者
     *
     * @return UPDATE_BY - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取删除标识
     *
     * @return DELETE_FLAG - 删除标识
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标识
     *
     * @param deleteFlag 删除标识
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * 获取删除时间
     *
     * @return DELETE_TIME - 删除时间
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * 设置删除时间
     *
     * @param deleteTime 删除时间
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * 获取删除者
     *
     * @return DELETE_BY - 删除者
     */
    public String getDeleteBy() {
        return deleteBy;
    }

    /**
     * 设置删除者
     *
     * @param deleteBy 删除者
     */
    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy == null ? null : deleteBy.trim();
    }
}