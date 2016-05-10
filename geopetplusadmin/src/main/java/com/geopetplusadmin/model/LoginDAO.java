package com.geopetplusadmin.model;

import java.math.BigInteger;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.LoginDO;

public interface LoginDAO {
	
	public void verify(LoginDO loginDO) throws DAOException;

	public String verifyLogin(final String loginid, String password) throws DAOException;
	 
	
}
