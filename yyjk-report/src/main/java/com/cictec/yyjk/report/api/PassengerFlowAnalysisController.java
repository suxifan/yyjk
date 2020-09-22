package com.cictec.yyjk.report.api;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseBusVideoInfo;
import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.view.BusLineView;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.base.service.BaseBusVideoInfoService;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BusLineService;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.commons.utils.gps.Gps;
import com.cictec.yyjk.commons.utils.gps.GpsSwitchUtils;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.service.DwDimBusDriverService;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.HeatmapVo;
import com.cictec.yyjk.report.model.vo.PassengerFlowVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.WarnInofVo;
import com.cictec.yyjk.report.service.PassengerFlowService;
import com.cictec.yyjk.report.service.TempPltwarnService;
import com.github.pagehelper.util.StringUtil;

/**
 * 客流相数据分析控制类
 * 
 * @author gxp
 *
 */
@RestController
@RequestMapping(value = "/zhfxpt/")
public class PassengerFlowAnalysisController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(PassengerFlowAnalysisController.class);
	@Autowired
	private Environment env;
	@Autowired
	private BusLineService busLineService;
	@Autowired
	private BusService busService;
	@Autowired
	private PassengerFlowService passengerFlowService;
	@Autowired
	private TempPltwarnService tempPltwarnService;
	@Autowired
	private BaseBusVideoInfoService baseBusVideoInfoService;
	@Autowired
	private BaseUserInfoService baseUserInfoService;
	@Autowired
	private DwDimBusDriverService dwDimBusDriverService;

	/**
	 * 总实时载客（人）、实时满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getRealTimePersoncountAndFullLoadRate")
	public Result getRealTimePersoncountAndFullLoadRate(@RequestBody QueryCondition queryCondition) {
		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		PassengerFlowVo passengerFlow = passengerFlowService.getRealTimePersoncountAndFullLoadRate(queryCondition);
		if (passengerFlow == null) {
			return ResultUtil.getSuccessResult(new PassengerFlowVo());
		}
		return ResultUtil.getSuccessResult(passengerFlow);
	}

	/**
	 * 当日机构累计客流
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "passengerflow/getCompanyTotalPassengerFlow")
	public Result getCompanyTotalPassengerFlow(@RequestBody Map<String, Object> paramMap) {
		List<Map> passengerFlow = passengerFlowService.getCompanyTotalPassengerFlow();
		return ResultUtil.getSuccessResult(passengerFlow);
	}

	/**
	 * 昨日累计客流（与当前时间同期的昨日客流数据量）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getYesterdayTotalPassengerFlow")
	public Result getYesterdayTotalPassengerFlow(@RequestBody QueryCondition queryCondition) {

		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String startTime = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()) + " 00:00:00";
		String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
		PassengerFlowVo passengerFlow = null;
		try {
			passengerFlow = passengerFlowService.getYesterdayTotalPassengerFlow(DateUtils.parseDateTime(startTime),
					DateUtils.parseDateTime(endTime), queryCondition.getOrgId(), queryCondition.getLineUuids());
		} catch (Exception e) {
			LOG.error("获取日客与当前同时刻昨流累计客流失败！{}", e);
			ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult(passengerFlow);
	}

	/**
	 * 周客流累计平均，（统计一周昨日累计客流平均值）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getWeekAvgTotalPassengerFlow")
	public Result getWeekAvgTotalPassengerFlow(@RequestBody QueryCondition queryCondition) {

		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		JSONObject result = new JSONObject();
		try {
			BigDecimal total = new BigDecimal("0");
			int index = 0;
			for (int i = 1; i < 8; i++) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_MONTH, -i);
				String startTime = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()) + " 00:00:00";
				String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
				PassengerFlowVo passengerFlow = passengerFlowService.getYesterdayTotalPassengerFlow(
						DateUtils.parseDateTime(startTime), DateUtils.parseDateTime(endTime), queryCondition.getOrgId(),
						queryCondition.getLineUuids());
				if (passengerFlow != null && passengerFlow.getPersonCount() != null) {
					index++;
				}
				String personCount = passengerFlow.getPersonCount() == null ? "0" : passengerFlow.getPersonCount();
				total = total.add(new BigDecimal(personCount));
			}
			if (index == 0) {
				result.put("personCount", new BigDecimal("0"));
			} else {
				result.put("personCount", total.divide(new BigDecimal(index + ""), 2, RoundingMode.HALF_UP));
			}
		} catch (Exception e) {
			LOG.error("获取日客与当前同时刻昨流累计客流失败！{}", e);
			ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult(result);
	}

	/**
	 * 当日累计客流
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getTotalPassengerFlow")
	public Result getTotalPassengerFlow(@RequestBody QueryCondition queryCondition) {
		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		PassengerFlowVo passengerFlow = passengerFlowService.getTotalPassengerFlow(queryCondition);
		return ResultUtil.getSuccessResult(passengerFlow);
	}

	/**
	 * 线路当日累计客流
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getLineTotalPassengerFlow")
	public Result getLineTotalPassengerFlow(@RequestBody QueryCondition queryCondition) {
		List<PassengerFlowVo> passengerFlow = passengerFlowService.getLineTotalPassengerFlow(queryCondition);
		return ResultUtil.getSuccessResult(passengerFlow);
	}

	/**
	 * 当日运营线路
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getRealTimeOperLines")
	public Result getRealTimeOperLines(@RequestBody QueryCondition queryCondition) {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getLineNum";
		String httpResult = RestUtils.getPostData(httpUrl, queryCondition.toString(), false);
		LOG.info("活跃线路数  url:{},result:{}", httpUrl, httpResult);
		JSONObject obj = null;
		if (PMSUtils.isNotEmpty(httpResult)) {
			obj = JSON.parseObject(httpResult);
		}
		Integer operLines = (obj == null) ? 0
				: (StringUtil.isEmpty(obj.getString("lineNum")) ? 0 : Integer.parseInt(obj.getString("lineNum")));
		Integer totalLines = busLineService.getLineCount(queryCondition.getOrgId());
		Map<String, Integer> result = new HashMap<>();
		result.put("operLines", operLines);
		result.put("totalLines", totalLines);
		return ResultUtil.getSuccessResult(result);
	}

	/**
	 * 实时客流人次
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getRealTimePassengerFlow")
	public Result getRealTimePassengerFlow(@RequestBody QueryCondition queryCondition) {
		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		long startDbTime = System.currentTimeMillis();
		List<PassengerFlowVo> list = passengerFlowService.getRealTimePassengerFlow(queryCondition);
		long endDbTime = System.currentTimeMillis();
		LOG.debug("实时客流人次时间:" + (endDbTime - startDbTime) + "");
		return ResultUtil.getSuccessResult(list);
	}

	/**
	 * 实时满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getRealTimeFullLoadRate")
	public Result getRealTimeFullLoadRate(@RequestBody QueryCondition queryCondition) {
		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		long startDbTime = System.currentTimeMillis();
		List<PassengerFlowVo> list = passengerFlowService.getRealTimeFullLoadRate(queryCondition);
		long endDbTime = System.currentTimeMillis();
		LOG.debug(" 实时满载率时间:" + (endDbTime - startDbTime) + "");
		return ResultUtil.getSuccessResult(list);
	}

	/**
	 * 线路满载率排行top10
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/getRealTimeFullRateTop10")
	public Result getRealTimeFullLoadRateTop10(@RequestBody QueryCondition queryCondition) {
		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		long startDbTime = System.currentTimeMillis();
		List<PassengerFlowVo> list = passengerFlowService.getRealTimeFullLoadRateTop10(queryCondition);
		long endDbTime = System.currentTimeMillis();
		LOG.debug("线路满载率排行top10时间:" + (endDbTime - startDbTime) + "");
		return ResultUtil.getSuccessResult(list);
	}

	/**
	 * 客流月趋势（折线图）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "客流首页")
	@RequestMapping(value = "passengerflow/line/monthtrend")
	public Result getPassengerflowMonthTrendDatas(@RequestBody QueryCondition queryCondition) {
		GridChartOption options = null;
		try {
			options = passengerFlowService.createMonthTrendOptions(queryCondition);
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("构建客流月趋势折线图失败，{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 客流实时登降量（折线图）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/line/upanddown")
	public Result getPassengerflowUpDownDatas(@RequestBody QueryCondition queryCondition) {
		GridChartOption options = null;
		try {
			options = passengerFlowService.createDayOnOffOptions(queryCondition);
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("客流实时登降量失败，{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 客流最热站点TOP10（柱状图）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/bar/hotstations")
	public Result getPassengerflowHotStationDatas(@RequestBody QueryCondition queryCondition) {
		GridChartOption options = null;

		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		try {
			options = passengerFlowService.createStationTopTenOptions(queryCondition);
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("客流最热站点TOP10失败，{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 客流最热线路TOP10（柱状图）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "passengerflow/line/hotlines")
	public Result getPassengerflowHotLineDatas(@RequestBody QueryCondition queryCondition) {
		GridChartOption options = null;

		// 增加用户线路权限设置
		BaseUserInfoVo user = new BaseUserInfoVo();
		user.setPersonId(queryCondition.getPersonId());
		List<BusLineView> lineList = baseUserInfoService.getLineListByUserId(user);
		List<String> lineUuids = new ArrayList<>();
		for (BusLineView busLineView : lineList) {
			lineUuids.add(busLineView.getLineUuid());
		}
		if (queryCondition.getLineUuids().size() == 0) {
			queryCondition.setLineUuids(lineUuids);
		}

		try {
			options = passengerFlowService.createLineTopTenOptions(queryCondition);
			return ResultUtil.getSuccessResult(options);
		} catch (Exception e) {
			LOG.error("客流最热线路TOP10失败，{}", e);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 获取车辆实时位置及车辆满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "map/getBusPositionAndFullLoadRate")
	public Result getBusPositionAndFullLoadRate(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request) {
		String showVideo = env.getProperty("show.bus.video");
		String httpUrl = env.getProperty("gjdd.http.url") + "/getBusPosition";
		String result = RestUtils.getPostData(httpUrl, queryCondition.toString(), false);
		LOG.info("车辆实时位置及车辆满载率 url:{},param:{},result:{}", httpUrl, queryCondition.toString(), result.length());
		Map<String, String> busOrgDic = initBusOrgDic();
		JSONArray arrys = null;
		if (PMSUtils.isNotEmpty(result)) {
			arrys = JSON.parseArray(result);
			// 车辆视频顺序配置
			Map<String, BaseBusVideoInfo> busVideoDisc = baseBusVideoInfoService.getBusVideoDisc();
			// 车辆报警信息(进行数据权限过滤)
			BaseUserInfo userInfo = getUserIdByToken(request);
			List<BaseDataResourceInfo> dataAuths = baseUserInfoService.getDataAuthByUserId(userInfo.getUserId());
			List<WarnInofVo> warnInfos = null;
			if (CollectionUtils.isNotEmpty(dataAuths)) {
				// 查询当天报警
				queryCondition.setStartTime(DateUtils.getStartDateTime(new Date()));
				queryCondition.setEndTime(DateUtils.getEndDateTime(new Date()));

				// 增加根据用户获取机构，如果是总公司看所有的审核状态的，如果是分公司只看审核属实的
				BaseUserInfo user = baseUserInfoService.selectByPrimaryKey(userInfo.getUserId());
				List<String> auditStatus = new ArrayList<>();
				if ("1".equals(user.getUserOrgUuid())) {
					auditStatus.add("0");
				} else {
					// 分公司查看已审核并且属实，未处理的报警
					auditStatus.add("1");
					List<String> handleResults = new ArrayList<String>();
					handleResults.add("0");
					queryCondition.setHandleResults(handleResults);
				}
				queryCondition.setAuditStatus(auditStatus);

				warnInfos = tempPltwarnService.getWarnInfos(queryCondition, userInfo);
			}

			Map<String, WarnInofVo> warnInofMap = this.tempPltwarnListToMap(warnInfos);
			List<DwDimBusDriver> drvInfo = dwDimBusDriverService.selectAllBusDriverInfo();
			// 全部司机信息
			Map<String, String> drvMap = new HashMap<>();
			for (DwDimBusDriver bean : drvInfo) {
				drvMap.put(bean.getDrvIcCard(), bean.getDrvEmployeeId());
			}
			Iterator<Object> iterator = arrys.iterator();
			while (iterator.hasNext()) {
				JSONObject next = (JSONObject) iterator.next();
				String busNumber = next.getString("busNumber");
				String busId = next.getString("busId");
				String drvIccard = next.getString("drvIccard");
				// 重新给司机工号赋值
				next.put("drvIccard", drvMap.get(drvIccard));
				// 设置车辆是否显示视频
				next.put("showVideo", showVideo);
				// 设置车辆所属机构
				next.put("orgName", busOrgDic.get(busId));
				// 设置车辆视频显示顺序 busSelfcode
				BaseBusVideoInfo busVideoInfo = busVideoDisc.get(busId);
				if (busVideoInfo != null) {
					List<String> busVideoOrder = createBusVideoOrder(busVideoInfo);
					next.put("busVideoOrder", busVideoOrder);
				} else {
					next.put("busVideoOrder", Collections.emptyList());
				}
				// 设置相关信息初始值
				next.put("warnInfo", false);
				next.put("warnSpeed", null);
				next.put("warnDeviceCode", null);
				// gps坐标转换
				String lngStr = (String) next.get("lng");
				String latStr = (String) next.get("lat");
				if (StringUtils.isNotEmpty(lngStr) && StringUtils.isNotEmpty(latStr)) {
					Gps gps = GpsSwitchUtils.wgs84tobd09(Double.valueOf(lngStr), Double.valueOf(latStr));
					next.put("lng", gps.getWgLon() + "");
					next.put("lat", gps.getWgLat() + "");
				}
				// 有报警的站点重新赋值
				if (warnInofMap.get(busNumber) != null) {
					WarnInofVo vo = warnInofMap.get(busNumber);
					next.put("warnInfo", true);
					next.put("warnSpeed", vo.getWarnSpeed());
					next.put("samplingTime", vo.getWarnTime());
					next.put("warnDeviceCode", vo.getWarnDeviceCode());
				}
			}
		}
		return ResultUtil.getSuccessResult(arrys);
	}

	private List<String> createBusVideoOrder(BaseBusVideoInfo busVideoInfo) {
		List<String> busVideoOrder = new LinkedList<>();
		if (busVideoInfo.getVideo1() == null) {
			busVideoOrder.add("通道1");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo1());
		}
		if (busVideoInfo.getVideo2() == null) {
			busVideoOrder.add("通道2");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo2());
		}
		if (busVideoInfo.getVideo3() == null) {
			busVideoOrder.add("通道3");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo3());
		}
		if (busVideoInfo.getVideo4() == null) {
			busVideoOrder.add("通道4");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo4());
		}
		if (busVideoInfo.getVideo5() == null) {
			busVideoOrder.add("通道5");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo5());
		}
		if (busVideoInfo.getVideo6() == null) {
			busVideoOrder.add("通道6");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo6());
		}
		if (busVideoInfo.getVideo7() == null) {
			busVideoOrder.add("通道7");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo7());
		}
		if (busVideoInfo.getVideo8() == null) {
			busVideoOrder.add("通道8");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo8());
		}
		if (busVideoInfo.getVideo9() == null) {
			busVideoOrder.add("通道9");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo9());
		}
		if (busVideoInfo.getVideo10() == null) {
			busVideoOrder.add("通道10");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo10());
		}
		if (busVideoInfo.getVideo11() == null) {
			busVideoOrder.add("通道11");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo11());
		}
		if (busVideoInfo.getVideo12() == null) {
			busVideoOrder.add("通道12");
		} else {
			busVideoOrder.add(busVideoInfo.getVideo12());
		}
		return busVideoOrder;
	}

	/**
	 * 获取站点实时登降量数据（热力图）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "map/getBusHeatmapDatas")
	public Result getBusHeatmapDatas(@RequestBody QueryCondition queryCondition) {
		long startDbTime = System.currentTimeMillis();
		List<HeatmapVo> list = passengerFlowService.getBusHeatmapDatas(queryCondition);
		long endDbTime = System.currentTimeMillis();
		LOG.debug("获取站点实时登降量数据（热力图）时间:" + (endDbTime - startDbTime) + "");
		return ResultUtil.getSuccessResult(list);
	}

	/**
	 * 疲劳驾驶行为转换为车牌号为key的map
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, WarnInofVo> tempPltwarnListToMap(List<WarnInofVo> list) {
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyMap();
		}
		Map<String, WarnInofVo> map = new HashMap<>();
		Iterator<WarnInofVo> iterator = list.iterator();
		while (iterator.hasNext()) {
			WarnInofVo next = iterator.next();
			String key = next.getBusNumber();
			// 报警信息倒序，因为获取的是当天的报警数据，存在一个车有多个报警，取最晚一次报警
			if (!map.containsKey(key)) {
				map.put(key, next);
			}
		}
		return map;
	}

	private Map<String, String> initBusOrgDic() {
		Map<String, String> busOrgMap = new HashMap<>();
		List<Map<String, String>> list = busService.getBusOrgInfo();
		if (list != null) {
			for (Map<String, String> map : list) {
				String busUuid = map.get("busuuid");
				if (busOrgMap.get(busUuid) == null) {
					busOrgMap.put(busUuid, map.get("orgname"));
				}
			}
		}
		return busOrgMap;
	}
}
