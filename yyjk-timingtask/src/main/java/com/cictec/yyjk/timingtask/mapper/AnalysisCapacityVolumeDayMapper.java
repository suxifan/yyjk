package com.cictec.yyjk.timingtask.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisCapacityVolumeDay;

public interface AnalysisCapacityVolumeDayMapper extends Mapper<AnalysisCapacityVolumeDay> {
	/**
	 * 获取客流运力运量日分析数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<AnalysisCapacityVolumeDay> getAnalysisCapacityVolumeDayDatas(
			@Param(value = "startTime") Date startTime, @Param(value = "endTime") Date endTime);
}