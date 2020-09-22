package com.cictec.yyjk.fatigue.service;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.TempBusWarnMsg;


/**
 * Created by xpguo on 2020/01/15.
 */
public interface TempBusWarnMsgService extends Service<TempBusWarnMsg> {
	/**
	 * 清空表
	 * 
	 * @return
	 */
	boolean clearTabel();
}
