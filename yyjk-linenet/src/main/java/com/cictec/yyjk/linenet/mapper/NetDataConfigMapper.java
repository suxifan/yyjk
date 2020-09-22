package com.cictec.yyjk.linenet.mapper;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetDataConfig;
import com.cictec.yyjk.linenet.model.view.NetDataConfigValue;

public interface NetDataConfigMapper extends Mapper<NetDataConfig> {
	/**
	 * 获取DeareslutConfigXML
	 * 
	 * @param vo
	 * @return
	 */
	public NetDataConfigValue getDeareslutConfigXML(NetDataConfig vo);

	/**
	 * 清空表
	 * 
	 * @param vo
	 * @return
	 */
	public void clearTabel();
}