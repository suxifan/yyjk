package com.cictec.yyjk.linenet.model.view;

public class NetIndexDeaLinescoreValue {
	/**
	 * 机构名称
	 */
	private String company;
	/**
	 * 线路号
	 */
	private String lineNumber;

	/**
	 * 线路ID
	 */
	private String lineUuid;

	/**
	 * 站位设置合理性评分
	 */
	private Float staRational;

	/**
	 * 舒适性评分
	 */
	private Float safeRational;

	/**
	 * 便捷性评分
	 */
	private Float conRational;

	/**
	 * 快捷性评分
	 */
	private Float rapRational;

	/**
	 * 总评分
	 */
	private Float score;
	/**
	 * 线路等级
	 */
	private String levelName;

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

	public Float getStaRational() {
		return staRational;
	}

	public void setStaRational(Float staRational) {
		this.staRational = staRational;
	}

	public Float getSafeRational() {
		return safeRational;
	}

	public void setSafeRational(Float safeRational) {
		this.safeRational = safeRational;
	}

	public Float getConRational() {
		return conRational;
	}

	public void setConRational(Float conRational) {
		this.conRational = conRational;
	}

	public Float getRapRational() {
		return rapRational;
	}

	public void setRapRational(Float rapRational) {
		this.rapRational = rapRational;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLineUuid() {
		return lineUuid;
	}

	public void setLineUuid(String lineUuid) {
		this.lineUuid = lineUuid;
	}

}
