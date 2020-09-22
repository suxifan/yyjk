package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cictec.yyjk.fatigue.model.view.CanDataValue;

@Table(name = "temp_pl_t_warn")
public class TWarn {
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
	 * 审核时间
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
	 * 报警次数
	 */
	@Column(name = "warn_number")
	private String warnNumber;
	/**
	 * 该天该设备的报警次数
	 */
	@Column(name = "device_warn_number")
	private String deviceWarnNumber;
	/**
	 * 同设备同天疲劳报警的报警ID
	 */
	private String warnUuids;
	/**
	 * 同设备同天疲劳报警的报警时间
	 */
	private String warnTimes;
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

	private String warnAddress;

	private String orgUuid;

	/*
	 * 车辆在线状态
	 */
	private String busState;

	public String getOrgUuid() {
		return orgUuid;
	}

	public void setOrgUuid(String orgUuid) {
		this.orgUuid = orgUuid;
	}

	public String getWarnAddress() {
		return warnAddress;
	}

	public void setWarnAddress(String warnAddress) {
		this.warnAddress = warnAddress;
	}

	public String getDriverIccard() {
		return driverIccard;
	}

	public void setDriverIccard(String driverIccard) {
		this.driverIccard = driverIccard;
	}

	public String getWarnUuids() {
		return warnUuids;
	}

	public void setWarnUuids(String warnUuids) {
		this.warnUuids = warnUuids;
	}

	public String getWarnTimes() {
		return warnTimes;
	}

	public void setWarnTimes(String warnTimes) {
		this.warnTimes = warnTimes;
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

	public TWarn() {
		super();
	}

	public TWarn(String warnUuid, String deviceId, String deviceCode, String warnType, Date warnTime, Date createTime,
			String lat, String lng, String speed, Date warnDate, String warnLevel) {
		super();
		this.warnUuid = warnUuid;
		this.deviceId = deviceId;
		this.deviceCode = deviceCode;
		this.warnType = warnType;
		this.warnTime = warnTime;
		this.createTime = createTime;
		this.lat = lat;
		this.lng = lng;
		this.speed = speed;
		this.warnLevel = warnLevel;
		this.warnDate = warnDate;
	}

	@Transient
	private String deviceType;

	@Transient
	private String orgName;// 机构名称

	@Transient
	private String busPlateNumber;// 车牌号

	@Transient
	private String busUuid;// 车辆uuid

	@Transient
	private String busSelfCode;// 车辆自编号

	@Transient
	private String devCode; // 设备编号
	@Transient
	private String devRefId; // 设备编号
	@Transient
	private String devUuid;// 设备Uuid
	@Transient
	private String busDevUuid;// 设备（调度）Uuid

	public String getBusDevUuid() {
		return busDevUuid;
	}

	public void setBusDevUuid(String busDevUuid) {
		this.busDevUuid = busDevUuid;
	}

	public String getDevUuid() {
		return devUuid;
	}

	public void setDevUuid(String devUuid) {
		this.devUuid = devUuid;
	}

	public String getDevRefId() {
		return devRefId;
	}

	public void setDevRefId(String devRefId) {
		this.devRefId = devRefId;
	}

	@Transient
	private String warnTypeName;// 报警类型名称

	@Transient
	private Object[] warnPicList;// 图片集合

	@Transient
	private Object[] pigePicList;// 图片集合 抓拍

	public Object[] getPigePicList() {
		return pigePicList;
	}

	public void setPigePicList(Object[] pigePicList) {
		this.pigePicList = pigePicList;
	}

	@Transient
	private Object[] warnMediaList;// 视频集合

	@Transient
	private List<TempBusOverWarnTrail> warnTrails;// 超速报警轨迹

	@Transient
	private List<CanDataValue> canDatas;// can数据

	@Transient
	private Date warnStartTime;// 告警开始时间

	@Transient
	private String duration;// 时长

	private String mediaUrl;

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	/**
	 * 是否超时 true未超时 false已超时
	 */
	@Transient
	private boolean overTime;

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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getWarnTypeName() {
		return warnTypeName;
	}

	public void setWarnTypeName(String warnTypeName) {
		this.warnTypeName = warnTypeName;
	}

	public Object[] getWarnPicList() {
		return warnPicList;
	}

	public void setWarnPicList(Object[] warnPicList) {
		this.warnPicList = warnPicList;
	}

	public Object[] getWarnMediaList() {
		return warnMediaList;
	}

	public void setWarnMediaList(Object[] warnMediaList) {
		this.warnMediaList = warnMediaList;
	}

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Date getWarnDate() {
		return warnDate;
	}

	public void setWarnDate(Date warnDate) {
		this.warnDate = warnDate;
	}

	public List<TempBusOverWarnTrail> getWarnTrails() {
		return warnTrails;
	}

	public void setWarnTrails(List<TempBusOverWarnTrail> warnTrails) {
		this.warnTrails = warnTrails;
	}

	public Date getWarnStartTime() {
		return warnStartTime;
	}

	public void setWarnStartTime(Date warnStartTime) {
		this.warnStartTime = warnStartTime;
	}

	public Date getWarnEndTime() {
		return warnEndTime;
	}

	public void setWarnEndTime(Date warnEndTime) {
		this.warnEndTime = warnEndTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	public List<CanDataValue> getCanDatas() {
		return canDatas;
	}

	public void setCanDatas(List<CanDataValue> canDatas) {
		this.canDatas = canDatas;
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

	public boolean isOverTime() {
		return overTime;
	}

	public void setOverTime(boolean overTime) {
		this.overTime = overTime;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getWarnNumber() {
		return warnNumber;
	}

	public void setWarnNumber(String warnNumber) {
		this.warnNumber = warnNumber;
	}

	public String getDeviceWarnNumber() {
		return deviceWarnNumber;
	}

	public void setDeviceWarnNumber(String deviceWarnNumber) {
		this.deviceWarnNumber = deviceWarnNumber;
	}

	public String getLineUuid() {
		return lineUuid;
	}

	public void setLineUuid(String lineUuid) {
		this.lineUuid = lineUuid;
	}

	public String getBusState() {
		return busState;
	}

	public void setBusState(String busState) {
		this.busState = busState;
	}

}