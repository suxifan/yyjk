package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "temp_bus_over_warn_trail")
public class TempBusOverWarnTrail {
    @Id
    @Column(name = "warn_uuid")
    private String warnUuid;

    /**
     * 设备号
     */
    @Column(name = "device_id")
    private String deviceId;

    /**
     * 设备编码
     */
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 告警类型
     */
    @Column(name = "warn_type")
    private String warnType;

    /**
     * 告警时间
     */
    @Column(name = "warn_time")
    private Date warnTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 维度
     */
    private String lat;

    /**
     * 经度
     */
    private String lng;

    /**
     * 速度
     */
    private String speed;

    /**
     * 司机姓名
     */
    @Column(name = "driver_name")
    private String driverName;

    /**
     * 司机卡号
     */
    @Column(name = "driver_num")
    private String driverNum;

    /**
     * 告警日期
     */
    @Column(name = "warn_date")
    private Date warnDate;

    /**
     * 报警表外键
     */
    @Column(name = "fk_warn_uuid")
    private String fkWarnUuid;

    /**
     * @return warn_uuid
     */
    public String getWarnUuid() {
        return warnUuid;
    }

    /**
     * @param warnUuid
     */
    public void setWarnUuid(String warnUuid) {
        this.warnUuid = warnUuid;
    }

    /**
     * 获取设备号
     *
     * @return device_id - 设备号
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备号
     *
     * @param deviceId 设备号
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取设备编码
     *
     * @return device_code - 设备编码
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 设置设备编码
     *
     * @param deviceCode 设备编码
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    /**
     * 获取告警类型
     *
     * @return warn_type - 告警类型
     */
    public String getWarnType() {
        return warnType;
    }

    /**
     * 设置告警类型
     *
     * @param warnType 告警类型
     */
    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    /**
     * 获取告警时间
     *
     * @return warn_time - 告警时间
     */
    public Date getWarnTime() {
        return warnTime;
    }

    /**
     * 设置告警时间
     *
     * @param warnTime 告警时间
     */
    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取维度
     *
     * @return lat - 维度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置维度
     *
     * @param lat 维度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取经度
     *
     * @return lng - 经度
     */
    public String getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * 获取速度
     *
     * @return speed - 速度
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * 设置速度
     *
     * @param speed 速度
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * 获取司机姓名
     *
     * @return driver_name - 司机姓名
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * 设置司机姓名
     *
     * @param driverName 司机姓名
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * 获取司机卡号
     *
     * @return driver_num - 司机卡号
     */
    public String getDriverNum() {
        return driverNum;
    }

    /**
     * 设置司机卡号
     *
     * @param driverNum 司机卡号
     */
    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    /**
     * 获取告警日期
     *
     * @return warn_date - 告警日期
     */
    public Date getWarnDate() {
        return warnDate;
    }

    /**
     * 设置告警日期
     *
     * @param warnDate 告警日期
     */
    public void setWarnDate(Date warnDate) {
        this.warnDate = warnDate;
    }

    /**
     * 获取报警表外键
     *
     * @return fk_warn_uuid - 报警表外键
     */
    public String getFkWarnUuid() {
        return fkWarnUuid;
    }

    /**
     * 设置报警表外键
     *
     * @param fkWarnUuid 报警表外键
     */
    public void setFkWarnUuid(String fkWarnUuid) {
        this.fkWarnUuid = fkWarnUuid;
    }
}