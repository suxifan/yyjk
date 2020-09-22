package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfLineDay;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineDayValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

public interface NetIndexPfLineDayMapper extends Mapper<NetIndexPfLineDay> {

	/**
	 * 获取线路客流综合查询列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineDayValue> getIndexPfLineDay(NetIndexPfBaseVo vo);

	/**
	 * 获取数据总览线路日均客流TOP10列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineDayValue> getDayPfTOP10List(NetIndexPfBaseVo vo);

}