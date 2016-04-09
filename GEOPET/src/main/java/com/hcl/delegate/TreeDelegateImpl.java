package com.hcl.delegate;

import java.util.List;

import org.apache.log4j.Logger;

import com.hcl.exception.DelegateException;
import com.hcl.exception.ServiceException;
import com.hcl.spring.tree.TreeService;
import com.hcl.spring.utility.SpringServiceFactory;
import com.hcl.vo.TreeVO;

public class TreeDelegateImpl implements TreeDelegate {
	
	private final static Logger LOGGER = Logger.getLogger(TreeDelegateImpl.class);
	
	public List<TreeVO> getTrees() throws DelegateException {
		
		LOGGER.info("Invoked TreeDelegateImpl.java # getTrees() method");
		
		List<TreeVO> listTrees = null;
		
		try {
		
			TreeService treeService = (TreeService) SpringServiceFactory.getBean("treeService");
			
			if (treeService != null) {
				
				listTrees = treeService.getTrees();
			}
		}
		catch(ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch(Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeDelegateImpl.java # getTrees() method");
		
		return listTrees;
	}

	public String saveTree(TreeVO treeVO) throws DelegateException {
		
		LOGGER.info("Invoked TreeDelegateImpl.java # saveTree(treeVO) method");
		
		String status = null;
		
		try {
		
			TreeService treeService = (TreeService) SpringServiceFactory.getBean("treeService");
			
			if (treeService != null) {
				
				status = treeService.saveTree(treeVO);
			}
		}
		catch(ServiceException exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		catch(Exception exception) {
			throw new DelegateException(exception.getMessage(), exception);
		}
		
		LOGGER.info("Exited TreeDelegateImpl.java # saveTree(treeVO) method");
		
		return status;
	}
}
