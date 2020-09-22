package com.cictec.yyjk.report.model.vo;

import java.util.Date;

/**
 * 时序图值对象
 *
 */
public class SequenceDiagramAnalysisVo implements Comparable<SequenceDiagramAnalysisVo> {
	/**
	 * 车牌号
	 */
	private String busNumber;
	/**
	 * 班次
	 */
	private String busClass;
	/**
	 * 站名
	 */
	private String staName;
	/**
	 * 进站时间时间戳
	 */
	private String timestamps;

	private Date uploadTimeIn;

	private int staSeq;

	public SequenceDiagramAnalysisVo() {
		super();
	}

	public SequenceDiagramAnalysisVo(String busNumber, String busClass, String staName, String timestamps,
			Date uploadTimeIn, int staSeq) {
		super();
		this.busNumber = busNumber;
		this.busClass = busClass;
		this.staName = staName;
		this.timestamps = timestamps;
		this.uploadTimeIn = uploadTimeIn;
		this.staSeq = staSeq;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusClass() {
		return busClass;
	}

	public void setBusClass(String busClass) {
		this.busClass = busClass;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public String getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(String timestamps) {
		this.timestamps = timestamps;
	}

	public Date getUploadTimeIn() {
		return uploadTimeIn;
	}

	public void setUploadTimeIn(Date uploadTimeIn) {
		this.uploadTimeIn = uploadTimeIn;
	}

	public int getStaSeq() {
		return staSeq;
	}

	public void setStaSeq(int staSeq) {
		this.staSeq = staSeq;
	}

	@Override
	public int compareTo(SequenceDiagramAnalysisVo o) {
		return this.getStaSeq() - o.getStaSeq();
	}

}
