package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_index_repeat_company")
public class NetIndexRepeatCompany {
    @Id
    private Integer uuid;

    /**
     * 所属单位
     */
    private String company;

    /**
     * 总站对数
     */
    @Column(name = "sc_count")
    private Short scCount;

    /**
     * 重复站对数
     */
    @Column(name = "repeat_sc_count")
    private Short repeatScCount;

    /**
     * 重复度
     */
    private Float repeatability;

    /**
     * 重复线路排名前三的线路
     */
    private String top3;

    /**
     * @return uuid
     */
    public Integer getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取所属单位
     *
     * @return company - 所属单位
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置所属单位
     *
     * @param company 所属单位
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取总站对数
     *
     * @return sc_count - 总站对数
     */
    public Short getScCount() {
        return scCount;
    }

    /**
     * 设置总站对数
     *
     * @param scCount 总站对数
     */
    public void setScCount(Short scCount) {
        this.scCount = scCount;
    }

    /**
     * 获取重复站对数
     *
     * @return repeat_sc_count - 重复站对数
     */
    public Short getRepeatScCount() {
        return repeatScCount;
    }

    /**
     * 设置重复站对数
     *
     * @param repeatScCount 重复站对数
     */
    public void setRepeatScCount(Short repeatScCount) {
        this.repeatScCount = repeatScCount;
    }

    /**
     * 获取重复度
     *
     * @return repeatability - 重复度
     */
    public Float getRepeatability() {
        return repeatability;
    }

    /**
     * 设置重复度
     *
     * @param repeatability 重复度
     */
    public void setRepeatability(Float repeatability) {
        this.repeatability = repeatability;
    }

    /**
     * 获取重复线路排名前三的线路
     *
     * @return top3 - 重复线路排名前三的线路
     */
    public String getTop3() {
        return top3;
    }

    /**
     * 设置重复线路排名前三的线路
     *
     * @param top3 重复线路排名前三的线路
     */
    public void setTop3(String top3) {
        this.top3 = top3;
    }
}