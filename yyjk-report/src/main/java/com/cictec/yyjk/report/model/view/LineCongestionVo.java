package com.cictec.yyjk.report.model.view;

/**
 * 线路拥堵分析值对象
 * 
 * @author lenovo
 *
 */
public class LineCongestionVo {
	private String staName;
	private int staSeq;
	private float avgTime;
	private float avgSpeed;
	public String getStaName() {
		return staName;
	}

	public LineCongestionVo setStaName(String staName) {
		this.staName = staName;
		return this;
	}

	public int getStaSeq() {
		return staSeq;
	}

	public LineCongestionVo setStaSeq(int staSeq) {
		this.staSeq = staSeq;
		return this;
	}

	public float getAvgTime() {
		return avgTime;
	}

	public LineCongestionVo setAvgTime(float avgTime) {
		this.avgTime = avgTime;
		return this;
	}

	public float getAvgSpeed() {
		return avgSpeed;
	}

	public LineCongestionVo setAvgSpeed(float avgSpeed) {
		this.avgSpeed = avgSpeed;
		return this;
	}

}
