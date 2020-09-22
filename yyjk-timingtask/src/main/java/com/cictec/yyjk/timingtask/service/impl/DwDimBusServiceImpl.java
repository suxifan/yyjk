package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimBusMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBus;
import com.cictec.yyjk.timingtask.service.DwDimBusService;


/**
 * Created by xpguo on 2019/09/25.
 */
@Service
@Transactional
public class DwDimBusServiceImpl extends AbstractService<DwDimBus> implements DwDimBusService {

    @Resource
    private DwDimBusMapper dwDimBusMapper;

	@Override
	public void clearTabel() {
		dwDimBusMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimBus> getBusDisc() {
		List<DwDimBus> list = dwDimBusMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimBus> resMap = new HashMap<>();
		for (DwDimBus item : list) {
			String busUuid = item.getBusUuid();
			if (!resMap.keySet().contains(busUuid)) {
				resMap.put(busUuid, item);
			}
		}
		return resMap;
	}

}
