package com.cictec.yyjk.report.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.commons.utils.gps.Gps;
import com.cictec.yyjk.commons.utils.gps.GpsSwitchUtils;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.service.TWarnService;
import com.cictec.yyjk.report.mapper.PassengerFlowMapper;
import com.cictec.yyjk.report.model.entity.PassengerFlow;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.HeatmapVo;
import com.cictec.yyjk.report.model.vo.PassengerFlowVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.WarnDetailInfoVo;
import com.cictec.yyjk.report.service.PassengerFlowService;
import com.cictec.yyjk.timingtask.model.entity.AnalysisFullloadDay;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPassengerFlowMonthTrend;
import com.cictec.yyjk.timingtask.model.entity.PassengerFlowResult;
import com.cictec.yyjk.timingtask.service.AnalysisFullloadDayService;
import com.cictec.yyjk.timingtask.service.AnalysisPassengerFlowMonthTrendService;
import com.cictec.yyjk.timingtask.service.PassengerFlowResultService;

@Service
@Transactional
public class PassengerFlowServiceImpl extends AbstractService<PassengerFlow> implements PassengerFlowService {
	private static final Logger logger = LoggerFactory.getLogger(PassengerFlowServiceImpl.class);
	@Autowired
	private Environment env;
	@Autowired
	private PassengerFlowMapper passengerFlowMapper;
	@Autowired
	private BusService busService;
	@Autowired
	private TWarnService tWarnService;
	@Autowired
	private AnalysisFullloadDayService analysisFullloadDayService;
	@Autowired
	private PassengerFlowResultService passengerFlowResultService;
	@Autowired
	private AnalysisPassengerFlowMonthTrendService analysisPassengerFlowMonthTrendService;
	@Autowired
	private BaseUserInfoService baseUserInfoService;

	@Override
	public PassengerFlowVo getRealTimePersoncountAndFullLoadRate(QueryCondition queryCondition) {
		PassengerFlowVo result = passengerFlowMapper.getRealTimePersoncountAndFullLoadRate(queryCondition);
		if (result == null) {
			PassengerFlowVo bean = new PassengerFlowVo();
			bean.setPersonCount("0");
			return bean;
		}
		return result;
	}

	@Override
	public PassengerFlowVo getTotalPassengerFlow(QueryCondition queryCondition) {
		PassengerFlowVo result = passengerFlowMapper.getTotalPassengerFlow(queryCondition);
		if (result == null) {
			PassengerFlowVo bean = new PassengerFlowVo();
			bean.setPersonCount("0");
			return bean;
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getCompanyTotalPassengerFlow() {
		return passengerFlowMapper.getCompanyTotalPassengerFlow();
	}

	@Override
	public List<PassengerFlowVo> getLineTotalPassengerFlow(QueryCondition queryCondition) {
		List<PassengerFlowVo> result = passengerFlowMapper.getLineTotalPassengerFlow(queryCondition);
		if (result == null) {
			return Collections.emptyList();
		}
		return result;
	}

	@Override
	public List<PassengerFlowVo> getRealTimePassengerFlow(QueryCondition queryCondition) {
		List<PassengerFlowVo> list = passengerFlowMapper.getRealTimePassengerFlow(queryCondition);
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public PassengerFlowVo getYesterdayTotalPassengerFlow(Date startTime, Date endTime, String orgId,
			List<String> lineUuids) throws Exception {
		PassengerFlowVo list = passengerFlowMapper.getYesterdayTotalPassengerFlow(startTime, endTime, orgId, lineUuids);
		if (list == null) {
			PassengerFlowVo bean = new PassengerFlowVo();
			bean.setFullLoadRate("0");
			return bean;
		}
		return list;
	}

	@Override
	public List<PassengerFlowVo> getRealTimeFullLoadRate(QueryCondition queryCondition) {
		List<PassengerFlowVo> list = passengerFlowMapper.getRealTimeFullLoadRate(queryCondition);
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public List<PassengerFlowVo> getRealTimeFullLoadRateTop10(QueryCondition queryCondition) {
		List<PassengerFlowVo> list = passengerFlowMapper.getRealTimeFullLoadRateTop10(queryCondition);
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public List<PassengerFlowVo> getBusFullLoadRate(QueryCondition queryCondition) {
		List<PassengerFlowVo> list = passengerFlowMapper.getBusFullLoadRate(queryCondition);
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public List<HeatmapVo> getBusHeatmapDatas(QueryCondition queryCondition) {
		List<HeatmapVo> list = passengerFlowMapper.getBusHeatmapDatas(queryCondition);
		for (HeatmapVo heatmapVo : list) {
			// gps坐标转换
			String lngStr = heatmapVo.getLng();
			String latStr = heatmapVo.getLat();
			if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
				Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
				heatmapVo.setLng(gps.getWgLon() + "");
				heatmapVo.setLat(gps.getWgLat() + "");
			}
		}
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public WarnDetailInfoVo getDetail(WarnDetailInfoVo warnDetailInfoVo) {
		// 计划总趟次
		String httpUrl = env.getProperty("gjdd.http.url") + "/getBusTrips";
		String httpResult = RestUtils.getPostData(httpUrl, "busUuid=" + warnDetailInfoVo.getBusId(), false);
		logger.info("车辆计划趟次  url:{},param:{},result:{}", httpUrl, "busUuid=" + warnDetailInfoVo.getBusId(), httpResult);
		JSONObject obj = null;
		if (PMSUtils.isNotEmpty(httpResult)) {
			obj = JSON.parseObject(httpResult);
		}
		warnDetailInfoVo.setPlanTrips((obj == null) ? "0" : obj.getString("realTimeTrips"));
		logger.info("getPlanTrips:{}", warnDetailInfoVo.getPlanTrips());
		// 当日累计客流量
		Integer totalPerson = passengerFlowMapper.getTotalPerson(warnDetailInfoVo);
		warnDetailInfoVo.setTotalPersonFlow(totalPerson);
		// 当前趟次客流量
		Integer currentPerson = passengerFlowMapper.getCurrentPerson(warnDetailInfoVo);
		warnDetailInfoVo.setCurrentPersonFlow(currentPerson);
		// 当日车内人数及车辆荷载人数
		PassengerFlowVo bean = passengerFlowMapper.getPersionCountAndLoadNumber(warnDetailInfoVo);
		warnDetailInfoVo.setBusLoadNumber((bean != null) ? Integer.parseInt(bean.getBusLoadNumber()) : 56);
		warnDetailInfoVo.setPersonNumberInCar((bean != null) ? Integer.parseInt(bean.getPersonCount()) : 0);
		// 车辆终端Id
		String devRefId = busService.getBusDevRefId(warnDetailInfoVo.getBusId());
		warnDetailInfoVo.setDevRefId(devRefId);

		// 增加根据用户获取机构，如果是总公司看所有的审核状态的，如果是分公司只看审核属实的
		BaseUserInfo user = baseUserInfoService.selectByPrimaryKey(warnDetailInfoVo.getPersonId());
		List<String> auditStatus = new ArrayList<>();
		List<String> handleResults = new ArrayList<String>();
		if ("1".equals(user.getUserOrgUuid())) {
			auditStatus.add("0");
		} else {
			// 分公司查看已审核并且属实，未处理的报警
			auditStatus.add("1");
			handleResults.add("0");
		}
		// 根据车辆报警设备编号获取视频信息
		List<TWarn> warnInfos = tWarnService.getLimitWarnInfoDetail(warnDetailInfoVo.getWarnDeviceCode(), auditStatus,
				handleResults, null);
		warnDetailInfoVo.setWarnInfos(warnInfos);

		// 计算趟次百分比
		warnDetailInfoVo.setTripPercent();
		// 获取视频流地址
		// List<String> videoPaths =
		// getVideoPath(warnDetailInfoVo.getDevRefId());
		// warnDetailInfoVo.setVideoPaths(videoPaths);
		return warnDetailInfoVo;
	}

	private List<String> getVideoPath(String terid) {
		String baseUrl = env.getProperty("video.baseurl");
		String username = env.getProperty("video.username");
		String password = env.getProperty("video.password");
		logger.info("baseUrl ==={}，terid==={}", baseUrl, terid);
		String key = null;
		try {
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append(baseUrl).append("key?username=").append(username).append("&password=").append(password);
			logger.info("keyUrl ==={}" + urlBuilder.toString());
			String result = RestUtils.getRestData(urlBuilder.toString());
			JSONObject jsonObject = JSON.parseObject(result);
			JSONObject keyObj = (JSONObject) jsonObject.get("data");
			key = keyObj.getString("key");
			logger.info("key ==={}" + key);
		} catch (Exception ex) {
			logger.error("获取key值异常！");
		}
		// http://192.168.10.40:12056/api/v1/basic/live/port?key=123aaeq3jjkljrqweoiu
		List<String> videoUrls = new LinkedList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder();
			urlBuilder.append(baseUrl).append("live/port?key=").append(key);
			String result = RestUtils.getRestData(urlBuilder.toString());
			JSONObject jsonObject = JSON.parseObject(result);
			JSONArray arrays = (JSONArray) jsonObject.get("data");
			String firstPort = ((JSONObject) arrays.get(0)).getString("port");
			String secendPort = ((JSONObject) arrays.get(1)).getString("port");
			// http://192.168.10.40:12056/api/v1/basic/live/video?key=123aaeq3jjkljrqweoiu&terid=00830007CB&chl=1&audio=1&st=0&port=12060
			for (int i = 0; i < 8; i++) {
				StringBuilder videoUrlBuilder = new StringBuilder();
				videoUrlBuilder.append(baseUrl).append("live/video?key=").append(key).append("&terid=").append(terid)
						.append("&audio=1&st=0");
				if (i <= 3) {
					videoUrlBuilder.append("&chl=").append(i).append("&port=").append(firstPort);
				} else {
					videoUrlBuilder.append("&chl=").append(i).append("&port=").append(secendPort);
				}
				videoUrls.add(videoUrlBuilder.toString());
			}
			List<String> results = new LinkedList<>();
			for (String videoUrl : videoUrls) {
				logger.info("videoUrl ==={}" + videoUrl);
				String videoAddrObj = RestUtils.getRestData(videoUrl);
				JSONObject videoObj = JSON.parseObject(videoAddrObj);
				JSONObject urlObj = (JSONObject) videoObj.get("data");
				results.add((String) urlObj.getString("url"));
			}
			return results;
		} catch (Exception ex) {
			logger.error("获取视频流地址异常！");
		}
		return Collections.emptyList();
	}

	@Override
	public GridChartOption createDayOnOffOptions(QueryCondition queryCondition) throws Exception {
		// 数据补全，横坐标为6-22小时数
		List<String> xAxisNames = new ArrayList<>();
		for (int i = 6; i < 23; i++) {
			xAxisNames.add(i + "时");
		}
		// 处理昨日客流等降量
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, -1);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(calender.getTime());
		Date startTime = DateUtils.parseDateTime(date + " 00:00:00");
		Date endTime = DateUtils.parseDateTime(date + " 23:59:59");
		List<AnalysisFullloadDay> yesterdayDatas = analysisFullloadDayService.getYesterdayOnOffLineChartDatas(startTime,
				endTime, queryCondition.getOrgId());
		Map<Integer, AnalysisFullloadDay> yesterdayMap = listToMap(yesterdayDatas);
		// 补全数据
		List<Object> yDatas = new ArrayList<>();
		for (int i = 6; i < 23; i++) {
			if (yesterdayMap.get(i) != null) {
				yDatas.add(yesterdayMap.get(i).getPfrGetOnNumber());
			} else {
				yDatas.add(0);
			}
		}

		// 处理当日客流等降量
		List<AnalysisFullloadDay> todayDatas = analysisFullloadDayService
				.getOnOffLineChartDatas(queryCondition.getOrgId());
		Map<Integer, AnalysisFullloadDay> todayMap = listToMap(todayDatas);
		// 补全数据,今日数据补全到当前系统时间为止
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formart = new SimpleDateFormat("HH");
		Integer hour = Integer.parseInt(formart.format(calendar.getTime()));
		if (hour < 6) {
			hour = 6;
		}
		if (hour > 22) {
			hour = 22;
		}
		List<Object> tDatas = new ArrayList<>();
		for (int i = 6; i <= hour; i++) {
			if (todayMap.get(i) != null) {
				tDatas.add(todayMap.get(i).getPfrGetOnNumber());
			} else {
				tDatas.add(0);
			}
		}

		// 构建图表option
		GridChartOption lineOption = new GridChartOption();
		List<String> legendNames = new ArrayList<>();
		legendNames.add("实时");
		legendNames.add("昨日");
		lineOption.setxAxisNames(xAxisNames);
		List<List<Object>> datas = new ArrayList<>();
		datas.add(tDatas);
		datas.add(yDatas);
		lineOption.setDatas(datas);
		return lineOption;
	}

	/**
	 * 将集合转换为hour为key的字典
	 * 
	 * @param datas
	 * @return
	 */
	private Map<Integer, AnalysisFullloadDay> listToMap(List<AnalysisFullloadDay> datas) {
		Map<Integer, AnalysisFullloadDay> disc = new HashMap<>();
		if (datas != null && datas.size() > 0) {
			for (AnalysisFullloadDay item : datas) {
				Integer hour = item.getUploadTimeHour();
				if (!disc.keySet().contains(hour)) {
					disc.put(hour, item);
				}
			}
		}
		return disc;
	}

	@Override
	public GridChartOption createStationTopTenOptions(QueryCondition queryCondition) throws Exception {
		// 站点uuid是以逗号分隔的站点uuid
		List<String> param = queryCondition.getStaUuids();
		List<String> staUuids = new ArrayList<>();
		if (param != null && param.size() > 0) {
			for (String item : param) {
				if (PMSUtils.isNotEmpty(item)) {
					String[] uuids = item.split(",");
					staUuids.addAll(Arrays.asList(uuids));
				}
			}
		}
		List<PassengerFlowResult> list = passengerFlowResultService.getHortStationTopTen(queryCondition.getOrgId(),
				staUuids, queryCondition.getLineUuids());
		List<String> xAxisNames = new ArrayList<>();
		List<Object> data = new ArrayList<>();
		for (PassengerFlowResult bean : list) {
			xAxisNames.add(bean.getStaName());
			data.add(bean.getPfrGetOnNumber());
		}
		List<List<Object>> datas = new ArrayList<>();
		Collections.reverse(data);
		datas.add(data);

		GridChartOption option = new GridChartOption();
		Collections.reverse(xAxisNames);
		option.setxAxisNames(xAxisNames);
		option.setDatas(datas);
		return option;
	}

	@Override
	public GridChartOption createLineTopTenOptions(QueryCondition queryCondition) throws Exception {
		List<PassengerFlowResult> list = passengerFlowResultService.getHortLineTopTen(queryCondition.getOrgId(),
				queryCondition.getLineUuids());
		List<String> xAxisNames = new ArrayList<>();
		List<Object> data = new ArrayList<>();
		for (PassengerFlowResult bean : list) {
			xAxisNames.add(bean.getPfrLineName());
			data.add(bean.getPfrGetOnNumber());
		}
		List<List<Object>> datas = new ArrayList<>();
		Collections.reverse(data);
		datas.add(data);

		GridChartOption option = new GridChartOption();
		Collections.reverse(xAxisNames);
		option.setxAxisNames(xAxisNames);
		option.setDatas(datas);
		return option;
	}

	@Override
	public GridChartOption createMonthTrendOptions(QueryCondition queryCondition) throws Exception {
		List<AnalysisPassengerFlowMonthTrend> list = new ArrayList<>();
		if (PMSUtils.isNotEmpty(queryCondition.getOrgId())) {
			list = analysisPassengerFlowMonthTrendService.getBranchCompanyMonthTrendDatas(queryCondition.getOrgId());
		} else {
			list = analysisPassengerFlowMonthTrendService.getHeadCompanyMonthTrendDatas();
		}
		List<String> xAxisNames = new ArrayList<>();
		List<Object> data = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (AnalysisPassengerFlowMonthTrend bean : list) {
			xAxisNames.add(format.format(bean.getUploadTimeDate()));
			data.add(bean.getPersonCount());
		}
		PassengerFlowVo passengerFlow = passengerFlowMapper.getTotalPassengerFlow(queryCondition);
		if (passengerFlow != null) {
			xAxisNames.add(passengerFlow.getTimeInterval());
			data.add(Float.parseFloat(passengerFlow.getPersonCount()));
		}

		GridChartOption option = new GridChartOption();
		option.setxAxisNames(xAxisNames);
		List<List<Object>> datas = new ArrayList<>();
		datas.add(data);
		option.setDatas(datas);
		return option;
	}
}
