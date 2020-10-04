package com.senyint.exercise.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "EMPI_PATIENT")
public class EmpiPatient {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "EMPI_ID")
    private String empiId;

    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "机构编码--必填")
    @NotBlank(message = "机构编码不能为空")
    private String orgCode;

    @Column(name = "ORG_NAME")
    private String orgName;

    @Column(name = "DOMAIN_ID")
    private String domainId;

    @Column(name = "LOCAL_ID")
    private String localId;

    @Column(name = "OUTPATIENT_NO")
    private String outpatientNo;

    @Column(name = "INPATIENT_NO")
    private String inpatientNo;

    @Column(name = "PATIENT_NAME")
    @ApiModelProperty(value = "患者姓名--必填")
    @NotBlank(message = "患者姓名不能为空")
    private String patientName;

    @Column(name = "PY_CODE")
    private String pyCode;

    @Column(name = "GENDER_CODE")
    @ApiModelProperty(value = "性别编码--必填")
    @NotBlank(message = "性别编码不能为空")
    private String genderCode;

    @Column(name = "GENDER_NAME")
    private String genderName;

    @Column(name = "BIRTH_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "SOCIAL_NO")
    private String socialNo;

    @Column(name = "TELECOM")
    private String telecom;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IDENTITY_TYPE")
    @ApiModelProperty(value = "证件编码--必填")
    @NotBlank(message = "证件编码不能为空")
    private String identityType;

    @Column(name = "IDENTITY_NAME")
    private String identityName;

    @Column(name = "IDENTITY_NO")
    @ApiModelProperty(value = "身份证号--必填")
    @NotBlank(message = "身份证号不能为空")
    private String identityNo;

    @Column(name = "MARITAL_STATUS_CODE")
    private String maritalStatusCode;

    @Column(name = "MARITAL_STATUS_NAME")
    private String maritalStatusName;

    @Column(name = "EDUCATION_LEVEL_CODE")
    private String educationLevelCode;

    @Column(name = "EDUCATION_LEVEL_NAME")
    private String educationLevelName;

    @Column(name = "NATIONALITY_CODE")
    private String nationalityCode;

    @Column(name = "NATIONALITY_NAME")
    private String nationalityName;

    @Column(name = "NATION_CODE")
    private String nationCode;

    @Column(name = "NATION_NAME")
    private String nationName;

    @Column(name = "OCCUPATION_CODE")
    private String occupationCode;

    @Column(name = "OCCUPATION_NAME")
    private String occupationName;

    @Column(name = "WORK_UNIT")
    private String workUnit;

    @Column(name = "WORK_TEL")
    private String workTel;

    @Column(name = "ABO_CODE")
    private String aboCode;

    @Column(name = "ABO_NAME")
    private String aboName;

    @Column(name = "RH_CODE")
    private String rhCode;

    @Column(name = "RH_NAME")
    private String rhName;

    @Column(name = "HOME_FULL_ADDRESS")
    private String homeFullAddress;

    @Column(name = "HOME_ADDR_PROVINCE")
    private String homeAddrProvince;

    @Column(name = "HOME_ADDR_CITY")
    private String homeAddrCity;

    @Column(name = "HOME_ADDR_COUNTY")
    private String homeAddrCounty;

    @Column(name = "HOME_ADDR_TOWN")
    private String homeAddrTown;

    @Column(name = "HOME_ADDR_VILLAGE")
    private String homeAddrVillage;

    @Column(name = "HOME_ADDR_HOUSE_NO")
    private String homeAddrHouseNo;

    @Column(name = "HOME_ZIP_CODE")
    private String homeZipCode;

    @Column(name = "PRESENT_FULL_ADDRESS")
    private String presentFullAddress;

    @Column(name = "PRESENT_ADDR_PROVINCE")
    private String presentAddrProvince;

    @Column(name = "PRESENT_ADDR_CITY")
    private String presentAddrCity;

    @Column(name = "PRESENT_ADDR_COUNTY")
    private String presentAddrCounty;

    @Column(name = "PRESENT_ADDR_TOWN")
    private String presentAddrTown;

    @Column(name = "PRESENT_ADDR_VILLAGE")
    private String presentAddrVillage;

    @Column(name = "PRESENT_ADDR_HOUSE_NO")
    private String presentAddrHouseNo;

    @Column(name = "PRESENT_ZIP_CODE")
    private String presentZipCode;

    @Column(name = "RESIDENCE_FULL_ADDRESS")
    private String residenceFullAddress;

    @Column(name = "RESIDENCE_ADDR_PROVINCE")
    private String residenceAddrProvince;

    @Column(name = "RESIDENCE_ADDR_CITY")
    private String residenceAddrCity;

    @Column(name = "RESIDENCE_ADDR_COUNTY")
    private String residenceAddrCounty;

    @Column(name = "RESIDENCE_ADDR_TOWN")
    private String residenceAddrTown;

    @Column(name = "RESIDENCE_ADDR_VILLAGE")
    private String residenceAddrVillage;

    @Column(name = "RESIDENCE_ADDR_HOUSE_NO")
    private String residenceAddrHouseNo;

    @Column(name = "RESIDENCE_ZIP_CODE")
    private String residenceZipCode;

    @Column(name = "CONTACT_RELATIONSHIP_CODE")
    private String contactRelationshipCode;

    @Column(name = "CONTACT_RELATIONSHIP_NAME")
    private String contactRelationshipName;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "CONTACT_TELECOM")
    private String contactTelecom;

    @Column(name = "CONTACT_FULL_ADDRESS")
    private String contactFullAddress;

    @Column(name = "CONTACT_ADDR_PROVINCE")
    private String contactAddrProvince;

    @Column(name = "CONTACT_ADDR_CITY")
    private String contactAddrCity;

    @Column(name = "CONTACT_ADDR_COUNTY")
    private String contactAddrCounty;

    @Column(name = "CONTACT_ADDR_TOWN")
    private String contactAddrTown;

    @Column(name = "CONTACT_ADDR_VILLAGE")
    private String contactAddrVillage;

    @Column(name = "CONTACT_ADDR_HOUSE_NO")
    private String contactAddrHouseNo;

    @Column(name = "CONTACT_ZIP_CODE")
    private String contactZipCode;

    @Column(name = "MEDICAL_CARD_NO")
    private String medicalCardNo;

    @Column(name = "INSURANCE_NO")
    private String insuranceNo;

    @Column(name = "INSURANCE_TYPE_CODE")
    private String insuranceTypeCode;

    @Column(name = "INSURANCE_TYPE_NAME")
    private String insuranceTypeName;

    @Column(name = "HEALTH_CARD_NO")
    private String healthCardNo;

    @Column(name = "HEALTH_CARD_ORG_CODE")
    private String healthCardOrgCode;

    @Column(name = "HEALTH_CARD_ORG_NAME")
    private String healthCardOrgName;

    @Column(name = "HEALTH_RECORD_NO")
    private String healthRecordNo;

    @Column(name = "HEALTH_RECORD_ORG_CODE")
    private String healthRecordOrgCode;

    @Column(name = "HEALTH_RECORD_ORG_NAME")
    private String healthRecordOrgName;

    @Column(name = "REGISTRANT_CODE")
    private String registrantCode;

    @Column(name = "REGISTRANT_NAME")
    private String registrantName;

    @Column(name = "REGIST_DATETIME")
    private Date registDatetime;

    @Column(name = "DATA_FLAG")
    private Integer dataFlag;

    @Column(name = "DATA_QUALITY")
    private Integer dataQuality;

    @Column(name = "RECORD_SCORE")
    private Integer recordScore;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "UPDATE_COUNT")
    private Integer updateCount;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "DELETE_FLAG")
    private String deleteFlag;

    @Column(name = "DELETE_TIME")
    private Date deleteTime;

    @Column(name = "DELETE_BY")
    private String deleteBy;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return EMPI_ID
     */
    public String getEmpiId() {
        return empiId;
    }

    /**
     * @param empiId
     */
    public void setEmpiId(String empiId) {
        this.empiId = empiId == null ? null : empiId.trim();
    }

    /**
     * @return ORG_CODE
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * @return ORG_NAME
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * @return DOMAIN_ID
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * @param domainId
     */
    public void setDomainId(String domainId) {
        this.domainId = domainId == null ? null : domainId.trim();
    }

    /**
     * @return LOCAL_ID
     */
    public String getLocalId() {
        return localId;
    }

    /**
     * @param localId
     */
    public void setLocalId(String localId) {
        this.localId = localId == null ? null : localId.trim();
    }

    /**
     * @return OUTPATIENT_NO
     */
    public String getOutpatientNo() {
        return outpatientNo;
    }

    /**
     * @param outpatientNo
     */
    public void setOutpatientNo(String outpatientNo) {
        this.outpatientNo = outpatientNo == null ? null : outpatientNo.trim();
    }

    /**
     * @return INPATIENT_NO
     */
    public String getInpatientNo() {
        return inpatientNo;
    }

    /**
     * @param inpatientNo
     */
    public void setInpatientNo(String inpatientNo) {
        this.inpatientNo = inpatientNo == null ? null : inpatientNo.trim();
    }

    /**
     * @return PATIENT_NAME
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    /**
     * @return PY_CODE
     */
    public String getPyCode() {
        return pyCode;
    }

    /**
     * @param pyCode
     */
    public void setPyCode(String pyCode) {
        this.pyCode = pyCode == null ? null : pyCode.trim();
    }

    /**
     * @return GENDER_CODE
     */
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * @param genderCode
     */
    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode == null ? null : genderCode.trim();
    }

    /**
     * @return GENDER_NAME
     */
    public String getGenderName() {
        return genderName;
    }

    /**
     * @param genderName
     */
    public void setGenderName(String genderName) {
        this.genderName = genderName == null ? null : genderName.trim();
    }

    /**
     * @return BIRTH_DATE
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return SOCIAL_NO
     */
    public String getSocialNo() {
        return socialNo;
    }

    /**
     * @param socialNo
     */
    public void setSocialNo(String socialNo) {
        this.socialNo = socialNo == null ? null : socialNo.trim();
    }

    /**
     * @return TELECOM
     */
    public String getTelecom() {
        return telecom;
    }

    /**
     * @param telecom
     */
    public void setTelecom(String telecom) {
        this.telecom = telecom == null ? null : telecom.trim();
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return IDENTITY_TYPE
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * @param identityType
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * @return IDENTITY_NAME
     */
    public String getIdentityName() {
        return identityName;
    }

    /**
     * @param identityName
     */
    public void setIdentityName(String identityName) {
        this.identityName = identityName == null ? null : identityName.trim();
    }

    /**
     * @return IDENTITY_NO
     */
    public String getIdentityNo() {
        return identityNo;
    }

    /**
     * @param identityNo
     */
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    /**
     * @return MARITAL_STATUS_CODE
     */
    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    /**
     * @param maritalStatusCode
     */
    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode == null ? null : maritalStatusCode.trim();
    }

    /**
     * @return MARITAL_STATUS_NAME
     */
    public String getMaritalStatusName() {
        return maritalStatusName;
    }

    /**
     * @param maritalStatusName
     */
    public void setMaritalStatusName(String maritalStatusName) {
        this.maritalStatusName = maritalStatusName == null ? null : maritalStatusName.trim();
    }

    /**
     * @return EDUCATION_LEVEL_CODE
     */
    public String getEducationLevelCode() {
        return educationLevelCode;
    }

    /**
     * @param educationLevelCode
     */
    public void setEducationLevelCode(String educationLevelCode) {
        this.educationLevelCode = educationLevelCode == null ? null : educationLevelCode.trim();
    }

    /**
     * @return EDUCATION_LEVEL_NAME
     */
    public String getEducationLevelName() {
        return educationLevelName;
    }

    /**
     * @param educationLevelName
     */
    public void setEducationLevelName(String educationLevelName) {
        this.educationLevelName = educationLevelName == null ? null : educationLevelName.trim();
    }

    /**
     * @return NATIONALITY_CODE
     */
    public String getNationalityCode() {
        return nationalityCode;
    }

    /**
     * @param nationalityCode
     */
    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode == null ? null : nationalityCode.trim();
    }

    /**
     * @return NATIONALITY_NAME
     */
    public String getNationalityName() {
        return nationalityName;
    }

    /**
     * @param nationalityName
     */
    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName == null ? null : nationalityName.trim();
    }

    /**
     * @return NATION_CODE
     */
    public String getNationCode() {
        return nationCode;
    }

    /**
     * @param nationCode
     */
    public void setNationCode(String nationCode) {
        this.nationCode = nationCode == null ? null : nationCode.trim();
    }

    /**
     * @return NATION_NAME
     */
    public String getNationName() {
        return nationName;
    }

    /**
     * @param nationName
     */
    public void setNationName(String nationName) {
        this.nationName = nationName == null ? null : nationName.trim();
    }

    /**
     * @return OCCUPATION_CODE
     */
    public String getOccupationCode() {
        return occupationCode;
    }

    /**
     * @param occupationCode
     */
    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode == null ? null : occupationCode.trim();
    }

    /**
     * @return OCCUPATION_NAME
     */
    public String getOccupationName() {
        return occupationName;
    }

    /**
     * @param occupationName
     */
    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName == null ? null : occupationName.trim();
    }

    /**
     * @return WORK_UNIT
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * @param workUnit
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    /**
     * @return WORK_TEL
     */
    public String getWorkTel() {
        return workTel;
    }

    /**
     * @param workTel
     */
    public void setWorkTel(String workTel) {
        this.workTel = workTel == null ? null : workTel.trim();
    }

    /**
     * @return ABO_CODE
     */
    public String getAboCode() {
        return aboCode;
    }

    /**
     * @param aboCode
     */
    public void setAboCode(String aboCode) {
        this.aboCode = aboCode == null ? null : aboCode.trim();
    }

    /**
     * @return ABO_NAME
     */
    public String getAboName() {
        return aboName;
    }

    /**
     * @param aboName
     */
    public void setAboName(String aboName) {
        this.aboName = aboName == null ? null : aboName.trim();
    }

    /**
     * @return RH_CODE
     */
    public String getRhCode() {
        return rhCode;
    }

    /**
     * @param rhCode
     */
    public void setRhCode(String rhCode) {
        this.rhCode = rhCode == null ? null : rhCode.trim();
    }

    /**
     * @return RH_NAME
     */
    public String getRhName() {
        return rhName;
    }

    /**
     * @param rhName
     */
    public void setRhName(String rhName) {
        this.rhName = rhName == null ? null : rhName.trim();
    }

    /**
     * @return HOME_FULL_ADDRESS
     */
    public String getHomeFullAddress() {
        return homeFullAddress;
    }

    /**
     * @param homeFullAddress
     */
    public void setHomeFullAddress(String homeFullAddress) {
        this.homeFullAddress = homeFullAddress == null ? null : homeFullAddress.trim();
    }

    /**
     * @return HOME_ADDR_PROVINCE
     */
    public String getHomeAddrProvince() {
        return homeAddrProvince;
    }

    /**
     * @param homeAddrProvince
     */
    public void setHomeAddrProvince(String homeAddrProvince) {
        this.homeAddrProvince = homeAddrProvince == null ? null : homeAddrProvince.trim();
    }

    /**
     * @return HOME_ADDR_CITY
     */
    public String getHomeAddrCity() {
        return homeAddrCity;
    }

    /**
     * @param homeAddrCity
     */
    public void setHomeAddrCity(String homeAddrCity) {
        this.homeAddrCity = homeAddrCity == null ? null : homeAddrCity.trim();
    }

    /**
     * @return HOME_ADDR_COUNTY
     */
    public String getHomeAddrCounty() {
        return homeAddrCounty;
    }

    /**
     * @param homeAddrCounty
     */
    public void setHomeAddrCounty(String homeAddrCounty) {
        this.homeAddrCounty = homeAddrCounty == null ? null : homeAddrCounty.trim();
    }

    /**
     * @return HOME_ADDR_TOWN
     */
    public String getHomeAddrTown() {
        return homeAddrTown;
    }

    /**
     * @param homeAddrTown
     */
    public void setHomeAddrTown(String homeAddrTown) {
        this.homeAddrTown = homeAddrTown == null ? null : homeAddrTown.trim();
    }

    /**
     * @return HOME_ADDR_VILLAGE
     */
    public String getHomeAddrVillage() {
        return homeAddrVillage;
    }

    /**
     * @param homeAddrVillage
     */
    public void setHomeAddrVillage(String homeAddrVillage) {
        this.homeAddrVillage = homeAddrVillage == null ? null : homeAddrVillage.trim();
    }

    /**
     * @return HOME_ADDR_HOUSE_NO
     */
    public String getHomeAddrHouseNo() {
        return homeAddrHouseNo;
    }

    /**
     * @param homeAddrHouseNo
     */
    public void setHomeAddrHouseNo(String homeAddrHouseNo) {
        this.homeAddrHouseNo = homeAddrHouseNo == null ? null : homeAddrHouseNo.trim();
    }

    /**
     * @return HOME_ZIP_CODE
     */
    public String getHomeZipCode() {
        return homeZipCode;
    }

    /**
     * @param homeZipCode
     */
    public void setHomeZipCode(String homeZipCode) {
        this.homeZipCode = homeZipCode == null ? null : homeZipCode.trim();
    }

    /**
     * @return PRESENT_FULL_ADDRESS
     */
    public String getPresentFullAddress() {
        return presentFullAddress;
    }

    /**
     * @param presentFullAddress
     */
    public void setPresentFullAddress(String presentFullAddress) {
        this.presentFullAddress = presentFullAddress == null ? null : presentFullAddress.trim();
    }

    /**
     * @return PRESENT_ADDR_PROVINCE
     */
    public String getPresentAddrProvince() {
        return presentAddrProvince;
    }

    /**
     * @param presentAddrProvince
     */
    public void setPresentAddrProvince(String presentAddrProvince) {
        this.presentAddrProvince = presentAddrProvince == null ? null : presentAddrProvince.trim();
    }

    /**
     * @return PRESENT_ADDR_CITY
     */
    public String getPresentAddrCity() {
        return presentAddrCity;
    }

    /**
     * @param presentAddrCity
     */
    public void setPresentAddrCity(String presentAddrCity) {
        this.presentAddrCity = presentAddrCity == null ? null : presentAddrCity.trim();
    }

    /**
     * @return PRESENT_ADDR_COUNTY
     */
    public String getPresentAddrCounty() {
        return presentAddrCounty;
    }

    /**
     * @param presentAddrCounty
     */
    public void setPresentAddrCounty(String presentAddrCounty) {
        this.presentAddrCounty = presentAddrCounty == null ? null : presentAddrCounty.trim();
    }

    /**
     * @return PRESENT_ADDR_TOWN
     */
    public String getPresentAddrTown() {
        return presentAddrTown;
    }

    /**
     * @param presentAddrTown
     */
    public void setPresentAddrTown(String presentAddrTown) {
        this.presentAddrTown = presentAddrTown == null ? null : presentAddrTown.trim();
    }

    /**
     * @return PRESENT_ADDR_VILLAGE
     */
    public String getPresentAddrVillage() {
        return presentAddrVillage;
    }

    /**
     * @param presentAddrVillage
     */
    public void setPresentAddrVillage(String presentAddrVillage) {
        this.presentAddrVillage = presentAddrVillage == null ? null : presentAddrVillage.trim();
    }

    /**
     * @return PRESENT_ADDR_HOUSE_NO
     */
    public String getPresentAddrHouseNo() {
        return presentAddrHouseNo;
    }

    /**
     * @param presentAddrHouseNo
     */
    public void setPresentAddrHouseNo(String presentAddrHouseNo) {
        this.presentAddrHouseNo = presentAddrHouseNo == null ? null : presentAddrHouseNo.trim();
    }

    /**
     * @return PRESENT_ZIP_CODE
     */
    public String getPresentZipCode() {
        return presentZipCode;
    }

    /**
     * @param presentZipCode
     */
    public void setPresentZipCode(String presentZipCode) {
        this.presentZipCode = presentZipCode == null ? null : presentZipCode.trim();
    }

    /**
     * @return RESIDENCE_FULL_ADDRESS
     */
    public String getResidenceFullAddress() {
        return residenceFullAddress;
    }

    /**
     * @param residenceFullAddress
     */
    public void setResidenceFullAddress(String residenceFullAddress) {
        this.residenceFullAddress = residenceFullAddress == null ? null : residenceFullAddress.trim();
    }

    /**
     * @return RESIDENCE_ADDR_PROVINCE
     */
    public String getResidenceAddrProvince() {
        return residenceAddrProvince;
    }

    /**
     * @param residenceAddrProvince
     */
    public void setResidenceAddrProvince(String residenceAddrProvince) {
        this.residenceAddrProvince = residenceAddrProvince == null ? null : residenceAddrProvince.trim();
    }

    /**
     * @return RESIDENCE_ADDR_CITY
     */
    public String getResidenceAddrCity() {
        return residenceAddrCity;
    }

    /**
     * @param residenceAddrCity
     */
    public void setResidenceAddrCity(String residenceAddrCity) {
        this.residenceAddrCity = residenceAddrCity == null ? null : residenceAddrCity.trim();
    }

    /**
     * @return RESIDENCE_ADDR_COUNTY
     */
    public String getResidenceAddrCounty() {
        return residenceAddrCounty;
    }

    /**
     * @param residenceAddrCounty
     */
    public void setResidenceAddrCounty(String residenceAddrCounty) {
        this.residenceAddrCounty = residenceAddrCounty == null ? null : residenceAddrCounty.trim();
    }

    /**
     * @return RESIDENCE_ADDR_TOWN
     */
    public String getResidenceAddrTown() {
        return residenceAddrTown;
    }

    /**
     * @param residenceAddrTown
     */
    public void setResidenceAddrTown(String residenceAddrTown) {
        this.residenceAddrTown = residenceAddrTown == null ? null : residenceAddrTown.trim();
    }

    /**
     * @return RESIDENCE_ADDR_VILLAGE
     */
    public String getResidenceAddrVillage() {
        return residenceAddrVillage;
    }

    /**
     * @param residenceAddrVillage
     */
    public void setResidenceAddrVillage(String residenceAddrVillage) {
        this.residenceAddrVillage = residenceAddrVillage == null ? null : residenceAddrVillage.trim();
    }

    /**
     * @return RESIDENCE_ADDR_HOUSE_NO
     */
    public String getResidenceAddrHouseNo() {
        return residenceAddrHouseNo;
    }

    /**
     * @param residenceAddrHouseNo
     */
    public void setResidenceAddrHouseNo(String residenceAddrHouseNo) {
        this.residenceAddrHouseNo = residenceAddrHouseNo == null ? null : residenceAddrHouseNo.trim();
    }

    /**
     * @return RESIDENCE_ZIP_CODE
     */
    public String getResidenceZipCode() {
        return residenceZipCode;
    }

    /**
     * @param residenceZipCode
     */
    public void setResidenceZipCode(String residenceZipCode) {
        this.residenceZipCode = residenceZipCode == null ? null : residenceZipCode.trim();
    }

    /**
     * @return CONTACT_RELATIONSHIP_CODE
     */
    public String getContactRelationshipCode() {
        return contactRelationshipCode;
    }

    /**
     * @param contactRelationshipCode
     */
    public void setContactRelationshipCode(String contactRelationshipCode) {
        this.contactRelationshipCode = contactRelationshipCode == null ? null : contactRelationshipCode.trim();
    }

    /**
     * @return CONTACT_RELATIONSHIP_NAME
     */
    public String getContactRelationshipName() {
        return contactRelationshipName;
    }

    /**
     * @param contactRelationshipName
     */
    public void setContactRelationshipName(String contactRelationshipName) {
        this.contactRelationshipName = contactRelationshipName == null ? null : contactRelationshipName.trim();
    }

    /**
     * @return CONTACT_NAME
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * @return CONTACT_TELECOM
     */
    public String getContactTelecom() {
        return contactTelecom;
    }

    /**
     * @param contactTelecom
     */
    public void setContactTelecom(String contactTelecom) {
        this.contactTelecom = contactTelecom == null ? null : contactTelecom.trim();
    }

    /**
     * @return CONTACT_FULL_ADDRESS
     */
    public String getContactFullAddress() {
        return contactFullAddress;
    }

    /**
     * @param contactFullAddress
     */
    public void setContactFullAddress(String contactFullAddress) {
        this.contactFullAddress = contactFullAddress == null ? null : contactFullAddress.trim();
    }

    /**
     * @return CONTACT_ADDR_PROVINCE
     */
    public String getContactAddrProvince() {
        return contactAddrProvince;
    }

    /**
     * @param contactAddrProvince
     */
    public void setContactAddrProvince(String contactAddrProvince) {
        this.contactAddrProvince = contactAddrProvince == null ? null : contactAddrProvince.trim();
    }

    /**
     * @return CONTACT_ADDR_CITY
     */
    public String getContactAddrCity() {
        return contactAddrCity;
    }

    /**
     * @param contactAddrCity
     */
    public void setContactAddrCity(String contactAddrCity) {
        this.contactAddrCity = contactAddrCity == null ? null : contactAddrCity.trim();
    }

    /**
     * @return CONTACT_ADDR_COUNTY
     */
    public String getContactAddrCounty() {
        return contactAddrCounty;
    }

    /**
     * @param contactAddrCounty
     */
    public void setContactAddrCounty(String contactAddrCounty) {
        this.contactAddrCounty = contactAddrCounty == null ? null : contactAddrCounty.trim();
    }

    /**
     * @return CONTACT_ADDR_TOWN
     */
    public String getContactAddrTown() {
        return contactAddrTown;
    }

    /**
     * @param contactAddrTown
     */
    public void setContactAddrTown(String contactAddrTown) {
        this.contactAddrTown = contactAddrTown == null ? null : contactAddrTown.trim();
    }

    /**
     * @return CONTACT_ADDR_VILLAGE
     */
    public String getContactAddrVillage() {
        return contactAddrVillage;
    }

    /**
     * @param contactAddrVillage
     */
    public void setContactAddrVillage(String contactAddrVillage) {
        this.contactAddrVillage = contactAddrVillage == null ? null : contactAddrVillage.trim();
    }

    /**
     * @return CONTACT_ADDR_HOUSE_NO
     */
    public String getContactAddrHouseNo() {
        return contactAddrHouseNo;
    }

    /**
     * @param contactAddrHouseNo
     */
    public void setContactAddrHouseNo(String contactAddrHouseNo) {
        this.contactAddrHouseNo = contactAddrHouseNo == null ? null : contactAddrHouseNo.trim();
    }

    /**
     * @return CONTACT_ZIP_CODE
     */
    public String getContactZipCode() {
        return contactZipCode;
    }

    /**
     * @param contactZipCode
     */
    public void setContactZipCode(String contactZipCode) {
        this.contactZipCode = contactZipCode == null ? null : contactZipCode.trim();
    }

    /**
     * @return MEDICAL_CARD_NO
     */
    public String getMedicalCardNo() {
        return medicalCardNo;
    }

    /**
     * @param medicalCardNo
     */
    public void setMedicalCardNo(String medicalCardNo) {
        this.medicalCardNo = medicalCardNo == null ? null : medicalCardNo.trim();
    }

    /**
     * @return INSURANCE_NO
     */
    public String getInsuranceNo() {
        return insuranceNo;
    }

    /**
     * @param insuranceNo
     */
    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }

    /**
     * @return INSURANCE_TYPE_CODE
     */
    public String getInsuranceTypeCode() {
        return insuranceTypeCode;
    }

    /**
     * @param insuranceTypeCode
     */
    public void setInsuranceTypeCode(String insuranceTypeCode) {
        this.insuranceTypeCode = insuranceTypeCode == null ? null : insuranceTypeCode.trim();
    }

    /**
     * @return INSURANCE_TYPE_NAME
     */
    public String getInsuranceTypeName() {
        return insuranceTypeName;
    }

    /**
     * @param insuranceTypeName
     */
    public void setInsuranceTypeName(String insuranceTypeName) {
        this.insuranceTypeName = insuranceTypeName == null ? null : insuranceTypeName.trim();
    }

    /**
     * @return HEALTH_CARD_NO
     */
    public String getHealthCardNo() {
        return healthCardNo;
    }

    /**
     * @param healthCardNo
     */
    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo == null ? null : healthCardNo.trim();
    }

    /**
     * @return HEALTH_CARD_ORG_CODE
     */
    public String getHealthCardOrgCode() {
        return healthCardOrgCode;
    }

    /**
     * @param healthCardOrgCode
     */
    public void setHealthCardOrgCode(String healthCardOrgCode) {
        this.healthCardOrgCode = healthCardOrgCode == null ? null : healthCardOrgCode.trim();
    }

    /**
     * @return HEALTH_CARD_ORG_NAME
     */
    public String getHealthCardOrgName() {
        return healthCardOrgName;
    }

    /**
     * @param healthCardOrgName
     */
    public void setHealthCardOrgName(String healthCardOrgName) {
        this.healthCardOrgName = healthCardOrgName == null ? null : healthCardOrgName.trim();
    }

    /**
     * @return HEALTH_RECORD_NO
     */
    public String getHealthRecordNo() {
        return healthRecordNo;
    }

    /**
     * @param healthRecordNo
     */
    public void setHealthRecordNo(String healthRecordNo) {
        this.healthRecordNo = healthRecordNo == null ? null : healthRecordNo.trim();
    }

    /**
     * @return HEALTH_RECORD_ORG_CODE
     */
    public String getHealthRecordOrgCode() {
        return healthRecordOrgCode;
    }

    /**
     * @param healthRecordOrgCode
     */
    public void setHealthRecordOrgCode(String healthRecordOrgCode) {
        this.healthRecordOrgCode = healthRecordOrgCode == null ? null : healthRecordOrgCode.trim();
    }

    /**
     * @return HEALTH_RECORD_ORG_NAME
     */
    public String getHealthRecordOrgName() {
        return healthRecordOrgName;
    }

    /**
     * @param healthRecordOrgName
     */
    public void setHealthRecordOrgName(String healthRecordOrgName) {
        this.healthRecordOrgName = healthRecordOrgName == null ? null : healthRecordOrgName.trim();
    }

    /**
     * @return REGISTRANT_CODE
     */
    public String getRegistrantCode() {
        return registrantCode;
    }

    /**
     * @param registrantCode
     */
    public void setRegistrantCode(String registrantCode) {
        this.registrantCode = registrantCode == null ? null : registrantCode.trim();
    }

    /**
     * @return REGISTRANT_NAME
     */
    public String getRegistrantName() {
        return registrantName;
    }

    /**
     * @param registrantName
     */
    public void setRegistrantName(String registrantName) {
        this.registrantName = registrantName == null ? null : registrantName.trim();
    }

    /**
     * @return REGIST_DATETIME
     */
    public Date getRegistDatetime() {
        return registDatetime;
    }

    /**
     * @param registDatetime
     */
    public void setRegistDatetime(Date registDatetime) {
        this.registDatetime = registDatetime;
    }

    /**
     * @return DATA_FLAG
     */
    public Integer getDataFlag() {
        return dataFlag;
    }

    /**
     * @param dataFlag
     */
    public void setDataFlag(Integer dataFlag) {
        this.dataFlag = dataFlag;
    }

    /**
     * @return DATA_QUALITY
     */
    public Integer getDataQuality() {
        return dataQuality;
    }

    /**
     * @param dataQuality
     */
    public void setDataQuality(Integer dataQuality) {
        this.dataQuality = dataQuality;
    }

    /**
     * @return RECORD_SCORE
     */
    public Integer getRecordScore() {
        return recordScore;
    }

    /**
     * @param recordScore
     */
    public void setRecordScore(Integer recordScore) {
        this.recordScore = recordScore;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return CREATE_BY
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * @return UPDATE_COUNT
     */
    public Integer getUpdateCount() {
        return updateCount;
    }

    /**
     * @param updateCount
     */
    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return UPDATE_BY
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * @return DELETE_FLAG
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * @return DELETE_TIME
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * @param deleteTime
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * @return DELETE_BY
     */
    public String getDeleteBy() {
        return deleteBy;
    }

    /**
     * @param deleteBy
     */
    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy == null ? null : deleteBy.trim();
    }
}