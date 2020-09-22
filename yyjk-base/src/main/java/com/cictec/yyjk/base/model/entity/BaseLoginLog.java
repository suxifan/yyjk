package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

@Table(name = "base_login_log")
public class BaseLoginLog {
    /**
	 * 主键uuid
	 */
    @Id
	@KeySql(sql = "select nextval('base_login_log_log_uuid_seq'::regclass)", order = ORDER.BEFORE)
    @Column(name = "log_uuid")
    private Long logUuid;

    @Column(name = "org_uuid")
    private String orgUuid;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "role_uuid")
    private String roleUuid;

    /**
	 * 访问IP地址
	 */
    @Column(name = "access_ip")
    private String accessIp;

    /**
	 * 访问渠道
	 */
    @Column(name = "access_channel")
    private String accessChannel;

    /**
	 * 登录时间
	 */
    @Column(name = "access_time")
    private Date accessTime;

    /**
	 * 访问模块1：登录；2：登出
	 */
    @Column(name = "access_model")
    private String accessModel;

    /**
	 * 创建时间
	 */
    @Column(name = "create_time")
    private Date createTime;

	@Transient
	private String orgName;

	@Transient
	private String userAccount;

	@Transient
	private String roleName;

    /**
	 * 获取主键uuid
	 *
	 * @return log_uuid - 主键uuid
	 */
    public Long getLogUuid() {
        return logUuid;
    }

    /**
	 * 设置主键uuid
	 *
	 * @param logUuid
	 *            主键uuid
	 */
    public void setLogUuid(Long logUuid) {
        this.logUuid = logUuid;
    }

    /**
     * @return org_uuid
     */
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
     * @param orgUuid
     */
    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    /**
     * @return user_uuid
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * @param userUuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    /**
     * @return role_uuid
     */
    public String getRoleUuid() {
        return roleUuid;
    }

    /**
     * @param roleUuid
     */
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    /**
	 * 获取访问IP地址
	 *
	 * @return access_ip - 访问IP地址
	 */
    public String getAccessIp() {
        return accessIp;
    }

    /**
	 * 设置访问IP地址
	 *
	 * @param accessIp
	 *            访问IP地址
	 */
    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    /**
	 * 获取访问渠道
	 *
	 * @return access_channel - 访问渠道
	 */
    public String getAccessChannel() {
        return accessChannel;
    }

    /**
	 * 设置访问渠道
	 *
	 * @param accessChannel
	 *            访问渠道
	 */
    public void setAccessChannel(String accessChannel) {
        this.accessChannel = accessChannel;
    }

    /**
	 * 获取登录时间
	 *
	 * @return access_time - 登录时间
	 */
    public Date getAccessTime() {
        return accessTime;
    }

    /**
	 * 设置登录时间
	 *
	 * @param accessTime
	 *            登录时间
	 */
    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    /**
	 * 获取访问模块
	 *
	 * @return access_model - 访问模块
	 */
    public String getAccessModel() {
        return accessModel;
    }

    /**
	 * 设置访问模块
	 *
	 * @param accessModel
	 *            访问模块
	 */
    public void setAccessModel(String accessModel) {
        this.accessModel = accessModel;
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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}