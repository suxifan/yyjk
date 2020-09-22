package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "dw_dim_line_station")
public class DwDimLineStation {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "ls_uuid")
    private String lsUuid;

    /**
	 * 线路uuid
	 */
    @Column(name = "ls_line_uuid")
    private String lsLineUuid;

    /**
	 * 线路类型 1：上行 2：下行
	 */
    @Column(name = "ls_line_type")
    private String lsLineType;

    /**
	 * 站点uuid
	 */
    @Column(name = "ls_sta_uuid")
    private String lsStaUuid;

    /**
	 * 站点经度
	 */
    @Column(name = "ls_sta_lng")
    private String lsStaLng;

    /**
	 * 站点纬度
	 */
    @Column(name = "ls_sta_lat")
    private String lsStaLat;

    /**
	 * 站点序号
	 */
    @Column(name = "ls_sequence")
    private Integer lsSequence;

    /**
	 * 删除标志 0--正常数据 1--删除数据
	 */
    @Column(name = "ls_delete_flag")
    private String lsDeleteFlag;

    /**
	 * 删除时间
	 */
    @Column(name = "ls_delete_time")
    private Date lsDeleteTime;

    /**
	 * 大站标志 0 -- 普通站点；1--大站
	 */
    @Column(name = "ls_major")
    private String lsMajor;

	/**
	 * 大站标志 0 -- 普通站点；1--大站
	 */
	@Column(name = "ls_start_to_this_distance")
	private String lsStartToThisDistance;

	/**
	 * 站间距
	 */
	@Transient
	private String lsBetweenDistance;

	public DwDimLineStation() {
		super();
	}

	public DwDimLineStation(String lsUuid, String lsLineUuid, String lsLineType, String lsStaUuid, String lsStaLng,
			String lsStaLat, Integer lsSequence, String lsDeleteFlag, Date lsDeleteTime, String lsMajor,
			String lsStartToThisDistance) {
		super();
		this.lsUuid = lsUuid;
		this.lsLineUuid = lsLineUuid;
		this.lsLineType = lsLineType;
		this.lsStaUuid = lsStaUuid;
		this.lsStaLng = lsStaLng;
		this.lsStaLat = lsStaLat;
		this.lsSequence = lsSequence;
		this.lsDeleteFlag = lsDeleteFlag;
		this.lsDeleteTime = lsDeleteTime;
		this.lsMajor = lsMajor;
		this.lsStartToThisDistance = lsStartToThisDistance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lsDeleteFlag == null) ? 0 : lsDeleteFlag.hashCode());
		result = prime * result + ((lsDeleteTime == null) ? 0 : lsDeleteTime.hashCode());
		result = prime * result + ((lsLineType == null) ? 0 : lsLineType.hashCode());
		result = prime * result + ((lsLineUuid == null) ? 0 : lsLineUuid.hashCode());
		result = prime * result + ((lsMajor == null) ? 0 : lsMajor.hashCode());
		result = prime * result + ((lsSequence == null) ? 0 : lsSequence.hashCode());
		result = prime * result + ((lsStaLat == null) ? 0 : lsStaLat.hashCode());
		result = prime * result + ((lsStaLng == null) ? 0 : lsStaLng.hashCode());
		result = prime * result + ((lsStaUuid == null) ? 0 : lsStaUuid.hashCode());
		result = prime * result + ((lsStartToThisDistance == null) ? 0 : lsStartToThisDistance.hashCode());
		result = prime * result + ((lsUuid == null) ? 0 : lsUuid.hashCode());
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
		DwDimLineStation other = (DwDimLineStation) obj;
		if (lsDeleteFlag == null) {
			if (other.lsDeleteFlag != null)
				return false;
		} else if (!lsDeleteFlag.equals(other.lsDeleteFlag))
			return false;
		if (lsDeleteTime == null) {
			if (other.lsDeleteTime != null)
				return false;
		} else if (!lsDeleteTime.equals(other.lsDeleteTime))
			return false;
		if (lsLineType == null) {
			if (other.lsLineType != null)
				return false;
		} else if (!lsLineType.equals(other.lsLineType))
			return false;
		if (lsLineUuid == null) {
			if (other.lsLineUuid != null)
				return false;
		} else if (!lsLineUuid.equals(other.lsLineUuid))
			return false;
		if (lsMajor == null) {
			if (other.lsMajor != null)
				return false;
		} else if (!lsMajor.equals(other.lsMajor))
			return false;
		if (lsSequence == null) {
			if (other.lsSequence != null)
				return false;
		} else if (!lsSequence.equals(other.lsSequence))
			return false;
		if (lsStaLat == null) {
			if (other.lsStaLat != null)
				return false;
		} else if (!lsStaLat.equals(other.lsStaLat))
			return false;
		if (lsStaLng == null) {
			if (other.lsStaLng != null)
				return false;
		} else if (!lsStaLng.equals(other.lsStaLng))
			return false;
		if (lsStaUuid == null) {
			if (other.lsStaUuid != null)
				return false;
		} else if (!lsStaUuid.equals(other.lsStaUuid))
			return false;
		if (lsStartToThisDistance == null) {
			if (other.lsStartToThisDistance != null)
				return false;
		} else if (!lsStartToThisDistance.equals(other.lsStartToThisDistance))
			return false;
		if (lsUuid == null) {
			if (other.lsUuid != null)
				return false;
		} else if (!lsUuid.equals(other.lsUuid))
			return false;
		return true;
	}

	/**
	 * 获取主键
	 *
	 * @return ls_uuid - 主键
	 */
    public String getLsUuid() {
        return lsUuid;
    }

    /**
	 * 设置主键
	 *
	 * @param lsUuid
	 *            主键
	 */
    public void setLsUuid(String lsUuid) {
        this.lsUuid = lsUuid;
    }

    /**
	 * 获取线路uuid
	 *
	 * @return ls_line_uuid - 线路uuid
	 */
    public String getLsLineUuid() {
        return lsLineUuid;
    }

    /**
	 * 设置线路uuid
	 *
	 * @param lsLineUuid
	 *            线路uuid
	 */
    public void setLsLineUuid(String lsLineUuid) {
        this.lsLineUuid = lsLineUuid;
    }

    /**
	 * 获取线路类型 1：上行 2：下行
	 *
	 * @return ls_line_type - 线路类型 1：上行 2：下行
	 */
    public String getLsLineType() {
        return lsLineType;
    }

    /**
	 * 设置线路类型 1：上行 2：下行
	 *
	 * @param lsLineType
	 *            线路类型 1：上行 2：下行
	 */
    public void setLsLineType(String lsLineType) {
        this.lsLineType = lsLineType;
    }

    /**
	 * 获取站点uuid
	 *
	 * @return ls_sta_uuid - 站点uuid
	 */
    public String getLsStaUuid() {
        return lsStaUuid;
    }

    /**
	 * 设置站点uuid
	 *
	 * @param lsStaUuid
	 *            站点uuid
	 */
    public void setLsStaUuid(String lsStaUuid) {
        this.lsStaUuid = lsStaUuid;
    }

    /**
	 * 获取站点经度
	 *
	 * @return ls_sta_lng - 站点经度
	 */
    public String getLsStaLng() {
        return lsStaLng;
    }

    /**
	 * 设置站点经度
	 *
	 * @param lsStaLng
	 *            站点经度
	 */
    public void setLsStaLng(String lsStaLng) {
        this.lsStaLng = lsStaLng;
    }

    /**
	 * 获取站点纬度
	 *
	 * @return ls_sta_lat - 站点纬度
	 */
    public String getLsStaLat() {
        return lsStaLat;
    }

    /**
	 * 设置站点纬度
	 *
	 * @param lsStaLat
	 *            站点纬度
	 */
    public void setLsStaLat(String lsStaLat) {
        this.lsStaLat = lsStaLat;
    }

    /**
	 * 获取站点序号
	 *
	 * @return ls_sequence - 站点序号
	 */
    public Integer getLsSequence() {
        return lsSequence;
    }

    /**
	 * 设置站点序号
	 *
	 * @param lsSequence
	 *            站点序号
	 */
    public void setLsSequence(Integer lsSequence) {
        this.lsSequence = lsSequence;
    }

    /**
	 * 获取删除标志 0--正常数据 1--删除数据
	 *
	 * @return ls_delete_flag - 删除标志 0--正常数据 1--删除数据
	 */
    public String getLsDeleteFlag() {
        return lsDeleteFlag;
    }

    /**
	 * 设置删除标志 0--正常数据 1--删除数据
	 *
	 * @param lsDeleteFlag
	 *            删除标志 0--正常数据 1--删除数据
	 */
    public void setLsDeleteFlag(String lsDeleteFlag) {
        this.lsDeleteFlag = lsDeleteFlag;
    }

    /**
	 * 获取删除时间
	 *
	 * @return ls_delete_time - 删除时间
	 */
    public Date getLsDeleteTime() {
        return lsDeleteTime;
    }

    /**
	 * 设置删除时间
	 *
	 * @param lsDeleteTime
	 *            删除时间
	 */
    public void setLsDeleteTime(Date lsDeleteTime) {
        this.lsDeleteTime = lsDeleteTime;
    }

    /**
	 * 获取大站标志 0 -- 普通站点；1--大站
	 *
	 * @return ls_major - 大站标志 0 -- 普通站点；1--大站
	 */
    public String getLsMajor() {
        return lsMajor;
    }

    /**
	 * 设置大站标志 0 -- 普通站点；1--大站
	 *
	 * @param lsMajor
	 *            大站标志 0 -- 普通站点；1--大站
	 */
    public void setLsMajor(String lsMajor) {
        this.lsMajor = lsMajor;
    }

	public String getLsStartToThisDistance() {
		return lsStartToThisDistance;
	}

	public void setLsStartToThisDistance(String lsStartToThisDistance) {
		this.lsStartToThisDistance = lsStartToThisDistance;
	}

	public String getLsBetweenDistance() {
		return lsBetweenDistance;
	}

	public void setLsBetweenDistance(String lsBetweenDistance) {
		this.lsBetweenDistance = lsBetweenDistance;
	}

}