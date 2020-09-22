package com.cictec.yyjk.timingtask.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by xpguo on 2019/05/21.
 */
public class PassengerFlowResultVo extends AbstractVo {
	private String orgId;
	private String lineId;
	private String lineType;
	private String busNumber;
	private String busSelfCode;
	private String isHistory;
	private String startDate;
	private String endDate;
	private List<String> lineIds = new ArrayList<>();
	private List<String> lineUuids = new ArrayList<>();
	private String startTrips;
	private String endTrips;

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

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getIsHistory() {
		return isHistory;
	}

	public void setIsHistory(String isHistory) {
		this.isHistory = isHistory;
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

	public List<String> getLineIds() {
		return lineIds;
	}

	public void setLineIds(List<String> lineIds) {
		this.lineIds = lineIds;
	}

	public String getStartTrips() {
		return startTrips;
	}

	public void setStartTrips(String startTrips) {
		this.startTrips = startTrips;
	}

	public String getEndTrips() {
		return endTrips;
	}

	public void setEndTrips(String endTrips) {
		this.endTrips = endTrips;
	}

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

}
