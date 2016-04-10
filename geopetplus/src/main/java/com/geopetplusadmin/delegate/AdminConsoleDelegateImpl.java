package com.geopetplusadmin.delegate;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.service.AdminConsoleService;
import com.geopetplusadmin.service.FacilityDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class AdminConsoleDelegateImpl implements AdminConsoleDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(AdminConsoleDelegateImpl.class);
	
	public ArrayList<FacilityDemographicsDO> getPendingFacilitiesList() throws DelegateException {
		
		LOGGER.info("Invoked AdminConsoleDelegateImpl.java # getPendingFacilities() method");
		ArrayList<FacilityDemographicsDO> pendingFacilities = new ArrayList<FacilityDemographicsDO>();
		try {
			AdminConsoleService adminConsoleService = (AdminConsoleService) SpringServiceFactory.getBean("adminConsoleService");
			if (adminConsoleService != null) {
				pendingFacilities = adminConsoleService.getPendingFacilities();
			}
		}
		catch (ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited AdminConsoleDelegateImpl.java # getPendingFacilities() method");
		
		return pendingFacilities;
	}
	
	public FacilityDemographicsVO getFacilityInfo(String facilityid) throws DelegateException {
		
		LOGGER.info("Invoked AdminConsoleDelegateImpl.java # getFacilityInfo(String facilityid) method");
		FacilityDemographicsVO facilityInfo = null;
		try {
			AdminConsoleService adminConsoleService = (AdminConsoleService) SpringServiceFactory.getBean("adminConsoleService");
			if (adminConsoleService != null) {
				facilityInfo = adminConsoleService.getFacilityInfo(facilityid);
			}
			
			LOGGER.info("Exited AdminConsoleDelegateImpl.java # getFacilityInfo(String facilityid) method");
			return facilityInfo;
		}
		catch (ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
			
	}

}
