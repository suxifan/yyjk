package com.cictec.yyjk.report.mapper;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.report.model.data.DriverRankingValue;
import com.cictec.yyjk.report.model.entity.TempPltwarn;
import com.cictec.yyjk.report.model.view.WarnInfoValue;
import com.cictec.yyjk.report.model.vo.BadDrivingInfo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.WarnInofVo;

public interface TempPltwarnMapper extends Mapper<TempPltwarn> {

	/**
	 * 获取当天疲劳报警信息
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<WarnInofVo> getWarnInfos(QueryCondition queryCondition);

	/**
	 * 获取未处理告警
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<TWarn> getNoHandleWarns(QueryCondition queryCondition);

	/**
	 * 根据查询条件，按不良驾驶行为类型分类统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<WarnInofVo> statisticsByWarnType(QueryCondition queryCondition);

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
	 * @param queryCondition
	 * @return
	 */
	List<BadDrivingInfo> getBadDrivingBehaviorRanking(QueryCondition queryCondition);

	/**
	 * 不良驾驶行为当日排行明细
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<TWarn> getBadDrivingBehaviorRankingDetail(QueryCondition queryCondition);

	/**
	 * 不良驾驶行为分析司机排行
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getBadDrivingDriverRanking(QueryCondition queryCondition);

	/**
	 * 不良驾驶行为分析车辆排行
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getBadDrivingBusRanking(QueryCondition queryCondition);

	/**
	 * 驾驶员行为监测台账（日报）
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getDrivingBehaviorDay(QueryCondition queryCondition);

	/**
	 * 报警上传统计日报表
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<WarnInfoValue> getAlarmUploadReportDay(QueryCondition queryCondition);

	/**
	 * 司机报警时间趋势
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DriverRankingValue> getDriverWarnTimeTrend(QueryCondition queryCondition);

	/**
	 * 司机超速报警统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	// List<Map> getOverSpeedWarnCount(QueryCondition queryCondition);

	/**
	 * 超速报警趋势
	 * 
	 * @param queryCondition
	 * @return
	 */
	// List<DriverRankingValue> getOverSpeedWarnTrend(QueryCondition
	// queryCondition);

	/**
	 * 疲劳驾驶 报警时间段分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DriverRankingValue> getFatigueDrivingWarnTimeAnalysis(QueryCondition queryCondition);

	/**
	 * 疲劳驾驶 报警时间趋势分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DriverRankingValue> getFatigueDrivingWarnTimeTrendAnalysis(QueryCondition queryCondition);

	/**
	 * 各报警速度占比统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DriverRankingValue> getAlarmLevelRatioAnalysis(QueryCondition queryCondition);

	/**
	 * 报警速度条件下各报警类型占比统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DriverRankingValue> getAlarmTypeRatioAnalysis(QueryCondition queryCondition);

	/**
	 * 各速度下报警总数统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DriverRankingValue> getAlarmSpeedStatistic(QueryCondition queryCondition);
	
	/**
	 * 根据角色查询报警总数
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<TempPltwarn> getAlarmSum(QueryCondition queryCondition);
	
	/**
	 * 查询已处理报警数
	 * 
	 * @param queryCondition
	 * @return
	 *//*
		 * List<TWarn> getProcessedSum(@Param(value = "roleId") String roleId);
		 */

}