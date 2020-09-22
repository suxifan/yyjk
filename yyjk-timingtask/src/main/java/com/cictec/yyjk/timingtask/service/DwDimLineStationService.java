package com.cictec.yyjk.timingtask.service;

import java.util.List;
import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimLineStation;

/**
 * Created by xpguo on 2019/09/26.
 */
public interface DwDimLineStationService extends Service<DwDimLineStation> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 线路站点信息字典
	 * 
	 * @return
	 */
	public Map<String, DwDimLineStation> getLineStaDisc();

	/**
	 * 获取线路站点的站间距字典
	 * 
	 * key lineUuid+lineType+staUuid+staSeq
	 * 
	 * @return
	 */
	public Map<String, String> getLineStationBetweenDistanceDisc();

	/**
	 * 根据线路UUID及lineType获取线站站序
	 * 
	 * @param lineUuid
	 * @param lineType
	 * @return
	 */
	List<String> getLineStaSeqs(String lineUuid, String lineType);

	public List<DwDimLineStation> getAll();
}
