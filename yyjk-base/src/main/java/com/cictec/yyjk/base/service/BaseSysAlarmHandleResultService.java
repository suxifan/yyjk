package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseSysAlarmHandleResult;
import com.cictec.yyjk.base.model.vo.BaseSysAlarmHandleResultVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2020/04/13.
 */
public interface BaseSysAlarmHandleResultService extends Service<BaseSysAlarmHandleResult> {

	/**
	 * 根据条件查询系统参数
	 * 
	 * @param baseSysParamInfoVo
	 * @return
	 */
	public List<BaseSysAlarmHandleResult> getBaseSysAlarmHandleResultByExample(BaseSysAlarmHandleResultVo baseSysAlarmHandleResultVo);
}
