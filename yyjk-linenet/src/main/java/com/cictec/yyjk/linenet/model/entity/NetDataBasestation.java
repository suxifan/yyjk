package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_data_basestation")
public class NetDataBasestation {
    /**
     * 站位ID
     */
    @Id
    @Column(name = "station_id")
    private String stationId;

    /**
     * 站位名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 经度
     */
    private String lon;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 方向角
     */
    private String angle;

    /**
     * 获取站位ID
     *
     * @return station_id - 站位ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置站位ID
     *
     * @param stationId 站位ID
     */
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * 获取站位名称
     *
     * @return station_name - 站位名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置站位名称
     *
     * @param stationName 站位名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * 获取经度
     *
     * @return lon - 经度
     */
    public String getLon() {
        return lon;
    }

    /**
     * 设置经度
     *
     * @param lon 经度
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取方向角
     *
     * @return angle - 方向角
     */
    public String getAngle() {
        return angle;
    }

    /**
     * 设置方向角
     *
     * @param angle 方向角
     */
    public void setAngle(String angle) {
        this.angle = angle;
    }
}