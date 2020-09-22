package com.cictec.yyjk.linenet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.linenet.mapper.NetDataBuslineMapper;
import com.cictec.yyjk.linenet.model.entity.NetDataBusline;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetDataBuslineValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;
import com.cictec.yyjk.linenet.service.NetDataBuslineService;

/**
 * Created by xpguo on 2019/10/12.
 */
@Service
@Transactional
public class NetDataBuslineServiceImpl extends AbstractService<NetDataBusline> implements NetDataBuslineService {

	@Resource
	private NetDataBuslineMapper netDataBuslineMapper;

	@Override
	public List<NetDataBusline> getCompanyListData(NetDataBuslineVo vo) {
		// bar
		List<NetDataBusline> list = netDataBuslineMapper.getCompanyList(vo);
		return list;
	}

	@Override
	public List<NetDataBusline> getLineListData(NetDataBuslineVo vo) {
		// bar
		List<NetDataBusline> list = netDataBuslineMapper.getLineList(vo);
		return list;
	}

	@Override
	public GridChartOption getCompanyEchartData(NetDataBuslineVo vo) {
		// bar
		List<NetDataBuslineValue> lineCountslist = netDataBuslineMapper.getCompanyLineCounts(vo);
		if (lineCountslist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> data = new ArrayList<>();
		for (NetDataBuslineValue item : lineCountslist) {
			xAxisNames.add(item.getCompany());
			data.add(Float.parseFloat(item.getLineCounts()));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(data);

		List<NetDataBuslineValue> lineLengthslist = netDataBuslineMapper.getCompanyLineLengths(vo);
		if (lineLengthslist != null) {
			List<Float> lineLengthData = new ArrayList<>();
			for (NetDataBuslineValue bean : lineLengthslist) {
				lineLengthData.add(Float.parseFloat(bean.getLineLengths()));
			}
			datas.add(lineLengthData);
		}
		List<String> legendNames = new ArrayList<>();
		legendNames.add("线路总数");
		legendNames.add("线路长度");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public GridChartOption getLineOnOrDownEchartData(NetDataBuslineVo vo) {
		// bar
		List<NetDataBuslineValue> lineOnLengthslist = netDataBuslineMapper.getCompanyLineOnLengths(vo);
		if (lineOnLengthslist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> lineOnLengthData = new ArrayList<>();
		for (NetDataBuslineValue item : lineOnLengthslist) {
			xAxisNames.add(item.getLineName());
			lineOnLengthData.add(Float.parseFloat(item.getLineLengths()));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(lineOnLengthData);

		List<NetDataBuslineValue> lineDownLengthslist = netDataBuslineMapper.getCompanyLineDownLengths(vo);
		if (lineDownLengthslist != null) {
			List<Float> lineDownLengthData = new ArrayList<>();
			for (NetDataBuslineValue bean : lineDownLengthslist) {
				lineDownLengthData.add(Float.parseFloat(bean.getLineLengths()));
			}
			datas.add(lineDownLengthData);
		}

		List<String> legendNames = new ArrayList<>();
		legendNames.add("上行线路长度");
		legendNames.add("下行线路长度");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public List<NetDataBuslineValue> getCompanyLineListsData(NetDataBuslineVo vo) {
		// bar
		List<NetDataBuslineValue> list = netDataBuslineMapper.getCompanyLineLists(vo);
		return list;
	}

	@Override
	public List<NetDataBuslineValue> getCompanyLineCountsListData(NetDataBuslineVo vo) {
		// bar
		List<NetDataBuslineValue> list = netDataBuslineMapper.getCompanyLineCounts(vo);
		return list;
	}

}
