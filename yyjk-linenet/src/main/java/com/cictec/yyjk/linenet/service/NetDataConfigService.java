package com.cictec.yyjk.linenet.service;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetDataConfig;
import com.cictec.yyjk.linenet.model.view.NetDataConfigValue;

/**
 * Created by mao on 2019/10/17.
 */
public interface NetDataConfigService extends Service<NetDataConfig> {

	public NetDataConfigValue getDeareslutConfigXMLData(NetDataConfig vo);

	public void clearTabel();

}
