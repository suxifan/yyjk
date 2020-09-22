package com.cictec.yyjk.report.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.report.model.data.HandleAnalysisValue;
import com.cictec.yyjk.report.model.entity.TempPltwarn;
import com.cictec.yyjk.report.model.vo.BadDrivingInfo;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.WarnInofVo;

/**
 * Created by xpguo on 2019/06/14.
 */
public interface TempPltwarnService extends Service<TempPltwarn> {
	/**
	 * 获取当天疲劳报警信息
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<WarnInofVo> getWarnInfos(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 获取未处理告警
	 * 
	 * @param userInfo
	 * @return
	 */
	List<TWarn> getNoHandleWarns(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 根据查询条件，按不良驾驶行为类型分类统计
	 * 
	 * @param queryCondition
	 * @param userInfo
	 * @return
	 */
	List<WarnInofVo> statisticsByWarnType(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 根据查询条件，按不良驾驶行为等级分类统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<WarnInofVo> statisticsByWarnLeave(QueryCondition queryCondition);

	/**
	 * 不良驾驶行为当日排行
	 * 
	 * @return
	 */
	List<BadDrivingInfo> getBadDrivingBehaviorRanking(QueryCondition queryCondition);

	/**
	 * 不良驾驶行为当日排行明细
	 * 
	 * @param orgUuid
	 * @return
	 */
	List<TWarn> getBadDrivingBehaviorRankingDetail(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 不良驾驶行为分析司机排行
	 * 
	 * @param queryCondition
	 * @return map数据结构 {"columns":[{"name":"","value":""},{}...],"data":List
	 *         <DriverRankingValue>} column：动态表头，data：数据列表
	 */
	Map<String, Object> getBadDrivingDriverRanking(QueryCondition queryCondition);

	/**
	 * 不良驾驶行为分析车辆排行
	 * 
	 * @param queryCondition
	 * @return map数据结构 {"columns":[{"name":"","value":""},{}...],"data":List
	 *         <DriverRankingValue>} column：动态表头，data：数据列表
	 */
	Map<String, Object> getBadDrivingBusRanking(QueryCondition queryCondition);

	/**
	 * 驾驶员行为监测台账（日报）
	 * 
	 * @param queryCondition
	 * @return map数据结构 {"columns":[{"name":"","value":""},{}...],"data":List
	 *         <DriverRankingValue>} column：动态表头，data：数据列表
	 */
	Map<String, Object> getDrivingBehaviorDay(QueryCondition queryCondition);

	/**
	 * 驾驶员行为监测台账（日报）导出专用
	 * 
	 * @param queryCondition
	 * @return map数据结构 {"columns":[{"name":"","value":""},{}...],"data":List
	 *         <DriverRankingValue>} column：动态表头，data：数据列表
	 */
	Map<String, Object> getDrivingBehaviorDayExport(QueryCondition queryCondition);

	/**
	 * 报警处理分析
	 * 
	 * @param queryCondition
	 * @return map数据结构 {"columns":[{"name":"","value":""},{}...],"data":List
	 *         <DriverRankingValue>} column：动态表头，data：数据列表
	 */
	List<HandleAnalysisValue> getAlarmHandleAnalysis(QueryCondition queryCondition);
	
	
	/**
	 * 驾驶员行为监测台账（日报）
	 * 
	 * @param queryCondition
	 * @return map数据结构 {"columns":[{"name":"","value":""},{}...],"data":List
	 *         <DriverRankingValue>} column：动态表头，data：数据列表
	 */
	Map<String, Object> getAlarmUploadReportDay(QueryCondition queryCondition);
	
	
	
	/**
	 * 司机报警时间趋势线图数据
	 * 
	 * @param queryCondition
	 * @return
	 */
	GridChartOption getDriverWarnTimeTrendEchartDatas(QueryCondition queryCondition);

	/**
	 * 疲劳驾驶 报警时间段分析
	 * 
	 * @param queryCondition
	 * @param userInfo
	 * @return
	 */
	GridChartOption getFatigueDrivingEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 疲劳驾驶 报警时间趋势分析
	 * 
	 * @param queryCondition
	 * @param userInfo
	 * @return
	 */
	GridChartOption getFatigueDrivingTrendEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 各报警速度占比统计
	 * 
	 * @param queryCondition
	 * @param userInfo
	 * @return
	 */
	GridChartOption getAlarmLevelRatioAnalysisEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 报警速度条件下各报警类型占比统计
	 * 
	 * @param queryCondition
	 * @param userInfo
	 * @return
	 */
	GridChartOption getAlarmTypeRatioAnalysisEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo);

	/**
	 * 各速度下报警总数统计
	 * 
	 * @param queryCondition
	 * @param userInfo
	 * @return
	 */
	GridChartOption getAlarmSpeedStatisticEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo);
}
