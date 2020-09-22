package com.cictec.yyjk.linenet.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetDataConfigMapper;
import com.cictec.yyjk.linenet.model.entity.NetDataConfig;
import com.cictec.yyjk.linenet.model.view.NetDataConfigValue;
import com.cictec.yyjk.linenet.service.NetDataConfigService;

/**
 * Created by mao on 2019/10/17.
 */
@Service
@Transactional
public class NetDataConfigServiceImpl extends AbstractService<NetDataConfig> implements NetDataConfigService {

	@Resource
	private NetDataConfigMapper netDataConfigMapper;

	@Override
	public NetDataConfigValue getDeareslutConfigXMLData(NetDataConfig vo) {
		// bar
		NetDataConfigValue netDataConfigValue = netDataConfigMapper.getDeareslutConfigXML(vo);
		return netDataConfigValue;
	}

	@Override
	public void clearTabel() {
		netDataConfigMapper.clearTabel();
	}
}
