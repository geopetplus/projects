package com.geopetplusadmin.delegate;

import org.hibernate.service.spi.ServiceException;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.service.FacilityDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class FacilityDemographicsDelegateImpl implements FacilityDemographicsDelegate {
	
	public String insertDemographics(FacilityDemographicsVO facilityDemographicsVO) throws DelegateException {
		
		String status = null;
		
		try {
			
			FacilityDemographicsService facilityDemographicsService = (FacilityDemographicsService) SpringServiceFactory.getBean("facilityDemographicService");
			if (facilityDemographicsService != null) {
				status = facilityDemographicsService.insertDemographics(facilityDemographicsVO);
			}
		}
		catch (ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		
		return status;
	}
}
