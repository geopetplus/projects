package com.geopetplusadmin.hibernate.admin;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

public class TransactionServicesDO implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(TransactionServicesDO.class);
	
	private int id;
	private String facilityid;
	private String policyid;
	private String termid;
	private String transactionseqnbr;
	private String serviceid;
	private String serviceseqnbr;
	private String servicesubplantype;
	private String status;
	private Date serviceeffectivedate;
	private Date serviceenddate;
	private int serviceoriginalamt;
	private String servicediscountcode;
	private int servicediscountamt;
	private int servicefinalamt;
	
	public TransactionServicesDO(){}

	public TransactionServicesDO(int id, String facilityid, String policyid, String termid, String transactionseqnbr,
			String serviceid, String serviceseqnbr, String servicesubplantype, String status, Date serviceeffectivedate,
			Date serviceenddate, int serviceoriginalamt, String servicediscountcode, int servicediscountamt,
			int servicefinalamt) {
		super();
		this.id = id;
		this.facilityid = facilityid;
		this.policyid = policyid;
		this.termid = termid;
		this.transactionseqnbr = transactionseqnbr;
		this.serviceid = serviceid;
		this.serviceseqnbr = serviceseqnbr;
		this.servicesubplantype = servicesubplantype;
		this.status = status;
		this.serviceeffectivedate = serviceeffectivedate;
		this.serviceenddate = serviceenddate;
		this.serviceoriginalamt = serviceoriginalamt;
		this.servicediscountcode = servicediscountcode;
		this.servicediscountamt = servicediscountamt;
		this.servicefinalamt = servicefinalamt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}

	public String getPolicyid() {
		return policyid;
	}

	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}

	public String getTermid() {
		return termid;
	}

	public void setTermid(String termid) {
		this.termid = termid;
	}

	public String getTransactionseqnbr() {
		return transactionseqnbr;
	}

	public void setTransactionseqnbr(String transactionseqnbr) {
		this.transactionseqnbr = transactionseqnbr;
	}

	public String getServiceid() {
		return serviceid;
	}

	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}

	public String getServiceseqnbr() {
		return serviceseqnbr;
	}

	public void setServiceseqnbr(String serviceseqnbr) {
		this.serviceseqnbr = serviceseqnbr;
	}

	public String getServicesubplantype() {
		return servicesubplantype;
	}

	public void setServicesubplantype(String servicesubplantype) {
		this.servicesubplantype = servicesubplantype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getServiceeffectivedate() {
		return serviceeffectivedate;
	}

	public void setServiceeffectivedate(Date serviceeffectivedate) {
		this.serviceeffectivedate = serviceeffectivedate;
	}

	public Date getServiceenddate() {
		return serviceenddate;
	}

	public void setServiceenddate(Date serviceenddate) {
		this.serviceenddate = serviceenddate;
	}

	public int getServiceoriginalamt() {
		return serviceoriginalamt;
	}

	public void setServiceoriginalamt(int serviceoriginalamt) {
		this.serviceoriginalamt = serviceoriginalamt;
	}

	public String getServicediscountcode() {
		return servicediscountcode;
	}

	public void setServicediscountcode(String servicediscountcode) {
		this.servicediscountcode = servicediscountcode;
	}

	public int getServicediscountamt() {
		return servicediscountamt;
	}

	public void setServicediscountamt(int servicediscountamt) {
		this.servicediscountamt = servicediscountamt;
	}

	public int getServicefinalamt() {
		return servicefinalamt;
	}

	public void setServicefinalamt(int servicefinalamt) {
		this.servicefinalamt = servicefinalamt;
	}

	@Override
	public String toString() {
		return "TransactionServicesDO [id=" + id + ", facilityid=" + facilityid + ", policyid=" + policyid + ", termid="
				+ termid + ", transactionseqnbr=" + transactionseqnbr + ", serviceid=" + serviceid + ", serviceseqnbr="
				+ serviceseqnbr + ", servicesubplantype=" + servicesubplantype + ", status=" + status
				+ ", serviceeffectivedate=" + serviceeffectivedate + ", serviceenddate=" + serviceenddate
				+ ", serviceoriginalamt=" + serviceoriginalamt + ", servicediscountcode=" + servicediscountcode
				+ ", servicediscountamt=" + servicediscountamt + ", servicefinalamt=" + servicefinalamt + "]";
	}
	
	
	
}
