package com.cictec.yyjk.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.report.mapper.SysConfigInfoMapper;
import com.cictec.yyjk.report.model.entity.SysConfigInfo;
import com.cictec.yyjk.report.service.SysConfigInfoService;

@Service
@Transactional
public class SysConfigInfoServiceImpl extends AbstractService<SysConfigInfo> implements SysConfigInfoService {
	@Resource
	private SysConfigInfoMapper dao;
}
