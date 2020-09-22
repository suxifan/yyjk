package com.cictec.yyjk.report.model.vo;

public class LineCapacityAnalysisVo {
	/**
	 * 时间间隔
	 */
	private String timeInterval;
	/**
	 * 线路运力
	 */
	private Float lineCapacity;
	/**
	 * 线路运量
	 */

	private Float lineVolume;
	/**
	 * 最大车内人数
	 */
	private Float maxPersonCount;

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Float getLineCapacity() {
		return lineCapacity;
	}

	public void setLineCapacity(Float lineCapacity) {
		this.lineCapacity = lineCapacity;
	}

	public Float getLineVolume() {
		return lineVolume;
	}

	public void setLineVolume(Float lineVolume) {
		this.lineVolume = lineVolume;
	}

	public Float getMaxPersonCount() {
		return maxPersonCount;
	}

	public void setMaxPersonCount(Float maxPersonCount) {
		this.maxPersonCount = maxPersonCount;
	}
}
