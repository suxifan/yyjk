package com.cictec.yyjk.fatigue.service;

import java.util.List;

import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTask;


/**
 * Created by xpguo on 2019/11/21.
 */
public interface TempDeviceSendTaskService extends Service<TempDeviceSendTask> {
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
	
	/**
	 * <p>
	 * Description: 保存下发信息
	 * </p>
	 * <p>
	 * Function: saveTask
	 * </p>
	 *
	 */
	int saveTask(TempDeviceSendTask vo);
	
	/**
	 * <p>
	 * Description: 重新下发信息
	 * </p>
	 * <p>
	 * Function: saveTask
	 * </p>
	 *
	 */
	int saveTask2(TempDeviceSendTask vo);
	
	
	// 组织线路车辆树
	List<TreeNode2> orgLineBusTreeGet();
}
