package com.cictec.yyjk.fatigue.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.sid.SidUtils;
import com.cictec.yyjk.fatigue.mapper.TVoicepromptMapper;
import com.cictec.yyjk.fatigue.model.entity.Voiceprompt;
import com.cictec.yyjk.fatigue.service.TVoicePromptService;

/**
 * Created by on 2019/05/22.
 */
@Service
@Transactional
public class TVoicePromptServiceImpl extends AbstractService<Voiceprompt> implements TVoicePromptService {
	@Resource(name = "AmqpTemplateTwo")
	private AmqpTemplate rabbitTemplate;
	@Autowired
	private TVoicepromptMapper tVoicepromptMapper;
	@Value("${rabbitmq2.exchange.name}")
	private String exchange;
	@Value("${rabbitmq2.send.queue}")
	private String queue;
	@Resource
	private BusService busService;

	@SuppressWarnings("rawtypes")
	@Override
	public void sendVoiceprompt(Map map) {
		map.remove("sendType");
		map.remove("devType");
		rabbitTemplate.convertAndSend(exchange, queue, JSON.toJSONString(map));
		Voiceprompt voiceprompt = new Voiceprompt();
		voiceprompt.setVoicepromptUuid(SidUtils.getSid());
		voiceprompt.setBusUuid((String) map.get("busUuid"));
		voiceprompt.setSendTime(new Date());
		voiceprompt.setMessageClass("send");
		voiceprompt.setVoicepromptContent((String) map.get("content"));
		voiceprompt.setMessageType("1");
		tVoicepromptMapper.insert(voiceprompt);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void sendVoicepromptBatch(Map map) {
		String busUuid = (String) map.get("busUuids");
		map.remove("busUuids");
		map.remove("sendType");
		map.remove("devType");
		map.remove("personId");
		String[] ids = busUuid.split(",");
		for (int i = 0; i < ids.length; i++) {
			map.put("busUuid", ids[i]);
			rabbitTemplate.convertAndSend(exchange, queue, JSON.toJSONString(map));
			Voiceprompt voiceprompt = new Voiceprompt();
			voiceprompt.setVoicepromptUuid(SidUtils.getSid());
			voiceprompt.setBusUuid(ids[i]);
			voiceprompt.setSendTime(new Date());
			voiceprompt.setMessageClass("send");
			voiceprompt.setVoicepromptContent((String) map.get("content"));
			voiceprompt.setMessageType("1");
			tVoicepromptMapper.insert(voiceprompt);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void sendAllVoicepromptBatch(Map map) {
		List<Map<String, String>> busOrgs = busService.getBusOrgInfo();
		String[] busIds = new String[busOrgs.size()];
		for (int i = 0; i < busOrgs.size(); i++) {
			String busUuid = busOrgs.get(i).get("busuuid");
			busIds[i] = busUuid;
		}
		String filterBusUuid = (String) map.get("filterBusUuids");
		map.remove("busUuids");
		map.remove("filterBusUuids");
		map.remove("sendType");
		map.remove("devType");
		map.remove("personId");
		String[] filterIds = null;
		if (filterBusUuid != null) {
			filterIds = filterBusUuid.split(",");
		}
		for (int i = 0; i < busIds.length; i++) {
			String busUuid = busIds[i];
			map.put("busUuid", busUuid);
			// 过滤
			if (!ArrayUtils.contains(filterIds, busUuid)) {
				rabbitTemplate.convertAndSend(exchange, queue, JSON.toJSONString(map));
				Voiceprompt voiceprompt = new Voiceprompt();
				voiceprompt.setVoicepromptUuid(SidUtils.getSid());
				voiceprompt.setBusUuid(busIds[i]);
				voiceprompt.setSendTime(new Date());
				voiceprompt.setMessageClass("send");
				voiceprompt.setVoicepromptContent((String) map.get("content"));
				voiceprompt.setMessageType("1");
				tVoicepromptMapper.insert(voiceprompt);
			}
		}

	}
}
