package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimMapLineMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimMapLine;
import com.cictec.yyjk.timingtask.service.DwDimMapLineService;


/**
 * Created by xpguo on 2019/09/24.
 */
@Service
@Transactional
public class DwDimMapLineServiceImpl extends AbstractService<DwDimMapLine> implements DwDimMapLineService {

    @Resource
    private DwDimMapLineMapper dwDimMapLineMapper;

	@Override
	public void clearTabel() {
		dwDimMapLineMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimMapLine> getMapLineDisc() {
		List<DwDimMapLine> list = dwDimMapLineMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimMapLine> devMap = new HashMap<>();
		for (DwDimMapLine item : list) {
			String mlUuid = item.getMlUuid();
			if (!devMap.keySet().contains(mlUuid)) {
				devMap.put(mlUuid, item);
			}
		}
		return devMap;
	}

}
