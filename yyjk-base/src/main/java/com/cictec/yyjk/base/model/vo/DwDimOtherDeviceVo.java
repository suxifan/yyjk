package com.cictec.yyjk.base.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2019/08/30.
 */
public class DwDimOtherDeviceVo extends AbstractVo {
	/**
	 * 设备编号
	 */
	private String devCode;
	/**
	 * 设备编号
	 */
	private String devClass;
	/**
	 * 型号
	 */
	private Integer devModelNum;
	/**
	 * 车牌号
	 */
	private String busPlateNumber;
	/**
	 * 自编号
	 */
	private String busSelfCode;
	/**
	 * 设备在线状态
	 * 
	 * 0：断开
	 * 
	 * 1：在线
	 */
	private String devOnlineStatus;

	private String devIsvalid;

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	public String getDevClass() {
		return devClass;
	}

	public void setDevClass(String devClass) {
		this.devClass = devClass;
	}

	public Integer getDevModelNum() {
		return devModelNum;
	}

	public void setDevModelNum(Integer devModelNum) {
		this.devModelNum = devModelNum;
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

	public String getDevOnlineStatus() {
		return devOnlineStatus;
	}

	public void setDevOnlineStatus(String devOnlineStatus) {
		this.devOnlineStatus = devOnlineStatus;
	}

	public String getDevIsvalid() {
		return devIsvalid;
	}

	public void setDevIsvalid(String devIsvalid) {
		this.devIsvalid = devIsvalid;
	}

}
