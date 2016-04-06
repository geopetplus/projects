package com.geopetplusadmin.hibernate.admin;

import java.util.Date;

public class AuditDO {
	
	private String auditId;
	private String typeofrequest;
	private String transaction;
	private String adminid;
	private String requestchannel;
	private String useragent;
	private String facilityid;
	private Date requestdate;
	
	public AuditDO(){}

	public AuditDO(String auditId, String typeofrequest, String transaction, String adminid, String requestchannel,
			String useragent, String facilityid, Date requestdate) {
		super();
		this.auditId = auditId;
		this.typeofrequest = typeofrequest;
		this.transaction = transaction;
		this.adminid = adminid;
		this.requestchannel = requestchannel;
		this.useragent = useragent;
		this.facilityid = facilityid;
		this.requestdate = requestdate;
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

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
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

	public String getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}

	public Date getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}

	@Override
	public String toString() {
		return "AuditDO [auditId=" + auditId + ", typeofrequest=" + typeofrequest + ", transaction=" + transaction
				+ ", adminid=" + adminid + ", requestchannel=" + requestchannel + ", useragent=" + useragent
				+ ", facilityid=" + facilityid + ", requestdate=" + requestdate + "]";
	}
	
}
