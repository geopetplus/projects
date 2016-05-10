package com.geopetplusadmin.domain.utility;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.AdminDemographicsDO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;
import com.geopetplusadmin.vo.AdminDemographicsVO;

public class TranformationUtils {
	
	private final static Logger LOGGER = Logger.getLogger(TranformationUtils.class);
	
	public static FacilityDemographicsDO transformFacilityDemographicsVO(FacilityDemographicsVO facilityDemographicsVO) throws Exception {
		
		LOGGER.info("Start TranformationUtils.java # transformFacilityDemographicsVO(FacilityDemographicsVO) method");
		
		FacilityDemographicsDO facilityDemographicsDO = null;
		
		if (facilityDemographicsVO != null) {
			facilityDemographicsDO = new FacilityDemographicsDO();
			BeanUtils.copyProperties(facilityDemographicsDO, facilityDemographicsVO);
		}
		
		LOGGER.info("End TranformationUtils.java # transformFacilityDemographicsVO(FacilityDemographicsVO) method");
		
		return facilityDemographicsDO;
	}	
	
	
	public static AdminDemographicsDO transformAdminDemographicsVO(AdminDemographicsVO adminDemographicsVO) throws Exception {
		AdminDemographicsDO adminDemographicsDO = null;
		if (adminDemographicsVO != null) {
			adminDemographicsDO = new AdminDemographicsDO();
			BeanUtils.copyProperties(adminDemographicsDO, adminDemographicsVO);
		}
		return adminDemographicsDO;
	}
}
