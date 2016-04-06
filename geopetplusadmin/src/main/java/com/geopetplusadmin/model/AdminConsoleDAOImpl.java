package com.geopetplusadmin.model;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.vo.FacilityDemographicsVO;

public class AdminConsoleDAOImpl extends HibernateDaoSupport implements AdminConsoleDAO {
	
	private final static Logger LOGGER = Logger.getLogger(AdminConsoleDAOImpl.class);
	
	@Override
	@Transactional(readOnly = false)
	public ArrayList<FacilityDemographicsVO> getPendingFacilities() throws DAOException {
		ArrayList<FacilityDemographicsVO> pendingFacilities = new ArrayList<FacilityDemographicsVO>();
		try {
			LOGGER.info("Start AdminConsoleDAOImpl.java # getPendingFacilities()");
			
			for(int i=1; i<=10; i++) {
				FacilityDemographicsVO facilityDemographicsVO = new FacilityDemographicsVO();
				facilityDemographicsVO.setFacilityid("FAC100"+i);
				facilityDemographicsVO.setFacilityname("Mahalakshmi"+i);
				facilityDemographicsVO.setMailingLocation("Bangalore"+i);
				facilityDemographicsVO.setMailingState("KA");
				facilityDemographicsVO.setFacilyMobileNum("111111111"+i);
				
				pendingFacilities.add(facilityDemographicsVO);
			}
			
	        //this.getHibernateTemplate().saveOrUpdate(facilityDemographicsDO);
			/*String getfacilityid = "";
			final String nativesql = "select facilityid from login where facilityid like :facilityid order by facilityid desc limit 1";
			try{
				getfacilityid = (String) this.getHibernateTemplate().execute(new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException {								
						SQLQuery sqlQuery = session.createSQLQuery(nativesql);
						sqlQuery.setParameter("facilityid", "%" + facilityid + "%");
						return sqlQuery.uniqueResult();
					}});
				
				if(getfacilityid == null) {
					getfacilityid = "empty";
				}
				return getfacilityid;
			} catch (Throwable exception) {
				throw new DAOException(exception.getMessage(), exception);
			}*/
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
        return pendingFacilities;
	}
}
