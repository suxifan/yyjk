package com.cictec.yyjk.fatigue.model.vo;

import java.util.Date;

public class TWarnNoPageVo {
	// 车牌号
	private String busPlateNumber;

	// 车辆编号
	private String busUuid;

	// 机构编号
	private String orgId;

	// 线路编号
	private String lineId;

	// 设备编号
	private String devCode;

	// 车辆编号
	private String busSelfCode;

	// 报警级别
	private String warnLevel;

	private String[] warnTypeId; // 疲劳类型id集合

	private String warnUuid;

	private Integer dateDiff; // 日期差

	private Date contrastStartTime; // 环比对比开始时间

	private Date contrastEndTime; // 环比对比结束时间

	protected Date startTime; // 开始时间
	protected Date endTime; // 结束时间

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
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

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String[] getWarnTypeId() {
		return warnTypeId;
	}

	public void setWarnTypeId(String[] warnTypeId) {
		this.warnTypeId = warnTypeId;
	}

	public String getWarnUuid() {
		return warnUuid;
	}

	public void setWarnUuid(String warnUuid) {
		this.warnUuid = warnUuid;
	}

	public Integer getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(Integer dateDiff) {
		this.dateDiff = dateDiff;
	}

	public Date getContrastStartTime() {
		return contrastStartTime;
	}

	public void setContrastStartTime(Date contrastStartTime) {
		this.contrastStartTime = contrastStartTime;
	}

	public Date getContrastEndTime() {
		return contrastEndTime;
	}

	public void setContrastEndTime(Date contrastEndTime) {
		this.contrastEndTime = contrastEndTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
