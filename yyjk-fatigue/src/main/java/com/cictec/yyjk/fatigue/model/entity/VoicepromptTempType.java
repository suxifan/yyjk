package com.cictec.yyjk.fatigue.model.entity;

import javax.persistence.*;

@Table(name = "dw_voiceprompt_temp_type")
public class VoicepromptTempType {
    /**
     * 主键
     */
    @Id
    @Column(name = "voicetemp_type_uuid")
    private String voicetempTypeUuid;

    /**
     * 消息内容
     */
    @Column(name = "voicetemp_content")
    private String voicetempContent;

    /**
     * 消息类型code
     */
    @Column(name = "voicetemp_type_code")
    private String voicetempTypeCode;

    /**
     * 获取主键
     *
     * @return voicetemp_type_uuid - 主键
     */
    public String getVoicetempTypeUuid() {
        return voicetempTypeUuid;
    }

    /**
     * 设置主键
     *
     * @param voicetempTypeUuid 主键
     */
    public void setVoicetempTypeUuid(String voicetempTypeUuid) {
        this.voicetempTypeUuid = voicetempTypeUuid;
    }

    /**
     * 获取消息内容
     *
     * @return voicetemp_content - 消息内容
     */
    public String getVoicetempContent() {
        return voicetempContent;
    }

    /**
     * 设置消息内容
     *
     * @param voicetempContent 消息内容
     */
    public void setVoicetempContent(String voicetempContent) {
        this.voicetempContent = voicetempContent;
    }

    /**
     * 获取消息类型code
     *
     * @return voicetemp_type_code - 消息类型code
     */
    public String getVoicetempTypeCode() {
        return voicetempTypeCode;
    }

    /**
     * 设置消息类型code
     *
     * @param voicetempTypeCode 消息类型code
     */
    public void setVoicetempTypeCode(String voicetempTypeCode) {
        this.voicetempTypeCode = voicetempTypeCode;
    }
}