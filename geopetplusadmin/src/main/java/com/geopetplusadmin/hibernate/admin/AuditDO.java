package com.geopetplusadmin.hibernate.admin;

import java.util.Date;

public class AuditDO {
	
	private String auditId;
	private String typeofrequest;
	private String currenttransaction;
	private String previoustransaction;
	private String adminrepid;
	private String requestchannel;
	private String useragent;
	private String custormerrepname;
	private String customerrepcontactno;
	private Date requestdate;
	private Date requeststarttime;
	private Date requestendtime;
	private String languageused;
	private String requestduration;
	private String notes;
	
	public AuditDO(){}

	public AuditDO(String auditId, String typeofrequest,
			String currenttransaction, String previoustransaction,
			String adminrepid, String requestchannel, String useragent,
			String custormerrepname, String customerrepcontactno,
			Date requestdate, Date requeststarttime, Date requestendtime,
			String languageused, String requestduration, String notes) {
		super();
		this.auditId = auditId;
		this.typeofrequest = typeofrequest;
		this.currenttransaction = currenttransaction;
		this.previoustransaction = previoustransaction;
		this.adminrepid = adminrepid;
		this.requestchannel = requestchannel;
		this.useragent = useragent;
		this.custormerrepname = custormerrepname;
		this.customerrepcontactno = customerrepcontactno;
		this.requestdate = requestdate;
		this.requeststarttime = requeststarttime;
		this.requestendtime = requestendtime;
		this.languageused = languageused;
		this.requestduration = requestduration;
		this.notes = notes;
	}

	public String getAuditId() {
		return auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public String getTypeofrequest() {
		return typeofrequest;
	}

	public void setTypeofrequest(String typeofrequest) {
		this.typeofrequest = typeofrequest;
	}

	public String getCurrenttransaction() {
		return currenttransaction;
	}

	public void setCurrenttransaction(String currenttransaction) {
		this.currenttransaction = currenttransaction;
	}

	public String getPrevioustransaction() {
		return previoustransaction;
	}

	public void setPrevioustransaction(String previoustransaction) {
		this.previoustransaction = previoustransaction;
	}

	public String getAdminrepid() {
		return adminrepid;
	}

	public void setAdminrepid(String adminrepid) {
		this.adminrepid = adminrepid;
	}

	public String getRequestchannel() {
		return requestchannel;
	}

	public void setRequestchannel(String requestchannel) {
		this.requestchannel = requestchannel;
	}

	public String getUseragent() {
		return useragent;
	}

	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}

	public String getCustormerrepname() {
		return custormerrepname;
	}

	public void setCustormerrepname(String custormerrepname) {
		this.custormerrepname = custormerrepname;
	}

	public String getCustomerrepcontactno() {
		return customerrepcontactno;
	}

	public void setCustomerrepcontactno(String customerrepcontactno) {
		this.customerrepcontactno = customerrepcontactno;
	}

	public Date getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	public Date getRequeststarttime() {
		return requeststarttime;
	}

	public void setRequeststarttime(Date requeststarttime) {
		this.requeststarttime = requeststarttime;
	}

	public Date getRequestendtime() {
		return requestendtime;
	}

	public void setRequestendtime(Date requestendtime) {
		this.requestendtime = requestendtime;
	}

	public String getLanguageused() {
		return languageused;
	}

	public void setLanguageused(String languageused) {
		this.languageused = languageused;
	}

	public String getRequestduration() {
		return requestduration;
	}

	public void setRequestduration(String requestduration) {
		this.requestduration = requestduration;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Audit [auditId=" + auditId + ", typeofrequest=" + typeofrequest
				+ ", currenttransaction=" + currenttransaction
				+ ", previoustransaction=" + previoustransaction
				+ ", adminrepid=" + adminrepid + ", requestchannel="
				+ requestchannel + ", useragent=" + useragent
				+ ", custormerrepname=" + custormerrepname
				+ ", customerrepcontactno=" + customerrepcontactno
				+ ", requestdate=" + requestdate + ", requeststarttime="
				+ requeststarttime + ", requestendtime=" + requestendtime
				+ ", languageused=" + languageused + ", requestduration="
				+ requestduration + ", notes=" + notes + "]";
	}
	
}
