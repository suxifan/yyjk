package com.cictec.yyjk.timingtask.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by xpguo on 2020/07/09.
 */
public class TSafeDeviceRidControlVo extends AbstractVo {
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

	private List<String> lineUuids = new ArrayList<>();
	private List<String> busUuids = new ArrayList<>();

	/**
	 * 线路名称
	 */
	private String lineName;

	/**
	 * 异常报警时间
	 */
	private Date warnTime;

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

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public List<String> getBusUuids() {
		return busUuids;
	}

	public void setBusUuids(List<String> busUuids) {
		this.busUuids = busUuids;
	}

}
