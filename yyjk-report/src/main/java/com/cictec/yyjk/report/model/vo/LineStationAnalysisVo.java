package com.cictec.yyjk.report.model.vo;

/**
 * 线路站点上车人数，下车人数，断面客流量及满载率值对象
 *
 */
public class LineStationAnalysisVo {
	private String staName;
	private Float getOnNumber;
	private Float getOffNumber;
	private Float personNumber;
	private Float fullLoadRate;

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public Float getGetOnNumber() {
		return getOnNumber;
	}

	public void setGetOnNumber(Float getOnNumber) {
		this.getOnNumber = getOnNumber;
	}

	public Float getGetOffNumber() {
		return getOffNumber;
	}

	public void setGetOffNumber(Float getOffNumber) {
		this.getOffNumber = getOffNumber;
	}

	public Float getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(Float personNumber) {
		this.personNumber = personNumber;
	}

	public Float getFullLoadRate() {
		return fullLoadRate;
	}

	public void setFullLoadRate(Float fullLoadRate) {
		this.fullLoadRate = fullLoadRate;
	}

}
