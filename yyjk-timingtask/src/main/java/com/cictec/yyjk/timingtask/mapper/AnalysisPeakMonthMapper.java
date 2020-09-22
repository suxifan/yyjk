package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPeakMonth;

public interface AnalysisPeakMonthMapper extends Mapper<AnalysisPeakMonth> {
	/**
	 * 获取高峰时刻月分析数据
	 * 
	 * @param month
	 * @return
	 */
	public List<AnalysisPeakMonth> getAnalysisPeakMonthDatas(@Param(value = "month") String month);
}