package com.geopetplusadmin.service;

import com.geopetplusadmin.domain.utility.TranformationUtils;
import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.model.FacilityDemographicsDAO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class FacilityDemographicsServiceImpl implements FacilityDemographicsService {
	
	FacilityDemographicsDAO facilityDemographicsDAO;
	
	public FacilityDemographicsDAO getFacilityDemographicsDAO() {
		return facilityDemographicsDAO;
	}

	public void setFacilityDemographicsDAO(
			FacilityDemographicsDAO facilityDemographicsDAO) {
		this.facilityDemographicsDAO = facilityDemographicsDAO;
	}
	
	public String insertDemographics(FacilityDemographicsVO facilityDemographicsVO) throws ServiceException {
		
		try {
			FacilityDemographicsDO facilityDemographicsDO = TranformationUtils.transformFacilityDemographicsVO(facilityDemographicsVO);
			return facilityDemographicsDAO.insertDemographics(facilityDemographicsDO);
		}
		catch (DAOException exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
	
}
