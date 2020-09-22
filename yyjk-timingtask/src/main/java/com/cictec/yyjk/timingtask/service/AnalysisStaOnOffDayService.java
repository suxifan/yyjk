package com.cictec.yyjk.timingtask.service;

import java.util.Date;
import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisStaOnOffDay;


/**
 * Created by xpguo on 2019/05/22.
 */
public interface AnalysisStaOnOffDayService extends Service<AnalysisStaOnOffDay> {
	/**
	 * 按时间区间获取站点等降量日分析数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<AnalysisStaOnOffDay> getAnalysisStaOnOffDayDatas(Date startTime, Date endTime);

}
