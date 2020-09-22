package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.BaseDataResourceInfoMapper;
import com.cictec.yyjk.base.model.entity.BaseDataResourceInfo;
import com.cictec.yyjk.base.service.BaseDataResourceInfoService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2019/11/18.
 */
@Service
@Transactional
public class BaseDataResourceInfoServiceImpl extends AbstractService<BaseDataResourceInfo> implements BaseDataResourceInfoService {

    @Resource
    private BaseDataResourceInfoMapper baseDataResourceInfoMapper;

}
