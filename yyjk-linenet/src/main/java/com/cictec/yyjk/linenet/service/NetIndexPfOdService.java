package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfOd;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineOdValue;
import com.cictec.yyjk.linenet.model.view.NodeLinkChart;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

/**
 * Created by mao on 2019/10/16.
 */
public interface NetIndexPfOdService extends Service<NetIndexPfOd> {
	/**
	 * 获取线路各时间段客流详情-刷卡总量Griddata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getPfOdbrushCountListGridData(NetIndexPfBaseVo vo);

	/**
	 * 获取线路各时间段客流详情-周转量Griddata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getPfOdZZLListGridData(NetIndexPfBaseVo vo);

	/**
	 * 获取线路各时间段客流详情-平均运距Griddata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getPfOdPJYJListGridData(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD列表data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineOdValue> getPfLineOdCountListData(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD图X轴数据列表data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineOdValue> getPfODXCountListData(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD图数据列表data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineOdValue> getPfODEdgesList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD图data
	 * 
	 * @param vo
	 * @return
	 */
	public NodeLinkChart getPfODYCountListData(NetIndexPfBaseVo vo);
}
