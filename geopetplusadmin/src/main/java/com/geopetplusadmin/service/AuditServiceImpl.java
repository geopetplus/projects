package com.geopetplusadmin.service;

import com.geopetplusadmin.domain.utility.TranformationUtils;
import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.model.AuditDAO;
import com.geopetplusadmin.model.LoginDAO;
import com.geopetplusadmin.vo.AuditVO;
import com.geopetplusadmin.vo.LoginVO;

public class AuditServiceImpl implements AuditService {
	
	AuditDAO auditDAO;
	
	public AuditDAO getAuditDAO() {
		return auditDAO;
	}


	public void setAuditDAO(AuditDAO auditDAO) {
		this.auditDAO = auditDAO;
	}

	public String insertAudit(AuditVO auditVO) throws Exception {
		AuditDO auditDO = TranformationUtils.transformAuditVO(auditVO);
		return auditDAO.insertAudit(auditDO);
	}

}
