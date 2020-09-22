package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.TempBusSchedule;


/**
 * Created by xpguo on 2019/09/26.
 */
public interface TempBusScheduleService extends Service<TempBusSchedule> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 排班表字典信息
	 * 
	 * @return
	 */
	public Map<String, TempBusSchedule> getScheduleDisc();
}
