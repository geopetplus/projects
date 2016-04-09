package com.hcl.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.hcl.delegate.TreeDelegate;
import com.hcl.delegate.TreeDelegateImpl;
import com.hcl.exception.DelegateException;
import com.hcl.vo.TreeVO;

@ManagedBean(name = "treeBean", eager = true)
@SessionScoped
public class TreeBean {
	
	private final static Logger LOGGER = Logger.getLogger(TreeBean.class);
	
	private TreeVO treeVO;
	
	public TreeBean() {
	}

	public TreeVO getTreeVO() {
		
		if (this.treeVO == null) {
			this.treeVO = new TreeVO();
		}
		
		return this.treeVO;
	}

	public void setTreeVO(TreeVO treeVO) {
		this.treeVO = treeVO;
	}

	public String saveTree() throws Exception {
		
		LOGGER.info("Invoked TreeBean.java # saveTree() method");
		
		LOGGER.info("Tree No : " + this.treeVO.getTreeNo());
		LOGGER.info("Tree Name : " + this.treeVO.getTreeName());
		LOGGER.info("Plant : " + this.treeVO.isPlant());
		
		String status = "failure";
		
		try {
		
			TreeDelegate treeDelegate = new TreeDelegateImpl();
			
			if (treeDelegate != null 
					&& this.treeVO != null) {
				
				status = treeDelegate.saveTree(this.treeVO);
			}
		}
		catch(DelegateException exception) {
			status = "failure";
			System.out.println("Exception : " + exception.getCause());
			exception.printStackTrace();
		}
		
		LOGGER.info("Exited TreeBean.java # saveTree() method");
		
		return status;
	}
	
}

