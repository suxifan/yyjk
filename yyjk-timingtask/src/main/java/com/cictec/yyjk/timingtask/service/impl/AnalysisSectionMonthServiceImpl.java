package com.cictec.yyjk.timingtask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisSectionMonthMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisSectionMonth;
import com.cictec.yyjk.timingtask.service.AnalysisSectionMonthService;


/**
 * Created by xpguo on 2019/05/22.
 */
@Service
@Transactional
public class AnalysisSectionMonthServiceImpl extends AbstractService<AnalysisSectionMonth> implements AnalysisSectionMonthService {

    @Resource
    private AnalysisSectionMonthMapper analysisPrfSectionMonthMapper;

	@Override
	public List<AnalysisSectionMonth> getAnalysisSectionMonthDatas(String month) {
		return analysisPrfSectionMonthMapper.getAnalysisSectionMonthDatas(month);
	}

}
