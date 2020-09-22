package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeDay;

public interface AnalysisLengthTimeDayMapper extends Mapper<AnalysisLengthTimeDay> {

	/**
	 * 计算线路站间运行时间日数据
	 * 
	 * @param dateTime
	 * @return
	 */
	public List<AnalysisLengthTimeDay> getAnalysisLengthTimeDayDatas(@Param(value = "dateTime") String dateTime);

	/**
	 * 到站数据日统计表保留2个月数据
	 * 
	 * @param month
	 */
	public void deleteLenthTimeDayDatas(@Param(value = "month") String month);
}