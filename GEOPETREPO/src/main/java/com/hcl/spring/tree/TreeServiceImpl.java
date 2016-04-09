package com.hcl.spring.tree;

import java.util.List;

import com.hcl.exception.DAOException;
import com.hcl.exception.ServiceException;
import com.hcl.hibernate.domains.TreeDO;
import com.hcl.hibernate.tree.TreeDAO;
import com.hcl.spring.utility.TranformationUtils;
import com.hcl.vo.TreeVO;

import org.apache.log4j.Logger;

public class TreeServiceImpl implements TreeService {
	
	private final static Logger LOGGER = Logger.getLogger(TreeServiceImpl.class);
	
	private TreeDAO treeDAO;
	
	public TreeDAO getTreeDAO() {
		return treeDAO;
	}

	public void setTreeDAO(TreeDAO treeDAO) {
		this.treeDAO = treeDAO;
	}

	public List<TreeVO> getTrees() throws ServiceException {
		
		LOGGER.info("Invoked TreeServiceImpl.java # getTrees() method");
		
		List<TreeVO> listTrees = null;
		
		try {
		
			if (this.treeDAO != null) {
				listTrees = TranformationUtils.transformListTreeDO(this.treeDAO.getTrees());
			}
		}
		catch (DAOException exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeServiceImpl.java # getTrees() method");
		
		return listTrees;
	}
	
	public List<TreeVO> getAllTrees() throws ServiceException {
		
		LOGGER.info("Invoked TreeServiceImpl.java # getAllTrees() method");
		
		List<TreeVO> listTrees = null;
		
		try {
		
			if (this.treeDAO != null) {
				listTrees = TranformationUtils.transformListTreeDO(this.treeDAO.getAllTrees());
			}
		}
		catch (DAOException exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeServiceImpl.java # getAllTrees() method");
		
		return listTrees;
	}

	public String saveTree(TreeVO treeVO) throws ServiceException {
		
		LOGGER.info("Invoked TreeServiceImpl.java # saveTree(TreeVO) method");
		
		String status = null;
		
		try {
			
			if (this.treeDAO != null 
					&& treeVO != null) {
				
				TreeDO treeDO = TranformationUtils.transformTreeVO(treeVO);
				status = this.treeDAO.saveTree(treeDO);
			}
		}
		catch (DAOException exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeServiceImpl.java # saveTree(TreeVO) method");
		
		return status;
	}

	@Override
	public String getTree(String treeNo) throws ServiceException {
		
		LOGGER.info("Invoked TreeServiceImpl.java # getTree(String) method");
		
		String treeName = null;
		
		try {
		
			if (this.treeDAO != null) {
				
				treeName = this.treeDAO.getTree(treeNo);
			}
		}
		catch (DAOException exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		catch (Exception exception) {
			throw new ServiceException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeServiceImpl.java # getTree(String) method");
		
		return treeName;
	}
}
