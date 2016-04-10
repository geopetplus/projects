package com.geopetplusadmin.model;

import java.util.ArrayList;

import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface AdminConsoleDAO {
	public ArrayList<FacilityDemographicsVO> getPendingFacilities() throws Exception;
}
