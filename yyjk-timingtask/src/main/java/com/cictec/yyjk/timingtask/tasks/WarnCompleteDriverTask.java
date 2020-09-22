package com.cictec.yyjk.timingtask.tasks;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.service.DwDimBusDriverService;
import com.cictec.yyjk.fatigue.service.TWarnService;

@Component
public class WarnCompleteDriverTask {
	private static final Logger LOG = LoggerFactory.getLogger(WarnCompleteDriverTask.class);
	@Autowired
	private Environment env;
	@Resource
	private TWarnService tWarnService;

	@Resource
	private DwDimBusDriverService dwDimBusDriverService;

	@Scheduled(cron = "${jobs.schedule.synchro.driver}")
	public void start() {
		try {
			String httpUrl = env.getProperty("gjdd.http.url") + "/getBusPosition";
			String interval = env.getProperty("jobs.schedule.synchro.driver.interval");
			if (PMSUtils.isEmpty(interval)) {
				interval = "3";
			}
			String result = RestUtils.getPostData(httpUrl, "orgId=", false);
			LOG.info("补全报警任务，获取车辆实时位置及车辆满载率 url:{},param:{},result:{}", httpUrl, "orgId=\"\"", result.length());
			JSONArray arrys = null;
			if (PMSUtils.isNotEmpty(result)) {
				arrys = JSON.parseArray(result);
				Map<String, JSONObject> map = listToMap(arrys);
				List<TWarn> warnInfos = tWarnService.getWarnInfo();
				if (warnInfos != null) {
					for (TWarn warnInfo : warnInfos) {
						String busPlateNumber = warnInfo.getBusPlateNumber();
						if (map.containsKey(busPlateNumber) && warnInfo.getWarnTime() != null) {
							Long warnTime = warnInfo.getWarnTime().getTime();
							JSONObject jsonObject = map.get(busPlateNumber);
							String samplingTime = (String) jsonObject.get("samplingTime");
							Date date = DateUtils.parseDateTime(samplingTime);
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(date);
							calendar.add(Calendar.MINUTE, -Integer.parseInt(interval));
							Long first = calendar.getTime().getTime();
							calendar.setTime(date);
							calendar.add(Calendar.MINUTE, Integer.parseInt(interval));
							Long second = calendar.getTime().getTime();
							if (warnTime >= first && warnTime <= second) {
								// 根据司机uuid查询司机编号
								DwDimBusDriver driver = dwDimBusDriverService
										.selectByPrimaryKey((String) jsonObject.get("drvUuid"));
								// 司机工号
								String driverNum = driver.getDrvEmployeeId();
								warnInfo.setDriverIccard(driverNum);

								warnInfo.setDriverName((String) jsonObject.get("drvName"));
								warnInfo.setDriverNum((String) jsonObject.get("drvIccard"));
							}

							// 根据车牌补全线路信息"lineId":"aa5015ec7fad43659442","lineName":"021路"
							warnInfo.setLineUuid((String) jsonObject.get("lineId"));
							warnInfo.setLineName((String) jsonObject.get("lineName"));
							// 更新
							tWarnService.updateByPrimaryKeySelective(warnInfo);
						}
					}
				}
			}
		} catch (Exception ex) {
			LOG.error("API耗时任务执行失败！错误信息：{}", ex);
		}
	}

	/**
	 * 转换为车牌号为key的map
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, JSONObject> listToMap(JSONArray list) {
		Map<String, JSONObject> map = new HashMap<>();
		Iterator<Object> iterator = list.iterator();
		while (iterator.hasNext()) {
			JSONObject next = (JSONObject) iterator.next();
			String key = next.getString("busNumber");
			map.put(key, next);
		}
		return map;
	}
}
