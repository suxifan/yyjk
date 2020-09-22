package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.TempBusScheduleMapper;
import com.cictec.yyjk.timingtask.model.entity.TempBusSchedule;
import com.cictec.yyjk.timingtask.service.TempBusScheduleService;


/**
 * Created by xpguo on 2019/09/26.
 */
@Service
@Transactional
public class TempBusScheduleServiceImpl extends AbstractService<TempBusSchedule> implements TempBusScheduleService {

    @Resource
    private TempBusScheduleMapper tempBusScheduleMapper;

	@Override
	public void clearTabel() {
		tempBusScheduleMapper.clearTabel();
	}

	@Override
	public Map<String, TempBusSchedule> getScheduleDisc() {
		List<TempBusSchedule> list = tempBusScheduleMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, TempBusSchedule> scheduleMap = new HashMap<>();
		for (TempBusSchedule item : list) {
			String scheduleUuid = item.getBsUuid();
			if (!scheduleMap.keySet().contains(scheduleUuid)) {
				scheduleMap.put(scheduleUuid, item);
			}
		}
		return scheduleMap;
	}

}
