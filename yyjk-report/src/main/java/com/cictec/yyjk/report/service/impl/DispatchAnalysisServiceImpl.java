package com.cictec.yyjk.report.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.avg.Avg;
import org.elasticsearch.search.aggregations.metrics.avg.AvgBuilder;
import org.springframework.stereotype.Service;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.report.mapper.DispatchAnalysisMapper;
import com.cictec.yyjk.report.model.entity.DispatchAnalysis;
import com.cictec.yyjk.report.model.view.LineCongestionVo;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.GridChartQueryCondition;
import com.cictec.yyjk.report.model.vo.HeatmapOption;
import com.cictec.yyjk.report.model.vo.LineBetweenStationsRunningTimeAnalysisVo;
import com.cictec.yyjk.report.model.vo.LineCapacityAnalysisVo;
import com.cictec.yyjk.report.model.vo.LineInfoVo;
import com.cictec.yyjk.report.model.vo.LineStationAnalysisVo;
import com.cictec.yyjk.report.model.vo.LineStationInfoVo;
import com.cictec.yyjk.report.model.vo.LineStationQueryVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.SequenceDiagramAnalysisVo;
import com.cictec.yyjk.report.model.vo.StationInfoVo;
import com.cictec.yyjk.report.model.vo.StationOnOffAnalysisVo;
import com.cictec.yyjk.report.model.vo.StationOnOffQueryCondition;
import com.cictec.yyjk.report.service.DispatchAnalysisService;

@Service
public class DispatchAnalysisServiceImpl extends AbstractService<DispatchAnalysis> implements DispatchAnalysisService {
	@Resource
	private DispatchAnalysisMapper dispatchAnalysisMapper;

	@Override
	public List<LineInfoVo> getLineInfo() {
		return dispatchAnalysisMapper.getLineInfo();
	}

	@Override
	public List<StationInfoVo> getStationInfo() {
		// 同一个站名可能因为方向有几条记录，将同名站点下的所有uuid拼接起来作为uuid
		List<StationInfoVo> queryList = dispatchAnalysisMapper.getStationInfo();
		if(queryList == null || queryList.size() == 0){
			return Collections.emptyList();
		}
		Map<String,List<String>> map = new HashMap<>();
		for (StationInfoVo item : queryList) {
			String key = StringUtils.replaceBlank(item.getStaName());
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				list.add(item.getStaUuid());
				map.put(key, list);
			} else {
				map.get(key).add(item.getStaUuid());
			}
		}
		List<StationInfoVo> result = new ArrayList<>();
		for (String key : map.keySet()) {
			StringBuilder builder = new StringBuilder();
			List<String> list = map.get(key);
			Iterator<String> iterator = list.iterator();
			builder.append(iterator.next());
			while (iterator.hasNext()) {
				builder.append(",");
				builder.append(iterator.next());
			}
			result.add(new StationInfoVo(key, builder.toString()));
		}
		return result;
	}

	@Override
	public HeatmapOption getUpRushHourLinePassengerChartDatas(QueryCondition queryCondition) {
		List<DispatchAnalysis> queryResult = dispatchAnalysisMapper.getRushHourLinePassengerDatas(queryCondition);
		HeatmapOption heatmapOption = createRushHourHeahmapOption(queryResult);
		return heatmapOption;
	}

	@Override
	public HeatmapOption getDownRushHourLinePassengerChartDatas(QueryCondition queryCondition) {
		List<DispatchAnalysis> queryResult = dispatchAnalysisMapper.getRushHourLinePassengerDatas(queryCondition);
		HeatmapOption heatmapOption = createRushHourHeahmapOption(queryResult);
		return heatmapOption;
	}

	@Override
	public HeatmapOption getSectionLinePassengerChartDatas(QueryCondition queryCondition) {
		List<DispatchAnalysis> queryResult = dispatchAnalysisMapper.getSectionPassengerDatas(queryCondition);
		Map<String, List<DispatchAnalysis>> mapList = this.listToMap(queryResult);
		List<String> stations = dispatchAnalysisMapper.getLineStationNames(queryCondition);
		HeatmapOption heatmapOption = createSectionHeahmapOption(mapList, stations);
		return heatmapOption;
	}

	/**
	 * 构建客流高峰时刻热力图数据
	 * 
	 * @param queryResult
	 * @return
	 */
	private HeatmapOption createRushHourHeahmapOption(List<DispatchAnalysis> queryResult) {
		// 没有则直接返回
		if (queryResult == null || queryResult.size() == 0) {
			return new HeatmapOption();
		}
		Map<String, List<DispatchAnalysis>> mapList = this.listToMap(queryResult);
		// 补全数据
		for (String key : mapList.keySet()) {
			List<DispatchAnalysis> datas = mapList.get(key);
			if(datas.size()<24){
				mapList.put(key, this.completionDatas(datas));
			}
		}

		// 按周六到周日排序
		Map<String, List<DispatchAnalysis>> map = new LinkedHashMap<>();
		map.put("星期日", mapList.get("Sun"));
		map.put("星期六", mapList.get("Sat"));
		map.put("星期五", mapList.get("Fri"));
		map.put("星期四", mapList.get("Thur"));
		map.put("星期三", mapList.get("Wed"));
		map.put("星期二", mapList.get("Tue"));
		map.put("星期一", mapList.get("Mon"));
		HeatmapOption heatmapOption = new HeatmapOption();
		// 构建yAxisNames
		heatmapOption.setyAxisNames(new ArrayList<>(map.keySet()));
		// 构建xAxisNames
		List<String> xAxisNames = new ArrayList<>();
		if (!map.isEmpty()) {
			for (String key : map.keySet()) {
				List<DispatchAnalysis> mapItems = map.get(key);
				if (mapItems != null && mapItems.size() > 0) {
					Iterator<DispatchAnalysis> iterator = mapItems.iterator();
					while (iterator.hasNext()) {
						xAxisNames.add(iterator.next().getxAxisLabel());
					}
					break;
				}
			}
		}
		heatmapOption.setxAxisNames(xAxisNames);
		// 构建datas[[0,0,43]...]
		int index = 0;
		List<List<Float>> datas = new ArrayList<>();
		for (String key : map.keySet()) {
			List<DispatchAnalysis> list = map.get(key);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < 18; i++) {
					ArrayList<Float> data = new ArrayList<>();
					data.add(Float.parseFloat(index + ""));
					data.add(Float.parseFloat(i + ""));
					data.add(Float.parseFloat(list.get(i).getAnalysisNumber()));
					datas.add(data);
				}
			}
			index++;
		}
		heatmapOption.setDatas(datas);
		return heatmapOption;
	}

	/**
	 * 构建客流高峰断面图表数据
	 * 
	 * @param queryResult
	 * @return
	 */
	private HeatmapOption createSectionHeahmapOption(Map<String, List<DispatchAnalysis>> mapList,
			List<String> stations) {
		// 没有站点信息则直接返回
		if (stations == null || stations.size() == 0 || mapList.isEmpty()) {
			return new HeatmapOption();
		}

		HeatmapOption heatmapOption = new HeatmapOption();
		// 构建yAxisNames
		heatmapOption.setxAxisNames(stations);
		Map<String, List<DispatchAnalysis>> filterMap = this.filterMapList(mapList, stations);
		int index = 0;
		List<List<Float>> datas = new ArrayList<>();
		for (String key : filterMap.keySet()) {
			List<DispatchAnalysis> list = filterMap.get(key);
			if (list == null) {
				continue;
			}
			for (int i = 0; i < stations.size(); i++) {
				ArrayList<Float> data = new ArrayList<>();
				data.add(Float.parseFloat(index + ""));
				data.add(Float.parseFloat(i + ""));
				data.add(Float.parseFloat(list.get(i).getAnalysisNumber()));
				datas.add(data);
			}
			index++;
		}
		// 构建yAxisNames
		heatmapOption.setyAxisNames(new ArrayList<>(filterMap.keySet()));
		// 构建datas[[0,0,43]...]
		heatmapOption.setDatas(datas);
		return heatmapOption;
	}

	private Map<String, List<DispatchAnalysis>> filterMapList(Map<String, List<DispatchAnalysis>> mapList,
			List<String> stations) {
		Map<String, List<DispatchAnalysis>> filterMap = new LinkedHashMap<>();
		for (String key_y : mapList.keySet()) {
			List<DispatchAnalysis> datas = mapList.get(key_y);
			Float total = 0f;
			for (DispatchAnalysis data : datas) {
				total += Float.parseFloat(data.getAnalysisNumber());
			}
			// 去掉某个时段少于5条数据且车辆人数和为0的y轴数据
			if (datas.size() < 5 && total == 0) {
				// mapList.remove(key_y);
				total = 0f;
				continue;
			}
			total = 0f;
			// 将缺失站点的车内人数用0补全（以站名为key补全）
			if (datas.size() < stations.size()) {
				Map<String, DispatchAnalysis> map = new HashMap<>();
				for (DispatchAnalysis data : datas) {
					if (!map.containsKey(data.getxAxisLabel())) {
						map.put(data.getxAxisLabel(), data);
					}
				}
				List<DispatchAnalysis> fullList = new ArrayList<>();
				for (String station : stations) {
					if (!map.containsKey(station)) {
						DispatchAnalysis bean = new DispatchAnalysis();
						bean.setAnalysisNumber("0");
						bean.setxAxisLabel(station);
						bean.setyAxisLabel(datas.get(0).getyAxisLabel());
						fullList.add(bean);
					} else {
						fullList.add(map.get(station));
					}
					filterMap.put(key_y, fullList);
				}
			} else {
				filterMap.put(key_y, datas);
			}
		}
		return filterMap;
	}

	/**
	 * 将数据y轴名分组
	 * 
	 * @param list
	 * @return
	 */
	private Map<String, List<DispatchAnalysis>> listToMap(List<DispatchAnalysis> list) {
		Map<String, List<DispatchAnalysis>> map = new LinkedHashMap<>();
		for (DispatchAnalysis dispatchAnalysis : list) {
			String key = dispatchAnalysis.getyAxisLabel();
			if (map.containsKey(key)) {
				map.get(key).add(dispatchAnalysis);
			} else {
				List<DispatchAnalysis> lis = new ArrayList<>();
				lis.add(dispatchAnalysis);
				map.put(key, lis);
			}
		}
		return map;
	}

	/**
	 * 补全数据（不够24个数据的补够）
	 * 
	 * @return
	 */
	private List<DispatchAnalysis> completionDatas(List<DispatchAnalysis> list) {
		Map<String, DispatchAnalysis> map = new LinkedHashMap<>();
		if (list != null && list.size() > 0) {
			for (DispatchAnalysis dispatchAnalysis : list) {
				String key = dispatchAnalysis.getxAxisLabel();
				if (!map.containsKey(key)) {
					map.put(key, dispatchAnalysis);
				}
			}
		}

		List<DispatchAnalysis> result = new ArrayList<>();
		if (!map.isEmpty()) {
			for (int i = 6; i < 24; i++) {
				if (!map.containsKey(i + "h")) {
					DispatchAnalysis bean = new DispatchAnalysis();
					bean.setyAxisLabel(list.get(0).getyAxisLabel());
					bean.setxAxisLabel(i + "h");
					bean.setAnalysisNumber("0");
					result.add(bean);
				} else {
					result.add(map.get(i + "h"));
				}
			}
		}
		return result;
	}

	@Override
	public GridChartOption getLineStationChartDatas(GridChartQueryCondition queryCondition) {
		List<LineStationAnalysisVo> list = dispatchAnalysisMapper.getLineStationInfo(queryCondition);
		if (list == null || list.size() == 0) {
			return new GridChartOption();
		}

		List<String> xAxisNames = new ArrayList<>();
		List<Object> onNumbers = new ArrayList<>();
		List<Object> offNumbers = new ArrayList<>();
		List<Object> personNumbers = new ArrayList<>();
		List<Object> fullLoadRates = new ArrayList<>();

		for (LineStationAnalysisVo item : list) {
			xAxisNames.add(item.getStaName());
			onNumbers.add(item.getGetOnNumber());
			offNumbers.add(item.getGetOffNumber());
			personNumbers.add(item.getPersonNumber());
			fullLoadRates.add(item.getFullLoadRate());
		}
		GridChartOption barChartOption = new GridChartOption();
		barChartOption.setxAxisNames(xAxisNames);
		List<List<Object>> datas = new ArrayList<>();
		datas.add(onNumbers);
		datas.add(offNumbers);
		datas.add(personNumbers);
		datas.add(fullLoadRates);
		barChartOption.setDatas(datas);
		return barChartOption;
	}

	@Override
	public GridChartOption getSequenceDiagramChartDatas(GridChartQueryCondition queryCondition) {
		QueryCondition condition = new QueryCondition();
		condition.setLineId(queryCondition.getLineId());
		condition.setType(queryCondition.getType());
		List<SequenceDiagramAnalysisVo> queryList = dispatchAnalysisMapper.getSequenceDiagramInfo(queryCondition);
		List<String> stations = dispatchAnalysisMapper.getLineStationNames(condition);
		if (queryList == null || queryList.size() == 0) {
			return new GridChartOption();
		}
		Map<String, List<SequenceDiagramAnalysisVo>> mapList = new LinkedHashMap<>();
		for (SequenceDiagramAnalysisVo item : queryList) {
			String key = item.getBusNumber() + "," + item.getBusClass();
			if (!mapList.containsKey(key)) {
				List<SequenceDiagramAnalysisVo> list = new ArrayList<>();
				list.add(item);
				mapList.put(key, list);
			} else {
				mapList.get(key).add(item);
			}
		}

		for (String key : mapList.keySet()) {
			List<SequenceDiagramAnalysisVo> list = mapList.get(key);
			List<SequenceDiagramAnalysisVo> resultList = new ArrayList<>();
			if (list != null && list.size() > 0) {
				// 一条线路存在某些相同的站点，采样map<String, List>保存数据
				Map<String, List<SequenceDiagramAnalysisVo>> map = new LinkedHashMap<>();
				for (SequenceDiagramAnalysisVo item : list) {
					String keyLabel = item.getStaName();
					if (!map.containsKey(keyLabel)) {
						List<SequenceDiagramAnalysisVo> vos = new ArrayList<>();
						vos.add(item);
						map.put(keyLabel, vos);
					} else {
						map.get(keyLabel).add(item);
					}
				}

				List<SequenceDiagramAnalysisVo> values = map.entrySet().iterator().next().getValue();
				Map<String, Integer> staticMap = new HashMap<>();
				for (int i = 0; i < stations.size(); i++) {
					String staName = stations.get(i);
					// 站点获取次数map
					if (staticMap.containsKey(staName)) {
						staticMap.put(staName, staticMap.get(staName) + 1);
					} else {
						staticMap.put(staName, 1);
					}
					if (!map.containsKey(staName)) {
						SequenceDiagramAnalysisVo vo = values.get(0);
						SequenceDiagramAnalysisVo bean = new SequenceDiagramAnalysisVo(vo.getBusNumber(),
								vo.getBusClass(), staName, null, vo.getUploadTimeIn(), (i + 1));
						resultList.add(bean);
					} else {
						// 相同站点只能取一次，因为上面已将相同的站点信息合并了
						if (staticMap.get(staName) == 1) {
							resultList.addAll(map.get(staName));
						}
					}
				}
			}

			Collections.sort(resultList);
			mapList.put(key, resultList);
		}

		// 构建xAxisNames
		List<String> xAxisNames = new ArrayList<>();
		xAxisNames.addAll(stations);
		// 构建legendNames,datas
		List<List<Object>> datas = new ArrayList<>();
		List<String> legendNames = new ArrayList<>();
		for (String key : mapList.keySet()) {
			legendNames.add(key.split(",")[0]);
			List<Object> data = new ArrayList<>();
			List<SequenceDiagramAnalysisVo> list = mapList.get(key);
			for (SequenceDiagramAnalysisVo item : list) {
				if (item.getTimestamps() != null) {
					data.add(Double.parseDouble(item.getTimestamps()));
				} else {
					data.add(null);
				}
			}
			datas.add(data);
		}

		GridChartOption gridChartOption = new GridChartOption();
		gridChartOption.setLegendNames(legendNames);
		gridChartOption.setxAxisNames(xAxisNames);
		gridChartOption.setDatas(datas);
		return gridChartOption;
	}

	@Override
	public GridChartOption getLineCapacityChartDatas(GridChartQueryCondition queryCondition) {
		List<LineCapacityAnalysisVo> queryList = dispatchAnalysisMapper.getLineCapacityInfo(queryCondition);
		if (queryList == null || queryList.size() == 0) {
			return new GridChartOption();
		}
		List<String> legendNames = new ArrayList<>();
		legendNames.add("运力");
		legendNames.add("运量");
		legendNames.add("车内人数");
		List<String> xAxisNames = new ArrayList<>();
		List<Object> lineCapacitys = new ArrayList<>();
		List<Object> lineVolumes = new ArrayList<>();
		List<Object> maxPersonCounts = new ArrayList<>();
		for (LineCapacityAnalysisVo item : queryList) {
			xAxisNames.add(item.getTimeInterval());
			lineCapacitys.add(item.getLineCapacity());
			lineVolumes.add(item.getLineVolume());
			maxPersonCounts.add(item.getMaxPersonCount());
		}
		// 构建barChartOption
		GridChartOption barChartOption = new GridChartOption();
		barChartOption.setxAxisNames(xAxisNames);
		List<List<Object>> datas = new ArrayList<>();
		datas.add(lineCapacitys);
		datas.add(lineVolumes);
		datas.add(maxPersonCounts);
		GridChartOption gridChartOption = new GridChartOption();
		gridChartOption.setLegendNames(legendNames);
		gridChartOption.setxAxisNames(xAxisNames);
		gridChartOption.setDatas(datas);
		return gridChartOption;
	}

	@Override
	public List<StationOnOffAnalysisVo> getStationOnOffTableDatas(StationOnOffQueryCondition queryCondition) {
		List<StationOnOffAnalysisVo> queryList = dispatchAnalysisMapper.getStationOnOffInfo(queryCondition);
		// 同一站点按参数小时补全
		Integer startHour = 0;
		Integer endHour = 23;
		if (queryCondition.getStartHour() != null) {
			startHour = queryCondition.getStartHour();
		}
		if (queryCondition.getEndHour() != null) {
			endHour = queryCondition.getEndHour();
		}
		List<StationOnOffAnalysisVo> fullList = new ArrayList<>();

		Map<String, List<StationOnOffAnalysisVo>> map = new LinkedHashMap<>();
		for (StationOnOffAnalysisVo item : queryList) {
			String key = item.getTimeDate() + item.getStaName();
			if (map.containsKey(key)) {
				map.get(key).add(item);
			} else {
				List<StationOnOffAnalysisVo> list = new ArrayList<>();
				list.add(item);
				map.put(key, list);
			}
		}
		for (String key : map.keySet()) {
			List<StationOnOffAnalysisVo> list = map.get(key);
			Map<String, StationOnOffAnalysisVo> tempmap = new HashMap<>();
			for (StationOnOffAnalysisVo item : list) {
				String keyLabel = item.getTimeHour() + "";
				if (!tempmap.containsKey(keyLabel)) {
					tempmap.put(keyLabel, item);
				}
			}

			for (int i = startHour; i <= endHour; i++) {
				if (!tempmap.containsKey(i + "")) {
					StationOnOffAnalysisVo vo = tempmap.entrySet().iterator().next().getValue();
					StationOnOffAnalysisVo bean = new StationOnOffAnalysisVo(vo.getTimeDate(), vo.getStaName(), i, 0,
							0);
					fullList.add(bean);
				} else {
					fullList.add(tempmap.get(i + ""));
				}
			}
		}
		return fullList;
	}

	@Override
	public List<LineStationInfoVo> getAllLineStationInfo() {
		return dispatchAnalysisMapper.getAllLineStationInfo();
	}

	@Override
	public GridChartOption getLineBetweenStationsRunningTimeChartDatas(QueryCondition queryCondition) {
		List<LineBetweenStationsRunningTimeAnalysisVo> queryList = dispatchAnalysisMapper
				.getLineBetweenStationsRunningTimeInfo(queryCondition);
		List<String> hours = dispatchAnalysisMapper.getLineBetweenStationsRunningTimeHours(queryCondition);
		if (queryList == null || queryList.size() == 0) {
			return new GridChartOption();
		}
		Map<String, List<LineBetweenStationsRunningTimeAnalysisVo>> mapList = new LinkedHashMap<>();
		for (LineBetweenStationsRunningTimeAnalysisVo item : queryList) {
			String key = item.getStaName();
			if (!mapList.containsKey(key)) {
				List<LineBetweenStationsRunningTimeAnalysisVo> list = new ArrayList<>();
				list.add(item);
				mapList.put(key, list);
			} else {
				mapList.get(key).add(item);
			}
		}

		for (String key : mapList.keySet()) {
			List<LineBetweenStationsRunningTimeAnalysisVo> list = mapList.get(key);
			List<LineBetweenStationsRunningTimeAnalysisVo> fullList = new ArrayList<>();
			if (list != null && list.size() > 0) {
				Map<String, LineBetweenStationsRunningTimeAnalysisVo> map = new HashMap<>();
				for (LineBetweenStationsRunningTimeAnalysisVo item : list) {
					String keyLabel = item.getTimeHour() + "";
					if (!map.containsKey(keyLabel)) {
						map.put(keyLabel, item);
					}
				}

				for (int i = 0; i < hours.size(); i++) {
					String hour = hours.get(i);
					if (!map.containsKey(hour)) {
						LineBetweenStationsRunningTimeAnalysisVo vo = map.entrySet().iterator().next().getValue();
						LineBetweenStationsRunningTimeAnalysisVo bean = new LineBetweenStationsRunningTimeAnalysisVo(
								vo.getStaName(), Integer.parseInt(hour), null);
						fullList.add(bean);
					} else {
						fullList.add(map.get(hour));
					}
				}
			}
			mapList.put(key, fullList);
		}

		// 构建xAxisNames
		List<String> xAxisNames = new ArrayList<>();
		xAxisNames.addAll(hours);
		// 构建legendNames,datas
		List<List<Object>> datas = new ArrayList<>();
		List<String> legendNames = new ArrayList<>();
		for (String key : mapList.keySet()) {
			legendNames.add(key);
			List<Object> data = new ArrayList<>();
			List<LineBetweenStationsRunningTimeAnalysisVo> list = mapList.get(key);
			for (LineBetweenStationsRunningTimeAnalysisVo item : list) {
				if (item.getTimeLength() != null) {
					data.add(item.getTimeLength());
				} else {
					data.add(null);
				}
			}
			datas.add(data);
		}

		GridChartOption gridChartOption = new GridChartOption();
		gridChartOption.setLegendNames(legendNames);
		gridChartOption.setxAxisNames(xAxisNames);
		gridChartOption.setDatas(datas);
		return gridChartOption;
	}

	@Override
	public GridChartOption getStationRunTimeChartDatas(Client client, String index, LineStationQueryVo queryVo) {
		List<LineCongestionVo> list = getAvgDatas(client, index, queryVo);
		GridChartOption option = new GridChartOption();
		if(CollectionUtils.isEmpty(list)){
			return option;
		}
		// 按站序排序
		Collections.sort(list, new Comparator<LineCongestionVo>() {
			@Override
			public int compare(LineCongestionVo arg0, LineCongestionVo arg1) {
				return arg0.getStaSeq() - arg1.getStaSeq();
			}

		});
		List<List<Object>> datas = new ArrayList<>();
		List<String> xAxisNames = new ArrayList<String>();
		List<Object> data = new ArrayList<>();
		for (LineCongestionVo bean : list) {
			xAxisNames.add((String) bean.getStaName());
			data.add(bean.getAvgTime());
		}
		datas.add(data);
		option.setDatas(datas).setxAxisNames(xAxisNames);
		return option;
	}

	@Override
	public GridChartOption getLineStationSpeedChartDatas(Client client, String index,
			LineStationQueryVo queryVo) {
		List<LineCongestionVo> list = getAvgDatas(client, index, queryVo);
		GridChartOption option = new GridChartOption();
		if (CollectionUtils.isEmpty(list)) {
			return option;
		}
		// 按站序排序
		Collections.sort(list, new Comparator<LineCongestionVo>() {
			@Override
			public int compare(LineCongestionVo arg0, LineCongestionVo arg1) {
				return arg0.getStaSeq() - arg1.getStaSeq();
			}

		});
		List<List<Object>> datas = new ArrayList<>();
		List<String> xAxisNames = new ArrayList<String>();
		List<Object> data = new ArrayList<>();
		for (LineCongestionVo bean : list) {
			xAxisNames.add(bean.getStaName());
			data.add(bean.getAvgSpeed());
		}
		datas.add(data);
		option.setDatas(datas).setxAxisNames(xAxisNames);
		return option;
	}

	private List<LineCongestionVo> getAvgDatas(Client client, String index, LineStationQueryVo queryVo) {
		List<LineCongestionVo> datas = new ArrayList<>();
		SearchResponse response = queryDatasFromES(client, index, queryVo);
		Terms staNameTerms = response.getAggregations().get("staName");
		for (Terms.Bucket staName : staNameTerms.getBuckets()) {
			Terms staSeqTerms = staName.getAggregations().get("staSeq");
			for (Terms.Bucket staSeqTerm : staSeqTerms.getBuckets()) {
				// 线路站间平均耗时
				Avg avgTime = staSeqTerm.getAggregations().get("staLengthTime");
				// 线路站间平均速度
				Avg avgDistance = staSeqTerm.getAggregations().get("staBetweenDistance");

				LineCongestionVo lineCongestionVo = new LineCongestionVo();
				lineCongestionVo.setStaName((String) staName.getKey()).setStaSeq(Integer.parseInt( staSeqTerm.getKey()+"")).setAvgTime(
						BigDecimal.valueOf(avgTime.getValue()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
				// 将米转换为千米
				BigDecimal bDistance = BigDecimal.valueOf(avgDistance.getValue() / 1000);
				// 将秒转换为小时
				BigDecimal bTime = BigDecimal.valueOf(avgTime.getValue() / 3600);
				// 计算速度（km/h）
				if (Objects.isNull(bTime)) {
					lineCongestionVo.setAvgSpeed(0);
				} else {
					lineCongestionVo.setAvgSpeed(bDistance.divide(bTime, 2, BigDecimal.ROUND_HALF_UP).floatValue());
				}
				datas.add(lineCongestionVo);
			}
		}
		return datas;
	}

	/**
	 * ES分组，对分组字段要嵌套，对求和，平均，最大，最小不嵌套（平级）
	 * 
	 * @param client
	 * @param index
	 * @param queryVo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private SearchResponse queryDatasFromES(Client client, String index, LineStationQueryVo queryVo) {
		// 查询条件
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		// 查询条件
		if (PMSUtils.isNotEmpty(queryVo.getLineId())) {
			boolQuery.must(QueryBuilders.matchPhraseQuery("lineUuid", queryVo.getLineId()));
		}
		if (PMSUtils.isNotEmpty(queryVo.getLineType())) {
			boolQuery.must(QueryBuilders.termQuery("lineType", queryVo.getLineType()));
		}
		if (PMSUtils.isNotEmpty(queryVo.getStartTime())) {
			String uploadTimeDay = DateUtils.formatDate(queryVo.getStartTime());
			boolQuery.must(QueryBuilders.termQuery("uploadTimeDay", uploadTimeDay));
		}
		if (PMSUtils.isNotEmpty(queryVo.getStartHour())) {
			boolQuery.must(QueryBuilders.rangeQuery("uploadTimeHour").gte(queryVo.getStartHour()));
		}
		if (PMSUtils.isNotEmpty(queryVo.getEndHour())) {
			boolQuery.must(QueryBuilders.rangeQuery("uploadTimeHour").lte(queryVo.getEndHour()));
		}
		SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index).setTypes("analysis_length_time_day")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(boolQuery);
		
		AggregationBuilder staNameBuilder = AggregationBuilders.terms("staName").field("staName").size(0);
		AggregationBuilder staSeqBuilder = AggregationBuilders.terms("staSeq").field("staSeq").size(0);
		AvgBuilder staLengthTimeBuilder = AggregationBuilders.avg("staLengthTime").field("staLengthTime");
		AvgBuilder staBetweenDistanceBuilder = AggregationBuilders.avg("staBetweenDistance")
				.field("staBetweenDistance");
		searchRequestBuilder.addAggregation(staNameBuilder.subAggregation(
				staSeqBuilder.subAggregation(staLengthTimeBuilder).subAggregation(staBetweenDistanceBuilder)));

		return searchRequestBuilder.execute().actionGet();
	}
}
