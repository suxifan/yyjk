package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetDataBasestation;
import com.cictec.yyjk.linenet.model.view.NetDataBasestationValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBasestationVo;

public interface NetDataBasestationMapper extends Mapper<NetDataBasestation> {
	/**
	 * 获取机构站位数
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBasestationValue> getCompanyBaseStations(NetDataBasestationVo vo);

	/**
	 * 获取所有站点名
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBasestationValue> getAllBaseStationNames(NetDataBasestationVo vo);

}