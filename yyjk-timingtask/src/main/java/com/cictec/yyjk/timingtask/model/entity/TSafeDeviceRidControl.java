package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_safe_device_rid_control")
public class TSafeDeviceRidControl {
    @Id
    private String uuid;

    /**
     * 车辆ID
     */
    @Column(name = "bus_uuid")
    private String busUuid;

    /**
     * 车辆自编号
     */
    @Column(name = "bus_self_code")
    private String busSelfCode;

    /**
     * 车牌号
     */
    @Column(name = "bus_number")
    private String busNumber;

    /**
     * 机构ID
     */
    @Column(name = "org_uuid")
    private String orgUuid;

    /**
     * 机构名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 线路ID
     */
    @Column(name = "line_uuid")
    private String lineUuid;

    /**
     * 线路名称
     */
    @Column(name = "line_name")
    private String lineName;

    /**
     * 车辆在线时间
     */
    @Column(name = "bus_online_time")
    private Date busOnlineTime;

    /**
     * 车辆更新时间
     */
    @Column(name = "bus_update_time")
    private Date busUpdateTime;

    /**
     * 车辆状态
     */
    @Column(name = "bus_state")
    private String busState;

    /**
     * 异常报警时间
     */
    @Column(name = "warn_time")
    private Date warnTime;

    /**
     * 当前状态(异常0；正常1；设备和车同时在线正常，设备不在线异常；)
     */
    @Column(name = "current_state")
    private String currentState;

    /**
     * 设备ID
     */
    @Column(name = "dev_uuid")
    private String devUuid;

    /**
     * 设备编号
     */
    @Column(name = "dev_code")
    private String devCode;

    /**
     * 设备类型
     */
    @Column(name = "dev_model")
    private String devModel;

    /**
     * 设备在线时间
     */
    @Column(name = "dev_online_time")
    private Date devOnlineTime;

    /**
     * 设备更新时间
     */
    @Column(name = "dev_update_time")
    private Date devUpdateTime;

    /**
     * 设备状态
     */
    @Column(name = "dev_state")
    private String devState;

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取车辆ID
     *
     * @return bus_uuid - 车辆ID
     */
    public String getBusUuid() {
        return busUuid;
    }

    /**
     * 设置车辆ID
     *
     * @param busUuid 车辆ID
     */
    public void setBusUuid(String busUuid) {
        this.busUuid = busUuid;
    }

    /**
     * 获取车辆自编号
     *
     * @return bus_self_code - 车辆自编号
     */
    public String getBusSelfCode() {
        return busSelfCode;
    }

    /**
     * 设置车辆自编号
     *
     * @param busSelfCode 车辆自编号
     */
    public void setBusSelfCode(String busSelfCode) {
        this.busSelfCode = busSelfCode;
    }

    /**
     * 获取车牌号
     *
     * @return bus_number - 车牌号
     */
    public String getBusNumber() {
        return busNumber;
    }

    /**
     * 设置车牌号
     *
     * @param busNumber 车牌号
     */
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    /**
     * 获取机构ID
     *
     * @return org_uuid - 机构ID
     */
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
     * 设置机构ID
     *
     * @param orgUuid 机构ID
     */
    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    /**
     * 获取机构名称
     *
     * @return org_name - 机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置机构名称
     *
     * @param orgName 机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取线路ID
     *
     * @return line_uuid - 线路ID
     */
    public String getLineUuid() {
        return lineUuid;
    }

    /**
     * 设置线路ID
     *
     * @param lineUuid 线路ID
     */
    public void setLineUuid(String lineUuid) {
        this.lineUuid = lineUuid;
    }

    /**
     * 获取线路名称
     *
     * @return line_name - 线路名称
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * 设置线路名称
     *
     * @param lineName 线路名称
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * 获取车辆在线时间
     *
     * @return bus_online_time - 车辆在线时间
     */
    public Date getBusOnlineTime() {
        return busOnlineTime;
    }

    /**
     * 设置车辆在线时间
     *
     * @param busOnlineTime 车辆在线时间
     */
    public void setBusOnlineTime(Date busOnlineTime) {
        this.busOnlineTime = busOnlineTime;
    }

    /**
     * 获取车辆更新时间
     *
     * @return bus_update_time - 车辆更新时间
     */
    public Date getBusUpdateTime() {
        return busUpdateTime;
    }

    /**
     * 设置车辆更新时间
     *
     * @param busUpdateTime 车辆更新时间
     */
    public void setBusUpdateTime(Date busUpdateTime) {
        this.busUpdateTime = busUpdateTime;
    }

    /**
     * 获取车辆状态
     *
     * @return bus_state - 车辆状态
     */
    public String getBusState() {
        return busState;
    }

    /**
     * 设置车辆状态
     *
     * @param busState 车辆状态
     */
    public void setBusState(String busState) {
        this.busState = busState;
    }

    /**
     * 获取异常报警时间
     *
     * @return warn_time - 异常报警时间
     */
    public Date getWarnTime() {
        return warnTime;
    }

    /**
     * 设置异常报警时间
     *
     * @param warnTime 异常报警时间
     */
    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    /**
     * 获取当前状态(异常0；正常1；设备和车同时在线正常，设备不在线异常；)
     *
     * @return current_state - 当前状态(异常0；正常1；设备和车同时在线正常，设备不在线异常；)
     */
    public String getCurrentState() {
        return currentState;
    }

    /**
     * 设置当前状态(异常0；正常1；设备和车同时在线正常，设备不在线异常；)
     *
     * @param currentState 当前状态(异常0；正常1；设备和车同时在线正常，设备不在线异常；)
     */
    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    /**
     * 获取设备ID
     *
     * @return dev_uuid - 设备ID
     */
    public String getDevUuid() {
        return devUuid;
    }

    /**
     * 设置设备ID
     *
     * @param devUuid 设备ID
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
     * @param devCode 设备编号
     */
    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    /**
     * 获取设备类型
     *
     * @return dev_model - 设备类型
     */
    public String getDevModel() {
        return devModel;
    }

    /**
     * 设置设备类型
     *
     * @param devModel 设备类型
     */
    public void setDevModel(String devModel) {
        this.devModel = devModel;
    }

    /**
     * 获取设备在线时间
     *
     * @return dev_online_time - 设备在线时间
     */
    public Date getDevOnlineTime() {
        return devOnlineTime;
    }

    /**
     * 设置设备在线时间
     *
     * @param devOnlineTime 设备在线时间
     */
    public void setDevOnlineTime(Date devOnlineTime) {
        this.devOnlineTime = devOnlineTime;
    }

    /**
     * 获取设备更新时间
     *
     * @return dev_update_time - 设备更新时间
     */
    public Date getDevUpdateTime() {
        return devUpdateTime;
    }

    /**
     * 设置设备更新时间
     *
     * @param devUpdateTime 设备更新时间
     */
    public void setDevUpdateTime(Date devUpdateTime) {
        this.devUpdateTime = devUpdateTime;
    }

    /**
     * 获取设备状态
     *
     * @return dev_state - 设备状态
     */
    public String getDevState() {
        return devState;
    }

    /**
     * 设置设备状态
     *
     * @param devState 设备状态
     */
    public void setDevState(String devState) {
        this.devState = devState;
    }
}