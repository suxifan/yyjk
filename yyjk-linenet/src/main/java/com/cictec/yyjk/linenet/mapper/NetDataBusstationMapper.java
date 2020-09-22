package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetDataBusstation;
import com.cictec.yyjk.linenet.model.view.NetDataBusstationValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBasestationVo;

public interface NetDataBusstationMapper extends Mapper<NetDataBusstation> {
	/**
	 * 获取机构站位数
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBusstationValue> getCompanyBusStations(NetDataBasestationVo vo);
}