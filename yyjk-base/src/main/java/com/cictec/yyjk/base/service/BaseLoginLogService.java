package com.cictec.yyjk.base.service;

import java.util.Date;
import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseLoginLog;
import com.cictec.yyjk.base.model.view.GridChartOption;
import com.cictec.yyjk.base.model.vo.BaseLoginLogVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2020/04/02.
 */
public interface BaseLoginLogService extends Service<BaseLoginLog> {
	/**
	 * 根据条件获取用户登录登出日志信息
	 * 
	 * @param vo
	 * @return
	 */
	List<BaseLoginLog> getLoginLogs(BaseLoginLogVo vo);

	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	GridChartOption loginLogStatisticAnalysis(Date startTime, Date endTime);
}
