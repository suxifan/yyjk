package com.cictec.yyjk.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseSysParamInfoMapper;
import com.cictec.yyjk.base.model.entity.BaseSysParamInfo;
import com.cictec.yyjk.base.model.vo.BaseSysParamInfoVo;
import com.cictec.yyjk.base.service.BaseSysParamInfoService;
import com.cictec.yyjk.commons.core.AbstractService;

/**
 * Created by xpguo on 2019/11/07.
 */
@Service
@Transactional
public class BaseSysParamInfoServiceImpl extends AbstractService<BaseSysParamInfo> implements BaseSysParamInfoService {

	@Resource
	private BaseSysParamInfoMapper baseSysParamInfoMapper;

	@Override
	public List<BaseSysParamInfo> getBaseSysParamInfoByExample(BaseSysParamInfoVo baseSysParamInfoVo) {
		/*
		 * Example example = new Example(BaseSysParamInfo.class); Criteria
		 * criteria = example.createCriteria(); if
		 * (PMSUtils.isNotEmpty(baseSysParamInfoVo.getParamName())) {
		 * criteria.andLike("paramName", "%" + baseSysParamInfoVo.getParamName()
		 * + "%"); }
		 * 
		 * if (PMSUtils.isNotEmpty(baseSysParamInfoVo.getParamIsvalid())) {
		 * criteria.andEqualTo("paramIsvalid",
		 * baseSysParamInfoVo.getParamIsvalid()); }
		 * 
		 * return baseSysParamInfoMapper.selectByExample(example);
		 */
		return baseSysParamInfoMapper.getBaseSysParamInfoByExample(baseSysParamInfoVo);
	}
}
