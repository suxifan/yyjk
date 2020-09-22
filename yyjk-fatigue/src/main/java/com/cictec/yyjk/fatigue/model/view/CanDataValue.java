package com.cictec.yyjk.fatigue.model.view;

import java.util.Date;

/**
 * 设备位置信息
 * 
 * @author Administrator
 *
 */
public class CanDataValue {
	private int speed;// 速度
	private Date warnTime;// 报警时间

	public CanDataValue(int speed, Date warnTime) {
		super();
		this.speed = speed;
		this.warnTime = warnTime;
	}

	public CanDataValue() {
		super();
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Date getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(Date warnTime) {
		this.warnTime = warnTime;
	}

}
