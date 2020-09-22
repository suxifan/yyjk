package com.cictec.yyjk.commons.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 统一API响应结果封装（继承JSONObject，可当Map用）
 * 
 * @author Administrator
 *
 */
public class Result extends JSONObject {

	/** */
	private static final long serialVersionUID = -2416495130324039885L;

	private Head head;
	private String code;
	private String message;
	private Object data;

	/**
	 * JSON封装的实体扩展
	 * 
	 * @param key
	 * @param value
	 * @param force
	 * @return
	 */
	public Result set(String key, Object value, boolean force) {
		if (force || value != null) {
			super.put(key, value);
		}
		return this;
	}

	/**
	 * 判定是否成功
	 * 
	 * @param result
	 * @return
	 */
	public boolean isSuccess() {
		String code = this.getCode();
		if (ResultCode.SUCCESS.equals(code)) {
			return true;
		}

		return false;
	}

	public Result setCode(String code) {
		this.code = code;
		return set("code", code, false);
	}

	public String getCode() {
		return getString("code");
	}

	public Result setMessage(String message) {
		this.message = message;
		return set("message", message, false);
	}

	public String getMessage() {
		return getString("message");
	}

	public Object getData() {

		return get("data");
	}

	public Result setData(Object data) {
		this.data = data;
		return set("data", data, false);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public Head getHead() {
		return (Head) get("head");
	}

	public Result setHead(Head head) {
		this.head = head;
		return set("head", head, false);
	}

}