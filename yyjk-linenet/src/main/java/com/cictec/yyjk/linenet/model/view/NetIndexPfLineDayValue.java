package com.cictec.yyjk.linenet.model.view;

public class NetIndexPfLineDayValue {
	/**
	 * 分公司
	 */
	private String company;
	/**
	 * 线路ID
	 */
	private String lineUuid;
	/**
	 * 线路号
	 */
	private String lineNumber;
	/**
	 * 上下行
	 */
	private String arrow;
	/**
	 * 刷卡总量
	 */
	private String brushCount;

	/**
	 * 周转量
	 */
	private String zzl;

	/**
	 * 平均运距
	 */
	private String pjyj;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLineUuid() {
		return lineUuid;
	}

	public void setLineUuid(String lineUuid) {
		this.lineUuid = lineUuid;
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

	public String getBrushCount() {
		return brushCount;
	}

	public void setBrushCount(String brushCount) {
		this.brushCount = brushCount;
	}

	public String getZzl() {
		return zzl;
	}

	public void setZzl(String zzl) {
		this.zzl = zzl;
	}

	public String getPjyj() {
		return pjyj;
	}

	public void setPjyj(String pjyj) {
		this.pjyj = pjyj;
	}

}
