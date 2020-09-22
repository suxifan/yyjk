package com.cictec.yyjk.fatigue.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 设备位置信息
 * 
 * @author Administrator
 *
 */
public class PositionInfoVo extends AbstractVo {

	private String devCode;// 设备号

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
}
