package com.cictec.yyjk.base.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.vo.TreeNode;
import com.cictec.yyjk.base.model.vo.TreeNode2;

public class TreeUtils {

	/**
	 * 构建树
	 * 
	 * @param resouceTable
	 * @return
	 */
	public static List<TreeNode> buildTree(Hashtable<String, TreeNode> resouceTable) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		if (resouceTable == null) {
			return nodes;
		}
		Set<Entry<String, TreeNode>> entrySet = resouceTable.entrySet();
		for (Entry<String, TreeNode> entry : entrySet) {
			TreeNode node = entry.getValue();
			if (!StringUtils.isEmpty(node.getParentId())) { // 非根节点
				TreeNode parentNode = resouceTable.get(node.getParentId());
				if (parentNode != null) {
					parentNode.addChild(node);

					Set<TreeNode> childerens = parentNode.getChildren();
					if (childerens.size() > 0) {
						for (TreeNode children : childerens) {
							if (children.getPath() != null) {
								parentNode.getRoles().add(children.getPath());
							}
						}
					}
					if (node.getPath() != null) {
						node.getRoles().add(node.getPath());
					}
				}
			} else {// 根节点
				nodes.add(node);

				Set<TreeNode> childerens = node.getChildren();
				for (TreeNode children : childerens) {
					if (children.getPath() != null) {
						node.getRoles().add(children.getPath());
					}
				}
			}
		}
		return nodes;
	}

	public static List<TreeNode2> buildTree2(List<BusSysOrg> list) {
		List<TreeNode2> nodes = new ArrayList<TreeNode2>();
		Hashtable<String, TreeNode2> nodeTable = new Hashtable<String, TreeNode2>();
		if (list == null) {
			return Collections.emptyList();
		}
		for (BusSysOrg bean : list) {
			TreeNode2 node = new TreeNode2();
			node.setId(bean.getOrgUuid());
			node.setName(bean.getOrgName());
			node.setpId(bean.getOrgParentUuid());
			node.setSort((bean.getOrgSortIndex() == null) ? 0 : bean.getOrgSortIndex());
			nodeTable.put(node.getId(), node);
		}
		Set<Entry<String, TreeNode2>> entrySet = nodeTable.entrySet();
		for (Entry<String, TreeNode2> entry : entrySet) {
			TreeNode2 node = entry.getValue();
			if (!StringUtils.isEmpty(node.getpId())) { // 非根节点
				TreeNode2 parentNode = nodeTable.get(node.getpId());
				if (parentNode != null) {
					parentNode.addChild(node);
				}
			} else {// 根节点
				nodes.add(node);
			}
		}
		return nodes;
	}
}
