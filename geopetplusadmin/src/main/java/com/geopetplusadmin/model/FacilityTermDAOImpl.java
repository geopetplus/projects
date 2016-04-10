package com.geopetplusadmin.model;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;

public class FacilityTermDAOImpl extends HibernateDaoSupport  implements FacilityTermDAO {

	private final static Logger LOGGER = Logger.getLogger(FacilityDemographicsDAOImpl.class);
	
	@Transactional(readOnly = false)
	public String insertFacilityTerm(FacilityDemographicsDO facilityDemographicsDO) throws DAOException {
		
		return null;
	}

}
