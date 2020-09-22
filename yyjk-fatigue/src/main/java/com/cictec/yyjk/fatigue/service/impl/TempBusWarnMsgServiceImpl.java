package com.cictec.yyjk.fatigue.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.fatigue.mapper.TempBusWarnMsgMapper;
import com.cictec.yyjk.fatigue.model.entity.TempBusWarnMsg;
import com.cictec.yyjk.fatigue.service.TempBusWarnMsgService;


/**
 * Created by xpguo on 2020/01/15.
 */
@Service
@Transactional
public class TempBusWarnMsgServiceImpl extends AbstractService<TempBusWarnMsg> implements TempBusWarnMsgService {

    @Resource
    private TempBusWarnMsgMapper tempBusWarnMsgMapper;

	@Override
	public boolean clearTabel() {
		return tempBusWarnMsgMapper.clearTabel();
	}

}
