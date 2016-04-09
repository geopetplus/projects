package com.hcl.spring.tree;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.hcl.vo.TreeVO;

@Ignore
@ContextConfiguration( locations = {"classpath*:**/spring.xml"} )
public class TreeTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private TreeService treeService;
	
	@Ignore
	public void testSaveTree() {
		
		TreeVO treeVO = new TreeVO("3", "Neem Tree", true);
		
		try {
			
			// Saving Tree 
			if (this.treeService != null) {
				this.treeService.saveTree(treeVO);
			}
		}
		catch(Exception exception) {
			
			System.out.println("Exception : " + exception.getCause());
			exception.printStackTrace();
		}
		
		assertTrue(Boolean.TRUE);
	}
	
	@Ignore
	public void testGetTrees() {
		
		List<TreeVO> listTrees = null;
		
		try {
		
			// Retrieving Trees
			if (this.treeService != null) {
				
				listTrees = this.treeService.getAllTrees();
				
				if (listTrees != null && listTrees.size() > 0) {
					
					for (TreeVO tree : listTrees) {
						System.out.println(tree.getTreeNo() + " <-->" + tree.getTreeName());
					}
				}
			}
		}
		catch(Exception exception) {
			System.out.println("Exception : " + exception.getCause());
			exception.printStackTrace();
		}
		
		assertTrue(listTrees.size()>0);
	}
	
	@Ignore
	public void testGetTree() {
		
		String treeName = null;
		
		try {
		
			// Retrieving Trees
			if (this.treeService != null) {
				
				treeName = this.treeService.getTree("1");
			}
		}
		catch(Exception exception) {
			System.out.println("Exception : " + exception.getCause());
			exception.printStackTrace();
		}
		
		assertTrue(treeName != null);
	}
	
}


