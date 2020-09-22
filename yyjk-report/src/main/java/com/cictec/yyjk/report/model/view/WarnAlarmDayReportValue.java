package com.cictec.yyjk.report.model.view;

import java.io.Serializable;

public class WarnAlarmDayReportValue implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3154941958385288027L;
	private String warnTypeName;
	private String warnType;
	// 报警级别
	private Integer warnTypeLevel;

	private Integer warnCount = 0;
	private Integer warnBusCount = 0;

	public WarnAlarmDayReportValue(String warnType, String warnTypeName, Integer warnTypeLevel, Integer warnCount,
			Integer warnBusCount) {
		super();
		this.warnType = warnType;
		this.warnTypeName = warnTypeName;
		this.warnTypeLevel = warnTypeLevel;
		this.warnCount = warnCount;
		this.warnBusCount = warnBusCount;
	}

	public WarnAlarmDayReportValue() {
		super();
	}

	public String getWarnTypeName() {
		return warnTypeName;
	}
	public void setWarnTypeName(String warnTypeName) {
		this.warnTypeName = warnTypeName;
	}

	public Integer getWarnTypeLevel() {
		return warnTypeLevel;
	}

	public void setWarnTypeLevel(Integer warnTypeLevel) {
		this.warnTypeLevel = warnTypeLevel;
	}

	public Integer getWarnCount() {
		return warnCount;
	}

	public void setWarnCount(Integer warnCount) {
		this.warnCount = warnCount;
	}

	public Integer getWarnBusCount() {
		return warnBusCount;
	}

	public void setWarnBusCount(Integer warnBusCount) {
		this.warnBusCount = warnBusCount;
	}

	public String getWarnType() {
		return warnType;
	}

	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

}
