package com.cictec.yyjk.fatigue.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTaskDetail;


/**
 * Created by Rwq on 2019/11/21.
 */
public interface TempDeviceSendTaskDetailService extends Service<TempDeviceSendTaskDetail> {
	
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
