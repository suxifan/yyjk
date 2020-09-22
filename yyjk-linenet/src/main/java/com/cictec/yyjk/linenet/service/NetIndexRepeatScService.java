package com.cictec.yyjk.linenet.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.linenet.model.entity.NetIndexRepeatSc;
import com.cictec.yyjk.linenet.model.view.NetIndexRepeatScValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexRepeatScVo;

/**
 * Created by mao on 2019/10/14.
 */
public interface NetIndexRepeatScService extends Service<NetIndexRepeatSc> {
	/**
	 * 获取重复度指标链接列表Listdata
	 * 
	 * @param vo
	 * @return
	 */
	public List<NetIndexRepeatScValue> getCompanyLineRepeatScListData(NetIndexRepeatScVo vo);

}
