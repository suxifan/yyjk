package com.cictec.yyjk.fatigue.service.impl;

import com.cictec.yyjk.fatigue.mapper.VoicepromptTempMapper;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTemp;
import com.cictec.yyjk.fatigue.service.VoicepromptTempService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2020/07/21.
 */
@Service
@Transactional
public class VoicepromptTempServiceImpl extends AbstractService<VoicepromptTemp> implements VoicepromptTempService {

    @Resource
    private VoicepromptTempMapper dwVoicepromptTempMapper;

}
