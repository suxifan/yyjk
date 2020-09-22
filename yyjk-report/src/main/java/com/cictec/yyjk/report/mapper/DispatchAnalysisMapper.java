package com.cictec.yyjk.report.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.report.model.entity.DispatchAnalysis;
import com.cictec.yyjk.report.model.vo.GridChartQueryCondition;
import com.cictec.yyjk.report.model.vo.LineBetweenStationsRunningTimeAnalysisVo;
import com.cictec.yyjk.report.model.vo.LineCapacityAnalysisVo;
import com.cictec.yyjk.report.model.vo.LineInfoVo;
import com.cictec.yyjk.report.model.vo.LineStationAnalysisVo;
import com.cictec.yyjk.report.model.vo.LineStationInfoVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.SequenceDiagramAnalysisVo;
import com.cictec.yyjk.report.model.vo.StationInfoVo;
import com.cictec.yyjk.report.model.vo.StationOnOffAnalysisVo;
import com.cictec.yyjk.report.model.vo.StationOnOffQueryCondition;

public interface DispatchAnalysisMapper extends Mapper<DispatchAnalysis> {
	/**
	 * 获取所有线路信息
	 * 
	 * @return
	 */
	List<LineInfoVo> getLineInfo();

	/**
	 * 获取所有站点信息
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
	 * 线路客流高峰时刻分析(上下行数据)
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DispatchAnalysis> getRushHourLinePassengerDatas(QueryCondition queryCondition);

	/**
	 * 线路客流高峰时刻分析(下行数据)
	 * 
	 * @return
	 */
	List<DispatchAnalysis> getDownRushHourLinePassengerDatas(QueryCondition queryCondition);

	/**
	 * 线路客流高峰断面分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DispatchAnalysis> getSectionPassengerDatas(QueryCondition queryCondition);

	/**
	 * 获取线路站点名（按站序升序排序）
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<String> getLineStationNames(QueryCondition queryCondition);

	/**
	 * 线路站点上车人数，下车人数，断面客流量及满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<LineStationAnalysisVo> getLineStationInfo(GridChartQueryCondition queryCondition);

	/**
	 * 车辆发车趟次时序图
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<SequenceDiagramAnalysisVo> getSequenceDiagramInfo(GridChartQueryCondition queryCondition);
	
	/**
	 * 线路站间运行时间分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<LineBetweenStationsRunningTimeAnalysisVo> getLineBetweenStationsRunningTimeInfo(QueryCondition queryCondition);
	
	/**
	 * 线路站间运行时间分析 获取小时，作为系列名
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<String> getLineBetweenStationsRunningTimeHours(QueryCondition queryCondition);

	/**
	 * 线路运力运量分析（上下行数据）
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<LineCapacityAnalysisVo> getLineCapacityInfo(GridChartQueryCondition queryCondition);

	/**
	 * 站点等降量分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<StationOnOffAnalysisVo> getStationOnOffInfo(StationOnOffQueryCondition queryCondition);
}
