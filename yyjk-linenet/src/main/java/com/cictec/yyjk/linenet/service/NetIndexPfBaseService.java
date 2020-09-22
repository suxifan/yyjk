package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfBase;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexPfBaseValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

/**
 * Created by mao on 2019/10/14.
 */
public interface NetIndexPfBaseService extends Service<NetIndexPfBase> {
	/**
	 * 获取线路站点客流综合listdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfBaseValue> getPfBaseListData(NetIndexPfBaseVo vo);

	/**
	 * 获取线路时段满载率gridData
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getPfBaseApprovalGrid(NetIndexPfBaseVo vo);

	/**
	 * 获取线路时段登降量gridData
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getPfBaseUpDownGrid(NetIndexPfBaseVo vo);
}
