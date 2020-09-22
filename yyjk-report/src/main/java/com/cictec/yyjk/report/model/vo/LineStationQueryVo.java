package com.cictec.yyjk.report.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

public class LineStationQueryVo extends AbstractVo {
	private String lineId;
	private String lineType;
	private Integer startHour;
	private Integer endHour;

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

}
