package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLine;


/**
 * Created by xpguo on 2019/09/26.
 */
public interface DwDimBusLineService extends Service<DwDimBusLine> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 线路字典信息
	 * 
	 * @return
	 */
	public Map<String, DwDimBusLine> getLineDisc();
}
