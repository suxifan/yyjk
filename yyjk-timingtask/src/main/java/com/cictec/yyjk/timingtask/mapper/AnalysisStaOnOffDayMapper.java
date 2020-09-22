package com.cictec.yyjk.timingtask.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisStaOnOffDay;

public interface AnalysisStaOnOffDayMapper extends Mapper<AnalysisStaOnOffDay> {
	/**
	 * 按时间区间获取站点等降量日分析数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<AnalysisStaOnOffDay> getAnalysisStaOnOffDayDatas(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime);

}