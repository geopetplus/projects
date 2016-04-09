package com.hcl.delegate;

import java.util.List;

import com.hcl.exception.DelegateException;
import com.hcl.vo.TreeVO;

public interface TreeDelegate {

	public List<TreeVO> getTrees() throws DelegateException;
	
	public String saveTree(TreeVO treeVO) throws DelegateException;
}
