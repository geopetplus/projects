package com.geopetplusadmin.hibernate.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

public class AdminDemographicsDO implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(AdminDemographicsDO.class);
	
	private String adminid;
	private String adminFirstName;
	private String adminLastName;
	private String mailAddr1;
	private String mailAddr2;
	private String mailingLocation;
	private String mailingCity;
	private String mailingState;
	private String mailingPincode;
	private String adminPhone;
	private String adminAltContact;
	private String adminMobileNum;
	private String adminEmail;
	private Date adminRegStartDate;
	private Date adminRegEndDate;
	private Date lastUpdateDate;
	private String status;
	private String auditID;
	private ArrayList<String> services;
	
	public AdminDemographicsDO(){}

	public AdminDemographicsDO(String adminid,
			String adminLastName, String adminFirstName, String mailAddr1,
			String mailAddr2, String mailingLocation, String mailingCity,
			String mailingState, String mailingPincode, String adminPhone,
			String adminAltContact, String adminMobileNum,
			String adminEmail,
			Date adminRegStartDate, Date adminRegEndDate,
			Date lastUpdateDate, String status, String auditID) {
		super();
		this.adminid = adminid;
		this.adminLastName = adminLastName;
		this.adminFirstName = adminFirstName;
		this.mailAddr1 = mailAddr1;
		this.mailAddr2 = mailAddr2;
		this.mailingLocation = mailingLocation;
		this.mailingCity = mailingCity;
		this.mailingState = mailingState;
		this.mailingPincode = mailingPincode;
		this.adminPhone = adminPhone;
		this.adminAltContact = adminAltContact;
		this.adminMobileNum = adminMobileNum;
		this.adminEmail = adminEmail;
		this.adminRegStartDate = adminRegStartDate;
		this.adminRegEndDate = adminRegEndDate;
		this.lastUpdateDate = lastUpdateDate;
		this.status = status;
		this.auditID = auditID;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getMailAddr1() {
		return mailAddr1;
	}

	public void setMailAddr1(String mailAddr1) {
		this.mailAddr1 = mailAddr1;
	}

	public String getMailAddr2() {
		return mailAddr2;
	}

	public void setMailAddr2(String mailAddr2) {
		this.mailAddr2 = mailAddr2;
	}

	public String getMailingLocation() {
		return mailingLocation;
	}

	public void setMailingLocation(String mailingLocation) {
		this.mailingLocation = mailingLocation;
	}

	public String getMailingCity() {
		return mailingCity;
	}

	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

	public String getMailingState() {
		return mailingState;
	}

	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}

	public String getMailingPincode() {
		return mailingPincode;
	}

	public void setMailingPincode(String mailingPincode) {
		this.mailingPincode = mailingPincode;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminAltContact() {
		return adminAltContact;
	}

	public void setAdminAltContact(String adminAltContact) {
		this.adminAltContact = adminAltContact;
	}

	public String getAdminMobileNum() {
		return adminMobileNum;
	}

	public void setAdminMobileNum(String adminMobileNum) {
		this.adminMobileNum = adminMobileNum;
	}

	
	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	
	public Date getAdminRegStartDate() {
		return adminRegStartDate;
	}

	public void setAdminRegStartDate(Date adminRegStartDate) {
		this.adminRegStartDate = adminRegStartDate;
	}

	public Date getAdminRegEndDate() {
		return adminRegEndDate;
	}

	public void setAdminRegEndDate(Date adminRegEndDate) {
		this.adminRegEndDate = adminRegEndDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuditID() {
		return auditID;
	}

	public void setAuditID(String auditID) {
		this.auditID = auditID;
	}

	@Override
	public String toString() {
		return "AdminDemographics [adminid=" + adminid
				+ ", adminLastName=" + adminLastName + ", adminFirstName=" + adminFirstName
				+ ", mailAddr1=" + mailAddr1 + ", mailAddr2=" + mailAddr2
				+ ", mailingLocation=" + mailingLocation + ", mailingCity="
				+ mailingCity + ", mailingState=" + mailingState
				+ ", mailingPincode=" + mailingPincode 
				+ ", adminPhone=" + adminPhone + ", adminAltContact="
				+ adminAltContact + ", adminMobileNum=" + adminMobileNum
				+ ", adminEmail=" + adminEmail 
				+ ", adminRegStartDate=" + adminRegStartDate
				+ ", adminRegEndDate=" + adminRegEndDate
				+ ", lastUpdateDate=" + lastUpdateDate + ", status=" + status
				+ ", auditID=" + auditID + "]";
	}
		
}
