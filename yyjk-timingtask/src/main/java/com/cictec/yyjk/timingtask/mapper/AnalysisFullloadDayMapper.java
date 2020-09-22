package com.cictec.yyjk.timingtask.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisFullloadDay;

public interface AnalysisFullloadDayMapper extends Mapper<AnalysisFullloadDay> {
	/**
	 * 获取昨日客流的区间满载率
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<AnalysisFullloadDay> getAnalysisFullload(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime);

	/**
	 * 获取昨日客流等降量
	 * 
	 * @param startTime
	 * @param endTime
	 * @param orgId
	 * @return
	 */
	public List<AnalysisFullloadDay> getYesterdayOnOffLineChartDatas(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime, @Param(value = "orgId") String orgId);

	/**
	 * 获取今日客流等降量
	 * 
	 * @return
	 */
	public List<AnalysisFullloadDay> getOnOffLineChartDatas(@Param(value = "orgId") String orgId);
}