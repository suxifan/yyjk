package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_index_dea_linescore")
public class NetIndexDeaLinescore {
    @Id
    private Integer uuid;

    /**
     * 线路号
     */
    @Column(name = "line_number")
    private String lineNumber;

    /**
     * 站位设置合理性评分
     */
    @Column(name = "sta_rational")
    private Float staRational;

    /**
     * 舒适性评分
     */
    @Column(name = "safe_rational")
    private Float safeRational;

    /**
     * 便捷性评分
     */
    @Column(name = "con_rational")
    private Float conRational;

    /**
     * 快捷性评分
     */
    @Column(name = "rap_rational")
    private Float rapRational;

    /**
     * 总评分
     */
    private Float score;

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
     * 获取线路号
     *
     * @return line_number - 线路号
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * 设置线路号
     *
     * @param lineNumber 线路号
     */
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * 获取站位设置合理性评分
     *
     * @return sta_rational - 站位设置合理性评分
     */
    public Float getStaRational() {
        return staRational;
    }

    /**
     * 设置站位设置合理性评分
     *
     * @param staRational 站位设置合理性评分
     */
    public void setStaRational(Float staRational) {
        this.staRational = staRational;
    }

    /**
     * 获取舒适性评分
     *
     * @return safe_rational - 舒适性评分
     */
    public Float getSafeRational() {
        return safeRational;
    }

    /**
     * 设置舒适性评分
     *
     * @param safeRational 舒适性评分
     */
    public void setSafeRational(Float safeRational) {
        this.safeRational = safeRational;
    }

    /**
     * 获取便捷性评分
     *
     * @return con_rational - 便捷性评分
     */
    public Float getConRational() {
        return conRational;
    }

    /**
     * 设置便捷性评分
     *
     * @param conRational 便捷性评分
     */
    public void setConRational(Float conRational) {
        this.conRational = conRational;
    }

    /**
     * 获取快捷性评分
     *
     * @return rap_rational - 快捷性评分
     */
    public Float getRapRational() {
        return rapRational;
    }

    /**
     * 设置快捷性评分
     *
     * @param rapRational 快捷性评分
     */
    public void setRapRational(Float rapRational) {
        this.rapRational = rapRational;
    }

    /**
     * 获取总评分
     *
     * @return score - 总评分
     */
    public Float getScore() {
        return score;
    }

    /**
     * 设置总评分
     *
     * @param score 总评分
     */
    public void setScore(Float score) {
        this.score = score;
    }
}