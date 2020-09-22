package com.cictec.yyjk.base.mapper;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseSysParamInfo;
import com.cictec.yyjk.base.model.vo.BaseSysParamInfoVo;
import com.cictec.yyjk.commons.core.Mapper;

public interface BaseSysParamInfoMapper extends Mapper<BaseSysParamInfo> {

	List<BaseSysParamInfo> getBaseSysParamInfoByExample(BaseSysParamInfoVo baseSysParamInfoVo);

}