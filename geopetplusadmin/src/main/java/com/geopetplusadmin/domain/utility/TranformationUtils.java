package com.geopetplusadmin.domain.utility;

import org.apache.commons.beanutils.BeanUtils;

import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.vo.AuditVO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;
import com.geopetplusadmin.vo.LoginVO;

public class TranformationUtils {

	public static LoginDO transformLoginVO(LoginVO loginVO) throws Exception {
		LoginDO loginDO = null;
		if (loginVO != null) {
			loginDO = new LoginDO();
			BeanUtils.copyProperties(loginDO, loginVO);
		}
		return loginDO;
	}
	
	public static FacilityDemographicsDO transformFacilityDemographicsVO(FacilityDemographicsVO facilityDemographicsVO) throws Exception {
		FacilityDemographicsDO facilityDemographicsDO = null;
		if (facilityDemographicsVO != null) {
			facilityDemographicsDO = new FacilityDemographicsDO();
			BeanUtils.copyProperties(facilityDemographicsDO, facilityDemographicsVO);
		}
		return facilityDemographicsDO;
	}
	
	public static AuditDO transformAuditVO(AuditVO auditVO) throws Exception {
		AuditDO auditDO = null;
		if (auditVO != null) {
			auditDO = new AuditDO();
			BeanUtils.copyProperties(auditDO, auditVO);
		}
		return auditDO;
	}
	
}
