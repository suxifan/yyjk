package com.cictec.yyjk.report.model.data;

import java.io.Serializable;

public class DriverRankingValue implements Serializable {
	private static final long serialVersionUID = 5191908194426710585L;
	/**
	 * 机构名
	 */
	private String orgName;
	/**
	 * 线路名
	 */
	private String lineName;
	/**
	 * 司机工号
	 */
	private String driverNum;
	/**
	 * 司机姓名
	 */
	private String driverName;
	/**
	 * 告警时间
	 */
	private String warnTime;
	/**
	 * 疲劳报警
	 */
	private Integer warnFatigue;
	/**
	 * 抽烟报警
	 */
	private Integer warnSmoking;
	/**
	 * 打电话报警
	 */
	private Integer warnPhone;
	/**
	 * 分神异常报警
	 */
	private Integer warnDistraction;
	/**
	 * 驾驶员异常报警
	 */
	private Integer warnAbnormal;
	/**
	 * 报警总数
	 */
	private Integer warnTotalNum;
	/**
	 * 报警类型
	 */
	private String warnType;

	/**
	 * 报警类型名称
	 */
	private String warnTypeName;
	/**
	 * 报警级别
	 */
	private String warnLevel;
	/**
	 * 报警速度
	 */
	private String warnSpeed;

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

	public String getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	public Integer getWarnFatigue() {
		return warnFatigue;
	}

	public void setWarnFatigue(Integer warnFatigue) {
		this.warnFatigue = warnFatigue;
	}

	public Integer getWarnSmoking() {
		return warnSmoking;
	}

	public void setWarnSmoking(Integer warnSmoking) {
		this.warnSmoking = warnSmoking;
	}

	public Integer getWarnPhone() {
		return warnPhone;
	}

	public void setWarnPhone(Integer warnPhone) {
		this.warnPhone = warnPhone;
	}

	public Integer getWarnDistraction() {
		return warnDistraction;
	}

	public void setWarnDistraction(Integer warnDistraction) {
		this.warnDistraction = warnDistraction;
	}

	public Integer getWarnAbnormal() {
		return warnAbnormal;
	}

	public void setWarnAbnormal(Integer warnAbnormal) {
		this.warnAbnormal = warnAbnormal;
	}

	public Integer getWarnTotalNum() {
		return warnTotalNum;
	}

	public void setWarnTotalNum(Integer warnTotalNum) {
		this.warnTotalNum = warnTotalNum;
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

	public String getWarnSpeed() {
		return warnSpeed;
	}

	public void setWarnSpeed(String warnSpeed) {
		this.warnSpeed = warnSpeed;
	}

	public String getWarnTypeName() {
		return warnTypeName;
	}

	public void setWarnTypeName(String warnTypeName) {
		this.warnTypeName = warnTypeName;
	}

}
