package com.geopetplusadmin.delegate;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.service.LoginService;
import com.geopetplusadmin.spring.utility.SpringServiceFactory;
import com.geopetplusadmin.vo.LoginVO;

public class LoginDelegateImpl implements LoginDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(LoginDelegateImpl.class);
	
	public String verifyLogin(LoginVO loginVO) throws DelegateException {
		
		String status = "";
		
		LOGGER.info("Invoked LoginDelegateImpl.java # verifyLogin(LoginVO) method");
		try {
			
			
			LoginService loginService = (LoginService) SpringServiceFactory.getBean("loginService");
			if (loginService != null && loginVO != null) {
				status = loginService.verifyLogin(loginVO);
				
			}
		}
		catch (ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		LOGGER.info("Exited LoginDelegateImpl.java # verifyLogin(LoginVO) method");
		
		return status;
	}
}
