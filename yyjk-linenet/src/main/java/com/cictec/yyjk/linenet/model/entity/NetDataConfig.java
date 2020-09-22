package com.cictec.yyjk.linenet.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "net_data_config")
public class NetDataConfig {
    /**
     * 唯一ID
     */
    @Id
    private String uuid;

    /**
     * 配置文件名称
     */
    @Column(name = "config_name")
    private String configName;

    /**
     * 配置文件内容
     */
    @Column(name = "config_file")
    private String configFile;

    /**
     * 配置文件更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取唯一ID
     *
     * @return uuid - 唯一ID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置唯一ID
     *
     * @param uuid 唯一ID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取配置文件名称
     *
     * @return config_name - 配置文件名称
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 设置配置文件名称
     *
     * @param configName 配置文件名称
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * 获取配置文件内容
     *
     * @return config_file - 配置文件内容
     */
    public String getConfigFile() {
        return configFile;
    }

    /**
     * 设置配置文件内容
     *
     * @param configFile 配置文件内容
     */
    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    /**
     * 获取配置文件更新时间
     *
     * @return update_time - 配置文件更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置配置文件更新时间
     *
     * @param updateTime 配置文件更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}