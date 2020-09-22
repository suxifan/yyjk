package com.cictec.yyjk.fatigue.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.Voiceprompt;

/**
 * Created by Rwq on 2019/05/22.
 */
public interface TVoicePromptService extends Service<Voiceprompt> {

	/***
	 * 发送语音 下发消息等
	 * 
	 */
	public void sendVoiceprompt(Map map);

	void sendVoicepromptBatch(Map map);

	void sendAllVoicepromptBatch(Map map);
}
