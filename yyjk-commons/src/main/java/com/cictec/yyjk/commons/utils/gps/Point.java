package com.cictec.yyjk.commons.utils.gps;

import java.io.Serializable;

public class Point implements Serializable {

	private static final long serialVersionUID = -1332195804165275696L;
	private long latitude;
	private long longitude;
	private double x;
	private double y;
	
	public Point(){
		
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

}
