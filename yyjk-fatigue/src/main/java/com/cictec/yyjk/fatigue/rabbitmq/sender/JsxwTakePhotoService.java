package com.cictec.yyjk.fatigue.rabbitmq.sender;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.fatigue.utils.RabbitMqConstants;

@Service
public class JsxwTakePhotoService {
	public Logger logger = LoggerFactory.getLogger(getClass());

	@Resource(name = "amqpTemplate")
	private AmqpTemplate amqpTemplate;

	/**
	 * 下发设备主动抓拍配置信息
	 * 
	 * @param dto
	 */
	public void takeJsxwPhotoTask(Map<String, Object> map) {
		logger.debug("设备抓拍推送MQ{}", JSON.toJSONString(map));
		amqpTemplate.convertAndSend(RabbitMqConstants.exchange_jsxw, RabbitMqConstants.routing_key_jsxw_take_photo,
				JSON.toJSONString(map));
	}

}
