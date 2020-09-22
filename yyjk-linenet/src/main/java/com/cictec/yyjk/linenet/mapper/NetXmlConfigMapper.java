package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetXmlConfig;
import com.cictec.yyjk.linenet.model.view.NetXmlConfigValue;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;

public interface NetXmlConfigMapper extends Mapper<NetXmlConfig> {

	/**
	 * 获取线网评分指标链接需要查询的tab列
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetXmlConfigValue> getSelectColumn(NetXmlConfigVo vo);

	/**
	 * 获取线网评分指标链接需要查询的列名
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetXmlConfigValue> getCodeList(NetXmlConfigVo vo);

}