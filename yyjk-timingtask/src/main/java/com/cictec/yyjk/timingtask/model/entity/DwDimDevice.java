package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_device")
public class DwDimDevice {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "dev_uuid")
    private String devUuid;

	/**
	 * 设备编号
	 */
    @Column(name = "dev_code")
    private String devCode;

    /**
	 * 版本
	 */
    @Column(name = "dev_version")
    private String devVersion;

    /**
	 * 设备卡号
	 */
    @Column(name = "dev_sim_num")
    private String devSimNum;

    /**
	 * 启用标记1：启用0：禁用
	 */
    @Column(name = "dev_isvalid")
    private String devIsvalid;

    /**
	 * 创建时间
	 */
    @Column(name = "dev_create_time")
    private Date devCreateTime;

    /**
	 * 删除标示0：未删除 1 删除
	 */
    @Column(name = "dev_drop_flag")
    private String devDropFlag;

    /**
	 * 鉴权码
	 */
    @Column(name = "dev_key")
    private String devKey;

    /**
	 * 设备类型 F3R , FTP, F3R-FTP
	 */
    @Column(name = "dev_type")
    private String devType;

	/**
	 * 终端id
	 */
	@Column(name = "dev_ref_id")
	private String devRefId;

	public DwDimDevice() {
		super();
	}

	public DwDimDevice(String devUuid, String devCode, String devVersion, String devSimNum, String devIsvalid,
			Date devCreateTime, String devDropFlag, String devKey, String devType, String devRefId) {
		super();
		this.devUuid = devUuid;
		this.devCode = devCode;
		this.devVersion = devVersion;
		this.devSimNum = devSimNum;
		this.devIsvalid = devIsvalid;
		this.devCreateTime = devCreateTime;
		this.devDropFlag = devDropFlag;
		this.devKey = devKey;
		this.devType = devType;
		this.devRefId = devRefId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devCode == null) ? 0 : devCode.hashCode());
		result = prime * result + ((devCreateTime == null) ? 0 : devCreateTime.hashCode());
		result = prime * result + ((devDropFlag == null) ? 0 : devDropFlag.hashCode());
		result = prime * result + ((devIsvalid == null) ? 0 : devIsvalid.hashCode());
		result = prime * result + ((devKey == null) ? 0 : devKey.hashCode());
		result = prime * result + ((devRefId == null) ? 0 : devRefId.hashCode());
		result = prime * result + ((devSimNum == null) ? 0 : devSimNum.hashCode());
		result = prime * result + ((devType == null) ? 0 : devType.hashCode());
		result = prime * result + ((devUuid == null) ? 0 : devUuid.hashCode());
		result = prime * result + ((devVersion == null) ? 0 : devVersion.hashCode());
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
		DwDimDevice other = (DwDimDevice) obj;
		if (devCode == null) {
			if (other.devCode != null)
				return false;
		} else if (!devCode.equals(other.devCode))
			return false;
		if (devCreateTime == null) {
			if (other.devCreateTime != null)
				return false;
		} else if (!devCreateTime.equals(other.devCreateTime))
			return false;
		if (devDropFlag == null) {
			if (other.devDropFlag != null)
				return false;
		} else if (!devDropFlag.equals(other.devDropFlag))
			return false;
		if (devIsvalid == null) {
			if (other.devIsvalid != null)
				return false;
		} else if (!devIsvalid.equals(other.devIsvalid))
			return false;
		if (devKey == null) {
			if (other.devKey != null)
				return false;
		} else if (!devKey.equals(other.devKey))
			return false;
		if (devRefId == null) {
			if (other.devRefId != null)
				return false;
		} else if (!devRefId.equals(other.devRefId))
			return false;
		if (devSimNum == null) {
			if (other.devSimNum != null)
				return false;
		} else if (!devSimNum.equals(other.devSimNum))
			return false;
		if (devType == null) {
			if (other.devType != null)
				return false;
		} else if (!devType.equals(other.devType))
			return false;
		if (devUuid == null) {
			if (other.devUuid != null)
				return false;
		} else if (!devUuid.equals(other.devUuid))
			return false;
		if (devVersion == null) {
			if (other.devVersion != null)
				return false;
		} else if (!devVersion.equals(other.devVersion))
			return false;
		return true;
	}

	/**
	 * 获取主键
	 *
	 * @return dev_uuid - 主键
	 */
    public String getDevUuid() {
        return devUuid;
    }

    /**
	 * 设置主键
	 *
	 * @param devUuid
	 *            主键
	 */
    public void setDevUuid(String devUuid) {
        this.devUuid = devUuid;
    }

    /**
	 * 获取设备编号
	 *
	 * @return dev_code - 设备编号
	 */
    public String getDevCode() {
        return devCode;
    }

    /**
	 * 设置设备编号
	 *
	 * @param devCode
	 *            设备编号
	 */
    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    /**
	 * 获取版本
	 *
	 * @return dev_version - 版本
	 */
    public String getDevVersion() {
        return devVersion;
    }

    /**
	 * 设置版本
	 *
	 * @param devVersion
	 *            版本
	 */
    public void setDevVersion(String devVersion) {
        this.devVersion = devVersion;
    }

    /**
	 * 获取设备卡号
	 *
	 * @return dev_sim_num - 设备卡号
	 */
    public String getDevSimNum() {
        return devSimNum;
    }

    /**
	 * 设置设备卡号
	 *
	 * @param devSimNum
	 *            设备卡号
	 */
    public void setDevSimNum(String devSimNum) {
        this.devSimNum = devSimNum;
    }

    /**
	 * 获取启用标记1：启用0：禁用
	 *
	 * @return dev_isvalid - 启用标记1：启用0：禁用
	 */
    public String getDevIsvalid() {
        return devIsvalid;
    }

    /**
	 * 设置启用标记1：启用0：禁用
	 *
	 * @param devIsvalid
	 *            启用标记1：启用0：禁用
	 */
    public void setDevIsvalid(String devIsvalid) {
        this.devIsvalid = devIsvalid;
    }

    /**
	 * 获取创建时间
	 *
	 * @return dev_create_time - 创建时间
	 */
    public Date getDevCreateTime() {
        return devCreateTime;
    }

    /**
	 * 设置创建时间
	 *
	 * @param devCreateTime
	 *            创建时间
	 */
    public void setDevCreateTime(Date devCreateTime) {
        this.devCreateTime = devCreateTime;
    }

    /**
	 * 获取删除标示0：未删除 1 删除
	 *
	 * @return dev_drop_flag - 删除标示0：未删除 1 删除
	 */
    public String getDevDropFlag() {
        return devDropFlag;
    }

    /**
	 * 设置删除标示0：未删除 1 删除
	 *
	 * @param devDropFlag
	 *            删除标示0：未删除 1 删除
	 */
    public void setDevDropFlag(String devDropFlag) {
        this.devDropFlag = devDropFlag;
    }

    /**
	 * 获取 鉴权码
	 *
	 * @return dev_key - 鉴权码
	 */
    public String getDevKey() {
        return devKey;
    }

    /**
	 * 设置 鉴权码
	 *
	 * @param devKey
	 *            鉴权码
	 */
    public void setDevKey(String devKey) {
        this.devKey = devKey;
    }

    /**
	 * 获取设备类型 F3R , FTP, F3R-FTP
	 *
	 * @return dev_type - 设备类型 F3R , FTP, F3R-FTP
	 */
    public String getDevType() {
        return devType;
    }

    /**
	 * 设置设备类型 F3R , FTP, F3R-FTP
	 *
	 * @param devType
	 *            设备类型 F3R , FTP, F3R-FTP
	 */
	public void setDevType(String devType) {
		this.devType = devType;
	}

	public String getDevRefId() {
		return devRefId;
	}

	public void setDevRefId(String devRefId) {
		this.devRefId = devRefId;
	}

}