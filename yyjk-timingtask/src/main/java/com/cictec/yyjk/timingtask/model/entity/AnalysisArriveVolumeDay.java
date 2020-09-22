package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "analysis_arrive_volume_day")
public class AnalysisArriveVolumeDay {
    /**
     * 主键id
     */
    @Id
    @Column(name = "arrive_uuid")
    private String arriveUuid;

    /**
     * 机构id
     */
    @Column(name = "org_uuid")
    private String orgUuid;

    /**
     * 机构名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 线路id
     */
    @Column(name = "line_uuid")
    private String lineUuid;

    /**
     * 线路名称
     */
    @Column(name = "line_name")
    private String lineName;

    /**
     * 线路类型
     */
    @Column(name = "line_type")
    private String lineType;

    /**
     * 站id
     */
    @Column(name = "sta_uuid")
    private String staUuid;

    /**
     * 站序
     */
    @Column(name = "sta_seq")
    private String staSeq;

    /**
     * 站名
     */
    @Column(name = "sta_name")
    private String staName;

    /**
     * 车牌号
     */
    @Column(name = "bus_plate_number")
    private String busPlateNumber;

    /**
     * 日期
     */
    @Column(name = "upload_time_date")
    private String uploadTimeDate;

    /**
     * 进站时间
     */
    @Column(name = "upload_time_in")
    private Date uploadTimeIn;

    /**
     * 出站时间
     */
    @Column(name = "upload_time_out")
    private Date uploadTimeOut;

    /**
     * 小时
     */
    @Column(name = "upload_time_hour")
    private Short uploadTimeHour;

    /**
     * 班次
     */
    @Column(name = "bus_class")
    private Short busClass;

    /**
     * 获取主键id
     *
     * @return arrive_uuid - 主键id
     */
    public String getArriveUuid() {
        return arriveUuid;
    }

    /**
     * 设置主键id
     *
     * @param arriveUuid 主键id
     */
    public void setArriveUuid(String arriveUuid) {
        this.arriveUuid = arriveUuid;
    }

    /**
     * 获取机构id
     *
     * @return org_uuid - 机构id
     */
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
     * 设置机构id
     *
     * @param orgUuid 机构id
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
     * 获取线路id
     *
     * @return line_uuid - 线路id
     */
    public String getLineUuid() {
        return lineUuid;
    }

    /**
     * 设置线路id
     *
     * @param lineUuid 线路id
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
     * 获取线路类型
     *
     * @return line_type - 线路类型
     */
    public String getLineType() {
        return lineType;
    }

    /**
     * 设置线路类型
     *
     * @param lineType 线路类型
     */
    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    /**
     * 获取站id
     *
     * @return sta_uuid - 站id
     */
    public String getStaUuid() {
        return staUuid;
    }

    /**
     * 设置站id
     *
     * @param staUuid 站id
     */
    public void setStaUuid(String staUuid) {
        this.staUuid = staUuid;
    }

    /**
     * 获取站序
     *
     * @return sta_seq - 站序
     */
    public String getStaSeq() {
        return staSeq;
    }

    /**
     * 设置站序
     *
     * @param staSeq 站序
     */
    public void setStaSeq(String staSeq) {
        this.staSeq = staSeq;
    }

    /**
     * 获取站名
     *
     * @return sta_name - 站名
     */
    public String getStaName() {
        return staName;
    }

    /**
     * 设置站名
     *
     * @param staName 站名
     */
    public void setStaName(String staName) {
        this.staName = staName;
    }

    /**
     * 获取车牌号
     *
     * @return bus_plate_number - 车牌号
     */
    public String getBusPlateNumber() {
        return busPlateNumber;
    }

    /**
     * 设置车牌号
     *
     * @param busPlateNumber 车牌号
     */
    public void setBusPlateNumber(String busPlateNumber) {
        this.busPlateNumber = busPlateNumber;
    }

    /**
     * 获取日期
     *
     * @return upload_time_date - 日期
     */
    public String getUploadTimeDate() {
        return uploadTimeDate;
    }

    /**
     * 设置日期
     *
     * @param uploadTimeDate 日期
     */
    public void setUploadTimeDate(String uploadTimeDate) {
        this.uploadTimeDate = uploadTimeDate;
    }

    /**
     * 获取进站时间
     *
     * @return upload_time_in - 进站时间
     */
    public Date getUploadTimeIn() {
        return uploadTimeIn;
    }

    /**
     * 设置进站时间
     *
     * @param uploadTimeIn 进站时间
     */
    public void setUploadTimeIn(Date uploadTimeIn) {
        this.uploadTimeIn = uploadTimeIn;
    }

    /**
     * 获取出站时间
     *
     * @return upload_time_out - 出站时间
     */
    public Date getUploadTimeOut() {
        return uploadTimeOut;
    }

    /**
     * 设置出站时间
     *
     * @param uploadTimeOut 出站时间
     */
    public void setUploadTimeOut(Date uploadTimeOut) {
        this.uploadTimeOut = uploadTimeOut;
    }

    /**
     * 获取小时
     *
     * @return upload_time_hour - 小时
     */
    public Short getUploadTimeHour() {
        return uploadTimeHour;
    }

    /**
     * 设置小时
     *
     * @param uploadTimeHour 小时
     */
    public void setUploadTimeHour(Short uploadTimeHour) {
        this.uploadTimeHour = uploadTimeHour;
    }

    /**
     * 获取班次
     *
     * @return bus_class - 班次
     */
    public Short getBusClass() {
        return busClass;
    }

    /**
     * 设置班次
     *
     * @param busClass 班次
     */
    public void setBusClass(Short busClass) {
        this.busClass = busClass;
    }
}