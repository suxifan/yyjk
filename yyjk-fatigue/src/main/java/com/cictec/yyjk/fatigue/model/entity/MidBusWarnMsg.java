package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mid_bus_warn_msg")
public class MidBusWarnMsg {

	@Id
	@Column(name = "warn_id")
	private String warnId;

    /**
	 * 报警SID
	 */
    @Column(name = "warn_sid")
    private String warnSid;

    /**
	 * 报警类型
	 */
    @Column(name = "warn_code")
    private String warnCode;

	/**
	 * 报警类型名称
	 */
	@Column(name = "warn_name")
	private String warnName;

    /**
	 * 线路SID
	 */
    @Column(name = "warn_line_group_sid")
    private String warnLineGroupSid;

    /**
	 * 线路名称
	 */
    @Column(name = "warn_line_group_name")
    private String warnLineGroupName;

    /**
	 * 线路编号
	 */
    @Column(name = "warn_line_group_no")
    private String warnLineGroupNo;

    /**
	 * 线路轨迹SID
	 */
    @Column(name = "warn_line_sid")
    private String warnLineSid;

    /**
	 * 线路轨迹名称
	 */
    @Column(name = "warn_line_name")
    private String warnLineName;

    /**
	 * 线路轨迹编号
	 */
    @Column(name = "warn_line_no")
    private String warnLineNo;

    /**
	 * 车辆SID
	 */
    @Column(name = "warn_bus_sid")
    private String warnBusSid;

    /**
	 * 车牌号
	 */
    @Column(name = "warn_bus_number")
    private String warnBusNumber;

    /**
	 * 车辆自编号
	 */
    @Column(name = "warn_bus_selfcode")
    private String warnBusSelfcode;

    /**
	 * 司机SID
	 */
    @Column(name = "warn_driver_sid")
    private String warnDriverSid;

    /**
	 * 司机名称
	 */
    @Column(name = "warn_driver_name")
    private String warnDriverName;

    /**
	 * 存储时间
	 */
    @Column(name = "warn_storage_time")
    private Date warnStorageTime;

    /**
	 * 报警开始时间
	 */
    @Column(name = "warn_start_time")
    private Date warnStartTime;

    /**
	 * 报警结束时间
	 */
    @Column(name = "warn_end_time")
    private Date warnEndTime;

    /**
	 * 报警开始坐标 经度
	 */
    @Column(name = "warn_start_lng")
    private String warnStartLng;

    /**
	 * 报警开始坐标 纬度
	 */
    @Column(name = "warn_start_lat")
    private String warnStartLat;

    /**
	 * 报警结束坐标 经度
	 */
    @Column(name = "warn_end_lng")
    private String warnEndLng;

    /**
	 * 报警结束坐标 纬度
	 */
    @Column(name = "warn_end_lat")
    private String warnEndLat;

    /**
	 * 报警里程(单位：米)
	 */
    @Column(name = "warn_mileage")
    private String warnMileage;

    /**
	 * 站点SID
	 */
    @Column(name = "warn_station_sid")
    private String warnStationSid;

    /**
	 * 站序
	 */
    @Column(name = "warn_station_seq")
    private Integer warnStationSeq;

    /**
	 * 方向（1：上行、2：下行）
	 */
    @Column(name = "warn_line_type")
    private String warnLineType;

    /**
	 * bus_schedule_run表SID,需要管理趟次信息时候使用
	 */
    @Column(name = "brs_sid")
    private String brsSid;

    /**
	 * 是否删除标识
	 */
    @Column(name = "warn_available")
    private Boolean warnAvailable;

    /**
	 * 报警关闭标识（0-未关闭，1-关闭）
	 */
    @Column(name = "warn_closed_flag")
    private String warnClosedFlag;

    /**
	 * 关闭报警调度员ID
	 */
    @Column(name = "warn_closed_by")
    private String warnClosedBy;

    /**
	 * 报警关闭时间
	 */
    @Column(name = "warn_closed_time")
    private Date warnClosedTime;

    /**
	 * 报警关闭说明
	 */
    @Column(name = "warn_closed_note")
    private String warnClosedNote;

    /**
	 * 超速GPS坐标 lng1,lat1;lng2,lat
	 */
    @Column(name = "warn_gps")
    private String warnGps;

    /**
	 * 报警时长
	 */
    @Column(name = "warn_duration")
    private Integer warnDuration;

    /**
	 * 速度
	 */
    @Column(name = "warn_speed")
    private Integer warnSpeed;

    /**
	 * 获取报警SID
	 *
	 * @return warn_sid - 报警SID
	 */
    public String getWarnSid() {
        return warnSid;
    }

    /**
	 * 设置报警SID
	 *
	 * @param warnSid
	 *            报警SID
	 */
    public void setWarnSid(String warnSid) {
        this.warnSid = warnSid;
    }

    /**
	 * 获取报警类型
	 *
	 * @return warn_code - 报警类型
	 */
    public String getWarnCode() {
        return warnCode;
    }

    /**
	 * 设置报警类型
	 *
	 * @param warnCode
	 *            报警类型
	 */
    public void setWarnCode(String warnCode) {
        this.warnCode = warnCode;
    }

    /**
	 * 获取线路SID
	 *
	 * @return warn_line_group_sid - 线路SID
	 */
    public String getWarnLineGroupSid() {
        return warnLineGroupSid;
    }

    /**
	 * 设置线路SID
	 *
	 * @param warnLineGroupSid
	 *            线路SID
	 */
    public void setWarnLineGroupSid(String warnLineGroupSid) {
        this.warnLineGroupSid = warnLineGroupSid;
    }

    /**
	 * 获取线路名称
	 *
	 * @return warn_line_group_name - 线路名称
	 */
    public String getWarnLineGroupName() {
        return warnLineGroupName;
    }

    /**
	 * 设置线路名称
	 *
	 * @param warnLineGroupName
	 *            线路名称
	 */
    public void setWarnLineGroupName(String warnLineGroupName) {
        this.warnLineGroupName = warnLineGroupName;
    }

    /**
	 * 获取线路编号
	 *
	 * @return warn_line_group_no - 线路编号
	 */
    public String getWarnLineGroupNo() {
        return warnLineGroupNo;
    }

    /**
	 * 设置线路编号
	 *
	 * @param warnLineGroupNo
	 *            线路编号
	 */
    public void setWarnLineGroupNo(String warnLineGroupNo) {
        this.warnLineGroupNo = warnLineGroupNo;
    }

    /**
	 * 获取线路轨迹SID
	 *
	 * @return warn_line_sid - 线路轨迹SID
	 */
    public String getWarnLineSid() {
        return warnLineSid;
    }

    /**
	 * 设置线路轨迹SID
	 *
	 * @param warnLineSid
	 *            线路轨迹SID
	 */
    public void setWarnLineSid(String warnLineSid) {
        this.warnLineSid = warnLineSid;
    }

    /**
	 * 获取线路轨迹名称
	 *
	 * @return warn_line_name - 线路轨迹名称
	 */
    public String getWarnLineName() {
        return warnLineName;
    }

    /**
	 * 设置线路轨迹名称
	 *
	 * @param warnLineName
	 *            线路轨迹名称
	 */
    public void setWarnLineName(String warnLineName) {
        this.warnLineName = warnLineName;
    }

    /**
	 * 获取线路轨迹编号
	 *
	 * @return warn_line_no - 线路轨迹编号
	 */
    public String getWarnLineNo() {
        return warnLineNo;
    }

    /**
	 * 设置线路轨迹编号
	 *
	 * @param warnLineNo
	 *            线路轨迹编号
	 */
    public void setWarnLineNo(String warnLineNo) {
        this.warnLineNo = warnLineNo;
    }

    /**
	 * 获取车辆SID
	 *
	 * @return warn_bus_sid - 车辆SID
	 */
    public String getWarnBusSid() {
        return warnBusSid;
    }

    /**
	 * 设置车辆SID
	 *
	 * @param warnBusSid
	 *            车辆SID
	 */
    public void setWarnBusSid(String warnBusSid) {
        this.warnBusSid = warnBusSid;
    }

    /**
	 * 获取车牌号
	 *
	 * @return warn_bus_number - 车牌号
	 */
    public String getWarnBusNumber() {
        return warnBusNumber;
    }

    /**
	 * 设置车牌号
	 *
	 * @param warnBusNumber
	 *            车牌号
	 */
    public void setWarnBusNumber(String warnBusNumber) {
        this.warnBusNumber = warnBusNumber;
    }

    /**
	 * 获取车辆自编号
	 *
	 * @return warn_bus_selfcode - 车辆自编号
	 */
    public String getWarnBusSelfcode() {
        return warnBusSelfcode;
    }

    /**
	 * 设置车辆自编号
	 *
	 * @param warnBusSelfcode
	 *            车辆自编号
	 */
    public void setWarnBusSelfcode(String warnBusSelfcode) {
        this.warnBusSelfcode = warnBusSelfcode;
    }

    /**
	 * 获取司机SID
	 *
	 * @return warn_driver_sid - 司机SID
	 */
    public String getWarnDriverSid() {
        return warnDriverSid;
    }

    /**
	 * 设置司机SID
	 *
	 * @param warnDriverSid
	 *            司机SID
	 */
    public void setWarnDriverSid(String warnDriverSid) {
        this.warnDriverSid = warnDriverSid;
    }

    /**
	 * 获取司机名称
	 *
	 * @return warn_driver_name - 司机名称
	 */
    public String getWarnDriverName() {
        return warnDriverName;
    }

    /**
	 * 设置司机名称
	 *
	 * @param warnDriverName
	 *            司机名称
	 */
    public void setWarnDriverName(String warnDriverName) {
        this.warnDriverName = warnDriverName;
    }

    /**
	 * 获取存储时间
	 *
	 * @return warn_storage_time - 存储时间
	 */
    public Date getWarnStorageTime() {
        return warnStorageTime;
    }

    /**
	 * 设置存储时间
	 *
	 * @param warnStorageTime
	 *            存储时间
	 */
    public void setWarnStorageTime(Date warnStorageTime) {
        this.warnStorageTime = warnStorageTime;
    }

    /**
	 * 获取报警开始时间
	 *
	 * @return warn_start_time - 报警开始时间
	 */
    public Date getWarnStartTime() {
        return warnStartTime;
    }

    /**
	 * 设置报警开始时间
	 *
	 * @param warnStartTime
	 *            报警开始时间
	 */
    public void setWarnStartTime(Date warnStartTime) {
        this.warnStartTime = warnStartTime;
    }

    /**
	 * 获取报警结束时间
	 *
	 * @return warn_end_time - 报警结束时间
	 */
    public Date getWarnEndTime() {
        return warnEndTime;
    }

    /**
	 * 设置报警结束时间
	 *
	 * @param warnEndTime
	 *            报警结束时间
	 */
    public void setWarnEndTime(Date warnEndTime) {
        this.warnEndTime = warnEndTime;
    }

    /**
	 * 获取报警开始坐标 经度
	 *
	 * @return warn_start_lng - 报警开始坐标 经度
	 */
    public String getWarnStartLng() {
        return warnStartLng;
    }

    /**
	 * 设置报警开始坐标 经度
	 *
	 * @param warnStartLng
	 *            报警开始坐标 经度
	 */
    public void setWarnStartLng(String warnStartLng) {
        this.warnStartLng = warnStartLng;
    }

    /**
	 * 获取报警开始坐标 纬度
	 *
	 * @return warn_start_lat - 报警开始坐标 纬度
	 */
    public String getWarnStartLat() {
        return warnStartLat;
    }

    /**
	 * 设置报警开始坐标 纬度
	 *
	 * @param warnStartLat
	 *            报警开始坐标 纬度
	 */
    public void setWarnStartLat(String warnStartLat) {
        this.warnStartLat = warnStartLat;
    }

    /**
	 * 获取报警结束坐标 经度
	 *
	 * @return warn_end_lng - 报警结束坐标 经度
	 */
    public String getWarnEndLng() {
        return warnEndLng;
    }

    /**
	 * 设置报警结束坐标 经度
	 *
	 * @param warnEndLng
	 *            报警结束坐标 经度
	 */
    public void setWarnEndLng(String warnEndLng) {
        this.warnEndLng = warnEndLng;
    }

    /**
	 * 获取报警结束坐标 纬度
	 *
	 * @return warn_end_lat - 报警结束坐标 纬度
	 */
    public String getWarnEndLat() {
        return warnEndLat;
    }

    /**
	 * 设置报警结束坐标 纬度
	 *
	 * @param warnEndLat
	 *            报警结束坐标 纬度
	 */
    public void setWarnEndLat(String warnEndLat) {
        this.warnEndLat = warnEndLat;
    }

    /**
	 * 获取报警里程(单位：米)
	 *
	 * @return warn_mileage - 报警里程(单位：米)
	 */
    public String getWarnMileage() {
        return warnMileage;
    }

    /**
	 * 设置报警里程(单位：米)
	 *
	 * @param warnMileage
	 *            报警里程(单位：米)
	 */
    public void setWarnMileage(String warnMileage) {
        this.warnMileage = warnMileage;
    }

    /**
	 * 获取站点SID
	 *
	 * @return warn_station_sid - 站点SID
	 */
    public String getWarnStationSid() {
        return warnStationSid;
    }

    /**
	 * 设置站点SID
	 *
	 * @param warnStationSid
	 *            站点SID
	 */
    public void setWarnStationSid(String warnStationSid) {
        this.warnStationSid = warnStationSid;
    }

    /**
	 * 获取站序
	 *
	 * @return warn_station_seq - 站序
	 */
    public Integer getWarnStationSeq() {
        return warnStationSeq;
    }

    /**
	 * 设置站序
	 *
	 * @param warnStationSeq
	 *            站序
	 */
    public void setWarnStationSeq(Integer warnStationSeq) {
        this.warnStationSeq = warnStationSeq;
    }

    /**
	 * 获取方向（1：上行、2：下行）
	 *
	 * @return warn_line_type - 方向（1：上行、2：下行）
	 */
    public String getWarnLineType() {
        return warnLineType;
    }

    /**
	 * 设置方向（1：上行、2：下行）
	 *
	 * @param warnLineType
	 *            方向（1：上行、2：下行）
	 */
    public void setWarnLineType(String warnLineType) {
        this.warnLineType = warnLineType;
    }

    /**
	 * 获取bus_schedule_run表SID,需要管理趟次信息时候使用
	 *
	 * @return brs_sid - bus_schedule_run表SID,需要管理趟次信息时候使用
	 */
    public String getBrsSid() {
        return brsSid;
    }

    /**
	 * 设置bus_schedule_run表SID,需要管理趟次信息时候使用
	 *
	 * @param brsSid
	 *            bus_schedule_run表SID,需要管理趟次信息时候使用
	 */
    public void setBrsSid(String brsSid) {
        this.brsSid = brsSid;
    }

    /**
	 * 获取是否删除标识
	 *
	 * @return warn_available - 是否删除标识
	 */
    public Boolean getWarnAvailable() {
        return warnAvailable;
    }

    /**
	 * 设置是否删除标识
	 *
	 * @param warnAvailable
	 *            是否删除标识
	 */
    public void setWarnAvailable(Boolean warnAvailable) {
        this.warnAvailable = warnAvailable;
    }

    /**
     * @return warn_id
     */
    public String getWarnId() {
        return warnId;
    }

    /**
     * @param warnId
     */
    public void setWarnId(String warnId) {
        this.warnId = warnId;
    }

    /**
	 * 获取报警关闭标识（0-未关闭，1-关闭）
	 *
	 * @return warn_closed_flag - 报警关闭标识（0-未关闭，1-关闭）
	 */
    public String getWarnClosedFlag() {
        return warnClosedFlag;
    }

    /**
	 * 设置报警关闭标识（0-未关闭，1-关闭）
	 *
	 * @param warnClosedFlag
	 *            报警关闭标识（0-未关闭，1-关闭）
	 */
    public void setWarnClosedFlag(String warnClosedFlag) {
        this.warnClosedFlag = warnClosedFlag;
    }

    /**
	 * 获取关闭报警调度员ID
	 *
	 * @return warn_closed_by - 关闭报警调度员ID
	 */
    public String getWarnClosedBy() {
        return warnClosedBy;
    }

    /**
	 * 设置关闭报警调度员ID
	 *
	 * @param warnClosedBy
	 *            关闭报警调度员ID
	 */
    public void setWarnClosedBy(String warnClosedBy) {
        this.warnClosedBy = warnClosedBy;
    }

    /**
	 * 获取报警关闭时间
	 *
	 * @return warn_closed_time - 报警关闭时间
	 */
    public Date getWarnClosedTime() {
        return warnClosedTime;
    }

    /**
	 * 设置报警关闭时间
	 *
	 * @param warnClosedTime
	 *            报警关闭时间
	 */
    public void setWarnClosedTime(Date warnClosedTime) {
        this.warnClosedTime = warnClosedTime;
    }

    /**
	 * 获取报警关闭说明
	 *
	 * @return warn_closed_note - 报警关闭说明
	 */
    public String getWarnClosedNote() {
        return warnClosedNote;
    }

    /**
	 * 设置报警关闭说明
	 *
	 * @param warnClosedNote
	 *            报警关闭说明
	 */
    public void setWarnClosedNote(String warnClosedNote) {
        this.warnClosedNote = warnClosedNote;
    }

    /**
	 * 获取超速GPS坐标 lng1,lat1;lng2,lat
	 *
	 * @return warn_gps - 超速GPS坐标 lng1,lat1;lng2,lat
	 */
    public String getWarnGps() {
        return warnGps;
    }

    /**
	 * 设置超速GPS坐标 lng1,lat1;lng2,lat
	 *
	 * @param warnGps
	 *            超速GPS坐标 lng1,lat1;lng2,lat
	 */
    public void setWarnGps(String warnGps) {
        this.warnGps = warnGps;
    }

    /**
	 * 获取报警时长
	 *
	 * @return warn_duration - 报警时长
	 */
    public Integer getWarnDuration() {
        return warnDuration;
    }

    /**
	 * 设置报警时长
	 *
	 * @param warnDuration
	 *            报警时长
	 */
    public void setWarnDuration(Integer warnDuration) {
        this.warnDuration = warnDuration;
    }

    /**
	 * 获取速度
	 *
	 * @return warn_speed - 速度
	 */
    public Integer getWarnSpeed() {
        return warnSpeed;
    }

    /**
	 * 设置速度
	 *
	 * @param warnSpeed
	 *            速度
	 */
    public void setWarnSpeed(Integer warnSpeed) {
        this.warnSpeed = warnSpeed;
    }

	public String getWarnName() {
		return warnName;
	}

	public void setWarnName(String warnName) {
		this.warnName = warnName;
	}

}