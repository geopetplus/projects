package com.hcl.hibernate.tree;

import java.util.List;

import com.hcl.exception.DAOException;
import com.hcl.hibernate.domains.TreeDO;

public interface TreeDAO {

	public List<TreeDO> getTrees() throws DAOException;
	
	public List<TreeDO> getAllTrees() throws DAOException;
	
	public String saveTree(TreeDO tree) throws DAOException;
	
	public String getTree(String treeNo) throws DAOException;
}
