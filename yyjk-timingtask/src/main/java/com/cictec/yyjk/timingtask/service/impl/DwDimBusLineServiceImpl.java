package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimBusLineMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLine;
import com.cictec.yyjk.timingtask.service.DwDimBusLineService;


/**
 * Created by xpguo on 2019/09/26.
 */
@Service
@Transactional
public class DwDimBusLineServiceImpl extends AbstractService<DwDimBusLine> implements DwDimBusLineService {

    @Resource
    private DwDimBusLineMapper dwDimBusLineMapper;

	@Override
	public void clearTabel() {
		dwDimBusLineMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimBusLine> getLineDisc() {
		List<DwDimBusLine> list = dwDimBusLineMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimBusLine> resultMap = new HashMap<>();
		for (DwDimBusLine item : list) {
			String lineUuid = item.getLineUuid();
			if (!resultMap.keySet().contains(lineUuid)) {
				resultMap.put(lineUuid, item);
			}
		}
		return resultMap;
	}

}
