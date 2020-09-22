package com.cictec.yyjk.timingtask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisLengthTimeMonthMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeMonth;
import com.cictec.yyjk.timingtask.service.AnalysisLengthTimeMonthService;


/**
 * Created by xpguo on 2019/05/22.
 */
@Service
@Transactional
public class AnalysisLengthTimeMonthServiceImpl extends AbstractService<AnalysisLengthTimeMonth> implements AnalysisLengthTimeMonthService {

    @Resource
    private AnalysisLengthTimeMonthMapper analysisLengthTimeMonthMapper;

	@Override
	public List<AnalysisLengthTimeMonth> getAnalysisLengthTimeMonthDatas(String month) {
		return analysisLengthTimeMonthMapper.getAnalysisLengthTimeMonthDatas(month);
	}

}
