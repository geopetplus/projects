package com.geopetplusadmin.delegate;

import com.geopetplusadmin.service.AdminDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;

public class AdminDemographicsDelegateImpl implements AdminDemographicsDelegate {
	
	public String insertDemographics() throws Exception {
		String status = null;		
		AdminDemographicsService adminDemographicsService = (AdminDemographicsService) SpringServiceFactory.getBean("facilityDemographicService");
		if (adminDemographicsService != null) {
			status = adminDemographicsService.insertDemographics(status);
		}
		return status;
	}
	
}
