package com.geopetplusadmin.model;

import com.geopetplusadmin.hibernate.admin.AuditDO;

public interface AuditDAO {
	public String insertAudit(AuditDO auditDO) throws Exception;
}
