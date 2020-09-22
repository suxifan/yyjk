package com.cictec.yyjk.commons.core;

public class Head {
	private String msg;
	private String code;
	private String success;

	public Head(String code, String msg, String success) {
		this.code = code;
		this.msg = msg;
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
}
