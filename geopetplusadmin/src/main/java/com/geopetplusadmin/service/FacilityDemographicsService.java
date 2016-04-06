package com.geopetplusadmin.service;

import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface FacilityDemographicsService {
	public String saveFacilityDemographics(FacilityDemographicsVO facilityDemographicsVO) throws ServiceException;
}
