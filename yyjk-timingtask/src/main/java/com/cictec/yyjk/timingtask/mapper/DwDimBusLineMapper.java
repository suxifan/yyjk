package com.cictec.yyjk.timingtask.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLine;

public interface DwDimBusLineMapper extends Mapper<DwDimBusLine> {
	/**
	 * 清空表
	 */
	public void clearTabel();
}