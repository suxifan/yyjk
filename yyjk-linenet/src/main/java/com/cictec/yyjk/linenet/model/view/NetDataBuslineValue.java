package com.cictec.yyjk.linenet.model.view;

public class NetDataBuslineValue {

	/**
	 * 公司名
	 */
	private String company;
	/**
	 * 线路条数
	 */
	private String lineCounts;
	/**
	 * 线路长度
	 */
	private String lineLengths;
	/**
	 * 线路名
	 */
	private String lineName;

	/**
	 * 站位名称
	 */
	private String stationName;

	/**
	 * 站序号
	 */
	private Integer stationIndex;

	/**
	 * 距前一站距离
	 */
	private String predistance;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Integer getStationIndex() {
		return stationIndex;
	}

	public void setStationIndex(Integer stationIndex) {
		this.stationIndex = stationIndex;
	}

	public String getPredistance() {
		return predistance;
	}

	public void setPredistance(String predistance) {
		this.predistance = predistance;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineLengths() {
		return lineLengths;
	}

	public void setLineLengths(String lineLengths) {
		this.lineLengths = lineLengths;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLineCounts() {
		return lineCounts;
	}

	public void setLineCounts(String lineCounts) {
		this.lineCounts = lineCounts;
	}

}
