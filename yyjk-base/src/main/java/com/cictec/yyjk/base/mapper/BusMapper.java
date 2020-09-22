package com.cictec.yyjk.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.vo.BusDeviceVo;
import com.cictec.yyjk.base.model.vo.BusVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface BusMapper extends Mapper<Bus> {

	/**
	 * 获取总车辆数
	 * 
	 * @return
	 */
	public Integer getTotalBus(@Param(value = "orgId") String orgId);

	/**
	 * 根据车牌获取车辆信息
	 * 
	 * @param busPlateNumber
	 * @return
	 */
	public Bus getBusInfo(@Param(value = "busPlateNumber") String busPlateNumber);

	/**
	 * 根据车辆id获取车辆终端Id
	 * 
	 * @param busPlateNumber
	 * @return
	 */
	public String getBusDevRefId(@Param(value = "busUuid") String busUuid);

	/**
	 * 根据查询条件获取车辆列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<Bus> getBuses(BusVo vo);

	/**
	 * 导入车辆设备关系时根据车辆条件查询对应车辆
	 * 
	 * @param vo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map getBusInfoByVo(BusDeviceVo vo);

	/**
	 * 获取车辆的机构信息
	 * 
	 * @return
	 */
	public List<Map<String, String>> getBusOrgInfo();

	/**
	 * 获取绑定minieye设备的车辆信息
	 * 
	 * @return
	 */
	List<Bus> getMinieyeBus(BusVo vo);

	/**
	 * 根据线路获取机构，线路及车辆信息
	 * 
	 * @param lineUuids
	 * @return
	 */
	List<Bus> getBusByLineIds(@Param(value = "lineUuids") List<String> lineUuids);

	/**
	 * 查询下发记录
	 */
	List<Map> selectvoiceprompt();

	/**
	 * 获取车辆自编号
	 * 
	 * @return
	 */
	public List<Bus> getCarNoList(BusVo vo);
}