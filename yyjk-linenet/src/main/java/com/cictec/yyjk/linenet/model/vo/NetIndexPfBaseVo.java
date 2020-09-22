package com.cictec.yyjk.linenet.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by mao on 2019/10/14.
 */
public class NetIndexPfBaseVo extends AbstractVo {
	/**
	 * 机构名
	 */
	private String company;
	/**
	 * 线路ID
	 */
	private String lineID;
	/**
	 * 方向
	 */
	private String arrow;
	/**
	 * 日期
	 */
	private String pDate;

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

	public String getArrow() {
		return arrow;
	}

	public void setArrow(String arrow) {
		this.arrow = arrow;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

}
