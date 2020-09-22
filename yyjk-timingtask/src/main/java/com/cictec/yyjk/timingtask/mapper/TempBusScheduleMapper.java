package com.cictec.yyjk.timingtask.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.TempBusSchedule;

public interface TempBusScheduleMapper extends Mapper<TempBusSchedule> {
	/**
	 * 清空表
	 */
	public void clearTabel();
}