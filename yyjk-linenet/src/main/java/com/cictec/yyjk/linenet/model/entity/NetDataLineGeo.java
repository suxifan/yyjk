package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_data_line_geo")
public class NetDataLineGeo {
    /**
     * 线路号的唯一ID,关联线路表的lineuuid
     */
    @Id
    private String lineid;

    /**
     * 线路号
     */
    private String linenum;

    /**
     * 上下行
     */
    private String arrow;

    /**
     * 经度
     */
    private String lon;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 节点序号
     */
    private Short nodeindex;

    /**
     * 站序号
     */
    private Short stationindex;

    /**
     * 站位名称
     */
    private String stationname;

    /**
     * 唯一站位ID
     */
    private String stationid;

    /**
     * 获取线路号的唯一ID,关联线路表的lineuuid
     *
     * @return lineid - 线路号的唯一ID,关联线路表的lineuuid
     */
    public String getLineid() {
        return lineid;
    }

    /**
     * 设置线路号的唯一ID,关联线路表的lineuuid
     *
     * @param lineid 线路号的唯一ID,关联线路表的lineuuid
     */
    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    /**
     * 获取线路号
     *
     * @return linenum - 线路号
     */
    public String getLinenum() {
        return linenum;
    }

    /**
     * 设置线路号
     *
     * @param linenum 线路号
     */
    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }

    /**
     * 获取上下行
     *
     * @return arrow - 上下行
     */
    public String getArrow() {
        return arrow;
    }

    /**
     * 设置上下行
     *
     * @param arrow 上下行
     */
    public void setArrow(String arrow) {
        this.arrow = arrow;
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
     * 获取节点序号
     *
     * @return nodeindex - 节点序号
     */
    public Short getNodeindex() {
        return nodeindex;
    }

    /**
     * 设置节点序号
     *
     * @param nodeindex 节点序号
     */
    public void setNodeindex(Short nodeindex) {
        this.nodeindex = nodeindex;
    }

    /**
     * 获取站序号
     *
     * @return stationindex - 站序号
     */
    public Short getStationindex() {
        return stationindex;
    }

    /**
     * 设置站序号
     *
     * @param stationindex 站序号
     */
    public void setStationindex(Short stationindex) {
        this.stationindex = stationindex;
    }

    /**
     * 获取站位名称
     *
     * @return stationname - 站位名称
     */
    public String getStationname() {
        return stationname;
    }

    /**
     * 设置站位名称
     *
     * @param stationname 站位名称
     */
    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    /**
     * 获取唯一站位ID
     *
     * @return stationid - 唯一站位ID
     */
    public String getStationid() {
        return stationid;
    }

    /**
     * 设置唯一站位ID
     *
     * @param stationid 唯一站位ID
     */
    public void setStationid(String stationid) {
        this.stationid = stationid;
    }
}