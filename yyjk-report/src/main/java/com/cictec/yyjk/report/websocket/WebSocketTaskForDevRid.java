// package com.cictec.yyjk.report.websocket;
//
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
// import java.util.Map;
//
// import org.apache.commons.collections.CollectionUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Component;
//
// import com.alibaba.fastjson.JSON;
// import com.cictec.yyjk.base.api.BaseController;
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
// public class WebSocketTaskForDevRid extends BaseController {
// private static final Logger LOG =
// LoggerFactory.getLogger(WebSocketTaskForDevRid.class);
// @Autowired
// private TSafeDeviceRidControlService tSafeDeviceRidControlService;
// @Autowired
// private BaseUserInfoService baseUserInfoService;
// @Autowired
// private BusLineService busLineService;
//
// @SuppressWarnings("static-access")
// @Scheduled(cron = "${jobs.push.rid.control.datas}")
// public void start() throws Exception {
// // 推送数据
// Map<String, WebSocketServletForDevRid> webSockets =
// WebSocketServletForDevRid.getWebSocketMap();
// LOG.info("脱管报警弹出框推送数据开始！");
// if (webSockets != null && webSockets.size() > 0) {
// for (String key : webSockets.keySet()) {
// WebSocketServletForDevRid webSocket = webSockets.get(key);
// BaseUserInfo userInfo =
// baseUserInfoService.selectByPrimaryKey(webSocket.getUserId());
// TSafeDeviceRidControlVo vo = new TSafeDeviceRidControlVo();
// vo.setStartTime(DateUtils.getStartDateTime(new Date()));
// vo.setEndTime(DateUtils.getEndDateTime(new Date()));
// String userId = userInfo.getUserId();
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
// LOG.info("用户所在机构uuid：{}，推送数据长度：{}", userInfo.getUserOrgUuid(),
// result.size());
// String message = (result != null && result.size() > 0) ?
// JSON.toJSONString(result) : "[]";
// webSocket.sendMessage(message, webSocket.getClientId());
// }
// LOG.info("脱管报警弹出框推送数据结束！");
// }
// }
// }
