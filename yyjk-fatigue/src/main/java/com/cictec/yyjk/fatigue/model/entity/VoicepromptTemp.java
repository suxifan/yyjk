package com.cictec.yyjk.fatigue.model.entity;

import javax.persistence.*;

@Table(name = "dw_voiceprompt_temp")
public class VoicepromptTemp {
    /**
     * 主键
     */
    @Id
    @Column(name = "voicetemp_uuid")
    private String voicetempUuid;

    /**
     * 消息内容
     */
    @Column(name = "voicetemp_message_content")
    private String voicetempMessageContent;

    /**
     * 消息类型
     */
    @Column(name = "voicetemp_type_uuid")
    private String voicetempTypeUuid;

    /**
     * 获取主键
     *
     * @return voicetemp_uuid - 主键
     */
    public String getVoicetempUuid() {
        return voicetempUuid;
    }

    /**
     * 设置主键
     *
     * @param voicetempUuid 主键
     */
    public void setVoicetempUuid(String voicetempUuid) {
        this.voicetempUuid = voicetempUuid;
    }

    /**
     * 获取消息内容
     *
     * @return voicetemp_message_content - 消息内容
     */
    public String getVoicetempMessageContent() {
        return voicetempMessageContent;
    }

    /**
     * 设置消息内容
     *
     * @param voicetempMessageContent 消息内容
     */
    public void setVoicetempMessageContent(String voicetempMessageContent) {
        this.voicetempMessageContent = voicetempMessageContent;
    }

    /**
     * 获取消息类型
     *
     * @return voicetemp_type_uuid - 消息类型
     */
    public String getVoicetempTypeUuid() {
        return voicetempTypeUuid;
    }

    /**
     * 设置消息类型
     *
     * @param voicetempTypeUuid 消息类型
     */
    public void setVoicetempTypeUuid(String voicetempTypeUuid) {
        this.voicetempTypeUuid = voicetempTypeUuid;
    }
}