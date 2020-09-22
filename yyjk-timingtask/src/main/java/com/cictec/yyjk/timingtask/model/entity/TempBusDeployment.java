package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "temp_bus_deployment")
public class TempBusDeployment {
    /**
     * 主键
     */
    @Id
    @Column(name = "dm_uuid")
    private String dmUuid;

    /**
     * 名称
     */
    @Column(name = "dm_name")
    private String dmName;

    /**
     * 线路机构id
     */
    @Column(name = "dm_org_uuid")
    private String dmOrgUuid;

    /**
     * 线路机构名
     */
    @Column(name = "dm_org_name")
    private String dmOrgName;

    /**
     * 线路id
     */
    @Column(name = "dm_line_uuid")
    private String dmLineUuid;

    /**
     * 线路名
     */
    @Column(name = "dm_line_name")
    private String dmLineName;

    /**
     * 出发站点id
     */
    @Column(name = "dm_start_sta_uuid")
    private String dmStartStaUuid;

    /**
     * 到达站点id
     */
    @Column(name = "dm_end_sta_uuid")
    private String dmEndStaUuid;

    /**
     * 出发站点名
     */
    @Column(name = "dm_start_sta_name")
    private String dmStartStaName;

    /**
     * 到达站点名
     */
    @Column(name = "dm_end_sta_name")
    private String dmEndStaName;

    /**
     * 出发站点的上下行
     */
    @Column(name = "dm_start_line_type")
    private String dmStartLineType;

    /**
     * 结束站点的上下行
     */
    @Column(name = "dm_end_line_type")
    private String dmEndLineType;

    /**
     * 趟次
     */
    @Column(name = "dm_trip")
    private String dmTrip;

    /**
     * 运营时长
     */
    @Column(name = "dm_run_time")
    private Short dmRunTime;

    /**
     * 运营里程
     */
    @Column(name = "dm_run_mileage")
    private Float dmRunMileage;

    /**
     * 非运营里程
     */
    @Column(name = "dm_non_mileage")
    private Float dmNonMileage;

    /**
     * 删除标示
     */
    @Column(name = "dm_drop_flag")
    private String dmDropFlag;

    /**
     * 创建时间
     */
    @Column(name = "dm_create_time")
    private Date dmCreateTime;

    /**
     * 更新时间
     */
    @Column(name = "dm_update_time")
    private Date dmUpdateTime;

    /**
     * 非运营类型,关联数据字典D45-value
     */
    @Column(name = "dm_non_type")
    private String dmNonType;

    /**
     * 获取主键
     *
     * @return dm_uuid - 主键
     */
    public String getDmUuid() {
        return dmUuid;
    }

    /**
     * 设置主键
     *
     * @param dmUuid 主键
     */
    public void setDmUuid(String dmUuid) {
        this.dmUuid = dmUuid;
    }

    /**
     * 获取名称
     *
     * @return dm_name - 名称
     */
    public String getDmName() {
        return dmName;
    }

    /**
     * 设置名称
     *
     * @param dmName 名称
     */
    public void setDmName(String dmName) {
        this.dmName = dmName;
    }

    /**
     * 获取线路机构id
     *
     * @return dm_org_uuid - 线路机构id
     */
    public String getDmOrgUuid() {
        return dmOrgUuid;
    }

    /**
     * 设置线路机构id
     *
     * @param dmOrgUuid 线路机构id
     */
    public void setDmOrgUuid(String dmOrgUuid) {
        this.dmOrgUuid = dmOrgUuid;
    }

    /**
     * 获取线路机构名
     *
     * @return dm_org_name - 线路机构名
     */
    public String getDmOrgName() {
        return dmOrgName;
    }

    /**
     * 设置线路机构名
     *
     * @param dmOrgName 线路机构名
     */
    public void setDmOrgName(String dmOrgName) {
        this.dmOrgName = dmOrgName;
    }

    /**
     * 获取线路id
     *
     * @return dm_line_uuid - 线路id
     */
    public String getDmLineUuid() {
        return dmLineUuid;
    }

    /**
     * 设置线路id
     *
     * @param dmLineUuid 线路id
     */
    public void setDmLineUuid(String dmLineUuid) {
        this.dmLineUuid = dmLineUuid;
    }

    /**
     * 获取线路名
     *
     * @return dm_line_name - 线路名
     */
    public String getDmLineName() {
        return dmLineName;
    }

    /**
     * 设置线路名
     *
     * @param dmLineName 线路名
     */
    public void setDmLineName(String dmLineName) {
        this.dmLineName = dmLineName;
    }

    /**
     * 获取出发站点id
     *
     * @return dm_start_sta_uuid - 出发站点id
     */
    public String getDmStartStaUuid() {
        return dmStartStaUuid;
    }

    /**
     * 设置出发站点id
     *
     * @param dmStartStaUuid 出发站点id
     */
    public void setDmStartStaUuid(String dmStartStaUuid) {
        this.dmStartStaUuid = dmStartStaUuid;
    }

    /**
     * 获取到达站点id
     *
     * @return dm_end_sta_uuid - 到达站点id
     */
    public String getDmEndStaUuid() {
        return dmEndStaUuid;
    }

    /**
     * 设置到达站点id
     *
     * @param dmEndStaUuid 到达站点id
     */
    public void setDmEndStaUuid(String dmEndStaUuid) {
        this.dmEndStaUuid = dmEndStaUuid;
    }

    /**
     * 获取出发站点名
     *
     * @return dm_start_sta_name - 出发站点名
     */
    public String getDmStartStaName() {
        return dmStartStaName;
    }

    /**
     * 设置出发站点名
     *
     * @param dmStartStaName 出发站点名
     */
    public void setDmStartStaName(String dmStartStaName) {
        this.dmStartStaName = dmStartStaName;
    }

    /**
     * 获取到达站点名
     *
     * @return dm_end_sta_name - 到达站点名
     */
    public String getDmEndStaName() {
        return dmEndStaName;
    }

    /**
     * 设置到达站点名
     *
     * @param dmEndStaName 到达站点名
     */
    public void setDmEndStaName(String dmEndStaName) {
        this.dmEndStaName = dmEndStaName;
    }

    /**
     * 获取出发站点的上下行
     *
     * @return dm_start_line_type - 出发站点的上下行
     */
    public String getDmStartLineType() {
        return dmStartLineType;
    }

    /**
     * 设置出发站点的上下行
     *
     * @param dmStartLineType 出发站点的上下行
     */
    public void setDmStartLineType(String dmStartLineType) {
        this.dmStartLineType = dmStartLineType;
    }

    /**
     * 获取结束站点的上下行
     *
     * @return dm_end_line_type - 结束站点的上下行
     */
    public String getDmEndLineType() {
        return dmEndLineType;
    }

    /**
     * 设置结束站点的上下行
     *
     * @param dmEndLineType 结束站点的上下行
     */
    public void setDmEndLineType(String dmEndLineType) {
        this.dmEndLineType = dmEndLineType;
    }

    /**
     * 获取趟次
     *
     * @return dm_trip - 趟次
     */
    public String getDmTrip() {
        return dmTrip;
    }

    /**
     * 设置趟次
     *
     * @param dmTrip 趟次
     */
    public void setDmTrip(String dmTrip) {
        this.dmTrip = dmTrip;
    }

    /**
     * 获取运营时长
     *
     * @return dm_run_time - 运营时长
     */
    public Short getDmRunTime() {
        return dmRunTime;
    }

    /**
     * 设置运营时长
     *
     * @param dmRunTime 运营时长
     */
    public void setDmRunTime(Short dmRunTime) {
        this.dmRunTime = dmRunTime;
    }

    /**
     * 获取运营里程
     *
     * @return dm_run_mileage - 运营里程
     */
    public Float getDmRunMileage() {
        return dmRunMileage;
    }

    /**
     * 设置运营里程
     *
     * @param dmRunMileage 运营里程
     */
    public void setDmRunMileage(Float dmRunMileage) {
        this.dmRunMileage = dmRunMileage;
    }

    /**
     * 获取非运营里程
     *
     * @return dm_non_mileage - 非运营里程
     */
    public Float getDmNonMileage() {
        return dmNonMileage;
    }

    /**
     * 设置非运营里程
     *
     * @param dmNonMileage 非运营里程
     */
    public void setDmNonMileage(Float dmNonMileage) {
        this.dmNonMileage = dmNonMileage;
    }

    /**
     * 获取删除标示
     *
     * @return dm_drop_flag - 删除标示
     */
    public String getDmDropFlag() {
        return dmDropFlag;
    }

    /**
     * 设置删除标示
     *
     * @param dmDropFlag 删除标示
     */
    public void setDmDropFlag(String dmDropFlag) {
        this.dmDropFlag = dmDropFlag;
    }

    /**
     * 获取创建时间
     *
     * @return dm_create_time - 创建时间
     */
    public Date getDmCreateTime() {
        return dmCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param dmCreateTime 创建时间
     */
    public void setDmCreateTime(Date dmCreateTime) {
        this.dmCreateTime = dmCreateTime;
    }

    /**
     * 获取更新时间
     *
     * @return dm_update_time - 更新时间
     */
    public Date getDmUpdateTime() {
        return dmUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param dmUpdateTime 更新时间
     */
    public void setDmUpdateTime(Date dmUpdateTime) {
        this.dmUpdateTime = dmUpdateTime;
    }

    /**
     * 获取非运营类型,关联数据字典D45-value
     *
     * @return dm_non_type - 非运营类型,关联数据字典D45-value
     */
    public String getDmNonType() {
        return dmNonType;
    }

    /**
     * 设置非运营类型,关联数据字典D45-value
     *
     * @param dmNonType 非运营类型,关联数据字典D45-value
     */
    public void setDmNonType(String dmNonType) {
        this.dmNonType = dmNonType;
    }
}