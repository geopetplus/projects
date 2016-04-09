package com.hcl.hibernate.tree;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.exception.DAOException;
import com.hcl.hibernate.domains.TreeDO;

public class TreeDAOImpl extends HibernateDaoSupport implements TreeDAO {
	
	private final static Logger LOGGER = Logger.getLogger(TreeDAOImpl.class);
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<TreeDO> getTrees() throws DAOException {
		
		LOGGER.info("Invoked TreeDAOImpl.java # getTrees() method");
		
		List<TreeDO> listTrees = null;
		
		try {
			String hqlQuery = "from TreeDO";
			listTrees = (List<TreeDO>) this.getHibernateTemplate().find(hqlQuery);
		}
		catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeDAOImpl.java # getTrees() method");
		
		return listTrees;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<TreeDO> getAllTrees() throws DAOException {
		
		LOGGER.info("Invoked TreeDAOImpl.java # getAllTrees() method");
		
		List<TreeDO> listTrees = null;
		
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(TreeDO.class);
			listTrees = (List<TreeDO>) this.getHibernateTemplate().findByCriteria(criteria);
		}
		catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeDAOImpl.java # getAllTrees() method");
		
		return listTrees;
	}

	@Transactional(readOnly = false)
	public String saveTree(TreeDO tree) throws DAOException {
		
		LOGGER.info("Invoked TreeDAOImpl.java # saveTree() method");
		
		String status = "failure";
		
		try {
			
			if (tree != null) {
				this.getHibernateTemplate().save(tree);
				status = "success";
			}
		}
		catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeDAOImpl.java # saveTree() method");
		
		return status;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = false)
	public String getTree(final String treeNo) throws DAOException {
		
		LOGGER.info("Invoked TreeDAOImpl.java # getTree(String) method");
		
		String treeName = null;
		final String nativeSql = "select treename from tree where treeno = :treeno";
		
		try {
			
			treeName = (String) this.getHibernateTemplate().execute(new HibernateCallback() {
				
			public Object doInHibernate(Session session) throws HibernateException {
						
				SQLQuery sqlQuery = session.createSQLQuery(nativeSql);
				sqlQuery.setParameter("treeno", treeNo);
				
				return sqlQuery.uniqueResult();
			}});
			
			System.out.println("TreeName : " + treeName);
		}
		catch (Throwable exception) {
			throw new DAOException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeDAOImpl.java # getTree(String) method");
		
		return treeName;
	}
}
