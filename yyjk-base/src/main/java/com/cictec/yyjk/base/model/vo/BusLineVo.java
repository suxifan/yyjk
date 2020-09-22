package com.cictec.yyjk.base.model.vo;

import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by xpguo on 2019/05/21.
 */
public class BusLineVo extends AbstractVo {
	private String lineId;
	private String lineName;
	private String parLineUuid;
	private String orgId;
	private String orgName;
	private String dropFlag;
	private String isvalid;
	private List<String> lineUuids;

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDropFlag() {
		return dropFlag;
	}

	public void setDropFlag(String dropFlag) {
		this.dropFlag = dropFlag;
	}

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getParLineUuid() {
		return parLineUuid;
	}

	public void setParLineUuid(String parLineUuid) {
		this.parLineUuid = parLineUuid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
