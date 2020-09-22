package com.cictec.yyjk.report.model.vo;

public class HeatmapVo extends Condition {
	private String staName;// 站名
	private String lng;
	private String lat;
	private String getOnNumber;// 总的上车人数

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getGetOnNumber() {
		return getOnNumber;
	}

	public void setGetOnNumber(String getOnNumber) {
		this.getOnNumber = getOnNumber;
	}

}
