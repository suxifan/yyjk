package com.cictec.yyjk.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.DwDimOtherDeviceVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface DwDimOtherDeviceMapper extends Mapper<DwDimOtherDevice> {

	/**
	 * 根据条件查询设备列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<DwDimOtherDevice> getDevices(DwDimOtherDeviceVo vo);

	/**
	 * 根据车辆id查询该车辆绑定的设备信息
	 * 
	 * @param busUuid
	 * @return
	 */
	public List<DwDimOtherDevice> getDeviceInfoByBusUuid(@Param(value = "busUuid") String busUuid);

	/**
	 * 根据车辆id查询该车辆绑定的设备信息
	 * 
	 * @param busUuid
	 * @return
	 */
	public List<DwDimOtherDevice> getDeviceInfoByDevCode(@Param(value = "devCode") String devCode);

	/**
	 * 根据设备类型获取待绑定的设备信息
	 * 
	 * @param busClass
	 * @return
	 */
	public List<DwDimOtherDevice> getNoBindDevCodeList(@Param(value = "devUuid") String devUuid,
			@Param(value = "devClass") String devClass);

	/**
	 * 根据代码类型及代码值查询该设备类型是否被绑定
	 * 
	 * @param typeValue
	 * @param typeCode
	 * @return
	 */
	public Integer getBindDevCodeByDevClass(@Param(value = "typeValue") String typeValue,
			@Param(value = "typeCode") String typeCode);

	/**
	 * 根据车辆id查询该车辆绑定疲劳minieye设备信息
	 * 
	 * @param busUuid
	 * @return
	 */
	public List<DwDimOtherDevice> getDeviceInfoByMinieye(@Param(value = "busUuid") String busUuid);
}