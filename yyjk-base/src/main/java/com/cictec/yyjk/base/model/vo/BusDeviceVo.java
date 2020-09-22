package com.cictec.yyjk.base.model.vo;

import java.io.Serializable;

public class BusDeviceVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7131124221485011265L;

	private String rowNum;
	/**
	 * 车辆uuid
	 */
	private String busUuid;
	/**
	 * 车牌号
	 */
	private String busPlateNumber;
	/**
	 * 车辆自编号
	 */
	private String busSelfCode;
	/**
	 * 机构名称
	 */
	private String orgName;
	/**
	 * 线路名称
	 */
	private String lineName;
	/**
	 * 设备uuid
	 */
	private String devUuid;
	/**
	 * 设备种类
	 */
	private String devClass;
	/**
	 * 设备编号
	 */
	private String devCode;

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
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

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
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

	public String getDevUuid() {
		return devUuid;
	}

	public void setDevUuid(String devUuid) {
		this.devUuid = devUuid;
	}

	public String getDevClass() {
		return devClass;
	}

	public void setDevClass(String devClass) {
		this.devClass = devClass;
	}

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
