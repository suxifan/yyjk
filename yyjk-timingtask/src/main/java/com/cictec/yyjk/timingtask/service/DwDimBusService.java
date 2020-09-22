package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimBus;


/**
 * Created by xpguo on 2019/09/25.
 */
public interface DwDimBusService extends Service<DwDimBus> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 获取车辆字段信息
	 * 
	 * @return
	 */
	public Map<String, DwDimBus> getBusDisc();
}
