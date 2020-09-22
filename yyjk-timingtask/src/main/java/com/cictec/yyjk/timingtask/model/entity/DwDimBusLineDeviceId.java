package com.cictec.yyjk.timingtask.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_bus_line_device_id")
public class DwDimBusLineDeviceId {
    @Id
    @Column(name = "bld_uuid")
    private String bldUuid;

    /**
	 * 线路在设备上的ID
	 */
    @Column(name = "bld_line_uuid")
    private String bldLineUuid;

    @Column(name = "bld_line_type")
    private String bldLineType;

    @Column(name = "bld_device_line_id")
    private Integer bldDeviceLineId;

    @Column(name = "bld_flag")
    private Short bldFlag;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bldDeviceLineId == null) ? 0 : bldDeviceLineId.hashCode());
		result = prime * result + ((bldFlag == null) ? 0 : bldFlag.hashCode());
		result = prime * result + ((bldLineType == null) ? 0 : bldLineType.hashCode());
		result = prime * result + ((bldLineUuid == null) ? 0 : bldLineUuid.hashCode());
		result = prime * result + ((bldUuid == null) ? 0 : bldUuid.hashCode());
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
		DwDimBusLineDeviceId other = (DwDimBusLineDeviceId) obj;
		if (bldDeviceLineId == null) {
			if (other.bldDeviceLineId != null)
				return false;
		} else if (!bldDeviceLineId.equals(other.bldDeviceLineId))
			return false;
		if (bldFlag == null) {
			if (other.bldFlag != null)
				return false;
		} else if (!bldFlag.equals(other.bldFlag))
			return false;
		if (bldLineType == null) {
			if (other.bldLineType != null)
				return false;
		} else if (!bldLineType.equals(other.bldLineType))
			return false;
		if (bldLineUuid == null) {
			if (other.bldLineUuid != null)
				return false;
		} else if (!bldLineUuid.equals(other.bldLineUuid))
			return false;
		if (bldUuid == null) {
			if (other.bldUuid != null)
				return false;
		} else if (!bldUuid.equals(other.bldUuid))
			return false;
		return true;
	}

	/**
	 * @return bld_uuid
	 */
    public String getBldUuid() {
        return bldUuid;
    }

    /**
     * @param bldUuid
     */
    public void setBldUuid(String bldUuid) {
        this.bldUuid = bldUuid;
    }

    /**
	 * 获取线路在设备上的ID
	 *
	 * @return bld_line_uuid - 线路在设备上的ID
	 */
    public String getBldLineUuid() {
        return bldLineUuid;
    }

    /**
	 * 设置线路在设备上的ID
	 *
	 * @param bldLineUuid
	 *            线路在设备上的ID
	 */
    public void setBldLineUuid(String bldLineUuid) {
        this.bldLineUuid = bldLineUuid;
    }

    /**
     * @return bld_line_type
     */
    public String getBldLineType() {
        return bldLineType;
    }

    /**
     * @param bldLineType
     */
    public void setBldLineType(String bldLineType) {
        this.bldLineType = bldLineType;
    }

    /**
     * @return bld_device_line_id
     */
    public Integer getBldDeviceLineId() {
        return bldDeviceLineId;
    }

    /**
     * @param bldDeviceLineId
     */
    public void setBldDeviceLineId(Integer bldDeviceLineId) {
        this.bldDeviceLineId = bldDeviceLineId;
    }

    /**
     * @return bld_flag
     */
    public Short getBldFlag() {
        return bldFlag;
    }

    /**
     * @param bldFlag
     */
    public void setBldFlag(Short bldFlag) {
        this.bldFlag = bldFlag;
    }
}