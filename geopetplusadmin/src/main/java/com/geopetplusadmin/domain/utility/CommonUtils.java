package com.geopetplusadmin.domain.utility;

import java.util.Calendar;
import java.util.Date;

public class CommonUtils {

	public static String generateFacilityId(String facilityName) {
		String facilityId = facilityName.substring(0, 5).toUpperCase();
		return facilityId;
	}
	
	public static Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
		
}
