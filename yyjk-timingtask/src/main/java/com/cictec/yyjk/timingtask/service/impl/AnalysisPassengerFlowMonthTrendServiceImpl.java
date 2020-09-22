package com.cictec.yyjk.timingtask.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.timingtask.mapper.AnalysisPassengerFlowMonthTrendMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPassengerFlowMonthTrend;
import com.cictec.yyjk.timingtask.service.AnalysisPassengerFlowMonthTrendService;

/**
 * Created by xpguo on 2019/11/16.
 */
@Service
@Transactional
public class AnalysisPassengerFlowMonthTrendServiceImpl extends AbstractService<AnalysisPassengerFlowMonthTrend> implements AnalysisPassengerFlowMonthTrendService {

    @Resource
	private AnalysisPassengerFlowMonthTrendMapper analysisPassengerFlowMonthTrendMapper;

	@Override
	public List<AnalysisPassengerFlowMonthTrend> countPassengerNumber(Date startTime, Date endTime) {
		return analysisPassengerFlowMonthTrendMapper.countPassengerNumber(startTime, endTime);
	}

	/**
	 * 查询当前月客流月趋势数据-分公司
	 * 
	 * @param queryCondition
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<AnalysisPassengerFlowMonthTrend> getBranchCompanyMonthTrendDatas(String orgId) throws Exception {
		return quryMonthTrendDatas(orgId);
	}

	private List<AnalysisPassengerFlowMonthTrend> quryMonthTrendDatas(String orgId) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -29);
		String dateTime = DateUtils.formatDate(calendar.getTime(), "yyyy-MM-dd");
		return analysisPassengerFlowMonthTrendMapper.getCompanyMonthTrendDatas(dateTime, orgId);
	}

	/**
	 * 查询当前月客流月趋势数据-总公司
	 * 
	 * @param queryCondition
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<AnalysisPassengerFlowMonthTrend> getHeadCompanyMonthTrendDatas() throws Exception {
		return quryMonthTrendDatas(null);
	}


}
