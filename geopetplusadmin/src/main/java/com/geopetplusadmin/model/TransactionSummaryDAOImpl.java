package com.geopetplusadmin.model;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;

public class TransactionSummaryDAOImpl extends HibernateDaoSupport  implements TransactionSummaryDAO {

	@Transactional(readOnly = false)
	public String insertFacilitySummary(FacilityDemographicsDO facilityDemographicsDO) throws DAOException {
		
		return null;
	}

}
