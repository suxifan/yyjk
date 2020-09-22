package com.cictec.yyjk.linenet.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "net_index_pf_od")
public class NetIndexPfOd {
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
     * 上车站位名称
     */
    @Column(name = "s_station_name")
    private String sStationName;

    /**
     * 上车站序号
     */
    @Column(name = "s_station_index")
    private Integer sStationIndex;

    /**
     * 下车站位名称
     */
    @Column(name = "e_station_name")
    private String eStationName;

    /**
     * 下车站序号
     */
    @Column(name = "e_station_index")
    private Integer eStationIndex;

    /**
     * 刷卡量
     */
    @Column(name = "brush_count")
    private Short brushCount;

    /**
     * 上车刷卡时间
     */
    @Column(name = "s_time")
    private Date sTime;

    /**
     * 下车刷卡时间
     */
    @Column(name = "e_time")
    private Date eTime;

    /**
     * 刷卡日上期
     */
    @Column(name = "p_date")
    private String pDate;

    /**
     * 刷卡时间段（以上车刷卡时间为准）
     */
    @Column(name = "p_time")
    private String pTime;

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
     * 获取上车站位名称
     *
     * @return s_station_name - 上车站位名称
     */
    public String getsStationName() {
        return sStationName;
    }

    /**
     * 设置上车站位名称
     *
     * @param sStationName 上车站位名称
     */
    public void setsStationName(String sStationName) {
        this.sStationName = sStationName;
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
     * 获取下车站位名称
     *
     * @return e_station_name - 下车站位名称
     */
    public String geteStationName() {
        return eStationName;
    }

    /**
     * 设置下车站位名称
     *
     * @param eStationName 下车站位名称
     */
    public void seteStationName(String eStationName) {
        this.eStationName = eStationName;
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
     * 获取刷卡量
     *
     * @return brush_count - 刷卡量
     */
    public Short getBrushCount() {
        return brushCount;
    }

    /**
     * 设置刷卡量
     *
     * @param brushCount 刷卡量
     */
    public void setBrushCount(Short brushCount) {
        this.brushCount = brushCount;
    }

    /**
     * 获取上车刷卡时间
     *
     * @return s_time - 上车刷卡时间
     */
    public Date getsTime() {
        return sTime;
    }

    /**
     * 设置上车刷卡时间
     *
     * @param sTime 上车刷卡时间
     */
    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    /**
     * 获取下车刷卡时间
     *
     * @return e_time - 下车刷卡时间
     */
    public Date geteTime() {
        return eTime;
    }

    /**
     * 设置下车刷卡时间
     *
     * @param eTime 下车刷卡时间
     */
    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    /**
     * 获取刷卡日上期
     *
     * @return p_date - 刷卡日上期
     */
    public String getpDate() {
        return pDate;
    }

    /**
     * 设置刷卡日上期
     *
     * @param pDate 刷卡日上期
     */
    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    /**
     * 获取刷卡时间段（以上车刷卡时间为准）
     *
     * @return p_time - 刷卡时间段（以上车刷卡时间为准）
     */
    public String getpTime() {
        return pTime;
    }

    /**
     * 设置刷卡时间段（以上车刷卡时间为准）
     *
     * @param pTime 刷卡时间段（以上车刷卡时间为准）
     */
    public void setpTime(String pTime) {
        this.pTime = pTime;
    }
}