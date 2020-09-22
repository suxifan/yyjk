package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseSysParamInfo;
import com.cictec.yyjk.base.model.vo.BaseSysParamInfoVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/11/07.
 */
public interface BaseSysParamInfoService extends Service<BaseSysParamInfo> {
	/**
	 * 根据条件查询系统参数
	 * 
	 * @param baseSysParamInfoVo
	 * @return
	 */
	public List<BaseSysParamInfo> getBaseSysParamInfoByExample(BaseSysParamInfoVo baseSysParamInfoVo);
}
