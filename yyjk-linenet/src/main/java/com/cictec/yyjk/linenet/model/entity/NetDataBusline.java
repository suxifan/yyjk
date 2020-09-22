package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_data_busline")
public class NetDataBusline {
    /**
     * 唯一ID
     */
    @Id
    private String uuid;

    /**
     * 线路号的唯一ID
     */
    @Column(name = "line_uuid")
    private String lineUuid;

    /**
     * 线路号
     */
    @Column(name = "line_number")
    private String lineNumber;

    /**
     * 所属单位
     */
    private String company;

    /**
     * 上下行
     */
    private String arrow;

    /**
     * 线路名称
     */
    @Column(name = "line_name")
    private String lineName;

    /**
     * 线路长度
     */
    private Float length;

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
     * 获取线路号的唯一ID
     *
     * @return line_uuid - 线路号的唯一ID
     */
    public String getLineUuid() {
        return lineUuid;
    }

    /**
     * 设置线路号的唯一ID
     *
     * @param lineUuid 线路号的唯一ID
     */
    public void setLineUuid(String lineUuid) {
        this.lineUuid = lineUuid;
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
     * 获取所属单位
     *
     * @return company - 所属单位
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置所属单位
     *
     * @param company 所属单位
     */
    public void setCompany(String company) {
        this.company = company;
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
     * 获取线路长度
     *
     * @return length - 线路长度
     */
    public Float getLength() {
        return length;
    }

    /**
     * 设置线路长度
     *
     * @param length 线路长度
     */
    public void setLength(Float length) {
        this.length = length;
    }
}