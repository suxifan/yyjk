package com.cictec.yyjk.report.model.vo;

public class PassengerFlowVo {
	private String lineName;

	private String timeInterval;// 时间区间

	private String personCount;// 人数

	private String busLoadNumber;// 车辆荷载人数

	private String fullLoadRate;// 满载率

	private String busNumber;// 车牌号

	public PassengerFlowVo() {
		super();
	}

	public PassengerFlowVo(String lineName, String timeInterval, String personCount, String busLoadNumber,
			String fullLoadRate, String busNumber) {
		super();
		this.lineName = lineName;
		this.timeInterval = timeInterval;
		this.personCount = personCount;
		this.busLoadNumber = busLoadNumber;
		this.fullLoadRate = fullLoadRate;
		this.busNumber = busNumber;
	}


	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getBusLoadNumber() {
		return busLoadNumber;
	}

	public void setBusLoadNumber(String busLoadNumber) {
		this.busLoadNumber = busLoadNumber;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getPersonCount() {
		return personCount;
	}

	public void setPersonCount(String personCount) {
		this.personCount = personCount;
	}

	public String getFullLoadRate() {
		return fullLoadRate;
	}

	public void setFullLoadRate(String fullLoadRate) {
		this.fullLoadRate = fullLoadRate;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

}
