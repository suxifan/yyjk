package com.cictec.yyjk.fatigue.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryCondition extends Condition {

	private String roleId;
	private String userId;
	private String orgId;
	// 日期（yyyy-MM-dd）
	private Date dateTime;
	// 日期（yyyy-MM-dd）
	private String warnDate;
	// 月份 yyyy-MM
	private String month;

	private Date startTime;

	private Date endTime;
	// 车牌号
	private String busNumber;
	// 自编号
	private String busSelfCode;
	// 司机姓名
	private String driverName;
	// 司机工号
	private String driverNum;
	// 报警类型
	private List<String> warnTypes = new ArrayList<>();
	// 告警级别
	private String warnLevel;
	// 是否分页
	private boolean isPage;

	// 站点uuids
	private List<String> staUuids = new ArrayList<>();
	// 线路uuids
	private List<String> lineUuids = new ArrayList<>();

	private String sql;

	// 处理结果（0：未处理；1：已处理；2：误报）
	private List<String> handleResults = new ArrayList<>();
	// 审核结果（0：未审核；1：已审核 ）其中已审核包含 1已处理；2：误报两种情况
	private List<String> auditStatus = new ArrayList<>();

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	public String getWarnDate() {
		return warnDate;
	}

	public void setWarnDate(String warnDate) {
		this.warnDate = warnDate;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public List<String> getWarnTypes() {
		return warnTypes;
	}

	public void setWarnTypes(List<String> warnTypes) {
		this.warnTypes = warnTypes;
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

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverNum() {
		return driverNum;
	}

	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<String> getStaUuids() {
		return staUuids;
	}

	public void setStaUuids(List<String> staUuids) {
		this.staUuids = staUuids;
	}

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public List<String> getHandleResults() {
		return handleResults;
	}

	public void setHandleResults(List<String> handleResults) {
		this.handleResults = handleResults;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public List<String> getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(List<String> auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * 调度http参数字符串
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("orgId=").append(this.getOrgId()).append("&lineId=");
		return builder.toString();
	}
}
