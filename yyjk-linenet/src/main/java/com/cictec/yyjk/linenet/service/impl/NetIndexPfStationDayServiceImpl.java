package com.cictec.yyjk.linenet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.linenet.mapper.NetIndexPfStationDayMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfStationDay;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexPfBaseValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.service.NetIndexPfStationDayService;

/**
 * Created by mao on 2019/10/15.
 */
@Service
@Transactional
public class NetIndexPfStationDayServiceImpl extends AbstractService<NetIndexPfStationDay>
		implements NetIndexPfStationDayService {

	@Resource
	private NetIndexPfStationDayMapper netIndexPfStationDayMapper;

	@Override
	public GridChartOption getPfStationDayListGridData(NetIndexPfBaseVo vo) {
		// bar
		String arrow = vo.getArrow();
		if (PMSUtils.isNotEmpty(arrow)) {
			if ("1".equals(arrow)) {
				vo.setArrow("上行");
			} else if ("2".equals(arrow)) {
				vo.setArrow("下行");
			} else {
				vo.setArrow("");
			}
		}
		List<NetIndexPfBaseValue> pfStationDaylist = netIndexPfStationDayMapper.getPfStationDayList(vo);
		if (pfStationDaylist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> upCountData = new ArrayList<>();
		List<Float> downCountData = new ArrayList<>();
		for (NetIndexPfBaseValue item : pfStationDaylist) {
			xAxisNames.add(item.getStationName());
			upCountData.add(Float.parseFloat(item.getUpCount() + ""));
			downCountData.add(Float.parseFloat(item.getDownCount() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(upCountData);
		datas.add(downCountData);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("登量(人次)");
		legendNames.add("降量(人次)");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}
}
