package com.cictec.yyjk.base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseUserInfoMapper;
import com.cictec.yyjk.base.mapper.BusLineMapper;
import com.cictec.yyjk.base.mapper.BusSysOrgMapper;
import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.BaseUserRole;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.view.BusLineView;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.base.model.vo.TreeNode;
import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.base.service.BaseRoleInfoService;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BaseUserRoleService;
import com.cictec.yyjk.base.utils.TreeUtils;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * Created by xpguo on 2019/05/28.
 */
@Service
@Transactional
public class BaseUserInfoServiceImpl extends AbstractService<BaseUserInfo> implements BaseUserInfoService {
	private static final Logger LOG = LoggerFactory.getLogger(BaseUserInfoServiceImpl.class);
	@Autowired
	private BaseUserInfoService baseUserInfoService;
	@Autowired
	private BaseRoleInfoService baseRoleInfoService;
	@Resource
	private BaseUserInfoMapper baseUserInfoMapper;
	@Autowired
	private BaseUserRoleService baseUserRoleService;
	@Autowired
	private BusSysOrgMapper busSysOrgMapper;
	@Autowired
	private BusLineMapper busLineMapper;

	@Override
	public PageInfo<BaseUserInfo> getUserInfoByVo(BaseUserInfoVo baseUserInfoVo) {
		List<BaseUserInfo> queryList = baseUserInfoMapper.getUserInfoByVo(baseUserInfoVo);
		for (BaseUserInfo bean : queryList) {
			List<BaseRoleInfo> users = baseRoleInfoService.getRolesByUserId(bean.getUserId());
			if (users != null && users.size() > 0) {
				StringBuilder builder = new StringBuilder();
				Iterator<BaseRoleInfo> iterator = users.iterator();
				builder.append(iterator.next().getRoleName());
				while (iterator.hasNext()) {
					builder.append("，");
					builder.append(iterator.next().getRoleName());
				}
				bean.setRoleName(builder.toString());
			}
		}
		Integer total = baseUserInfoService.getUserCount(baseUserInfoVo);
		PageInfo<BaseUserInfo> pageInfo = new PageInfo<>();
		pageInfo.setPageNum(baseUserInfoVo.getPageNumber());
		pageInfo.setPageSize(baseUserInfoVo.getPageSize());
		pageInfo.setTotal(total == null ? 0 : total);
		pageInfo.setList(queryList);
		return pageInfo;
	}

	@Override
	public BaseUserInfo selectUserByUserAccout(String userAccout) {
		Example example = new Example(BaseUserInfo.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("userAccount", userAccout);
		return baseUserInfoMapper.selectOneByExample(example);
	}

	public List<BaseUserInfo> getUsersByOrgId(String orgId) {
		return baseUserInfoMapper.getUsersByOrgId(orgId);
	}

	@Override
	public void correlationRoles(String userId, String... roleIds) {
		for (String roleId : roleIds) {
			BaseUserRole entity = new BaseUserRole();
			entity.setRoleId(roleId);
			entity.setUserId(userId);
			entity.setCreateTime(new Date());
			baseUserRoleService.insert(entity);
		}
	}

	@Override
	public void uncorrelationRoles(String userId, String... roleIds) {
		baseUserInfoMapper.deleteUserRole(userId, roleIds);
	}

	@Override
	public List<BaseRoleInfo> findRolesByUserId(String userId) {
		return baseUserInfoMapper.findRolesByUserId(userId);
	}

	@Override
	public boolean delUserAndRoles(String userId) {
		try {
			int result = baseUserInfoMapper.deleteByPrimaryKey(userId);
			if (result > 0 && PMSUtils.isNotEmpty(userId)) {
				List<BaseRoleInfo> userRoles = baseUserInfoMapper.findAllRolesByUserId(userId);
				String[] roleIds = new String[userRoles.size()];
				for (int i = 0; i < userRoles.size(); i++) {
					roleIds[i] = userRoles.get(i).getRoleId();
				}
				baseUserInfoMapper.deleteUserRole(userId, roleIds);
			}
			return true;
		} catch (Exception ex) {
			LOG.error("删除用户及用户角色失败，原因{}", ex);
		}
		return false;
	}

	@Override
	public boolean updateUserAndRoles(BaseUserInfo baseUserInfo) {
		try {
			int result = baseUserInfoMapper.updateByPrimaryKeySelective(baseUserInfo);
			if (result > 0) {
				List<String> list = baseUserInfo.getRoleIds();
				if (PMSUtils.isNotEmpty(list)) {
					String[] roleIds = new String[list.size()];
					list.toArray(roleIds);
					// 先解除绑定用户角色
					baseUserInfoMapper.deleteUserRole(baseUserInfo.getUserId());
					// 再重新绑定用户角色
					for (String roleId : roleIds) {
						BaseUserRole entity = new BaseUserRole();
						entity.setRoleId(roleId);
						entity.setUserId(baseUserInfo.getUserId());
						entity.setCreateTime(new Date());
						baseUserRoleService.insert(entity);
					}
				}
			}
			return true;
		} catch (Exception ex) {

		}
		return false;
	}

	@Override
	public BaseUserInfo getDetail(String userId) {
		if (PMSUtils.isNotEmpty(userId)) {
			BaseUserInfo userInfo = baseUserInfoMapper.selectByPrimaryKey(userId);
			List<BaseRoleInfo> rolesList = baseUserInfoMapper.findAllRolesByUserId(userId);
			userInfo.setRoles(rolesList);
			List<String> roleIds = new ArrayList<>();
			if (rolesList != null && rolesList.size() > 0) {
				for (BaseRoleInfo bean : rolesList) {
					roleIds.add(bean.getRoleId());
				}
			}
			userInfo.setRoleIds(roleIds);
			return userInfo;
		}
		return new BaseUserInfo();
	}

	@Override
	public List<BaseUserInfo> getUsersByIds(List<String> userIds) {
		return baseUserInfoMapper.getUsersByIds(userIds);
	}

	@Override
	public void addUser(BaseUserInfo baseUserInfo) {
		int result = baseUserInfoMapper.insertSelective(baseUserInfo);
		List<String> roleIds = baseUserInfo.getRoleIds();
		if (result > 0 && (roleIds != null && roleIds.size() > 0)) {
			for (String roleId : roleIds) {
				BaseUserRole entity = new BaseUserRole();
				entity.setRoleId(roleId);
				entity.setUserId(baseUserInfo.getUserId());
				entity.setCreateTime(new Date());
				baseUserRoleService.insert(entity);
			}
		}
	}

	@Override
	public Integer getUserCount(BaseUserInfoVo baseUserInfoVo) {
		return baseUserInfoMapper.getUserCount(baseUserInfoVo);
	}

	@Override
	public Map<String, Object> getPermissionsByUserId(String userId) {
		BaseUserInfo userInfo = baseUserInfoMapper.selectByPrimaryKey(userId);
		Map<String, Object> result = new HashMap<>();
		result.put("userOrgId", userInfo.getUserOrgUuid());
		// 超级管理员用户id为1，返回所有资源权限
		if ("1".equals(userId)) {
			userId = null;
		}
		List<BaseResourceInfo> queryList = baseUserInfoMapper.getPermissionsByUserId(userId);
		Hashtable<String, TreeNode> resouceTable = new Hashtable<String, TreeNode>();
		if (queryList != null && queryList.size() > 0) {
			for (BaseResourceInfo bean : queryList) {
				TreeNode node = new TreeNode();
				node.setId(bean.getResourceId());
				node.setName(bean.getResourceName());
				node.setParentId(bean.getResourceParentId());
				node.setComponent(bean.getResourceComponent());
				node.setPath(bean.getResourceUrl());
				node.setSort((bean.getResourceSort() == null) ? 0 : bean.getResourceSort());
				node.setIcon(bean.getResourceImage());
				node.setType(bean.getResourceType());
				node.setTitle(bean.getResourceTitle());
				resouceTable.put(node.getId(), node);
			}
		}
		List<TreeNode> resourceTree = TreeUtils.buildTree(resouceTable);
		result.put("resourceTree", resourceTree);
		return result;
	}

	@Override
	public Map<String, Object> getDataPermissionsByUserId(String userId) {
		BaseUserInfo userInfo = baseUserInfoMapper.selectByPrimaryKey(userId);
		Map<String, Object> result = new HashMap<>();
		result.put("userOrgId", userInfo.getUserOrgUuid());
		// 超级管理员用户id为1，返回所有数据权限
		if ("1".equals(userId)) {
			userId = null;
		}
		List<BaseDataResourceInfo> queryList = baseUserInfoMapper.getDataPermissionsByUserId(userId);
		Hashtable<String, TreeNode> resouceTable = new Hashtable<String, TreeNode>();
		if (queryList != null && queryList.size() > 0) {
			for (BaseDataResourceInfo bean : queryList) {
				TreeNode node = new TreeNode();
				node.setId(bean.getDataResourceId());
				node.setName(bean.getDataResourceName());
				node.setParentId(bean.getDataResourceParentId());
				node.setSort((bean.getDataResourceSort() == null) ? 0 : bean.getDataResourceSort());
				node.setType(bean.getDataResourceType());
				node.setTitle(bean.getDataResourceTitle());
				resouceTable.put(node.getId(), node);
			}
		}

		List<TreeNode> resourceTree = TreeUtils.buildTree(resouceTable);
		result.put("resourceTree", resourceTree);
		return result;
	}

	public List<TreeNode2> getLineAuthsByOrgUuid(String orgUuid) {
		BusSysOrg vo = new BusSysOrg();
		if (StringUtils.isNotEmpty(orgUuid)) {
			vo.setOrgUuid(orgUuid);
		}
		vo.setOrgDropFlag("0");
		vo.setOrgEnabled("1");
		// vo.setOrgType(1);
		List<BusSysOrg> list = busSysOrgMapper.selectTBusSysOrgList(vo);
		if (list != null && list.size() > 0) {
			List<TreeNode2> trees = TreeUtils.buildTree2(list);
			for (TreeNode2 node : trees) {
				if (node.getpId() == null) {// 总公司
					node.setLevelsType("0");
					node.setOpen(true);
				}
				if (node.getChildren().size() > 0) {
					Set<TreeNode2> childs = node.getChildren();
					for (TreeNode2 child : childs) {
						addLineNodes(child);
					}
				} else {
					addLineNodes(node);
				}
			}
			return trees;
		}
		return Collections.emptyList();
	}

	private void addLineNodes(TreeNode2 node) {
		// 分公司
		node.setLevelsType("1");
		node.setOpen(false);
		Example example = new Example(BusLine.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("lineOrgUuid", node.getId());
		criteria.andEqualTo("lineIsvalid", "1");
		criteria.andEqualTo("lineDropFlag", "0");
		List<BusLine> lineList = busLineMapper.selectByExample(example);
		if (lineList != null && lineList.size() > 0) {
			for (BusLine line : lineList) {
				TreeNode2 lineNode = new TreeNode2();
				lineNode.setId(line.getLineUuid());
				lineNode.setName(line.getLineName());
				lineNode.setpId(node.getId());
				lineNode.setOpen(false);
				lineNode.setLevelsType("2");
				node.addChild(lineNode);
			}
		}
	}

	@Override
	public List<BaseDataResourceInfo> getDataAuthByUserId(String userId) {
		// 超级管理员用户id为1，返回所有数据权限
		if ("1".equals(userId)) {
			userId = null;
		}
		return baseUserInfoMapper.getDataPermissionsByUserId(userId);
	}

	@Override
	public List<BusLine> getLineAuthByUserId(BaseUserInfo userInfo) {
		// 超级管理员用户id为1，返回所有数据权限
		if ("1".equals(userInfo.getUserId())) {
			userInfo = null;
		}
		return baseUserInfoMapper.getLineAuthsByUserId(userInfo);
	}

	@Override
	public String findAuditStatusByUserId(String userId) {
		return baseUserInfoMapper.findAuditStatusByUserId(userId);
	}

	@Override
	public List<BusLineView> getLineListByUserId(BaseUserInfoVo vo) {
		return baseUserInfoMapper.getLineListByUserId(vo);
	}
}
