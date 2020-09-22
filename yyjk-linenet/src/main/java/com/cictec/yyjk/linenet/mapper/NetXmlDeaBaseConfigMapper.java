package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetXmlDeaBaseConfig;
import com.cictec.yyjk.linenet.model.view.NetXmlDeaBaseConfigValue;

public interface NetXmlDeaBaseConfigMapper extends Mapper<NetXmlDeaBaseConfig> {

	/**
	 * 清空表
	 * 
	 * @param vo
	 * @return
	 */
	public void clearTabel();

	/**
	 * 获取线网评分指标链接的提示值
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetXmlDeaBaseConfigValue> getDeaBaseConfigList();
}