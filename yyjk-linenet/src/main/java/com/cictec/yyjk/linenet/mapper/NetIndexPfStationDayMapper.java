package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfStationDay;
import com.cictec.yyjk.linenet.model.view.NetIndexPfBaseValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

public interface NetIndexPfStationDayMapper extends Mapper<NetIndexPfStationDay> {

	/**
	 * 获取线路站点登降量列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfBaseValue> getPfStationDayList(NetIndexPfBaseVo vo);
}