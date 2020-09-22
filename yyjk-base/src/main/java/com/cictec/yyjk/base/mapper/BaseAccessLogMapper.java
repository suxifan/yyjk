package com.cictec.yyjk.base.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.BaseAccessLog;
import com.cictec.yyjk.base.model.vo.BaseAccessLogVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface BaseAccessLogMapper extends Mapper<BaseAccessLog> {
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
	List<Map<String, Object>> accessLogStatisticAnalysis(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime, @Param(value = "orgId") String orgId);

	/**
	 * 页面访问频次日志分析
	 * 
	 * @param startTime
	 * @param endTime
	 * @param orgId
	 * @return
	 */
	List<Map<String, Object>> pageLogStatisticAnalysis(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime, @Param(value = "orgId") String orgId);
}