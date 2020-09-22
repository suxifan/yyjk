package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetDataBusline;
import com.cictec.yyjk.linenet.model.view.NetDataBuslineValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

public interface NetDataBuslineMapper extends Mapper<NetDataBusline> {
	/**
	 * 获取机构
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBusline> getCompanyList(NetDataBuslineVo vo);

	/**
	 * 获取线路
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBusline> getLineList(NetDataBuslineVo vo);

	/**
	 * 获取机构线路数
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBuslineValue> getCompanyLineCounts(NetDataBuslineVo vo);

	/**
	 * 获取机构线路长度
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBuslineValue> getCompanyLineLengths(NetDataBuslineVo vo);

	/**
	 * 获取机构线路上行长度
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBuslineValue> getCompanyLineOnLengths(NetDataBuslineVo vo);

	/**
	 * 获取机构线路下行长度
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBuslineValue> getCompanyLineDownLengths(NetDataBuslineVo vo);

	/**
	 * 获取机构线路列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetDataBuslineValue> getCompanyLineLists(NetDataBuslineVo vo);
}