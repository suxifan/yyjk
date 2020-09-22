package com.cictec.yyjk.base.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

@Table(name = "base_user_info")
public class BaseUserInfo {
	/**
	 * 用户id
	 */
	@Id
	@KeySql(sql = "select nextval('base_user_info_id_seq'::regclass)", order = ORDER.BEFORE)
	@Column(name = "user_id")
	private String userId;

	/**
	 * 用户名
	 */
	@Column(name = "user_account")
	private String userAccount;

	/**
	 * 密码
	 */
	@Column(name = "user_password")
	private String userPassword;

	/**
	 * 性别 1.男 2 女
	 */
	@Column(name = "user_gender")
	private String userGender;

	/**
	 * 姓名
	 */
	@Column(name = "user_real_name")
	private String userRealName;

	/**
	 * 联系电话
	 */
	@Column(name = "user_telephone")
	private String userTelephone;

	/**
	 * 移动电话
	 */
	@Column(name = "user_mobile")
	private String userMobile;

	/**
	 * 创建者
	 */
	@Column(name = "create_user")
	private String createUser;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 更新者
	 */
	@Column(name = "update_user")
	private String updateUser;

	/**
	 * 更新时间
	 */
	@Column(name = "update_time")
	private Date updateTime;

	/**
	 * 是否启用
	 */
	@Column(name = "enabled")
	private String enabled;

	/**
	 * 描述
	 */
	@Column(name = "describes")
	private String describes;

	/**
	 * 用户所属机构UUID
	 */
	@Column(name = "user_org_uuid")
	private String userOrgUuid;

	@Transient
	private String roleName;

	@Transient
	private List<String> roleIds = new ArrayList<String>();

	@Transient
	private List<BaseRoleInfo> roles = new ArrayList<BaseRoleInfo>();

	@Transient
	private String orgName;

	@Transient
	private String orgId;

	@Transient
	private List<String> lineUuids;

	/**
	 * 用户管理员（可审核可修改角色）
	 */
	@Transient
	private String recheckType;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Transient
	private boolean auditStatus;// 审核状态

	public boolean isAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(boolean auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * 获取用户id
	 *
	 * @return user_id - 用户id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置用户id
	 *
	 * @param userId
	 *            用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取用户名
	 *
	 * @return user_account - 用户名
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * 设置用户名
	 *
	 * @param userAccount
	 *            用户名
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * 获取密码
	 *
	 * @return user_password - 密码
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 设置密码
	 *
	 * @param userPassword
	 *            密码
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 获取性别 1.男 2 女
	 *
	 * @return user_gender - 性别 1.男 2 女
	 */
	public String getUserGender() {
		return userGender;
	}

	/**
	 * 设置性别 1.男 2 女
	 *
	 * @param userGender
	 *            性别 1.男 2 女
	 */
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	/**
	 * 获取姓名
	 *
	 * @return user_real_name - 姓名
	 */
	public String getUserRealName() {
		return userRealName;
	}

	/**
	 * 设置姓名
	 *
	 * @param userReallName
	 *            姓名
	 */
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	/**
	 * 获取联系电话
	 *
	 * @return user_telephone - 联系电话
	 */
	public String getUserTelephone() {
		return userTelephone;
	}

	/**
	 * 设置联系电话
	 *
	 * @param userTelephone
	 *            联系电话
	 */
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	/**
	 * 获取移动电话
	 *
	 * @return user_mobile - 移动电话
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * 设置移动电话
	 *
	 * @param userMobile
	 *            移动电话
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * 获取创建者
	 *
	 * @return create_user - 创建者
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置创建者
	 *
	 * @param createUser
	 *            创建者
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 获取创建时间
	 *
	 * @return create_time - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取更新者
	 *
	 * @return update_user - 更新者
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * 设置更新者
	 *
	 * @param updateUser
	 *            更新者
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * 获取更新时间
	 *
	 * @return update_time - 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 *
	 * @param updateTime
	 *            更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取是否启用
	 *
	 * @return enable - 是否启用
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 设置是否启用
	 *
	 * @param enable
	 *            是否启用
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * 获取描述
	 *
	 * @return describe - 描述
	 */
	public String getDescribes() {
		return describes;
	}

	/**
	 * 设置描述
	 *
	 * @param describe
	 *            描述
	 */
	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public List<BaseRoleInfo> getRoles() {
		return roles;
	}

	public void setRoles(List<BaseRoleInfo> roles) {
		this.roles = roles;
	}

	public String getUserOrgUuid() {
		return userOrgUuid;
	}

	public void setUserOrgUuid(String userOrgUuid) {
		this.userOrgUuid = userOrgUuid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public String getRecheckType() {
		return recheckType;
	}

	public void setRecheckType(String recheckType) {
		this.recheckType = recheckType;
	}

}