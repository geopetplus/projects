package com.geopetplusadmin.model;

import java.sql.Timestamp;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.hibernate.admin.AuditDO;

public class AuditDAOImpl extends HibernateDaoSupport implements AuditDAO {
	
	private static String facilityId;
	
	@Transactional(readOnly = false)
	public String insertAudit(AuditDO auditDO) throws Exception {
		return facilityId;
	}
	
}
