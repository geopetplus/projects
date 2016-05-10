package com.geopetplusadmin.delegate;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.AdminDemographicsVO;

public interface AdminDemographicsDelegate {
	public String saveAdminDemographics(AdminDemographicsVO adminDemographicsVO) throws DelegateException;
}
