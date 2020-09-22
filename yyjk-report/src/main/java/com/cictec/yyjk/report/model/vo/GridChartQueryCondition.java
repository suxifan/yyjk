package com.cictec.yyjk.report.model.vo;

import java.util.ArrayList;
import java.util.List;

public class GridChartQueryCondition extends Condition {
	private String dateTime;
	private Integer startHour;
	private Integer endHour;
	private String dynamicTableName;// 动态表名
	private List<String> busPlateNumbers = new ArrayList<>();
	// 线路uuids
	private List<String> lineUuids = new ArrayList<>();

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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

	public List<String> getBusPlateNumbers() {
		return busPlateNumbers;
	}

	public void setBusPlateNumbers(List<String> busPlateNumbers) {
		this.busPlateNumbers = busPlateNumbers;
	}

	public String getDynamicTableName() {
		return dynamicTableName;
	}

	public void setDynamicTableName(String dynamicTableName) {
		this.dynamicTableName = dynamicTableName;
	}

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

}
