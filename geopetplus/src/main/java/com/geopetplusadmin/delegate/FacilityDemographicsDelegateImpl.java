package com.geopetplusadmin.delegate;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.service.FacilityDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class FacilityDemographicsDelegateImpl implements FacilityDemographicsDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(FacilityDemographicsDelegateImpl.class);
	
	public void saveFacilityDemographics(FacilityDemographicsVO facilityDemographicsVO) throws DelegateException {
		LOGGER.info("Invoked FacilityDemographicsDelegateImpl.java # saveFacilityDemographics(FacilityDemographicsVO) method");
		try {
			
			FacilityDemographicsService facilityDemographicsService = (FacilityDemographicsService) SpringServiceFactory.getBean("facilityDemographicService");
			if (facilityDemographicsService != null && facilityDemographicsVO != null) {
				facilityDemographicsService.saveFacilityDemographics(facilityDemographicsVO);
			}
		}
		catch (ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		LOGGER.info("Exited FacilityDemographicsDelegateImpl.java # saveFacilityDemographics(FacilityDemographicsVO) method");		
	}
}
