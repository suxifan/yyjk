package com.cictec.yyjk.linenet.model.view;

public class NetDataBasestationValue {

	/**
	 * 公司名
	 */
	private String company;
	/**
	 * 站点数
	 * 
	 * @return
	 */
	private String basestations;
	/**
	 * 站点名
	 * 
	 */
	private String stationName;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBasestations() {
		return basestations;
	}

	public void setBasestations(String basestations) {
		this.basestations = basestations;
	}

}
