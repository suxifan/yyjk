package com.cictec.yyjk.linenet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetIndexRepeatScMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatSc;
import com.cictec.yyjk.linenet.model.view.NetIndexRepeatScValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexRepeatScVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatScService;

/**
 * Created by mao on 2019/10/14.
 */
@Service
@Transactional
public class NetIndexRepeatScServiceImpl extends AbstractService<NetIndexRepeatSc> implements NetIndexRepeatScService {

	@Resource
	private NetIndexRepeatScMapper netIndexRepeatScMapper;

	@Override
	public List<NetIndexRepeatScValue> getCompanyLineRepeatScListData(NetIndexRepeatScVo vo) {
		// bar
		List<NetIndexRepeatScValue> list = netIndexRepeatScMapper.getCompanyLineRepeatScList(vo);
		return list;
	}
}
