package com.cictec.yyjk.fatigue.mapper;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TDevice;
import com.cictec.yyjk.fatigue.model.vo.TDeviceVo;

public interface TDeviceMapper extends Mapper<TDevice> {

	/**
	 * 设备在线率状态统计
	 */
	Map<String, String> countDeviceStatus(TDeviceVo vo);

	/**
	 * 查询设备在线信息
	 */
	List<TDevice> queryDeviveInfo(TDeviceVo vo);

	/**
	 * 查询所有设备信息
	 */
	List<TDevice> queryAllDeviveInfo();
}