package com.geopetplusadmin.service;

import java.util.ArrayList;

import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface AdminConsoleService {
	public ArrayList<FacilityDemographicsVO> getPendingFacilities() throws ServiceException;
}
