package com.cictec.yyjk.timingtask.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimDevice;

public interface DwDimDeviceMapper extends Mapper<DwDimDevice> {
	/**
	 * 清空表
	 */
	public void clearTabel();
}