package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatArrow;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

public interface NetIndexRepeatArrowMapper extends Mapper<NetIndexRepeatArrow> {

	/**
	 * 获取分公司线路重复度列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatArrow> getCompanyLineRepeatList(NetDataBuslineVo vo);

	/**
	 * 获取数据总览页线路重复度TOP10列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatArrow> getLineRepeatTOP10List(NetDataBuslineVo vo);
}