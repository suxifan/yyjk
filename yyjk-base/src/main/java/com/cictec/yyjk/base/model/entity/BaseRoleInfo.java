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

@Table(name = "base_role_info")
public class BaseRoleInfo {
	/**
	 * 角色id
	 */
	@Id
	@KeySql(sql = "select nextval('base_role_info_id_seq'::regclass)", order = ORDER.BEFORE)
	@Column(name = "role_id")
	private String roleId;

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 角色父级id
	 */
	@Column(name = "role_parent_id")
	private String roleParentId;

	/**
	 * 排序字段
	 */
	@Column(name = "role_sort")
	private Short roleSort;

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
	 * 描述
	 */
	@Column(name = "role_type")
	private String roleType;

	/**
	 * 用户管理员（可审核可修改角色）
	 */
	@Column(name = "recheck_type")
	private String recheckType;

	@Transient
	private List<String> resourceIds = new ArrayList<String>();

	@Transient
	private List<BaseResourceInfo> resources = new ArrayList<>();

	@Transient
	private List<String> dataAuthIds = new ArrayList<String>();

	@Transient
	private List<BaseDataResourceInfo> dataAuths = new ArrayList<>();

	@Transient
	private List<BusLine> lineAuths = new ArrayList<>();

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * 获取角色id
	 *
	 * @return role_id - 角色id
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * 设置角色id
	 *
	 * @param roleId
	 *            角色id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取角色名称
	 *
	 * @return role_name - 角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置角色名称
	 *
	 * @param roleName
	 *            角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取角色父级id
	 *
	 * @return role_parent_id - 角色父级id
	 */
	public String getRoleParentId() {
		return roleParentId;
	}

	/**
	 * 设置角色父级id
	 *
	 * @param roleParentId
	 *            角色父级id
	 */
	public void setRoleParentId(String roleParentId) {
		this.roleParentId = roleParentId;
	}

	/**
	 * 获取排序字段
	 *
	 * @return role_sort - 排序字段
	 */
	public Short getRoleSort() {
		return roleSort;
	}

	/**
	 * 设置排序字段
	 *
	 * @param roleSort
	 *            排序字段
	 */
	public void setRoleSort(Short roleSort) {
		this.roleSort = roleSort;
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
	 * @return enabled - 是否启用
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 设置是否启用
	 *
	 * @param enabled
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

	public List<String> getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(List<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	public List<BaseResourceInfo> getResources() {
		return resources;
	}

	public void setResources(List<BaseResourceInfo> resources) {
		this.resources = resources;
	}

	public List<String> getDataAuthIds() {
		return dataAuthIds;
	}

	public void setDataAuthIds(List<String> dataAuthIds) {
		this.dataAuthIds = dataAuthIds;
	}

	public List<BaseDataResourceInfo> getDataAuths() {
		return dataAuths;
	}

	public void setDataAuths(List<BaseDataResourceInfo> dataAuths) {
		this.dataAuths = dataAuths;
	}

	public List<BusLine> getLineAuths() {
		return lineAuths;
	}

	public void setLineAuths(List<BusLine> lineAuths) {
		this.lineAuths = lineAuths;
	}

	public String getRecheckType() {
		return recheckType;
	}

	public void setRecheckType(String recheckType) {
		this.recheckType = recheckType;
	}

}