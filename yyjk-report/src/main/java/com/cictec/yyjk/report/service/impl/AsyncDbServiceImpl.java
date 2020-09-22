package com.cictec.yyjk.report.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.report.model.entity.TempPltwarn;
import com.cictec.yyjk.report.service.AsyncDbService;

/**
 * 异步存储数据库落地数据
 * 
 * @author gxp
 *
 */
@Component
public class AsyncDbServiceImpl implements AsyncDbService {
	private static final Logger LOG = LoggerFactory.getLogger(AsyncDbServiceImpl.class);

	@Override
	public void insertBadDrivingBehaviorInfo(List<TempPltwarn> list) {
		// TODO Auto-generated method stub

	}

}
