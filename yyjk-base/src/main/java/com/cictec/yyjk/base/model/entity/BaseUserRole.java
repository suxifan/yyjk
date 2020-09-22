package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

@Table(name = "base_user_role")
public class BaseUserRole {
    /**
	 * 用户角色主键
	 */
    @Id
	@KeySql(sql = "select nextval('base_user_role_id_seq'::regclass)", order = ORDER.BEFORE)
    @Column(name = "user_role_id")
    private String userRoleId;

    /**
	 * 用户编号
	 */
    @Column(name = "user_id")
    private String userId;

    /**
	 * 角色编号
	 */
    @Column(name = "role_id")
    private String roleId;

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
	 * 获取用户角色主键
	 *
	 * @return user_role_id - 用户角色主键
	 */
    public String getUserRoleId() {
        return userRoleId;
    }

    /**
	 * 设置用户角色主键
	 *
	 * @param userRoleId
	 *            用户角色主键
	 */
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
	 * 获取用户编号
	 *
	 * @return user_id - 用户编号
	 */
    public String getUserId() {
        return userId;
    }

    /**
	 * 设置用户编号
	 *
	 * @param userId
	 *            用户编号
	 */
    public void setUserId(String userId) {
        this.userId = userId;
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