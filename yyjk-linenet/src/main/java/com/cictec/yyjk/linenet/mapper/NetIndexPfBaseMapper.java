package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfBase;
import com.cictec.yyjk.linenet.model.view.NetIndexPfBaseValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;

public interface NetIndexPfBaseMapper extends Mapper<NetIndexPfBase> {

	/**
	 * 获取线路站点客流综合list
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfBaseValue> getPfBaseList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路时段满载率gridData
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfBaseValue> getPfBaseApprovalList(NetIndexPfBaseVo vo);

	/**
	 * 获取线路时段登降量gridData
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexPfBaseValue> getPfBaseUpDownList(NetIndexPfBaseVo vo);
}