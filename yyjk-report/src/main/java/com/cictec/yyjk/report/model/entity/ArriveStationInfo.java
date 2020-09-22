package com.cictec.yyjk.report.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

/**
 * 车辆到站时刻信息实体类
 * 
 * @author gxp
 *
 */
@Table(name = "analysis_arrive_volume_day")
public class ArriveStationInfo {
	@Id
	@KeySql(sql = "select nextval('zhfxpt_info_id_seq'::regclass)", order = ORDER.BEFORE)
	@Column(name = "arrive_uuid")
	private String arriveUuid;

	@Column(name = "org_uuid")
	private String orgUuid;

	@Column(name = "org_name")
	private String orgName;

	@Column(name = "line_uuid")
	private String lineUuid;

	@Column(name = "line_name")
	private String lineName;

	@Column(name = "line_type")
	private String lineType;

	@Column(name = "sta_uuid")
	private String staUuid;

	@Column(name = "sta_seq")
	private String staSequence;

	@Column(name = "sta_name")
	private String staName;

	@Column(name = "bus_plate_number")
	private String busNumber;

	@Column(name = "upload_time_date")
	private String uploadTimeDate;

	@Column(name = "upload_time_in")
	private Date uploadTimeIn;

	@Column(name = "upload_time_out")
	private Date uploadTimeOut;

	@Column(name = "upload_time_hour")
	private Integer uploadTimeHour;

	@Column(name = "bus_class")
	private Integer busClass;

	public String getArriveUuid() {
		return arriveUuid;
	}

	public void setArriveUuid(String arriveUuid) {
		this.arriveUuid = arriveUuid;
	}

	public String getOrgUuid() {
		return orgUuid;
	}

	public void setOrgUuid(String orgUuid) {
		this.orgUuid = orgUuid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public String getStaSequence() {
		return staSequence;
	}

	public void setStaSequence(String staSequence) {
		this.staSequence = staSequence;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getUploadTimeDate() {
		return uploadTimeDate;
	}

	public void setUploadTimeDate(String uploadTimeDate) {
		this.uploadTimeDate = uploadTimeDate;
	}

	public Date getUploadTimeIn() {
		return uploadTimeIn;
	}

	public void setUploadTimeIn(Date uploadTimeIn) {
		this.uploadTimeIn = uploadTimeIn;
	}

	public Date getUploadTimeOut() {
		return uploadTimeOut;
	}

	public void setUploadTimeOut(Date uploadTimeOut) {
		this.uploadTimeOut = uploadTimeOut;
	}

	public Integer getUploadTimeHour() {
		return uploadTimeHour;
	}

	public void setUploadTimeHour(Integer uploadTimeHour) {
		this.uploadTimeHour = uploadTimeHour;
	}

	public Integer getBusClass() {
		return busClass;
	}

	public void setBusClass(Integer busClass) {
		this.busClass = busClass;
	}

}
