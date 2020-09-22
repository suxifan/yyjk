package com.cictec.yyjk.linenet.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by mao on 2019/10/18.
 */
public class NetXmlConfigVo extends AbstractVo {
	/**
	 * 机构名
	 */
	private String company;
	/**
	 * 线路ID
	 */
	private String lineID;
	/**
	 * 列名
	 */
	private String codes;
	/**
	 * tab栏
	 */
	private String codeType;

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
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

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

}
