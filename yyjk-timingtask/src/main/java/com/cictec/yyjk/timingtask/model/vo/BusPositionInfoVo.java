package com.cictec.yyjk.timingtask.model.vo;

public class BusPositionInfoVo {
	private String busNumber;// 车牌号
	private String busSelfcode;// 自编号
	private String samplingTime;// 到站时间
	private String driverName;// 司机姓名
	private String driverNum;// 司机工号

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusSelfcode() {
		return busSelfcode;
	}

	public void setBusSelfcode(String busSelfcode) {
		this.busSelfcode = busSelfcode;
	}

	public String getSamplingTime() {
		return samplingTime;
	}

	public void setSamplingTime(String samplingTime) {
		this.samplingTime = samplingTime;
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

}
