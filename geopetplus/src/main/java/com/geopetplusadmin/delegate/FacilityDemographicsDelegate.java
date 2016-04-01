package com.geopetplusadmin.delegate;

import com.geopetplusadmin.exception.DelegateException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public interface FacilityDemographicsDelegate {
	public String saveFacilityDemographics(FacilityDemographicsVO facilityDemographicsVO) throws DelegateException;
}
