package com.cictec.yyjk.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.commons.core.Mapper;

public interface BaseRoleInfoMapper extends Mapper<BaseRoleInfo> {
	/**
	 * 根据用户id获取用户角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseRoleInfo> getRolesByUserId(@Param(value = "userId") String userId);
	
	/**
	 * 根据角色Id查询权限
	 * 
	 * @param roleId
	 * @return
	 */
	public List<BaseResourceInfo> getResourseByRoleId(@Param(value = "roleId") String roleId);

	/**
	 * 根据角色Id查询数据权限
	 * 
	 * @param roleId
	 * @return
	 */
	public List<BaseDataResourceInfo> getDataResourseByRoleId(@Param(value = "roleId") String roleId);


	/**
	 * 根据角色Id查询线路权限
	 * 
	 * @param roleId
	 * @return
	 */
	public List<BusLine> getLineResourseByRoleId(@Param(value = "roleId") String roleId);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void deleteRoleResourses(@Param(value = "roleId") String roleId,
			@Param(value = "permissionIds") String... permissionIds);

	/**
	 * 移除角色-数据权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void deleteRoleDataResourses(@Param(value = "roleId") String roleId,
			@Param(value = "permissionIds") String... permissionIds);
}