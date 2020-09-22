package com.cictec.yyjk.timingtask.model.vo;

public class LineStationInfoVo {
	private String lineUuid;
	private String lineName;
	private String lineType;
	private String staUuid;
	private String staName;
	private String staSeq;

	public LineStationInfoVo() {
		super();
	}

	public LineStationInfoVo(String lineUuid, String lineName, String lineType, String staUuid, String staName,
			String staSeq) {
		super();
		this.lineUuid = lineUuid;
		this.lineName = lineName;
		this.lineType = lineType;
		this.staUuid = staUuid;
		this.staName = staName;
		this.staSeq = staSeq;
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

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getStaUuid() {
		return staUuid;
	}

	public void setStaUuid(String staUuid) {
		this.staUuid = staUuid;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public String getStaSeq() {
		return staSeq;
	}

	public void setStaSeq(String staSeq) {
		this.staSeq = staSeq;
	}

}
