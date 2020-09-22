package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisSectionMonth;

public interface AnalysisSectionMonthMapper extends Mapper<AnalysisSectionMonth> {
	/**
	 * 线路客流高峰断面月数据分析
	 * 
	 * @param month
	 * @return
	 */
	public List<AnalysisSectionMonth> getAnalysisSectionMonthDatas(@Param(value = "month") String month);
}