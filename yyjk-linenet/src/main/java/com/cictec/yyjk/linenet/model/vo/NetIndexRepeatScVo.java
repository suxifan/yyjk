package com.cictec.yyjk.linenet.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by mao on 2019/10/14.
 */
public class NetIndexRepeatScVo extends AbstractVo {
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
	 * 站位A
	 */
	private String sStation;
	/**
	 * 站位B
	 */
	private String eStation;

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

	public String getsStation() {
		return sStation;
	}

	public void setsStation(String sStation) {
		this.sStation = sStation;
	}

	public String geteStation() {
		return eStation;
	}

	public void seteStation(String eStation) {
		this.eStation = eStation;
	}

}
