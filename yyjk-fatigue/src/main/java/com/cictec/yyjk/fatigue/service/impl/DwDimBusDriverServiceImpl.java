package com.cictec.yyjk.fatigue.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.fatigue.mapper.DwDimBusDriverMapper;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.model.vo.DwDimBusDriverVo;
import com.cictec.yyjk.fatigue.service.DwDimBusDriverService;

/**
 * Created by xpguo on 2019/09/25.
 */
@Service
@Transactional
public class DwDimBusDriverServiceImpl extends AbstractService<DwDimBusDriver> implements DwDimBusDriverService {

	@Resource
	private DwDimBusDriverMapper dwDimBusDriverMapper;

	@Override
	public void clearTabel() {
		dwDimBusDriverMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimBusDriver> getDriverDisc() {
		List<DwDimBusDriver> list = dwDimBusDriverMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimBusDriver> resultMap = new HashMap<>();
		for (DwDimBusDriver item : list) {
			String driverUuid = item.getDrvUuid();
			if (!resultMap.keySet().contains(driverUuid)) {
				resultMap.put(driverUuid, item);
			}
		}
		return resultMap;
	}

	@Override
	public List<DwDimBusDriver> selectAllBusDriver(DwDimBusDriverVo dwDimBusDriverVo) {
		// 根据数据权限过滤
		return dwDimBusDriverMapper.selectAllBusDriver(dwDimBusDriverVo);
	}

	@Override
	public List<DwDimBusDriver> selectAllBusDriverInfo() {
		// 根据数据权限过滤
		return dwDimBusDriverMapper.selectAllBusDriverInfo();
	}

}
