package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_other_bus_device")
public class DwDimOtherBusDevice {
    @Id
    @Column(name = "bus_dev_uuid")
	private String busDevUuid;

    @Column(name = "bus_uuid")
    private String busUuid;

    @Column(name = "dev_uuid")
	private String devUuid;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return bus_dev_uuid
     */
	public String getBusDevUuid() {
        return busDevUuid;
    }

    /**
     * @param busDevUuid
     */
	public void setBusDevUuid(String busDevUuid) {
        this.busDevUuid = busDevUuid;
    }

    /**
     * @return bus_uuid
     */
    public String getBusUuid() {
        return busUuid;
    }

    /**
     * @param busUuid
     */
    public void setBusUuid(String busUuid) {
        this.busUuid = busUuid;
    }

    /**
     * @return dev_uuid
     */
	public String getDevUuid() {
        return devUuid;
    }

    /**
     * @param devUuid
     */
	public void setDevUuid(String devUuid) {
        this.devUuid = devUuid;
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}