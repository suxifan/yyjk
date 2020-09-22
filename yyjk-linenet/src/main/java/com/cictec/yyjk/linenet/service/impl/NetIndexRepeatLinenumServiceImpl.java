package com.cictec.yyjk.linenet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetIndexRepeatLinenumMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatLinenum;
import com.cictec.yyjk.linenet.model.view.GridRadarOption;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatLinenumService;

/**
 * Created by mao on 2019/10/14.
 */
@Service
@Transactional
public class NetIndexRepeatLinenumServiceImpl extends AbstractService<NetIndexRepeatLinenum>
		implements NetIndexRepeatLinenumService {

	@Resource
	private NetIndexRepeatLinenumMapper netIndexRepeatLinenumMapper;

	@Override
	public GridRadarOption getCompanyLineNumRepeatPieData(NetDataBuslineVo vo) {
		// bar
		List<NetIndexRepeatLinenum> repeatLinenumlist = netIndexRepeatLinenumMapper.getCompanyLineNumRepeat(vo);
		if (repeatLinenumlist == null) {
			return new GridRadarOption();
		}

		List<String> radarNames = new ArrayList<String>();
		List<Float> data = new ArrayList<>();
		for (NetIndexRepeatLinenum item : repeatLinenumlist) {
			radarNames.add(item.getLineNumber());
			data.add(item.getRepeatability());
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(data);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("线路重复度");
		GridRadarOption option = new GridRadarOption();
		option.setDatas(datas);
		option.setRadarNames(radarNames);
		option.setLegendNames(legendNames);
		return option;
	}

}
