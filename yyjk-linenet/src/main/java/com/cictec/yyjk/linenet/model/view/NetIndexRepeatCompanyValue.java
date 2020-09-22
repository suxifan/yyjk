package com.cictec.yyjk.linenet.model.view;

public class NetIndexRepeatCompanyValue {

	/**
	 * 所属单位
	 */
	private String company;

	/**
	 * 总站对数
	 */
	private Short scCount;

	/**
	 * 重复站对数
	 */
	private Short repeatScCount;

	/**
	 * 重复度
	 */
	private Float repeatability;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Short getScCount() {
		return scCount;
	}

	public void setScCount(Short scCount) {
		this.scCount = scCount;
	}

	public Short getRepeatScCount() {
		return repeatScCount;
	}

	public void setRepeatScCount(Short repeatScCount) {
		this.repeatScCount = repeatScCount;
	}

	public Float getRepeatability() {
		return repeatability;
	}

	public void setRepeatability(Float repeatability) {
		this.repeatability = repeatability;
	}

}
