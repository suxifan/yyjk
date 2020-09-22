package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

@Table(name = "base_role_lineresource")
public class BaseRoleLineresource {
    /**
	 * 主键
	 */
    @Id
	@KeySql(sql = "select nextval('base_role_lineresource_role_data_id_seq'::regclass)", order = ORDER.BEFORE)
	@Column(name = "role_line_id")
    private String roleLineId;

    /**
	 * 角色id
	 */
	@NotBlank(message = "角色外键不能为空")
	@Column(name = "role_id")
    private String roleId;

    /**
	 * 数据权限id
	 */
	@NotBlank(message = "线路外键不能为空")
	@Column(name = "line_resource_id")
    private String lineResourceId;

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
	 * @return role_line_id - 主键
	 */
    public String getRoleLineId() {
        return roleLineId;
    }

    /**
	 * 设置主键
	 *
	 * @param roleLineId
	 *            主键
	 */
    public void setRoleLineId(String roleLineId) {
        this.roleLineId = roleLineId;
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
	 * @return line_resource_id - 数据权限id
	 */
    public String getLineResourceId() {
        return lineResourceId;
    }

    /**
	 * 设置数据权限id
	 *
	 * @param lineResourceId
	 *            数据权限id
	 */
    public void setLineResourceId(String lineResourceId) {
        this.lineResourceId = lineResourceId;
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