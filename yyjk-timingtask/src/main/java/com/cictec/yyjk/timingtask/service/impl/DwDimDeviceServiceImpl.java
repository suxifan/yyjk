package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimDeviceMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimDevice;
import com.cictec.yyjk.timingtask.service.DwDimDeviceService;


/**
 * Created by xpguo on 2019/09/25.
 */
@Service
@Transactional
public class DwDimDeviceServiceImpl extends AbstractService<DwDimDevice> implements DwDimDeviceService {

    @Resource
    private DwDimDeviceMapper dwDimDeviceMapper;

	@Override
	public void clearTabel() {
		dwDimDeviceMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimDevice> getDeviceDisc() {
		List<DwDimDevice> list = dwDimDeviceMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimDevice> devMap = new HashMap<>();
		for (DwDimDevice item : list) {
			String devUuid = item.getDevUuid();
			if (!devMap.keySet().contains(devUuid)) {
				devMap.put(devUuid, item);
			}
		}
		return devMap;
	}

}
