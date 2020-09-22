package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimMapLine;


/**
 * Created by xpguo on 2019/09/24.
 */
public interface DwDimMapLineService extends Service<DwDimMapLine> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 线网信息字典
	 * 
	 * @return
	 */
	public Map<String, DwDimMapLine> getMapLineDisc();
}
