package com.cictec.yyjk.base.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "base_data_resource_info")
public class BaseDataResourceInfo {
    @Id
    @Column(name = "data_resource_id")
    private String dataResourceId;

    /**
     * 数据资源名称
     */
    @Column(name = "data_resource_name")
    private String dataResourceName;

    /**
     * 父id
     */
    @Column(name = "data_resource_parent_id")
    private String dataResourceParentId;

    /**
     * 数据资源类型
     */
    @Column(name = "data_resource_type")
    private String dataResourceType;

    /**
     * 数据资源名称
     */
    @Column(name = "data_resource_title")
    private String dataResourceTitle;

    /**
     * 排序号
     */
    @Column(name = "data_resource_sort")
    private Short dataResourceSort;

    /**
     * 是否有效1：有效；0：无效
     */
    @Column(name = "data_resource_isvalid")
    private String dataResourceIsvalid;

    /**
     * 创建者
     */
    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改者
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 描述
     */
    private String describes;

    /**
     * @return data_resource_id
     */
    public String getDataResourceId() {
        return dataResourceId;
    }

    /**
     * @param dataResourceId
     */
    public void setDataResourceId(String dataResourceId) {
        this.dataResourceId = dataResourceId;
    }

    /**
     * 获取数据资源名称
     *
     * @return data_resource_name - 数据资源名称
     */
    public String getDataResourceName() {
        return dataResourceName;
    }

    /**
     * 设置数据资源名称
     *
     * @param dataResourceName 数据资源名称
     */
    public void setDataResourceName(String dataResourceName) {
        this.dataResourceName = dataResourceName;
    }

    /**
     * 获取父id
     *
     * @return data_resource_parent_id - 父id
     */
    public String getDataResourceParentId() {
        return dataResourceParentId;
    }

    /**
     * 设置父id
     *
     * @param dataResourceParentId 父id
     */
    public void setDataResourceParentId(String dataResourceParentId) {
        this.dataResourceParentId = dataResourceParentId;
    }

    /**
     * 获取数据资源类型
     *
     * @return data_resource_type - 数据资源类型
     */
    public String getDataResourceType() {
        return dataResourceType;
    }

    /**
     * 设置数据资源类型
     *
     * @param dataResourceType 数据资源类型
     */
    public void setDataResourceType(String dataResourceType) {
        this.dataResourceType = dataResourceType;
    }

    /**
     * 获取数据资源名称
     *
     * @return data_resource_title - 数据资源名称
     */
    public String getDataResourceTitle() {
        return dataResourceTitle;
    }

    /**
     * 设置数据资源名称
     *
     * @param dataResourceTitle 数据资源名称
     */
    public void setDataResourceTitle(String dataResourceTitle) {
        this.dataResourceTitle = dataResourceTitle;
    }

    /**
     * 获取排序号
     *
     * @return data_resource_sort - 排序号
     */
    public Short getDataResourceSort() {
        return dataResourceSort;
    }

    /**
     * 设置排序号
     *
     * @param dataResourceSort 排序号
     */
    public void setDataResourceSort(Short dataResourceSort) {
        this.dataResourceSort = dataResourceSort;
    }

    /**
     * 获取是否有效1：有效；0：无效
     *
     * @return data_resource_isvalid - 是否有效1：有效；0：无效
     */
    public String getDataResourceIsvalid() {
        return dataResourceIsvalid;
    }

    /**
     * 设置是否有效1：有效；0：无效
     *
     * @param dataResourceIsvalid 是否有效1：有效；0：无效
     */
    public void setDataResourceIsvalid(String dataResourceIsvalid) {
        this.dataResourceIsvalid = dataResourceIsvalid;
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
     * @param createUser 创建者
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改者
     *
     * @return update_user - 修改者
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置修改者
     *
     * @param updateUser 修改者
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
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取描述
     *
     * @return describes - 描述
     */
    public String getDescribes() {
        return describes;
    }

    /**
     * 设置描述
     *
     * @param describes 描述
     */
    public void setDescribes(String describes) {
        this.describes = describes;
    }
}