package com.cictec.yyjk.report.model.entity;

import javax.persistence.Id;

public class DispatchInfo {
	@Id
	private String id;
	private String orgUuid;
	private String orgName;
	private String lineUuid;
	private String lineName;
	private Float realtimeMileage;
	private Float planMileage;
	private Float realtimeTrips;
	private Float planTrips;
	private Float realtimeClasses;
	private Float planClasses;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgUuid() {
		return orgUuid;
	}

	public void setOrgUuid(String orgUuid) {
		this.orgUuid = orgUuid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLineUuid() {
		return lineUuid;
	}

	public void setLineUuid(String lineUuid) {
		this.lineUuid = lineUuid;
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
		this.realtimeMileage = realtimeMileage;
	}

	public Float getPlanMileage() {
		return planMileage;
	}

	public void setPlanMileage(Float planMileage) {
		this.planMileage = planMileage;
	}

	public Float getRealtimeTrips() {
		return realtimeTrips;
	}

	public void setRealtimeTrips(Float realtimeTrips) {
		this.realtimeTrips = realtimeTrips;
	}

	public Float getPlanTrips() {
		return planTrips;
	}

	public void setPlanTrips(Float planTrips) {
		this.planTrips = planTrips;
	}

	public Float getRealtimeClasses() {
		return realtimeClasses;
	}

	public void setRealtimeClasses(Float realtimeClasses) {
		this.realtimeClasses = realtimeClasses;
	}

	public Float getPlanClasses() {
		return planClasses;
	}

	public void setPlanClasses(Float planClasses) {
		this.planClasses = planClasses;
	}
}
