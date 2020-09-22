package com.cictec.yyjk.fatigue.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by xpguo on 2019/09/25.
 */
public class DwDimBusDriverVo extends AbstractVo {

	/*
	 * 机构
	 */
	private String orgId;
	/*
	 * 线路uuids
	 */
	private List<String> lineUuids = new ArrayList<>();
	/*
	 * 线路UUID
	 */
	private String lineUuid;
	/*
	 * 司机名称
	 */
	private String drvName;

	/*
	 * 司机工号
	 */
	private String drvEmployeeId;

	/*
	 * 司机UUID
	 */
	private String drvUuid;
	/*
	 * 司机IC卡号
	 */
	private String drvIcCard;

	public String getDrvIcCard() {
		return drvIcCard;
	}

	public void setDrvIcCard(String drvIcCard) {
		this.drvIcCard = drvIcCard;
	}

	public String getDrvUuid() {
		return drvUuid;
	}

	public void setDrvUuid(String drvUuid) {
		this.drvUuid = drvUuid;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public String getLineUuid() {
		return lineUuid;
	}

	public void setLineUuid(String lineUuid) {
		this.lineUuid = lineUuid;
	}

	public String getDrvName() {
		return drvName;
	}

	public void setDrvName(String drvName) {
		this.drvName = drvName;
	}

	public String getDrvEmployeeId() {
		return drvEmployeeId;
	}

	public void setDrvEmployeeId(String drvEmployeeId) {
		this.drvEmployeeId = drvEmployeeId;
	}

}
