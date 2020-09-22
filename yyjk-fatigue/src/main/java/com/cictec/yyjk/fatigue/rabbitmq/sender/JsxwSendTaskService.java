package com.cictec.yyjk.fatigue.rabbitmq.sender;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.fatigue.utils.RabbitMqConstants;

@Service
public class JsxwSendTaskService {
	public Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	/**
	 * 下发设备参数配置信息
	 * @param dto
	 */
	public void saveJsxwSendTask(Map<String, Object> map) {
		System.out.println(JSON.toJSONString(map));
		amqpTemplate.convertAndSend(RabbitMqConstants.exchange_jsxw, RabbitMqConstants.routing_key_jsxw_send_params, JSON.toJSONString(map));
	}
	
}
