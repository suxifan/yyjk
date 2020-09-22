package com.cictec.yyjk.timingtask.service;

import java.util.Date;
import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPassengerFlowMonthTrend;


/**
 * Created by xpguo on 2019/11/16.
 */
public interface AnalysisPassengerFlowMonthTrendService extends Service<AnalysisPassengerFlowMonthTrend> {
	/**
	 * 统计每天客流数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<AnalysisPassengerFlowMonthTrend> countPassengerNumber(Date startTime, Date endTime);

	/**
	 * 查询客流月趋势数据-分公司
	 * 
	 * @param queryCondition
	 * @return
	 * @throws Exception
	 */
	public List<AnalysisPassengerFlowMonthTrend> getBranchCompanyMonthTrendDatas(String orgId) throws Exception;

	/**
	 * 查询客流月趋势数据-总公司
	 * 
	 * @param queryCondition
	 * @return
	 * @throws Exception
	 */
	public List<AnalysisPassengerFlowMonthTrend> getHeadCompanyMonthTrendDatas() throws Exception;
}
