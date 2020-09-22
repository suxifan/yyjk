package com.cictec.yyjk.fatigue.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConstants {

	public static String exchange_jsxw = "jsxw.platform";

	@Value("${rabbitmq.exchange.jsxw:jsxw.platform}")
	public void setExchangePototocl(String exchangeName) {
		RabbitMqConstants.exchange_jsxw = exchangeName;
	}

	/** 驾驶行为-参数下发默认队列 */
	public static String queue_jsxw_send_params = exchange_jsxw + ".send.params";
	/** 驾驶行为-参数下发默认RoutingKey */
	public static String routing_key_jsxw_send_params = queue_jsxw_send_params;
	
	/** 驾驶行为-参数下发默认队列 */
	public static String queue_jsxw_take_photo = exchange_jsxw + ".take.photo";
	/** 驾驶行为-参数下发默认RoutingKey */
	public static String routing_key_jsxw_take_photo = queue_jsxw_take_photo;
	

	/**
	 * 驾驶行为-参数下发队列* 
	 * @param queneName
	 */
	@Value("${rabbitmq.queue.jsxw.send.params:jsxw.platform.send.params}")
	public void setQueueJsxwPlatformSendParams(String data) {
		RabbitMqConstants.queue_jsxw_send_params = data;
	}

	/** 驾驶行为-参数下发RoutingKey */
	@Value("${rabbitmq.routingKey.jsxw.send.params:jsxw.platform.send.params}")
	public void setRoutingKeyJsxwPlatformSendParams(String data) {
		RabbitMqConstants.routing_key_jsxw_send_params = data;
	}
	
	
	/**
	 * 驾驶行为-设备抓拍队列* 
	 * @param queneName
	 */
	@Value("${rabbitmq.queue.jsxw.take.photo:jsxw.platform.take.photo}")
	public void setQueueJsxwPlatformTakePhoto(String data) {
		RabbitMqConstants.queue_jsxw_take_photo = data;
	}

	/** 驾驶行为-设备抓拍RoutingKey */
	@Value("${rabbitmq.routingKey.jsxw.take.photo:jsxw.platform.stake.photo}")
	public void setRoutingKeyJsxwPlatformTakePhoto(String data) {
		RabbitMqConstants.routing_key_jsxw_take_photo = data;
	}
	
	
}
