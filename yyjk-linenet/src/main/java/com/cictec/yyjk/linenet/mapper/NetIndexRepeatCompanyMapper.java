package com.cictec.yyjk.linenet.mapper;

import java.util.List;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatCompany;
import com.cictec.yyjk.linenet.model.view.NetIndexRepeatCompanyValue;
import com.cictec.yyjk.linenet.model.vo.NetDataBuslineVo;

public interface NetIndexRepeatCompanyMapper extends Mapper<NetIndexRepeatCompany> {

	/**
	 * 获取分公司线路重复度
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatCompanyValue> getCompanyLineRepeat(NetDataBuslineVo vo);

}