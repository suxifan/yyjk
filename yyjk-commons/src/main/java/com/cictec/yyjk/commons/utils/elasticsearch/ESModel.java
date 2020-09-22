package com.cictec.yyjk.commons.utils.elasticsearch;

import java.io.Serializable;

public class ESModel implements Serializable {

	private static final long serialVersionUID = -2176331898295262935L;
	// String index(数据库), String type(表), String id(document一行数据id)

	private String index; // 索引(数据库名)
	private String type; // 类型type(表)
	private String id; // id(document一行数据id)

	/* 对象 */
	private String jsonString;

	/** 索引(数据库名) */
	public String getIndex() {
		return index;
	}

	/** 索引(数据库名) */
	public void setIndex(String index) {
		this.index = index;
	}

	/** 类型type(表名) */
	public String getType() {
		return type;
	}

	/** 类型type(表名) */
	public void setType(String type) {
		this.type = type;
	}

	/** id(document一行数据id) */
	public String getId() {
		return id;
	}

	/** id(document一行数据id) */
	public void setId(String id) {
		this.id = id;
	}

	/** 数据json字符串 */
	public String getJsonString() {
		return jsonString;
	}

	/** 数据json字符串 */
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
