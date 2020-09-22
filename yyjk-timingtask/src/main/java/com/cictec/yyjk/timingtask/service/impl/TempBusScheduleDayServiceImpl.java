package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.TempBusScheduleDayMapper;
import com.cictec.yyjk.timingtask.model.entity.TempBusScheduleDay;
import com.cictec.yyjk.timingtask.service.TempBusScheduleDayService;


/**
 * Created by xpguo on 2019/09/26.
 */
@Service
@Transactional
public class TempBusScheduleDayServiceImpl extends AbstractService<TempBusScheduleDay> implements TempBusScheduleDayService {

    @Resource
    private TempBusScheduleDayMapper tempBusScheduleDayMapper;

	@Override
	public void clearTabel() {
		tempBusScheduleDayMapper.clearTabel();
	}

	@Override
	public Map<String, TempBusScheduleDay> getScheduleDayDisc() {
		List<TempBusScheduleDay> list = tempBusScheduleDayMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, TempBusScheduleDay> scheduleDayMap = new HashMap<>();
		for (TempBusScheduleDay item : list) {
			String scheduleDayUuid = item.getBsdUuid();
			if (!scheduleDayMap.keySet().contains(scheduleDayUuid)) {
				scheduleDayMap.put(scheduleDayUuid, item);
			}
		}
		return scheduleDayMap;
	}
}
