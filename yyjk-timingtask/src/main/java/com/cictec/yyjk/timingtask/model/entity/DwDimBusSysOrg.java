package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_bus_sys_org")
public class DwDimBusSysOrg {
    /**
	 * 组织机构编号
	 */
    @Id
    @Column(name = "org_uuid")
    private String orgUuid;

    /**
	 * 组织机构名称
	 */
    @Column(name = "org_name")
    private String orgName;

    /**
	 * 组织机构类型0:总公司 2：分公司 3：路队4：部门
	 */
    @Column(name = "org_type")
    private Integer orgType;

    /**
	 * 上级机构
	 */
    @Column(name = "org_parent_uuid")
    private String orgParentUuid;

    /**
	 * 是否启用（1：启用0：禁用）
	 */
    @Column(name = "org_enabled")
    private String orgEnabled;

    /**
	 * 排序号
	 */
    @Column(name = "org_sort_index")
    private Integer orgSortIndex;

    /**
	 * 创建时间
	 */
    @Column(name = "org_create_time")
    private Date orgCreateTime;

    /**
	 * 简称
	 */
    @Column(name = "org_short_name")
    private String orgShortName;

    /**
	 * 逻辑删除标识符
	 */
    @Column(name = "org_drop_flag")
    private String orgDropFlag;


	public DwDimBusSysOrg() {
		super();
	}

	public DwDimBusSysOrg(String orgUuid, String orgName, Integer orgType, String orgParentUuid, String orgEnabled,
			Integer orgSortIndex, Date orgCreateTime, String orgShortName, String orgDropFlag) {
		super();
		this.orgUuid = orgUuid;
		this.orgName = orgName;
		this.orgType = orgType;
		this.orgParentUuid = orgParentUuid;
		this.orgEnabled = orgEnabled;
		this.orgSortIndex = orgSortIndex;
		this.orgCreateTime = orgCreateTime;
		this.orgShortName = orgShortName;
		this.orgDropFlag = orgDropFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orgCreateTime == null) ? 0 : orgCreateTime.hashCode());
		result = prime * result + ((orgDropFlag == null) ? 0 : orgDropFlag.hashCode());
		result = prime * result + ((orgEnabled == null) ? 0 : orgEnabled.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((orgParentUuid == null) ? 0 : orgParentUuid.hashCode());
		result = prime * result + ((orgShortName == null) ? 0 : orgShortName.hashCode());
		result = prime * result + ((orgSortIndex == null) ? 0 : orgSortIndex.hashCode());
		result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
		result = prime * result + ((orgUuid == null) ? 0 : orgUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DwDimBusSysOrg other = (DwDimBusSysOrg) obj;
		if (orgCreateTime == null) {
			if (other.orgCreateTime != null)
				return false;
		} else if (!orgCreateTime.equals(other.orgCreateTime))
			return false;
		if (orgDropFlag == null) {
			if (other.orgDropFlag != null)
				return false;
		} else if (!orgDropFlag.equals(other.orgDropFlag))
			return false;
		if (orgEnabled == null) {
			if (other.orgEnabled != null)
				return false;
		} else if (!orgEnabled.equals(other.orgEnabled))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (orgParentUuid == null) {
			if (other.orgParentUuid != null)
				return false;
		} else if (!orgParentUuid.equals(other.orgParentUuid))
			return false;
		if (orgShortName == null) {
			if (other.orgShortName != null)
				return false;
		} else if (!orgShortName.equals(other.orgShortName))
			return false;
		if (orgSortIndex == null) {
			if (other.orgSortIndex != null)
				return false;
		} else if (!orgSortIndex.equals(other.orgSortIndex))
			return false;
		if (orgType == null) {
			if (other.orgType != null)
				return false;
		} else if (!orgType.equals(other.orgType))
			return false;
		if (orgUuid == null) {
			if (other.orgUuid != null)
				return false;
		} else if (!orgUuid.equals(other.orgUuid))
			return false;
		return true;
	}

	/**
	 * 获取组织机构编号
	 *
	 * @return org_uuid - 组织机构编号
	 */
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
	 * 设置组织机构编号
	 *
	 * @param orgUuid
	 *            组织机构编号
	 */
    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    /**
	 * 获取组织机构名称
	 *
	 * @return org_name - 组织机构名称
	 */
    public String getOrgName() {
        return orgName;
    }

    /**
	 * 设置组织机构名称
	 *
	 * @param orgName
	 *            组织机构名称
	 */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
	 * 获取组织机构类型0:总公司 2：分公司 3：路队4：部门
	 *
	 * @return org_type - 组织机构类型0:总公司 2：分公司 3：路队4：部门
	 */
    public Integer getOrgType() {
        return orgType;
    }

    /**
	 * 设置组织机构类型0:总公司 2：分公司 3：路队4：部门
	 *
	 * @param orgType
	 *            组织机构类型0:总公司 2：分公司 3：路队4：部门
	 */
    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    /**
	 * 获取上级机构
	 *
	 * @return org_parent_uuid - 上级机构
	 */
    public String getOrgParentUuid() {
        return orgParentUuid;
    }

    /**
	 * 设置上级机构
	 *
	 * @param orgParentUuid
	 *            上级机构
	 */
    public void setOrgParentUuid(String orgParentUuid) {
        this.orgParentUuid = orgParentUuid;
    }

    /**
	 * 获取是否启用（1：启用0：禁用）
	 *
	 * @return org_enabled - 是否启用（1：启用0：禁用）
	 */
    public String getOrgEnabled() {
        return orgEnabled;
    }

    /**
	 * 设置是否启用（1：启用0：禁用）
	 *
	 * @param orgEnabled
	 *            是否启用（1：启用0：禁用）
	 */
    public void setOrgEnabled(String orgEnabled) {
        this.orgEnabled = orgEnabled;
    }

    /**
	 * 获取排序号
	 *
	 * @return org_sort_index - 排序号
	 */
    public Integer getOrgSortIndex() {
        return orgSortIndex;
    }

    /**
	 * 设置排序号
	 *
	 * @param orgSortIndex
	 *            排序号
	 */
    public void setOrgSortIndex(Integer orgSortIndex) {
        this.orgSortIndex = orgSortIndex;
    }

    /**
	 * 获取创建时间
	 *
	 * @return org_create_time - 创建时间
	 */
    public Date getOrgCreateTime() {
        return orgCreateTime;
    }

    /**
	 * 设置创建时间
	 *
	 * @param orgCreateTime
	 *            创建时间
	 */
    public void setOrgCreateTime(Date orgCreateTime) {
        this.orgCreateTime = orgCreateTime;
    }

    /**
	 * 获取简称
	 *
	 * @return org_short_name - 简称
	 */
    public String getOrgShortName() {
        return orgShortName;
    }

    /**
	 * 设置简称
	 *
	 * @param orgShortName
	 *            简称
	 */
    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }

    /**
	 * 获取逻辑删除标识符
	 *
	 * @return org_drop_flag - 逻辑删除标识符
	 */
    public String getOrgDropFlag() {
        return orgDropFlag;
    }

    /**
	 * 设置逻辑删除标识符
	 *
	 * @param orgDropFlag
	 *            逻辑删除标识符
	 */
    public void setOrgDropFlag(String orgDropFlag) {
        this.orgDropFlag = orgDropFlag;
    }
}