package com.cictec.yyjk.report.model.vo;

public class StationInfoVo {
	private String staUuid;
	private String staName;

	public StationInfoVo() {
		super();
	}

	public StationInfoVo(String staName, String staUuid) {
		super();
		this.staName = staName;
		this.staUuid = staUuid;
	}

	public String getStaUuid() {
		return staUuid;
	}

	public void setStaUuid(String staUuid) {
		this.staUuid = staUuid;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

}
