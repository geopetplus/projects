package com.geopetplusadmin.domain.utility;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class CommonUtils {
	
	private final static Logger LOGGER = Logger.getLogger(CommonUtils.class);
	
	public static String generateFacilityId(String facilityName) {
		LOGGER.info("Invoked CommonUtils.java # generateFacilityId(String, String) method");
		String facilityId = facilityName.substring(0, 5).toUpperCase();
		LOGGER.info("Exited CommonUtils.java # generateFacilityId(String, String) method");
		return facilityId;
	}
	
	public static Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
		
}
