package com.geopetplusadmin.delegate;

import java.util.ArrayList;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface AdminConsoleDelegate {
	public ArrayList<FacilityDemographicsVO> getPendingFacilitiesList() throws DelegateException;
}
