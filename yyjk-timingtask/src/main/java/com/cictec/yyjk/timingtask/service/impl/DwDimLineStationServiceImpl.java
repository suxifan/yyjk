package com.cictec.yyjk.timingtask.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimLineStationMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimLineStation;
import com.cictec.yyjk.timingtask.service.DwDimLineStationService;

/**
 * Created by xpguo on 2019/09/26.
 */
@Service
@Transactional
public class DwDimLineStationServiceImpl extends AbstractService<DwDimLineStation> implements DwDimLineStationService {

	@Resource
	private DwDimLineStationMapper dwDimLineStationMapper;

	@Override
	public void clearTabel() {
		dwDimLineStationMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimLineStation> getLineStaDisc() {
		List<DwDimLineStation> list = dwDimLineStationMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimLineStation> devMap = new HashMap<>();
		for (DwDimLineStation item : list) {
			String lsUuid = item.getLsUuid();
			if (!devMap.keySet().contains(lsUuid)) {
				devMap.put(lsUuid, item);
			}
		}
		return devMap;
	}

	@Override
	public Map<String, String> getLineStationBetweenDistanceDisc() {
		List<DwDimLineStation> queryList = dwDimLineStationMapper.getLineStationBetweenDistance();
		if (CollectionUtils.isEmpty(queryList)) {
			return Collections.emptyMap();
		}
		Map<String, List<DwDimLineStation>> map = new HashMap<>();
		for (DwDimLineStation bean : queryList) {
			String key = bean.getLsLineUuid() + bean.getLsLineType();
			if (map.containsKey(key)) {
				map.get(key).add(bean);
			} else {
				List<DwDimLineStation> lineStations = new ArrayList<>();
				DwDimLineStation firstBean = new DwDimLineStation();
				firstBean.setLsLineUuid(bean.getLsLineUuid());
				firstBean.setLsLineType(bean.getLsLineType());
				firstBean.setLsSequence(1);
				firstBean.setLsBetweenDistance("0");
				lineStations.add(firstBean);
				lineStations.add(bean);
				map.put(key, lineStations);
			}
		}

		Map<String, String> disc = new HashMap<>();
		for (String key : map.keySet()) {
			List<DwDimLineStation> list = map.get(key);
			for (DwDimLineStation item : list) {
				String discKey = item.getLsLineUuid() + item.getLsLineType() + item.getLsSequence();
				disc.put(discKey, item.getLsBetweenDistance());
			}
		}
		return disc;
	}

	@Override
	public List<String> getLineStaSeqs(String lineUuid, String lineType) {
		return dwDimLineStationMapper.getLineStaSeqs(lineUuid, lineType);
	}

	@Override
	public List<DwDimLineStation> getAll() {
		return dwDimLineStationMapper.getAll();
	}

}
