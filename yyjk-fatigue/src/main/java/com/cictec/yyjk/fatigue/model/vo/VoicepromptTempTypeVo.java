package com.cictec.yyjk.fatigue.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;

/**
 * 值对象 Created by xpguo on 2020/07/21.
 */
public class VoicepromptTempTypeVo extends AbstractVo {
	private String voicetempTypeUuid;

	private String voicetempTypeCode;

	private String voicetempContent;

	private String voicetempUuid;

	private String voicetempMessageContent;

	public String getVoicetempMessageContent() {
		return voicetempMessageContent;
	}

	public void setVoicetempMessageContent(String voicetempMessageContent) {
		this.voicetempMessageContent = voicetempMessageContent;
	}

	public String getVoicetempUuid() {
		return voicetempUuid;
	}

	public void setVoicetempUuid(String voicetempUuid) {
		this.voicetempUuid = voicetempUuid;
	}

	public String getVoicetempTypeUuid() {
		return voicetempTypeUuid;
	}

	public void setVoicetempTypeUuid(String voicetempTypeUuid) {
		this.voicetempTypeUuid = voicetempTypeUuid;
	}

	public String getVoicetempTypeCode() {
		return voicetempTypeCode;
	}

	public void setVoicetempTypeCode(String voicetempTypeCode) {
		this.voicetempTypeCode = voicetempTypeCode;
	}

	public String getVoicetempContent() {
		return voicetempContent;
	}

	public void setVoicetempContent(String voicetempContent) {
		this.voicetempContent = voicetempContent;
	}

}
