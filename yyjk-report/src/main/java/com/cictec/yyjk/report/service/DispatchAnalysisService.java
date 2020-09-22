package com.cictec.yyjk.report.service;

import java.util.List;

import org.elasticsearch.client.Client;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.report.model.entity.DispatchAnalysis;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.GridChartQueryCondition;
import com.cictec.yyjk.report.model.vo.HeatmapOption;
import com.cictec.yyjk.report.model.vo.LineInfoVo;
import com.cictec.yyjk.report.model.vo.LineStationInfoVo;
import com.cictec.yyjk.report.model.vo.LineStationQueryVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.StationInfoVo;
import com.cictec.yyjk.report.model.vo.StationOnOffAnalysisVo;
import com.cictec.yyjk.report.model.vo.StationOnOffQueryCondition;

public interface DispatchAnalysisService extends Service<DispatchAnalysis> {
	/**
	 * 获取线路信息
	 * 
	 * @return
	 */
	List<LineInfoVo> getLineInfo();

	/**
	 * 获取所有站点信息(同一个站名可能因为方向有几条记录，将同名站点下的所有uuid拼接起来作为uuid)
	 * 
	 * @return
	 */
	List<StationInfoVo> getStationInfo();

	/**
	 * 获取所有线路站点信息
	 * 
	 * @return
	 */
	List<LineStationInfoVo> getAllLineStationInfo();

	/**
	 * 线路客流高峰时刻分析(上行数据)
	 * 
	 * @return
	 */
	HeatmapOption getUpRushHourLinePassengerChartDatas(QueryCondition queryCondition);

	/**
	 * 线路客流高峰时刻分析(下行数据)
	 * 
	 * @return
	 */
	HeatmapOption getDownRushHourLinePassengerChartDatas(QueryCondition queryCondition);
	
	
	/**
	 * 线路客流高峰断面分析
	 * 
	 * @return
	 */
	HeatmapOption getSectionLinePassengerChartDatas(QueryCondition queryCondition);	

	/**
	 * 线路站点上车人数，下车人数，断面客流量、满载率查询(上下行数据)
	 * 
	 * @return
	 */
	GridChartOption getLineStationChartDatas(GridChartQueryCondition queryCondition);

	/**
	 * 车辆发车趟次时序图
	 * 
	 * @return
	 */
	GridChartOption getSequenceDiagramChartDatas(GridChartQueryCondition queryCondition);

	/**
	 * 线路站间运行时间分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	GridChartOption getLineBetweenStationsRunningTimeChartDatas(QueryCondition queryCondition);

	/**
	 * 线路运力运量分析（上下行数据）
	 * 
	 * @param queryCondition
	 * @return
	 */
	GridChartOption getLineCapacityChartDatas(GridChartQueryCondition queryCondition);

	/**
	 * 站点等降量分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<StationOnOffAnalysisVo> getStationOnOffTableDatas(StationOnOffQueryCondition queryCondition);
	

	/**
	 * 获取站点运行时间数据
	 * 
	 * @param client
	 * @param index
	 * @param queryCondition
	 * @return
	 */
	GridChartOption getStationRunTimeChartDatas(Client client, String index, LineStationQueryVo queryCondition);

	/**
	 * 获取相邻站点速度柱形图数据
	 * 
	 * @param client
	 * @param index
	 * @param queryCondition
	 * @return
	 */
	GridChartOption getLineStationSpeedChartDatas(Client client, String index, LineStationQueryVo queryCondition);
}
