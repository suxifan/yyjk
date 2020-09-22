// package com.cictec.yyjk.report.websocket;
//
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.List;
// import java.util.Map;
//
// import javax.websocket.OnClose;
// import javax.websocket.OnError;
// import javax.websocket.OnMessage;
// import javax.websocket.OnOpen;
// import javax.websocket.Session;
// import javax.websocket.server.PathParam;
// import javax.websocket.server.ServerEndpoint;
//
// import org.apache.commons.collections.CollectionUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
//
// import com.alibaba.fastjson.JSON;
// import com.alibaba.fastjson.JSONObject;
// import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
// import com.cictec.yyjk.base.model.entity.BaseUserInfo;
// import com.cictec.yyjk.base.model.entity.BusLine;
// import com.cictec.yyjk.base.service.BaseUserInfoService;
// import com.cictec.yyjk.base.service.BusLineService;
// import com.cictec.yyjk.commons.utils.DateUtils;
// import com.cictec.yyjk.timingtask.model.viewdata.TSafeDeviceRidControlValue;
// import com.cictec.yyjk.timingtask.model.vo.TSafeDeviceRidControlVo;
// import com.cictec.yyjk.timingtask.service.TSafeDeviceRidControlService;
//
// @Component
// @ServerEndpoint(value = "/websocket/mesgshowfordevrid/{clientId}/{userId}")
// public class WebSocketServletForDevRid {
// private static final Logger LOG =
// LoggerFactory.getLogger(WebSocketServletForDevRid.class);
//
// /**
// * websocket注入失败
// *
// * 因为websocket是多实例单线程的，而websocket中的对象在@Autowried时，只有整个项目启动时会注入，
// * 而之后新的websocket实例都不会再次注入，故websocket上@Autowried的bean是会为null的 websocket
// *
// * 解决方案：静态注入
// *
// * 注入代码也可以写到WebSocketConfig配置文件中去，本类中值保留 静态服务属性static TempPltwarnService
// * tempPltwarnService;
// *
// * @Autowired
// *
// * public void setTempPltwarnService(TempPltwarnService
// * tempPltwarnService) { WebSocketServlet.tempPltwarnService =
// * tempPltwarnService; }
// *
// */
// static TSafeDeviceRidControlService tSafeDeviceRidControlService;
//
// public static TSafeDeviceRidControlService gettSafeDeviceRidControlService()
// {
// return tSafeDeviceRidControlService;
// }
//
// public static void
// settSafeDeviceRidControlService(TSafeDeviceRidControlService
// tSafeDeviceRidControlService) {
// WebSocketServletForDevRid.tSafeDeviceRidControlService =
// tSafeDeviceRidControlService;
// }
//
// static BaseUserInfoService baseUserInfoService;
//
// @Autowired
// public void setBaseUserInfoService(BaseUserInfoService baseUserInfoService) {
// WebSocketServletForDevRid.baseUserInfoService = baseUserInfoService;
// }
//
// static BusLineService busLineService;
//
// @Autowired
// public void setBusLineService(BusLineService busLineService) {
// WebSocketServletForDevRid.busLineService = busLineService;
// }
//
// /**
// * 所有在线的Session
// */
// private static final Map<String, Session> connections =
// Collections.synchronizedMap(new HashMap<String, Session>());
// /**
// * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
// * 在外部可以获取此连接的所有websocket对象，并能对其触发消息发送功能，我们的定时发送核心功能的实现在与此变量
// */
// private static Map<String, WebSocketServletForDevRid> webSocketMap =
// Collections
// .synchronizedMap(new HashMap<String, WebSocketServletForDevRid>());
//
// /**
// * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
// */
// private static int onlineCount = 0;
//
// private Session session;
//
// private String clientId;
//
// private String userId;
//
// public WebSocketServletForDevRid() {
// super();
// }
//
// public WebSocketServletForDevRid(Session session, String clientId, String
// userId) {
// super();
// this.session = session;
// this.clientId = clientId;
// this.userId = userId;
// }
//
// @OnOpen
// public void onOpen(@PathParam(value = "clientId") String clientId,
// @PathParam(value = "userId") String userId,
// Session session) {
// try {
// this.session = session;
// this.clientId = clientId;
// connections.put(clientId, session);
// webSocketMap.put(clientId, new WebSocketServletForDevRid(session, clientId,
// userId));
// addOnlineCount();
// LOG.info("开始监听:" + clientId + ",当前在线人数为" + getOnlineCount());
// // 重置查询条件
// BaseUserInfo userInfo = baseUserInfoService.selectByPrimaryKey(userId);
// TSafeDeviceRidControlVo vo = new TSafeDeviceRidControlVo();
// vo.setStartTime(DateUtils.getStartDateTime(new Date()));
// vo.setEndTime(DateUtils.getEndDateTime(new Date()));
// if (!"1".equals(userId)) {
// vo.setOrgUuid(userInfo.getUserOrgUuid());
// }
// // 设置用户线路权限
// List<BusLine> lineAuths = busLineService.getBusLineByUserAuths(userInfo);
// if (CollectionUtils.isEmpty(lineAuths)) {
// throw new RuntimeException("用户没有线路权限！");
// } else {
// List<String> lineIds = new ArrayList<>();
// for (BusLine bean : lineAuths) {
// lineIds.add(bean.getLineUuid());
// }
// vo.setLineUuids(lineIds);
// }
// List<TSafeDeviceRidControlValue> result =
// tSafeDeviceRidControlService.getDeviceRidControlData(vo);
// LOG.info("onOpen初始推送：用户所在机构uuid：{}，推送数据长度：{}", userInfo.getUserOrgUuid(),
// result.size());
// String message = (result != null && result.size() > 0) ?
// JSON.toJSONString(result) : "[]";
// // 推送消息
// sendMessage(message, clientId);
// } catch (Exception e) {
// LOG.error("WebSocket链接异常！错误原因：{}", e);
// }
// }
//
// @OnClose
// public void onClose() {
// subOnlineCount();
// connections.remove(this.clientId);
// webSocketMap.remove(this.clientId);
// LOG.info("有一个连接关闭！当前在线人数为" + getOnlineCount());
// }
//
// @OnError
// public void onError(Session session, Throwable t) {
// LOG.error("WebSocket出现错误！{}", t);
// }
//
// @SuppressWarnings("unchecked")
// @OnMessage
// public void onMessage(String message, Session session) {
// try {
// LOG.debug("收到来自客服端{}的信息:{}", this.clientId, message);
// // 发送消息（群发或给某个客服端发）
// HashMap<String, String> hashmap = JSONObject.parseObject(message,
// HashMap.class);
// if (hashmap.get("toid") != null) {
// sendMessage(message, hashmap.get("toid"));
// } else {
// LOG.info("不存在客服端！{}", this.clientId);
// }
// } catch (Exception e) {
// LOG.error("WebSocket发送消息异常！{}", e);
// }
// }
//
// /**
// * 发送消息给指定用户
// *
// * @param message
// * @param userid
// */
// public static void sendMessage(String message, String userid) {
// LOG.info("给用户：{}发送消息：{}", userid, message.length());
// try {
// Session session = connections.get(userid);
// if (session != null) {
// if (session != null && session.isOpen() == true) {
// session.getBasicRemote().sendText(message);
// }
// }
// } catch (Exception e) {
// LOG.error("WebSocket发送同步消息异常！{}", e);
// }
// }
//
// // 给指定用户发送信息
// public static void sendToClient(String message, Session session) {
// session.getAsyncRemote().sendText(message);
// }
//
// /**
// * 群发消息（同步）
// *
// * @param message
// */
// public static void sendMessage(String message) {
// LOG.debug("发送消息：{}", message);
// try {
// Iterator<String> keys = connections.keySet().iterator();
// while (keys.hasNext()) {
// String cid = keys.next();
// Session inbound = (Session) connections.get(cid);
// if (inbound != null && inbound.isOpen()) {
// inbound.getBasicRemote().sendText(message);
// }
// }
// } catch (Exception e) {
// LOG.error("WebSocket发送同步消息异常！{}", e);
// }
// }
//
// /**
// * 群发消息（异步）
// *
// * @param message
// */
// public static void sendSyncMessage(String message) {
// LOG.debug("发送消息：{}", message);
// try {
// Iterator<String> keys = connections.keySet().iterator();
// while (keys.hasNext()) {
// String cid = keys.next();
// Session inbound = (Session) connections.get(cid);
// if (inbound != null && inbound.isOpen()) {
// inbound.getAsyncRemote().sendText(message);
// }
// }
// } catch (Exception e) {
// LOG.error("WebSocket发送异步消息异常！{}", e);
// }
// }
//
// // 判断用户是否在线
// public static Boolean isOnline(String cid) {
// for (String key : connections.keySet()) {
// if (cid.indexOf(key) >= 0) {
// return true;
// }
// }
// return false;
// }
//
// public static synchronized int getOnlineCount() {
// return onlineCount;
// }
//
// public static synchronized int addOnlineCount() {
// return WebSocketServletForDevRid.onlineCount++;
// }
//
// public static synchronized int subOnlineCount() {
// return WebSocketServletForDevRid.onlineCount--;
// }
//
// public static Map<String, Session> getConnections() {
// return connections;
// }
//
// public Session getSession() {
// return session;
// }
//
// public void setSession(Session session) {
// this.session = session;
// }
//
// public String getClientId() {
// return clientId;
// }
//
// public void setClientId(String clientId) {
// this.clientId = clientId;
// }
//
// public String getUserId() {
// return userId;
// }
//
// public void setUserId(String userId) {
// this.userId = userId;
// }
//
// public static Map<String, WebSocketServletForDevRid> getWebSocketMap() {
// return webSocketMap;
// }
//
// public static void setWebSocketMap(Map<String, WebSocketServletForDevRid>
// webSocketMap) {
// WebSocketServletForDevRid.webSocketMap = webSocketMap;
// }
//
// public boolean hasDataAuthority(BaseUserInfo userInfo) {
// List<BaseDataResourceInfo> dataAuths =
// baseUserInfoService.getDataAuthByUserId(userInfo.getUserId());
// if (CollectionUtils.isNotEmpty(dataAuths)) {
// return true;
// } else {
// return false;
// }
// }
//
// }
