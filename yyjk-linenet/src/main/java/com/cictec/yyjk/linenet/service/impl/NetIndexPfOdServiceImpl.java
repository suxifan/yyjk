package com.cictec.yyjk.linenet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.linenet.mapper.NetIndexPfOdMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfOd;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineOdValue;
import com.cictec.yyjk.linenet.model.view.NetIndexPfOdValue;
import com.cictec.yyjk.linenet.model.view.NodeLinkChart;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.service.NetIndexPfOdService;

/**
 * Created by mao on 2019/10/16.
 */
@Service
@Transactional
public class NetIndexPfOdServiceImpl extends AbstractService<NetIndexPfOd> implements NetIndexPfOdService {

	@Resource
	private NetIndexPfOdMapper netIndexPfOdMapper;

	@Override
	public GridChartOption getPfOdbrushCountListGridData(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfOdValue> pfOdlist = netIndexPfOdMapper.getPfOdbrushCountList(vo);
		if (pfOdlist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> brushCountData = new ArrayList<>();
		for (NetIndexPfOdValue item : pfOdlist) {
			xAxisNames.add(item.getpTime());
			brushCountData.add(Float.parseFloat(item.getBrushCount() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(brushCountData);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("刷卡总量");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public GridChartOption getPfOdZZLListGridData(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfOdValue> pfOdlist = netIndexPfOdMapper.getPfOdZZLAndPJYJList(vo);
		if (pfOdlist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> brushCountData = new ArrayList<>();
		for (NetIndexPfOdValue item : pfOdlist) {
			xAxisNames.add(item.getpTime());
			brushCountData.add(Float.parseFloat(item.getZzl() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(brushCountData);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("周转量");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public GridChartOption getPfOdPJYJListGridData(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfOdValue> pfOdlist = netIndexPfOdMapper.getPfOdZZLAndPJYJList(vo);
		if (pfOdlist == null) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<String>();
		List<Float> brushCountData = new ArrayList<>();
		for (NetIndexPfOdValue item : pfOdlist) {
			xAxisNames.add(item.getpTime());
			brushCountData.add(Float.parseFloat(item.getPjyj() + ""));
		}
		List<List<Float>> datas = new ArrayList<>();
		datas.add(brushCountData);

		List<String> legendNames = new ArrayList<>();
		legendNames.add("平均运距");
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		option.setLegendNames(legendNames);
		return option;
	}

	@Override
	public List<NetIndexPfLineOdValue> getPfLineOdCountListData(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfLineOdValue> list = netIndexPfOdMapper.getPfLineOdCountList(vo);
		return list;
	}

	@Override
	public List<NetIndexPfLineOdValue> getPfODXCountListData(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfLineOdValue> list = netIndexPfOdMapper.getPfODXCountList(vo);
		return list;
	}

	@Override
	public List<NetIndexPfLineOdValue> getPfODEdgesList(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfLineOdValue> list = netIndexPfOdMapper.getPfLineOdCountList(vo);
		return list;
	}

	@Override
	public NodeLinkChart getPfODYCountListData(NetIndexPfBaseVo vo) {
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
		List<NetIndexPfLineOdValue> pfedgeslist = netIndexPfOdMapper.getPfODEdgesList(vo);
		if (pfedgeslist == null) {
			return new NodeLinkChart();
		}
		// 将上下车的站名都塞入X轴
		List<NetIndexPfLineOdValue> pfxlist = netIndexPfOdMapper.getPfODXCountList(vo);
		// List<NetIndexPfLineOdValue> pfxeStationlist =
		// netIndexPfOdMapper.getPfODXEStationCountList(vo);
		// for (NetIndexPfLineOdValue bean1 : pfxlist) {
		// Contains(obj);
		// for (NetIndexPfLineOdValue bean2 : pfxeStationlist) {
		// if (Contains(obj)) {
		// pfxlist.add(bean2);
		// }
		// }
		// }
		NodeLinkChart chart = new NodeLinkChart();
		chart.setEdges(pfedgeslist);
		chart.setNodes(pfxlist);
		return chart;
	}

}
