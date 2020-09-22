package com.cictec.yyjk.base.model.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "dw_dim_bus")
public class Bus {
	/**
	 * 主键
	 */
	@Id
	@Column(name = "bus_uuid")
	private String busUuid;

	/**
	 * 设备编号
	 */
	@Column(name = "bus_dev_uuid")
	private String busDevUuid;

	/**
	 * 车牌号
	 */
	@Column(name = "bus_plate_number")
	private String busPlateNumber;

	/**
	 * 车辆自编号
	 */
	@Column(name = "bus_self_code")
	private String busSelfCode;

	/**
	 * 燃料类型
	 */
	@Column(name = "bus_fuel_type")
	private String busFuelType;

	/**
	 * 启用标记1：启用0：禁用
	 */
	@Column(name = "bus_isvalid")
	private String busIsvalid;

	/**
	 * 所属机构
	 */
	@Column(name = "bus_org_uuid")
	private String busOrgUuid;

	/**
	 * 所属线路
	 */
	@Column(name = "bus_line_uuid")
	private String busLineUuid;

	/**
	 * 荷载人数
	 */
	@Column(name = "bus_load_number")
	private Integer busLoadNumber;

	/**
	 * 创建时间
	 */
	@Column(name = "bus_create_time")
	private Date busCreateTime;

	/**
	 * 删除标示 0 正常 1 删除
	 */
	@Column(name = "bus_drop_flag")
	private String busDropFlag;

	/**
	 * 车辆绑定的设备数
	 */
	@Transient
	private Integer devNum;

	/**
	 * 车辆绑定的设备信息
	 */
	@Transient
	private List<DwDimOtherDevice> deviceList;

	@Transient
	private String lineName;

	@Transient
	private String orgName;

	@Transient
	private String devUuid;

	@Transient
	private String devCode;
	@Transient
	private String voicepromptContent;
	@Transient
	private String sendTime;
	@Transient
	private String sendStatus;
	@Transient
	private List<Map> voiceMap;
	@Transient
	private String busNo;

	public List<Map> getVoiceMap() {
		return voiceMap;
	}

	public void setVoiceMap(List<Map> voiceMap) {
		this.voiceMap = voiceMap;
	}

	public String getVoicepromptContent() {
		return voicepromptContent;
	}

	public void setVoicepromptContent(String voicepromptContent) {
		this.voicepromptContent = voicepromptContent;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	/**
	 * 获取主键
	 *
	 * @return bus_uuid - 主键
	 */
	public String getBusUuid() {
		return busUuid;
	}

	/**
	 * 设置主键
	 *
	 * @param busUuid
	 *            主键
	 */
	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	/**
	 * 获取设备编号
	 *
	 * @return bus_dev_uuid - 设备编号
	 */
	public String getBusDevUuid() {
		return busDevUuid;
	}

	/**
	 * 设置设备编号
	 *
	 * @param busDevUuid
	 *            设备编号
	 */
	public void setBusDevUuid(String busDevUuid) {
		this.busDevUuid = busDevUuid;
	}

	/**
	 * 获取车牌号
	 *
	 * @return bus_plate_number - 车牌号
	 */
	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	/**
	 * 设置车牌号
	 *
	 * @param busPlateNumber
	 *            车牌号
	 */
	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	/**
	 * 获取车辆自编号
	 *
	 * @return bus_self_code - 车辆自编号
	 */
	public String getBusSelfCode() {
		return busSelfCode;
	}

	/**
	 * 设置车辆自编号
	 *
	 * @param busSelfCode
	 *            车辆自编号
	 */
	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	/**
	 * 获取燃料类型
	 *
	 * @return bus_fuel_type - 燃料类型
	 */
	public String getBusFuelType() {
		return busFuelType;
	}

	/**
	 * 设置燃料类型
	 *
	 * @param busFuelType
	 *            燃料类型
	 */
	public void setBusFuelType(String busFuelType) {
		this.busFuelType = busFuelType;
	}

	/**
	 * 获取启用标记1：启用0：禁用
	 *
	 * @return bus_isvalid - 启用标记1：启用0：禁用
	 */
	public String getBusIsvalid() {
		return busIsvalid;
	}

	/**
	 * 设置启用标记1：启用0：禁用
	 *
	 * @param busIsvalid
	 *            启用标记1：启用0：禁用
	 */
	public void setBusIsvalid(String busIsvalid) {
		this.busIsvalid = busIsvalid;
	}

	/**
	 * 获取所属机构
	 *
	 * @return bus_org_uuid - 所属机构
	 */
	public String getBusOrgUuid() {
		return busOrgUuid;
	}

	/**
	 * 设置所属机构
	 *
	 * @param busOrgUuid
	 *            所属机构
	 */
	public void setBusOrgUuid(String busOrgUuid) {
		this.busOrgUuid = busOrgUuid;
	}

	/**
	 * 获取所属线路
	 *
	 * @return bus_line_uuid - 所属线路
	 */
	public String getBusLineUuid() {
		return busLineUuid;
	}

	/**
	 * 设置所属线路
	 *
	 * @param busLineUuid
	 *            所属线路
	 */
	public void setBusLineUuid(String busLineUuid) {
		this.busLineUuid = busLineUuid;
	}

	/**
	 * 获取荷载人数
	 *
	 * @return bus_load_number - 荷载人数
	 */
	public Integer getBusLoadNumber() {
		return busLoadNumber;
	}

	/**
	 * 设置荷载人数
	 *
	 * @param busLoadNumber
	 *            荷载人数
	 */
	public void setBusLoadNumber(Integer busLoadNumber) {
		this.busLoadNumber = busLoadNumber;
	}

	/**
	 * 获取创建时间
	 *
	 * @return bus_create_time - 创建时间
	 */
	public Date getBusCreateTime() {
		return busCreateTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param busCreateTime
	 *            创建时间
	 */
	public void setBusCreateTime(Date busCreateTime) {
		this.busCreateTime = busCreateTime;
	}

	/**
	 * 获取删除标示 0 正常 1 删除
	 *
	 * @return bus_drop_flag - 删除标示 0 正常 1 删除
	 */
	public String getBusDropFlag() {
		return busDropFlag;
	}

	/**
	 * 设置删除标示 0 正常 1 删除
	 *
	 * @param busDropFlag
	 *            删除标示 0 正常 1 删除
	 */
	public void setBusDropFlag(String busDropFlag) {
		this.busDropFlag = busDropFlag;
	}

	public Integer getDevNum() {
		return devNum;
	}

	public void setDevNum(Integer devNum) {
		this.devNum = devNum;
	}

	public List<DwDimOtherDevice> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<DwDimOtherDevice> deviceList) {
		this.deviceList = deviceList;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDevUuid() {
		return devUuid;
	}

	public void setDevUuid(String devUuid) {
		this.devUuid = devUuid;
	}

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

}