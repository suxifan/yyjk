package com.cictec.yyjk.linenet.service;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatCompany;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

/**
 * Created by mao on 2019/10/14.
 */
public interface NetIndexRepeatCompanyService extends Service<NetIndexRepeatCompany> {
	/**
	 * 获取分公司线路重复度Echartdata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getCompanyLineRepeatEchartData(NetDataBuslineVo vo);
}
