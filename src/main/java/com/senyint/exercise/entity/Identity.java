package com.senyint.exercise.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "IDENTITY")
public class Identity {
    @Id
    @Column(name = "IDENTITY_ID")
    private Integer identityId;

    /**
     * ֤������
     */
    @Column(name = "IDENTITY_TYPE")
    private String identityType;

    /**
     * ֤������
     */
    @Column(name = "IDENTITY_NAME")
    private String identityName;

    /**
     * ����ʱ��
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * ������
     */
    @Column(name = "CREATE_BY")
    private String createBy;

    /**
     * ���´���
     */
    @Column(name = "UPDATE_COUNT")
    private Integer updateCount;

    /**
     * ����ʱ��
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * ������
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;

    /**
     * ɾ����ʶ
     */
    @Column(name = "DELETE_FLAG")
    private String deleteFlag;

    /**
     * ɾ��ʱ��
     */
    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    /**
     * ɾ����
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
     * ��ȡ֤������
     *
     * @return IDENTITY_TYPE - ֤������
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * ����֤������
     *
     * @param identityType ֤������
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * ��ȡ֤������
     *
     * @return IDENTITY_NAME - ֤������
     */
    public String getIdentityName() {
        return identityName;
    }

    /**
     * ����֤������
     *
     * @param identityName ֤������
     */
    public void setIdentityName(String identityName) {
        this.identityName = identityName == null ? null : identityName.trim();
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return CREATE_TIME - ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��ȡ������
     *
     * @return CREATE_BY - ������
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * ���ô�����
     *
     * @param createBy ������
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * ��ȡ���´���
     *
     * @return UPDATE_COUNT - ���´���
     */
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     * ���ø��´���
     *
     * @param updateCount ���´���
     */
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return UPDATE_TIME - ����ʱ��
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * ���ø���ʱ��
     *
     * @param updateTime ����ʱ��
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * ��ȡ������
     *
     * @return UPDATE_BY - ������
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * ���ø�����
     *
     * @param updateBy ������
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * ��ȡɾ����ʶ
     *
     * @return DELETE_FLAG - ɾ����ʶ
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * ����ɾ����ʶ
     *
     * @param deleteFlag ɾ����ʶ
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * ��ȡɾ��ʱ��
     *
     * @return DELETE_TIME - ɾ��ʱ��
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * ����ɾ��ʱ��
     *
     * @param deleteTime ɾ��ʱ��
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * ��ȡɾ����
     *
     * @return DELETE_BY - ɾ����
     */
    public String getDeleteBy() {
        return deleteBy;
    }

    /**
     * ����ɾ����
     *
     * @param deleteBy ɾ����
     */
    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy == null ? null : deleteBy.trim();
    }
}