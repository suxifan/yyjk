package com.cictec.yyjk.fatigue.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.model.vo.DwDimBusDriverVo;

/**
 * Created by xpguo on 2019/09/25.
 */
public interface DwDimBusDriverService extends Service<DwDimBusDriver> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 获取司机字典
	 * 
	 * @return
	 */
	public Map<String, DwDimBusDriver> getDriverDisc();

	/**
	 * 获取所有司机
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DwDimBusDriver> selectAllBusDriver(DwDimBusDriverVo dwDimBusDriverVo);

	/**
	 * 获取所有司机
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<DwDimBusDriver> selectAllBusDriverInfo();
}
