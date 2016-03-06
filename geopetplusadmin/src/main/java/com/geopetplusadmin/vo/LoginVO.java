package com.geopetplusadmin.vo;

import java.util.Date;

public class LoginVO {
	
	private String facilityid;
	private String versionid;
	private String userid;
	private String password;
	private Date lastupdated;
	private String role;
	private String status;
	private String auditid;
	
	public LoginVO() {}

	public LoginVO(String facilityid, String versionid, String userid,
			String password, Date lastupdated, String role, String status,
			String auditid) {
		super();
		this.facilityid = facilityid;
		this.versionid = versionid;
		this.userid = userid;
		this.password = password;
		this.lastupdated = lastupdated;
		this.role = role;
		this.status = status;
		this.auditid = auditid;
	}

	public String getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}

	public String getVersionid() {
		return versionid;
	}

	public void setVersionid(String versionid) {
		this.versionid = versionid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditid() {
		return auditid;
	}

	public void setAuditid(String auditid) {
		this.auditid = auditid;
	}
	
}
