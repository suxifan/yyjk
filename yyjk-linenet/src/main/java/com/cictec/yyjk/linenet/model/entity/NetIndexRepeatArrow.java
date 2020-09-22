package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "net_index_repeat_arrow")
public class NetIndexRepeatArrow {
	@Id
	private Integer uuid;

	/**
	 * 线路号
	 */
	@Column(name = "line_number")
	private String lineNumber;
	/**
	 * 线路UUID
	 */
	private String lineUuid;
	/**
	 * 机构
	 */
	private String company;

	/**
	 * 线路名称
	 */
	@Column(name = "line_name")
	private String lineName;

	/**
	 * 上下行
	 */
	private String arrow;

	/**
	 * 总站对数
	 */
	@Column(name = "sc_count")
	private Integer scCount;

	/**
	 * 重复站对数
	 */
	@Column(name = "repeat_sc_count")
	private Integer repeatScCount;

	/**
	 * 重复度
	 */
	private Float repeatability;

	/**
	 * 重复线路排名前三的线路
	 */
	private String top3;

	/**
	 * @return uuid
	 */
	public Integer getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 */
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	/**
	 * 获取线路号
	 *
	 * @return line_number - 线路号
	 */
	public String getLineNumber() {
		return lineNumber;
	}

	/**
	 * 设置线路号
	 *
	 * @param lineNumber
	 *            线路号
	 */
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * 获取线路名称
	 *
	 * @return line_name - 线路名称
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * 设置线路名称
	 *
	 * @param lineName
	 *            线路名称
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	/**
	 * 获取上下行
	 *
	 * @return arrow - 上下行
	 */
	public String getArrow() {
		return arrow;
	}

	/**
	 * 设置上下行
	 *
	 * @param arrow
	 *            上下行
	 */
	public void setArrow(String arrow) {
		this.arrow = arrow;
	}

	/**
	 * 获取总站对数
	 *
	 * @return sc_count - 总站对数
	 */
	public Integer getScCount() {
		return scCount;
	}

	/**
	 * 设置总站对数
	 *
	 * @param scCount
	 *            总站对数
	 */
	public void setScCount(Integer scCount) {
		this.scCount = scCount;
	}

	/**
	 * 获取重复站对数
	 *
	 * @return repeat_sc_count - 重复站对数
	 */
	public Integer getRepeatScCount() {
		return repeatScCount;
	}

	/**
	 * 设置重复站对数
	 *
	 * @param repeatScCount
	 *            重复站对数
	 */
	public void setRepeatScCount(Integer repeatScCount) {
		this.repeatScCount = repeatScCount;
	}

	/**
	 * 获取重复度
	 *
	 * @return repeatability - 重复度
	 */
	public Float getRepeatability() {
		return repeatability;
	}

	/**
	 * 设置重复度
	 *
	 * @param repeatability
	 *            重复度
	 */
	public void setRepeatability(Float repeatability) {
		this.repeatability = repeatability;
	}

	/**
	 * 获取重复线路排名前三的线路
	 *
	 * @return top3 - 重复线路排名前三的线路
	 */
	public String getTop3() {
		return top3;
	}

	/**
	 * 设置重复线路排名前三的线路
	 *
	 * @param top3
	 *            重复线路排名前三的线路
	 */
	public void setTop3(String top3) {
		this.top3 = top3;
	}

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

}