package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatArrow;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

/**
 * Created by mao on 2019/10/14.
 */
public interface NetIndexRepeatArrowService extends Service<NetIndexRepeatArrow> {
	/**
	 * 获取分公司线路重复度Echartdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatArrow> getCompanyLineRepeatListData(NetDataBuslineVo vo);

	/**
	 * 获取数据总览页线路重复度TOP10列表data
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatArrow> getLineRepeatTOP10ListData(NetDataBuslineVo vo);
}
