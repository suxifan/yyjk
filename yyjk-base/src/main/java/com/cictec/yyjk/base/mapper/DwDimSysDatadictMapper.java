package com.cictec.yyjk.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.base.model.entity.DwDimSysDatadict;
import com.cictec.yyjk.commons.core.Mapper;

public interface DwDimSysDatadictMapper extends Mapper<DwDimSysDatadict> {
	/**
	 * 获取有效的设备类型字典
	 * 
	 * @return
	 */
	public List<DwDimSysDatadict> queryDatadicts(@Param(value = "typeCode") String typeCode);
}