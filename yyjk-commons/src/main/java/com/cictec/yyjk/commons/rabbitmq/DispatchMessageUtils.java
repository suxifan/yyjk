package com.cictec.yyjk.commons.rabbitmq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.commons.spring.utils.SpringContextHolder;
import com.cictec.yyjk.commons.utils.PropertiesUtils;

/**
 * 消息交互接口： 下发消息至车辆 服务内部业务交互
 * 
 * @author Administrator
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DispatchMessageUtils {

	/** 调度业务 交换机名称 */
//	public static String Exchange_dispatch = "test.dispatch";
	public static String Exchange_dispatch = PropertiesUtils.getString("rabbitmq.exchange.dispatch", "test.dispatch");
	/** 计算服务 交换机名称 */
//	public static String Exchange_caculate = "test.caculate";
	public static String Exchange_caculate = PropertiesUtils.getString("rabbitmq.exchange.caculate", "test.caculate");
	
	
	/** 对列名 */
	public interface QueueName {
		public final static String notifyWarnHandler = Exchange_dispatch+".notify.warn.handler";
		public final static String notifyApplyHandler = Exchange_dispatch+".notify.apply.handler";
		public final static String notifyBusInfoRefresh = Exchange_dispatch+".notify.businfo.refresh";
		public final static String notifyLineInfoRefresh = Exchange_dispatch+".notify.lineinfo.refresh";
		public final static String notifyDriverInfoRefresh = Exchange_dispatch+".notify.driverinfo.refresh";
		public final static String notifyDeviatePlanRefresh = Exchange_dispatch+".notify.deviate.plan.refresh";
		public final static String notifyFenceRefresh = Exchange_dispatch+".notify.fence.refresh";
		public final static String notifyScheduleRefresh = Exchange_dispatch+".notify.schedule.refresh";
		public final static String notifyBusMileageCaculateReal = Exchange_caculate +".mileage.real";
		public final static String notifyBusMileageCaculateDelay = Exchange_caculate +".mileage.delay";

		public final static String sendBeforeAfterDistanceMessage = Exchange_dispatch+".send.message.before.after.distance";
		public final static String sendBroadcastMessage = Exchange_dispatch+".send.message.broadcast";
		public final static String sendChangeLineMessage = Exchange_dispatch+".send.message.change.line";
		public final static String sendChangeOperateMessage = Exchange_dispatch+".send.message.change.operate";
		public final static String sendDepartureTimeMessage = Exchange_dispatch+".send.message.departure.time";
		public final static String sendUploadReportStationFileMessage = Exchange_dispatch+".send.message.upload.station.file";

	}
	
	
	/** RoutingKey 交换机 路由 绑定关键字 */
	public interface RoutingKey {
		public final static String notifyWarnHandler = QueueName.notifyWarnHandler;
		public final static String notifyApplyHandler = QueueName.notifyApplyHandler;
		public final static String notifyBusInfoRefresh = QueueName.notifyBusInfoRefresh;
		public final static String notifyLineInfoRefresh = QueueName.notifyLineInfoRefresh;
		public final static String notifyDriverInfoRefresh = QueueName.notifyDriverInfoRefresh;
		public final static String notifyDeviatePlanRefresh = QueueName.notifyDeviatePlanRefresh;
		public final static String notifyFenceRefresh = QueueName.notifyFenceRefresh;
		public final static String notifyScheduleRefresh = QueueName.notifyScheduleRefresh;
		public final static String notifyBusMileageCaculateReal = QueueName.notifyBusMileageCaculateReal;
		public final static String notifyBusMileageCaculateDelay = QueueName.notifyBusMileageCaculateDelay;

		public final static String sendBeforeAfterDistanceMessage = QueueName.sendBeforeAfterDistanceMessage;
		public final static String sendBroadcastMessage = QueueName.sendBroadcastMessage;
		public final static String sendChangeLineMessage = QueueName.sendChangeLineMessage;
		public final static String sendChangeOperateMessage = QueueName.sendChangeOperateMessage;
		public final static String sendDepartureTimeMessage = QueueName.sendDepartureTimeMessage;
		public final static String sendUploadReportStationFileMessage = QueueName.sendUploadReportStationFileMessage;
	
	
	}
	private static  AmqpTemplate amqpTemplate;
	private static AmqpTemplate getAmqpTemplate(){
		if(amqpTemplate == null){
			amqpTemplate = SpringContextHolder.getBean("rabbitTemplate");
		}
		return amqpTemplate;

	}
	private static void _convertAndSend(String exchange, String routingKey, Object obj){
		AmqpTemplate amqpTemplate = getAmqpTemplate();
		try {
			amqpTemplate.convertAndSend(exchange, routingKey, JSON.toJSONString(obj));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 广播消息 下发
	 * 
	 * @param busUuid
	 *            车辆UUID
	 * @param content
	 *            广播消息内容 （自定义消息内容，也可通过模板获取）
	 */
	public static void sendBroadcastMessage(String busUuid,   String content,String msgId) {
		// TODO Auto-generated method stub
		
		Map params = new HashMap();
		params.put("busUuid", busUuid);
		params.put("content", content);
		params.put("msgId", msgId);
		params.put("messageType", "1");
		_convertAndSend(Exchange_dispatch, RoutingKey.sendBroadcastMessage, params);
		
	}
	
	/**
	 * 调度指令
	 * 
	 * @param busUuid
	 * @param content
	 * @param msgId
	 */
	public static void sendCommandMessage(String busUuid,   String content,String msgId) {
		// TODO Auto-generated method stub
		
		Map params = new HashMap();
		params.put("busUuid", busUuid);
		params.put("content", content);
		params.put("msgId", msgId);
		params.put("messageType", "7");
		_convertAndSend(Exchange_dispatch, RoutingKey.sendBroadcastMessage, params);
		
	}


	/**
	 * 发车时刻 下发
	 * 
	 * @param lineUuid
	 *            线路UUID
	 * @param busUuid
	 *            车辆UUID
	 * @param content
	 *            内容 【参见】 发车时刻下发模板
	 */
	public static void sendDepartureTimeMessage(String lineUuid, String busUuid, String content) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		params.put("busUuid", busUuid);
		params.put("content", content);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.sendDepartureTimeMessage, params);
	}


	/**
	 * 切换运营线路 下发 根据设备使用协议，例如瑞明
	 * 
	 * @param busUuid
	 *            车辆UUID
	 * @param newDevLineId
	 *            切换后设备线路编号
	 */
	public static void sendChangeLineMessage(String busUuid, String newDevLineId) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("busUuid", busUuid);
		params.put("lineId", newDevLineId);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.sendChangeLineMessage, params);
		
	}


	/**
	 * 切换运营线路 下发
	 * 
	 * @param busUuid
	 *            车辆UUID
	 * @param newDevLineId
	 *            切换回后设备线路编号
	 * @param lineType
	 *            切换回设备线路方向 1：上行 2：下行
	 */
	public static void sendChangeLineMessage(String busUuid, String newDevLineId, String lineType) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("busUuid", busUuid);
		params.put("lineId", newDevLineId);
		params.put("lineType", lineType);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.sendChangeLineMessage, params);
	}


	/**
	 * 切换运营状态 下发
	 * 
	 * @param lineUuid
	 * @param busUuid
	 * @param operCode
	 * @param operDesc
	 */
	public static void sendChangeOperateMessage(String lineUuid, String busUuid, String operCode, String operDesc) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		params.put("busUuid", busUuid);
		params.put("operCode", operCode);
		params.put("operDesc", operDesc);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.sendChangeOperateMessage, params);
		
	}


	/** 报站文件升级指令下发 【参数待定】 */
	public static void sendUploadReportStationFileMessage(Map params) {
		// TODO Auto-generated method stub
//		Map params = new HashMap();
//		params.put("lineUuid", lineUuid);
//		params.put("busUuid", busUuid);
//		params.put("operCode", operCode);
//		params.put("operDesc", operDesc);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.sendUploadReportStationFileMessage, params);
	}


	/**
	 * 车辆前后车距消息下发
	 * 
	 * @param lineUuid
	 * @param busUuid
	 * @param content
	 */
	public static void sendBeforeAfterDistanceMessage(String lineUuid, String busUuid, String content) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		params.put("busUuid", busUuid);
		params.put("content", content);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.sendBeforeAfterDistanceMessage, params);
		
	}


	/** 报警处理结果 消息广播【参数待定】 */
	public static void notifyWarnHandler(Map params) {
		// TODO Auto-generated method stub
//		Map params = new HashMap();
//		params.put("lineUuid", lineUuid);
//		params.put("busUuid", busUuid);
//		params.put("content", content);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyWarnHandler, params);
	}


	/** 调度申请处理结果 消息广播【参数待定】 */
	public static void notifyApplyHandler(Map params) {
		// TODO Auto-generated method stub
//		Map params = new HashMap();
//		params.put("lineUuid", lineUuid);
//		params.put("busUuid", busUuid);
//		params.put("content", content);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyApplyHandler, params);
		
	}


	/**
	 * 车辆信息刷新 消息广播
	 * 
	 * @param busUuid
	 */
	public static void notifyBusInfoRefresh(String busUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("busUuid", busUuid);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyBusInfoRefresh, params);
	}


	/**
	 * 线路信息刷新 消息广播
	 * 
	 * @param lineUuid
	 */
	public static void notifyLineInfoRefresh(String lineUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyBusInfoRefresh, params);
	}


	/**
	 * 司机信息刷新 消息广播
	 * 
	 * @param driverUuid
	 */
	public static void notifyDriverInfoRefresh(String driverUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("driverUuid", driverUuid);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyDriverInfoRefresh, params);
		
	}


	/**
	 * 偏线信息刷新 消息广播
	 * 
	 * @param fenceUuid
	 */
	public static void notifyDeviatePlanRefresh(String lineUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyDeviatePlanRefresh, params);
	}


	/**
	 * 电子围栏信息刷新 消息广播
	 * 
	 * @param fenceUuid
	 */
	public static void notifyFenceRefresh(String fenceUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("fenceUuid", fenceUuid);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyFenceRefresh, params);
	}


	/**
	 * 时刻表刷新 消息广播
	 * 
	 * @param lineUuid
	 *            排班表主表线路UUID
	 */
	public static void notifyScheduleRefresh(String lineUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyScheduleRefresh, params);
	}


	/**
	 * 时刻表刷新 消息广播 [刷新指定线路、车辆排班信息]
	 * 
	 * @param lineUuid
	 *            排班表主表线路UUID
	 * @param busUuid
	 *            车辆UUID
	 */
	public static void notifyScheduleRefresh(String lineUuid, String busUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		params.put("busUuid", busUuid);
		
		_convertAndSend(Exchange_dispatch, RoutingKey.notifyScheduleRefresh, params);
	}


	/**
	 * 车辆里程重算【实时计算】 消息广播
	 * 
	 * @param lineUuid
	 * @param bsrSid
	 *            计划趟次UUID
	 */
	public static void notifyBusMileageCaculateReal(String lineUuid, String bsrSid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("lineUuid", lineUuid);
		params.put("bsrSid", bsrSid);
		
		_convertAndSend(Exchange_caculate, RoutingKey.notifyBusMileageCaculateReal, params);
	}


	/**
	 * 车辆里程重算【延时计算】 消息广播
	 * 
	 * @param date
	 *            指定日志（计划排班日期 YYYY-MM-DD）
	 * @param lineUuid
	 *            指定线路（可为null, 为空默认按照GPS线路信息）
	 * @param busUuid
	 *            车辆UUID
	 */
	public static void notifyBusMileageCaculateDelay(String date, String lineUuid, String busUuid) {
		// TODO Auto-generated method stub
		Map params = new HashMap();
		params.put("date", date);
		params.put("lineUuid", lineUuid);
		params.put("busUuid", busUuid);

		_convertAndSend(Exchange_caculate, RoutingKey.notifyBusMileageCaculateDelay, params);
	}
	
}
