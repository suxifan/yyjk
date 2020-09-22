package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.DwDimSysDatadict;
import com.cictec.yyjk.base.model.vo.DwDimSysDatadictVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/08/29.
 */
public interface DwDimSysDatadictService extends Service<DwDimSysDatadict> {
	/**
	 * 根据条件查询设备类型明细
	 * 
	 * @param vo
	 * @return
	 */
	public List<DwDimSysDatadict> selectByVo(DwDimSysDatadictVo vo);

	/**
	 * 获取有效的设备类型字典
	 * 
	 * @return
	 */
	public List<DwDimSysDatadict> queryDatadicts(String typeCode);
}
