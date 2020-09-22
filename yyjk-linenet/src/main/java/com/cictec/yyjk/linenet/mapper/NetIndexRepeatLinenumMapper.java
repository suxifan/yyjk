package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatLinenum;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

public interface NetIndexRepeatLinenumMapper extends Mapper<NetIndexRepeatLinenum> {

	/**
	 * 获取分公司线路重复度
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatLinenum> getCompanyLineNumRepeat(NetDataBuslineVo vo);
}