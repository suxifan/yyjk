package com.cictec.yyjk.base.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by xpguo on 2019/05/20.
 */
public class BusVo extends AbstractVo {
	private String orgId;
	private String orgName;
	private String lineId;
	private String busDropFlag;
	private String busIsvalid;
	/**
	 * 车牌号
	 */
	private String busPlateNumber;
	/**
	 * 自编号
	 */
	private String busSelfCode;

	private String[] lineIds;

	private List<String> lineUuids = new ArrayList<String>();

	private String lineIdsStr;

	// 车辆自编号
	private List<String> carNo = new ArrayList<String>();
	// 车牌号
	private List<String> carList = new ArrayList<String>();

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<String> getCarNo() {
		return carNo;
	}

	public void setCarNo(List<String> carNo) {
		this.carNo = carNo;
	}

	public List<String> getCarList() {
		return carList;
	}

	public void setCarList(List<String> carList) {
		this.carList = carList;
	}

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

	public String getBusDropFlag() {
		return busDropFlag;
	}

	public void setBusDropFlag(String busDropFlag) {
		this.busDropFlag = busDropFlag;
	}

	public String getBusIsvalid() {
		return busIsvalid;
	}

	public void setBusIsvalid(String busIsvalid) {
		this.busIsvalid = busIsvalid;
	}

	public String[] getLineIds() {
		return lineIds;
	}

	public void setLineIds(String[] lineIds) {
		this.lineIds = lineIds;
	}

	public String getLineIdsStr() {
		return lineIdsStr;
	}

	public void setLineIdsStr(String lineIdsStr) {
		this.lineIdsStr = lineIdsStr;
	}

}
