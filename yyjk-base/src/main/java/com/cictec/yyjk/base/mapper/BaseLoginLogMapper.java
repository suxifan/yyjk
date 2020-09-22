package com.cictec.yyjk.base.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.BaseLoginLog;
import com.cictec.yyjk.base.model.vo.BaseLoginLogVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface BaseLoginLogMapper extends Mapper<BaseLoginLog> {
	/**
	 * 根据条件获取用户登录登出日志信息
	 * 
	 * @param vo
	 * @return
	 */
	List<BaseLoginLog> getLoginLogs(BaseLoginLogVo vo);

	/**
	 * 登录日志分析
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> loginLogStatisticAnalysis(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime);
}