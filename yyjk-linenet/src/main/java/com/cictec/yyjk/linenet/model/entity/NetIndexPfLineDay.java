package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_index_pf_line_day")
public class NetIndexPfLineDay {
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
     * 刷卡总量
     */
    @Column(name = "brush_count")
    private String brushCount;

    /**
     * 周转量
     */
    private String zzl;

    /**
     * 平均运距
     */
    private String pjyj;

    /**
     * 刷卡时间
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
     * 获取刷卡总量
     *
     * @return brush_count - 刷卡总量
     */
    public String getBrushCount() {
        return brushCount;
    }

    /**
     * 设置刷卡总量
     *
     * @param brushCount 刷卡总量
     */
    public void setBrushCount(String brushCount) {
        this.brushCount = brushCount;
    }

    /**
     * 获取周转量
     *
     * @return zzl - 周转量
     */
    public String getZzl() {
        return zzl;
    }

    /**
     * 设置周转量
     *
     * @param zzl 周转量
     */
    public void setZzl(String zzl) {
        this.zzl = zzl;
    }

    /**
     * 获取平均运距
     *
     * @return pjyj - 平均运距
     */
    public String getPjyj() {
        return pjyj;
    }

    /**
     * 设置平均运距
     *
     * @param pjyj 平均运距
     */
    public void setPjyj(String pjyj) {
        this.pjyj = pjyj;
    }

    /**
     * 获取刷卡时间
     *
     * @return p_date - 刷卡时间
     */
    public String getpDate() {
        return pDate;
    }

    /**
     * 设置刷卡时间
     *
     * @param pDate 刷卡时间
     */
    public void setpDate(String pDate) {
        this.pDate = pDate;
    }
}