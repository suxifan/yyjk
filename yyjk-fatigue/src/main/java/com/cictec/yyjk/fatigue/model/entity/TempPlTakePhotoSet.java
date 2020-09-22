package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Table(name = "temp_pl_take_photo_set")
public class TempPlTakePhotoSet {
    /**
     * 主键uuid
     */
	@Id
    @Column(name = "take_photo_uuid")
    private String takePhotoUuid;

    /**
     * 设备id
     */
    @Column(name = "device_id")
    private String deviceId;

    /**
     * 设备号
     */
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 开始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 结束日期
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 采集间隔
     */
    private String duration;

    /**
     * 采集类型 （1每天 ,2每周,3每月）
     */
    @Column(name = "timing_class")
    private String timingClass;

    /**
     * 采集内容
     */
    @Column(name = "timing_remark")
    private String timingRemark;

    /**
     * cron表达式
     */
    private String cron;

    /**
     * 启用标记1：启用0：禁用
     */
    private String isvalid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    
	@Transient
	private String orgName;// 机构名称

	@Transient
	private String lineName;// 线路

	@Transient
	private String busPlateNumber;// 车牌号

/*	@Transient
	private String busUuid;// 车辆uuid
*/
	@Transient
	private String busSelfCode;// 车辆自编号
	
    @Transient
	private List<TDevice> devList; //设备集合

    /**
     * 获取主键uuid
     *
     * @return take_photo_uuid - 主键uuid
     */
    public String getTakePhotoUuid() {
        return takePhotoUuid;
    }

    /**
     * 设置主键uuid
     *
     * @param takePhotoUuid 主键uuid
     */
    public void setTakePhotoUuid(String takePhotoUuid) {
        this.takePhotoUuid = takePhotoUuid;
    }

    /**
     * 获取设备id
     *
     * @return device_id - 设备id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备id
     *
     * @param deviceId 设备id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取设备号
     *
     * @return device_code - 设备号
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 设置设备号
     *
     * @param deviceCode 设备号
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    /**
     * 获取开始日期
     *
     * @return start_date - 开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置开始日期
     *
     * @param startDate 开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束日期
     *
     * @return end_date - 结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束日期
     *
     * @param endDate 结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取采集间隔
     *
     * @return duration - 采集间隔
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 设置采集间隔
     *
     * @param duration 采集间隔
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 获取采集类型 （1每天 ,2每周,3每月）
     *
     * @return timing_class - 采集类型 （1每天 ,2每周,3每月）
     */
    public String getTimingClass() {
        return timingClass;
    }

    /**
     * 设置采集类型 （1每天 ,2每周,3每月）
     *
     * @param timingClass 采集类型 （1每天 ,2每周,3每月）
     */
    public void setTimingClass(String timingClass) {
        this.timingClass = timingClass;
    }

    /**
     * 获取采集内容
     *
     * @return timing_remark - 采集内容
     */
    public String getTimingRemark() {
        return timingRemark;
    }

    /**
     * 设置采集内容
     *
     * @param timingRemark 采集内容
     */
    public void setTimingRemark(String timingRemark) {
        this.timingRemark = timingRemark;
    }

    /**
     * 获取cron表达式
     *
     * @return cron - cron表达式
     */
    public String getCron() {
        return cron;
    }

    /**
     * 设置cron表达式
     *
     * @param cron cron表达式
     */
    public void setCron(String cron) {
        this.cron = cron;
    }

    /**
     * 获取启用标记1：启用0：禁用
     *
     * @return isvalid - 启用标记1：启用0：禁用
     */
    public String getIsvalid() {
        return isvalid;
    }

    /**
     * 设置启用标记1：启用0：禁用
     *
     * @param isvalid 启用标记1：启用0：禁用
     */
    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public List<TDevice> getDevList() {
		return devList;
	}

	public void setDevList(List<TDevice> devList) {
		this.devList = devList;
	}
    
    
}