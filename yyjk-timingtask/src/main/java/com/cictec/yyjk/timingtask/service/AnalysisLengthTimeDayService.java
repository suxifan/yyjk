package com.cictec.yyjk.timingtask.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeDay;


/**
 * Created by xpguo on 2019/06/28.
 */
public interface AnalysisLengthTimeDayService extends Service<AnalysisLengthTimeDay> {

	/**
	 * 定时任务，每天获取获取线路站间运行时间日数据
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<AnalysisLengthTimeDay> getAnalysisLengthTimeDayDatas(String dateTime);

	/**
	 * 到站数据日统计表保留2个月数据
	 * 
	 * @param month
	 */
	public void deleteLenthTimeDayDatas(@Param(value = "month") String month);
}
