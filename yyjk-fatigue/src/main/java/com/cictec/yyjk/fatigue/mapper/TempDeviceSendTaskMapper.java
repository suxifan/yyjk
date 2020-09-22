package com.cictec.yyjk.fatigue.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTask;

public interface TempDeviceSendTaskMapper extends Mapper<TempDeviceSendTask> {
	
	/**
	 * <p>
	 * Description: 参数下发任务列表
	 * </p>
	 * <p>
	 * Function: selectTaskPage
	 * </p>
	 *
	 */
	List<TempDeviceSendTask> selectTaskPage(TempDeviceSendTask vo);
}