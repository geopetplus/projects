package com.geopetplusadmin.service;

import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface FacilityDemographicsService {
	public void saveFacilityDemographics(FacilityDemographicsVO facilityDemographicsVO) throws ServiceException;
}
