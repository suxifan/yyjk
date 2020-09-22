package com.cictec.yyjk.linenet.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetDataBusstationMapper;
import com.cictec.yyjk.linenet.model.entity.NetDataBusstation;
import com.cictec.yyjk.linenet.service.NetDataBusstationService;

/**
 * Created by mao on 2019/10/12.
 */
@Service
@Transactional
public class NetDataBusstationServiceImpl extends AbstractService<NetDataBusstation>
		implements NetDataBusstationService {
	@Resource
	private NetDataBusstationMapper netDataBusstationMapper;
}
