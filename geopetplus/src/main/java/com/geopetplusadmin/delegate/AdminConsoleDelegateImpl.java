package com.geopetplusadmin.delegate;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.service.AdminConsoleService;
import com.geopetplusadmin.service.FacilityDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class AdminConsoleDelegateImpl implements AdminConsoleDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(AdminConsoleDelegateImpl.class);
	
	public ArrayList<FacilityDemographicsVO> getPendingFacilitiesList() throws DelegateException {
		
		LOGGER.info("Invoked AdminConsoleDelegateImpl.java # getPendingFacilities() method");
		ArrayList<FacilityDemographicsVO> pendingFacilities = new ArrayList<FacilityDemographicsVO>();
		try {
			AdminConsoleService adminConsoleService = (AdminConsoleService) SpringServiceFactory.getBean("adminConsoleService");
			if (adminConsoleService != null) {
				pendingFacilities = adminConsoleService.getPendingFacilities();
			}
			/*pendingFacilities.add("Fac1");
			pendingFacilities.add("Fac2");
			pendingFacilities.add("Fac3");
			pendingFacilities.add("Fac4");
			pendingFacilities.add("Fac5");*/
			
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

}
