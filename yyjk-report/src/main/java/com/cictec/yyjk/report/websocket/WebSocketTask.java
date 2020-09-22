package com.cictec.yyjk.report.websocket;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.commons.utils.gps.Gps;
import com.cictec.yyjk.commons.utils.gps.GpsSwitchUtils;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.utils.GetLatAndLngByBaidu;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.service.TempPltwarnService;

@Component
public class WebSocketTask extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(WebSocketTask.class);
	@Autowired
	private TempPltwarnService tempPltwarnService;
	@Autowired
	private BaseUserInfoService baseUserInfoService;

	@SuppressWarnings("static-access")
	@Scheduled(cron = "${jobs.push.warn.datas}")
	public void start() throws Exception {
		// 推送数据
		Map<String, WebSocketServlet> webSockets = WebSocketServlet.getWebSocketMap();
		LOG.info("疲劳报警推送数据开始！");
		if (webSockets != null && webSockets.size() > 0) {
			for (String key : webSockets.keySet()) {
				WebSocketServlet webSocket = webSockets.get(key);
				BaseUserInfo userInfo = baseUserInfoService.selectByPrimaryKey(webSocket.getUserId());
				QueryCondition condition = new QueryCondition();
				condition.setStartTime(DateUtils.getStartDateTime(new Date()));
				condition.setEndTime(DateUtils.getEndDateTime(new Date()));
				String userId = userInfo.getUserId();
				if (!"1".equals(userId)) {
					condition.setOrgId(userInfo.getUserOrgUuid());
				}

				boolean res = hasDataAuthority(userInfo);
				if (!res) {
					webSocket.sendMessage("[]", webSocket.getClientId());
					throw new RuntimeException("用户没有数据权限！");
				} else {
					// 设置用户线路权限
					// List<BusLine> lineAuths =
					// busLineService.getBusLineByUserAuths(userInfo);
					// if (CollectionUtils.isEmpty(lineAuths)) {
					// throw new RuntimeException("用户没有线路权限！");
					// } else {
					// List<String> lineIds = new ArrayList<>();
					// for (BusLine bean : lineAuths) {
					// lineIds.add(bean.getLineUuid());
					// }
					// condition.setLineUuids(lineIds);
					// }
					List<TWarn> result = tempPltwarnService.getNoHandleWarns(condition, userInfo);
					for (TWarn tWarn : result) {
						// gps坐标转换
						String lngStr = tWarn.getLng();
						String latStr = tWarn.getLat();
						if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
							Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
							tWarn.setLng(gps.getWgLon() + "");
							tWarn.setLat(gps.getWgLat() + "");
							// 增加报警地址
							try {
								tWarn.setWarnAddress(
										GetLatAndLngByBaidu.getLocationByBaiduMap(gps.getWgLon(), gps.getWgLat()));
							} catch (Exception e) {
								tWarn.setWarnAddress("暂无地址");
							}
						}
					}
					LOG.info("用户所在机构uuid：{}，推送数据长度：{}", userInfo.getUserOrgUuid(), result.size());
					String message = (result != null && result.size() > 0) ? JSON.toJSONString(result) : "[]";
					webSocket.sendMessage(message, webSocket.getClientId());
				}

			}
			LOG.info("疲劳报警推送数据结束！");
		}
	}
}
