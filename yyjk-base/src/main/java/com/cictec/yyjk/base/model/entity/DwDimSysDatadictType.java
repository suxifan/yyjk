package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_sys_datadict_type")
public class DwDimSysDatadictType {
    @Id
	private String uuid;

    /**
	 * 数据类型类型code
	 */
    @Column(name = "type_code")
    private String typeCode;

    /**
	 * 数据字典类型名称，不能重复
	 */
    @Column(name = "type_name")
    private String typeName;

    /**
	 * 状态（1：启用 0：禁用）
	 */
    private String isvalid;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 修改时间
	 */
	@Column(name = "update_time")
	private Date updateTime;

    /**
     * @return uuid
     */
	public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
	public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
	 * 获取数据类型类型code
	 *
	 * @return type_code - 数据类型类型code
	 */
    public String getTypeCode() {
        return typeCode;
    }

    /**
	 * 设置数据类型类型code
	 *
	 * @param typeCode
	 *            数据类型类型code
	 */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
	 * 获取数据字典类型名称，不能重复
	 *
	 * @return type_name - 数据字典类型名称，不能重复
	 */
    public String getTypeName() {
        return typeName;
    }

    /**
	 * 设置数据字典类型名称，不能重复
	 *
	 * @param typeName
	 *            数据字典类型名称，不能重复
	 */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
	 * 获取状态（1：启用 0：禁用）
	 *
	 * @return isvalid - 状态（1：启用 0：禁用）
	 */
    public String getIsvalid() {
        return isvalid;
    }

    /**
	 * 设置状态（1：启用 0：禁用）
	 *
	 * @param isvalid
	 *            状态（1：启用 0：禁用）
	 */
    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}