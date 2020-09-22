package com.cictec.yyjk.fatigue.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;


/**
 * Created by xpguo on 2020/02/13.
 */
public interface TempBusOverWarnTrailService extends Service<TempBusOverWarnTrail> {
	/**
	 * 获取超速报警数据
	 * 
	 * @return
	 */
	List<TempBusOverWarnTrail> getOverSpeedInfos();
}
