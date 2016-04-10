package com.geopetplusadmin.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.domain.utility.CommonUtils;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;

public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {

	private static String facilityId;
	
	@Transactional(readOnly = false)
	public String insertLogin(LoginDO loginDO) throws Exception {
		
		/*CommonUtils getFacilityId = new CommonUtils();
		facilityId = getFacilityId.generateFacilityId("facilityName", "facilityOwner");
		
		LoginDO loginEntries = new LoginDO();
		loginEntries.setFacilityid(facilityId);
		loginEntries.setVersionid("V001");
		loginEntries.setUserid(facilityId);
		loginEntries.setPassword("pass1");
		loginEntries.setLastupdated(new Timestamp(System.currentTimeMillis()));
		loginEntries.setRole("Owner");
		loginEntries.setStatus("IA");
		loginEntries.setAuditid("Aud001");*/
		
		//this.getHibernateTemplate().saveOrUpdate(loginDO);		
	
		return facilityId;
	}

	public static String getFacilityId() {
		return facilityId;
	}

	public static void setFacilityId(String facilityId) {
		LoginDAOImpl.facilityId = facilityId;
	}

}
