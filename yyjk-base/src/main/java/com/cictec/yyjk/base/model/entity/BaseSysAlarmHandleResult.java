package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "base_sys_alarm_handle_result")
public class BaseSysAlarmHandleResult {
    @Id
    private String uuid;

    /**
	 * 处理内容
	 */
	@Column(name = "handle_context")
	private String handleContext;

    /**
	 * 处理状态 1已处理 2误报
	 */
	@Column(name = "handle_status")
	private String handleStatus;

	@Column(name = "handle_isvalid")
	private String handleIsvalid;

	@Column(name = "handle_type")
	private String handleType;

    /**
	 * 创建时间
	 */
    @Column(name = "crate_time")
    private Date crateTime;
    private String remark;

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
	 * 获取处理内容
	 *
	 * @return h_context - 处理内容
	 */
	public String getHandleContext() {
		return handleContext;
    }

    /**
	 * 设置处理内容
	 *
	 * @param hContext
	 *            处理内容
	 */
	public void setHandleContext(String handleContext) {
		this.handleContext = handleContext;
    }

    /**
	 * 获取处理状态 1已处理 2误报
	 *
	 * @return h_status - 处理状态 1已处理 2误报
	 */
	public String getHandleStatus() {
		return handleStatus;
    }

    /**
	 * 设置处理状态 1已处理 2误报
	 *
	 * @param hStatus
	 *            处理状态 1已处理 2误报
	 */
	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
    }

    /**
	 * 获取创建时间
	 *
	 * @return crate_time - 创建时间
	 */
    public Date getCrateTime() {
        return crateTime;
    }

    /**
	 * 设置创建时间
	 *
	 * @param crateTime
	 *            创建时间
	 */
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    /**
     * @return h_isvalid
     */
	public String getHandleIsvalid() {
		return handleIsvalid;
    }

    /**
     * @param hIsvalid
     */
	public void setHandleIsvalid(String handleIsvalid) {
		this.handleIsvalid = handleIsvalid;
    }

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	/**
	 * @return remark
	 */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}