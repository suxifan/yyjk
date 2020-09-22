package com.cictec.yyjk.timingtask.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisArriveVolumeDay;


/**
 * Created by xpguo on 2019/05/23.
 */
public interface AnalysisArriveVolumeDayService extends Service<AnalysisArriveVolumeDay> {
	/**
	 * 根据日期获取当天所以线路ids
	 * 
	 * @param dateTime
	 * @return
	 */
	public List<String> getLineIds(String dateTime);

	/**
	 * 根据线路，日期获取到站数据
	 * 
	 * @param lineId
	 * @param dateTime
	 * @return
	 */
	public List<AnalysisArriveVolumeDay> getAnalysisArriveVolumeDatas(String lineId, String dateTime);

}
