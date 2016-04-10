package com.geopetplusadmin.model;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;

public interface TransactionServicesDAO {

	public String insertServices(FacilityDemographicsDO facilityDemographicsDO) throws DAOException;
	
}
