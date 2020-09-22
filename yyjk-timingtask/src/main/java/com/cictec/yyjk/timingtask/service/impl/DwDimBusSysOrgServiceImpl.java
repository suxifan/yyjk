package com.cictec.yyjk.timingtask.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.DwDimBusSysOrgMapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusSysOrg;
import com.cictec.yyjk.timingtask.service.DwDimBusSysOrgService;


/**
 * Created by xpguo on 2019/09/25.
 */
@Service
@Transactional
public class DwDimBusSysOrgServiceImpl extends AbstractService<DwDimBusSysOrg> implements DwDimBusSysOrgService {

    @Resource
    private DwDimBusSysOrgMapper dwDimBusSysOrgMapper;

	@Override
	public void clearTabel() {
		dwDimBusSysOrgMapper.clearTabel();
	}

	@Override
	public Map<String, DwDimBusSysOrg> getBusSysOrgDisc() {
		List<DwDimBusSysOrg> list = dwDimBusSysOrgMapper.selectAll();
		if (list == null) {
			return Collections.emptyMap();
		}
		Map<String, DwDimBusSysOrg> result = new HashMap<>();
		for (DwDimBusSysOrg item : list) {
			if (!result.keySet().contains(item.getOrgUuid())) {
				result.put(item.getOrgUuid(), item);
			}
		}
		return result;
	}

}
