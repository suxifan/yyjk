package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetDataBusline;
import com.cictec.yyjk.linenet.model.view.GridChartOption;
import com.cictec.yyjk.linenet.model.view.NetDataBuslineValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

/**
 * Created by xpguo on 2019/10/12.
 */
public interface NetDataBuslineService extends Service<NetDataBusline> {

	/**
	 * 获取机构列表data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBusline> getCompanyListData(NetDataBuslineVo vo);

	/**
	 * 获取线路列表data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBusline> getLineListData(NetDataBuslineVo vo);

	/**
	 * 获取机构线路条数Echartdata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getCompanyEchartData(NetDataBuslineVo vo);

	/**
	 * 获取机构线路上下行长度Echartdata
	 * 
	 * @param vo
	 * @return
	 */
	public GridChartOption getLineOnOrDownEchartData(NetDataBuslineVo vo);

	/**
	 * 获取机构线路机构线路列表Echartdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBuslineValue> getCompanyLineListsData(NetDataBuslineVo vo);

	/**
	 * 获取线路条数data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBuslineValue> getCompanyLineCountsListData(NetDataBuslineVo vo);

}
