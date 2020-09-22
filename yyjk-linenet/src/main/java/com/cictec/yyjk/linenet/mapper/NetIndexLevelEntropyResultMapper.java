package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexLevelEntropyResult;
import com.cictec.yyjk.linenet.model.view.NetIndexLevelEntropyResultVoValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

public interface NetIndexLevelEntropyResultMapper extends Mapper<NetIndexLevelEntropyResult> {

	/**
	 * 获取线网评分-线路等级占比gridData
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexLevelEntropyResultVoValue> getLevelLineCountList(NetDataBuslineVo vo);
}