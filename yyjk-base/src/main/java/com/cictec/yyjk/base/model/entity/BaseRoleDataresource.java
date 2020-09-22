package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

@Table(name = "base_role_dataresource")
public class BaseRoleDataresource {
    /**
	 * 主键
	 */
    @Id
	@KeySql(sql = "select nextval('base_role_dataresource_role_data_id_seq'::regclass)", order = ORDER.BEFORE)
    @Column(name = "role_data_id")
    private String roleDataId;

    /**
	 * 角色id
	 */
    @Column(name = "role_id")
    private String roleId;

    /**
	 * 数据权限id
	 */
    @Column(name = "data_resource_id")
    private String dataResourceId;

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
	 * 获取主键
	 *
	 * @return role_data_id - 主键
	 */
    public String getRoleDataId() {
        return roleDataId;
    }

    /**
	 * 设置主键
	 *
	 * @param roleDataId
	 *            主键
	 */
    public void setRoleDataId(String roleDataId) {
        this.roleDataId = roleDataId;
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
	 * 获取数据权限id
	 *
	 * @return data_resource_id - 数据权限id
	 */
    public String getDataResourceId() {
        return dataResourceId;
    }

    /**
	 * 设置数据权限id
	 *
	 * @param dataResourceId
	 *            数据权限id
	 */
    public void setDataResourceId(String dataResourceId) {
        this.dataResourceId = dataResourceId;
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