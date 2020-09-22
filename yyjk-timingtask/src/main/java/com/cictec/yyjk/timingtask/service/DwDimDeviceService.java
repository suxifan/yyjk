package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimDevice;


/**
 * Created by xpguo on 2019/09/25.
 */
public interface DwDimDeviceService extends Service<DwDimDevice> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 获取设备信息字典
	 * 
	 * @return
	 */
	public Map<String, DwDimDevice> getDeviceDisc();
}
