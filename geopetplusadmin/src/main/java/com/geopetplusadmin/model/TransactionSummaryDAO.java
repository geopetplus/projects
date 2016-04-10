package com.geopetplusadmin.model;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;

public interface TransactionSummaryDAO {
	public String insertFacilitySummary(FacilityDemographicsDO facilityDemographicsDO) throws DAOException;
}
