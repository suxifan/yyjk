package com.cictec.yyjk.report.model.view;

import java.io.Serializable;

public class WarnInfoValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7368227594927188860L;

	private String warnType;
	private Integer warnLevel;
	private String busUuid;
	private String busPlateNumber;

	public String getWarnType() {
		return warnType;
	}

	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}

	public Integer getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(Integer warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

}
