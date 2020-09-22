package com.cictec.yyjk.report.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.report.model.entity.PassengerFlow;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.HeatmapVo;
import com.cictec.yyjk.report.model.vo.PassengerFlowVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.WarnDetailInfoVo;

public interface PassengerFlowService extends Service<PassengerFlow> {
	/**
	 * 总实时载客（人）、实时满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	PassengerFlowVo getRealTimePersoncountAndFullLoadRate(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询当日累计客流
	 * 
	 * @param queryCondition
	 * @return
	 */
	PassengerFlowVo getTotalPassengerFlow(QueryCondition queryCondition);

	/**
	 * 查询与当前时间同期的昨日客流数据量
	 * 
	 * @param startTime
	 * @param endTime
	 * @param orgId
	 * @return
	 */
	PassengerFlowVo getYesterdayTotalPassengerFlow(Date startTime, Date endTime, String orgId, List<String> lineUuids)
			throws Exception;

	/**
	 * 获取当天线路累计客流人数
	 * 
	 * @return
	 */
	List<PassengerFlowVo> getLineTotalPassengerFlow(QueryCondition queryCondition);

	/**
	 * 当日机构累计客流
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getCompanyTotalPassengerFlow();

	/**
	 * 根据查询条件查询实时客流人次
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getRealTimePassengerFlow(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询实时满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getRealTimeFullLoadRate(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询线路满载率排行top10
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getRealTimeFullLoadRateTop10(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询某一时刻车辆满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getBusFullLoadRate(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询某一时刻前五分钟站点等降量（热力图数据）
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<HeatmapVo> getBusHeatmapDatas(QueryCondition queryCondition);

	/**
	 * 组织报警车辆详情
	 * 
	 * @param warnDetailInfoVo
	 * @return
	 */
	WarnDetailInfoVo getDetail(WarnDetailInfoVo warnDetailInfoVo);

	/**
	 * 构建客流等降量日趋势折线图
	 * 
	 * @return
	 */
	public GridChartOption createDayOnOffOptions(QueryCondition queryCondition) throws Exception;

	/**
	 * 构建客流等降量日趋势折线图
	 * 
	 * @return
	 */
	public GridChartOption createStationTopTenOptions(QueryCondition queryCondition) throws Exception;

	/**
	 * 构建客流等降量日趋势折线图
	 * 
	 * @return
	 */
	public GridChartOption createLineTopTenOptions(QueryCondition queryCondition) throws Exception;

	/**
	 * 构建客流数据月趋势折线图
	 * 
	 * @return
	 */
	public GridChartOption createMonthTrendOptions(QueryCondition queryCondition) throws Exception;
}
