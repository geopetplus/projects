package com.geopetplusadmin.service;

import java.sql.Timestamp;

import com.geopetplusadmin.domain.utility.CommonUtils;
import com.geopetplusadmin.domain.utility.TranformationUtils;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.model.LoginDAO;
import com.geopetplusadmin.vo.LoginVO;

public class LoginServiceImpl implements LoginService {

	LoginDAO loginDAO;
	
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public String insertLogin(LoginVO loginVO) throws Exception {
		
		CommonUtils getFacilityId = new CommonUtils();
		String facilityId = getFacilityId.generateFacilityId("facilityName", "facilityOwner");
		
		/*LoginDO loginEntries = new LoginDO();
		loginEntries.setFacilityid(facilityId);
		loginEntries.setVersionid("V001");
		loginEntries.setUserid(facilityId);
		loginEntries.setPassword("pass1");
		loginEntries.setLastupdated(new Timestamp(System.currentTimeMillis()));
		loginEntries.setRole("Owner");
		loginEntries.setStatus("IA");
		loginEntries.setAuditid("Aud001");*/
		
		LoginDO loginDO = TranformationUtils.transformLoginVO(loginVO);
		
		return loginDAO.insertLogin(loginDO);
	}

}
