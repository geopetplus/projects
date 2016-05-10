package com.geopetplusadmin.model;

import java.math.BigInteger;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.AdminDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;
import com.geopetplusadmin.hibernate.admin.TransactionSummaryDO;

public interface AdminDemographicsDAO {
	
	public String saveAdminDemographics(AdminDemographicsDO adminDemographicsDO) throws DAOException;
	
	public void saveLoginInfo(LoginDO loginDO) throws DAOException;
	
	public void saveServiceInfo(TransactionServicesDO serviceDO) throws DAOException;
	

	
	public String getAdminId() throws DAOException;
	
	public String getServiceId(final String serviceName) throws DAOException;
}
