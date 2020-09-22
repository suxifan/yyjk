package com.cictec.yyjk.linenet.model.view;

public class NetIndexPfOdValue {
	/**
	 * 时间段
	 */
	private String pTime;
	/**
	 * 刷卡总量
	 */
	private Integer brushCount;

	/**
	 * 周转量
	 */
	private float zzl;

	/**
	 * 平均运距
	 */
	private float pjyj;

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	public Integer getBrushCount() {
		return brushCount;
	}

	public void setBrushCount(Integer brushCount) {
		this.brushCount = brushCount;
	}

	public float getZzl() {
		return zzl;
	}

	public void setZzl(float zzl) {
		this.zzl = zzl;
	}

	public float getPjyj() {
		return pjyj;
	}

	public void setPjyj(float pjyj) {
		this.pjyj = pjyj;
	}

}
