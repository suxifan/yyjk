package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLineDeviceId;


/**
 * Created by xpguo on 2019/12/26.
 */
public interface DwDimBusLineDeviceIdService extends Service<DwDimBusLineDeviceId> {
	/**
	 * 获取线路设备关系字典
	 * 
	 * @return
	 */
	public Map<String, DwDimBusLineDeviceId> getLineDeviceIdDisc();
}
