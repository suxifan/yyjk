package com.cictec.yyjk.base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseRoleDataresourceMapper;
import com.cictec.yyjk.base.mapper.BaseRoleInfoMapper;
import com.cictec.yyjk.base.mapper.BaseRoleLineresourceMapper;
import com.cictec.yyjk.base.mapper.BaseRoleResourceMapper;
import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleDataresource;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleLineresource;
import com.cictec.yyjk.base.model.entity.BaseRoleResource;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.BaseUserRole;
import com.cictec.yyjk.base.model.vo.BaseRoleInfoVo;
import com.cictec.yyjk.base.service.BaseRoleDataresourceService;
import com.cictec.yyjk.base.service.BaseRoleInfoService;
import com.cictec.yyjk.base.service.BaseRoleLineresourceService;
import com.cictec.yyjk.base.service.BaseRoleResourceService;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BaseUserRoleService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * Created by xpguo on 2019/05/28.
 */
@Service
@Transactional
public class BaseRoleInfoServiceImpl extends AbstractService<BaseRoleInfo> implements BaseRoleInfoService {

    @Resource
    private BaseRoleInfoMapper baseRoleInfoMapper;

	@Resource
	private BaseRoleResourceMapper baseRoleResourceMapper;

	@Resource
	private BaseRoleDataresourceMapper baseRoleDataresourceMapper;

	@Autowired
	private BaseRoleLineresourceMapper baseRoleLineresourceMapper;

	@Autowired
	private BaseRoleResourceService baseRoleResourceService;
	@Autowired
	private BaseRoleDataresourceService baseRoleDataresourceService;
	@Autowired
	private BaseRoleLineresourceService baseRoleLineresourceService;
	@Autowired
	private BaseUserRoleService baseUserRoleService;
	@Autowired
	private BaseUserInfoService baseUserInfoService;

	@Override
	public List<BaseRoleInfo> getRoleInfoByVo(BaseRoleInfoVo baseRoleInfoVo) {
		Example example = new Example(BaseRoleInfo.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(baseRoleInfoVo.getRoleName())) {
			criteria.andLike("roleName", baseRoleInfoVo.getRoleName());
		}
		if (PMSUtils.isNotEmpty(baseRoleInfoVo.getEnabled())) {
			criteria.andEqualTo("enabled", baseRoleInfoVo.getEnabled());
		}
		if (PMSUtils.isNotEmpty(baseRoleInfoVo.getStartTime())) {
			criteria.andGreaterThanOrEqualTo("updateTime", baseRoleInfoVo.getStartTime());
		}
		if (PMSUtils.isNotEmpty(baseRoleInfoVo.getEndTime())) {
			criteria.andLessThanOrEqualTo("updateTime", baseRoleInfoVo.getEndTime());
		}
		if (PMSUtils.isNotEmpty(baseRoleInfoVo.getTokenUserAccount())) {
			criteria.andEqualTo("createUser", baseRoleInfoVo.getTokenUserAccount());
		}
		example.setOrderByClause("role_sort ASC");
		List<BaseRoleInfo> list = baseRoleInfoMapper.selectByExample(example);
		for (BaseRoleInfo bean : list) {
			// 设置菜单权限
			bean.setResources(baseRoleInfoMapper.getResourseByRoleId(bean.getRoleId()));
			// 设置数据权限
			bean.setDataAuths(baseRoleInfoMapper.getDataResourseByRoleId(bean.getRoleId()));
			// 设置线路权限
			bean.setLineAuths(baseRoleInfoMapper.getLineResourseByRoleId(bean.getRoleId()));
		}
		return list;
	}

	@Override
	public void correlationPermissions(String roleId, String... permissionIds) {
		// 先清除角色权限关系
		Example example = new Example(BaseRoleResource.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(roleId)) {
			criteria.andEqualTo("roleId", roleId);
		}
		baseRoleResourceMapper.deleteByExample(example);
		// 重新绑定角色权限关系
		for (String permissionId : permissionIds) {
			BaseRoleResource entity = new BaseRoleResource();
			entity.setRoleId(roleId);
			entity.setResourceId(permissionId);
			entity.setCreateTime(new Date());
			baseRoleResourceService.insert(entity);
		}
	}

	@Override
	public void correlationDataPermissions(String roleId, String... permissionIds) {
		// 先清除角色权限关系
		Example example = new Example(BaseRoleDataresource.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(roleId)) {
			criteria.andEqualTo("roleId", roleId);
		}
		baseRoleDataresourceMapper.deleteByExample(example);
		// 重新绑定角色权限关系
		for (String permissionId : permissionIds) {
			BaseRoleDataresource entity = new BaseRoleDataresource();
			entity.setRoleId(roleId);
			entity.setDataResourceId(permissionId);
			entity.setCreateTime(new Date());
			baseRoleDataresourceService.insert(entity);
		}
	}

	@Override
	public void correlationLinePermissions(String roleId, String... permissionIds) {
		// 先清除角色权限关系
		Example example = new Example(BaseRoleLineresource.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(roleId)) {
			criteria.andEqualTo("roleId", roleId);
		}
		baseRoleLineresourceMapper.deleteByExample(example);
		// 重新绑定角色权限关系
		for (String permissionId : permissionIds) {
			BaseRoleLineresource entity = new BaseRoleLineresource();
			entity.setRoleId(roleId);
			entity.setLineResourceId(permissionId);
			entity.setCreateTime(new Date());
			baseRoleLineresourceService.insert(entity);
		}
	}

	@Override
	public void uncorrelationPermissions(String roleId, String... permissionIds) {
		for (String permissionId : permissionIds) {
			baseRoleInfoMapper.deleteRoleResourses(roleId, permissionId);
		}
	}

	@Override
	public void uncorrelationDataPermissions(String roleId, String... permissionIds) {
		for (String permissionId : permissionIds) {
			baseRoleInfoMapper.deleteRoleDataResourses(roleId, permissionId);
		}
	}

	@Override
	public List<BaseResourceInfo> getResourseByRoleId(String roleId) {
		return baseRoleInfoMapper.getResourseByRoleId(roleId);
	}

	@Override
	public List<BaseUserInfo> deleteRole(String roleId) {
		BaseUserRole baseUserRole = new BaseUserRole();
		baseUserRole.setRoleId(roleId);
		List<BaseUserRole> list = baseUserRoleService.select(baseUserRole);
		if (list == null || (list != null && list.size() == 0)) {
			// 角色没有被使用时删除角色及角色权限关系
			baseRoleInfoMapper.deleteByPrimaryKey(roleId);
			// 先清除角色权限关系
			Example example = new Example(BaseRoleResource.class);
			Criteria criteria = example.createCriteria();
			if (PMSUtils.isNotEmpty(roleId)) {
				criteria.andEqualTo("roleId", roleId);
			}
			baseRoleResourceMapper.deleteByExample(example);
			return Collections.emptyList();
		}
		List<String> userIds = new ArrayList<>();
		for (BaseUserRole bean : list) {
			userIds.add(bean.getUserId());
		}
		return baseUserInfoService.getUsersByIds(userIds);
	}

	@Override
	public List<BaseRoleInfo> getRolesByUserId(String userId) {
		return baseRoleInfoMapper.getRolesByUserId(userId);
	}

}
