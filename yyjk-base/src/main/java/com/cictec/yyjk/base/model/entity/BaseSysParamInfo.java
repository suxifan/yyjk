package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "base_sys_param_info")
public class BaseSysParamInfo {
	@Id
	@Column(name = "sys_uuid")
	private Integer sysUuid;

	@Column(name = "param_name")
	private String paramName;

	@Column(name = "param_value")
	private String paramValue;

	@Column(name = "param_isvalid")
	private String paramIsvalid;

	@Column(name = "crate_time")
	private Date crateTime;

	@Column(name = "remark")
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return sys_uuid
	 */
	public Integer getSysUuid() {
		return sysUuid;
	}

	/**
	 * @param sysUuid
	 */
	public void setSysUuid(Integer sysUuid) {
		this.sysUuid = sysUuid;
	}

	/**
	 * @return param_name
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * @param paramName
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * @return param_value
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * @param paramValue
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 * @return param_isvalid
	 */
	public String getParamIsvalid() {
		return paramIsvalid;
	}

	/**
	 * @param paramIsvalid
	 */
	public void setParamIsvalid(String paramIsvalid) {
		this.paramIsvalid = paramIsvalid;
	}

	/**
	 * @return crate_time
	 */
	public Date getCrateTime() {
		return crateTime;
	}

	/**
	 * @param crateTime
	 */
	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}
}