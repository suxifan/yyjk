package com.cictec.yyjk.linenet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetXmlConfigMapper;
import com.cictec.yyjk.linenet.model.entity.NetXmlConfig;
import com.cictec.yyjk.linenet.model.view.NetXmlConfigValue;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;
import com.cictec.yyjk.linenet.service.NetXmlConfigService;

/**
 * Created by mao on 2019/10/18.
 */
@Service
@Transactional
public class NetXmlConfigServiceImpl extends AbstractService<NetXmlConfig> implements NetXmlConfigService {

	@Resource
	private NetXmlConfigMapper netXmlConfigMapper;

	@Override
	public List<NetXmlConfigValue> getSelectColumnListData(NetXmlConfigVo vo) {
		// bar
		List<NetXmlConfigValue> list = netXmlConfigMapper.getSelectColumn(vo);
		return list;
	}

	@Override
	public List<NetXmlConfigValue> getCodeListData(NetXmlConfigVo vo) {
		// bar
		List<NetXmlConfigValue> list = netXmlConfigMapper.getCodeList(vo);
		return list;
	}
}
