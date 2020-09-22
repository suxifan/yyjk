package com.cictec.yyjk.fatigue.model.entity;

import javax.persistence.*;

@Table(name = "dw_dim_pl_sys_datadict")
public class TSysDatadict {
    /**
     * 主键
     */
    @Id
    @Column(name = "pl_uuid")
    private String plUuid;

    /**
     * 编码值（同一编码code内，不能重复）
     */
    @Column(name = "pl_value")
    private String plValue;

    /**
     * 显示值
     */
    @Column(name = "pl_display")
    private String plDisplay;

    /**
     * 显示顺序
     */
    @Column(name = "pl_sort")
    private Short plSort;

    /**
     * 状态（1：启用  0：禁用）
     */
    @Column(name = "pl_isvalid")
    private String plIsvalid;

    /**
     * 报警类型
     */
    @Column(name = "pl_warn_level")
    private String plWarnLevel;

    /**
     * 备注
     */
    @Column(name = "pl_remark")
    private String plRemark;

    /**
     * 获取主键
     *
     * @return pl_uuid - 主键
     */
    public String getPlUuid() {
        return plUuid;
    }

    /**
     * 设置主键
     *
     * @param plUuid 主键
     */
    public void setPlUuid(String plUuid) {
        this.plUuid = plUuid;
    }

    /**
     * 获取编码值（同一编码code内，不能重复）
     *
     * @return pl_value - 编码值（同一编码code内，不能重复）
     */
    public String getPlValue() {
        return plValue;
    }

    /**
     * 设置编码值（同一编码code内，不能重复）
     *
     * @param plValue 编码值（同一编码code内，不能重复）
     */
    public void setPlValue(String plValue) {
        this.plValue = plValue;
    }

    /**
     * 获取显示值
     *
     * @return pl_display - 显示值
     */
    public String getPlDisplay() {
        return plDisplay;
    }

    /**
     * 设置显示值
     *
     * @param plDisplay 显示值
     */
    public void setPlDisplay(String plDisplay) {
        this.plDisplay = plDisplay;
    }

    /**
     * 获取显示顺序
     *
     * @return pl_sort - 显示顺序
     */
    public Short getPlSort() {
        return plSort;
    }

    /**
     * 设置显示顺序
     *
     * @param plSort 显示顺序
     */
    public void setPlSort(Short plSort) {
        this.plSort = plSort;
    }

    /**
     * 获取状态（1：启用  0：禁用）
     *
     * @return pl_isvalid - 状态（1：启用  0：禁用）
     */
    public String getPlIsvalid() {
        return plIsvalid;
    }

    /**
     * 设置状态（1：启用  0：禁用）
     *
     * @param plIsvalid 状态（1：启用  0：禁用）
     */
    public void setPlIsvalid(String plIsvalid) {
        this.plIsvalid = plIsvalid;
    }

    /**
     * 获取报警类型
     *
     * @return pl_warn_level - 报警类型
     */
    public String getPlWarnLevel() {
        return plWarnLevel;
    }

    /**
     * 设置报警类型
     *
     * @param plWarnLevel 报警类型
     */
    public void setPlWarnLevel(String plWarnLevel) {
        this.plWarnLevel = plWarnLevel;
    }

    /**
     * 获取备注
     *
     * @return pl_remark - 备注
     */
    public String getPlRemark() {
        return plRemark;
    }

    /**
     * 设置备注
     *
     * @param plRemark 备注
     */
    public void setPlRemark(String plRemark) {
        this.plRemark = plRemark;
    }
}