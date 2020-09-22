package com.cictec.yyjk.base.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2019/11/13.
 */
public class BaseBusVideoInfoVo extends AbstractVo {
	private String orgUuid;
	private String lineUuid;
	private List<String> busPlateNumbers = new ArrayList<>();

	public String getOrgUuid() {
		return orgUuid;
	}

	public void setOrgUuid(String orgUuid) {
		this.orgUuid = orgUuid;
	}

	public String getLineUuid() {
		return lineUuid;
	}

	public void setLineUuid(String lineUuid) {
		this.lineUuid = lineUuid;
	}

	public List<String> getBusPlateNumbers() {
		return busPlateNumbers;
	}

	public void setBusPlateNumbers(List<String> busPlateNumbers) {
		this.busPlateNumbers = busPlateNumbers;
	}

}
