package com.cictec.yyjk.linenet.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by mao on 2019/10/12.
 */
public class NetDataBuslineVo extends AbstractVo {

	/**
	 * 机构名
	 */
	private String company;
	/**
	 * 线路ID
	 */
	private String lineID;

	/**
	 * 线路名称
	 */
	private String lineName;

	/**
	 * 上下行
	 */
	private String arrow;

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getArrow() {
		return arrow;
	}

	public void setArrow(String arrow) {
		this.arrow = arrow;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLineID() {
		return lineID;
	}

	public void setLineID(String lineID) {
		this.lineID = lineID;
	}
}
