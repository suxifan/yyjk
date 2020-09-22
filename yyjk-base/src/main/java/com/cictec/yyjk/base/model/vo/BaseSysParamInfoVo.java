package com.cictec.yyjk.base.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2019/11/07.
 */
public class BaseSysParamInfoVo extends AbstractVo {
	/**
	 * 参数名
	 */
	private String paramName;

	/**
	 * 是否有效，1：有效，0：无效
	 */
	private String paramIsvalid;

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamIsvalid() {
		return paramIsvalid;
	}

	public void setParamIsvalid(String paramIsvalid) {
		this.paramIsvalid = paramIsvalid;
	}
}
