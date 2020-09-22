package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaTransfordata;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaTransfordataValue;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;

public interface NetIndexDeaTransfordataMapper extends Mapper<NetIndexDeaTransfordata> {
	/**
	 * 获取线网评分指标链接-列表Data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexDeaTransfordataValue> getDeaDataList(NetXmlConfigVo vo);
}