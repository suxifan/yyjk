package com.cictec.yyjk.linenet.model.view;

public class NetIndexRepeatScValue {
	/**
	 * 分公司
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
	 * 线路名称
	 */
	private String linename;

	/**
	 * 上车站序号
	 */
	private Integer sStationIndex;

	/**
	 * 下车站序号
	 */
	private Integer eStationIndex;
	/**
	 * 上车站位
	 */
	private String sStation;

	/**
	 * 下车站位
	 */
	private String eStation;

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

	public String getLinename() {
		return linename;
	}

	public void setLinename(String linename) {
		this.linename = linename;
	}

	public Integer getsStationIndex() {
		return sStationIndex;
	}

	public void setsStationIndex(Integer sStationIndex) {
		this.sStationIndex = sStationIndex;
	}

	public Integer geteStationIndex() {
		return eStationIndex;
	}

	public void seteStationIndex(Integer eStationIndex) {
		this.eStationIndex = eStationIndex;
	}

	public String getsStation() {
		return sStation;
	}

	public void setsStation(String sStation) {
		this.sStation = sStation;
	}

	public String geteStation() {
		return eStation;
	}

	public void seteStation(String eStation) {
		this.eStation = eStation;
	}

	public String getRepeatLine() {
		return repeatLine;
	}

	public void setRepeatLine(String repeatLine) {
		this.repeatLine = repeatLine;
	}

	public Integer getRepeatLineCount() {
		return repeatLineCount;
	}

	public void setRepeatLineCount(Integer repeatLineCount) {
		this.repeatLineCount = repeatLineCount;
	}

	/**
	 * 重复线路
	 */
	private String repeatLine;

	/**
	 * 重复线路数量
	 */
	private Integer repeatLineCount;

}
