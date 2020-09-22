package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "temp_bus_schedule")
public class TempBusSchedule {
    /**
	 * 排班表主键
	 */
    @Id
    @Column(name = "bs_uuid")
    private String bsUuid;

    /**
	 * 机构id
	 */
    @Column(name = "bs_org_uuid")
    private String bsOrgUuid;

    /**
	 * 线路id
	 */
    @Column(name = "bs_line_uuid")
    private String bsLineUuid;

    /**
	 * 日期
	 */
    @Column(name = "bs_schedule_time")
    private Date bsScheduleTime;

	public TempBusSchedule() {
		super();
	}

	public TempBusSchedule(String bsUuid, String bsOrgUuid, String bsLineUuid, Date bsScheduleTime) {
		super();
		this.bsUuid = bsUuid;
		this.bsOrgUuid = bsOrgUuid;
		this.bsLineUuid = bsLineUuid;
		this.bsScheduleTime = bsScheduleTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bsLineUuid == null) ? 0 : bsLineUuid.hashCode());
		result = prime * result + ((bsOrgUuid == null) ? 0 : bsOrgUuid.hashCode());
		result = prime * result + ((bsScheduleTime == null) ? 0 : bsScheduleTime.hashCode());
		result = prime * result + ((bsUuid == null) ? 0 : bsUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempBusSchedule other = (TempBusSchedule) obj;
		if (bsLineUuid == null) {
			if (other.bsLineUuid != null)
				return false;
		} else if (!bsLineUuid.equals(other.bsLineUuid))
			return false;
		if (bsOrgUuid == null) {
			if (other.bsOrgUuid != null)
				return false;
		} else if (!bsOrgUuid.equals(other.bsOrgUuid))
			return false;
		if (bsScheduleTime == null) {
			if (other.bsScheduleTime != null)
				return false;
		} else if (!bsScheduleTime.equals(other.bsScheduleTime))
			return false;
		if (bsUuid == null) {
			if (other.bsUuid != null)
				return false;
		} else if (!bsUuid.equals(other.bsUuid))
			return false;
		return true;
	}

	/**
	 * 获取排班表主键
	 *
	 * @return bs_uuid - 排班表主键
	 */
    public String getBsUuid() {
        return bsUuid;
    }

    /**
	 * 设置排班表主键
	 *
	 * @param bsUuid
	 *            排班表主键
	 */
    public void setBsUuid(String bsUuid) {
        this.bsUuid = bsUuid;
    }

    /**
	 * 获取机构id
	 *
	 * @return bs_org_uuid - 机构id
	 */
    public String getBsOrgUuid() {
        return bsOrgUuid;
    }

    /**
	 * 设置机构id
	 *
	 * @param bsOrgUuid
	 *            机构id
	 */
    public void setBsOrgUuid(String bsOrgUuid) {
        this.bsOrgUuid = bsOrgUuid;
    }

    /**
	 * 获取线路id
	 *
	 * @return bs_line_uuid - 线路id
	 */
    public String getBsLineUuid() {
        return bsLineUuid;
    }

    /**
	 * 设置线路id
	 *
	 * @param bsLineUuid
	 *            线路id
	 */
    public void setBsLineUuid(String bsLineUuid) {
        this.bsLineUuid = bsLineUuid;
    }

    /**
	 * 获取日期
	 *
	 * @return bs_schedule_time - 日期
	 */
    public Date getBsScheduleTime() {
        return bsScheduleTime;
    }

    /**
	 * 设置日期
	 *
	 * @param bsScheduleTime
	 *            日期
	 */
    public void setBsScheduleTime(Date bsScheduleTime) {
        this.bsScheduleTime = bsScheduleTime;
    }

}