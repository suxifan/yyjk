package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_index_repeat_sc")
public class NetIndexRepeatSc {
    @Id
    private Integer uuid;

    /**
     * 线路号
     */
    @Column(name = "line_number")
    private String lineNumber;

    /**
     * 上车站位
     */
    @Column(name = "s_station")
    private String sStation;

    /**
     * 下车站位
     */
    @Column(name = "e_station")
    private String eStation;

    /**
     * 上车站序号
     */
    @Column(name = "s_station_index")
    private Integer sStationIndex;

    /**
     * 下车站序号
     */
    @Column(name = "e_station_index")
    private Integer eStationIndex;

    /**
     * 重复线路
     */
    @Column(name = "repeat_line")
    private String repeatLine;

    /**
     * 重复线路数量
     */
    @Column(name = "repeat_line_count")
    private Integer repeatLineCount;

    /**
     * 上下行
     */
    private String arrow;

    /**
     * 线路名称
     */
    private String linename;

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
     * 获取上车站位
     *
     * @return s_station - 上车站位
     */
    public String getsStation() {
        return sStation;
    }

    /**
     * 设置上车站位
     *
     * @param sStation 上车站位
     */
    public void setsStation(String sStation) {
        this.sStation = sStation;
    }

    /**
     * 获取下车站位
     *
     * @return e_station - 下车站位
     */
    public String geteStation() {
        return eStation;
    }

    /**
     * 设置下车站位
     *
     * @param eStation 下车站位
     */
    public void seteStation(String eStation) {
        this.eStation = eStation;
    }

    /**
     * 获取上车站序号
     *
     * @return s_station_index - 上车站序号
     */
    public Integer getsStationIndex() {
        return sStationIndex;
    }

    /**
     * 设置上车站序号
     *
     * @param sStationIndex 上车站序号
     */
    public void setsStationIndex(Integer sStationIndex) {
        this.sStationIndex = sStationIndex;
    }

    /**
     * 获取下车站序号
     *
     * @return e_station_index - 下车站序号
     */
    public Integer geteStationIndex() {
        return eStationIndex;
    }

    /**
     * 设置下车站序号
     *
     * @param eStationIndex 下车站序号
     */
    public void seteStationIndex(Integer eStationIndex) {
        this.eStationIndex = eStationIndex;
    }

    /**
     * 获取重复线路
     *
     * @return repeat_line - 重复线路
     */
    public String getRepeatLine() {
        return repeatLine;
    }

    /**
     * 设置重复线路
     *
     * @param repeatLine 重复线路
     */
    public void setRepeatLine(String repeatLine) {
        this.repeatLine = repeatLine;
    }

    /**
     * 获取重复线路数量
     *
     * @return repeat_line_count - 重复线路数量
     */
    public Integer getRepeatLineCount() {
        return repeatLineCount;
    }

    /**
     * 设置重复线路数量
     *
     * @param repeatLineCount 重复线路数量
     */
    public void setRepeatLineCount(Integer repeatLineCount) {
        this.repeatLineCount = repeatLineCount;
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
     * 获取线路名称
     *
     * @return linename - 线路名称
     */
    public String getLinename() {
        return linename;
    }

    /**
     * 设置线路名称
     *
     * @param linename 线路名称
     */
    public void setLinename(String linename) {
        this.linename = linename;
    }
}