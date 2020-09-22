package com.cictec.yyjk.linenet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetIndexRepeatArrowMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatArrow;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatArrowService;

/**
 * Created by mao on 2019/10/14.
 */
@Service
@Transactional
public class NetIndexRepeatArrowServiceImpl extends AbstractService<NetIndexRepeatArrow>
		implements NetIndexRepeatArrowService {

	@Resource
	private NetIndexRepeatArrowMapper netIndexRepeatArrowMapper;

	@Override
	public List<NetIndexRepeatArrow> getCompanyLineRepeatListData(NetDataBuslineVo vo) {
		// bar
		List<NetIndexRepeatArrow> list = netIndexRepeatArrowMapper.getCompanyLineRepeatList(vo);
		return list;
	}

	@Override
	public List<NetIndexRepeatArrow> getLineRepeatTOP10ListData(NetDataBuslineVo vo) {
		// bar
		List<NetIndexRepeatArrow> list = netIndexRepeatArrowMapper.getLineRepeatTOP10List(vo);
		return list;
	}
}
