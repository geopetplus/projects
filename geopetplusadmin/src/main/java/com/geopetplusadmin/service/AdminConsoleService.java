package com.geopetplusadmin.service;

import java.util.ArrayList;

import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface AdminConsoleService {
	public ArrayList<FacilityDemographicsDO> getPendingFacilities() throws ServiceException;
	public FacilityDemographicsVO getFacilityInfo(String facilityid) throws ServiceException;
}
