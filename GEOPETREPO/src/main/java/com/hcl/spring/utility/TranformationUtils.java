package com.hcl.spring.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.hcl.hibernate.domains.TreeDO;
import com.hcl.vo.TreeVO;

public class TranformationUtils {
	
	private final static Logger LOGGER = Logger.getLogger(TranformationUtils.class);

	public static TreeDO transformTreeVO(TreeVO treeVO) throws Exception {
		
		LOGGER.info("Invoked TranformationUtils.java # transformTreeVO(TreeVO) method");
		
		TreeDO treeDO = null;
		
		if (treeVO != null) {
			
			treeDO = new TreeDO();
			
			// Transform TreeVO to TreeDO
			BeanUtils.copyProperties(treeDO, treeVO);
		}
		
		LOGGER.info("Exited TranformationUtils.java # transformTreeVO(TreeVO) method");
		
		return treeDO;
	}
	
	public static List<TreeVO> transformListTreeDO(List<TreeDO> listTreeDO) throws Exception {
		
		LOGGER.info("Invoked TranformationUtils.java # transformListTreeDO(List<TreeDO>) method");
		
		List<TreeVO> listTreeVO = null;
		
		if (listTreeDO != null 
				&& listTreeDO.size() > 0) {
			
			listTreeVO = new ArrayList<TreeVO>();
			
			for(TreeDO treeDO : listTreeDO) {
				
				TreeVO treeVO = new TreeVO();
				BeanUtils.copyProperties(treeVO, treeDO);
				listTreeVO.add(treeVO);
			}
		}
		
		LOGGER.info("Exited TranformationUtils.java # transformListTreeDO(List<TreeDO>) method");
		
		return listTreeVO;
	}
	
	@SuppressWarnings("unused")
	public static TreeVO transformTreeDO(TreeDO treeDO) throws Exception {
		
		LOGGER.info("Invoked TranformationUtils.java # transformTreeDO(TreeDO) method");
		
		TreeVO treeVO = null;
		
		if (treeVO != null) {
			
			treeVO = new TreeVO();
			
			// Transform TreeDO to TreeVO
			BeanUtils.copyProperties(treeVO, treeDO);
		}
		
		LOGGER.info("Exited TranformationUtils.java # transformTreeDO(TreeDO) method");
		
		return treeVO;
	}
}
