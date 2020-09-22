package com.cictec.yyjk.timingtask.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBus;

public interface DwDimBusMapper extends Mapper<DwDimBus> {
	/**
	 * 清空表
	 */
	public void clearTabel();
}