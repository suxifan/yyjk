package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_bus")
public class DwDimBus {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "bus_uuid")
    private String busUuid;

    /**
	 * 设备编号
	 */
    @Column(name = "bus_dev_uuid")
    private String busDevUuid;

    /**
	 * 车牌号
	 */
    @Column(name = "bus_plate_number")
    private String busPlateNumber;

    /**
	 * 车辆自编号
	 */
    @Column(name = "bus_self_code")
    private String busSelfCode;

    /**
	 * 燃料类型
	 */
    @Column(name = "bus_fuel_type")
    private String busFuelType;

    /**
	 * 启用标记1：启用0：禁用
	 */
    @Column(name = "bus_isvalid")
    private String busIsvalid;

    /**
	 * 所属机构
	 */
    @Column(name = "bus_org_uuid")
    private String busOrgUuid;

    /**
	 * 所属线路
	 */
    @Column(name = "bus_line_uuid")
    private String busLineUuid;

    /**
	 * 荷载人数
	 */
    @Column(name = "bus_load_number")
    private Integer busLoadNumber;

    /**
	 * 创建时间
	 */
    @Column(name = "bus_create_time")
    private Date busCreateTime;

    /**
	 * 删除标示 0 正常 1 删除
	 */
    @Column(name = "bus_drop_flag")
    private String busDropFlag;


	public DwDimBus() {
		super();
	}

	public DwDimBus(String busUuid, String busDevUuid, String busPlateNumber, String busSelfCode, String busFuelType,
			String busIsvalid, String busOrgUuid, String busLineUuid, Integer busLoadNumber, Date busCreateTime,
			String busDropFlag) {
		super();
		this.busUuid = busUuid;
		this.busDevUuid = busDevUuid;
		this.busPlateNumber = busPlateNumber;
		this.busSelfCode = busSelfCode;
		this.busFuelType = busFuelType;
		this.busIsvalid = busIsvalid;
		this.busOrgUuid = busOrgUuid;
		this.busLineUuid = busLineUuid;
		this.busLoadNumber = busLoadNumber;
		this.busCreateTime = busCreateTime;
		this.busDropFlag = busDropFlag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busCreateTime == null) ? 0 : busCreateTime.hashCode());
		result = prime * result + ((busDevUuid == null) ? 0 : busDevUuid.hashCode());
		result = prime * result + ((busDropFlag == null) ? 0 : busDropFlag.hashCode());
		result = prime * result + ((busFuelType == null) ? 0 : busFuelType.hashCode());
		result = prime * result + ((busIsvalid == null) ? 0 : busIsvalid.hashCode());
		result = prime * result + ((busLineUuid == null) ? 0 : busLineUuid.hashCode());
		result = prime * result + ((busLoadNumber == null) ? 0 : busLoadNumber.hashCode());
		result = prime * result + ((busOrgUuid == null) ? 0 : busOrgUuid.hashCode());
		result = prime * result + ((busPlateNumber == null) ? 0 : busPlateNumber.hashCode());
		result = prime * result + ((busSelfCode == null) ? 0 : busSelfCode.hashCode());
		result = prime * result + ((busUuid == null) ? 0 : busUuid.hashCode());
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
		DwDimBus other = (DwDimBus) obj;
		if (busCreateTime == null) {
			if (other.busCreateTime != null)
				return false;
		} else if (!busCreateTime.equals(other.busCreateTime))
			return false;
		if (busDevUuid == null) {
			if (other.busDevUuid != null)
				return false;
		} else if (!busDevUuid.equals(other.busDevUuid))
			return false;
		if (busDropFlag == null) {
			if (other.busDropFlag != null)
				return false;
		} else if (!busDropFlag.equals(other.busDropFlag))
			return false;
		if (busFuelType == null) {
			if (other.busFuelType != null)
				return false;
		} else if (!busFuelType.equals(other.busFuelType))
			return false;
		if (busIsvalid == null) {
			if (other.busIsvalid != null)
				return false;
		} else if (!busIsvalid.equals(other.busIsvalid))
			return false;
		if (busLineUuid == null) {
			if (other.busLineUuid != null)
				return false;
		} else if (!busLineUuid.equals(other.busLineUuid))
			return false;
		if (busLoadNumber == null) {
			if (other.busLoadNumber != null)
				return false;
		} else if (!busLoadNumber.equals(other.busLoadNumber))
			return false;
		if (busOrgUuid == null) {
			if (other.busOrgUuid != null)
				return false;
		} else if (!busOrgUuid.equals(other.busOrgUuid))
			return false;
		if (busPlateNumber == null) {
			if (other.busPlateNumber != null)
				return false;
		} else if (!busPlateNumber.equals(other.busPlateNumber))
			return false;
		if (busSelfCode == null) {
			if (other.busSelfCode != null)
				return false;
		} else if (!busSelfCode.equals(other.busSelfCode))
			return false;
		if (busUuid == null) {
			if (other.busUuid != null)
				return false;
		} else if (!busUuid.equals(other.busUuid))
			return false;
		return true;
	}

	/**
	 * 获取主键
	 *
	 * @return bus_uuid - 主键
	 */
    public String getBusUuid() {
        return busUuid;
    }

    /**
	 * 设置主键
	 *
	 * @param busUuid
	 *            主键
	 */
    public void setBusUuid(String busUuid) {
        this.busUuid = busUuid;
    }

    /**
	 * 获取设备编号
	 *
	 * @return bus_dev_uuid - 设备编号
	 */
    public String getBusDevUuid() {
        return busDevUuid;
    }

    /**
	 * 设置设备编号
	 *
	 * @param busDevUuid
	 *            设备编号
	 */
    public void setBusDevUuid(String busDevUuid) {
        this.busDevUuid = busDevUuid;
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
	 * @param busPlateNumber
	 *            车牌号
	 */
    public void setBusPlateNumber(String busPlateNumber) {
        this.busPlateNumber = busPlateNumber;
    }

    /**
	 * 获取车辆自编号
	 *
	 * @return bus_self_code - 车辆自编号
	 */
    public String getBusSelfCode() {
        return busSelfCode;
    }

    /**
	 * 设置车辆自编号
	 *
	 * @param busSelfCode
	 *            车辆自编号
	 */
    public void setBusSelfCode(String busSelfCode) {
        this.busSelfCode = busSelfCode;
    }

    /**
	 * 获取燃料类型
	 *
	 * @return bus_fuel_type - 燃料类型
	 */
    public String getBusFuelType() {
        return busFuelType;
    }

    /**
	 * 设置燃料类型
	 *
	 * @param busFuelType
	 *            燃料类型
	 */
    public void setBusFuelType(String busFuelType) {
        this.busFuelType = busFuelType;
    }

    /**
	 * 获取启用标记1：启用0：禁用
	 *
	 * @return bus_isvalid - 启用标记1：启用0：禁用
	 */
    public String getBusIsvalid() {
        return busIsvalid;
    }

    /**
	 * 设置启用标记1：启用0：禁用
	 *
	 * @param busIsvalid
	 *            启用标记1：启用0：禁用
	 */
    public void setBusIsvalid(String busIsvalid) {
        this.busIsvalid = busIsvalid;
    }

    /**
	 * 获取所属机构
	 *
	 * @return bus_org_uuid - 所属机构
	 */
    public String getBusOrgUuid() {
        return busOrgUuid;
    }

    /**
	 * 设置所属机构
	 *
	 * @param busOrgUuid
	 *            所属机构
	 */
    public void setBusOrgUuid(String busOrgUuid) {
        this.busOrgUuid = busOrgUuid;
    }

    /**
	 * 获取所属线路
	 *
	 * @return bus_line_uuid - 所属线路
	 */
    public String getBusLineUuid() {
        return busLineUuid;
    }

    /**
	 * 设置所属线路
	 *
	 * @param busLineUuid
	 *            所属线路
	 */
    public void setBusLineUuid(String busLineUuid) {
        this.busLineUuid = busLineUuid;
    }

    /**
	 * 获取荷载人数
	 *
	 * @return bus_load_number - 荷载人数
	 */
    public Integer getBusLoadNumber() {
        return busLoadNumber;
    }

    /**
	 * 设置荷载人数
	 *
	 * @param busLoadNumber
	 *            荷载人数
	 */
    public void setBusLoadNumber(Integer busLoadNumber) {
        this.busLoadNumber = busLoadNumber;
    }

    /**
	 * 获取创建时间
	 *
	 * @return bus_create_time - 创建时间
	 */
    public Date getBusCreateTime() {
        return busCreateTime;
    }

    /**
	 * 设置创建时间
	 *
	 * @param busCreateTime
	 *            创建时间
	 */
    public void setBusCreateTime(Date busCreateTime) {
        this.busCreateTime = busCreateTime;
    }

    /**
	 * 获取删除标示 0 正常 1 删除
	 *
	 * @return bus_drop_flag - 删除标示 0 正常 1 删除
	 */
    public String getBusDropFlag() {
        return busDropFlag;
    }

    /**
	 * 设置删除标示 0 正常 1 删除
	 *
	 * @param busDropFlag
	 *            删除标示 0 正常 1 删除
	 */
    public void setBusDropFlag(String busDropFlag) {
        this.busDropFlag = busDropFlag;
    }

}