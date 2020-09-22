package com.cictec.yyjk.timingtask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisLengthTimeDayMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeDay;
import com.cictec.yyjk.timingtask.service.AnalysisLengthTimeDayService;


/**
 * Created by xpguo on 2019/06/28.
 */
@Service
@Transactional
public class AnalysisLengthTimeDayServiceImpl extends AbstractService<AnalysisLengthTimeDay> implements AnalysisLengthTimeDayService {

    @Resource
    private AnalysisLengthTimeDayMapper analysisLengthTimeDayMapper;

	@Override
	public List<AnalysisLengthTimeDay> getAnalysisLengthTimeDayDatas(String dateTime) {
		return analysisLengthTimeDayMapper.getAnalysisLengthTimeDayDatas(dateTime);
	}

	@Override
	public void deleteLenthTimeDayDatas(String month) {
		analysisLengthTimeDayMapper.deleteLenthTimeDayDatas(month);
	}

}
