package com.geopetplusadmin.domain.utility;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

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
	
	public static FacilityDemographicsVO transformFacilityDemographicsDO(FacilityDemographicsDO facilityDemographicsDO) throws Exception {
		
		LOGGER.info("Start TranformationUtils.java # transformFacilityDemographicsDO(FacilityDemographicsDO) method");
		
		FacilityDemographicsVO facilityDemographicsVO = null;
		
		if (facilityDemographicsDO != null) {
			facilityDemographicsVO = new FacilityDemographicsVO();
			BeanUtils.copyProperties(facilityDemographicsVO, facilityDemographicsDO);
		}
		
		LOGGER.info("End TranformationUtils.java # transformFacilityDemographicsDO(FacilityDemographicsDO) method");
		
		return facilityDemographicsVO;
	}
}
