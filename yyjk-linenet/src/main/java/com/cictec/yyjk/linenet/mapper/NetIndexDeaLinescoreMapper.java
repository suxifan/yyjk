package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaLinescore;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaLinescoreValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

public interface NetIndexDeaLinescoreMapper extends Mapper<NetIndexDeaLinescore> {

	/**
	 * 获取数据总览-线路评分展示gridData
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexDeaLinescoreValue> getDeaLineScoreList(NetDataBuslineVo vo);
}