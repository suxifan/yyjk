package com.cictec.yyjk.report.model.entity;

import javax.persistence.Id;

public class DispatchAnalysis {

	@Id
	private String id;
	/**
	 * 纵坐标标签
	 */
	private String yAxisLabel;
	/**
	 * 横坐标标签
	 */
	private String xAxisLabel;
	/**
	 * 分析值
	 */
	private String analysisNumber;

	public String getyAxisLabel() {
		return yAxisLabel;
	}

	public void setyAxisLabel(String yAxisLabel) {
		this.yAxisLabel = yAxisLabel;
	}

	public String getxAxisLabel() {
		return xAxisLabel;
	}

	public void setxAxisLabel(String xAxisLabel) {
		this.xAxisLabel = xAxisLabel;
	}

	public String getAnalysisNumber() {
		return analysisNumber;
	}

	public void setAnalysisNumber(String analysisNumber) {
		this.analysisNumber = analysisNumber;
	}

}
