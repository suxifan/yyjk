package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatSc;
import com.cictec.yyjk.linenet.model.view.NetIndexRepeatScValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexRepeatScVo;

public interface NetIndexRepeatScMapper extends Mapper<NetIndexRepeatSc> {

	/**
	 * 获取重复度指标链接列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatScValue> getCompanyLineRepeatScList(NetIndexRepeatScVo vo);
}