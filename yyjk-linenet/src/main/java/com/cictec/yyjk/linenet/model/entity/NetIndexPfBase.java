package com.cictec.yyjk.linenet.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "net_index_pf_base")
public class NetIndexPfBase {
    @Id
    private Integer uuid;

    /**
     * 线路号
     */
    @Column(name = "line_number")
    private String lineNumber;

    /**
     * 车牌号
     */
    @Column(name = "plate_number")
    private String plateNumber;

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
     * 通过率
     */
    @Column(name = "pass_count")
    private Integer passCount;

    /**
     * 到站时间
     */
    @Column(name = "pass_time")
    private Date passTime;

    /**
     * 刷卡日期
     */
    @Column(name = "p_date")
    private String pDate;

    /**
     * 刷卡时间段
     */
    @Column(name = "p_time")
    private String pTime;

    /**
     * 负载人数
     */
    @Column(name = "full_load_num")
    private String fullLoadNum;

    /**
     * 距下一站距离
     */
    @Column(name = "to_next_dic")
    private Float toNextDic;

    /**
     * 所属单位
     */
    private String company;

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
     * 获取车牌号
     *
     * @return plate_number - 车牌号
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * 设置车牌号
     *
     * @param plateNumber 车牌号
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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
     * 获取通过率
     *
     * @return pass_count - 通过率
     */
    public Integer getPassCount() {
        return passCount;
    }

    /**
     * 设置通过率
     *
     * @param passCount 通过率
     */
    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    /**
     * 获取到站时间
     *
     * @return pass_time - 到站时间
     */
    public Date getPassTime() {
        return passTime;
    }

    /**
     * 设置到站时间
     *
     * @param passTime 到站时间
     */
    public void setPassTime(Date passTime) {
        this.passTime = passTime;
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

    /**
     * 获取刷卡时间段
     *
     * @return p_time - 刷卡时间段
     */
    public String getpTime() {
        return pTime;
    }

    /**
     * 设置刷卡时间段
     *
     * @param pTime 刷卡时间段
     */
    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    /**
     * 获取负载人数
     *
     * @return full_load_num - 负载人数
     */
    public String getFullLoadNum() {
        return fullLoadNum;
    }

    /**
     * 设置负载人数
     *
     * @param fullLoadNum 负载人数
     */
    public void setFullLoadNum(String fullLoadNum) {
        this.fullLoadNum = fullLoadNum;
    }

    /**
     * 获取距下一站距离
     *
     * @return to_next_dic - 距下一站距离
     */
    public Float getToNextDic() {
        return toNextDic;
    }

    /**
     * 设置距下一站距离
     *
     * @param toNextDic 距下一站距离
     */
    public void setToNextDic(Float toNextDic) {
        this.toNextDic = toNextDic;
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
}