package com.cictec.yyjk.linenet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetIndexRepeatCompanyMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatCompany;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexRepeatCompanyValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.service.NetIndexRepeatCompanyService;

/**
 * Created by mao on 2019/10/14.
 */
@Service
@Transactional
public class NetIndexRepeatCompanyServiceImpl extends AbstractService<NetIndexRepeatCompany>
		implements NetIndexRepeatCompanyService {

	@Resource
	private NetIndexRepeatCompanyMapper netIndexRepeatCompanyMapper;

	@Override
	public GridChartOption getCompanyLineRepeatEchartData(NetDataBuslineVo vo) {
		// bar
		List<NetIndexRepeatCompanyValue> companyLineRepeatlist = netIndexRepeatCompanyMapper.getCompanyLineRepeat(vo);
		if (companyLineRepeatlist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> scCountData = new ArrayList<>();
		List<Float> repeatScCountData = new ArrayList<>();
		List<Float> repeatabilityData = new ArrayList<>();
		for (NetIndexRepeatCompanyValue item : companyLineRepeatlist) {
			xAxisNames.add(item.getCompany());
			scCountData.add(Float.parseFloat(item.getScCount() + ""));
			repeatScCountData.add(Float.parseFloat(item.getRepeatScCount() + ""));
			repeatabilityData.add(Float.parseFloat(item.getRepeatability() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(scCountData);
		datas.add(repeatScCountData);
		datas.add(repeatabilityData);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("站对比");
		legendNames.add("重复站位数");
		legendNames.add("重复比");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

}
