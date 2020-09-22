package com.cictec.yyjk.timingtask.service;

import java.util.Date;
import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisFullloadDay;


/**
 * Created by xpguo on 2019/05/22.
 */
public interface AnalysisFullloadDayService extends Service<AnalysisFullloadDay> {
	/**
	 * 获取昨日客流的区间满载率
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<AnalysisFullloadDay> getAnalysisFullload(Date startTime, Date endTime);

	/**
	 * 获取昨日客流等降量
	 * 
	 * @param startTime
	 * @param endTime
	 * @param orgId
	 * @return
	 */
	public List<AnalysisFullloadDay> getYesterdayOnOffLineChartDatas(Date startTime, Date endTime, String orgId);

	/**
	 * 获取今日客流等降量
	 * 
	 * @return
	 */
	public List<AnalysisFullloadDay> getOnOffLineChartDatas(String orgId);
}
