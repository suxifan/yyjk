package com.cictec.yyjk.report.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.base.mapper.BaseUserInfoMapper;
import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.service.TSysDatadictService;
import com.cictec.yyjk.report.mapper.TempPltwarnMapper;
import com.cictec.yyjk.report.model.data.DriverRankingValue;
import com.cictec.yyjk.report.model.data.HandleAnalysisValue;
import com.cictec.yyjk.report.model.data.WarnSpeedEnum;
import com.cictec.yyjk.report.model.entity.TempPltwarn;
import com.cictec.yyjk.report.model.view.WarnAlarmDayReportValue;
import com.cictec.yyjk.report.model.view.WarnInfoValue;
import com.cictec.yyjk.report.model.vo.BadDrivingInfo;
import com.cictec.yyjk.report.model.vo.GridChartOption;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.WarnInofVo;
import com.cictec.yyjk.report.service.TempPltwarnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/06/14.
 */
@Service
@Transactional
public class TempPltwarnServiceImpl extends AbstractService<TempPltwarn> implements TempPltwarnService {

	@Resource
	private TempPltwarnMapper tempPlTWarnMapper;

	@Autowired
	private TSysDatadictService tSysDatadictService;

	@Autowired
	private BaseUserInfoService baseUserInfoService;

	@Autowired
	private BaseUserInfoMapper baseUserInfoMapper;

	@Override
	public List<WarnInofVo> getWarnInfos(QueryCondition queryCondition, BaseUserInfo userInfo) {
		// 根据数据权限过滤
		setQueryConditon(queryCondition, userInfo);
		return tempPlTWarnMapper.getWarnInfos(queryCondition);
	}

	@Override
	public List<TWarn> getNoHandleWarns(QueryCondition queryCondition, BaseUserInfo userInfo) {
		// 根据数据权限过滤
		setQueryConditon(queryCondition, userInfo);
		BaseUserInfo user = baseUserInfoService.selectByPrimaryKey(userInfo.getUserId());
		List<String> auditStatus = new ArrayList<>();
		// 根据用户获取机构，如果是总公司看所有的审核状态的，如果是分公司只看审核属实的
		if ("1".equals(user.getUserOrgUuid())) {
			auditStatus.add("0");
		} else {
			auditStatus.add("1");
		}
		queryCondition.setAuditStatus(auditStatus);
		return tempPlTWarnMapper.getNoHandleWarns(queryCondition);
	}

	@Override
	public List<WarnInofVo> statisticsByWarnType(QueryCondition queryCondition, BaseUserInfo userInfo) {
		setQueryConditon(queryCondition, userInfo);
		return tempPlTWarnMapper.statisticsByWarnType(queryCondition);
	}

	@Override
	public List<WarnInofVo> statisticsByWarnLeave(QueryCondition queryCondition) {
		return tempPlTWarnMapper.statisticsByWarnLeave(queryCondition);
	}

	@Override
	public List<BadDrivingInfo> getBadDrivingBehaviorRanking(QueryCondition queryCondition) {
		List<BadDrivingInfo> datas = tempPlTWarnMapper.getBadDrivingBehaviorRanking(queryCondition);
		if (datas == null) {
			return Collections.emptyList();
		}
		Collections.sort(datas, new Comparator<BadDrivingInfo>() {
			@Override
			public int compare(BadDrivingInfo arg0, BadDrivingInfo arg1) {
				return Integer.parseInt(arg1.getTotalWarn()) - Integer.parseInt(arg0.getTotalWarn());
			}
		});
		return datas;
	}

	@Override
	public List<TWarn> getBadDrivingBehaviorRankingDetail(QueryCondition queryCondition, BaseUserInfo userInfo) {
		// 根据数据权限过滤
		setQueryConditon(queryCondition, userInfo);
		return tempPlTWarnMapper.getBadDrivingBehaviorRankingDetail(queryCondition);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getBadDrivingDriverRanking(QueryCondition queryCondition) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 列表图数据结构
		List<Map> columnData = new ArrayList<>();
		// 初始固定表头
		String fixedColmuns = " [{\"pldisplay\": \"机构\",\"plvalue\": \"orgname\"},{\"pldisplay\": \"线路\",\"plvalue\": \"linename\"},{\"pldisplay\": \"车牌号\",\"plvalue\": \"busplatenumber\"},{\"pldisplay\": \"工号\",\"plvalue\": \"drivernum\"},{\"pldisplay\": \"司机\",\"plvalue\": \"drivername\"}]";
		columnData.addAll(JSON.parseArray(fixedColmuns, Map.class));
		// 动态表头
		List<String> warnTypes = queryCondition.getWarnTypes();
		List<Map> dynamicColumns = null;
		if (CollectionUtils.isNotEmpty(warnTypes)) {
			dynamicColumns = tSysDatadictService.queryByValues(warnTypes);
		}
		if (CollectionUtils.isNotEmpty(dynamicColumns)) {
			columnData.addAll(dynamicColumns);
		}

		Map<String, String> totalColumn = new HashMap<>();
		totalColumn.put("pldisplay", "报警总数");
		totalColumn.put("plvalue", "warnTotalNum");
		columnData.add(totalColumn);
		result.put("column", columnData);

		// 如果动态列为空，直接返回
		if (dynamicColumns == null) {
			result.put("data", Collections.emptyList());
			return result;
		}
		// 获取列名信息
		List<String> columnKeys = new ArrayList<>();
		for (Map map : dynamicColumns) {
			columnKeys.add((String) map.get("plvalue"));
		}
		// 根据报警类型条件构建动态统计列脚本
		String columnSql = createDynamicColumnSql(columnKeys);
		queryCondition.setSql(columnSql);

		List<Map> list = tempPlTWarnMapper.getBadDrivingDriverRanking(queryCondition);
		if (list == null) {
			result.put("data", Collections.emptyList());
			return result;
		}

		// // 司机超速报警字典
		// Map<String, Map> disc = getOverSpeedWarnDisc(queryCondition);
		//
		// // 记录需要合并报警的key
		// Set<String> commKey = new HashSet<>();
		// // 存在超速报警的将超速报警补全到改司机超的疲劳报警里
		// for (Map item : list) {
		// String key = (String) item.get("drivername");
		// Map overSpeedMap = disc.get(key);
		// if (overSpeedMap != null) {
		// commKey.add(key);
		// item.put("OVERSPEED", overSpeedMap.get("OVERSPEED") + "");
		// }
		// }
		//
		// // 将只有超速报警的司机合并到疲劳报警集合中
		// if (CollectionUtils.isNotEmpty(disc.keySet())) {
		// List<String> types = queryCondition.getWarnTypes();
		// types.remove("OVERSPEED");
		// if (CollectionUtils.isEmpty(commKey)) {
		// Iterator<String> iterator = disc.keySet().iterator();
		// while (iterator.hasNext()) {
		// String key = iterator.next();
		// Map overWarnMap = disc.get(key);
		// if (overWarnMap != null) {
		// for (String type : types) {
		// overWarnMap.put(type, 0);
		// }
		// list.add(overWarnMap);
		// }
		// }
		// } else if (disc.keySet().removeAll(commKey)) {
		// Iterator<String> iterator = disc.keySet().iterator();
		// while (iterator.hasNext()) {
		// String key = iterator.next();
		// Map overWarnMap = disc.get(key);
		// if (overWarnMap != null) {
		// for (String type : types) {
		// overWarnMap.put(type, 0);
		// }
		// list.add(overWarnMap);
		// }
		// }
		// }
		// }

		// 求和
		for (Map map : list) {
			Integer total = 0;
			for (String columnKey : columnKeys) {
				if (map.get(columnKey) != null) {
					total += Integer.parseInt(map.get(columnKey) + "");
				}
			}
			map.put("warnTotalNum", total);
		}
		// 报警总数倒序排序
		Collections.sort(list, new Comparator<Map>() {
			public int compare(Map o1, Map o2) {
				Integer warnTotalNum1 = Integer.valueOf(o1.get("warnTotalNum").toString());
				Integer warnTotalNum2 = Integer.valueOf(o2.get("warnTotalNum").toString());
				return warnTotalNum2 - warnTotalNum1;
			}
		});

		result.put("data", list);
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getBadDrivingBusRanking(QueryCondition queryCondition) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 列表图数据结构
		List<Map> columnData = new ArrayList<>();
		// 初始固定表头
		String fixedColmuns = " [{\"pldisplay\": \"机构\",\"plvalue\": \"orgname\"},{\"pldisplay\": \"线路\",\"plvalue\": \"linename\"},{\"pldisplay\": \"车牌号\",\"plvalue\": \"busnumber\"}]";
		columnData.addAll(JSON.parseArray(fixedColmuns, Map.class));
		// 动态表头
		List<String> warnTypes = queryCondition.getWarnTypes();
		List<Map> dynamicColumns = null;
		if (CollectionUtils.isNotEmpty(warnTypes)) {
			dynamicColumns = tSysDatadictService.queryByValues(warnTypes);
		}
		if (CollectionUtils.isNotEmpty(dynamicColumns)) {
			columnData.addAll(dynamicColumns);
		}

		Map<String, String> totalColumn = new HashMap<>();
		totalColumn.put("pldisplay", "报警总数");
		totalColumn.put("plvalue", "warnTotalNum");
		columnData.add(totalColumn);
		result.put("column", columnData);

		// 如果动态列为空，直接返回
		if (dynamicColumns == null) {
			result.put("data", null);
			return result;
		}
		// 获取列名信息
		List<String> columnKeys = new ArrayList<>();
		for (Map map : dynamicColumns) {
			columnKeys.add((String) map.get("plvalue"));
		}
		// 根据报警类型条件构建动态统计列脚本
		String columnSql = createDynamicColumnSql(columnKeys);
		queryCondition.setSql(columnSql);

		List<Map> list = tempPlTWarnMapper.getBadDrivingBusRanking(queryCondition);
		if (list == null) {
			result.put("data", null);
			return result;
		}

		// 求和
		for (Map map : list) {
			Integer total = 0;
			for (String columnKey : columnKeys) {
				if (map.get(columnKey) != null) {
					total += Integer.parseInt(map.get(columnKey) + "");
				}
			}
			map.put("warnTotalNum", total);
		}
		// 报警总数倒序排序
		Collections.sort(list, new Comparator<Map>() {
			public int compare(Map o1, Map o2) {
				Integer warnTotalNum1 = Integer.valueOf(o1.get("warnTotalNum").toString());
				Integer warnTotalNum2 = Integer.valueOf(o2.get("warnTotalNum").toString());
				return warnTotalNum2 - warnTotalNum1;
			}
		});

		result.put("data", list);
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getDrivingBehaviorDay(QueryCondition queryCondition) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 列表图数据结构
		List<Map> columnData = new ArrayList<>();
		// 初始固定表头
		// String fixedColmuns = " [{\"pldisplay\": \"日期\",\"plvalue\":
		// \"warntime\"},{\"pldisplay\": \"时间\",\"plvalue\":
		// \"warntime\"},{\"pldisplay\": \"车牌号\",\"plvalue\": \"busnumber\"}"
		// + ",{\"pldisplay\": \"司机工号\",\"plvalue\":
		// \"drivernum\"},{\"pldisplay\": \"司机\",\"plvalue\":
		// \"drivername\"},{\"pldisplay\": \"线路\",\"plvalue\": \"linename\"}"
		// + ",{\"pldisplay\": \"总站\",\"plvalue\": \"orgname\"}]";
		// columnData.addAll(JSON.parseArray(fixedColmuns, Map.class));
		// 动态表头
		List<String> warnTypes = queryCondition.getWarnTypes();
		List<Map> dynamicColumns = null;
		if (CollectionUtils.isNotEmpty(warnTypes)) {
			dynamicColumns = tSysDatadictService.queryByValues(warnTypes);
		}
		if (CollectionUtils.isNotEmpty(dynamicColumns)) {
			for (Map map : dynamicColumns) {
				List<String> levelList = new ArrayList<>();
				levelList.add(map.get("plvalue") + "First");
				levelList.add(map.get("plvalue") + "Second");
				map.put("level", levelList);
			}
			columnData.addAll(dynamicColumns);
		}

		// 如果动态列为空，直接返回
		if (dynamicColumns == null) {
			result.put("data", null);
			return result;
		}
		// 获取列名信息
		List<String> columnKeys = new ArrayList<>();
		for (Map map : dynamicColumns) {
			columnKeys.add((String) map.get("plvalue"));
		}
		// 根据报警类型条件构建动态统计列脚本
		String columnSql = createDynamicColumnSqlByBehaviorDay(columnKeys);
		queryCondition.setSql(columnSql);
		// 分页数据请求处理
		if (queryCondition.isPage()) {
			PageHelper.startPage(queryCondition.getPageNumber(), queryCondition.getPageSize());
			List<Map> list = tempPlTWarnMapper.getDrivingBehaviorDay(queryCondition);
			PageInfo listInfo = new PageInfo<Map>(list);
			result.put("columnData", columnData);
			result.put("data", listInfo);
		} else {
			List<Map> list = tempPlTWarnMapper.getDrivingBehaviorDay(queryCondition);
			result.put("columnData", columnData);
			result.put("data", list);
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getDrivingBehaviorDayExport(QueryCondition queryCondition) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 列表图数据结构
		List<Map> columnData = new ArrayList<>();
		// 初始固定表头
		// String fixedColmuns = " [{\"pldisplay\": \"日期\",\"plvalue\":
		// \"warntime\"},{\"pldisplay\": \"时间\",\"plvalue\":
		// \"warntime\"},{\"pldisplay\": \"车牌号\",\"plvalue\": \"busnumber\"}"
		// + ",{\"pldisplay\": \"司机工号\",\"plvalue\":
		// \"drivernum\"},{\"pldisplay\": \"司机\",\"plvalue\":
		// \"drivername\"},{\"pldisplay\": \"线路\",\"plvalue\": \"linename\"}"
		// + ",{\"pldisplay\": \"总站\",\"plvalue\": \"orgname\"}]";
		// columnData.addAll(JSON.parseArray(fixedColmuns, Map.class));
		// 动态表头
		List<String> warnTypes = queryCondition.getWarnTypes();
		List<Map> dynamicColumns = null;
		if (CollectionUtils.isNotEmpty(warnTypes)) {
			dynamicColumns = tSysDatadictService.queryByValues(warnTypes);
		}
		if (CollectionUtils.isNotEmpty(dynamicColumns)) {
			for (Map map : dynamicColumns) {
				List<String> levelList = new ArrayList<>();
				levelList.add(map.get("plvalue") + "First");
				levelList.add(map.get("plvalue") + "Second");
				map.put("level", levelList);
			}
			columnData.addAll(dynamicColumns);
		}

		// 如果动态列为空，直接返回
		if (dynamicColumns == null) {
			result.put("data", null);
			return result;
		}
		// 获取列名信息
		List<String> columnKeys = new ArrayList<>();
		for (Map map : dynamicColumns) {
			columnKeys.add((String) map.get("plvalue"));
		}
		// 根据报警类型条件构建动态统计列脚本
		String columnSql = createDynamicColumnSqlByBehaviorDayExport(columnKeys);
		queryCondition.setSql(columnSql);
		// 分页数据请求处理
		if (queryCondition.isPage()) {
			PageHelper.startPage(queryCondition.getPageNumber(), queryCondition.getPageSize());
			List<Map> list = tempPlTWarnMapper.getDrivingBehaviorDay(queryCondition);
			PageInfo listInfo = new PageInfo<Map>(list);
			result.put("columnData", columnData);
			result.put("data", listInfo);
		} else {
			List<Map> list = tempPlTWarnMapper.getDrivingBehaviorDay(queryCondition);
			result.put("columnData", columnData);
			result.put("data", list);
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getAlarmUploadReportDay(QueryCondition queryCondition) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 监测报警列表图数据结构
		List<Map> alarmColumnData = new ArrayList<>();
		// 辅助功能列表图数据结构
		List<Map> assistColumnData = new ArrayList<>();

		String[] assist = { "HMW", "LDW", "FCW", "PCW" };
		List<String> warnTypes = queryCondition.getWarnTypes();
		// 动态表头
		List<Map> dynamicColumns = null;
		if (CollectionUtils.isNotEmpty(warnTypes)) {
			dynamicColumns = tSysDatadictService.queryByValues(warnTypes);
		} else {
			dynamicColumns = tSysDatadictService.queryAll();
		}
		if (CollectionUtils.isNotEmpty(dynamicColumns)) {
			for (Map map : dynamicColumns) {
				List<String> levelList = new ArrayList<>();
				levelList.add(map.get("plvalue") + "First");
				levelList.add(map.get("plvalue") + "FirstBusCounts");
				levelList.add(map.get("plvalue") + "Second");
				levelList.add(map.get("plvalue") + "SecondBusCounts");
				levelList.add(map.get("plvalue") + "TotalWarns");
				levelList.add(map.get("plvalue") + "TotalWarnBusCounts");
				map.put("level", levelList);
				if (Arrays.asList(assist).contains(map.get("plvalue"))) {
					assistColumnData.add(map);
				} else {
					alarmColumnData.add(map);
				}
			}
		}
		// 获取列名信息
		List<String> columnKeys = new ArrayList<>();
		for (Map map : dynamicColumns) {
			columnKeys.add((String) map.get("plvalue"));
		}
		List<WarnInfoValue> reportDaylist = tempPlTWarnMapper.getAlarmUploadReportDay(queryCondition);
		Map<String, String> warnTypeDisc = tSysDatadictService.warnTypeDisc();
		List<WarnAlarmDayReportValue> list = statisicWarnInfo(warnTypeDisc, reportDaylist);

		List<Map<String, Integer>> datas = switchWarnInfo(list);
		// 有数据报警类型
		Set<String> warnSet = new HashSet();
		for (WarnAlarmDayReportValue bean : list) {
			warnSet.add(bean.getWarnType());
		}
		result.put("alarmColumnData", filterWarnType(warnSet, alarmColumnData));
		result.put("assistColumnData", filterWarnType(warnSet, assistColumnData));
		result.put("data", datas);
		return result;
	}

	@SuppressWarnings("rawtypes")
	private List<Map> filterWarnType(Set<String> warnSet, List<Map> list) {
		List<Map> result = new ArrayList<>();
		Iterator<Map> iterator = list.iterator();
		while (iterator.hasNext()) {
			Map map = iterator.next();
			String warnCode = (String) map.get("plvalue");
			if (warnSet.contains(warnCode)) {
				result.add(map);
			}
		}
		return result;
	}

	private List<Map<String, Integer>> switchWarnInfo(List<WarnAlarmDayReportValue> datas) {
		if (CollectionUtils.isEmpty(datas)) {
			return Collections.emptyList();
		}
		List<Map<String, Integer>> resultList = new ArrayList<>();
		Map<String, Integer> result = new TreeMap<>();
		for (WarnAlarmDayReportValue bean : datas) {
			if (bean.getWarnTypeLevel() == 1) {
				result.put(bean.getWarnType() + "First", bean.getWarnCount() == null ? 0 : bean.getWarnCount());
				result.put(bean.getWarnType() + "FirstBusCounts",
						bean.getWarnBusCount() == null ? 0 : bean.getWarnBusCount());
			}
			if (bean.getWarnTypeLevel() == 2) {
				result.put(bean.getWarnType() + "Second", bean.getWarnCount() == null ? 0 : bean.getWarnCount());
				result.put(bean.getWarnType() + "SecondBusCounts",
						bean.getWarnBusCount() == null ? 0 : bean.getWarnBusCount());
			}
			if (bean.getWarnTypeLevel() == 3) {
				result.put(bean.getWarnType() + "TotalWarns", bean.getWarnCount() == null ? 0 : bean.getWarnCount());
				result.put(bean.getWarnType() + "TotalWarnBusCounts",
						bean.getWarnBusCount() == null ? 0 : bean.getWarnBusCount());
			}
		}
		resultList.add(result);
		return resultList;
	}

	private List<WarnAlarmDayReportValue> statisicWarnInfo(Map<String, String> warnTypeDisc,
			List<WarnInfoValue> reportDaylist) {
		// 报警类型日报
		List<WarnAlarmDayReportValue> restList = new ArrayList<>();
		Map<String, List<WarnInfoValue>> reportDayMap = listToMap(reportDaylist);
		for (String key : reportDayMap.keySet()) {
			// 统计同一个报警类型的一二级报警条数及车台数
			List<WarnInfoValue> warnList = reportDayMap.get(key);
			List<Integer> totalFriCount = new ArrayList<>();
			List<Integer> totalSecCount = new ArrayList<>();
			Set<String> totalFriSet = new HashSet<>();
			Set<String> totalSecSet = new HashSet<>();
			Set<String> totalWarnBusCount = new HashSet<>();
			for (WarnInfoValue bean : warnList) {
				if (bean.getWarnLevel() == 1) {
					totalFriCount.add(1);
					totalFriSet.add(bean.getBusPlateNumber());
				}
				if (bean.getWarnLevel() == 2) {
					totalSecCount.add(1);
					totalSecSet.add(bean.getBusPlateNumber());
				}
				totalWarnBusCount.add(bean.getBusPlateNumber());
			}
			//
			WarnInfoValue value = warnList.get(0);
			String warnType = value.getWarnType();
			String warnTypeName = warnTypeDisc.get(value.getWarnType());
			Integer totalWarnCount = totalFriCount.size() + totalSecCount.size();
			restList.add(
					new WarnAlarmDayReportValue(warnType, warnTypeName, 1, totalFriCount.size(), totalFriSet.size()));
			restList.add(
					new WarnAlarmDayReportValue(warnType, warnTypeName, 2, totalSecCount.size(), totalSecSet.size()));
			restList.add(
					new WarnAlarmDayReportValue(warnType, warnTypeName, 3, totalWarnCount, totalWarnBusCount.size()));
		}
		return restList;
	}

	/**
	 * 将list转换为已报警类型为key的字典
	 * 
	 * @param queryCondition
	 * @return
	 */
	private Map<String, List<WarnInfoValue>> listToMap(List<WarnInfoValue> list) {
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyMap();
		}
		Map<String, List<WarnInfoValue>> disc = new HashMap<>();
		for (WarnInfoValue item : list) {
			String key = item.getWarnType();
			if (!disc.containsKey(item.getWarnType())) {
				List<WarnInfoValue> subList = new ArrayList<>();
				subList.add(item);
				disc.put(key, subList);
			} else {
				disc.get(key).add(item);
			}
		}
		return disc;
	}

	private String createDynamicColumnSql(List<String> columns) {
		StringBuilder builder = new StringBuilder();
		if (columns != null) {
			Iterator<String> iterator = columns.iterator();
			String column = iterator.next();
			builder.append("SUM(CASE WHEN tt.warn_type = '").append(column).append("' THEN 1 ELSE 0 END) AS ")
					.append("\"" + column + "\" ");
			while (iterator.hasNext()) {
				String next = iterator.next();
				builder.append(",SUM(CASE WHEN tt.warn_type = '").append(next).append("' THEN 1 ELSE 0 END) AS ")
						.append("\"" + next + "\" ");
			}
		}
		return builder.toString();
	}

	private String createDynamicColumnSqlByBehaviorDay(List<String> columns) {
		StringBuilder builder = new StringBuilder();
		if (columns != null) {
			Iterator<String> iterator = columns.iterator();
			String column = iterator.next();
			builder.append("(CASE WHEN tt.warn_type = '").append(column)
					.append("' AND tt.warn_level = '1' THEN '1' ELSE '0' END) AS ")
					.append("\"" + column + "First" + "\" ");
			builder.append(",(CASE WHEN tt.warn_type = '").append(column)
					.append("'  AND tt.warn_level = '2' THEN '1' ELSE '0' END) AS ")
					.append("\"" + column + "Second" + "\" ");
			while (iterator.hasNext()) {
				String next = iterator.next();
				builder.append(",(CASE WHEN tt.warn_type = '").append(next)
						.append("'  AND tt.warn_level = '1' THEN '1' ELSE '0' END) AS ")
						.append("\"" + next + "First" + "\" ");
				builder.append(",(CASE WHEN tt.warn_type = '").append(next)
						.append("'  AND tt.warn_level = '2' THEN '1' ELSE '0' END) AS ")
						.append("\"" + next + "Second" + "\" ");
			}
		}
		return builder.toString();
	}

	private String createDynamicColumnSqlByBehaviorDayExport(List<String> columns) {
		StringBuilder builder = new StringBuilder();
		if (columns != null) {
			Iterator<String> iterator = columns.iterator();
			String column = iterator.next();
			builder.append("(CASE WHEN tt.warn_type = '").append(column)
					.append("' AND tt.warn_level = '1' THEN '√' ELSE '' END) AS ")
					.append("\"" + column + "First" + "\" ");
			builder.append(",(CASE WHEN tt.warn_type = '").append(column)
					.append("'  AND tt.warn_level = '2' THEN '√' ELSE '' END) AS ")
					.append("\"" + column + "Second" + "\" ");
			while (iterator.hasNext()) {
				String next = iterator.next();
				builder.append(",(CASE WHEN tt.warn_type = '").append(next)
						.append("'  AND tt.warn_level = '1' THEN '√' ELSE '' END) AS ")
						.append("\"" + next + "First" + "\" ");
				builder.append(",(CASE WHEN tt.warn_type = '").append(next)
						.append("'  AND tt.warn_level = '2' THEN '√' ELSE '' END) AS ")
						.append("\"" + next + "Second" + "\" ");
			}
		}
		return builder.toString();
	}

	@Override
	public GridChartOption getDriverWarnTimeTrendEchartDatas(QueryCondition queryCondition) {
		List<DriverRankingValue> trends = tempPlTWarnMapper.getDriverWarnTimeTrend(queryCondition);
		if (trends == null) {
			return new GridChartOption();
		}
		// // 司机超速报警趋势字典
		// Map<String, DriverRankingValue> disc =
		// getOverSpeedWarnTrendDisc(queryCondition);
		// // 记录需要合并报警的key
		// Set<String> commKey = new HashSet<>();
		// // 补全司机超速趋势报警
		// for (DriverRankingValue bean : trends) {
		// String key = bean.getWarnTime();
		// DriverRankingValue warnTrendBean = disc.get(key);
		// if (warnTrendBean != null) {
		// commKey.add(key);
		// bean.setWarnTotalNum(bean.getWarnTotalNum() +
		// warnTrendBean.getWarnTotalNum());
		// }
		// }
		//
		// // 将字典中剩余的值添加到司机报警集合中
		// if (CollectionUtils.isNotEmpty(disc.keySet())) {
		// if (CollectionUtils.isEmpty(commKey)) {
		// Iterator<String> iterator = disc.keySet().iterator();
		// while (iterator.hasNext()) {
		// String key = iterator.next();
		// DriverRankingValue bean = disc.get(key);
		// if (bean != null) {
		// trends.add(bean);
		// }
		// }
		// } else if (disc.keySet().removeAll(commKey)) {
		// Iterator<String> iterator = disc.keySet().iterator();
		// while (iterator.hasNext()) {
		// String key = iterator.next();
		// DriverRankingValue bean = disc.get(key);
		// if (bean != null) {
		// trends.add(bean);
		// }
		// }
		// }
		// }

		// 重新根据warntime排序
		// Collections.sort(trends, new Comparator<DriverRankingValue>() {
		// @Override
		// public int compare(DriverRankingValue arg0, DriverRankingValue arg1)
		// {
		// Date date0 = DateUtils.parseDate(arg0.getWarnTime());
		// Date date1 = DateUtils.parseDate(arg1.getWarnTime());
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(date0);
		// long time0 = calendar.getTimeInMillis();
		// calendar.setTime(date1);
		// long time1 = calendar.getTimeInMillis();
		// return (int) (time0 - time1);
		// }
		//
		// });

		List<String> xAxisNames = new ArrayList<String>();
		List<Object> data = new ArrayList<>();
		for (DriverRankingValue bean : trends) {
			xAxisNames.add(bean.getWarnTime());
			data.add(bean.getWarnTotalNum());
		}
		List<List<Object>> datas = new ArrayList<>();
		datas.add(data);

		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		return option;
	}

	/**
	 * 司机超速报警统计字典
	 * 
	 * @param queryCondition
	 * @return
	 */
	// private Map<String, DriverRankingValue>
	// getOverSpeedWarnTrendDisc(QueryCondition queryCondition) {
	// Map<String, DriverRankingValue> disc = new HashMap<>();
	// List<DriverRankingValue> list =
	// tempPlTWarnMapper.getOverSpeedWarnTrend(queryCondition);
	// if (CollectionUtils.isNotEmpty(list)) {
	// for (DriverRankingValue bean : list) {
	// String key = bean.getWarnTime();
	// if (!disc.containsKey(key)) {
	// disc.put(key, bean);
	// }
	// }
	// }
	// return disc;
	// }

	@Override
	public GridChartOption getFatigueDrivingEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo) {
		// 根据数据权限过滤
		setQueryConditon(queryCondition, userInfo);
		List<DriverRankingValue> trends = tempPlTWarnMapper.getFatigueDrivingWarnTimeAnalysis(queryCondition);
		if (trends == null) {
			return new GridChartOption();
		}
		List<String> xAxisNames = new ArrayList<String>();
		List<Object> data = new ArrayList<>();
		for (DriverRankingValue bean : trends) {
			xAxisNames.add(bean.getWarnTime());
			data.add(bean.getWarnTotalNum());
		}
		List<List<Object>> datas = new ArrayList<>();
		datas.add(data);

		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		return option;
	}

	@Override
	public GridChartOption getFatigueDrivingTrendEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo) {
		// 根据数据权限过滤
		setQueryConditon(queryCondition, userInfo);
		List<DriverRankingValue> trends = tempPlTWarnMapper.getFatigueDrivingWarnTimeTrendAnalysis(queryCondition);
		if (trends == null) {
			return new GridChartOption();
		}
		List<String> xAxisNames = new ArrayList<String>();
		List<Object> data = new ArrayList<>();
		for (DriverRankingValue bean : trends) {
			xAxisNames.add(bean.getWarnTime());
			data.add(bean.getWarnTotalNum());
		}
		List<List<Object>> datas = new ArrayList<>();
		datas.add(data);

		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		return option;
	}

	@Override
	public GridChartOption getAlarmLevelRatioAnalysisEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo) {
		setQueryConditon(queryCondition, userInfo);
		List<DriverRankingValue> trends = tempPlTWarnMapper.getAlarmLevelRatioAnalysis(queryCondition);
		return createAlarmSpeedOption(trends, WarnSpeedEnum.warnLevel);
	}

	@Override
	public GridChartOption getAlarmTypeRatioAnalysisEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo) {
		setQueryConditon(queryCondition, userInfo);
		List<DriverRankingValue> trends = tempPlTWarnMapper.getAlarmTypeRatioAnalysis(queryCondition);
		return createAlarmSpeedOption(trends, WarnSpeedEnum.warnType);
	}

	@Override
	public GridChartOption getAlarmSpeedStatisticEchartDatas(QueryCondition queryCondition, BaseUserInfo userInfo) {
		setQueryConditon(queryCondition, userInfo);
		List<DriverRankingValue> trends = tempPlTWarnMapper.getAlarmSpeedStatistic(queryCondition);
		return createAlarmSpeedOption(trends, WarnSpeedEnum.warnSpeed);
	}

	private GridChartOption createAlarmSpeedOption(List<DriverRankingValue> trends, WarnSpeedEnum warnSpeedEnum) {
		if (trends == null) {
			return new GridChartOption();
		}
		List<String> xAxisNames = new ArrayList<String>();
		List<Object> data = new ArrayList<>();
		for (DriverRankingValue bean : trends) {
			switch (warnSpeedEnum) {
			case warnType:
				xAxisNames.add(bean.getWarnTypeName());
				break;
			case warnLevel:
				xAxisNames.add(bean.getWarnLevel());
				break;
			case warnSpeed:
				xAxisNames.add(bean.getWarnSpeed());
				break;
			default:
			}
			data.add(bean.getWarnTotalNum());
		}
		List<List<Object>> datas = new ArrayList<>();
		datas.add(data);

		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		return option;
	}

	private void setQueryConditon(QueryCondition queryCondition, BaseUserInfo userInfo) {
		if ("1".equals(queryCondition.getOrgId())) {// 去掉前端误传总公司id
			queryCondition.setOrgId(null);
		}
		List<String> warnTypes = queryCondition.getWarnTypes();
		if (userInfo != null && (warnTypes != null && warnTypes.size() == 0)) {
			List<BaseDataResourceInfo> dataAuths = baseUserInfoService.getDataAuthByUserId(userInfo.getUserId());
			Set<String> dataAuthSet = getUserDataAuths(dataAuths);
			queryCondition.setWarnTypes(new ArrayList<>(dataAuthSet));
		}
	}

	private Set<String> getUserDataAuths(List<BaseDataResourceInfo> dataAuths) {
		if (dataAuths == null) {
			return Collections.emptySet();
		}
		Set<String> authsSet = new HashSet<>();
		for (BaseDataResourceInfo baseDataResourceInfo : dataAuths) {
			authsSet.add(baseDataResourceInfo.getDataResourceName());
		}
		return authsSet;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<HandleAnalysisValue> getAlarmHandleAnalysis(QueryCondition queryCondition) {
		List<HandleAnalysisValue> havList = new ArrayList<HandleAnalysisValue>();
		List<Map> map = null;
		if (queryCondition.getUserId().equals("1")) {// admin 全查
			map = baseUserInfoMapper.findAllUserByOrgId(queryCondition.getUserId());
		} else {
			map = baseUserInfoMapper.findUserByOrgId(queryCondition.getUserId());
		}
		if (CollectionUtils.isEmpty(map)) {
			return havList;
		}
		for (Map item : map) {
			HandleAnalysisValue bean = new HandleAnalysisValue();
			bean.setRoleId((String) item.get("roleId"));
			bean.setUserName((String) item.get("userName"));
			// BeanUtils.copyProperties(item, bean);
			havList.add(bean);

		}

		for (int i = 0; i < havList.size(); i++) {
			String roleId = havList.get(i).getRoleId();
			queryCondition.setRoleId(roleId);
			HandleAnalysisValue hav = alarmSum(queryCondition);
			havList.get(i).setAlarmSum(hav.getAlarmSum()).setFalseAlarmErro(hav.getFalseAlarmErro())
					.setProcessed(hav.getProcessed()).setProcessedErro(hav.getProcessedErro())
					.setUntreated(hav.getUntreated());
		}

		return havList;
	}

	public HandleAnalysisValue alarmSum(QueryCondition queryCondition) {
		HandleAnalysisValue bean = new HandleAnalysisValue();
		List<TempPltwarn> t = tempPlTWarnMapper.getAlarmSum(queryCondition);
		Integer sum = t.size();
		Integer processed = 0;// 已处理总数
		Integer processedErro = 0;// 已处理误差
		Integer falseAlarmErro = 0;// 误报误差
		for (int i = 0; i < t.size(); i++) {
			if (PMSUtils.isNotEmpty(t.get(i).getHandleSuggestion())) {
				processed++;
			}
			if (t.get(i).getHandleResult().equals("2") && t.get(i).getAuditStatus().equals("1")) {// *已处理误差（审核为：已处理，处理为：误报）
				processedErro++;
			}
			if (t.get(i).getHandleResult().equals("1") && t.get(i).getAuditStatus().equals("2")) {// *误报误差（应该：误报，处理为：已处理）
				falseAlarmErro++;
			}
		}
		Integer untreated = sum - processed;// 未处理
		// Integer untreatedRatio = (sum == 0) ? 0 : untreated / sum;//
		// 未处理占比：未处理/总数
		// Integer errorRatio = (processed == 0) ? 0 : (processedErro +
		// falseAlarmErro) / processed;// 误差占比:
		// （已处理误差+误报误差）/已处理
		bean.setAlarmSum(sum.toString()).setProcessed(processed.toString()).setUntreated(untreated.toString())
				.setFalseAlarmErro(falseAlarmErro.toString()).setProcessedErro(processedErro.toString());
		return bean;
	}

}
