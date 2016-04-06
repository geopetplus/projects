package com.geopetplusadmin.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.model.AdminConsoleDAO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class AdminConsoleServiceImpl implements AdminConsoleService {
	
	private final static Logger LOGGER = Logger.getLogger(AdminConsoleServiceImpl.class);
	
	AdminConsoleDAO adminConsoleDAO;
	
	@Transactional(readOnly = false)
	public ArrayList<FacilityDemographicsVO> getPendingFacilities() throws ServiceException {
		
		try {
			LOGGER.info("Start getting pending facilities list");
			adminConsoleDAO.getPendingFacilities();
			return adminConsoleDAO.getPendingFacilities();
		}
		catch (DAOException exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		catch (NullPointerException npe) {
			throw new ServiceException(npe.getMessage(), npe);
		}
		catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
	}

	public AdminConsoleDAO getAdminConsoleDAO() {
		return adminConsoleDAO;
	}

	public void setAdminConsoleDAO(AdminConsoleDAO adminConsoleDAO) {
		this.adminConsoleDAO = adminConsoleDAO;
	}

}
