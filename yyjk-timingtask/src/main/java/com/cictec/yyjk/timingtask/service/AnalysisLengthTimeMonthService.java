package com.cictec.yyjk.timingtask.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeMonth;


/**
 * Created by xpguo on 2019/05/22.
 */
public interface AnalysisLengthTimeMonthService extends Service<AnalysisLengthTimeMonth> {
	/**
	 * 获取线路站间运行时间月数据
	 * 
	 * @param month
	 * @return
	 */
	List<AnalysisLengthTimeMonth> getAnalysisLengthTimeMonthDatas(String month);
}
