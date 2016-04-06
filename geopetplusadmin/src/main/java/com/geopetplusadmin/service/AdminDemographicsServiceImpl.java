package com.geopetplusadmin.service;

import com.geopetplusadmin.model.AdminDemographicsDAO;

public class AdminDemographicsServiceImpl implements AdminDemographicsService {
	
	private static String adminId;
	AdminDemographicsDAO adminDemographicsDAO;
	
	public AdminDemographicsDAO getAdminDemographicsDAO() {
		return adminDemographicsDAO;
	}

	public void setAdminDemographicsDAO(
			AdminDemographicsDAO adminDemographicsDAO) {
		this.adminDemographicsDAO = adminDemographicsDAO;
	}
	
	public static String getAdminId() {
		return adminId;
	}

	public static void setAdminId(String adminId) {
		AdminDemographicsServiceImpl.adminId = adminId;
	}

	public String insertDemographics(String getAdminId) throws Exception {
		adminId = getAdminId;
		return adminDemographicsDAO.insertDemographics(adminId);
	}
	
}
