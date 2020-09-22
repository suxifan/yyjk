package com.cictec.yyjk.base.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Result;

public interface ExcelImportService {
	/**
	 * 导入车辆设备绑定关系
	 * 
	 * @param busDevices
	 * @param fileName
	 * @param userName
	 * @throws Exception
	 */
	public Result importBusDevice(List<Map<String, String>> busDevices, String fileName, String userName)
			throws Exception;

	/**
	 * 导入设备信息
	 * 
	 * @param devices
	 * @param fileName
	 * @param userName
	 * @throws Exception
	 */
	public Result importDeviceInfo(List<Map<String, String>> devices, String fileName, String userName)
			throws Exception;
}
