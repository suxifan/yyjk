package com.cictec.yyjk.commons.utils;

import java.io.Serializable;

public class BaseTreeNode implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = -7959637470919292378L;
	/**
	 * 时间原因，现实现简单的
	 */
	private String id;// 树节点id
	private String pId;// 树父节点id
	private String name;// 树节点id
	boolean checked; // 节点是否被选中
	boolean open;// 节点是否打开
    private String levelsType; //节点值
    
	public BaseTreeNode() {
		super();

	}

	public BaseTreeNode(String id, String name, String pId) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getLevelsType() {
		return levelsType;
	}

	public void setLevelsType(String levelsType) {
		this.levelsType = levelsType;
	}



     
	
}
