package com.cictec.yyjk.base.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseRoleInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.view.BusLineView;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.commons.core.Service;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/05/28.
 */
public interface BaseUserInfoService extends Service<BaseUserInfo> {
	/**
	 * 根据条件获取用户数
	 * 
	 * @param baseUserInfoVo
	 * @return
	 */
	public Integer getUserCount(BaseUserInfoVo baseUserInfoVo);

	/**
	 * 新增用户，并绑定角色
	 * 
	 * @param baseUserInfoVo
	 */
	public void addUser(BaseUserInfo baseUserInfo);

	/**
	 * 根据条件查询
	 * 
	 * @param baseUserInfoVo
	 * @return
	 */
	public PageInfo<BaseUserInfo> getUserInfoByVo(BaseUserInfoVo baseUserInfoVo);

	/**
	 * 获取机构下用户
	 * 
	 * @param orgUuid
	 * @return
	 */
	public List<BaseUserInfo> getUsersByOrgId(String orgId);

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public BaseUserInfo getDetail(String userId);

	/**
	 * 根据用户ids获取用户列表
	 * 
	 * @param userIds
	 * @return
	 */
	public List<BaseUserInfo> getUsersByIds(List<String> userIds);

	/**
	 * 删除用户及解除用户角色关系
	 * 
	 * @return
	 */
	public boolean delUserAndRoles(String userId);

	/**
	 * 更新用户及用户角色关系
	 * 
	 * @return
	 */
	public boolean updateUserAndRoles(BaseUserInfo baseUserInfo);

	/**
	 * 通过用户名查找用户
	 */
	public BaseUserInfo selectUserByUserAccout(String userAccout);

	/**
	 * 添加用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void correlationRoles(String userId, String... roleIds);

	/**
	 * 移除用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void uncorrelationRoles(String userId, String... roleIds);

	/**
	 * 根据用户id查找权限
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Object> getPermissionsByUserId(String userId);

	/**
	 * 根据用户id查找数据权限树
	 * 
	 * @param userId
	 * @return
	 */
	public Map<String, Object> getDataPermissionsByUserId(String userId);

	/**
	 * 机构线路树
	 * 
	 * @param orgUuid
	 * @return
	 */
	public List<TreeNode2> getLineAuthsByOrgUuid(String orgUuid);

	/**
	 * 根据用户id查找数据权限列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseDataResourceInfo> getDataAuthByUserId(String userId);

	/**
	 * 根据用户id查线路权限列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<BusLine> getLineAuthByUserId(BaseUserInfo userInfo);

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<BaseRoleInfo> findRolesByUserId(String userId);

	/**
	 * 根据用户名查询该用户是否拥有审核权限
	 * 
	 * @param userId
	 * @return
	 */
	public String findAuditStatusByUserId(String userId);

	/**
	 * 获取用户ID下的所有有权限的线路id
	 * 
	 * @param personId
	 * @return
	 */
	public List<BusLineView> getLineListByUserId(BaseUserInfoVo vo);

}
