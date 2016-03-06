package com.geopetplusadmin.delegate;

import com.geopetplusadmin.service.LoginService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.LoginVO;

public class LoginDelegateImpl implements LoginDelegate {
	
	public String insertLogin(LoginVO loginVO) throws Exception {
		String status = null;		
		LoginService loginService = (LoginService) SpringServiceFactory.getBean("loginService");
		if (loginService != null) {
			status = loginService.insertLogin(loginVO);
		}
		return status;
	}
	
}
