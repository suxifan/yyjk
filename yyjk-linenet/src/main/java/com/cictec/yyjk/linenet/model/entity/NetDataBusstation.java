package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_data_busstation")
public class NetDataBusstation {
    /**
     * 唯一ID
     */
    @Id
    private String uuid;

    /**
     * 关联线路表的uuid
     */
    private String pid;

    /**
     * 站位ID
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 站位名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 站序号
     */
    @Column(name = "station_index")
    private Integer stationIndex;

    /**
     * 距前一站距离
     */
    private String predistance;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lon;

    /**
     * 获取唯一ID
     *
     * @return uuid - 唯一ID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置唯一ID
     *
     * @param uuid 唯一ID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取关联线路表的uuid
     *
     * @return pid - 关联线路表的uuid
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置关联线路表的uuid
     *
     * @param pid 关联线路表的uuid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

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
     * 获取站序号
     *
     * @return station_index - 站序号
     */
    public Integer getStationIndex() {
        return stationIndex;
    }

    /**
     * 设置站序号
     *
     * @param stationIndex 站序号
     */
    public void setStationIndex(Integer stationIndex) {
        this.stationIndex = stationIndex;
    }

    /**
     * 获取距前一站距离
     *
     * @return predistance - 距前一站距离
     */
    public String getPredistance() {
        return predistance;
    }

    /**
     * 设置距前一站距离
     *
     * @param predistance 距前一站距离
     */
    public void setPredistance(String predistance) {
        this.predistance = predistance;
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
}