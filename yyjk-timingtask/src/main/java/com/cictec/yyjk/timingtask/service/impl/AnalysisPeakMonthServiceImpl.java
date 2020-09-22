package com.cictec.yyjk.timingtask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisPeakMonthMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPeakMonth;
import com.cictec.yyjk.timingtask.service.AnalysisPeakMonthService;


/**
 * Created by xpguo on 2019/05/22.
 */
@Service
@Transactional
public class AnalysisPeakMonthServiceImpl extends AbstractService<AnalysisPeakMonth> implements AnalysisPeakMonthService {

    @Resource
    private AnalysisPeakMonthMapper analysisPrfPeakMonthMapper;

	@Override
	public List<AnalysisPeakMonth> getAnalysisPeakMonthDatas(String month) {
		return analysisPrfPeakMonthMapper.getAnalysisPeakMonthDatas(month);
	}

}
