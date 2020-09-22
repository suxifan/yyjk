package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.DwDimSysDatadictType;
import com.cictec.yyjk.base.model.vo.DwDimSysDatadictTypeVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/08/29.
 */
public interface DwDimSysDatadictTypeService extends Service<DwDimSysDatadictType> {
	/**
	 * 根据条件查询设备类型列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<DwDimSysDatadictType> selectByVo(DwDimSysDatadictTypeVo vo);
}
