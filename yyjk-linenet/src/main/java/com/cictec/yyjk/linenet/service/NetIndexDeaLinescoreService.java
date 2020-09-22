package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexDeaLinescore;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexDeaLinescoreValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

/**
 * Created by mao on 2019/10/17.
 */
public interface NetIndexDeaLinescoreService extends Service<NetIndexDeaLinescore> {
	/**
	 * 获取数据总览-线路评分展示gridData
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getDeaLineScoreGrid(NetDataBuslineVo vo);

	/**
	 * 获取线网评分-列表ListData
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexDeaLinescoreValue> getDeaLineScoreListData(NetDataBuslineVo vo);
}
