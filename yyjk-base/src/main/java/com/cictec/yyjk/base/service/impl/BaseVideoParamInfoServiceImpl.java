package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.BaseVideoParamInfoMapper;
import com.cictec.yyjk.base.model.entity.BaseVideoParamInfo;
import com.cictec.yyjk.base.service.BaseVideoParamInfoService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2019/11/12.
 */
@Service
@Transactional
public class BaseVideoParamInfoServiceImpl extends AbstractService<BaseVideoParamInfo> implements BaseVideoParamInfoService {

    @Resource
    private BaseVideoParamInfoMapper baseVideoParamInfoMapper;

}
