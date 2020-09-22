package com.cictec.yyjk.report.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.report.model.entity.DispatchInfo;
import com.cictec.yyjk.report.model.vo.DispatchInfoVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;

public interface DispatchInfoService extends Service<DispatchInfo> {
	/**
	 * 合并里程
	 * 
	 * @param list
	 * @param queryCondition
	 * @return
	 */
	List<DispatchInfoVo> mergeMileage(List<DispatchInfoVo> list, QueryCondition queryCondition);

	/**
	 * 合并趟次
	 * 
	 * @param list
	 * @param queryCondition
	 * @return
	 */
	List<DispatchInfoVo> mergeTrips(List<DispatchInfoVo> list, QueryCondition queryCondition);

	/**
	 * 合并班次
	 * 
	 * @param list
	 * @param queryCondition
	 * @return
	 */
	List<DispatchInfoVo> mergeClasses(List<DispatchInfoVo> list, QueryCondition queryCondition);
}
