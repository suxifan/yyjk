package com.cictec.yyjk.linenet.service;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatLinenum;
import com.cictec.yyjk.linenet.model.view.GridRadarOption;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

/**
 * Created by mao on 2019/10/14.
 */
public interface NetIndexRepeatLinenumService extends Service<NetIndexRepeatLinenum> {
	/**
	 * 获取分公司线路重复度Piedata
	 * 
	 * @param vo
	 * @return
	 */
	public GridRadarOption getCompanyLineNumRepeatPieData(NetDataBuslineVo vo);
}
