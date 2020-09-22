package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexLevelEntropyResult;
import com.cictec.yyjk.linenet.model.view.NetIndexLevelEntropyResultVoValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

/**
 * Created by mao on 2019/10/17.
 */
public interface NetIndexLevelEntropyResultService extends Service<NetIndexLevelEntropyResult> {
	/**
	 * 获取线网评分-线路等级占比gridData
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexLevelEntropyResultVoValue> getLevelLineCountListData(NetDataBuslineVo vo);
}
