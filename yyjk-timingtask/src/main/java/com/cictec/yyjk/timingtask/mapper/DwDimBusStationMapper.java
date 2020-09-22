package com.cictec.yyjk.timingtask.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusStation;

public interface DwDimBusStationMapper extends Mapper<DwDimBusStation> {
	/**
	 * 清空表
	 */
	public void clearTabel();
}