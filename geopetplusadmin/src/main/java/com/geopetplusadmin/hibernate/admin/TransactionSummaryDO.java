package com.geopetplusadmin.hibernate.admin;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

public class TransactionSummaryDO implements Serializable {
	
	private final static Logger LOGGER = Logger.getLogger(TransactionSummaryDO.class);
	
	private int id;
	private String transactionseqnr;
	private Date transactiondate;
	private int termamountbeforediscount;
	private int servicetotdiscountamt;
	private String discountcode;
	private int discountamt;
	private int termamountafterdiscount;
	private int previoustermamount;
	private int finaltransactionamountdebit;
	private int finaltransactionamountcredit;
	private String modeofpayment;
	private String paymentstatus;
	private String auditid;
	private String remarks;
	
	public TransactionSummaryDO() {}
	
	public TransactionSummaryDO(int id, String transactionseqnr, Date transactiondate, int termamountbeforediscount,
			int servicetotdiscountamt, String discountcode, int discountamt, int termamountafterdiscount,
			int previoustermamount, int finaltransactionamountdebit, int finaltransactionamountcredit,
			String modeofpayment, String paymentstatus, String auditid, String remarks) {
		super();
		this.id = id;
		this.transactionseqnr = transactionseqnr;
		this.transactiondate = transactiondate;
		this.termamountbeforediscount = termamountbeforediscount;
		this.servicetotdiscountamt = servicetotdiscountamt;
		this.discountcode = discountcode;
		this.discountamt = discountamt;
		this.termamountafterdiscount = termamountafterdiscount;
		this.previoustermamount = previoustermamount;
		this.finaltransactionamountdebit = finaltransactionamountdebit;
		this.finaltransactionamountcredit = finaltransactionamountcredit;
		this.modeofpayment = modeofpayment;
		this.paymentstatus = paymentstatus;
		this.auditid = auditid;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionseqnr() {
		return transactionseqnr;
	}

	public void setTransactionseqnr(String transactionseqnr) {
		this.transactionseqnr = transactionseqnr;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public int getTermamountbeforediscount() {
		return termamountbeforediscount;
	}

	public void setTermamountbeforediscount(int termamountbeforediscount) {
		this.termamountbeforediscount = termamountbeforediscount;
	}

	public int getServicetotdiscountamt() {
		return servicetotdiscountamt;
	}

	public void setServicetotdiscountamt(int servicetotdiscountamt) {
		this.servicetotdiscountamt = servicetotdiscountamt;
	}

	public String getDiscountcode() {
		return discountcode;
	}

	public void setDiscountcode(String discountcode) {
		this.discountcode = discountcode;
	}

	public int getDiscountamt() {
		return discountamt;
	}

	public void setDiscountamt(int discountamt) {
		this.discountamt = discountamt;
	}

	public int getTermamountafterdiscount() {
		return termamountafterdiscount;
	}

	public void setTermamountafterdiscount(int termamountafterdiscount) {
		this.termamountafterdiscount = termamountafterdiscount;
	}

	public int getPrevioustermamount() {
		return previoustermamount;
	}

	public void setPrevioustermamount(int previoustermamount) {
		this.previoustermamount = previoustermamount;
	}

	public int getFinaltransactionamountdebit() {
		return finaltransactionamountdebit;
	}

	public void setFinaltransactionamountdebit(int finaltransactionamountdebit) {
		this.finaltransactionamountdebit = finaltransactionamountdebit;
	}

	public int getFinaltransactionamountcredit() {
		return finaltransactionamountcredit;
	}

	public void setFinaltransactionamountcredit(int finaltransactionamountcredit) {
		this.finaltransactionamountcredit = finaltransactionamountcredit;
	}

	public String getModeofpayment() {
		return modeofpayment;
	}

	public void setModeofpayment(String modeofpayment) {
		this.modeofpayment = modeofpayment;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getAuditid() {
		return auditid;
	}

	public void setAuditid(String auditid) {
		this.auditid = auditid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TransactionSummaryDO [id=" + id + ", transactionseqnr=" + transactionseqnr + ", transactiondate="
				+ transactiondate + ", termamountbeforediscount=" + termamountbeforediscount
				+ ", servicetotdiscountamt=" + servicetotdiscountamt + ", discountcode=" + discountcode
				+ ", discountamt=" + discountamt + ", termamountafterdiscount=" + termamountafterdiscount
				+ ", previoustermamount=" + previoustermamount + ", finaltransactionamountdebit="
				+ finaltransactionamountdebit + ", finaltransactionamountcredit=" + finaltransactionamountcredit
				+ ", modeofpayment=" + modeofpayment + ", paymentstatus=" + paymentstatus + ", auditid=" + auditid
				+ ", remarks=" + remarks + "]";
	}
	
}
