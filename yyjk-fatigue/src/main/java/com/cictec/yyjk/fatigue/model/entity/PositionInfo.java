package com.cictec.yyjk.fatigue.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备位置信息
 * 
 * @author Administrator
 *
 */
public class PositionInfo implements Serializable{
	private static final long serialVersionUID = -1777286240645943036L;

	private String terminalId;// 设备号
	private double lat;// 8 纬度 DWORD 以度为单位的纬度值乘以 10 的 6 次方，精确到百万分之一度
	private double lng;// 12 经度 DWORD 以度为单位的经度值乘以 10 的 6 次方，精确到百万分之一度
	private int altitude;// 16 高程 WORD 海拔高度，单位为米（m）
	private int speed;// 18 速度 WORD 1/10km/h
	private int angle;// 20 方向 WORD 0-359，正北为 0，顺时针
	private Date sendtime;// 21 时间 BCD[6] YY-MM-DD-hh-mm-ss（GMT+8
							// 时间，本标准中之后涉及的时间均采用此时区）
	private Date createtime;// 创建时间
	private boolean isOverSpeed;// 是否超速

	public PositionInfo(String terminalId, double lat, double lng, int speed, Date sendtime, Date createtime,
			boolean isOverSpeed) {
		super();
		this.terminalId = terminalId;
		this.lat = lat;
		this.lng = lng;
		this.speed = speed;
		this.sendtime = sendtime;
		this.createtime = createtime;
		this.isOverSpeed = isOverSpeed;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public boolean isOverSpeed() {
		return isOverSpeed;
	}

	public void setOverSpeed(boolean isOverSpeed) {
		this.isOverSpeed = isOverSpeed;
	}
	
}
