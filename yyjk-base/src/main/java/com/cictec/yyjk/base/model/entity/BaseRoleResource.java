package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

@Table(name = "base_role_resource")
public class BaseRoleResource {
    /**
	 * 角色资源id
	 */
    @Id
	@KeySql(sql = "select nextval('base_role_resource_id_seq'::regclass)", order = ORDER.BEFORE)
    @Column(name = "role_resource_id")
	private String roleResourceId;

    /**
	 * 角色编号
	 */
    @Column(name = "role_id")
    private String roleId;

    /**
	 * 资源编号
	 */
    @Column(name = "resource_id")
    private String resourceId;

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
	 * 获取角色资源id
	 *
	 * @return role_resource_id - 角色资源id
	 */
	public String getRoleResourceId() {
        return roleResourceId;
    }

    /**
	 * 设置角色资源id
	 *
	 * @param roleResourceId
	 *            角色资源id
	 */
	public void setRoleResourceId(String roleResourceId) {
        this.roleResourceId = roleResourceId;
    }

    /**
	 * 获取角色编号
	 *
	 * @return role_id - 角色编号
	 */
    public String getRoleId() {
        return roleId;
    }

    /**
	 * 设置角色编号
	 *
	 * @param roleId
	 *            角色编号
	 */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
	 * 获取资源编号
	 *
	 * @return resource_id - 资源编号
	 */
    public String getResourceId() {
        return resourceId;
    }

    /**
	 * 设置资源编号
	 *
	 * @param resourceId
	 *            资源编号
	 */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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

}