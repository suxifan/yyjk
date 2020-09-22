package com.cictec.yyjk.linenet.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetXmlDeaBaseConfig;

/**
 * Created by mao on 2019/10/22.
 */
public interface NetXmlDeaBaseConfigService extends Service<NetXmlDeaBaseConfig> {

	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 获取线网评分指标链接的提示值Listdata
	 * 
	 * @param vo
	 * @return
	 */
	public Map<String, String> getDeaBaseConfigListData();
}
