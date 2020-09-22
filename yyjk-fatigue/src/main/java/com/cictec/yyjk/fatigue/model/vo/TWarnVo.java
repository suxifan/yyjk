package com.cictec.yyjk.fatigue.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by Rwq on 2019/05/22.
 */
public class TWarnVo extends AbstractVo {
	// 车牌号
	private String busPlateNumber;

	// 车辆编号
	private String busUuid;

	// 机构编号
	private String orgId;

	// 线路编号 兼顾老版本前端传参
	private String lineId;

	// 线路编号
	private List<String> lineUuids;

	// 设备编号
	private String devCode;

	// 车辆编号
	private String busSelfCode;

	// 报警级别
	private String warnLevel;

	// 员工编号
	private String drvEmployeeId;

	// 处理结果
	private List<String> handleResults = new ArrayList<>();

	private String[] warnTypeId; // 疲劳类型id集合

	private String warnUuid;

	private Integer dateDiff; // 日期差

	private Date contrastStartTime; // 环比对比开始时间

	private Date contrastEndTime; // 环比对比结束时间

	private Date warnTime; // 报警时间

	// 审核状态
	private List<String> auditStatus = new ArrayList<>();

	private String driverName;

	public Date getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(Date warnTime) {
		this.warnTime = warnTime;
	}

	public List<String> getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(List<String> auditStatus) {
		this.auditStatus = auditStatus;
	}

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

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
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

	public List<String> getHandleResults() {
		return handleResults;
	}

	public void setHandleResults(List<String> handleResults) {
		this.handleResults = handleResults;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getDrvEmployeeId() {
		return drvEmployeeId;
	}

	public void setDrvEmployeeId(String drvEmployeeId) {
		this.drvEmployeeId = drvEmployeeId;
	}

}
