package com.geopetplusadmin.model;

import java.math.BigInteger;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;

public interface FacilityDemographicsDAO {
	
	public String saveFacilityDemographics(FacilityDemographicsDO facilityDemographicsDO) throws DAOException;
	
	public void saveLoginInfo(LoginDO loginDO) throws DAOException;
	
	public void saveServiceInfo(TransactionServicesDO serviceDO) throws DAOException;
	
	public void saveAuditInfo(AuditDO auditDO) throws DAOException;

	public BigInteger getSequence(String sequenceName) throws DAOException;
	
	public String getFacilityId(String facilityid) throws DAOException;
	
	public String getServiceId(final String serviceName) throws DAOException;
}
