package com.cictec.yyjk.report.model.vo;

import java.util.ArrayList;
import java.util.List;

public class StationOnOffQueryCondition {
	private List<String> stationIds = new ArrayList<>();
	private String startDate;
	private String endDate;
	private Integer startHour;
	private Integer endHour;
	private String personId;
	
	public List<String> getStationIds() {
		return stationIds;
	}

	public void setStationIds(List<String> stationIds) {
		this.stationIds = stationIds;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
