package com.geopetplusadmin.service;

import com.geopetplusadmin.model.AudithistoryDAO;

public class AudithistoryServiceImpl implements AudithistoryService {
	
	private static String facilityId;
	AudithistoryDAO audithistoryDAO;
	
	public static String getFacilityId() {
		return facilityId;
	}
	public static void setFacilityId(String facilityId) {
		AudithistoryServiceImpl.facilityId = facilityId;
	}
	public AudithistoryDAO getAudithistoryDAO() {
		return audithistoryDAO;
	}
	public void setAudithistoryDAO(AudithistoryDAO audithistoryDAO) {
		this.audithistoryDAO = audithistoryDAO;
	}
	public String insertAudit(String getfacilityId) throws Exception {
		facilityId = getfacilityId;
		return audithistoryDAO.insertAudit(facilityId);
	}
	
}
