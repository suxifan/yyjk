package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_bus_station")
public class DwDimBusStation {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "sta_uuid")
    private String staUuid;

    /**
	 * 站名
	 */
    @Column(name = "sta_name")
    private String staName;

    /**
	 * 详细地址
	 */
    @Column(name = "sta_address")
    private String staAddress;

    /**
	 * 创建时间
	 */
    @Column(name = "sta_create_time")
	private Date staCreateTime;

    /**
	 * 删除标记 1：启用 0：禁用
	 */
    @Column(name = "sta_isvalid")
    private String staIsvalid;

    /**
	 * 删除标示（0:未删除 1 ：删除）
	 */
    @Column(name = "sta_drop_flag")
    private String staDropFlag;

    /**
	 * 站点编号
	 */
    @Column(name = "sta_no")
    private String staNo;

    /**
	 * 站点经度
	 */
    @Column(name = "sta_lng")
    private String staLng;

    /**
	 * 站点纬度
	 */
    @Column(name = "sta_lnt")
    private String staLnt;

    /**
	 * 方向角
	 */
    @Column(name = "direction_angle")
    private String directionAngle;

    /**
	 * 方向:东南西北
	 */
    @Column(name = "sta_direction")
    private String staDirection;

	public DwDimBusStation() {
		super();
	}

	public DwDimBusStation(String staUuid, String staName, String staAddress, Date staCreateTime, String staIsvalid,
			String staDropFlag, String staNo, String staLng, String staLnt, String directionAngle,
			String staDirection) {
		super();
		this.staUuid = staUuid;
		this.staName = staName;
		this.staAddress = staAddress;
		this.staCreateTime = staCreateTime;
		this.staIsvalid = staIsvalid;
		this.staDropFlag = staDropFlag;
		this.staNo = staNo;
		this.staLng = staLng;
		this.staLnt = staLnt;
		this.directionAngle = directionAngle;
		this.staDirection = staDirection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((directionAngle == null) ? 0 : directionAngle.hashCode());
		result = prime * result + ((staAddress == null) ? 0 : staAddress.hashCode());
		result = prime * result + ((staCreateTime == null) ? 0 : staCreateTime.hashCode());
		result = prime * result + ((staDirection == null) ? 0 : staDirection.hashCode());
		result = prime * result + ((staDropFlag == null) ? 0 : staDropFlag.hashCode());
		result = prime * result + ((staIsvalid == null) ? 0 : staIsvalid.hashCode());
		result = prime * result + ((staLng == null) ? 0 : staLng.hashCode());
		result = prime * result + ((staLnt == null) ? 0 : staLnt.hashCode());
		result = prime * result + ((staName == null) ? 0 : staName.hashCode());
		result = prime * result + ((staNo == null) ? 0 : staNo.hashCode());
		result = prime * result + ((staUuid == null) ? 0 : staUuid.hashCode());
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
		DwDimBusStation other = (DwDimBusStation) obj;
		if (directionAngle == null) {
			if (other.directionAngle != null)
				return false;
		} else if (!directionAngle.equals(other.directionAngle))
			return false;
		if (staAddress == null) {
			if (other.staAddress != null)
				return false;
		} else if (!staAddress.equals(other.staAddress))
			return false;
		if (staCreateTime == null) {
			if (other.staCreateTime != null)
				return false;
		} else if (!staCreateTime.equals(other.staCreateTime))
			return false;
		if (staDirection == null) {
			if (other.staDirection != null)
				return false;
		} else if (!staDirection.equals(other.staDirection))
			return false;
		if (staDropFlag == null) {
			if (other.staDropFlag != null)
				return false;
		} else if (!staDropFlag.equals(other.staDropFlag))
			return false;
		if (staIsvalid == null) {
			if (other.staIsvalid != null)
				return false;
		} else if (!staIsvalid.equals(other.staIsvalid))
			return false;
		if (staLng == null) {
			if (other.staLng != null)
				return false;
		} else if (!staLng.equals(other.staLng))
			return false;
		if (staLnt == null) {
			if (other.staLnt != null)
				return false;
		} else if (!staLnt.equals(other.staLnt))
			return false;
		if (staName == null) {
			if (other.staName != null)
				return false;
		} else if (!staName.equals(other.staName))
			return false;
		if (staNo == null) {
			if (other.staNo != null)
				return false;
		} else if (!staNo.equals(other.staNo))
			return false;
		if (staUuid == null) {
			if (other.staUuid != null)
				return false;
		} else if (!staUuid.equals(other.staUuid))
			return false;
		return true;
	}

	/**
	 * 获取主键
	 *
	 * @return sta_uuid - 主键
	 */
    public String getStaUuid() {
        return staUuid;
    }

    /**
	 * 设置主键
	 *
	 * @param staUuid
	 *            主键
	 */
    public void setStaUuid(String staUuid) {
        this.staUuid = staUuid;
    }

    /**
	 * 获取站名
	 *
	 * @return sta_name - 站名
	 */
    public String getStaName() {
        return staName;
    }

    /**
	 * 设置站名
	 *
	 * @param staName
	 *            站名
	 */
    public void setStaName(String staName) {
        this.staName = staName;
    }

    /**
	 * 获取详细地址
	 *
	 * @return sta_address - 详细地址
	 */
    public String getStaAddress() {
        return staAddress;
    }

    /**
	 * 设置详细地址
	 *
	 * @param staAddress
	 *            详细地址
	 */
    public void setStaAddress(String staAddress) {
        this.staAddress = staAddress;
    }

    /**
	 * 获取创建时间
	 *
	 * @return sta_create_time - 创建时间
	 */
	public Date getStaCreateTime() {
        return staCreateTime;
    }

    /**
	 * 设置创建时间
	 *
	 * @param staCreateTime
	 *            创建时间
	 */
	public void setStaCreateTime(Date staCreateTime) {
        this.staCreateTime = staCreateTime;
    }

    /**
	 * 获取删除标记 1：启用 0：禁用
	 *
	 * @return sta_isvalid - 删除标记 1：启用 0：禁用
	 */
    public String getStaIsvalid() {
        return staIsvalid;
    }

    /**
	 * 设置删除标记 1：启用 0：禁用
	 *
	 * @param staIsvalid
	 *            删除标记 1：启用 0：禁用
	 */
    public void setStaIsvalid(String staIsvalid) {
        this.staIsvalid = staIsvalid;
    }

    /**
	 * 获取删除标示（0:未删除 1 ：删除）
	 *
	 * @return sta_drop_flag - 删除标示（0:未删除 1 ：删除）
	 */
    public String getStaDropFlag() {
        return staDropFlag;
    }

    /**
	 * 设置删除标示（0:未删除 1 ：删除）
	 *
	 * @param staDropFlag
	 *            删除标示（0:未删除 1 ：删除）
	 */
    public void setStaDropFlag(String staDropFlag) {
        this.staDropFlag = staDropFlag;
    }

    /**
	 * 获取站点编号
	 *
	 * @return sta_no - 站点编号
	 */
    public String getStaNo() {
        return staNo;
    }

    /**
	 * 设置站点编号
	 *
	 * @param staNo
	 *            站点编号
	 */
    public void setStaNo(String staNo) {
        this.staNo = staNo;
    }

    /**
	 * 获取站点经度
	 *
	 * @return sta_lng - 站点经度
	 */
    public String getStaLng() {
        return staLng;
    }

    /**
	 * 设置站点经度
	 *
	 * @param staLng
	 *            站点经度
	 */
    public void setStaLng(String staLng) {
        this.staLng = staLng;
    }

    /**
	 * 获取站点纬度
	 *
	 * @return sta_lnt - 站点纬度
	 */
    public String getStaLnt() {
        return staLnt;
    }

    /**
	 * 设置站点纬度
	 *
	 * @param staLnt
	 *            站点纬度
	 */
    public void setStaLnt(String staLnt) {
        this.staLnt = staLnt;
    }

    /**
	 * 获取方向角
	 *
	 * @return direction_angle - 方向角
	 */
    public String getDirectionAngle() {
        return directionAngle;
    }

    /**
	 * 设置方向角
	 *
	 * @param directionAngle
	 *            方向角
	 */
    public void setDirectionAngle(String directionAngle) {
        this.directionAngle = directionAngle;
    }

    /**
	 * 获取方向:东南西北
	 *
	 * @return sta_direction - 方向:东南西北
	 */
    public String getStaDirection() {
        return staDirection;
    }

    /**
	 * 设置方向:东南西北
	 *
	 * @param staDirection
	 *            方向:东南西北
	 */
    public void setStaDirection(String staDirection) {
        this.staDirection = staDirection;
    }
}