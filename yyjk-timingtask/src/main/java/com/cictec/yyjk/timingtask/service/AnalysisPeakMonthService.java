package com.cictec.yyjk.timingtask.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPeakMonth;


/**
 * Created by xpguo on 2019/05/22.
 */
public interface AnalysisPeakMonthService extends Service<AnalysisPeakMonth> {
	/**
	 * 获取高峰时刻月分析数据
	 * 
	 * @param month
	 * @return
	 */
	public List<AnalysisPeakMonth> getAnalysisPeakMonthDatas(String month);
}
