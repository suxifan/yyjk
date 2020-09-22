package com.cictec.yyjk.report.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.GridChartQueryCondition;
import com.cictec.yyjk.report.model.vo.HeatmapOption;
import com.cictec.yyjk.report.model.vo.LineInfoVo;
import com.cictec.yyjk.report.model.vo.LineStationQueryVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.StationInfoVo;
import com.cictec.yyjk.report.model.vo.StationOnOffAnalysisVo;
import com.cictec.yyjk.report.model.vo.StationOnOffQueryCondition;
import com.cictec.yyjk.report.service.DispatchAnalysisService;

/**
 * 调度相关数据分析控制类
 * 
 * @author gxp
 *
 */
@RestController
@RequestMapping(value = "/zhfxpt/analysis/")
public class DispatchAnalysisController {
	@Resource(name = "client")
	private Client client;
	@Autowired
	private Environment env;

	@Autowired
	private DispatchAnalysisService dispatchAnalysisService;
	
	/**
	 * 获取线路
	 * 
	 * @return
	 */
	@RequestMapping(value = "getLines")
	public Result getLines(@RequestBody(required=false) Map<String,Object> param) {
		List<LineInfoVo> list = dispatchAnalysisService.getLineInfo();
		return ResultUtil.getSuccessResult(list);
	}

	/**
	 * 站点等降量查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "getStations")
	public Result getStations(@RequestBody(required=false) Map<String,Object> param) {
		List<StationInfoVo> list = dispatchAnalysisService.getStationInfo();
		return ResultUtil.getSuccessResult(list);
	}
	
	/**
	 * 线路客流高峰时刻分析上行
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "客流高峰时刻分析")
	@RequestMapping(value = "getUpRushHourLinePassengerChartDatas")
	public Result getUpRushHourLinePassengerChartDatas(@RequestBody QueryCondition queryCondition) {
		HeatmapOption heatmapOption = dispatchAnalysisService.getUpRushHourLinePassengerChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(heatmapOption);
	}

	/**
	 * 线路客流高峰时刻分析下行
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getDownRushHourLinePassengerChartDatas")
	public Result getDownRushHourLinePassengerChartDatas(@RequestBody QueryCondition queryCondition) {
		HeatmapOption heatmapOption = dispatchAnalysisService.getDownRushHourLinePassengerChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(heatmapOption);
	}

	/**
	 * 线路客流高峰断面分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "客流高峰断面分析")
	@RequestMapping(value = "getSectionLinePassengerChartDatas")
	public Result getSectionLinePassengerChartDatas(@RequestBody QueryCondition queryCondition) {
		HeatmapOption heatmapOption = dispatchAnalysisService.getSectionLinePassengerChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(heatmapOption);
	}

	/**
	 * 线路站点上车人数，下车人数，断面客流量、满载率查询(上行数据)
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "区间满载率查询")
	@RequestMapping(value = "getUpLineStationChartDatas")
	public Result getUpLineStationChartDatas(@RequestBody GridChartQueryCondition queryCondition) {
		GridChartOption barChartOption = dispatchAnalysisService.getLineStationChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 线路站点上车人数，下车人数，断面客流量、满载率查询(下行数据)
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getDownLineStationChartDatas")
	public Result getDownLineStationChartDatas(@RequestBody GridChartQueryCondition queryCondition) {
		GridChartOption barChartOption = dispatchAnalysisService.getLineStationChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 线路车辆发车趟次时序图
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "发车趟次时序图")
	@RequestMapping(value = "getSequenceChartDatas")
	public Result getSequenceChartDatas(@RequestBody GridChartQueryCondition queryCondition) {
		String dynamicTableName = "analysis_arrive_volume_day_%s";
		boolean history = queryCondition.isHistory();
		if (history) {
			String dateTime = queryCondition.getDateTime();
			if (StringUtils.isEmpty(dateTime)) {
				return ResultUtil.getErrorResult("历史查询行车日期不能为空！");
			}
			queryCondition.setDynamicTableName(String.format(dynamicTableName, dateTime.substring(5, 7)));
		} else {
			queryCondition.setDynamicTableName("analysis_arrive_volume_day");
		}
		GridChartOption barChartOption = dispatchAnalysisService.getSequenceDiagramChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 线路站间运行时间分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "站间运行时间分析")
	@RequestMapping(value = "getLineBetweenStationsRunningTimeChartDatas")
	public Result getLineBetweenStationsRunningTimeChartDatas(@RequestBody QueryCondition queryCondition) {
		GridChartOption barChartOption = dispatchAnalysisService
				.getLineBetweenStationsRunningTimeChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 线路运力、运量及车内最大人数分析(上行数据)
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "客流运力运量分析")
	@RequestMapping(value = "getUpLineCapacityChartDatas")
	public Result getUpLineCapacityChartDatas(@RequestBody GridChartQueryCondition queryCondition) {
		GridChartOption barChartOption = dispatchAnalysisService.getLineCapacityChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 线路运力、运量及车内最大人数分析(下行数据)
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getDownLineCapacityChartDatas")
	public Result getDownLineCapacityChartDatas(@RequestBody GridChartQueryCondition queryCondition) {
		GridChartOption barChartOption = dispatchAnalysisService.getLineCapacityChartDatas(queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 站点等降量分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@AccessLogInfo(modelName = "运营分析", pageName = "站点登降量查询")
	@RequestMapping(value = "getStationOnOffTableDatas")
	public Result getStationOnOffTableDatas(@RequestBody StationOnOffQueryCondition queryCondition) {
		// 因为同一个站名可能因为方向有几条记录，这里需要将多个uuid拆分
		List<String> ids = new ArrayList<>();
		List<String> list = queryCondition.getStationIds();
		for (String id : list) {
			if (id.contains(",")) {
				ids.addAll(Arrays.asList(id.split(",")));
			} else {
				ids.add(id);
			}
		}

		queryCondition.setStationIds(ids);
		List<StationOnOffAnalysisVo> queryList = dispatchAnalysisService.getStationOnOffTableDatas(queryCondition);
		return ResultUtil.getSuccessResult(queryList);
	}

	// 线路拥堵分析 ------------------------开始

	/**
	 * 获取线路运行时间柱形图数据
	 * 
	 * @param queryCondition
	 * 
	 * @return
	 */
	@RequestMapping(value = "getLineOperationTimeDatas")
	public Result getLineOperationTimeDatas(@RequestBody LineStationQueryVo queryCondition) {
		String index = env.getProperty("elasticsearch.cluster.businoutstation.index");
		GridChartOption barChartOption = dispatchAnalysisService.getStationRunTimeChartDatas(client, index,
				queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 获取站点停留时间柱形图数据
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getLineDwellTimeDatas")
	public Result getLineDwellTimeDatas(@RequestBody LineStationQueryVo queryCondition) {
		String index = env.getProperty("elasticsearch.cluster.businoutstation.index");
		GridChartOption barChartOption = dispatchAnalysisService.getStationRunTimeChartDatas(client, index,
				queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 获取相邻站点速度柱形图数据
	 * 
	 * @param queryCondition
	 * @return LineStationSpeed
	 */
	@RequestMapping(value = "getLineStationSpeedDatas")
	public Result getLineStationSpeedDatas(@RequestBody LineStationQueryVo queryCondition) {
		String index = env.getProperty("elasticsearch.cluster.businoutstation.index");
		GridChartOption barChartOption = dispatchAnalysisService.getLineStationSpeedChartDatas(client, index,
				queryCondition);
		return ResultUtil.getSuccessResult(barChartOption);
	}
	// 线路拥堵分析-------------------------结束

}
