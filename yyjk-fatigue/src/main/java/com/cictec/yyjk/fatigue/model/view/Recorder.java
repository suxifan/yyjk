package com.cictec.yyjk.fatigue.model.view;

public class Recorder {
	/**
	 * 记录超速前30秒中内位置点个数
	 */
	private int startNoOverTimes;

	/**
	 * 记录超速报警点个数
	 */
	private int overTimes;

	/**
	 * 记录超速后30秒中内位置点个数
	 */
	private int endNoOverTimes;

	/**
	 * 记录第二段非超速报警里超速点个数 <br/>
	 * <br/>
	 * 因为超速两端要补全，超速尾部补全的6个点由超速点的情况 <br/>
	 * <br/>
	 * 2020-03-26
	 */
	private int endOverTimes;

	public Recorder(int startNoOverTimes, int overTimes, int endNoOverTimes, int endOverTimes) {
		super();
		this.startNoOverTimes = startNoOverTimes;
		this.overTimes = overTimes;
		this.endNoOverTimes = endNoOverTimes;
		this.endOverTimes = endOverTimes;
	}

	public int getStartNoOverTimes() {
		return startNoOverTimes;
	}

	public void setStartNoOverTimes(int startNoOverTimes) {
		this.startNoOverTimes = startNoOverTimes;
	}

	public int getOverTimes() {
		return overTimes;
	}

	public void setOverTimes(int overTimes) {
		this.overTimes = overTimes;
	}

	public int getEndNoOverTimes() {
		return endNoOverTimes;
	}

	public void setEndNoOverTimes(int endNoOverTimes) {
		this.endNoOverTimes = endNoOverTimes;
	}

	public int getEndOverTimes() {
		return endOverTimes;
	}

	public void setEndOverTimes(int endOverTimes) {
		this.endOverTimes = endOverTimes;
	}

}
