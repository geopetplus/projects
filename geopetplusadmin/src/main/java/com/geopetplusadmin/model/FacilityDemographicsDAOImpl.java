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

public class FacilityDemographicsDAOImpl extends HibernateDaoSupport implements FacilityDemographicsDAO {
	
	private final static Logger LOGGER = Logger.getLogger(FacilityDemographicsDAOImpl.class);
	
	@Override
	@Transactional(readOnly = false)
	public void saveFacilityDemographics(FacilityDemographicsDO facilityDemographicsDO) throws DAOException {
		try {
	        this.getHibernateTemplate().saveOrUpdate(facilityDemographicsDO);
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
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
	
	@Override
	public void saveFacilityTermInfo(FacilityTermDO facilityTermDO) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdate(facilityTermDO);
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public void saveTransactionSummaryInfo(TransactionSummaryDO transactionSummaryDO) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdate(transactionSummaryDO);
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}
	
	@Override
	public void saveAuditInfo(AuditDO auditDO) throws DAOException {
		try {
			this.getHibernateTemplate().saveOrUpdate(auditDO);
		} catch(Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getFacilityId(final String facilityid) throws DAOException {
		String getfacilityid = "";
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
		}
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BigInteger getSequence(final String sequenceName) throws DAOException {
		final BigInteger value;
		final String getsql = "select value from getsequence where name = :sequenceName";
		final String updatesql = "update getsequence set value = :nextvalue where name = :sequenceName";
		try{
			value = (BigInteger) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {								
					SQLQuery sqlQuery = session.createSQLQuery(getsql);
					sqlQuery.setParameter("sequenceName", sequenceName);
					return sqlQuery.uniqueResult();
				}});
			
			this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {								
					SQLQuery sqlQuery = session.createSQLQuery(updatesql);
					sqlQuery.setParameter("nextvalue", value.add(BigInteger.ONE));
					sqlQuery.setParameter("sequenceName", sequenceName);
					sqlQuery.executeUpdate();
					return null;
				}});
			return value;
			
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
