package com.cictec.yyjk.fatigue.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by Rwq on 2019/05/23.
 */
public class TDeviceVo extends AbstractVo {
	private String devOnlineStatus; // 在线状态 1:在线，0:离线
	private String lineId;// 线路ID
	private String orgId;// 权限ID
	private String busPlateNumber;// 车牌号
	private String busSelfCode; // 自编号
	private String devCode;// 设备编号
	private String busState;
	private String devModel;// 设备类型
	private String busNumber;// 车牌号

	/*
	 * 车辆UUID
	 */
	private String busUuid;
	private List<String> lineUuids = new ArrayList<>();
	private List<String> busUuids = new ArrayList<>();
	/**
	 * 设备ID
	 */
	private String devUuid;

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public List<String> getBusUuids() {
		return busUuids;
	}

	public void setBusUuids(List<String> busUuids) {
		this.busUuids = busUuids;
	}

	public String getDevUuid() {
		return devUuid;
	}

	public void setDevUuid(String devUuid) {
		this.devUuid = devUuid;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusState() {
		return busState;
	}

	public void setBusState(String busState) {
		this.busState = busState;
	}

	public String getDevModel() {
		return devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busPlateNumber == null) ? 0 : busPlateNumber.hashCode());
		result = prime * result + ((busSelfCode == null) ? 0 : busSelfCode.hashCode());
		result = prime * result + ((devCode == null) ? 0 : devCode.hashCode());
		result = prime * result + ((devOnlineStatus == null) ? 0 : devOnlineStatus.hashCode());
		result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TDeviceVo other = (TDeviceVo) obj;
		if (busPlateNumber == null) {
			if (other.busPlateNumber != null)
				return false;
		} else if (!busPlateNumber.equals(other.busPlateNumber))
			return false;
		if (busSelfCode == null) {
			if (other.busSelfCode != null)
				return false;
		} else if (!busSelfCode.equals(other.busSelfCode))
			return false;
		if (devCode == null) {
			if (other.devCode != null)
				return false;
		} else if (!devCode.equals(other.devCode))
			return false;
		if (devOnlineStatus == null) {
			if (other.devOnlineStatus != null)
				return false;
		} else if (!devOnlineStatus.equals(other.devOnlineStatus))
			return false;
		if (lineId == null) {
			if (other.lineId != null)
				return false;
		} else if (!lineId.equals(other.lineId))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		return true;
	}

	public String getDevOnlineStatus() {
		return devOnlineStatus;
	}

	public void setDevOnlineStatus(String devOnlineStatus) {
		this.devOnlineStatus = devOnlineStatus;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

}
