package com.cictec.yyjk.commons.utils.gps;

public class GeoCoordinate {
    public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private  double latitude;
    private  double longitude;
 
 
    public GeoCoordinate(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
 
    public  String ToString()
    {
        return String.format("{0},{1}", this.latitude, this.longitude);
    }
}
