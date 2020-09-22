package com.cictec.yyjk.report.api;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.view.BusLineView;
import com.cictec.yyjk.base.model.vo.BaseUserInfoVo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.ExcelExportUtil;
import com.cictec.yyjk.commons.utils.ExportExcel;
import com.cictec.yyjk.commons.utils.FileOperUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.report.model.data.HandleAnalysisValue;
import com.cictec.yyjk.report.model.entity.TempPltwarn;
import com.cictec.yyjk.report.model.view.TempPltwarnExportView;
import com.cictec.yyjk.report.model.vo.BadDrivingInfo;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.TempPltwarnVo;
import com.cictec.yyjk.report.model.vo.WarnDetailInfoVo;
import com.cictec.yyjk.report.model.vo.WarnInofVo;
import com.cictec.yyjk.report.service.PassengerFlowService;
import com.cictec.yyjk.report.service.TempPltwarnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/06/14.
 */
@RestController
@RequestMapping(value = "/zhfxpt/")
public class ApiTempPltwarn extends BaseController {
	private static Logger LOG = LoggerFactory.getLogger(ApiTempPltwarn.class);
	@Resource
	private TempPltwarnService tempPltwarnService;
	@Autowired
	private PassengerFlowService passengerFlowService;
	@Autowired
	private BaseUserInfoService baseUserInfoService;
	// web映射地址
	@Value("${web.webrooturl}")
	private String webrooturl;

	@Autowired
	private Environment env;

	@PostMapping("/add")
	public Result add(@RequestBody TempPltwarn tempPltwarn) {
		tempPltwarnService.insertSelective(tempPltwarn);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		tempPltwarnService.deleteByPrimaryKey(id);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/update")
	public Result update(@RequestBody TempPltwarn tempPltwarn) {
		if (PMSUtils.isNotEmpty(tempPltwarn.getHandleUser())) {
			tempPltwarn.setHandleTime(new Date());
		}
		if (PMSUtils.isNotEmpty(tempPltwarn.getHandleSuggestion())) {
			tempPltwarn.setHandleResult("1");
		}
		tempPltwarnService.updateByPrimaryKeySelective(tempPltwarn);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		TempPltwarn tempPltwarn = tempPltwarnService.selectByPrimaryKey(id);
		return ResultUtil.getSuccessResult(tempPltwarn);
	}

	@PostMapping("/list")
	public Result list(@RequestBody TempPltwarnVo tempPltwarnVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (tempPltwarnVo.getPageSize() != null && tempPltwarnVo.getPageSize() != 0) {
			return pageList(tempPltwarnVo);
		}
		List<TempPltwarn> list = tempPltwarnService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody TempPltwarnVo tempPltwarnVo) {
		// 分页数据请求处理
		PageHelper.startPage(tempPltwarnVo.getPageNumber(), tempPltwarnVo.getPageSize());
		List<TempPltwarn> list = tempPltwarnService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<TempPltwarn>(list));
	}

	/**
	 * 实时获取疲劳app数据
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getBadDrivingBehaviorDatas")
	public Result getBadDrivingBehaviorDatas(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		BaseUserInfo userInfo = getUserIdByToken(request);
		boolean res = hasDataAuthority(userInfo);
		if (!res) {
			return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
		}

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

		queryCondition.setStartTime(DateUtils.getStartDateTime(new Date()));
		queryCondition.setEndTime(DateUtils.getEndDateTime(new Date()));
		List<WarnInofVo> list = tempPltwarnService.getWarnInfos(queryCondition, userInfo);
		List<String> results = new LinkedList<>();
		if (list != null) {
			Iterator<WarnInofVo> iterator = list.iterator();
			while (iterator.hasNext()) {
				WarnInofVo bean = iterator.next();
				results.add(bean.toString());
			}
		}
		return ResultUtil.getSuccessResult(results);
	}

	/**
	 * 不良驾驶行为类型--监控大屏
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营监控", pageName = "监控分析大屏")
	@RequestMapping(value = "/getStatisticDatasByWarnType")
	public Result getStatisticDatasByWarnType(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(new Date()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(new Date()));
			List<WarnInofVo> list = tempPltwarnService.statisticsByWarnType(queryCondition, userInfo);
			LOG.debug("不良驾驶行为类型数据：{}", list);
			return ResultUtil.getSuccessResult(list);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为类型异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为类型--监控大屏
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营监控", pageName = "监控分析大屏")
	@RequestMapping(value = "monitorScreen/getStatisticDatasByWarnType")
	public Result getMonitorScreenStatisticDatasByWarnType(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(new Date()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(new Date()));
			List<WarnInofVo> list = tempPltwarnService.statisticsByWarnType(queryCondition, userInfo);
			LOG.debug("不良驾驶行为类型数据：{}", list);
			return ResultUtil.getSuccessResult(list);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为类型异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为类型--安全运营首页
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "安全运营首页")
	@RequestMapping(value = "homepage/getStatisticDatasByWarnType")
	public Result getHomepageStatisticDatasByWarnType(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(new Date()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(new Date()));
			List<WarnInofVo> list = tempPltwarnService.statisticsByWarnType(queryCondition, userInfo);
			LOG.debug("不良驾驶行为类型数据：{}", list);
			return ResultUtil.getSuccessResult(list);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为类型异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为类型--报警类型分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "warnTypeAnalysis/getStatisticDatasByWarnType")
	public Result getWarnTypeAnalysisStatisticDatasByWarnType(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(
					queryCondition.getStartTime() == null ? new Date() : queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils
					.getEndDateTime(queryCondition.getEndTime() == null ? new Date() : queryCondition.getEndTime()));
			List<WarnInofVo> list = tempPltwarnService.statisticsByWarnType(queryCondition, userInfo);
			LOG.debug("不良驾驶行为类型数据：{}", list);
			return ResultUtil.getSuccessResult(list);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为类型异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为等级分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getAnalysisDatasByWarnLeave")
	public Result getAnalysisDatasByWarnLeave(@RequestBody QueryCondition queryCondition) {
		try {
			List<WarnInofVo> list = tempPltwarnService.statisticsByWarnLeave(queryCondition);
			LOG.debug("不良驾驶行为等级分析数据：{}", list);
			return ResultUtil.getSuccessResult(list);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为等级分析异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为当日排行
	 * 
	 * @param warnDetailInfoVo
	 * @return
	 */
	@RequestMapping(value = "getBadDrivingBehaviorRanking")
	public Result getBadDrivingBehaviorRanking(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(new Date()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(new Date()));
			List<BadDrivingInfo> result = tempPltwarnService.getBadDrivingBehaviorRanking(queryCondition);
			LOG.debug("不良驾驶行为日排行数据：{}", result);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为日排行异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为日排行详情
	 * 
	 * @param warnDetailInfoVo
	 * @return
	 */
	@RequestMapping(value = "getBadDrivingBehaviorRankingDetail")
	public Result getBadDrivingBehaviorRankingDetail(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(new Date()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(new Date()));
			List<TWarn> result = tempPltwarnService.getBadDrivingBehaviorRankingDetail(queryCondition, userInfo);
			LOG.debug("不良驾驶行为日排行详情数据：{}", result);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为日排行详情异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 单车不良驾驶行为详情
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getDetail")
	public Result getDetail(@RequestBody WarnDetailInfoVo warnDetailInfoVo) {
		try {
			WarnDetailInfoVo detail = passengerFlowService.getDetail(warnDetailInfoVo);
			LOG.debug("单车不良驾驶行为详情数据：{}", detail);
			return ResultUtil.getSuccessResult(detail);
		} catch (Exception ex) {
			LOG.error("单车不良驾驶行为详情异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为分析报警司机排行
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "司机排行分析")
	@RequestMapping(value = "getBadDrivingDriverRanking")
	public Result getBadDrivingDriverRanking(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			Map<String, Object> result = tempPltwarnService.getBadDrivingDriverRanking(queryCondition);
			LOG.debug("不良驾驶行为分析司机排行数据：{}", result);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为分析司机排行异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为分析报警司机排行导出
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "getBadDrivingDriverRankingExport")
	public Result getBadDrivingDriverRankingExport(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			Map<String, Object> result = tempPltwarnService.getBadDrivingDriverRanking(queryCondition);
			List<Map<String, String>> listColumns = (List<Map<String, String>>) result.get("column");
			String[] headerTitle = new String[listColumns.size()];
			for (int i = 0; i < listColumns.size(); i++) {
				headerTitle[i] = listColumns.get(i).get("pldisplay");
			}
			String[] headers = new String[listColumns.size()];
			for (int i = 0; i < listColumns.size(); i++) {
				headers[i] = listColumns.get(i).get("plvalue");
			}
			List<Map> projectList = (List<Map>) result.get("data");

			String envPath = env.getProperty("spring.resources.static-locations");
			String fileName = String.format("badDrivingDriverRanking%s.xls",
					new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;

			ExcelExportUtil excelExport2 = new ExcelExportUtil();
			excelExport2.setData(projectList);
			excelExport2.setHeardKey(headers);
			excelExport2.setFontSize(12);
			excelExport2.setSheetName("不良驾驶行为分析报警司机排行");
			excelExport2.setTitle("不良驾驶行为分析报警司机排行");
			excelExport2.setHeardList(headerTitle);
			excelExport2.exportExport(request, response, new FileOutputStream(tempFilePath));

			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("不良驾驶行为分析报警司机排行下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为分析司机排行数据导出异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为分析报警车辆排行
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "车辆排行")
	@RequestMapping(value = "getBadDrivingBusRanking")
	public Result getBadDrivingBusRanking(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			Map<String, Object> result = tempPltwarnService.getBadDrivingBusRanking(queryCondition);
			LOG.debug("不良驾驶行为分析车辆排行数据：{}", result);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为分析车辆排行异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 不良驾驶行为分析报警车辆排行导出
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "getBadDrivingBusRankingExport")
	public Result getBadDrivingBusRankingExport(@RequestBody QueryCondition queryCondition, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			Map<String, Object> result = tempPltwarnService.getBadDrivingBusRanking(queryCondition);
			List<Map<String, String>> listColumns = (List<Map<String, String>>) result.get("column");
			String[] headerTitle = new String[listColumns.size()];
			for (int i = 0; i < listColumns.size(); i++) {
				headerTitle[i] = listColumns.get(i).get("pldisplay");
			}
			String[] headers = new String[listColumns.size()];
			for (int i = 0; i < listColumns.size(); i++) {
				headers[i] = listColumns.get(i).get("plvalue");
			}
			List<Map> projectList = (List<Map>) result.get("data");

			String envPath = env.getProperty("spring.resources.static-locations");
			String fileName = String.format("badDrivingBusRanking%s.xls",
					new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;

			ExcelExportUtil excelExport2 = new ExcelExportUtil();
			excelExport2.setData(projectList);
			excelExport2.setHeardKey(headers);
			excelExport2.setFontSize(12);
			excelExport2.setSheetName("不良驾驶行为分析车辆排行");
			excelExport2.setTitle("不良驾驶行为分析车辆排行");
			excelExport2.setHeardList(headerTitle);
			excelExport2.exportExport(request, response, new FileOutputStream(tempFilePath));

			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("不良驾驶行为分析车辆排行下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("不良驾驶行为分析车辆排行数据导出异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 驾驶员行为监测台账（日报）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "监测台账")
	@RequestMapping(value = "getDrivingBehaviorDay")
	public Result getDrivingBehaviorDay(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看驾驶员行为监测台账数据的权限！");
			}
			queryCondition.setPage(true);
			Map<String, Object> result = tempPltwarnService.getDrivingBehaviorDay(queryCondition);
			LOG.debug("驾驶员行为监测台账（日报）：{}", result);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("驾驶员行为监测台账（日报），原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 驾驶员行为监测台账（日报）导出树状表头
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "getDrivingBehaviorDayExport")
	public Result getDrivingBehaviorDayExport(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setPage(false);
			Map<String, Object> result = tempPltwarnService.getDrivingBehaviorDayExport(queryCondition);
			List<Map<String, Object>> listColumns = (List<Map<String, Object>>) result.get("columnData");
			String[] headerTitle = new String[listColumns.size() * 2 + 6];
			headerTitle[0] = "驾驶员行为监测台账_报警时间";
			headerTitle[1] = "驾驶员行为监测台账_车牌号";
			headerTitle[2] = "驾驶员行为监测台账_司机工号";
			headerTitle[3] = "驾驶员行为监测台账_司机";
			headerTitle[4] = "驾驶员行为监测台账_线路";
			headerTitle[5] = "驾驶员行为监测台账_总站";
			int j = 6;
			for (int i = 0; i < listColumns.size(); i++) {
				headerTitle[j] = "驾驶员行为监测台账_驾驶员行为监测报警_" + (String) listColumns.get(i).get("pldisplay") + "_一级";
				headerTitle[++j] = "驾驶员行为监测台账_驾驶员行为监测报警_" + (String) listColumns.get(i).get("pldisplay") + "_二级";
				j++;
			}
			String[] headers = new String[listColumns.size() * 2 + 6];
			headers[0] = "warntime";
			headers[1] = "busnumber";
			headers[2] = "drivernum";
			headers[3] = "drivername";
			headers[4] = "linename";
			headers[5] = "orgname";
			int k = 6;
			for (int i = 0; i < listColumns.size(); i++) {
				List<String> list = (List<String>) listColumns.get(i).get("level");
				for (String string : list) {
					headers[k] = string;
					k++;
				}
			}
			List<Map> projectList = (List<Map>) result.get("data");
			if (projectList != null && projectList.size() == 0) {
				return ResultUtil.getErrorResult("没有导出记录！");
			}
			if (projectList != null && projectList.size() > 65536) {
				projectList = projectList.subList(0, 65532);
			}
			String envPath = env.getProperty("spring.resources.static-locations");
			String fileName = String.format("drivingBehaviorDay%s.xls",
					new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;
			String sheetName = "驾驶员行为监测台账";
			ExportExcel.ExportExcel1(sheetName, headerTitle, 4, headers, projectList, new File(tempFilePath));

			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("驾驶员行为监测台账（日报）下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("驾驶员行为监测台账（日报）导出异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 报警上传统计日报表
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "统计日报表")
	@RequestMapping(value = "getAlarmUploadReportDay")
	public Result getAlarmUploadReportDay(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看驾驶员行为监测台账数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getStartTime()));
			Map<String, Object> result = tempPltwarnService.getAlarmUploadReportDay(queryCondition);
			LOG.debug("报警上传统计日报表：{}", result);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("报警上传统计日报表，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 
	 * 
	 * /** 报警上传统计日报表导出
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "getAlarmUploadReportDayExcel")
	public Result getAlarmUploadReportDayExcel(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		BaseUserInfo userInfo = getUserIdByToken(request);
		boolean res = hasDataAuthority(userInfo);
		if (!res) {
			return ResultUtil.getErrorResult("用户没有查看驾驶员行为监测台账数据的权限！");
		}
		queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getWarnDate()));
		queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getWarnDate()));
		Map<String, Object> result = tempPltwarnService.getAlarmUploadReportDay(queryCondition);
		// 行为监测
		List<Map> alarmColumnDataList = (List<Map>) result.get("alarmColumnData");
		// 辅助功能
		List<Map> assistColumnDataList = (List<Map>) result.get("assistColumnData");
		// 值
		List<Map> dataList = (List<Map>) result.get("data");

		// 驾驶员行为监测报警
		List<TempPltwarnExportView> alarmExportList = new ArrayList<>();
		// 驾驶员行为监测报警
		List<TempPltwarnExportView> assistExportList = new ArrayList<>();
		// 组合导出data
		ExportData(alarmColumnDataList, assistColumnDataList, dataList, alarmExportList, assistExportList);

		String envPath = env.getProperty("spring.resources.static-locations");
		String srcFilePath = envPath.substring(envPath.indexOf(":") + 1) + "alarmUploadReportDay.xlsx";
		String fileName = String.format("alarmUploadReportDay%s.xlsx",
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		String tempFilePath = envPath.substring(envPath.indexOf(":") + 1) + "upload" + File.separator + fileName;

		List<List<String>> alarmData = new ArrayList<List<String>>();
		for (TempPltwarnExportView item : alarmExportList) {
			List<String> row = new ArrayList<>();
			row.add(item.getConfigName());
			row.add(item.getProjectName());
			row.add(item.getLevelName());
			row.add(item.getNumberTimes() + "");
			row.add(item.getBusCounts() + "");
			alarmData.add(row);
		}
		List<List<String>> assistData = new ArrayList<List<String>>();
		for (TempPltwarnExportView item : assistExportList) {
			List<String> row = new ArrayList<>();
			row.add(item.getConfigName());
			row.add(item.getProjectName());
			row.add(item.getLevelName());
			row.add(item.getNumberTimes() + "");
			row.add(item.getBusCounts() + "");
			assistData.add(row);
		}
		File tempFile = new File(tempFilePath);
		try {
			String tital = "主动安全智能防控系统报警上传统计日报表（" + queryCondition.getWarnDate() + "）";
			FileOperUtils.writeExcelForAlarmUpload(tital, new File(srcFilePath), tempFile, 3, alarmData, assistData);
			JSONObject json = new JSONObject();
			json.put("url", webrooturl + "exceltemplate/upload/" + fileName);
			LOG.info("报警上传统计日报表下载文件:{}", fileName);
			return ResultUtil.getSuccessResult(json);
		} catch (Exception ex) {
			LOG.error("报警上传统计日报表导出失败！{}", ex.getMessage());
			return ResultUtil.getErrorResult("报警上传统计日报表导出失败！");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void ExportData(List<Map> alarmColumnDataList, List<Map> assistColumnDataList, List<Map> dataList,
			List<TempPltwarnExportView> alarmExportList, List<TempPltwarnExportView> assistExportList) {
		Integer alarmAccountTimes = 0;// 合计次数
		Integer alarmAccountCounts = 0;// 合计车台数
		Integer assistAccountTimes = 0;// 合计次数
		Integer assistAccountCounts = 0;// 合计车台数
		for (Map<String, Object> item : alarmColumnDataList) {
			List<String> LevelList = (List<String>) item.get("level");
			for (String level : LevelList) {
				TempPltwarnExportView obj = new TempPltwarnExportView();
				obj.setConfigName("主配");
				obj.setProjectName((String) item.get("pldisplay"));
				if (level.equals(item.get("plvalue") + "First")) {
					obj.setLevelName("一级");
					for (Map map : dataList) {
						obj.setNumberTimes((Integer) map.get(level));
						obj.setBusCounts((Integer) map.get(level + "BusCounts"));
						alarmExportList.add(obj);
					}
				} else if (level.equals(item.get("plvalue") + "Second")) {
					obj.setLevelName("二级");
					for (Map map : dataList) {
						obj.setNumberTimes((Integer) map.get(level));
						obj.setBusCounts((Integer) map.get(level + "BusCounts"));
						alarmExportList.add(obj);
					}
				} else if ((item.get("plvalue") + "TotalWarns").contains(level)) {
					obj.setLevelName("合计");
					for (Map map : dataList) {
						Integer totalWarns = (Integer) map.get(item.get("plvalue") + "TotalWarns");
						Integer totalWarnBusCounts = (Integer) map.get(item.get("plvalue") + "TotalWarnBusCounts");
						obj.setNumberTimes(totalWarns);
						obj.setBusCounts(totalWarnBusCounts);
						alarmExportList.add(obj);
						alarmAccountTimes += totalWarns;
						alarmAccountCounts += totalWarnBusCounts;
					}
				}
			}
		}
		// 增加总计行
		TempPltwarnExportView alarmTotalObj = new TempPltwarnExportView();
		alarmTotalObj.setConfigName("共计");
		alarmTotalObj.setProjectName("");
		alarmTotalObj.setLevelName("");
		alarmTotalObj.setNumberTimes(alarmAccountTimes);
		alarmTotalObj.setBusCounts(alarmAccountCounts);
		alarmExportList.add(alarmTotalObj);
		// 增加总计行
		TempPltwarnExportView alarmAccountObj = new TempPltwarnExportView();
		alarmAccountObj.setConfigName("总计");
		alarmAccountObj.setProjectName("");
		alarmAccountObj.setLevelName("");
		alarmAccountObj.setNumberTimes(alarmAccountTimes);
		alarmAccountObj.setBusCounts(alarmAccountCounts);
		alarmExportList.add(alarmAccountObj);

		for (Map<String, Object> item : assistColumnDataList) {
			List<String> LevelList = (List<String>) item.get("level");
			for (String level : LevelList) {
				TempPltwarnExportView obj = new TempPltwarnExportView();
				obj.setConfigName("主配");
				obj.setProjectName((String) item.get("pldisplay"));
				if (level.equals(item.get("plvalue") + "First")) {
					obj.setLevelName("一级");
					for (Map map : dataList) {
						obj.setNumberTimes((Integer) map.get(level));
						obj.setBusCounts((Integer) map.get(level + "BusCounts"));
						assistExportList.add(obj);
					}
				} else if (level.equals(item.get("plvalue") + "Second")) {
					obj.setLevelName("二级");
					for (Map map : dataList) {
						obj.setNumberTimes((Integer) map.get(level));
						obj.setBusCounts((Integer) map.get(level + "BusCounts"));
						assistExportList.add(obj);
					}
				} else if ((item.get("plvalue") + "TotalWarns").contains(level)) {
					obj.setLevelName("合计");
					for (Map map : dataList) {
						Integer totalWarns = (Integer) map.get(item.get("plvalue") + "TotalWarns");
						Integer totalWarnBusCounts = (Integer) map.get(item.get("plvalue") + "TotalWarnBusCounts");
						obj.setNumberTimes(totalWarns);
						obj.setBusCounts(totalWarnBusCounts);
						assistExportList.add(obj);
						assistAccountTimes += totalWarns;
						assistAccountCounts += totalWarnBusCounts;
					}
				}
			}
		}
		// 增加总计行
		TempPltwarnExportView assistTotalObj = new TempPltwarnExportView();
		assistTotalObj.setConfigName("共计");
		assistTotalObj.setProjectName("");
		assistTotalObj.setLevelName("");
		assistTotalObj.setNumberTimes(assistAccountTimes);
		assistTotalObj.setBusCounts(assistAccountCounts);
		assistExportList.add(assistTotalObj);
		// 增加总计行
		TempPltwarnExportView assistAccountObj = new TempPltwarnExportView();
		assistAccountObj.setConfigName("总计");
		assistAccountObj.setProjectName("");
		assistAccountObj.setLevelName("");
		assistAccountObj.setNumberTimes(assistAccountTimes);
		assistAccountObj.setBusCounts(assistAccountCounts);
		assistExportList.add(assistAccountObj);
	}

	/**
	 * 司机报警时间趋势
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getDriverWarnTimeTrend")
	public Result getDriverWarnTimeTrendEchartDatas(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			GridChartOption option = tempPltwarnService.getDriverWarnTimeTrendEchartDatas(queryCondition);
			LOG.debug("司机报警时间趋势数据：{}", option);
			return ResultUtil.getSuccessResult(option);
		} catch (Exception ex) {
			LOG.error("司机报警时间趋势数据异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * （报警类型分析）报警时间段分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "报警类型分析")
	@RequestMapping(value = "getFatigueDrivingWarnTimeAnalysis")
	public Result getFatigueDrivingEchartDatas(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			GridChartOption option = tempPltwarnService.getFatigueDrivingEchartDatas(queryCondition, userInfo);
			LOG.debug("疲劳驾驶 报警时间段分析数据：{}", option);
			return ResultUtil.getSuccessResult(option);
		} catch (Exception ex) {
			LOG.error("疲劳驾驶 报警时间段分析异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * （报警类型分析）报警时间趋势分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getFatigueDrivingWarnTimeTrendAnalysis")
	public Result getFatigueDrivingTrendEchartDatas(@RequestBody QueryCondition queryCondition,
			HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			GridChartOption option = tempPltwarnService.getFatigueDrivingTrendEchartDatas(queryCondition, userInfo);
			LOG.debug("疲劳驾驶 报警时间趋势分析数据：{}", option);
			return ResultUtil.getSuccessResult(option);
		} catch (Exception ex) {
			LOG.error("疲劳驾驶 报警时间趋势分析异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 各报警速度占比统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getAlarmLevelRatioAnalysis")
	public Result getAlarmLevelRatioAnalysis(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			GridChartOption option = tempPltwarnService.getAlarmLevelRatioAnalysisEchartDatas(queryCondition, userInfo);
			LOG.debug("各报警速度占比统计分析数据：{}", option);
			return ResultUtil.getSuccessResult(option);
		} catch (Exception ex) {
			LOG.error("各报警速度占比统计分析异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 报警速度条件下各报警类型占比统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getAlarmTypeRatioAnalysis")
	public Result getAlarmTypeRatioAnalysis(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			GridChartOption option = tempPltwarnService.getAlarmTypeRatioAnalysisEchartDatas(queryCondition, userInfo);
			LOG.debug("报警速度条件下各报警类型占比统计分析数据：{}", option);
			return ResultUtil.getSuccessResult(option);
		} catch (Exception ex) {
			LOG.error("报警速度条件下各报警类型占比统计分析异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/**
	 * 各速度下报警总数统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "报警速度分析")
	@RequestMapping(value = "getAlarmSpeedStatistic")
	public Result getAlarmSpeedStatistic(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			GridChartOption option = tempPltwarnService.getAlarmSpeedStatisticEchartDatas(queryCondition, userInfo);
			LOG.debug("各速度下报警总数统计分析数据：{}", option);
			return ResultUtil.getSuccessResult(option);
		} catch (Exception ex) {
			LOG.error("各速度下报警总数统计分析异常，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

	/*
	 * 报警处理分析
	 * 
	 * @param queryCondition
	 * 
	 * @return
	 */
	@AccessLogInfo(modelName = "疲劳监测", pageName = "报警处理分析")
	@RequestMapping(value = "getAlarmHandleAnalysis")
	public Result getAlarmHandleAnalysis(@RequestBody QueryCondition queryCondition, HttpServletRequest request) {
		try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			boolean res = hasDataAuthority(userInfo);
			if (!res) {
				return ResultUtil.getErrorResult("用户没有查看报警处理分析数据的权限！");
			}
			queryCondition.setStartTime(DateUtils.getStartDateTime(queryCondition.getStartTime()));
			queryCondition.setEndTime(DateUtils.getEndDateTime(queryCondition.getEndTime()));
			List<HandleAnalysisValue> result = tempPltwarnService.getAlarmHandleAnalysis(queryCondition);
			LOG.debug("报警处理分析：{}", result);
			return ResultUtil.getSuccessResult(result);
		} catch (Exception ex) {
			LOG.error("报警处理分析，原因：{}", ex);
			return ResultUtil.getErrorResult();
		}
	}

}
