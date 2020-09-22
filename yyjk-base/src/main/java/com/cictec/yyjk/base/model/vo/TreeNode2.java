package com.cictec.yyjk.base.model.vo;

import java.util.Set;
import java.util.TreeSet;

public class TreeNode2 implements Comparable<TreeNode2> {
	private String id;// 树节点id
	private String pId;// 树父节点id
	private String name;// 树节点id
	boolean checked; // 节点是否被选中
	boolean open;// 节点是否打开
	private int sort;// 排序号
	private String levelsType; // 节点值

	private Set<TreeNode2> children = new TreeSet<TreeNode2>();// 树节子点集合

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

	public Set<TreeNode2> getChildren() {
		return children;
	}

	public void setChildren(Set<TreeNode2> children) {
		this.children = children;
	}

	public void addChild(TreeNode2 node) {
		this.children.add(node);
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public int compareTo(TreeNode2 node) {
		int result = sort > node.getSort() ? 1 : -1;
		return result;
	}
}

