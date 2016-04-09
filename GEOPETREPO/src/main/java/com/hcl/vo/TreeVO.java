package com.hcl.vo;

public class TreeVO {

	private String treeNo;
	private String treeName;
	private boolean plant;
	
	public TreeVO() {
	}

	public TreeVO(String treeNo, String treeName, boolean plant) {
		super();
		this.treeNo = treeNo;
		this.treeName = treeName;
		this.plant = plant;
	}

	public String getTreeNo() {
		return treeNo;
	}

	public void setTreeNo(String treeNo) {
		this.treeNo = treeNo;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

	public boolean isPlant() {
		return plant;
	}

	public void setPlant(boolean plant) {
		this.plant = plant;
	}
	
}
