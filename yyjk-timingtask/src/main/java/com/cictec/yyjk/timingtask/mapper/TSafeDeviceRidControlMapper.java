package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.TSafeDeviceRidControl;
import com.cictec.yyjk.timingtask.model.viewdata.TSafeDeviceRidControlValue;
import com.cictec.yyjk.timingtask.model.vo.TSafeDeviceRidControlVo;

public interface TSafeDeviceRidControlMapper extends Mapper<TSafeDeviceRidControl> {

	public void updateBusState();

	public TSafeDeviceRidControl getBusDetailByBusUuid(@Param(value = "busUuid") String busUuid);

	public List<TSafeDeviceRidControlValue> getDeviceRidControlData(TSafeDeviceRidControlVo tSafeDeviceRidControlVo);
}