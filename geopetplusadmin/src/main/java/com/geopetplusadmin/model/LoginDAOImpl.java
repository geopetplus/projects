package com.geopetplusadmin.model;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.exception.DAOException;
import com.geopetplusadmin.hibernate.admin.AuditDO;
import com.geopetplusadmin.hibernate.admin.FacilityDemographicsDO;
import com.geopetplusadmin.hibernate.admin.FacilityTermDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;
import com.geopetplusadmin.hibernate.admin.TransactionSummaryDO;

public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {
	
	private final static Logger LOGGER = Logger.getLogger(LoginDAOImpl.class);
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String verifyLogin(final String loginid, String password) throws DAOException  {
		String result = "";
		final String nativesql = "select password from login where userid = :loginid";
		try{
			result = (String) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {								
					SQLQuery sqlQuery = session.createSQLQuery(nativesql);
					sqlQuery.setParameter("loginid", loginid);
					return sqlQuery.uniqueResult();
				}});
			
			if(result == null) {
				result = "notfound";
			}
			else if (result.equals(password)) {
				result = "matched";
			}
			else {
				result = "notmatched";
			}
			
			return result;
		} catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}

	@Override
	public void verify(LoginDO loginDO) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	
	
}

