package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimBusLineDeviceIdMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLineDeviceId;
import com.cictec.yyjk.timingtask.service.DwDimBusLineDeviceIdService;


/**
 * Created by xpguo on 2019/12/26.
 */
@Service
@Transactional
public class DwDimBusLineDeviceIdServiceImpl extends AbstractService<DwDimBusLineDeviceId> implements DwDimBusLineDeviceIdService {

    @Resource
    private DwDimBusLineDeviceIdMapper dwDimBusLineDeviceIdMapper;

	@Override
	public Map<String, DwDimBusLineDeviceId> getLineDeviceIdDisc() {
		List<DwDimBusLineDeviceId> list = dwDimBusLineDeviceIdMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimBusLineDeviceId> resMap = new HashMap<>();
		for (DwDimBusLineDeviceId item : list) {
			String busUuid = item.getBldUuid();
			if (!resMap.keySet().contains(busUuid)) {
				resMap.put(busUuid, item);
			}
		}
		return resMap;
	}

}
