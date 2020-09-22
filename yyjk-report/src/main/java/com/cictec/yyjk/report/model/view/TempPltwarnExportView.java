package com.cictec.yyjk.report.model.view;

public class TempPltwarnExportView {
	/**
	 * 主配选配
	 */
	private String configName;
	/**
	 * 项目
	 */
	private String projectName;
	/**
	 * 级别名称
	 */
	private String levelName;
	/**
	 * 次数
	 */
	private long numberTimes;
	/**
	 * 车辆数
	 */
	private long busCounts;

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public long getNumberTimes() {
		return numberTimes;
	}

	public void setNumberTimes(long numberTimes) {
		this.numberTimes = numberTimes;
	}

	public long getBusCounts() {
		return busCounts;
	}

	public void setBusCounts(long busCounts) {
		this.busCounts = busCounts;
	}

}
