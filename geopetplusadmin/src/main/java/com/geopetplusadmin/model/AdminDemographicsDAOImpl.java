package com.geopetplusadmin.model;

import java.math.BigInteger;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.geopetplusadmin.exception.DAOException;

import com.geopetplusadmin.hibernate.admin.AdminDemographicsDO;
import com.geopetplusadmin.hibernate.admin.LoginDO;
import com.geopetplusadmin.hibernate.admin.TransactionServicesDO;

public class AdminDemographicsDAOImpl extends HibernateDaoSupport implements AdminDemographicsDAO {
	
	private final static Logger LOGGER = Logger.getLogger(AdminDemographicsDAOImpl.class);
	
	@Override
	@Transactional(readOnly = false)
	public String saveAdminDemographics(AdminDemographicsDO adminDemographicsDO) throws DAOException {
		try {
	        this.getHibernateTemplate().saveOrUpdate(adminDemographicsDO);
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		return "Inserted into AdminDemographics!";
	}
	
	@Override
	public void saveLoginInfo(LoginDO loginDO) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdate(loginDO);
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public void saveServiceInfo(TransactionServicesDO serviceDO) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdate(serviceDO);
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getAdminId() throws DAOException {
		String getadminid = "";
		final String nativesql = "select max(adminid) from admindemographics";
		try{

			getadminid = (String) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {								
					SQLQuery sqlQuery = session.createSQLQuery(nativesql);
					return sqlQuery.uniqueResult();
				}});
			
			if(getadminid == null) {
				getadminid = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).concat("0001");
			}
			else {
			//	String adminPrefix = getadminid.substring(0, 1);
				String adminNumber = getadminid.substring(4);
				int adminNumeric;
				if (adminNumber.equals(" ")) {
					adminNumeric = 0000;
				}
				else 
				{
					adminNumeric = Integer.parseInt(adminNumber);
				}
				adminNumeric = adminNumeric + 1; 
				String formatted = String.format("%04d", adminNumeric);
				getadminid = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).concat(formatted);
			}
			
			return getadminid;
		} catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getServiceId(final String serviceName) throws DAOException {
		String serviceid = "";
		final String nativesql = "select serviceid from services where servicename= :servicename";
		try{
			serviceid = (String) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {								
					SQLQuery sqlQuery = session.createSQLQuery(nativesql);
					sqlQuery.setParameter("servicename", serviceName);
					return sqlQuery.uniqueResult();
				}});
		} catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		return serviceid;
	}
	
}
