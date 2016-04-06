package com.geopetplusadmin.model;

import java.math.BigInteger;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.FacilityTermDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;
import com.geopetplusadmin.hibernate.admin.TransactionSummaryDO;

public interface FacilityDemographicsDAO {
	
	public void saveFacilityDemographics(FacilityDemographicsDO facilityDemographicsDO) throws DAOException;
	
	public void saveLoginInfo(LoginDO loginDO) throws DAOException;
	
	public void saveServiceInfo(TransactionServicesDO serviceDO) throws DAOException;
	
	public void saveFacilityTermInfo(FacilityTermDO facilityTermDO) throws DAOException;
	
	public void saveTransactionSummaryInfo(TransactionSummaryDO transactionSummaryDO) throws DAOException;
	
	public void saveAuditInfo(AuditDO auditDO) throws DAOException;

	public BigInteger getSequence(String sequenceName) throws DAOException;
	
	public String getFacilityId(String facilityid) throws DAOException;
	
	public String getServiceId(final String serviceName) throws DAOException;
}
