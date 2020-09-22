package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cictec.yyjk.commons.core.AbstractVo;

@Table(name = "temp_device_send_task")
public class TempDeviceSendTask extends AbstractVo{
    @Id
    @Column(name = "task_uuid")
    private String taskUuid;

    /**
     * 任务名称
     */
    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_create_time")
    private Date taskCreateTime;

    @Column(name = "task_create_user")
    private String taskCreateUser;

    /**
     * 下发设备数量
     */
    @Column(name = "task_issue_num")
    private Integer taskIssueNum;

    @Column(name = "remark")
    private String remark;

    @Transient
	private List<TDevice> devList; //设备集合
    
    @Transient
	private List<Object> jsonData; //参数配置json数据
    /**
     * @return task_uuid
     */
    public String getTaskUuid() {
        return taskUuid;
    }

    /**
     * @param taskUuid
     */
    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }

    /**
     * 获取任务名称
     *
     * @return task_name - 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置任务名称
     *
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return task_create_time
     */
    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    /**
     * @param taskCreateTime
     */
    public void setTaskCreateTime(Date taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    /**
     * @return task_create_user
     */
    public String getTaskCreateUser() {
        return taskCreateUser;
    }

    /**
     * @param taskCreateUser
     */
    public void setTaskCreateUser(String taskCreateUser) {
        this.taskCreateUser = taskCreateUser;
    }

    /**
     * 获取下发设备数量
     *
     * @return task_issue_num - 下发设备数量
     */
    public Integer getTaskIssueNum() {
        return taskIssueNum;
    }

    /**
     * 设置下发设备数量
     *
     * @param taskIssueNum 下发设备数量
     */
    public void setTaskIssueNum(Integer taskIssueNum) {
        this.taskIssueNum = taskIssueNum;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public List<TDevice> getDevList() {
		return devList;
	}

	public void setDevList(List<TDevice> devList) {
		this.devList = devList;
	}

	public List<Object> getJsonData() {
		return jsonData;
	}

	public void setJsonData(List<Object> jsonData) {
		this.jsonData = jsonData;
	}

	
    
    
}