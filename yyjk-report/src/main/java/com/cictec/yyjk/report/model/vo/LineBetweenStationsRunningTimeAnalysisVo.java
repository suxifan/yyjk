package com.cictec.yyjk.report.model.vo;

public class LineBetweenStationsRunningTimeAnalysisVo {
	private String staName;
	private Integer timeHour;
	/**
	 * 时长
	 */
	private Integer timeLength;

	public LineBetweenStationsRunningTimeAnalysisVo() {
		super();
	}

	public LineBetweenStationsRunningTimeAnalysisVo(String staName, Integer timeHour, Integer timeLength) {
		super();
		this.staName = staName;
		this.timeHour = timeHour;
		this.timeLength = timeLength;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public Integer getTimeHour() {
		return timeHour;
	}

	public void setTimeHour(Integer timeHour) {
		this.timeHour = timeHour;
	}

	public Integer getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(Integer timeLength) {
		this.timeLength = timeLength;
	}

}
