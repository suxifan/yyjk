package com.cictec.yyjk.fatigue.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;

public interface TempBusOverWarnTrailMapper extends Mapper<TempBusOverWarnTrail> {
	/**
	 * 获取超速报警数据
	 * 
	 * @return
	 */
	List<TempBusOverWarnTrail> getOverSpeedInfos();
}