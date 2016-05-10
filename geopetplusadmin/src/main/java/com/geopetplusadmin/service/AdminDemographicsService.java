package com.geopetplusadmin.service;

import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.vo.AdminDemographicsVO;

public interface AdminDemographicsService {
	public String saveAdminDemographics(AdminDemographicsVO adminDemographicsVO) throws ServiceException;
}
