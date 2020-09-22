package com.cictec.yyjk.timingtask.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimMapLine;

public interface DwDimMapLineMapper extends Mapper<DwDimMapLine> {
	/**
	 * 清空表
	 */
	public void clearTabel();
}