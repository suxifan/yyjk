package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_voiceprompt")
public class Voiceprompt {
	@Id
	@Column(name = "voiceprompt_uuid")
	private String voicepromptUuid;

	@Column(name = "bus_uuid")
	private String busUuid;

	@Column(name = "voiceprompt_content")
	private String voicepromptContent;

	@Column(name = "send_type")
	private String sendType;

	@Column(name = "send_time")
	private Date sendTime;

	
	@Column(name ="message_class")
	private String messageClass;
	
	@Column(name ="message_type")
	private String messageType;
	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getVoicepromptUuid() {
		return voicepromptUuid;
	}

	public void setVoicepromptUuid(String voicepromptUuid) {
		this.voicepromptUuid = voicepromptUuid;
	}

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	public String getVoicepromptContent() {
		return voicepromptContent;
	}

	public void setVoicepromptContent(String voicepromptContent) {
		this.voicepromptContent = voicepromptContent;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}


	public String getMessageClass() {
		return messageClass;
	}

	public void setMessageClass(String messageClass) {
		this.messageClass = messageClass;
	}



}