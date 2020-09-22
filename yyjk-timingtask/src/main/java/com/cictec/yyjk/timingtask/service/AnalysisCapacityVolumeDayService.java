package com.cictec.yyjk.timingtask.service;

import java.util.Date;
import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisCapacityVolumeDay;


/**
 * Created by xpguo on 2019/05/22.
 */
public interface AnalysisCapacityVolumeDayService extends Service<AnalysisCapacityVolumeDay> {
	/**
	 * 获取客流运力运量日分析数据
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<AnalysisCapacityVolumeDay> getAnalysisCapacityVolumeDayDatas(Date startTime, Date endTime);
}
