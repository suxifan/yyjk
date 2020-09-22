package com.cictec.yyjk.base.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.vo.BusDeviceVo;
import com.cictec.yyjk.base.model.vo.BusVo;
import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.commons.utils.BaseTreeNode;

/**
 * Created by xpguo on 2019/05/20.
 */
public interface BusService extends Service<Bus> {

	public List<Bus> getBusByExample(BusVo busVo);

	/**
	 * 获取总车辆数
	 * 
	 * @return
	 */
	Integer getTotalBus(String orgId);

	/**
	 * 根据车牌获取车辆信息
	 * 
	 * @param busPlateNumber
	 * @return
	 */
	Bus getBusInfo(String busPlateNumber);

	/**
	 * 根据车辆id获取车辆终端Id
	 * 
	 * @param busPlateNumber
	 * @return
	 */
	String getBusDevRefId(String busUuid);

	/**
	 * 根据查询条件获取车辆列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<Bus> getBusesBy(BusVo vo);
	
	/**
	 * 根据查询条件获取车辆列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<Bus> getSafeBuses(BusVo vo);

	/**
	 * 绑定车辆设备信息
	 * 
	 * @param bus
	 * @return
	 */
	public void bindingBusDeviceInfo(Bus bus, BaseUserInfo userInfo) throws Exception;

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
	 * 获取车辆字典,车牌号为key的map结构
	 * 
	 * @return
	 */
	public Map<String, Bus> getBusDic();

	/**
	 * 获取绑定minieye设备的车辆信息
	 * 
	 * @return
	 */
	public List<Bus> getMinieyeBus(BusVo vo);

	/**
	 * 根据线路获取机构，线路及车辆信息
	 * 
	 * @param lineUuids
	 * @return
	 */
	public List<Bus> getBusByLineIds(List<String> lineUuids);

	public List<BaseTreeNode> getBus();

	public List<Bus> getCarNoList(BusVo vo);
}
