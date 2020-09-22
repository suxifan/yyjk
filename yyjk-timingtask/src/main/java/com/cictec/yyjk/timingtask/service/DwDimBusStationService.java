package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusStation;


/**
 * Created by xpguo on 2019/09/25.
 */
public interface DwDimBusStationService extends Service<DwDimBusStation> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 站点信息字典
	 * 
	 * @return
	 */
	public Map<String, DwDimBusStation> getStationDisc();
}
