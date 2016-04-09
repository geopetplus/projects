package com.hcl.hibernate.domains;

public class TreeDO {

	private int treeNo;
	private String treeName;
	
	public TreeDO() {
	}

	public TreeDO(int treeNo, String treeName) {
		this.treeNo = treeNo;
		this.treeName = treeName;
	}

	public int getTreeNo() {
		return treeNo;
	}

	public void setTreeNo(int treeNo) {
		this.treeNo = treeNo;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
}
