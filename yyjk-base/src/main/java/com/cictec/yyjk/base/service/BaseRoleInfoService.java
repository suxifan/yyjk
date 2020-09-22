package com.cictec.yyjk.base.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.vo.BaseRoleInfoVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/05/28.
 */
public interface BaseRoleInfoService extends Service<BaseRoleInfo> {
	/**
	 * 根据用户id获取用户角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseRoleInfo> getRolesByUserId(@Param(value = "userId") String userId);

	/**
	 * 根据条件查询
	 * 
	 * @param baseRoleInfoVo
	 * @return
	 */
	public List<BaseRoleInfo> getRoleInfoByVo(BaseRoleInfoVo baseRoleInfoVo);

	/**
	 * 根据角色Id查询权限
	 * 
	 * @param roleId
	 * @return
	 */
	public List<BaseResourceInfo> getResourseByRoleId(String roleId);

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(String roleId, String... permissionIds);

	/**
	 * 添加角色-数据权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationDataPermissions(String roleId, String... permissionIds);

	/**
	 * 添加角色-线路权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationLinePermissions(String roleId, String... permissionIds);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(String roleId, String... permissionIds);


	/**
	 * 移除角色-数据权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationDataPermissions(String roleId, String... permissionIds);

	/**
	 * 根据角色id删除角色，当角色有用户在用时不能删除，同时指出哪些用户在使用该角色
	 * 
	 * @param roleId
	 * @return
	 */
	public List<BaseUserInfo> deleteRole(String roleId);
}
