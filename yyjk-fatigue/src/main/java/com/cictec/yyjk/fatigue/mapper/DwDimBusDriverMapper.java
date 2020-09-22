package com.cictec.yyjk.fatigue.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.model.vo.DwDimBusDriverVo;

public interface DwDimBusDriverMapper extends Mapper<DwDimBusDriver> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 获取所有司机
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DwDimBusDriver> selectAllBusDriver(DwDimBusDriverVo dwDimBusDriverVo);

	/**
	 * 获取司机工号信息
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DwDimBusDriver> selectAllBusDriverInfo();
}