package com.cictec.yyjk.timingtask.model.viewdata;

import java.util.Date;

public class TSafeDeviceRidControlValue {
	/*
	 * 车辆UUID
	 */
	private String busUuid;
	/**
	 * 车辆自编号
	 */
	private String busSelfCode;

	/**
	 * 车牌号
	 */
	private String busNumber;

	/**
	 * 机构ID
	 */
	private String orgUuid;

	/**
	 * 机构名称
	 */
	private String orgName;

	/**
	 * 线路ID
	 */
	private String lineUuid;

	/**
	 * 线路名称
	 */
	private String lineName;

	/**
	 * 车辆在线时间
	 */
	private Date busOnlineTime;

	/**
	 * 车辆更新时间
	 */
	private Date busUpdateTime;

	/**
	 * 车辆状态
	 */
	private String busState;

	/**
	 * 异常报警时间
	 */
	private Date warnTime;

	/**
	 * 异常报警时长
	 */
	private String warnTimes;

	/**
	 * 当前状态(异常0；正常1；设备和车同时在线正常，设备不在线异常；)
	 */
	private String currentState;

	/**
	 * 设备ID
	 */
	private String devUuid;

	/**
	 * 设备编号
	 */
	private String devCode;

	/**
	 * 设备类型
	 */
	private String devModel;

	/**
	 * 设备在线时间
	 */
	private Date devOnlineTime;

	/**
	 * 设备更新时间
	 */
	private Date devUpdateTime;

	private String devState;

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getOrgUuid() {
		return orgUuid;
	}

	public void setOrgUuid(String orgUuid) {
		this.orgUuid = orgUuid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

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

	public Date getBusOnlineTime() {
		return busOnlineTime;
	}

	public void setBusOnlineTime(Date busOnlineTime) {
		this.busOnlineTime = busOnlineTime;
	}

	public Date getBusUpdateTime() {
		return busUpdateTime;
	}

	public void setBusUpdateTime(Date busUpdateTime) {
		this.busUpdateTime = busUpdateTime;
	}

	public String getBusState() {
		return busState;
	}

	public void setBusState(String busState) {
		this.busState = busState;
	}

	public Date getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(Date warnTime) {
		this.warnTime = warnTime;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
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

	public String getDevModel() {
		return devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}

	public Date getDevOnlineTime() {
		return devOnlineTime;
	}

	public void setDevOnlineTime(Date devOnlineTime) {
		this.devOnlineTime = devOnlineTime;
	}

	public Date getDevUpdateTime() {
		return devUpdateTime;
	}

	public void setDevUpdateTime(Date devUpdateTime) {
		this.devUpdateTime = devUpdateTime;
	}

	public String getDevState() {
		return devState;
	}

	public void setDevState(String devState) {
		this.devState = devState;
	}

	public String getWarnTimes() {
		return warnTimes;
	}

	public void setWarnTimes(String warnTimes) {
		this.warnTimes = warnTimes;
	}

}
