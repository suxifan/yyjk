package com.cictec.yyjk.report.model.vo;

/**
 * 站点等降量分析值对象
 * 
 */
public class StationOnOffAnalysisVo {
	private String timeDate;
	private String staName;
	private Integer timeHour;
	private Integer getOnNumber;
	private Integer getOffNumber;

	public StationOnOffAnalysisVo() {
		super();
	}

	public StationOnOffAnalysisVo(String timeDate, String staName, Integer timeHour, Integer getOnNumber,
			Integer getOffNumber) {
		super();
		this.timeDate = timeDate;
		this.staName = staName;
		this.timeHour = timeHour;
		this.getOnNumber = getOnNumber;
		this.getOffNumber = getOffNumber;
	}

	public String getTimeDate() {
		return timeDate;
	}

	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}

	public Integer getTimeHour() {
		return timeHour;
	}

	public void setTimeHour(Integer timeHour) {
		this.timeHour = timeHour;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}


	public Integer getGetOnNumber() {
		return getOnNumber;
	}

	public void setGetOnNumber(Integer getOnNumber) {
		this.getOnNumber = getOnNumber;
	}

	public Integer getGetOffNumber() {
		return getOffNumber;
	}

	public void setGetOffNumber(Integer getOffNumber) {
		this.getOffNumber = getOffNumber;
	}

}
