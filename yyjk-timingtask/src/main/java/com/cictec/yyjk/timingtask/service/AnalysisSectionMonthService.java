package com.cictec.yyjk.timingtask.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisSectionMonth;


/**
 * Created by xpguo on 2019/05/22.
 */
public interface AnalysisSectionMonthService extends Service<AnalysisSectionMonth> {
	/**
	 * 线路客流高峰断面月数据分析
	 * 
	 * @param month
	 * @return
	 */
	public List<AnalysisSectionMonth> getAnalysisSectionMonthDatas(String month);
}
