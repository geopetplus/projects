package com.geopetplusadmin.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.domain.utility.CommonUtils;
import com.geopetplusadmin.domain.utility.TranformationUtils;
import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.exception.ServiceException;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.model.LoginDAO;
import com.geopetplusadmin.model.LoginDAOImpl;
import com.geopetplusadmin.vo.LoginVO;

public class LoginServiceImpl implements LoginService {
	
	private final static Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
	
	LoginDAO loginDAO;
	
	@Transactional(readOnly = false)
	public String verifyLogin(LoginVO loginVO) throws ServiceException {
		String status;
		try {
			LOGGER.info("Start verifying Login");
			status = loginDAO.verifyLogin(loginVO.getLoginid(), loginVO.getPassword());
		
			//LOGGER.info("New Facility ID created "+facilityid);
				
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
		return status;
	}
	
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(
			LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
}
