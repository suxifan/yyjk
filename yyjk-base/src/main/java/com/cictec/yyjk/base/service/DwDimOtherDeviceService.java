package com.cictec.yyjk.base.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.DwDimOtherDeviceVo;
import com.cictec.yyjk.commons.core.Service;

/**
 * Created by xpguo on 2019/08/30.
 */
public interface DwDimOtherDeviceService extends Service<DwDimOtherDevice> {

	/**
	 * 根据条件查询设备列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<DwDimOtherDevice> getDevicesBy(DwDimOtherDeviceVo vo);

	/**
	 * 根据车辆id查询该车辆绑定的设备信息
	 * 
	 * @param busUuid
	 * @return
	 */
	public List<DwDimOtherDevice> getDeviceInfoByBusUuid(String busUuid);

	/**
	 * 根据设备编号查询设备信息
	 * 
	 * @param devCode
	 * @return
	 */
	public List<DwDimOtherDevice> getDeviceInfoByDevCode(String devCode);

	/**
	 * 根据设备类型获取待绑定的设备信息
	 * 
	 * @param devUuid
	 * @param devClass
	 * @return
	 */
	public List<DwDimOtherDevice> getNoBindDevCodeList(String devUuid, String devClass);

	/**
	 * 根据代码类型及代码值查询该设备类型是否被绑定
	 * 
	 * @param typeValue
	 * @param typeCode
	 * @return
	 */
	public Integer getBindDevCodeByDevClass(String typeValue, String typeCode);

	/**
	 * 获取设备信息字典
	 * 
	 * @return
	 */
	public Map<String, String> devInfoMap();
}
