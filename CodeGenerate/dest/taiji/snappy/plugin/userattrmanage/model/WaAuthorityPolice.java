/*
 * Powered By [douniwan]
 * Generate Date:  2015-08-18
 */

package taiji.snappy.plugin.userattrmanage.model;

import java.util.HashMap;
import java.util.Map;

import taiji.snappy.db.DataObject;

public class WaAuthorityPolice {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * certificateCodeMd5
     * CERTIFICATE_CODE_MD5
     */	
	
	private java.lang.String certificateCodeMd5;
	
    /**
     * certificateCodeSuffix
     * CERTIFICATE_CODE_SUFFIX
     */	
	
	private java.lang.String certificateCodeSuffix;
	
    /**
     * name
     * NAME
     */	
	
	private java.lang.String name;
	
    /**
     * sexcode
     * SEXCODE
     */	
	
	private java.lang.String sexcode;
	
    /**
     * gaDepartment
     * GA_DEPARTMENT
     */	
	
	private java.lang.String gaDepartment;
	
    /**
     * unit
     * UNIT
     */	
	
	private java.lang.String unit;
	
    /**
     * orgLevel
     * ORG_LEVEL
     */	
	
	private java.lang.String orgLevel;
	
    /**
     * policeSort
     * POLICE_SORT
     */	
	
	private java.lang.String policeSort;
	
    /**
     * policeNo
     * POLICE_NO
     */	
	
	private java.lang.String policeNo;
	
    /**
     * sensitiveLevel
     * SENSITIVE_LEVEL
     */	
	
	private java.lang.String sensitiveLevel;
	
    /**
     * businessType
     * BUSINESS_TYPE
     */	
	
	private java.lang.String businessType;
	
    /**
     * takeOffice
     * TAKE_OFFICE
     */	
	
	private java.lang.String takeOffice;
	
    /**
     * userStatus
     * USER_STATUS
     */	
	
	private java.lang.String userStatus;
	
    /**
     * deleteStatus
     * DELETE_STATUS
     */	
	
	private java.lang.String deleteStatus;
	
    /**
     * dataVersion
     * DATA_VERSION
     */	
	
	private Long dataVersion;
	
    /**
     * latestModTime
     * LATEST_MOD_TIME
     */	
	
	private Long latestModTime;
	
	
	public WaAuthorityPolice(){
	}

	public WaAuthorityPolice(
		java.lang.String certificateCodeMd5
	){
		this.certificateCodeMd5 = certificateCodeMd5;
	}

	public java.lang.String getCertificateCodeMd5() {
		return this.certificateCodeMd5;
	}
	
	
	public void setCertificateCodeMd5(java.lang.String value) {
		this.certificateCodeMd5 = value;
	}

	
	public java.lang.String getCertificateCodeSuffix() {
		return this.certificateCodeSuffix;
	}
	
	
	public void setCertificateCodeSuffix(java.lang.String value) {
		this.certificateCodeSuffix = value;
	}

	
	public java.lang.String getName() {
		return this.name;
	}
	
	
	public void setName(java.lang.String value) {
		this.name = value;
	}

	
	public java.lang.String getSexcode() {
		return this.sexcode;
	}
	
	
	public void setSexcode(java.lang.String value) {
		this.sexcode = value;
	}

	
	public java.lang.String getGaDepartment() {
		return this.gaDepartment;
	}
	
	
	public void setGaDepartment(java.lang.String value) {
		this.gaDepartment = value;
	}

	
	public java.lang.String getUnit() {
		return this.unit;
	}
	
	
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}

	
	public java.lang.String getOrgLevel() {
		return this.orgLevel;
	}
	
	
	public void setOrgLevel(java.lang.String value) {
		this.orgLevel = value;
	}

	
	public java.lang.String getPoliceSort() {
		return this.policeSort;
	}
	
	
	public void setPoliceSort(java.lang.String value) {
		this.policeSort = value;
	}

	
	public java.lang.String getPoliceNo() {
		return this.policeNo;
	}
	
	
	public void setPoliceNo(java.lang.String value) {
		this.policeNo = value;
	}

	
	public java.lang.String getSensitiveLevel() {
		return this.sensitiveLevel;
	}
	
	
	public void setSensitiveLevel(java.lang.String value) {
		this.sensitiveLevel = value;
	}

	
	public java.lang.String getBusinessType() {
		return this.businessType;
	}
	
	
	public void setBusinessType(java.lang.String value) {
		this.businessType = value;
	}

	
	public java.lang.String getTakeOffice() {
		return this.takeOffice;
	}
	
	
	public void setTakeOffice(java.lang.String value) {
		this.takeOffice = value;
	}

	
	public java.lang.String getUserStatus() {
		return this.userStatus;
	}
	
	
	public void setUserStatus(java.lang.String value) {
		this.userStatus = value;
	}

	
	public java.lang.String getDeleteStatus() {
		return this.deleteStatus;
	}
	
	
	public void setDeleteStatus(java.lang.String value) {
		this.deleteStatus = value;
	}

	
	public Long getDataVersion() {
		return this.dataVersion;
	}
	
	
	public void setDataVersion(Long value) {
		this.dataVersion = value;
	}

	
	public Long getLatestModTime() {
		return this.latestModTime;
	}
	
	
	public void setLatestModTime(Long value) {
		this.latestModTime = value;
	}

	


	public static WaAuthorityPolice create(DataObject dataObject){
		WaAuthorityPolice a = new WaAuthorityPolice();
		a.certificateCodeMd5  = dataObject.getString("certificateCodeMd5");
		a.certificateCodeSuffix  = dataObject.getString("certificateCodeSuffix");
		a.name  = dataObject.getString("name");
		a.sexcode  = dataObject.getString("sexcode");
		a.gaDepartment  = dataObject.getString("gaDepartment");
		a.unit  = dataObject.getString("unit");
		a.orgLevel  = dataObject.getString("orgLevel");
		a.policeSort  = dataObject.getString("policeSort");
		a.policeNo  = dataObject.getString("policeNo");
		a.sensitiveLevel  = dataObject.getString("sensitiveLevel");
		a.businessType  = dataObject.getString("businessType");
		a.takeOffice  = dataObject.getString("takeOffice");
		a.userStatus  = dataObject.getString("userStatus");
		a.deleteStatus  = dataObject.getString("deleteStatus");
		a.dataVersion  = dataObject.getLong("dataVersion");
		a.latestModTime  = dataObject.getLong("latestModTime");
		return a;
	}

	

}