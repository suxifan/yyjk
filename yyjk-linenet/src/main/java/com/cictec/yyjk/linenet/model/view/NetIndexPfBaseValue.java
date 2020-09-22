package com.cictec.yyjk.linenet.model.view;

public class NetIndexPfBaseValue {
	/**
	 * 所属单位
	 */
	private String company;
	/**
	 * 线路号
	 */
	private String lineNumber;

	/**
	 * 上下行
	 */
	private String arrow;

	/**
	 * 站序号
	 */
	private Integer stationIndex;

	/**
	 * 站位名称
	 */
	private String stationName;

	/**
	 * 登量
	 */
	private Integer upCount;

	/**
	 * 降量
	 */
	private Integer downCount;

	/**
	 * 通过量
	 */
	private Integer passCount;

	/**
	 * 满载率
	 */
	private float approval;

	/**
	 * 时间段
	 */
	private String pTime;

	/**
	 * 负载人数
	 */
	private Integer fullLoadNum;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getArrow() {
		return arrow;
	}

	public void setArrow(String arrow) {
		this.arrow = arrow;
	}

	public Integer getStationIndex() {
		return stationIndex;
	}

	public void setStationIndex(Integer stationIndex) {
		this.stationIndex = stationIndex;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Integer getUpCount() {
		return upCount;
	}

	public void setUpCount(Integer upCount) {
		this.upCount = upCount;
	}

	public Integer getDownCount() {
		return downCount;
	}

	public void setDownCount(Integer downCount) {
		this.downCount = downCount;
	}

	public Integer getPassCount() {
		return passCount;
	}

	public void setPassCount(Integer passCount) {
		this.passCount = passCount;
	}

	public float getApproval() {
		return approval;
	}

	public void setApproval(float approval) {
		this.approval = approval;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	public Integer getFullLoadNum() {
		return fullLoadNum;
	}

	public void setFullLoadNum(Integer fullLoadNum) {
		this.fullLoadNum = fullLoadNum;
	}

}
