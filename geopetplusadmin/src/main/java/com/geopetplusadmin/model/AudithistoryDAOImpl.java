package com.geopetplusadmin.model;

import java.sql.Timestamp;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.hibernate.admin.AuditDO;

public class AudithistoryDAOImpl extends HibernateDaoSupport implements AudithistoryDAO {
	
	private static String facilityId;
	
	@Transactional(readOnly = false)
	public String insertAudit(String getfacilityId) throws Exception {
		
		facilityId = getfacilityId;
		AuditDO auditEntries = new AuditDO();
		auditEntries.setAuditId("auditId");
		auditEntries.setTypeofrequest("tyofreq");
		auditEntries.setCurrenttransaction("currenttransaction");
		auditEntries.setPrevioustransaction("prevtrans");
		auditEntries.setAdminrepid("adminid");
		auditEntries.setRequestchannel("reqchan");
		auditEntries.setUseragent("useragent");
		auditEntries.setCustormerrepname("custormerrepname");
		auditEntries.setCustomerrepcontactno("custrepno");
		auditEntries.setRequestdate(new Timestamp(System.currentTimeMillis()));
		auditEntries.setRequeststarttime(new Timestamp(System.currentTimeMillis()));
		auditEntries.setRequestendtime(new Timestamp(System.currentTimeMillis()));
		auditEntries.setLanguageused("langused");
		auditEntries.setRequestduration("reqdur");
		auditEntries.setNotes("notes");
		
		this.getHibernateTemplate().save(auditEntries);
		return facilityId;
	}
	
}
