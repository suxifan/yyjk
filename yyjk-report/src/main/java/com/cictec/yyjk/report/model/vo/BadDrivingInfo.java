package com.cictec.yyjk.report.model.vo;

public class BadDrivingInfo {
	/**
	 * 
	 */
	private String orgUuid;
	/**
	 * 机构名
	 */
	private String orgName;
	/**
	 * 线路名
	 */
	private String lineName;
	/**
	 * 车牌号
	 */
	private String busPlateNumber;
	/**
	 * 司机姓名
	 */
	private String driverName;
	/**
	 * 司机卡号
	 */
	private String driverNum;
	/**
	 * 告警总数
	 */
	private String totalWarn;

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

	public String getTotalWarn() {
		return totalWarn;
	}

	public void setTotalWarn(String totalWarn) {
		this.totalWarn = totalWarn;
	}

}
