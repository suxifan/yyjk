package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;


@Table(name = "base_resource_info")
public class BaseResourceInfo {
    /**
	 * 全局唯一编号
	 */
    @Id
	@KeySql(sql = "select nextval('base_resource_info_id_seq'::regclass)", order = ORDER.BEFORE)
    @Column(name = "resource_id")
	private String resourceId;

    /**
	 * 对应的是模块name;只有菜单级别有
	 */
    @Column(name = "resource_name")
    private String resourceName;

    /**
	 * 父级菜单
	 */
	@Column(name = "resource_parent_id")
	private String resourceParentId;

    /**
	 * 1.根节点2.菜单级别3.按钮级别
	 */
    @Column(name = "resource_type")
    private String resourceType;

    /**
	 * title资源标题(对应按钮级别的name和菜单级别的title)
	 */
    @Column(name = "resource_title")
    private String resourceTitle;

    /**
	 * 资源链接(对应菜单级别的path和按钮级别的click)
	 */
    @Column(name = "resource_url")
    private String resourceUrl;

	/**
	 * 1.模块 ，2.页面
	 */
	@Column(name = "resource_level")
	private String resourceLevel;

    /**
	 * 排序字段
	 */
    @Column(name = "resource_sort")
    private Short resourceSort;

    /**
	 * 所对应有的icon
	 */
    @Column(name = "resource_image")
    private String resourceImage;

    /**
	 * 组件
	 */
	@Column(name = "resource_component")
	private String resourceComponent;

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
	 * 获取全局唯一编号
	 *
	 * @return resource_id - 全局唯一编号
	 */
	public String getResourceId() {
        return resourceId;
    }

    /**
	 * 设置全局唯一编号
	 *
	 * @param resourceId
	 *            全局唯一编号
	 */
	public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
	 * 获取对应的是模块name;只有菜单级别有
	 *
	 * @return resource_name - 对应的是模块name;只有菜单级别有
	 */
    public String getResourceName() {
        return resourceName;
    }

    /**
	 * 设置对应的是模块name;只有菜单级别有
	 *
	 * @param resourceName
	 *            对应的是模块name;只有菜单级别有
	 */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
	 * 获取父级菜单
	 *
	 * @return resource_parent_sid - 父级菜单
	 */
	public String getResourceParentId() {
		return resourceParentId;
    }

    /**
	 * 设置父级菜单
	 *
	 * @param resourceParentSid
	 *            父级菜单
	 */
	public void setResourceParentId(String resourceParentId) {
		this.resourceParentId = resourceParentId;
    }

    /**
	 * 获取1.根节点2.菜单级别3.按钮级别
	 *
	 * @return resource_type - 1.根节点2.菜单级别3.按钮级别
	 */
    public String getResourceType() {
        return resourceType;
    }

    /**
	 * 设置1.根节点2.菜单级别3.按钮级别
	 *
	 * @param resourceType
	 *            1.根节点2.菜单级别3.按钮级别
	 */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
	 * 获取title资源标题(对应按钮级别的name和菜单级别的title)
	 *
	 * @return resource_title - title资源标题(对应按钮级别的name和菜单级别的title)
	 */
    public String getResourceTitle() {
        return resourceTitle;
    }

    /**
	 * 设置title资源标题(对应按钮级别的name和菜单级别的title)
	 *
	 * @param resourceTitle
	 *            title资源标题(对应按钮级别的name和菜单级别的title)
	 */
    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    /**
	 * 获取资源链接(对应菜单级别的path和按钮级别的click)
	 *
	 * @return resource_url - 资源链接(对应菜单级别的path和按钮级别的click)
	 */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
	 * 设置资源链接(对应菜单级别的path和按钮级别的click)
	 *
	 * @param resourceUrl
	 *            资源链接(对应菜单级别的path和按钮级别的click)
	 */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
	 * 获取排序字段
	 *
	 * @return resource_sort - 排序字段
	 */
    public Short getResourceSort() {
        return resourceSort;
    }

    /**
	 * 设置排序字段
	 *
	 * @param resourceSort
	 *            排序字段
	 */
    public void setResourceSort(Short resourceSort) {
        this.resourceSort = resourceSort;
    }

    /**
	 * 获取所对应有的icon
	 *
	 * @return resource_image - 所对应有的icon
	 */
    public String getResourceImage() {
        return resourceImage;
    }

    /**
	 * 设置所对应有的icon
	 *
	 * @param resourceImage
	 *            所对应有的icon
	 */
    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

	/**
	 * 获取组件
	 *
	 * @return resource_component - 组件
	 */
	public String getResourceComponent() {
		return resourceComponent;
	}

	/**
	 * 设置组件
	 *
	 * @return resource_component - 组件
	 */
	public void setResourceComponent(String resourceComponent) {
		this.resourceComponent = resourceComponent;
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

	public String getResourceLevel() {
		return resourceLevel;
	}

	public void setResourceLevel(String resourceLevel) {
		this.resourceLevel = resourceLevel;
	}

}