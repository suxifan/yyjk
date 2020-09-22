package com.cictec.yyjk.base.model.vo;

import java.util.Set;
import java.util.TreeSet;

public class TreeNode implements Comparable<TreeNode> {
	private String id;// 树节点id
	private String name;// 树节点名称
	private String parentId;// 树节点父节点id
	private String path;// 树节点url资源
	private String icon;// 树节点图标路径
	private String type;// 树节点类型，[mudule, field]
	private String title;// 标题
	private String component;// 树节点模块名-和前段angular js 模块名对应
	private Set<String> roles = new TreeSet<>();
	private int sort;// 排序号
	private String describe;// 树节点描述信息
	private Set<TreeNode> children = new TreeSet<TreeNode>();// 树节子点集合

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Set<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(Set<TreeNode> children) {
		this.children = children;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	@Override
	public int compareTo(TreeNode node) {
		int result = sort > node.getSort() ? 1 : -1;
		return result;
	}

	public void addChild(TreeNode node) {
		this.children.add(node);
	}
}
