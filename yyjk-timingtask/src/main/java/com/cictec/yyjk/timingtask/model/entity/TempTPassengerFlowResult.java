package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "temp_t_passenger_flow_result")
public class TempTPassengerFlowResult {
	/**
	 * 主键id
	 */
	@Id
	@Column(name = "pfr_uuid")
	private String pfrUuid;

	/**
	 * 线路名称
	 */
	@Column(name = "pfr_line_name")
	private String pfrLineName;

	/**
	 * 线路ID
	 */
	@Column(name = "pfr_line_uuid")
	private String pfrLineUuid;

	/**
	 * 线路类型
	 */
	@Column(name = "pfr_line_type")
	private String pfrLineType;

	/**
	 * 站点顺序
	 */
	@Column(name = "pfr_station_seq")
	private String pfrStationSeq;

	/**
	 * 线路站点ID
	 */
	@Column(name = "pfr_line_station_uuid")
	private String pfrLineStationUuid;

	/**
	 * 总的上车人数
	 */
	@Column(name = "pfr_get_on_number")
	private Integer pfrGetOnNumber;

	/**
	 * 总的下车人数
	 */
	@Column(name = "pfr_get_off_number")
	private Integer pfrGetOffNumber;

	/**
	 * 修改时间
	 */
	@Column(name = "pfr_upload_time")
	private Date pfrUploadTime;

	/**
	 * 设备编号
	 */
	@Column(name = "prf_dev_code")
	private String prfDevCode;

	/**
	 * 前门上车人数
	 */
	@Column(name = "prf_get_f_on_number")
	private Integer prfGetFOnNumber;

	/**
	 * 前门下车人数
	 */
	@Column(name = "prf_get_f_off_number")
	private Integer prfGetFOffNumber;

	/**
	 * 中门上车人数
	 */
	@Column(name = "prf_get_c_on_number")
	private Integer prfGetCOnNumber;

	/**
	 * 中门下车人数
	 */
	@Column(name = "prf_get_c_off_number")
	private Integer prfGetCOffNumber;

	/**
	 * 后门上车人数
	 */
	@Column(name = "prf_get_e_on_number")
	private Integer prfGetEOnNumber;

	/**
	 * 后门下车人数
	 */
	@Column(name = "prf_get_e_off_number")
	private Integer prfGetEOffNumber;

	/**
	 * 原始数据值
	 */
	@Column(name = "prf_dev_datastring")
	private String prfDevDatastring;

	/**
	 * 车内人数
	 */
	@Column(name = "prf_get_person_count")
	private Integer prfGetPersonCount;

	/**
	 * 站点ID
	 */
	@Column(name = "pfr_station_uuid")
	private String pfrStationUuid;

	/**
	 * 趟次
	 */
	@Column(name = "pfr_trip_time")
	private String pfrTripTime;

	/**
	 * 日期
	 */
	@Column(name = "pfr_trip_date")
	private Date pfrTripDate;

	/**
	 * 开门时间
	 */
	@Column(name = "pfr_open_door_time")
	private String pfrOpenDoorTime;

	/**
	 * 关门时间
	 */
	@Column(name = "pfr_close_door_time")
	private String pfrCloseDoorTime;

	/**
	 * 设备uuid
	 */
	@Column(name = "prf_dev_uuid")
	private String prfDevUuid;

	@Column(name = "pfr_current_long")
	private String pfrCurrentLong;

	@Column(name = "pfr_current_lat")
	private String pfrCurrentLat;

	@Column(name = "pfr_before_long")
	private String pfrBeforeLong;

	@Column(name = "pfr_before_lat")
	private String pfrBeforeLat;

	@Column(name = "pfr_normal")
	private Integer pfrNormal;

	@Column(name = "pfr_quality")
	private String pfrQuality;

	@Transient
	private String type;

	/**
	 * 获取主键id
	 *
	 * @return pfr_uuid - 主键id
	 */
	public String getPfrUuid() {
		return pfrUuid;
	}

	/**
	 * 设置主键id
	 *
	 * @param pfrUuid
	 *            主键id
	 */
	public void setPfrUuid(String pfrUuid) {
		this.pfrUuid = pfrUuid;
	}

	/**
	 * 获取线路名称
	 *
	 * @return pfr_line_name - 线路名称
	 */
	public String getPfrLineName() {
		return pfrLineName;
	}

	/**
	 * 设置线路名称
	 *
	 * @param pfrLineName
	 *            线路名称
	 */
	public void setPfrLineName(String pfrLineName) {
		this.pfrLineName = pfrLineName;
	}

	/**
	 * 获取线路ID
	 *
	 * @return pfr_line_uuid - 线路ID
	 */
	public String getPfrLineUuid() {
		return pfrLineUuid;
	}

	/**
	 * 设置线路ID
	 *
	 * @param pfrLineUuid
	 *            线路ID
	 */
	public void setPfrLineUuid(String pfrLineUuid) {
		this.pfrLineUuid = pfrLineUuid;
	}

	/**
	 * 获取线路类型
	 *
	 * @return pfr_line_type - 线路类型
	 */
	public String getPfrLineType() {
		return pfrLineType;
	}

	/**
	 * 设置线路类型
	 *
	 * @param pfrLineType
	 *            线路类型
	 */
	public void setPfrLineType(String pfrLineType) {
		this.pfrLineType = pfrLineType;
	}

	/**
	 * 获取站点顺序
	 *
	 * @return pfr_station_seq - 站点顺序
	 */
	public String getPfrStationSeq() {
		return pfrStationSeq;
	}

	/**
	 * 设置站点顺序
	 *
	 * @param pfrStationSeq
	 *            站点顺序
	 */
	public void setPfrStationSeq(String pfrStationSeq) {
		this.pfrStationSeq = pfrStationSeq;
	}

	/**
	 * 获取线路站点ID
	 *
	 * @return pfr_line_station_uuid - 线路站点ID
	 */
	public String getPfrLineStationUuid() {
		return pfrLineStationUuid;
	}

	/**
	 * 设置线路站点ID
	 *
	 * @param pfrLineStationUuid
	 *            线路站点ID
	 */
	public void setPfrLineStationUuid(String pfrLineStationUuid) {
		this.pfrLineStationUuid = pfrLineStationUuid;
	}

	/**
	 * 获取总的上车人数
	 *
	 * @return pfr_get_on_number - 总的上车人数
	 */
	public Integer getPfrGetOnNumber() {
		return pfrGetOnNumber;
	}

	/**
	 * 设置总的上车人数
	 *
	 * @param pfrGetOnNumber
	 *            总的上车人数
	 */
	public void setPfrGetOnNumber(Integer pfrGetOnNumber) {
		this.pfrGetOnNumber = pfrGetOnNumber;
	}

	/**
	 * 获取总的下车人数
	 *
	 * @return pfr_get_off_number - 总的下车人数
	 */
	public Integer getPfrGetOffNumber() {
		return pfrGetOffNumber;
	}

	/**
	 * 设置总的下车人数
	 *
	 * @param pfrGetOffNumber
	 *            总的下车人数
	 */
	public void setPfrGetOffNumber(Integer pfrGetOffNumber) {
		this.pfrGetOffNumber = pfrGetOffNumber;
	}

	/**
	 * 获取修改时间
	 *
	 * @return pfr_upload_time - 修改时间
	 */
	public Date getPfrUploadTime() {
		return pfrUploadTime;
	}

	/**
	 * 设置修改时间
	 *
	 * @param pfrUploadTime
	 *            修改时间
	 */
	public void setPfrUploadTime(Date pfrUploadTime) {
		this.pfrUploadTime = pfrUploadTime;
	}

	/**
	 * 获取设备编号
	 *
	 * @return prf_dev_code - 设备编号
	 */
	public String getPrfDevCode() {
		return prfDevCode;
	}

	/**
	 * 设置设备编号
	 *
	 * @param prfDevCode
	 *            设备编号
	 */
	public void setPrfDevCode(String prfDevCode) {
		this.prfDevCode = prfDevCode;
	}

	/**
	 * 获取前门上车人数
	 *
	 * @return prf_get_f_on_number - 前门上车人数
	 */
	public Integer getPrfGetFOnNumber() {
		return prfGetFOnNumber;
	}

	/**
	 * 设置前门上车人数
	 *
	 * @param prfGetFOnNumber
	 *            前门上车人数
	 */
	public void setPrfGetFOnNumber(Integer prfGetFOnNumber) {
		this.prfGetFOnNumber = prfGetFOnNumber;
	}

	/**
	 * 获取前门下车人数
	 *
	 * @return prf_get_f_off_number - 前门下车人数
	 */
	public Integer getPrfGetFOffNumber() {
		return prfGetFOffNumber;
	}

	/**
	 * 设置前门下车人数
	 *
	 * @param prfGetFOffNumber
	 *            前门下车人数
	 */
	public void setPrfGetFOffNumber(Integer prfGetFOffNumber) {
		this.prfGetFOffNumber = prfGetFOffNumber;
	}

	/**
	 * 获取中门上车人数
	 *
	 * @return prf_get_c_on_number - 中门上车人数
	 */
	public Integer getPrfGetCOnNumber() {
		return prfGetCOnNumber;
	}

	/**
	 * 设置中门上车人数
	 *
	 * @param prfGetCOnNumber
	 *            中门上车人数
	 */
	public void setPrfGetCOnNumber(Integer prfGetCOnNumber) {
		this.prfGetCOnNumber = prfGetCOnNumber;
	}

	/**
	 * 获取中门下车人数
	 *
	 * @return prf_get_c_off_number - 中门下车人数
	 */
	public Integer getPrfGetCOffNumber() {
		return prfGetCOffNumber;
	}

	/**
	 * 设置中门下车人数
	 *
	 * @param prfGetCOffNumber
	 *            中门下车人数
	 */
	public void setPrfGetCOffNumber(Integer prfGetCOffNumber) {
		this.prfGetCOffNumber = prfGetCOffNumber;
	}

	/**
	 * 获取后门上车人数
	 *
	 * @return prf_get_e_on_number - 后门上车人数
	 */
	public Integer getPrfGetEOnNumber() {
		return prfGetEOnNumber;
	}

	/**
	 * 设置后门上车人数
	 *
	 * @param prfGetEOnNumber
	 *            后门上车人数
	 */
	public void setPrfGetEOnNumber(Integer prfGetEOnNumber) {
		this.prfGetEOnNumber = prfGetEOnNumber;
	}

	/**
	 * 获取后门下车人数
	 *
	 * @return prf_get_e_off_number - 后门下车人数
	 */
	public Integer getPrfGetEOffNumber() {
		return prfGetEOffNumber;
	}

	/**
	 * 设置后门下车人数
	 *
	 * @param prfGetEOffNumber
	 *            后门下车人数
	 */
	public void setPrfGetEOffNumber(Integer prfGetEOffNumber) {
		this.prfGetEOffNumber = prfGetEOffNumber;
	}

	/**
	 * 获取原始数据值
	 *
	 * @return prf_dev_datastring - 原始数据值
	 */
	public String getPrfDevDatastring() {
		return prfDevDatastring;
	}

	/**
	 * 设置原始数据值
	 *
	 * @param prfDevDatastring
	 *            原始数据值
	 */
	public void setPrfDevDatastring(String prfDevDatastring) {
		this.prfDevDatastring = prfDevDatastring;
	}

	/**
	 * 获取车内人数
	 *
	 * @return prf_get_person_count - 车内人数
	 */
	public Integer getPrfGetPersonCount() {
		return prfGetPersonCount;
	}

	/**
	 * 设置车内人数
	 *
	 * @param prfGetPersonCount
	 *            车内人数
	 */
	public void setPrfGetPersonCount(Integer prfGetPersonCount) {
		this.prfGetPersonCount = prfGetPersonCount;
	}

	/**
	 * 获取站点ID
	 *
	 * @return pfr_station_uuid - 站点ID
	 */
	public String getPfrStationUuid() {
		return pfrStationUuid;
	}

	/**
	 * 设置站点ID
	 *
	 * @param pfrStationUuid
	 *            站点ID
	 */
	public void setPfrStationUuid(String pfrStationUuid) {
		this.pfrStationUuid = pfrStationUuid;
	}

	/**
	 * 获取趟次
	 *
	 * @return pfr_trip_time - 趟次
	 */
	public String getPfrTripTime() {
		return pfrTripTime;
	}

	/**
	 * 设置趟次
	 *
	 * @param pfrTripTime
	 *            趟次
	 */
	public void setPfrTripTime(String pfrTripTime) {
		this.pfrTripTime = pfrTripTime;
	}

	/**
	 * 获取日期
	 *
	 * @return pfr_trip_date - 日期
	 */
	public Date getPfrTripDate() {
		return pfrTripDate;
	}

	/**
	 * 设置日期
	 *
	 * @param pfrTripDate
	 *            日期
	 */
	public void setPfrTripDate(Date pfrTripDate) {
		this.pfrTripDate = pfrTripDate;
	}

	/**
	 * 获取开门时间
	 *
	 * @return pfr_open_door_time - 开门时间
	 */
	public String getPfrOpenDoorTime() {
		return pfrOpenDoorTime;
	}

	/**
	 * 设置开门时间
	 *
	 * @param pfrOpenDoorTime
	 *            开门时间
	 */
	public void setPfrOpenDoorTime(String pfrOpenDoorTime) {
		this.pfrOpenDoorTime = pfrOpenDoorTime;
	}

	/**
	 * 获取关门时间
	 *
	 * @return pfr_close_door_time - 关门时间
	 */
	public String getPfrCloseDoorTime() {
		return pfrCloseDoorTime;
	}

	/**
	 * 设置关门时间
	 *
	 * @param pfrCloseDoorTime
	 *            关门时间
	 */
	public void setPfrCloseDoorTime(String pfrCloseDoorTime) {
		this.pfrCloseDoorTime = pfrCloseDoorTime;
	}

	/**
	 * 获取设备uuid
	 *
	 * @return prf_dev_uuid - 设备uuid
	 */
	public String getPrfDevUuid() {
		return prfDevUuid;
	}

	/**
	 * 设置设备uuid
	 *
	 * @param prfDevUuid
	 *            设备uuid
	 */
	public void setPrfDevUuid(String prfDevUuid) {
		this.prfDevUuid = prfDevUuid;
	}

	/**
	 * @return pfr_current_long
	 */
	public String getPfrCurrentLong() {
		return pfrCurrentLong;
	}

	/**
	 * @param pfrCurrentLong
	 */
	public void setPfrCurrentLong(String pfrCurrentLong) {
		this.pfrCurrentLong = pfrCurrentLong;
	}

	/**
	 * @return pfr_current_lat
	 */
	public String getPfrCurrentLat() {
		return pfrCurrentLat;
	}

	/**
	 * @param pfrCurrentLat
	 */
	public void setPfrCurrentLat(String pfrCurrentLat) {
		this.pfrCurrentLat = pfrCurrentLat;
	}

	/**
	 * @return pfr_before_long
	 */
	public String getPfrBeforeLong() {
		return pfrBeforeLong;
	}

	/**
	 * @param pfrBeforeLong
	 */
	public void setPfrBeforeLong(String pfrBeforeLong) {
		this.pfrBeforeLong = pfrBeforeLong;
	}

	/**
	 * @return pfr_before_lat
	 */
	public String getPfrBeforeLat() {
		return pfrBeforeLat;
	}

	/**
	 * @param pfrBeforeLat
	 */
	public void setPfrBeforeLat(String pfrBeforeLat) {
		this.pfrBeforeLat = pfrBeforeLat;
	}

	/**
	 * @return pfr_normal
	 */
	public Integer getPfrNormal() {
		return pfrNormal;
	}

	/**
	 * @param pfrNormal
	 */
	public void setPfrNormal(Integer pfrNormal) {
		this.pfrNormal = pfrNormal;
	}

	public String getPfrQuality() {
		return pfrQuality;
	}

	public void setPfrQuality(String pfrQuality) {
		this.pfrQuality = pfrQuality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}