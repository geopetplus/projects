package com.geopetplusadmin.hibernate.admin;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;


public class FacilityTermDO implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(FacilityTermDO.class);
	
	private int id;
	private String facilityid;
	private String policyid;
	private String termid;
	private String transactionseqnbr;
	private String status;
	private Date termeffectivedate;
	private Date termenddate;
	private String autorenewind;
	
	public FacilityTermDO() {}
	
	public FacilityTermDO(int id, String facilityid, String policyid, String termid, String transactionseqnbr,
			String status, Date termeffectivedate, Date termenddate, String autorenewind) {
		super();
		this.id = id;
		this.facilityid = facilityid;
		this.policyid = policyid;
		this.termid = termid;
		this.transactionseqnbr = transactionseqnbr;
		this.status = status;
		this.termeffectivedate = termeffectivedate;
		this.termenddate = termenddate;
		this.autorenewind = autorenewind;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTermeffectivedate() {
		return termeffectivedate;
	}

	public void setTermeffectivedate(Date termeffectivedate) {
		this.termeffectivedate = termeffectivedate;
	}

	public Date getTermenddate() {
		return termenddate;
	}

	public void setTermenddate(Date termenddate) {
		this.termenddate = termenddate;
	}

	public String getAutorenewind() {
		return autorenewind;
	}

	public void setAutorenewind(String autorenewind) {
		this.autorenewind = autorenewind;
	}

	@Override
	public String toString() {
		return "FacilityTermDO [id=" + id + ", facilityid=" + facilityid + ", policyid=" + policyid + ", termid="
				+ termid + ", transactionseqnbr=" + transactionseqnbr + ", status=" + status + ", termeffectivedate="
				+ termeffectivedate + ", termenddate=" + termenddate + ", autorenewind=" + autorenewind + "]";
	}
	
}
