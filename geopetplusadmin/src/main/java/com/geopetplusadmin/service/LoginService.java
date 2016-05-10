package com.geopetplusadmin.service;

import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.vo.LoginVO;

public interface LoginService {
	public String verifyLogin(LoginVO loginVO) throws ServiceException;
}
