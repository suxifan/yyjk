package com.cictec.yyjk.base.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2020/04/13.
 */
public class BaseSysAlarmHandleResultVo extends AbstractVo {
	private String handleIsvalid;
	private String handleStatus;
	private String handleContext;
	private String handleType;

	public String getHandleIsvalid() {
		return handleIsvalid;
	}

	public void setHandleIsvalid(String handleIsvalid) {
		this.handleIsvalid = handleIsvalid;
	}

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	public String getHandleContext() {
		return handleContext;
	}

	public void setHandleContext(String handleContext) {
		this.handleContext = handleContext;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

}
