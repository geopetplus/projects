package com.geopetplusadmin.model;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class AdminConsoleDAOImpl extends HibernateDaoSupport implements AdminConsoleDAO {
	
	private final static Logger LOGGER = Logger.getLogger(AdminConsoleDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = false)
	public ArrayList<FacilityDemographicsDO> getPendingFacilities() throws DAOException {
		LOGGER.info("Start AdminConsoleDAOImpl.java # getPendingFacilities()");
		
		ArrayList<FacilityDemographicsDO> pendingFacilities = null;
		ArrayList<String> pendingLogin = null;
		DetachedCriteria criteria = null;
				
		try {
			criteria = DetachedCriteria.forClass(LoginDO.class);
			criteria.setProjection(Projections.projectionList().add(Projections.property("facilityid")));
			criteria.add(Restrictions.eq("status", "IA"));
			pendingLogin = (ArrayList<String>) this.getHibernateTemplate().findByCriteria(criteria);
			if(pendingLogin != null && pendingLogin.size() > 0) {
				criteria = DetachedCriteria.forClass(FacilityDemographicsDO.class);
				criteria.add(Restrictions.in("facilityid", pendingLogin));
				pendingFacilities = (ArrayList<FacilityDemographicsDO>) this.getHibernateTemplate().findByCriteria(criteria);
			}
		}
		catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		return pendingFacilities;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional(readOnly = false)
	public FacilityDemographicsDO getFacilityInfo(final String facilityid) throws DAOException {
		LOGGER.info("Start AdminConsoleDAOImpl.java # getFacilityInfo(String facilityid)");
		try {
			return (FacilityDemographicsDO) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {								
					return (FacilityDemographicsDO) session.get(FacilityDemographicsDO.class, facilityid);
				}});
		}
		catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		
	}
}
