package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaTransfordata;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaTransfordataValue;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;

/**
 * Created by mao on 2019/10/18.
 */
public interface NetIndexDeaTransfordataService extends Service<NetIndexDeaTransfordata> {
	/**
	 * 获取线网评分指标链接-列表Data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexDeaTransfordataValue> getDeaDataListData(NetXmlConfigVo vo);
}
