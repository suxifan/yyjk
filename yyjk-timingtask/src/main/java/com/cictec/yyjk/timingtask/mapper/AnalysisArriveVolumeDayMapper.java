package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisArriveVolumeDay;

public interface AnalysisArriveVolumeDayMapper extends Mapper<AnalysisArriveVolumeDay> {

	/**
	 * 批量插入指定表
	 * 
	 * @param list
	 */
	public void batchInsert(@Param(value = "tableName") String tableName,
			@Param(value = "item") AnalysisArriveVolumeDay item);

	/**
	 * 根据日期获取当天所以线路ids
	 * 
	 * @param dateTime
	 * @return
	 */
	public List<String> getLineIds(@Param(value = "dateTime") String dateTime);

	/**
	 * 根据线路，日期获取到站数据
	 * 
	 * @param lineId
	 * @param dateTime
	 * @return
	 */
	public List<AnalysisArriveVolumeDay> getAnalysisArriveVolumeDatas(@Param(value = "lineId") String lineId,
			@Param(value = "dateTime") String dateTime);

}