package com.geopetplusadmin.delegate;

import org.apache.log4j.Logger;

import com.geopetplusadmin.service.AdminDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;

public class AdminDemographicsDelegateImpl implements AdminDemographicsDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(AdminDemographicsDelegateImpl.class);
	
	public String insertDemographics() throws Exception {
		
		LOGGER.info("Invoked AdminDemographicsDelegateImpl.java # insertDemographics() method");
		
		String status = null;		
		AdminDemographicsService adminDemographicsService = (AdminDemographicsService) SpringServiceFactory.getBean("facilityDemographicService");
		if (adminDemographicsService != null) {
			status = adminDemographicsService.insertDemographics(status);
		}
		
		LOGGER.info("Invoked AdminDemographicsDelegateImpl.java # insertDemographics() method");
		
		return status;
	}
	
}
