package com.geopetplusadmin.delegate;

import org.apache.log4j.Logger;

import com.geopetplusadmin.service.LoginService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.LoginVO;

public class LoginDelegateImpl implements LoginDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(LoginDelegateImpl.class);
	
	public String insertLogin(LoginVO loginVO) throws Exception {
		
		LOGGER.info("Invoked LoginDelegateImpl.java # insertLogin(LoginVO) method");
		
		String status = null;		
		LoginService loginService = (LoginService) SpringServiceFactory.getBean("loginService");
		if (loginService != null) {
			status = loginService.insertLogin(loginVO);
		}
		
		LOGGER.info("Exited LoginDelegateImpl.java # insertLogin(LoginVO) method");
		
		return status;
	}
	
}
