package com.cictec.yyjk.timingtask.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.TempBusScheduleDay;

public interface TempBusScheduleDayMapper extends Mapper<TempBusScheduleDay> {
	/**
	 * 清空表
	 */
	public void clearTabel();
}