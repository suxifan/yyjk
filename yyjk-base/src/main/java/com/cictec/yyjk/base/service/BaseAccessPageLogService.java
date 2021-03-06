package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseAccessPageLog;
import com.cictec.yyjk.base.model.vo.BaseAccessPageLogVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2020/04/13.
 */
public interface BaseAccessPageLogService extends Service<BaseAccessPageLog> {

	/**
	 * 根据条件获取用户访问页面行为日志信息
	 * 
	 * @param vo
	 * @return
	 */
	List<BaseAccessPageLog> getAccessPageLogs(BaseAccessPageLogVo vo);
}
