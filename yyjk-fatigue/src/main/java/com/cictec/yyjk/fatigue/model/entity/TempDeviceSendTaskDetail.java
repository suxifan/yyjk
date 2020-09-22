package com.cictec.yyjk.fatigue.model.entity;

import javax.persistence.*;

import com.cictec.yyjk.commons.core.AbstractVo;

@Table(name = "temp_device_send_task_detail")
public class TempDeviceSendTaskDetail extends AbstractVo{
    @Id
    @Column(name = "task_detail_uuid")
    private String taskDetailUuid;

    /**
     * 下发任务表主键
     */
    @Column(name = "task_uuid")
    private String taskUuid;

    /**
     * 设备id
     */
    @Column(name = "dev_uuid")
    private String devUuid;

    /**
     * 任务状态 1：成功  0：失败
     */
    @Column(name = "task_status")
    private String taskStatus;

    /**
     * 设备号
     */
    @Column(name = "dev_code")
    private String devCode;
    
    @Transient
	private String orgName;// 机构名称
    
    @Transient
	private String lineName;// 线路
    
    @Transient
	private String busPlateNumber;// 车牌号
    
    @Transient
	private String busSelfCode;// 车辆自编号

    @Transient
	private String devOnlineStatus;//在线状态 0 离线 1 在线
    /**
     * @return task_detail_uuid
     */
    public String getTaskDetailUuid() {
        return taskDetailUuid;
    }

    /**
     * @param taskDetailUuid
     */
    public void setTaskDetailUuid(String taskDetailUuid) {
        this.taskDetailUuid = taskDetailUuid;
    }

    /**
     * 获取下发任务表主键
     *
     * @return task_uuid - 下发任务表主键
     */
    public String getTaskUuid() {
        return taskUuid;
    }

    /**
     * 设置下发任务表主键
     *
     * @param taskUuid 下发任务表主键
     */
    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }

    /**
     * 获取设备id
     *
     * @return dev_uuid - 设备id
     */
    public String getDevUuid() {
        return devUuid;
    }

    /**
     * 设置设备id
     *
     * @param devUuid 设备id
     */
    public void setDevUuid(String devUuid) {
        this.devUuid = devUuid;
    }

    /**
     * 获取任务状态 1：成功  0：失败
     *
     * @return task_status - 任务状态 1：成功  0：失败
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置任务状态 1：成功  0：失败
     *
     * @param taskStatus 任务状态 1：成功  0：失败
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取设备号
     *
     * @return dev_code - 设备号
     */
    public String getDevCode() {
        return devCode;
    }

    /**
     * 设置设备号
     *
     * @param devCode 设备号
     */
    public void setDevCode(String devCode) {
        this.devCode = devCode;
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

	public String getDevOnlineStatus() {
		return devOnlineStatus;
	}

	public void setDevOnlineStatus(String devOnlineStatus) {
		this.devOnlineStatus = devOnlineStatus;
	}
    
}