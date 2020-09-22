package com.cictec.yyjk.timingtask.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisCapacityVolumeDayMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisCapacityVolumeDay;
import com.cictec.yyjk.timingtask.service.AnalysisCapacityVolumeDayService;


/**
 * Created by xpguo on 2019/05/22.
 */
@Service
@Transactional
public class AnalysisCapacityVolumeDayServiceImpl extends AbstractService<AnalysisCapacityVolumeDay> implements AnalysisCapacityVolumeDayService {

    @Resource
    private AnalysisCapacityVolumeDayMapper analysisPrfCapacityVolumeDayMapper;

	@Override
	public List<AnalysisCapacityVolumeDay> getAnalysisCapacityVolumeDayDatas(Date startTime, Date endTime) {
		return analysisPrfCapacityVolumeDayMapper.getAnalysisCapacityVolumeDayDatas(startTime, endTime);
	}

}
