package com.geopetplusadmin.delegate;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.service.AdminDemographicsService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.AdminDemographicsVO;

public class AdminDemographicsDelegateImpl implements AdminDemographicsDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(AdminDemographicsDelegateImpl.class);
	
	public String saveAdminDemographics(AdminDemographicsVO adminDemographicsVO) throws DelegateException {
		String status = null;
		LOGGER.info("Invoked AdminDemographicsDelegateImpl.java # saveAdminDemographics(AdminDemographicsVO) method");
		try {
			
			AdminDemographicsService adminDemographicsService = (AdminDemographicsService) SpringServiceFactory.getBean("adminDemographicService");
			if (adminDemographicsService != null && adminDemographicsVO != null) {
				status = adminDemographicsService.saveAdminDemographics(adminDemographicsVO);
			}
		}
		catch (ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited AdminDemographicsDelegateImpl.java # saveAdminDemographics(AdminDemographicsVO) method");
		
		return status;
	}
}
