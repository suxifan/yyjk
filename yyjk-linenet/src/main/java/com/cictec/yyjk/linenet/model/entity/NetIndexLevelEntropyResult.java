package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_index_level_entropy_result")
public class NetIndexLevelEntropyResult {
    @Id
    private Integer uuid;

    /**
     * 线路号
     */
    @Column(name = "line_number")
    private String lineNumber;

    /**
     * 线路等级
     */
    @Column(name = "level_name")
    private String levelName;

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
     * 获取线路等级
     *
     * @return level_name - 线路等级
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置线路等级
     *
     * @param levelName 线路等级
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}