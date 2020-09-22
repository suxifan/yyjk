package com.cictec.yyjk.fatigue.model.view;

import java.util.Date;
import java.util.List;

import com.cictec.yyjk.fatigue.model.entity.TWarn;

public class OverWarnDetailValue {
	private String warnType;
	private String lat;
	private String lng;
	private String speed;
	private String driverName;
	private String warnLevel;
	private String orgName;// 机构名称
	private String lineName;// 线路
	private String busPlateNumber;// 车牌号
	private String busSelfCode;// 车辆自编号
	private String devCode; // 设备编号
	private String warnTypeName;// 报警类型名称
	private List<TWarn> warnList;// 超速报警轨迹
	private Date warnStartTime;// 告警开始时间
	private Date warnEndTime;// 告警结束时间
	private String duration;// 时长

	public String getWarnType() {
		return warnType;
	}

	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public String getWarnTypeName() {
		return warnTypeName;
	}

	public void setWarnTypeName(String warnTypeName) {
		this.warnTypeName = warnTypeName;
	}

	public List<TWarn> getWarnList() {
		return warnList;
	}

	public void setWarnList(List<TWarn> warnList) {
		this.warnList = warnList;
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

}
