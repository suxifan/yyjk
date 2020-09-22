package com.cictec.yyjk.linenet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetIndexDeaLinescoreMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaLinescore;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaLinescoreValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.service.NetIndexDeaLinescoreService;

/**
 * Created by mao on 2019/10/17.
 */
@Service
@Transactional
public class NetIndexDeaLinescoreServiceImpl extends AbstractService<NetIndexDeaLinescore>
		implements NetIndexDeaLinescoreService {

	@Resource
	private NetIndexDeaLinescoreMapper netIndexDeaLinescoreMapper;

	@Override
	public GridChartOption getDeaLineScoreGrid(NetDataBuslineVo vo) {
		List<NetIndexDeaLinescoreValue> deaLinescorelist = netIndexDeaLinescoreMapper.getDeaLineScoreList(vo);
		if (deaLinescorelist == null) {
			return new GridChartOption();
		}
		List<String> xAxisNames = new ArrayList<String>();
		List<Float> scoreData = new ArrayList<>();
		List<Float> staRationalData = new ArrayList<>();
		List<Float> safeRationalData = new ArrayList<>();
		List<Float> conRationalData = new ArrayList<>();
		List<Float> rapRationalData = new ArrayList<>();
		for (NetIndexDeaLinescoreValue item : deaLinescorelist) {
			xAxisNames.add(item.getLineNumber());
			scoreData.add(Float.parseFloat(item.getScore() + ""));
			staRationalData.add(Float.parseFloat(item.getStaRational() + ""));
			safeRationalData.add(Float.parseFloat(item.getSafeRational() + ""));
			conRationalData.add(Float.parseFloat(item.getConRational() + ""));
			rapRationalData.add(Float.parseFloat(item.getRapRational() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(scoreData);
		datas.add(staRationalData);
		datas.add(safeRationalData);
		datas.add(conRationalData);
		datas.add(rapRationalData);
		List<String> legendNames = new ArrayList<>();
		legendNames.add("总得分");
		legendNames.add("站位设置合理性评分");
		legendNames.add("舒适性评分");
		legendNames.add("便捷性评分");
		legendNames.add("快捷性评分");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public List<NetIndexDeaLinescoreValue> getDeaLineScoreListData(NetDataBuslineVo vo) {
		List<NetIndexDeaLinescoreValue> list = netIndexDeaLinescoreMapper.getDeaLineScoreList(vo);
		return list;
	}
}
