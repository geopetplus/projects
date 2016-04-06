package com.geopetplusadmin.model;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;

public interface FacilityTermDAO {
	public String insertFacilityTerm(FacilityDemographicsDO facilityDemographicsDO) throws DAOException;
}
