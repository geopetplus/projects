package com.geopetplusadmin.model;

import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface LoginDAO {
	public String insertLogin(LoginDO loginDO) throws Exception;
}
