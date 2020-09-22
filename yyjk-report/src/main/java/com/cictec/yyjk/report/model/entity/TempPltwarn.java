package com.cictec.yyjk.report.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "temp_pl_t_warn")
public class TempPltwarn {
	@Id
	@Column(name = "warn_uuid")
	private String warnUuid;

	@Column(name = "device_id")
	private String deviceId;

	@Column(name = "device_code")
	private String deviceCode;

	@Column(name = "warn_type")
	private String warnType;

	@Column(name = "warn_time")
	private Date warnTime;

	@Column(name = "warn_id")
	private String warnId;

	@Column(name = "warn_content")
	private String warnContent;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "hex_location_buf")
	private String hexLocationBuf;

	private String lat;

	private String lng;

	private String speed;

	@Column(name = "warn_source")
	private String warnSource;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "driver_num")
	private String driverNum;

	/**
	 * 告警级别
	 */
	@Column(name = "warn_level")
	private String warnLevel;

	/**
	 * 告警日期
	 */
	@Column(name = "warn_date")
	private Date warnDate;

	/**
	 * 告警结束时间
	 */
	@Column(name = "warn_end_time")
	private Date warnEndTime;

	/**
	 * 告警结束经度
	 */
	@Column(name = "warn_end_lng")
	private String warnEndLng;

	/**
	 * 告警结束维度
	 */
	@Column(name = "warn_end_lat")
	private String warnEndLat;

	/**
	 * 处理结果（0：未处理；1：已处理）
	 */
	@Column(name = "handle_result")
	private String handleResult;

	/**
	 * 
	 * 处理意见
	 */
	@Column(name = "handle_suggestion")
	private String handleSuggestion;

	/**
	 * 处理账号
	 */
	@Column(name = "handle_user")
	private String handleUser;

	/**
	 * 处理时间
	 */
	@Column(name = "handle_time")
	private Date handleTime;

	/**
	 * 审核状态 0未审核 1已审核
	 */
	@Column(name = "audit_status")
	private String auditStatus;

	/**
	 * 审核意见
	 */
	@Column(name = "audit_suggestion")
	private String auditSuggestion;

	/**
	 * 审批时间
	 */
	@Column(name = "audit_time")
	private Date auditTime;

	/**
	 * 审核人
	 */
	@Column(name = "audit_user")
	private String auditUser;

	/**
	 * 抄送人
	 */
	@Column(name = "cc")
	private String cc;

	/**
	 * 抄送时间
	 */
	@Column(name = "cc_time")
	private Date ccTime;

	/**
	 * 线路UUID
	 */
	@Column(name = "line_uuid")
	private String lineUuid;

	/**
	 * 线路名称
	 */
	@Column(name = "line_name")
	private String lineName;

	/**
	 * 司机IC卡号
	 */
	@Column(name = "driver_iccard")
	private String driverIccard;

	public String getLineUuid() {
		return lineUuid;
	}

	public void setLineUuid(String lineUuid) {
		this.lineUuid = lineUuid;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getDriverIccard() {
		return driverIccard;
	}

	public void setDriverIccard(String driverIccard) {
		this.driverIccard = driverIccard;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public Date getCcTime() {
		return ccTime;
	}

	public void setCcTime(Date ccTime) {
		this.ccTime = ccTime;
	}

	public void setWarnEndTime(Date warnEndTime) {
		this.warnEndTime = warnEndTime;
	}

	public Date getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

	public String getHandleUser() {
		return handleUser;
	}

	public void setHandleUser(String handleUser) {
		this.handleUser = handleUser;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditSuggestion() {
		return auditSuggestion;
	}

	public void setAuditSuggestion(String auditSuggestion) {
		this.auditSuggestion = auditSuggestion;
	}

	public String getHandleSuggestion() {
		return handleSuggestion;
	}

	public void setHandleSuggestion(String handleSuggestion) {
		this.handleSuggestion = handleSuggestion;
	}

	/**
	 * @return warn_uuid
	 */
	public String getWarnUuid() {
		return warnUuid;
	}

	/**
	 * @param warnUuid
	 */
	public void setWarnUuid(String warnUuid) {
		this.warnUuid = warnUuid;
	}

	/**
	 * @return device_id
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return device_code
	 */
	public String getDeviceCode() {
		return deviceCode;
	}

	/**
	 * @param deviceCode
	 */
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	/**
	 * @return warn_type
	 */
	public String getWarnType() {
		return warnType;
	}

	/**
	 * @param warnType
	 */
	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

	/**
	 * @return warn_time
	 */
	public Date getWarnTime() {
		return warnTime;
	}

	/**
	 * @param warnTime
	 */
	public void setWarnTime(Date warnTime) {
		this.warnTime = warnTime;
	}

	/**
	 * @return warn_id
	 */
	public String getWarnId() {
		return warnId;
	}

	/**
	 * @param warnId
	 */
	public void setWarnId(String warnId) {
		this.warnId = warnId;
	}

	/**
	 * @return warn_content
	 */
	public String getWarnContent() {
		return warnContent;
	}

	/**
	 * @param warnContent
	 */
	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
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
	 * @return hex_location_buf
	 */
	public String getHexLocationBuf() {
		return hexLocationBuf;
	}

	/**
	 * @param hexLocationBuf
	 */
	public void setHexLocationBuf(String hexLocationBuf) {
		this.hexLocationBuf = hexLocationBuf;
	}

	/**
	 * @return lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return speed
	 */
	public String getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
	}

	/**
	 * @return warn_source
	 */
	public String getWarnSource() {
		return warnSource;
	}

	/**
	 * @param warnSource
	 */
	public void setWarnSource(String warnSource) {
		this.warnSource = warnSource;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public Date getWarnDate() {
		return warnDate;
	}

	public void setWarnDate(Date warnDate) {
		this.warnDate = warnDate;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getWarnEndLng() {
		return warnEndLng;
	}

	public void setWarnEndLng(String warnEndLng) {
		this.warnEndLng = warnEndLng;
	}

	public String getWarnEndLat() {
		return warnEndLat;
	}

	public void setWarnEndLat(String warnEndLat) {
		this.warnEndLat = warnEndLat;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Date getWarnEndTime() {
		return warnEndTime;
	}

}