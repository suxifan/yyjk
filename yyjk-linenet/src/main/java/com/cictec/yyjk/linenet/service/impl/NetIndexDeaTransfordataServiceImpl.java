package com.cictec.yyjk.linenet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetIndexDeaTransfordataMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaTransfordata;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaTransfordataValue;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;
import com.cictec.yyjk.linenet.service.NetIndexDeaTransfordataService;

/**
 * Created by mao on 2019/10/18.
 */
@Service
@Transactional
public class NetIndexDeaTransfordataServiceImpl extends AbstractService<NetIndexDeaTransfordata>
		implements NetIndexDeaTransfordataService {

	@Resource
	private NetIndexDeaTransfordataMapper netIndexDeaTransfordataMapper;

	@Override
	public List<NetIndexDeaTransfordataValue> getDeaDataListData(NetXmlConfigVo vo) {
		// bar
		List<NetIndexDeaTransfordataValue> list = netIndexDeaTransfordataMapper.getDeaDataList(vo);
		return list;
	}
}
