package com.cictec.yyjk.base.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cictec.yyjk.base.model.entity.BaseAccessLog;
import com.cictec.yyjk.base.model.view.GridChartOption;
import com.cictec.yyjk.base.model.vo.BaseAccessLogVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2020/04/02.
 */
public interface BaseAccessLogService extends Service<BaseAccessLog> {
	/**
	 * 根据条件获取用户访问日志信息
	 * 
	 * @param vo
	 * @return
	 */
	List<BaseAccessLog> getAccsessLogs(BaseAccessLogVo vo);

	/**
	 * 访问日志分析
	 * 
	 * @param startTime
	 * @param endTime
	 * @param orgId
	 * @return
	 */
	GridChartOption accessLogStatisticAnalysis(Date startTime, Date endTime, String orgId);

	/**
	 * 访问页面频次日志分析
	 * 
	 * @param startTime
	 * @param endTime
	 * @param orgId
	 * @return
	 */
	GridChartOption pageLogStatisticAnalysis(Date startTime, Date endTime, String orgId);
	
	/**
	 * 获取用户访问的模块及页面
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, List<String>> getModelAndPageInfoByUserId(String userId);
	
}
