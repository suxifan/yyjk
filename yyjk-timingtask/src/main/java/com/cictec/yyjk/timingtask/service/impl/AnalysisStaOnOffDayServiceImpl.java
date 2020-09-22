package com.cictec.yyjk.timingtask.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisStaOnOffDayMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisStaOnOffDay;
import com.cictec.yyjk.timingtask.service.AnalysisStaOnOffDayService;


/**
 * Created by xpguo on 2019/05/22.
 */
@Service
@Transactional
public class AnalysisStaOnOffDayServiceImpl extends AbstractService<AnalysisStaOnOffDay> implements AnalysisStaOnOffDayService {

    @Resource
    private AnalysisStaOnOffDayMapper analysisPrfStaOnOffDayMapper;

	@Override
	public List<AnalysisStaOnOffDay> getAnalysisStaOnOffDayDatas(Date startTime, Date endTime) {
		return analysisPrfStaOnOffDayMapper.getAnalysisStaOnOffDayDatas(startTime, endTime);
	}

}
