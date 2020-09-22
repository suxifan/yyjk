package com.cictec.yyjk.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.view.BusLineView;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface BaseUserInfoMapper extends Mapper<BaseUserInfo> {
	/**
	 * 根据条件获取用户数
	 * 
	 * @param baseUserInfoVo
	 * @return
	 */
	public Integer getUserCount(BaseUserInfoVo baseUserInfoVo);

	/**
	 * 根据查询条件查询用户信息
	 * 
	 * @param baseUserInfoVo
	 * @return
	 */
	public List<BaseUserInfo> getUserInfoByVo(BaseUserInfoVo baseUserInfoVo);

	/**
	 * 获取机构下用户
	 * 
	 * @param orgUuid
	 * @return
	 */
	public List<BaseUserInfo> getUsersByOrgId(@Param(value = "orgId") String orgId);

	/**
	 * 移除用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void deleteUserRole(@Param(value = "userId") String userId, @Param(value = "roleIds") String... roleIds);

	/**
	 * 根据用户id查找其角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseRoleInfo> findRolesByUserId(@Param(value = "userId") String userId);

	/**
	 * 根据用户id查找其角色包含已禁用的角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseRoleInfo> findAllRolesByUserId(@Param(value = "userId") String userId);

	/**
	 * 根据用户id查找权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseResourceInfo> getPermissionsByUserId(@Param(value = "userId") String userId);

	/**
	 * 根据用户id查找数据权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseDataResourceInfo> getDataPermissionsByUserId(@Param(value = "userId") String userId);

	/**
	 * 根据用户id查找用户线路权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<BusLine> getLineAuthsByUserId(BaseUserInfo userInfo);

	/**
	 * 根据角色查找其权限
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseResourceInfo> getResourcesByRoleIds(@Param(value = "roleIds") List<String> roleIds);

	/**
	 * 根据用户ids获取用户列表
	 * 
	 * @param userIds
	 * @return
	 */
	public List<BaseUserInfo> getUsersByIds(@Param(value = "userIds") List<String> userIds);

	public String findAuditStatusByUserId(@Param(value = "userId") String userId);

	@SuppressWarnings("rawtypes")
	public List<Map> findAllUserByOrgId(@Param(value = "userId") String userId);

	@SuppressWarnings("rawtypes")
	public List<Map> findUserByOrgId(@Param(value = "userId") String userId);

	/**
	 * 获取用户ID下的所有有权限的线路id
	 * 
	 * @param personId
	 * @return
	 */
	public List<BusLineView> getLineListByUserId(BaseUserInfoVo vo);
}