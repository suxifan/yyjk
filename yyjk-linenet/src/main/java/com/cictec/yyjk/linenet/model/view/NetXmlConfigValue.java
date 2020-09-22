package com.cictec.yyjk.linenet.model.view;

public class NetXmlConfigValue {
	/**
	 * 父类型
	 */
	private String codeType;

	/**
	 * 父类型名称
	 */
	private String codeTypeName;

	/**
	 * 父类型
	 */
	private String code;

	/**
	 * 父类型名称
	 */
	private String codeValue;

	/**
	 * 需要查询的类型
	 */
	private String codes;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeTypeName() {
		return codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

}
