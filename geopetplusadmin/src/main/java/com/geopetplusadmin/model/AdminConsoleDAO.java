package com.geopetplusadmin.model;

import java.util.ArrayList;

import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface AdminConsoleDAO {
	public ArrayList<FacilityDemographicsDO> getPendingFacilities() throws Exception;
	public FacilityDemographicsDO getFacilityInfo(String facilityid) throws Exception;
}
