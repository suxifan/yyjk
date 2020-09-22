package com.cictec.yyjk.timingtask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisArriveVolumeDayMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisArriveVolumeDay;
import com.cictec.yyjk.timingtask.service.AnalysisArriveVolumeDayService;


/**
 * Created by xpguo on 2019/05/23.
 */
@Service
@Transactional
public class AnalysisArriveVolumeDayServiceImpl extends AbstractService<AnalysisArriveVolumeDay> implements AnalysisArriveVolumeDayService {

    @Resource
    private AnalysisArriveVolumeDayMapper analysisArriveVolumeDayMapper;

	@Override
	public List<String> getLineIds(String dateTime) {
		return analysisArriveVolumeDayMapper.getLineIds(dateTime);
	}

	@Override
	public List<AnalysisArriveVolumeDay> getAnalysisArriveVolumeDatas(String lineId, String dateTime) {
		return analysisArriveVolumeDayMapper.getAnalysisArriveVolumeDatas(lineId, dateTime);
	}
}
