package com.geopetplusadmin.delegate;

import com.geopetplusadmin.service.FacilityDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class FacilityDemographicsDelegateImpl implements FacilityDemographicsDelegate {
	
	public String insertDemographics(FacilityDemographicsVO facilityDemographicsVO) throws Exception {
		String status = null;
		FacilityDemographicsService facilityDemographicsService = (FacilityDemographicsService) SpringServiceFactory.getBean("facilityDemographicService");
		if (facilityDemographicsService != null) {
			status = facilityDemographicsService.insertDemographics(facilityDemographicsVO);
		}
		return status;
	}
	
}
