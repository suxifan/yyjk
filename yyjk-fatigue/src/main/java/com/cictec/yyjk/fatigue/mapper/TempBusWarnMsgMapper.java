package com.cictec.yyjk.fatigue.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TempBusWarnMsg;

public interface TempBusWarnMsgMapper extends Mapper<TempBusWarnMsg> {
	/**
	 * 清空表
	 * 
	 * @return
	 */
	boolean clearTabel();
}