package com.cictec.yyjk.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.vo.BusLineStationVo;
import com.cictec.yyjk.base.model.vo.BusLineVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface BusLineMapper extends Mapper<BusLine> {
	/**
	 * 获取所有线路站点信息
	 * 
	 * @return
	 */
	List<BusLineStationVo> getAllLineStations();

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
	Integer getLineCount(@Param(value = "orgId") String orgId);
}