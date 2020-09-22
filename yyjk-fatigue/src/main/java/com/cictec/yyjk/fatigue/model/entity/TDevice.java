package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "dw_dim_other_device")
public class TDevice {
	@Id
	@Column(name = "dev_uuid")
	private String devUuid;

	/**
	 * 设备编号
	 */
	@Column(name = "dev_code")
	private String devCode;

	/**
	 * 型号
	 */
	@Column(name = "dev_model_num")
	private String devModelNum;

	/**
	 * 版本号
	 */
	@Column(name = "dev_version")
	private String devVersion;

	@Column(name = "dev_plate_number")
	private String devPlateNumber;

	/**
	 * sim卡号
	 */
	@Column(name = "dev_sim_num")
	private String devSimNum;

	/**
	 * 设备在线状态
	 * 
	 * 0：断开
	 * 
	 * 1：在线
	 */
	@Column(name = "dev_online_status")
	private String devOnlineStatus;

	/**
	 * 1 启用 0 禁用
	 */
	@Column(name = "dev_isvalid")
	private String devIsvalid;

	/**
	 * 通用电话
	 */
	@Column(name = "dev_phone")
	private String devPhone;

	@Column(name = "dev_create_user")
	private String devCreateUser;

	@Column(name = "dev_create_time")
	private Date devCreateTime;

	@Column(name = "dev_update_user")
	private String devUpdateUser;

	@Column(name = "dev_update_time")
	private Date devUpdateTime;

	/**
	 * 删除标示 0：未删除 1 删除
	 */
	@Column(name = "dev_drop_flag")
	private String devDropFlag;

	@Column(name = "dev_remark")
	private String devRemark;

	/**
	 * 鉴权码
	 */
	@Column(name = "dev_key")
	private String devKey;

	/**
	 * 在线更新时间
	 */
	@Column(name = "dev_online_time")
	private Date devOnlineTime;

	/**
	 * 设备类别
	 */
	@Column(name = "dev_class")
	private String devClass;

	/**
	 * arm版本号
	 */
	@Column(name = "dev_arm_version")
	private String devArmVersion;

	/**
	 * arm秘钥
	 */
	@Column(name = "dev_arm_crc")
	private String devArmCrc;

	/**
	 * dsp版本号
	 */
	@Column(name = "dev_dsp_version")
	private String devDspVersion;

	/**
	 * dsp秘钥
	 */
	@Column(name = "dev_dsp_crc")
	private String devDspCrc;

	/**
	 * 车牌号
	 */
	@Column(name = "dev_bus_plate_number")
	private String devBusPlateNumber;

	// 机构名称
	@Transient
	private String orgName;

	// 线路名称
	@Transient
	private String lineName;
	// 车牌号
	@Transient
	private String busPlateNumber;
	// 车牌号
	@Transient
	private String busNumber;

	// 自编号
	@Transient
	private String busSelfCode;

	@Transient
	private String lineId; // 线路ID

	// 离线时间（毫秒）
	@Transient
	private String offlineTime;

	// 离线时间（显示 天.时.分.秒.毫秒）
	@Transient
	private String offlineTimeLabel;

	// 车辆状态
	@Transient
	private String busState;
	// 设备类型
	@Transient
	private String devModel;
	// 离线时长
	@Transient
	private String offlineTimes;

	public String getOfflineTimes() {
		return offlineTimes;
	}

	public void setOfflineTimes(String offlineTimes) {
		this.offlineTimes = offlineTimes;
	}

	public String getDevModel() {
		return devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}

	/**
	 * @return dev_uuid
	 */
	public String getDevUuid() {
		return devUuid;
	}

	/**
	 * @param devUuid
	 */
	public void setDevUuid(String devUuid) {
		this.devUuid = devUuid;
	}

	/**
	 * 获取设备编号
	 *
	 * @return dev_code - 设备编号
	 */
	public String getDevCode() {
		return devCode;
	}

	/**
	 * 设置设备编号
	 *
	 * @param devCode
	 *            设备编号
	 */
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	/**
	 * 获取型号
	 *
	 * @return dev_model_num - 型号
	 */
	public String getDevModelNum() {
		return devModelNum;
	}

	/**
	 * 设置型号
	 *
	 * @param devModelNum
	 *            型号
	 */
	public void setDevModelNum(String devModelNum) {
		this.devModelNum = devModelNum;
	}

	/**
	 * 获取版本号
	 *
	 * @return dev_version - 版本号
	 */
	public String getDevVersion() {
		return devVersion;
	}

	/**
	 * 设置版本号
	 *
	 * @param devVersion
	 *            版本号
	 */
	public void setDevVersion(String devVersion) {
		this.devVersion = devVersion;
	}

	/**
	 * @return dev_plate_number
	 */
	public String getDevPlateNumber() {
		return devPlateNumber;
	}

	/**
	 * @param devPlateNumber
	 */
	public void setDevPlateNumber(String devPlateNumber) {
		this.devPlateNumber = devPlateNumber;
	}

	/**
	 * 获取sim卡号
	 *
	 * @return dev_sim_num - sim卡号
	 */
	public String getDevSimNum() {
		return devSimNum;
	}

	/**
	 * 设置sim卡号
	 *
	 * @param devSimNum
	 *            sim卡号
	 */
	public void setDevSimNum(String devSimNum) {
		this.devSimNum = devSimNum;
	}

	/**
	 * 获取设备在线状态
	 * 
	 * 0：断开
	 * 
	 * 1：在线
	 *
	 * @return dev_online_status - 设备在线状态
	 * 
	 *         0：断开
	 * 
	 *         1：在线
	 */
	public String getDevOnlineStatus() {
		return devOnlineStatus;
	}

	/**
	 * 设置设备在线状态
	 * 
	 * 0：断开
	 * 
	 * 1：在线
	 *
	 * @param devOnlineStatus
	 *            设备在线状态
	 * 
	 *            0：断开
	 * 
	 *            1：在线
	 */
	public void setDevOnlineStatus(String devOnlineStatus) {
		this.devOnlineStatus = devOnlineStatus;
	}

	/**
	 * 获取1 启用 0 禁用
	 *
	 * @return dev_isvalid - 1 启用 0 禁用
	 */
	public String getDevIsvalid() {
		return devIsvalid;
	}

	/**
	 * 设置1 启用 0 禁用
	 *
	 * @param devIsvalid
	 *            1 启用 0 禁用
	 */
	public void setDevIsvalid(String devIsvalid) {
		this.devIsvalid = devIsvalid;
	}

	/**
	 * 获取通用电话
	 *
	 * @return dev_phone - 通用电话
	 */
	public String getDevPhone() {
		return devPhone;
	}

	/**
	 * 设置通用电话
	 *
	 * @param devPhone
	 *            通用电话
	 */
	public void setDevPhone(String devPhone) {
		this.devPhone = devPhone;
	}

	/**
	 * @return dev_create_user
	 */
	public String getDevCreateUser() {
		return devCreateUser;
	}

	/**
	 * @param devCreateUser
	 */
	public void setDevCreateUser(String devCreateUser) {
		this.devCreateUser = devCreateUser;
	}

	/**
	 * @return dev_create_time
	 */
	public Date getDevCreateTime() {
		return devCreateTime;
	}

	/**
	 * @param devCreateTime
	 */
	public void setDevCreateTime(Date devCreateTime) {
		this.devCreateTime = devCreateTime;
	}

	/**
	 * @return dev_update_user
	 */
	public String getDevUpdateUser() {
		return devUpdateUser;
	}

	/**
	 * @param devUpdateUser
	 */
	public void setDevUpdateUser(String devUpdateUser) {
		this.devUpdateUser = devUpdateUser;
	}

	/**
	 * @return dev_update_time
	 */
	public Date getDevUpdateTime() {
		return devUpdateTime;
	}

	/**
	 * @param devUpdateTime
	 */
	public void setDevUpdateTime(Date devUpdateTime) {
		this.devUpdateTime = devUpdateTime;
	}

	/**
	 * 获取删除标示 0：未删除 1 删除
	 *
	 * @return dev_drop_flag - 删除标示 0：未删除 1 删除
	 */
	public String getDevDropFlag() {
		return devDropFlag;
	}

	/**
	 * 设置删除标示 0：未删除 1 删除
	 *
	 * @param devDropFlag
	 *            删除标示 0：未删除 1 删除
	 */
	public void setDevDropFlag(String devDropFlag) {
		this.devDropFlag = devDropFlag;
	}

	/**
	 * @return dev_remark
	 */
	public String getDevRemark() {
		return devRemark;
	}

	/**
	 * @param devRemark
	 */
	public void setDevRemark(String devRemark) {
		this.devRemark = devRemark;
	}

	/**
	 * 获取鉴权码
	 *
	 * @return dev_key - 鉴权码
	 */
	public String getDevKey() {
		return devKey;
	}

	/**
	 * 设置鉴权码
	 *
	 * @param devKey
	 *            鉴权码
	 */
	public void setDevKey(String devKey) {
		this.devKey = devKey;
	}

	/**
	 * 获取在线更新时间
	 *
	 * @return dev_online_time - 在线更新时间
	 */
	public Date getDevOnlineTime() {
		return devOnlineTime;
	}

	/**
	 * 设置在线更新时间
	 *
	 * @param devOnlineTime
	 *            在线更新时间
	 */
	public void setDevOnlineTime(Date devOnlineTime) {
		this.devOnlineTime = devOnlineTime;
	}

	/**
	 * 获取设备类别
	 *
	 * @return dev_class - 设备类别
	 */
	public String getDevClass() {
		return devClass;
	}

	/**
	 * 设置设备类别
	 *
	 * @param devClass
	 *            设备类别
	 */
	public void setDevClass(String devClass) {
		this.devClass = devClass;
	}

	/**
	 * 获取arm版本号
	 *
	 * @return dev_arm_version - arm版本号
	 */
	public String getDevArmVersion() {
		return devArmVersion;
	}

	/**
	 * 设置arm版本号
	 *
	 * @param devArmVersion
	 *            arm版本号
	 */
	public void setDevArmVersion(String devArmVersion) {
		this.devArmVersion = devArmVersion;
	}

	/**
	 * 获取arm秘钥
	 *
	 * @return dev_arm_crc - arm秘钥
	 */
	public String getDevArmCrc() {
		return devArmCrc;
	}

	/**
	 * 设置arm秘钥
	 *
	 * @param devArmCrc
	 *            arm秘钥
	 */
	public void setDevArmCrc(String devArmCrc) {
		this.devArmCrc = devArmCrc;
	}

	/**
	 * 获取dsp版本号
	 *
	 * @return dev_dsp_version - dsp版本号
	 */
	public String getDevDspVersion() {
		return devDspVersion;
	}

	/**
	 * 设置dsp版本号
	 *
	 * @param devDspVersion
	 *            dsp版本号
	 */
	public void setDevDspVersion(String devDspVersion) {
		this.devDspVersion = devDspVersion;
	}

	/**
	 * 获取dsp秘钥
	 *
	 * @return dev_dsp_crc - dsp秘钥
	 */
	public String getDevDspCrc() {
		return devDspCrc;
	}

	/**
	 * 设置dsp秘钥
	 *
	 * @param devDspCrc
	 *            dsp秘钥
	 */
	public void setDevDspCrc(String devDspCrc) {
		this.devDspCrc = devDspCrc;
	}

	/**
	 * 获取车牌号
	 *
	 * @return dev_bus_plate_number - 车牌号
	 */
	public String getDevBusPlateNumber() {
		return devBusPlateNumber;
	}

	/**
	 * 设置车牌号
	 *
	 * @param devBusPlateNumber
	 *            车牌号
	 */
	public void setDevBusPlateNumber(String devBusPlateNumber) {
		this.devBusPlateNumber = devBusPlateNumber;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(String offlineTime) {
		this.offlineTime = offlineTime;
	}

	public String getOfflineTimeLabel() {
		return offlineTimeLabel;
	}

	public void setOfflineTimeLabel(String offlineTimeLabel) {
		this.offlineTimeLabel = offlineTimeLabel;
	}

	public String getBusState() {
		return busState;
	}

	public void setBusState(String busState) {
		this.busState = busState;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

}