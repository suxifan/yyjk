package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetDataBasestation;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetDataBasestationValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBasestationVo;

/**
 * Created by xpguo on 2019/10/12.
 */
public interface NetDataBasestationService extends Service<NetDataBasestation> {

	/**
	 * 获取机构站点数Echartdata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getCompanyEchartData(NetDataBasestationVo vo);

	/**
	 * 获取所有站点名Listdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBasestationValue> getAllBaseStationNamesListData(NetDataBasestationVo vo);
}
