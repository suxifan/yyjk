package com.cictec.yyjk.report.model.vo;

public class WarnInofVo {
	private String busNumber;// 车牌号
	private String busSelfCode;// 自编号
	private String orgUuid;
	private String orgName;
	private String lineUuid;
	private String lineName;
	private String warnType;
	private String warnLabel;
	private String warnLevel;
	private String warnLevelLabel;
	private String warnTime;
	private String warnNumber;
	// 单车详情新增属性2019-08-09
	private String warnSpeed;// 报警时速
	private String warnDeviceCode;// 报警设备号

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getWarnSpeed() {
		return warnSpeed;
	}

	public void setWarnSpeed(String warnSpeed) {
		this.warnSpeed = warnSpeed;
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

	public String getWarnType() {
		return warnType;
	}

	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getWarnLevelLabel() {
		return warnLevelLabel;
	}

	public void setWarnLevelLabel(String warnLevelLabel) {
		this.warnLevelLabel = warnLevelLabel;
	}

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	public String getWarnLabel() {
		return warnLabel;
	}

	public void setWarnLabel(String warnLabel) {
		this.warnLabel = warnLabel;
	}

	public String getWarnNumber() {
		return warnNumber;
	}

	public void setWarnNumber(String warnNumber) {
		this.warnNumber = warnNumber;
	}

	public String getWarnDeviceCode() {
		return warnDeviceCode;
	}

	public void setWarnDeviceCode(String warnDeviceCode) {
		this.warnDeviceCode = warnDeviceCode;
	}

	@Override
	public String toString() {
		return this.getWarnTime() + " " + this.getLineName() + " " + this.getBusNumber() + "触发报警，报警类型："
				+ this.getWarnLabel() + "。";
	}
}
