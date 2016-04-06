package com.geopetplusadmin.hibernate.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

public class FacilityDemographicsDO implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(FacilityDemographicsDO.class);
	
	private String facilityid;
	private String facilityname;
	private String contactLastName;
	private String contactFirstName;
	private String versionid;
	private String mailAddr1;
	private String mailAddr2;
	private String mailingLocation;
	private String mailingCity;
	private String mailingState;
	private String mailingPincode;
	private boolean sameAddress;
	private String billAddr1;
	private String billAddr2;
	private String billLocation;
	private String billCity;
	private String billState;
	private String billPincode;
	private String facilityPhone;
	private String facilityAltPhone;
	private String facilyMobileNum;
	private String facilityWhatsAppNum;
	private String facilityEmail1;
	private String facilityEmail2;
	private String facilityURL;
	private Date facilityRegStartDate;
	private Date facilityRegEndDate;
	private Date lastUpdateDate;
	private String auditID;
	private ArrayList<String> services;
	
	public FacilityDemographicsDO(){}

	public FacilityDemographicsDO(String facilityid, String facilityname, String contactLastName,
			String contactFirstName, String versionid, String mailAddr1, String mailAddr2, String mailingLocation,
			String mailingCity, String mailingState, String mailingPincode, boolean sameAddress, String billAddr1,
			String billAddr2, String billLocation, String billCity, String billState, String billPincode,
			String facilityPhone, String facilityAltPhone, String facilyMobileNum, String facilityWhatsAppNum,
			String facilityEmail1, String facilityEmail2, String facilityURL, Date facilityRegStartDate,
			Date facilityRegEndDate, Date lastUpdateDate, String auditID, ArrayList<String> services) {
		super();
		this.facilityid = facilityid;
		this.facilityname = facilityname;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.versionid = versionid;
		this.mailAddr1 = mailAddr1;
		this.mailAddr2 = mailAddr2;
		this.mailingLocation = mailingLocation;
		this.mailingCity = mailingCity;
		this.mailingState = mailingState;
		this.mailingPincode = mailingPincode;
		this.sameAddress = sameAddress;
		this.billAddr1 = billAddr1;
		this.billAddr2 = billAddr2;
		this.billLocation = billLocation;
		this.billCity = billCity;
		this.billState = billState;
		this.billPincode = billPincode;
		this.facilityPhone = facilityPhone;
		this.facilityAltPhone = facilityAltPhone;
		this.facilyMobileNum = facilyMobileNum;
		this.facilityWhatsAppNum = facilityWhatsAppNum;
		this.facilityEmail1 = facilityEmail1;
		this.facilityEmail2 = facilityEmail2;
		this.facilityURL = facilityURL;
		this.facilityRegStartDate = facilityRegStartDate;
		this.facilityRegEndDate = facilityRegEndDate;
		this.lastUpdateDate = lastUpdateDate;
		this.auditID = auditID;
		this.services = services;
	}

	public String getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}

	public String getFacilityname() {
		return facilityname;
	}

	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getVersionid() {
		return versionid;
	}

	public void setVersionid(String versionid) {
		this.versionid = versionid;
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

	public boolean isSameAddress() {
		return sameAddress;
	}

	public void setSameAddress(boolean sameAddress) {
		this.sameAddress = sameAddress;
	}

	public String getBillAddr1() {
		return billAddr1;
	}

	public void setBillAddr1(String billAddr1) {
		this.billAddr1 = billAddr1;
	}

	public String getBillAddr2() {
		return billAddr2;
	}

	public void setBillAddr2(String billAddr2) {
		this.billAddr2 = billAddr2;
	}

	public String getBillLocation() {
		return billLocation;
	}

	public void setBillLocation(String billLocation) {
		this.billLocation = billLocation;
	}

	public String getBillCity() {
		return billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	public String getBillState() {
		return billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	public String getBillPincode() {
		return billPincode;
	}

	public void setBillPincode(String billPincode) {
		this.billPincode = billPincode;
	}

	public String getFacilityPhone() {
		return facilityPhone;
	}

	public void setFacilityPhone(String facilityPhone) {
		this.facilityPhone = facilityPhone;
	}

	public String getFacilityAltPhone() {
		return facilityAltPhone;
	}

	public void setFacilityAltPhone(String facilityAltPhone) {
		this.facilityAltPhone = facilityAltPhone;
	}

	public String getFacilyMobileNum() {
		return facilyMobileNum;
	}

	public void setFacilyMobileNum(String facilyMobileNum) {
		this.facilyMobileNum = facilyMobileNum;
	}

	public String getFacilityWhatsAppNum() {
		return facilityWhatsAppNum;
	}

	public void setFacilityWhatsAppNum(String facilityWhatsAppNum) {
		this.facilityWhatsAppNum = facilityWhatsAppNum;
	}

	public String getFacilityEmail1() {
		return facilityEmail1;
	}

	public void setFacilityEmail1(String facilityEmail1) {
		this.facilityEmail1 = facilityEmail1;
	}

	public String getFacilityEmail2() {
		return facilityEmail2;
	}

	public void setFacilityEmail2(String facilityEmail2) {
		this.facilityEmail2 = facilityEmail2;
	}

	public String getFacilityURL() {
		return facilityURL;
	}

	public void setFacilityURL(String facilityURL) {
		this.facilityURL = facilityURL;
	}

	public Date getFacilityRegStartDate() {
		return facilityRegStartDate;
	}

	public void setFacilityRegStartDate(Date facilityRegStartDate) {
		this.facilityRegStartDate = facilityRegStartDate;
	}

	public Date getFacilityRegEndDate() {
		return facilityRegEndDate;
	}

	public void setFacilityRegEndDate(Date facilityRegEndDate) {
		this.facilityRegEndDate = facilityRegEndDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getAuditID() {
		return auditID;
	}

	public void setAuditID(String auditID) {
		this.auditID = auditID;
	}

	public ArrayList<String> getServices() {
		return services;
	}

	public void setServices(ArrayList<String> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "FacilityDemographicsDO [facilityid=" + facilityid + ", facilityname=" + facilityname
				+ ", contactLastName=" + contactLastName + ", contactFirstName=" + contactFirstName + ", versionid="
				+ versionid + ", mailAddr1=" + mailAddr1 + ", mailAddr2=" + mailAddr2 + ", mailingLocation="
				+ mailingLocation + ", mailingCity=" + mailingCity + ", mailingState=" + mailingState
				+ ", mailingPincode=" + mailingPincode + ", sameAddress=" + sameAddress + ", billAddr1=" + billAddr1
				+ ", billAddr2=" + billAddr2 + ", billLocation=" + billLocation + ", billCity=" + billCity
				+ ", billState=" + billState + ", billPincode=" + billPincode + ", facilityPhone=" + facilityPhone
				+ ", facilityAltPhone=" + facilityAltPhone + ", facilyMobileNum=" + facilyMobileNum
				+ ", facilityWhatsAppNum=" + facilityWhatsAppNum + ", facilityEmail1=" + facilityEmail1
				+ ", facilityEmail2=" + facilityEmail2 + ", facilityURL=" + facilityURL + ", facilityRegStartDate="
				+ facilityRegStartDate + ", facilityRegEndDate=" + facilityRegEndDate + ", lastUpdateDate="
				+ lastUpdateDate + ", auditID=" + auditID + ", services=" + services + "]";
	}
		
}
