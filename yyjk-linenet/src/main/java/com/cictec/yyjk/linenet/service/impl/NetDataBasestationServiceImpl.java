package com.cictec.yyjk.linenet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetDataBasestationMapper;
import com.cictec.yyjk.linenet.mapper.NetDataBusstationMapper;
import com.cictec.yyjk.linenet.model.entity.NetDataBasestation;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetDataBasestationValue;
import com.cictec.yyjk.linenet.model.view.NetDataBusstationValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBasestationVo;
import com.cictec.yyjk.linenet.service.NetDataBasestationService;

/**
 * Created by xpguo on 2019/10/12.
 */
@Service
@Transactional
public class NetDataBasestationServiceImpl extends AbstractService<NetDataBasestation>
		implements NetDataBasestationService {

	@Resource
	private NetDataBasestationMapper netDataBasestationMapper;
	@Resource
	private NetDataBusstationMapper netDataBusstationMapper;

	@Override
	public GridChartOption getCompanyEchartData(NetDataBasestationVo vo) {
		// bar
		List<NetDataBasestationValue> basestationlist = netDataBasestationMapper.getCompanyBaseStations(vo);
		if (basestationlist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> data = new ArrayList<>();
		for (NetDataBasestationValue item : basestationlist) {
			xAxisNames.add(item.getCompany());
			data.add(Float.parseFloat(item.getBasestations()));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(data);

		List<NetDataBusstationValue> busstationlist = netDataBusstationMapper.getCompanyBusStations(vo);
		if (busstationlist != null) {
			List<Float> busstationData = new ArrayList<>();
			for (NetDataBusstationValue bean : busstationlist) {
				busstationData.add(Float.parseFloat(bean.getBusstations()));
			}
			datas.add(busstationData);
		}
		List<String> legendNames = new ArrayList<>();
		legendNames.add("站点数");
		legendNames.add("站位数");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public List<NetDataBasestationValue> getAllBaseStationNamesListData(NetDataBasestationVo vo) {
		// bar
		List<NetDataBasestationValue> list = netDataBasestationMapper.getAllBaseStationNames(vo);
		return list;
	}

}
