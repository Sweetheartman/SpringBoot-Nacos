package com.senyint.exercise.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "IDENTITY")
public class Identity {
    @Id
    @Column(name = "IDENTITY_ID")
    private Integer identityId;

    /**
     * 证件类型
     */
    @Column(name = "IDENTITY_TYPE")
    private String identityType;

    /**
     * 证件名称
     */
    @Column(name = "IDENTITY_NAME")
    private String identityName;

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
     * @return IDENTITY_ID
     */
    public Integer getIdentityId() {
        return identityId;
    }

    /**
     * @param identityId
     */
    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }

    /**
     * 获取证件类型
     *
     * @return IDENTITY_TYPE - 证件类型
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * 设置证件类型
     *
     * @param identityType 证件类型
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * 获取证件名称
     *
     * @return IDENTITY_NAME - 证件名称
     */
    public String getIdentityName() {
        return identityName;
    }

    /**
     * 设置证件名称
     *
     * @param identityName 证件名称
     */
    public void setIdentityName(String identityName) {
        this.identityName = identityName == null ? null : identityName.trim();
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