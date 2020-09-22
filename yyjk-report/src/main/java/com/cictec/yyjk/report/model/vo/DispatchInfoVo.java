package com.cictec.yyjk.report.model.vo;

public class DispatchInfoVo {
	private String orgId;
	private String orgName;
	private String lineId;
	private String lineName;
	private String displyLabel;
	private Float realtimeMileage;
	private Float planMileage;
	private Float realtimeTrips;
	private Float planTrips;
	private Float realtimeClasses;
	private Float planClasses;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public Float getRealtimeMileage() {
		return realtimeMileage;
	}

	public void setRealtimeMileage(Float realtimeMileage) {
		this.realtimeMileage = toFixed(realtimeMileage);
	}

	private float toFixed(Float num){
		if(num == null){
			return 0f;
		}
		return (float)(Math.round(num*100))/100;
	}
	
	public Float getPlanMileage() {
		return planMileage;
	}

	public void setPlanMileage(Float planMileage) {
		this.planMileage = toFixed(planMileage) ;
	}

	public Float getRealtimeTrips() {
		return realtimeTrips;
	}

	public void setRealtimeTrips(Float realtimeTrips) {
		this.realtimeTrips = toFixed(realtimeTrips) ;
	}

	public Float getPlanTrips() {
		return planTrips;
	}

	public void setPlanTrips(Float planTrips) {
		this.planTrips = toFixed(planTrips) ;
	}

	public Float getRealtimeClasses() {
		return realtimeClasses;
	}

	public void setRealtimeClasses(Float realtimeClasses) {
		this.realtimeClasses = toFixed(realtimeClasses) ;
	}

	public Float getPlanClasses() {
		return planClasses;
	}

	public void setPlanClasses(Float planClasses) {
		this.planClasses = toFixed(planClasses) ;
	}

	public String getDisplyLabel() {
		return displyLabel;
	}

	public void setDisplyLabel(String displyLabel) {
		this.displyLabel = displyLabel;
	}
}
