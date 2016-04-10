package com.geopetplusadmin.delegate;

import java.util.ArrayList;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface AdminConsoleDelegate {
	public ArrayList<FacilityDemographicsDO> getPendingFacilitiesList() throws DelegateException;
	public FacilityDemographicsVO getFacilityInfo(String facilityid) throws DelegateException;
}
