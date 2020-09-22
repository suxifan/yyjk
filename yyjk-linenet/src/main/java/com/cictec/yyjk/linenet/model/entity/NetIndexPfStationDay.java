package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_index_pf_station_day")
public class NetIndexPfStationDay {
    @Id
    private Integer uuid;

    /**
     * 线路号
     */
    @Column(name = "line_number")
    private String lineNumber;

    /**
     * 上下行
     */
    private String arrow;

    /**
     * 站序号
     */
    @Column(name = "station_index")
    private Integer stationIndex;

    /**
     * 站位名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 登量
     */
    @Column(name = "up_count")
    private Integer upCount;

    /**
     * 降量
     */
    @Column(name = "down_count")
    private Integer downCount;

    /**
     * 通过量
     */
    @Column(name = "pass_count")
    private Integer passCount;

    /**
     * 刷卡日期
     */
    @Column(name = "p_date")
    private String pDate;

    /**
     * @return uuid
     */
    public Integer getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取线路号
     *
     * @return line_number - 线路号
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * 设置线路号
     *
     * @param lineNumber 线路号
     */
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
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
     * 获取登量
     *
     * @return up_count - 登量
     */
    public Integer getUpCount() {
        return upCount;
    }

    /**
     * 设置登量
     *
     * @param upCount 登量
     */
    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    /**
     * 获取降量
     *
     * @return down_count - 降量
     */
    public Integer getDownCount() {
        return downCount;
    }

    /**
     * 设置降量
     *
     * @param downCount 降量
     */
    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    /**
     * 获取通过量
     *
     * @return pass_count - 通过量
     */
    public Integer getPassCount() {
        return passCount;
    }

    /**
     * 设置通过量
     *
     * @param passCount 通过量
     */
    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    /**
     * 获取刷卡日期
     *
     * @return p_date - 刷卡日期
     */
    public String getpDate() {
        return pDate;
    }

    /**
     * 设置刷卡日期
     *
     * @param pDate 刷卡日期
     */
    public void setpDate(String pDate) {
        this.pDate = pDate;
    }
}