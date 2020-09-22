package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimBusStationMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusStation;
import com.cictec.yyjk.timingtask.service.DwDimBusStationService;


/**
 * Created by xpguo on 2019/09/25.
 */
@Service
@Transactional
public class DwDimBusStationServiceImpl extends AbstractService<DwDimBusStation> implements DwDimBusStationService {

    @Resource
    private DwDimBusStationMapper dwDimBusStationMapper;

	@Override
	public void clearTabel() {
		dwDimBusStationMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimBusStation> getStationDisc() {
		List<DwDimBusStation> list = dwDimBusStationMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimBusStation> stationMap = new HashMap<>();
		for (DwDimBusStation item : list) {
			String staUuid = item.getStaUuid();
			if (!stationMap.keySet().contains(staUuid)) {
				stationMap.put(staUuid, item);
			}
		}
		return stationMap;
	}

}
