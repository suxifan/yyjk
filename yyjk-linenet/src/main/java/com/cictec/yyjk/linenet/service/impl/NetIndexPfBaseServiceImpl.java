package com.cictec.yyjk.linenet.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.linenet.mapper.NetIndexPfBaseMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfBase;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexPfBaseValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.service.NetIndexPfBaseService;

/**
 * Created by mao on 2019/10/14.
 */
@Service
@Transactional
public class NetIndexPfBaseServiceImpl extends AbstractService<NetIndexPfBase> implements NetIndexPfBaseService {

	@Resource
	private NetIndexPfBaseMapper netIndexPfBaseMapper;

	@Override
	public List<NetIndexPfBaseValue> getPfBaseListData(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfBaseValue> list = netIndexPfBaseMapper.getPfBaseList(vo);
		for (NetIndexPfBaseValue item : list) {
			BigDecimal b1 = BigDecimal.valueOf(item.getPassCount());
			BigDecimal b2 = BigDecimal.valueOf(item.getFullLoadNum());
			item.setApproval(b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP).floatValue());
		}
		return list;
	}

	@Override
	public GridChartOption getPfBaseApprovalGrid(NetIndexPfBaseVo vo) {
		// bar
		List<NetIndexPfBaseValue> approvallist = netIndexPfBaseMapper.getPfBaseApprovalList(vo);
		if (approvallist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> approvalData = new ArrayList<>();
		for (NetIndexPfBaseValue item : approvallist) {
			xAxisNames.add(item.getpTime());
			approvalData.add(Float.parseFloat(item.getApproval() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(approvalData);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("满载率");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public GridChartOption getPfBaseUpDownGrid(NetIndexPfBaseVo vo) {
		// bar
		List<NetIndexPfBaseValue> approvallist = netIndexPfBaseMapper.getPfBaseUpDownList(vo);
		if (approvallist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> upData = new ArrayList<>();
		List<Float> downData = new ArrayList<>();
		for (NetIndexPfBaseValue item : approvallist) {
			xAxisNames.add(item.getpTime());
			upData.add(Float.parseFloat(item.getUpCount() + ""));
			downData.add(Float.parseFloat(item.getDownCount() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(upData);
		datas.add(downData);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("登量");
		legendNames.add("降量");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}
}
