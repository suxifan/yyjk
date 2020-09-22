package com.cictec.yyjk.linenet.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by xpguo on 2019/10/12.
 */
public class NetDataBasestationVo extends AbstractVo {
	/**
	 * 机构名
	 */
	private String company;
	/**
	 * 线路ID
	 */
	private String lineID;

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
