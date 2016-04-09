package com.hcl.spring.tree;

import java.util.List;

import com.hcl.exception.ServiceException;
import com.hcl.vo.TreeVO;

public interface TreeService {

	public List<TreeVO> getTrees() throws ServiceException;
	
	public List<TreeVO> getAllTrees() throws ServiceException;
	
	public String saveTree(TreeVO tree) throws ServiceException;
	
	public String getTree(String treeNo) throws ServiceException;
}
