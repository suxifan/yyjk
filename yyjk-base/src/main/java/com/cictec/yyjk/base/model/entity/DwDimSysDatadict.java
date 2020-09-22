package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "dw_dim_sys_datadict")
public class DwDimSysDatadict {
    @Id
	private String uuid;

    /**
	 * 数据类型类型code，不能重复
	 */
    @Column(name = "type_code")
    private String typeCode;

    /**
	 * 编码值（同一编码code内，不能重复）
	 */
	@Column(name = "type_value")
	private String typeValue;

    /**
	 * 显示值
	 */
    private String display;

    /**
	 * 显示顺序
	 */
    private Short sort;

    /**
	 * 状态（1：启用 0：禁用）
	 */
    private String isvalid;

    /**
	 * 备注
	 */
    private String remark;

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

	@Transient
	private String typeName;

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
	 * 获取数据类型类型code，不能重复
	 *
	 * @return type_code - 数据类型类型code，不能重复
	 */
    public String getTypeCode() {
        return typeCode;
    }

    /**
	 * 设置数据类型类型code，不能重复
	 *
	 * @param typeCode
	 *            数据类型类型code，不能重复
	 */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
	 * 获取编码值（同一编码code内，不能重复）
	 *
	 * @return value - 编码值（同一编码code内，不能重复）
	 */
	public String getTypeValue() {
		return typeValue;
    }

    /**
	 * 设置编码值（同一编码code内，不能重复）
	 *
	 * @param value
	 *            编码值（同一编码code内，不能重复）
	 */
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
    }

    /**
	 * 获取显示值
	 *
	 * @return display - 显示值
	 */
    public String getDisplay() {
        return display;
    }

    /**
	 * 设置显示值
	 *
	 * @param display
	 *            显示值
	 */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
	 * 获取显示顺序
	 *
	 * @return sort - 显示顺序
	 */
    public Short getSort() {
        return sort;
    }

    /**
	 * 设置显示顺序
	 *
	 * @param sort
	 *            显示顺序
	 */
    public void setSort(Short sort) {
        this.sort = sort;
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

    /**
	 * 获取备注
	 *
	 * @return remark - 备注
	 */
    public String getRemark() {
        return remark;
    }

    /**
	 * 设置备注
	 *
	 * @param remark
	 *            备注
	 */
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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