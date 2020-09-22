package com.cictec.yyjk.linenet.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetXmlDeaBaseConfigMapper;
import com.cictec.yyjk.linenet.model.entity.NetXmlDeaBaseConfig;
import com.cictec.yyjk.linenet.model.view.NetXmlDeaBaseConfigValue;
import com.cictec.yyjk.linenet.service.NetXmlDeaBaseConfigService;

/**
 * Created by mao on 2019/10/22.
 */
@Service
@Transactional
public class NetXmlDeaBaseConfigServiceImpl extends AbstractService<NetXmlDeaBaseConfig>
		implements NetXmlDeaBaseConfigService {

	@Resource
	private NetXmlDeaBaseConfigMapper netXmlDeaBaseConfigMapper;

	@Override
	public void clearTabel() {
		netXmlDeaBaseConfigMapper.clearTabel();
	}

	@Override
	public Map<String, String> getDeaBaseConfigListData() {
		// bar
		List<NetXmlDeaBaseConfigValue> lists = netXmlDeaBaseConfigMapper.getDeaBaseConfigList();
		Map<String, String> map = new HashMap<String, String>();
		if (lists == null) {
			return Collections.emptyMap();
		}

		for (NetXmlDeaBaseConfigValue list : lists) {
			map.put(list.getColName(), list.getColValue());
		}
		return map;
	}
}
