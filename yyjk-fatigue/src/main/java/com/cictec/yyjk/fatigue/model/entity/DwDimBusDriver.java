package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_bus_driver")
public class DwDimBusDriver {
	@Id
    @Column(name = "drv_uuid")
    private String drvUuid;

    /**
	 * 所属机构
	 */
    @Column(name = "drv_org_uuid")
    private String drvOrgUuid;

    /**
	 * 所属线路
	 */
    @Column(name = "drv_line_uuid")
    private String drvLineUuid;

    /**
	 * 姓名
	 */
    @Column(name = "drv_name")
    private String drvName;

    /**
	 * 性别
	 */
    @Column(name = "drv_sex")
    private String drvSex;

    /**
	 * 出生日期
	 */
    @Column(name = "drv_birthday")
    private Date drvBirthday;

    /**
	 * 员工编号
	 */
    @Column(name = "drv_employee_id")
    private String drvEmployeeId;

    /**
	 * 身份证号
	 */
    @Column(name = "drv_per_id")
    private String drvPerId;

    /**
	 * IC卡编号
	 */
    @Column(name = "drv_ic_card")
    private String drvIcCard;

    /**
	 * 删除标识1启用，2禁用
	 */
    @Column(name = "drv_isvalid")
    private String drvIsvalid;

    /**
	 * 创建时间
	 */
    @Column(name = "drv_create_time")
    private Date drvCreateTime;

    /**
	 * 删除标示 0 正常 1 删除';
	 */
    @Column(name = "drv_drop_flag")
    private String drvDropFlag;

    /**
	 * 人员类型
	 */
    @Column(name = "drv_type")
    private String drvType;

	public DwDimBusDriver() {
		super();
	}

	public DwDimBusDriver(String drvUuid, String drvOrgUuid, String drvLineUuid, String drvName, String drvSex,
			Date drvBirthday, String drvEmployeeId, String drvPerId, String drvIcCard, String drvIsvalid,
			Date drvCreateTime, String drvDropFlag, String drvType) {
		super();
		this.drvUuid = drvUuid;
		this.drvOrgUuid = drvOrgUuid;
		this.drvLineUuid = drvLineUuid;
		this.drvName = drvName;
		this.drvSex = drvSex;
		this.drvBirthday = drvBirthday;
		this.drvEmployeeId = drvEmployeeId;
		this.drvPerId = drvPerId;
		this.drvIcCard = drvIcCard;
		this.drvIsvalid = drvIsvalid;
		this.drvCreateTime = drvCreateTime;
		this.drvDropFlag = drvDropFlag;
		this.drvType = drvType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drvBirthday == null) ? 0 : drvBirthday.hashCode());
		result = prime * result + ((drvCreateTime == null) ? 0 : drvCreateTime.hashCode());
		result = prime * result + ((drvDropFlag == null) ? 0 : drvDropFlag.hashCode());
		result = prime * result + ((drvEmployeeId == null) ? 0 : drvEmployeeId.hashCode());
		result = prime * result + ((drvIcCard == null) ? 0 : drvIcCard.hashCode());
		result = prime * result + ((drvIsvalid == null) ? 0 : drvIsvalid.hashCode());
		result = prime * result + ((drvLineUuid == null) ? 0 : drvLineUuid.hashCode());
		result = prime * result + ((drvName == null) ? 0 : drvName.hashCode());
		result = prime * result + ((drvOrgUuid == null) ? 0 : drvOrgUuid.hashCode());
		result = prime * result + ((drvPerId == null) ? 0 : drvPerId.hashCode());
		result = prime * result + ((drvSex == null) ? 0 : drvSex.hashCode());
		result = prime * result + ((drvType == null) ? 0 : drvType.hashCode());
		result = prime * result + ((drvUuid == null) ? 0 : drvUuid.hashCode());
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
		DwDimBusDriver other = (DwDimBusDriver) obj;
		if (drvBirthday == null) {
			if (other.drvBirthday != null)
				return false;
		} else if (!drvBirthday.equals(other.drvBirthday))
			return false;
		if (drvCreateTime == null) {
			if (other.drvCreateTime != null)
				return false;
		} else if (!drvCreateTime.equals(other.drvCreateTime))
			return false;
		if (drvDropFlag == null) {
			if (other.drvDropFlag != null)
				return false;
		} else if (!drvDropFlag.equals(other.drvDropFlag))
			return false;
		if (drvEmployeeId == null) {
			if (other.drvEmployeeId != null)
				return false;
		} else if (!drvEmployeeId.equals(other.drvEmployeeId))
			return false;
		if (drvIcCard == null) {
			if (other.drvIcCard != null)
				return false;
		} else if (!drvIcCard.equals(other.drvIcCard))
			return false;
		if (drvIsvalid == null) {
			if (other.drvIsvalid != null)
				return false;
		} else if (!drvIsvalid.equals(other.drvIsvalid))
			return false;
		if (drvLineUuid == null) {
			if (other.drvLineUuid != null)
				return false;
		} else if (!drvLineUuid.equals(other.drvLineUuid))
			return false;
		if (drvName == null) {
			if (other.drvName != null)
				return false;
		} else if (!drvName.equals(other.drvName))
			return false;
		if (drvOrgUuid == null) {
			if (other.drvOrgUuid != null)
				return false;
		} else if (!drvOrgUuid.equals(other.drvOrgUuid))
			return false;
		if (drvPerId == null) {
			if (other.drvPerId != null)
				return false;
		} else if (!drvPerId.equals(other.drvPerId))
			return false;
		if (drvSex == null) {
			if (other.drvSex != null)
				return false;
		} else if (!drvSex.equals(other.drvSex))
			return false;
		if (drvType == null) {
			if (other.drvType != null)
				return false;
		} else if (!drvType.equals(other.drvType))
			return false;
		if (drvUuid == null) {
			if (other.drvUuid != null)
				return false;
		} else if (!drvUuid.equals(other.drvUuid))
			return false;
		return true;
	}

	/**
	 * @return drv_uuid
	 */
    public String getDrvUuid() {
        return drvUuid;
    }

    /**
     * @param drvUuid
     */
    public void setDrvUuid(String drvUuid) {
        this.drvUuid = drvUuid;
    }

    /**
	 * 获取所属机构
	 *
	 * @return drv_org_uuid - 所属机构
	 */
    public String getDrvOrgUuid() {
        return drvOrgUuid;
    }

    /**
	 * 设置所属机构
	 *
	 * @param drvOrgUuid
	 *            所属机构
	 */
    public void setDrvOrgUuid(String drvOrgUuid) {
        this.drvOrgUuid = drvOrgUuid;
    }

    /**
	 * 获取所属线路
	 *
	 * @return drv_line_uuid - 所属线路
	 */
    public String getDrvLineUuid() {
        return drvLineUuid;
    }

    /**
	 * 设置所属线路
	 *
	 * @param drvLineUuid
	 *            所属线路
	 */
    public void setDrvLineUuid(String drvLineUuid) {
        this.drvLineUuid = drvLineUuid;
    }

    /**
	 * 获取姓名
	 *
	 * @return drv_name - 姓名
	 */
    public String getDrvName() {
        return drvName;
    }

    /**
	 * 设置姓名
	 *
	 * @param drvName
	 *            姓名
	 */
    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    /**
	 * 获取性别
	 *
	 * @return drv_sex - 性别
	 */
    public String getDrvSex() {
        return drvSex;
    }

    /**
	 * 设置性别
	 *
	 * @param drvSex
	 *            性别
	 */
    public void setDrvSex(String drvSex) {
        this.drvSex = drvSex;
    }

    /**
	 * 获取出生日期
	 *
	 * @return drv_birthday - 出生日期
	 */
    public Date getDrvBirthday() {
        return drvBirthday;
    }

    /**
	 * 设置出生日期
	 *
	 * @param drvBirthday
	 *            出生日期
	 */
    public void setDrvBirthday(Date drvBirthday) {
        this.drvBirthday = drvBirthday;
    }

    /**
	 * 获取员工编号
	 *
	 * @return drv_employee_id - 员工编号
	 */
    public String getDrvEmployeeId() {
        return drvEmployeeId;
    }

    /**
	 * 设置员工编号
	 *
	 * @param drvEmployeeId
	 *            员工编号
	 */
    public void setDrvEmployeeId(String drvEmployeeId) {
        this.drvEmployeeId = drvEmployeeId;
    }

    /**
	 * 获取身份证号
	 *
	 * @return drv_per_id - 身份证号
	 */
    public String getDrvPerId() {
        return drvPerId;
    }

    /**
	 * 设置身份证号
	 *
	 * @param drvPerId
	 *            身份证号
	 */
    public void setDrvPerId(String drvPerId) {
        this.drvPerId = drvPerId;
    }

    /**
	 * 获取IC卡编号
	 *
	 * @return drv_ic_card - IC卡编号
	 */
    public String getDrvIcCard() {
        return drvIcCard;
    }

    /**
	 * 设置IC卡编号
	 *
	 * @param drvIcCard
	 *            IC卡编号
	 */
    public void setDrvIcCard(String drvIcCard) {
        this.drvIcCard = drvIcCard;
    }

    /**
	 * 获取删除标识1启用，2禁用
	 *
	 * @return drv_isvalid - 删除标识1启用，2禁用
	 */
    public String getDrvIsvalid() {
        return drvIsvalid;
    }

    /**
	 * 设置删除标识1启用，2禁用
	 *
	 * @param drvIsvalid
	 *            删除标识1启用，2禁用
	 */
    public void setDrvIsvalid(String drvIsvalid) {
        this.drvIsvalid = drvIsvalid;
    }

    /**
	 * 获取创建时间
	 *
	 * @return drv_create_time - 创建时间
	 */
    public Date getDrvCreateTime() {
        return drvCreateTime;
    }

    /**
	 * 设置创建时间
	 *
	 * @param drvCreateTime
	 *            创建时间
	 */
    public void setDrvCreateTime(Date drvCreateTime) {
        this.drvCreateTime = drvCreateTime;
    }

    /**
	 * 获取删除标示 0 正常 1 删除';
	 *
	 * @return drv_drop_flag - 删除标示 0 正常 1 删除';
	 */
    public String getDrvDropFlag() {
        return drvDropFlag;
    }

    /**
	 * 设置删除标示 0 正常 1 删除';
	 *
	 * @param drvDropFlag
	 *            删除标示 0 正常 1 删除';
	 */
    public void setDrvDropFlag(String drvDropFlag) {
        this.drvDropFlag = drvDropFlag;
    }

    /**
	 * 获取人员类型
	 *
	 * @return drv_type - 人员类型
	 */
    public String getDrvType() {
        return drvType;
    }

    /**
	 * 设置人员类型
	 *
	 * @param drvType
	 *            人员类型
	 */
    public void setDrvType(String drvType) {
        this.drvType = drvType;
    }
}