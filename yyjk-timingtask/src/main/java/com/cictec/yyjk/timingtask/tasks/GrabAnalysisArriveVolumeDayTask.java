package com.cictec.yyjk.timingtask.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.model.vo.BusLineStationVo;
import com.cictec.yyjk.base.model.vo.BusLineVo;
import com.cictec.yyjk.base.service.BusLineService;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.timingtask.model.entity.AnalysisArriveVolumeDay;
import com.cictec.yyjk.timingtask.service.AnalysisArriveVolumeDayService;

/**
 * 抓取到站数据任务类（通过Http获取前一天到站数据）
 * 
 */
// @Component
public class GrabAnalysisArriveVolumeDayTask {
	private static Logger LOG = LoggerFactory.getLogger(GrabAnalysisArriveVolumeDayTask.class);
	@Autowired
	private Environment env;

	@Autowired
	private BusLineService busLineService;

	@Autowired
	private AnalysisArriveVolumeDayService analysisArriveVolumeDayService;

	/**
	 * 按线路获取车辆到站时刻信息(获取前一天数据)
	 * 
	 * http://117.34.118.30:9082/base/getBusToStationInfo?lineId=0137&dateTime=
	 * 2018-07-07
	 */
	@Scheduled(cron = "${jobs.schedule.dispatch.arrivestation.grab}")
	public void start() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String dateTime = DateUtils.formatDate(calendar.getTime());
		List<BusLineVo> list = busLineService.getAllBusLines();
		StringBuilder builder = new StringBuilder();
		for (BusLineVo item : list) {
			builder.append("dateTime=").append(dateTime);
			builder.append("&lineId=").append(item.getLineId());
			String httpUrl = env.getProperty("gjdd.http.url") + "/getBusToStationInfo";
			String result = RestUtils.getPostData(httpUrl, builder.toString(), false);
			LOG.info("按线路获取车辆到站时刻信息 url:{},params:{},result:{}", httpUrl, builder.toString(), result.length());
			// 清除查询参数
			builder.delete(0, builder.length());
			if (PMSUtils.isNotEmpty(result)) {
				JSONArray arrys = JSON.parseArray(result);
				List<AnalysisArriveVolumeDay> completeList = completeBusStationInfo(arrys);
				// LOG.info("completeList:{}", completeList);
				if (completeList != null && completeList.size() > 0) {
					int pageSize = 1000;
					int total = completeList.size();
					try {
						if (total <= pageSize) {
							analysisArriveVolumeDayService.insertList(completeList);
						} else {
							int pages = (total % pageSize) == 0 ? (total / pageSize) : (total / pageSize + 1);
							int currentPage = 1;
							while (currentPage <= pages) {
								int startIndex = (currentPage - 1) * pageSize;
								int endIndex = (currentPage * pageSize) > total ? total : (currentPage * pageSize);
								analysisArriveVolumeDayService.insertList(completeList.subList(startIndex, endIndex));
								currentPage++;
							}
						}
					} catch (Exception ex) {
						LOG.error("获取车辆到站时刻信息(日报)插入数据失败！{}", ex);
					}
				}
			}
		}
	}

	public List<AnalysisArriveVolumeDay> completeBusStationInfo(JSONArray arrys) {
		if (arrys == null || (arrys != null && arrys.size() == 0)) {
			return Collections.emptyList();
		}
		List<AnalysisArriveVolumeDay> list = new ArrayList<>();
		Map<String, BusLineVo> lineInfoMap = this.getBusLines();
		Map<String, BusLineStationVo> lineStationInfoMap = this.getBusLineStations();
		if (arrys != null && !arrys.isEmpty()) {
			Iterator<Object> iterator = arrys.iterator();
			while (iterator.hasNext()) {
				String next = JSON.toJSONString(iterator.next());
				JSONObject obj = JSON.parseObject(next);
				AnalysisArriveVolumeDay busToStationInfo = JSON.parseObject(next, AnalysisArriveVolumeDay.class);
				busToStationInfo.setBusPlateNumber(obj.getString("busNumber"));
				busToStationInfo.setStaSeq(obj.getString("staSequence"));
				// 根据lineUuid反查orgName、orgUuid
				BusLineVo busLine = lineInfoMap.get(busToStationInfo.getLineUuid());
				busToStationInfo.setOrgUuid((busLine != null) ? busLine.getOrgId() : null);
				busToStationInfo.setOrgName((busLine != null) ? busLine.getOrgName() : null);
				// 根据站名和站序反查站id
				String key = busToStationInfo.getStaName() + busToStationInfo.getStaSeq();
				BusLineStationVo busLineStationVo = lineStationInfoMap.get(key);
				busToStationInfo.setStaUuid((busLineStationVo != null) ? busLineStationVo.getStaUuid() : null);
				// 从到站时间生成小时，没有到站时间按出站时间，两者都没有则为null
				Date date = (busToStationInfo.getUploadTimeIn() == null) ? busToStationInfo.getUploadTimeOut()
						: busToStationInfo.getUploadTimeIn();
				if (date != null) {
					busToStationInfo.setUploadTimeHour(Short.valueOf(DateUtils.formatHour(date)));
				} else {
					busToStationInfo.setUploadTimeHour(null);
				}
				list.add(busToStationInfo);
			}
		}
		return list;
	}

	/**
	 * 获取线路信息，并转化为key为lineId的map
	 * 
	 * @return
	 */
	private Map<String, BusLineVo> getBusLines() {
		List<BusLineVo> lineInfos = busLineService.getAllBusLines();
		Map<String, BusLineVo> map = new HashMap<>();
		for (BusLineVo lineInfo : lineInfos) {
			String key = lineInfo.getLineId();
			if (!map.containsKey(key)) {
				map.put(key, lineInfo);
			}
		}
		return map;
	}

	/**
	 * 获取所有线路站点信息，并转化为key为站名+站序的map
	 * 
	 * @return
	 */
	private Map<String, BusLineStationVo> getBusLineStations() {
		List<BusLineStationVo> lineInfos = busLineService.getAllLineStations();
		Map<String, BusLineStationVo> map = new HashMap<>();
		for (BusLineStationVo lineStationInfo : lineInfos) {
			String key = lineStationInfo.getStaName() + lineStationInfo.getStaSeq();
			if (!map.containsKey(key)) {
				map.put(key, lineStationInfo);
			}
		}
		return map;
	}
}
