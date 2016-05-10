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

import com.geopetplusadmin.hibernate.admin.AdminDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;
import com.geopetplusadmin.hibernate.admin.TransactionSummaryDO;
import com.geopetplusadmin.model.AdminDemographicsDAO;
import com.geopetplusadmin.model.AdminDemographicsDAOImpl;
import com.geopetplusadmin.vo.AdminDemographicsVO;

public class AdminDemographicsServiceImpl implements AdminDemographicsService {
	
	private final static Logger LOGGER = Logger.getLogger(AdminDemographicsServiceImpl.class);
	
	AdminDemographicsDAO adminDemographicsDAO;
	
	@Transactional(readOnly = false)
	public String saveAdminDemographics(AdminDemographicsVO adminDemographicsVO) throws ServiceException {
		
		try {
			AdminDemographicsDO adminDemographicsDO = TranformationUtils.transformAdminDemographicsVO(adminDemographicsVO);
		 	AdminDemographicsDO demographicData = new AdminDemographicsDO();
			String adminid = adminDemographicsDAO.getAdminId();
	
			String versionid = "01";
			String auditid = adminid.concat(String.valueOf(Calendar.getInstance().get(Calendar.MONTH))).
					concat(String.valueOf(Calendar.getInstance().get(Calendar.DATE))).
					concat(String.valueOf(Calendar.getInstance().get(Calendar.YEAR))).
					concat(String.valueOf(Calendar.getInstance().get(Calendar.HOUR))).
					concat(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE))).
					concat(String.valueOf(Calendar.getInstance().get(Calendar.SECOND)));
			
			//Insert login records
			LoginDO loginData = new LoginDO();
			loginData.setFacilityid(adminid);
			loginData.setVersionid(versionid);
			loginData.setUserid(adminid);
			loginData.setPassword(adminDemographicsDO.getAdminLastName().substring(0,3).
					concat(adminDemographicsDO.getAdminFirstName().substring(0,3)));
			
			
			loginData.setLastupdated(CommonUtils.getCurrentDate());
			loginData.setRole("Admin");
			loginData.setStatus("A");
			loginData.setAuditid(auditid);
	        	
	        adminDemographicsDAO.saveLoginInfo(loginData);
			
	        
	      //Insert demographic records
	    //    AdminDemographicsDO demographicData = new AdminDemographicsDO();
	        demographicData.setAdminid(adminid);
	        demographicData.setAdminFirstName(adminDemographicsDO.getAdminFirstName());
	        demographicData.setAdminLastName(adminDemographicsDO.getAdminLastName());
	        demographicData.setMailAddr1(adminDemographicsDO.getMailAddr1());
	        demographicData.setMailAddr2(adminDemographicsDO.getMailAddr2());
	        demographicData.setMailingLocation(adminDemographicsDO.getMailingLocation());
	        demographicData.setMailingCity(adminDemographicsDO.getMailingCity());
	        demographicData.setMailingState(adminDemographicsDO.getMailingState());
	        demographicData.setMailingPincode(adminDemographicsDO.getMailingPincode());
	        demographicData.setAdminPhone(adminDemographicsDO.getAdminPhone());
	        demographicData.setAdminAltContact(adminDemographicsDO.getAdminAltContact());
	        demographicData.setAdminMobileNum(adminDemographicsDO.getAdminMobileNum());
	        demographicData.setAdminEmail(adminDemographicsDO.getAdminEmail());
	        demographicData.setAdminRegStartDate(CommonUtils.getCurrentDate());
	        demographicData.setAdminRegEndDate(CommonUtils.getCurrentDate());
	        demographicData.setLastUpdateDate(CommonUtils.getCurrentDate());
	        demographicData.setStatus("A");
	        demographicData.setAuditID(auditid);
	        
	        return  adminDemographicsDAO.saveAdminDemographics(demographicData);
		
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
	}
		
	
	public AdminDemographicsDAO getAdminDemographicsDAO() {
		return adminDemographicsDAO;
	}

	public void setAdminDemographicsDAO(
			AdminDemographicsDAO adminDemographicsDAO) {
		this.adminDemographicsDAO = adminDemographicsDAO;
	}




	
}
