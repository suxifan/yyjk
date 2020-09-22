package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetXmlConfig;
import com.cictec.yyjk.linenet.model.view.NetXmlConfigValue;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;

/**
 * Created by mao on 2019/10/18.
 */
public interface NetXmlConfigService extends Service<NetXmlConfig> {
	/**
	 * 获取线网评分指标链接需要查询的tab列Listdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetXmlConfigValue> getSelectColumnListData(NetXmlConfigVo vo);

	/**
	 * 获取线网评分指标链接需要查询的列名Listdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetXmlConfigValue> getCodeListData(NetXmlConfigVo vo);
}
