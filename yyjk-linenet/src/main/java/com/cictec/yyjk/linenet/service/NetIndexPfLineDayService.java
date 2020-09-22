package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfLineDay;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineDayValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

/**
 * Created by mao on 2019/10/16.
 */
public interface NetIndexPfLineDayService extends Service<NetIndexPfLineDay> {
	/**
	 * 获取线路客流综合查询列表listdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineDayValue> getIndexPfLineDayListData(NetIndexPfBaseVo vo);

	/**
	 * 获取数据总览线路日均客流TOP10列表listdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfLineDayValue> getDayPfTOP10ListData(NetIndexPfBaseVo vo);
}
