package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.DwDimLineStation;

public interface DwDimLineStationMapper extends Mapper<DwDimLineStation> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 获取线路站点的站间距
	 * 
	 * @return
	 */
	List<DwDimLineStation> getLineStationBetweenDistance();

	/**
	 * 根据线路UUID及lineType获取线站站序
	 * 
	 * @param lineUuid
	 * @param lineType
	 * @return
	 */
	List<String> getLineStaSeqs(@Param(value = "lineUuid") String lineUuid, @Param(value = "lineType") String lineType);

	public List<DwDimLineStation> getAll();

}