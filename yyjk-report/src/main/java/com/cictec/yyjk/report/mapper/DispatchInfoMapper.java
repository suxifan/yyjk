package com.cictec.yyjk.report.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.report.model.entity.DispatchInfo;
import com.cictec.yyjk.report.model.vo.DispatchInfoVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;

public interface DispatchInfoMapper extends Mapper<DispatchInfo> {
	/**
	 * 按线路获取计划里程
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DispatchInfoVo> getLinePlanMileage(QueryCondition queryCondition);

	/**
	 * 按公司获取计划里程
	 * 
	 * @return
	 */
	List<DispatchInfoVo> getOrgPlanMileage();

	/**
	 * 获取分公司线路计划趟次
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DispatchInfoVo> getBranchCompanyPlanTrips(QueryCondition queryCondition);

	/**
	 * 获取总公司计划趟次
	 * 
	 * @return
	 */
	List<DispatchInfoVo> getHeadCompanyPlanTrips();

	/**
	 * 获取分公司线路计划班次
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DispatchInfoVo> getBranchCompanyPlanClasses(QueryCondition queryCondition);

	/**
	 * 获取总公司计划班次
	 * 
	 * @return
	 */
	List<DispatchInfoVo> getHeadCompanyPlanClasses();
}
