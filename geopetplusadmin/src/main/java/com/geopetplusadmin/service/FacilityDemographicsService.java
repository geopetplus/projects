package com.geopetplusadmin.service;

import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface FacilityDemographicsService {
	public String insertDemographics(FacilityDemographicsVO facilityDemographicsVO) throws ServiceException;
}
