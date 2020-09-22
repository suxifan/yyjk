package com.cictec.yyjk.timingtask.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.TSafeDeviceRidControl;
import com.cictec.yyjk.timingtask.model.viewdata.TSafeDeviceRidControlValue;
import com.cictec.yyjk.timingtask.model.vo.TSafeDeviceRidControlVo;

/**
 * Created by xpguo on 2020/07/09.
 */
public interface TSafeDeviceRidControlService extends Service<TSafeDeviceRidControl> {

	/**
	 * 更新所有车辆掉线
	 */
	public void updateBusState();

	/*
	 * 根据busUuid获取机构信息
	 */
	public TSafeDeviceRidControl getBusDetailByBusUuid(String busUuid);

	/*
	 * 设备脱管报警
	 */
	public List<TSafeDeviceRidControlValue> getDeviceRidControlData(TSafeDeviceRidControlVo tSafeDeviceRidControlVo);

}
