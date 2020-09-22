package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeMonth;

public interface AnalysisLengthTimeMonthMapper extends Mapper<AnalysisLengthTimeMonth> {

	/**
	 * 获取线路站间运行时间月数据
	 * 
	 * @param month
	 * @return
	 */
	List<AnalysisLengthTimeMonth> getAnalysisLengthTimeMonthDatas(@Param(value = "month") String month);
}