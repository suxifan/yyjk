package com.cictec.yyjk.report.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.report.mapper.DispatchInfoMapper;
import com.cictec.yyjk.report.model.entity.DispatchInfo;
import com.cictec.yyjk.report.model.vo.DispatchInfoVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.service.DispatchInfoService;

@Service
@Transactional
public class DispatchInfoServiceImpl extends AbstractService<DispatchInfo> implements DispatchInfoService {
	@Resource
	private DispatchInfoMapper dispatchInfoMapper;

	@Override
	public List<DispatchInfoVo> mergeMileage(List<DispatchInfoVo> arrays, QueryCondition queryCondition) {
		// 过滤掉班次为0,或0.0的数据
		List<DispatchInfoVo> result = new ArrayList<>();
		for (DispatchInfoVo item : arrays) {
			if (item.getRealtimeMileage() != 0 || item.getRealtimeMileage() != 0.0) {
				result.add(item);
			}
		}

		if (StringUtils.isNotEmpty(queryCondition.getOrgId())) {
			List<DispatchInfoVo> lineList = dispatchInfoMapper.getLinePlanMileage(queryCondition);
			return mergeData(result, lineList, "lineId", "mileage");
		} else {
			List<DispatchInfoVo> orgList = dispatchInfoMapper.getOrgPlanMileage();
			return mergeData(result, orgList, "orgId", "mileage");
		}
	}

	@Override
	public List<DispatchInfoVo> mergeTrips(List<DispatchInfoVo> arrays, QueryCondition queryCondition) {
		// 过滤掉趟次为0,或0.0的数据
		List<DispatchInfoVo> result = new ArrayList<>();
		for (DispatchInfoVo item : arrays) {
			if (item.getRealtimeTrips() != 0 || item.getRealtimeTrips() != 0.0) {
				result.add(item);
			}
		}
		if (StringUtils.isNotEmpty(queryCondition.getOrgId())) {
			List<DispatchInfoVo> lineList = dispatchInfoMapper.getBranchCompanyPlanTrips(queryCondition);
			return mergeData(result, lineList, "lineId", "trips");
		} else {
			List<DispatchInfoVo> orgList = dispatchInfoMapper.getHeadCompanyPlanTrips();
			return mergeData(result, orgList, "orgId", "trips");
		}
	}

	@Override
	public List<DispatchInfoVo> mergeClasses(List<DispatchInfoVo> arrays, QueryCondition queryCondition) {
		// 过滤掉班次为0,或0.0的数据
		List<DispatchInfoVo> result = new ArrayList<>();
		for (DispatchInfoVo item : arrays) {
			if (item.getRealtimeClasses() != 0 || item.getRealtimeClasses() != 0.0) {
				result.add(item);
			}
		}
		if (StringUtils.isNotEmpty(queryCondition.getOrgId())) {
			List<DispatchInfoVo> lineList = dispatchInfoMapper.getBranchCompanyPlanClasses(queryCondition);
			return mergeData(result, lineList, "lineId", "classes");
		} else {
			List<DispatchInfoVo> orglist = dispatchInfoMapper.getHeadCompanyPlanClasses();
			return mergeData(result, orglist, "orgId", "classes");
		}
	}

	/**
	 * 将计划值合并到有实际值的对象上
	 * 
	 * @param realList
	 *            实际值
	 * @param planList
	 *            计划值
	 * @Param orgLeave 机构级别
	 * @param type
	 *            里程，趟次，班次
	 */
	private List<DispatchInfoVo> mergeData(List<DispatchInfoVo> realList, List<DispatchInfoVo> planList,
			String orgLeave,
			String type) {
		Map<String, DispatchInfoVo> realMap = listToMap(realList, orgLeave);
		Map<String, DispatchInfoVo> planMap = listToMap(planList, orgLeave);
		
		Set<String> allKeys = new LinkedHashSet<>();
		allKeys.addAll(realMap.keySet());
		allKeys.addAll(planMap.keySet());
		
		List<DispatchInfoVo> result = new ArrayList<>();
		Iterator<String> it = allKeys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			DispatchInfoVo bean = null;
			if (realMap.containsKey(key) && planMap.containsKey(key)) {
				bean = realMap.get(key);
				if ("trips".equals(type)) {
					bean.setPlanTrips(planMap.get(key).getPlanTrips());
				}
				if ("classes".equals(type)) {
					bean.setPlanClasses(planMap.get(key).getPlanClasses());
				}
				if ("mileage".equals(type)) {
					bean.setPlanMileage(planMap.get(key).getPlanMileage());
				}
			} else if (realMap.containsKey(key) && !planMap.containsKey(key)) {
				bean = realMap.get(key);
				if ("trips".equals(type)) {
					bean.setPlanTrips(0f);
				}
				if ("classes".equals(type)) {
					bean.setPlanClasses(0f);
				}
				if ("pileage".equals(type)) {
					bean.setPlanMileage(0f);
				}
			} else if (!realMap.containsKey(key) && planMap.containsKey(key)) {
				bean = planMap.get(key);
				if ("trips".equals(type)) {
					bean.setRealtimeTrips(0f);
				}
				if ("classes".equals(type)) {
					bean.setRealtimeClasses(0f);
				}
				if ("mileage".equals(type)) {
					bean.setRealtimeMileage(0f);
				}
			}
			// 将机构和线路名映射到displyLabel属性
			if ("orgId".equals(orgLeave)) {
				bean.setDisplyLabel(bean.getOrgName());
			} else {
				bean.setDisplyLabel(bean.getLineName());
			}
			result.add(bean);
		}
		return result;
	}

	private Map<String, DispatchInfoVo> listToMap(List<DispatchInfoVo> list, String key) {
		Map<String, DispatchInfoVo> map = new LinkedHashMap<>();
		if (list == null || list.size() == 0) {
			return map;
		}
		for (DispatchInfoVo item : list) {
			if ("lineId".equals(key)) {
				if (StringUtils.isNotEmpty(item.getLineId()) && !map.containsKey(item.getLineId())) {
					map.put(item.getLineId(), item);
				}
			}
			if ("orgId".equals(key)) {
				if (StringUtils.isNotEmpty(item.getOrgId()) && !map.containsKey(item.getOrgId())) {
					map.put(item.getOrgId(), item);
				}
			}
		}
		return map;
	}
}
