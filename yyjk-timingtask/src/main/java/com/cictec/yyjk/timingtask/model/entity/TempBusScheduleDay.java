package com.cictec.yyjk.timingtask.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "temp_bus_schedule_day")
public class TempBusScheduleDay {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "bsd_uuid")
    private String bsdUuid;

    /**
	 * 外键uuid
	 */
    @Column(name = "bsd_bs_uuid")
    private String bsdBsUuid;

    /**
	 * 发车时间
	 */
    @Column(name = "bsd_departure_time")
    private String bsdDepartureTime;

    /**
	 * 班次
	 */
    @Column(name = "bsd_shift")
    private Integer bsdShift;

    /**
	 * 运行模式
	 */
    @Column(name = "bsd_type")
    private String bsdType;

    /**
	 * 趟次系数
	 */
    @Column(name = "bsd_trip_coefficient")
    private String bsdTripCoefficient;

	/**
	 * 线路趟次里程
	 */
	@Column(name = "bsd_plan_mileage")
	private String bsdPlanMileage;

	public TempBusScheduleDay() {
		super();
	}

	public TempBusScheduleDay(String bsdUuid, String bsdBsUuid, String bsdDepartureTime, Integer bsdShift,
			String bsdType, String bsdTripCoefficient, String bsdPlanMileage) {
		super();
		this.bsdUuid = bsdUuid;
		this.bsdBsUuid = bsdBsUuid;
		this.bsdDepartureTime = bsdDepartureTime;
		this.bsdShift = bsdShift;
		this.bsdType = bsdType;
		this.bsdTripCoefficient = bsdTripCoefficient;
		this.bsdPlanMileage = bsdPlanMileage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bsdBsUuid == null) ? 0 : bsdBsUuid.hashCode());
		result = prime * result + ((bsdDepartureTime == null) ? 0 : bsdDepartureTime.hashCode());
		result = prime * result + ((bsdPlanMileage == null) ? 0 : bsdPlanMileage.hashCode());
		result = prime * result + ((bsdShift == null) ? 0 : bsdShift.hashCode());
		result = prime * result + ((bsdTripCoefficient == null) ? 0 : bsdTripCoefficient.hashCode());
		result = prime * result + ((bsdType == null) ? 0 : bsdType.hashCode());
		result = prime * result + ((bsdUuid == null) ? 0 : bsdUuid.hashCode());
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
		TempBusScheduleDay other = (TempBusScheduleDay) obj;
		if (bsdBsUuid == null) {
			if (other.bsdBsUuid != null)
				return false;
		} else if (!bsdBsUuid.equals(other.bsdBsUuid))
			return false;
		if (bsdDepartureTime == null) {
			if (other.bsdDepartureTime != null)
				return false;
		} else if (!bsdDepartureTime.equals(other.bsdDepartureTime))
			return false;
		if (bsdPlanMileage == null) {
			if (other.bsdPlanMileage != null)
				return false;
		} else if (!bsdPlanMileage.equals(other.bsdPlanMileage))
			return false;
		if (bsdShift == null) {
			if (other.bsdShift != null)
				return false;
		} else if (!bsdShift.equals(other.bsdShift))
			return false;
		if (bsdTripCoefficient == null) {
			if (other.bsdTripCoefficient != null)
				return false;
		} else if (!bsdTripCoefficient.equals(other.bsdTripCoefficient))
			return false;
		if (bsdType == null) {
			if (other.bsdType != null)
				return false;
		} else if (!bsdType.equals(other.bsdType))
			return false;
		if (bsdUuid == null) {
			if (other.bsdUuid != null)
				return false;
		} else if (!bsdUuid.equals(other.bsdUuid))
			return false;
		return true;
	}

	/**
	 * 获取班次类型
	 *
	 * @return bsd_uuid - 班次类型
	 */
    public String getBsdUuid() {
        return bsdUuid;
    }

    /**
	 * 设置班次类型
	 *
	 * @param bsdUuid
	 *            班次类型
	 */
    public void setBsdUuid(String bsdUuid) {
        this.bsdUuid = bsdUuid;
    }

    /**
	 * 获取外键uuid
	 *
	 * @return bsd_bs_uuid - 外键uuid
	 */
    public String getBsdBsUuid() {
        return bsdBsUuid;
    }

    /**
	 * 设置外键uuid
	 *
	 * @param bsdBsUuid
	 *            外键uuid
	 */
    public void setBsdBsUuid(String bsdBsUuid) {
        this.bsdBsUuid = bsdBsUuid;
    }

    /**
	 * 获取发车时间
	 *
	 * @return bsd_departure_time - 发车时间
	 */
    public String getBsdDepartureTime() {
        return bsdDepartureTime;
    }

    /**
	 * 设置发车时间
	 *
	 * @param bsdDepartureTime
	 *            发车时间
	 */
    public void setBsdDepartureTime(String bsdDepartureTime) {
        this.bsdDepartureTime = bsdDepartureTime;
    }

    /**
	 * 获取班次
	 *
	 * @return bsd_shift - 班次
	 */
    public Integer getBsdShift() {
        return bsdShift;
    }

    /**
	 * 设置班次
	 *
	 * @param bsdShift
	 *            班次
	 */
    public void setBsdShift(Integer bsdShift) {
        this.bsdShift = bsdShift;
    }

    /**
	 * 获取运行模式
	 *
	 * @return bsd_type - 运行模式
	 */
    public String getBsdType() {
        return bsdType;
    }

    /**
	 * 设置运行模式
	 *
	 * @param bsdType
	 *            运行模式
	 */
    public void setBsdType(String bsdType) {
        this.bsdType = bsdType;
    }

    /**
	 * 获取趟次系数
	 *
	 * @return bsd_trip_coefficient - 趟次系数
	 */
    public String getBsdTripCoefficient() {
        return bsdTripCoefficient;
    }

    /**
	 * 设置趟次系数
	 *
	 * @param bsdTripCoefficient
	 *            趟次系数
	 */
    public void setBsdTripCoefficient(String bsdTripCoefficient) {
        this.bsdTripCoefficient = bsdTripCoefficient;
    }

	public String getBsdPlanMileage() {
		return bsdPlanMileage;
	}

	public void setBsdPlanMileage(String bsdPlanMileage) {
		this.bsdPlanMileage = bsdPlanMileage;
	}

}