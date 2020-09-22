package com.cictec.yyjk.base.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "base_access_page_log")
public class BaseAccessPageLog {
    /**
     * 主键uuid
     */
    @Id
    @Column(name = "log_uuid")
    private Long logUuid;

    /**
     * 机构uuid
     */
    @Column(name = "org_uuid")
    private String orgUuid;

    @Column(name = "user_uuid")
    private String userUuid;

    /**
     * 角色uuid
     */
    @Column(name = "role_uuid")
    private String roleUuid;

    /**
     * 访问模块名称
     */
    @Column(name = "access_model_name")
    private String accessModelName;

    /**
     * 访问页面名称
     */
    @Column(name = "access_page_name")
    private String accessPageName;

    /**
     * 访问IP地址
     */
    @Column(name = "access_ip")
    private String accessIp;

    /**
     * 访问时间
     */
    @Column(name = "access_time")
    private Date accessTime;

    /**
     * 访问时长（毫秒）
     */
    @Column(name = "access_duration")
    private Long accessDuration;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * @param logUuid 主键uuid
     */
    public void setLogUuid(Long logUuid) {
        this.logUuid = logUuid;
    }

    /**
     * 获取机构uuid
     *
     * @return org_uuid - 机构uuid
     */
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
     * 设置机构uuid
     *
     * @param orgUuid 机构uuid
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
     * 获取角色uuid
     *
     * @return role_uuid - 角色uuid
     */
    public String getRoleUuid() {
        return roleUuid;
    }

    /**
     * 设置角色uuid
     *
     * @param roleUuid 角色uuid
     */
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    /**
     * 获取访问模块名称
     *
     * @return access_model_name - 访问模块名称
     */
    public String getAccessModelName() {
        return accessModelName;
    }

    /**
     * 设置访问模块名称
     *
     * @param accessModelName 访问模块名称
     */
    public void setAccessModelName(String accessModelName) {
        this.accessModelName = accessModelName;
    }

    /**
     * 获取访问页面名称
     *
     * @return access_page_name - 访问页面名称
     */
    public String getAccessPageName() {
        return accessPageName;
    }

    /**
     * 设置访问页面名称
     *
     * @param accessPageName 访问页面名称
     */
    public void setAccessPageName(String accessPageName) {
        this.accessPageName = accessPageName;
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
     * @param accessIp 访问IP地址
     */
    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    /**
     * 获取访问时间
     *
     * @return access_time - 访问时间
     */
    public Date getAccessTime() {
        return accessTime;
    }

    /**
     * 设置访问时间
     *
     * @param accessTime 访问时间
     */
    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    /**
     * 获取访问时长（毫秒）
     *
     * @return access_duration - 访问时长（毫秒）
     */
    public Long getAccessDuration() {
        return accessDuration;
    }

    /**
     * 设置访问时长（毫秒）
     *
     * @param accessDuration 访问时长（毫秒）
     */
    public void setAccessDuration(Long accessDuration) {
        this.accessDuration = accessDuration;
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
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}