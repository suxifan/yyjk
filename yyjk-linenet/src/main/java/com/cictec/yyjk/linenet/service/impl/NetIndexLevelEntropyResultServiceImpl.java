package com.cictec.yyjk.linenet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetIndexLevelEntropyResultMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexLevelEntropyResult;
import com.cictec.yyjk.linenet.model.view.NetIndexLevelEntropyResultVoValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.service.NetIndexLevelEntropyResultService;

/**
 * Created by mao on 2019/10/17.
 */
@Service
@Transactional
public class NetIndexLevelEntropyResultServiceImpl extends AbstractService<NetIndexLevelEntropyResult>
		implements NetIndexLevelEntropyResultService {

	@Resource
	private NetIndexLevelEntropyResultMapper netIndexLevelEntropyResultMapper;

	@Override
	public List<NetIndexLevelEntropyResultVoValue> getLevelLineCountListData(NetDataBuslineVo vo) {
		// bar
		List<NetIndexLevelEntropyResultVoValue> list = netIndexLevelEntropyResultMapper.getLevelLineCountList(vo);
		return list;
	}
}
