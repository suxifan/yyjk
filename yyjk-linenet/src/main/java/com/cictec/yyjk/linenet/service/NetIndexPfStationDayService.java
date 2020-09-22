package com.cictec.yyjk.linenet.service;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfStationDay;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

/**
 * Created by mao on 2019/10/15.
 */
public interface NetIndexPfStationDayService extends Service<NetIndexPfStationDay> {

	/**
	 * 获取线路站点登降量列表Griddata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getPfStationDayListGridData(NetIndexPfBaseVo vo);
}
