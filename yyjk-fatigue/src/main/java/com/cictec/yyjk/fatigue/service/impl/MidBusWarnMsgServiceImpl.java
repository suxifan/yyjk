package com.cictec.yyjk.fatigue.service.impl;

import com.cictec.yyjk.fatigue.mapper.MidBusWarnMsgMapper;
import com.cictec.yyjk.fatigue.model.entity.MidBusWarnMsg;
import com.cictec.yyjk.fatigue.service.MidBusWarnMsgService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2020/01/15.
 */
@Service
@Transactional
public class MidBusWarnMsgServiceImpl extends AbstractService<MidBusWarnMsg> implements MidBusWarnMsgService {

    @Resource
    private MidBusWarnMsgMapper midBusWarnMsgMapper;

}
