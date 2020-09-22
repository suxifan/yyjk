package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.TempBusScheduleDay;


/**
 * Created by xpguo on 2019/09/26.
 */
public interface TempBusScheduleDayService extends Service<TempBusScheduleDay> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 排班明细字典信息
	 * 
	 * @return
	 */
	public Map<String, TempBusScheduleDay> getScheduleDayDisc();
}
