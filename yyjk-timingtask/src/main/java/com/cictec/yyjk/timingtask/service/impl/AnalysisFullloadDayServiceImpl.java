package com.cictec.yyjk.timingtask.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.AnalysisFullloadDayMapper;
import com.cictec.yyjk.timingtask.model.entity.AnalysisFullloadDay;
import com.cictec.yyjk.timingtask.service.AnalysisFullloadDayService;


/**
 * Created by xpguo on 2019/05/22.
 */
@Service
@Transactional
public class AnalysisFullloadDayServiceImpl extends AbstractService<AnalysisFullloadDay> implements AnalysisFullloadDayService {

    @Resource
    private AnalysisFullloadDayMapper analysisPrfFullloadDayMapper;

	@Override
	public List<AnalysisFullloadDay> getAnalysisFullload(Date startTime, Date endTime) {
		return analysisPrfFullloadDayMapper.getAnalysisFullload(startTime, endTime);
	}

	@Override
	public List<AnalysisFullloadDay> getYesterdayOnOffLineChartDatas(Date startTime, Date endTime, String orgId) {
		return analysisPrfFullloadDayMapper.getYesterdayOnOffLineChartDatas(startTime, endTime, orgId);
	}

	@Override
	public List<AnalysisFullloadDay> getOnOffLineChartDatas(String orgId) {
		Calendar calendar = Calendar.getInstance();
		String hour = new SimpleDateFormat("HH").format(calendar.getTime());
		List<AnalysisFullloadDay> result = new ArrayList<>();
		List<AnalysisFullloadDay> list = analysisPrfFullloadDayMapper.getOnOffLineChartDatas(orgId);
		for (AnalysisFullloadDay item : list) {
			if (item.getUploadTimeHour() <= Integer.parseInt(hour)) {
				result.add(item);
			}
		}
		return result;
	}
}
