package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfOd;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineOdValue;
import com.cictec.yyjk.linenet.model.view.NetIndexPfOdValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

public interface NetIndexPfOdMapper extends Mapper<NetIndexPfOd> {

	/**
	 * 获取线路各时间段客流详情-刷卡总量列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfOdValue> getPfOdbrushCountList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路各时间段客流详情-周转量，平均运距列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfOdValue> getPfOdZZLAndPJYJList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineOdValue> getPfLineOdCountList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD图X轴数据列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineOdValue> getPfODXCountList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD图X轴下车站点数据列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineOdValue> getPfODXEStationCountList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路OD图数据列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineOdValue> getPfODEdgesList(NetIndexPfBaseVo vo);
}