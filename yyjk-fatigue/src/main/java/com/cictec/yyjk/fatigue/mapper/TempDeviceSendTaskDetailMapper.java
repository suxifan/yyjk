package com.cictec.yyjk.fatigue.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTaskDetail;

public interface TempDeviceSendTaskDetailMapper extends Mapper<TempDeviceSendTaskDetail> {
	/**
	 * <p>
	 * Description: 参数下发任务列表详情
	 * </p>
	 * <p>
	 * Function: selectTaskPage
	 * </p>
	 *
	 */
	List<TempDeviceSendTaskDetail> selectTaskDetailPage(TempDeviceSendTaskDetail vo);
	
}