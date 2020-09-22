package com.cictec.yyjk.timingtask.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPassengerFlowMonthTrend;

public interface AnalysisPassengerFlowMonthTrendMapper extends Mapper<AnalysisPassengerFlowMonthTrend> {
	/**
	 * 统计每天客流数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<AnalysisPassengerFlowMonthTrend> countPassengerNumber(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime);

	/**
	 * 查询当前月客流月趋势数据
	 * 
	 * @return
	 */
	public List<AnalysisPassengerFlowMonthTrend> getCompanyMonthTrendDatas(@Param(value = "dateTime") String dateTime,
			@Param(value = "orgId") String orgId);
}