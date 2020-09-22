package com.cictec.yyjk.linenet.model.view;

import javax.persistence.Column;

public class NetIndexPfLineOdValue {
	/**
	 * 机构
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
	 * 上车站位名称
	 */
	private String sStationName;

	/**
	 * 上车站序号
	 */
	private Integer sStationIndex;

	/**
	 * 下车站位名称
	 */
	private String eStationName;

	/**
	 * 下车站序号
	 */
	private Integer eStationIndex;

	/**
	 * 刷卡量
	 */
	private Short brushCount;

	/**
	 * 刷卡日上期
	 */
	@Column(name = "p_date")
	private String pDate;

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

	public String getsStationName() {
		return sStationName;
	}

	public void setsStationName(String sStationName) {
		this.sStationName = sStationName;
	}

	public Integer getsStationIndex() {
		return sStationIndex;
	}

	public void setsStationIndex(Integer sStationIndex) {
		this.sStationIndex = sStationIndex;
	}

	public String geteStationName() {
		return eStationName;
	}

	public void seteStationName(String eStationName) {
		this.eStationName = eStationName;
	}

	public Integer geteStationIndex() {
		return eStationIndex;
	}

	public void seteStationIndex(Integer eStationIndex) {
		this.eStationIndex = eStationIndex;
	}

	public Short getBrushCount() {
		return brushCount;
	}

	public void setBrushCount(Short brushCount) {
		this.brushCount = brushCount;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

}
