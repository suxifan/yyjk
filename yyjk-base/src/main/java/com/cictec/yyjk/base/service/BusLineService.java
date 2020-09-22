package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.vo.BusLineStationVo;
import com.cictec.yyjk.base.model.vo.BusLineVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/05/21.
 */
public interface BusLineService extends Service<BusLine> {
	/**
	 * 获取所有线路站点信息
	 * 
	 * @return
	 */
	List<BusLineStationVo> getAllLineStations();

	/**
	 * 根据条件查询线路信息
	 * 
	 * @param busLineVo
	 * @return
	 */
	List<BusLine> getBusLineByExample(BusLineVo busLineVo);

	/**
	 * 根据用户条件获取线路
	 * 
	 * @param busLineVo
	 * @param userInfo
	 * @return
	 */
	List<BusLine> getBusLineByUserAuths(BaseUserInfo userInfo);

	/**
	 * 获取所有线路
	 * 
	 * @return
	 */
	List<BusLineVo> getAllBusLines();

	/**
	 * 获取机构下线路数
	 * 
	 * @param orgId
	 * @return
	 */
	Integer getLineCount(String orgId);
}
