package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.BaseRoleResourceMapper;
import com.cictec.yyjk.base.model.entity.BaseRoleResource;
import com.cictec.yyjk.base.service.BaseRoleResourceService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2019/05/28.
 */
@Service
@Transactional
public class BaseRoleResourceServiceImpl extends AbstractService<BaseRoleResource> implements BaseRoleResourceService {

    @Resource
    private BaseRoleResourceMapper baseRoleResourceMapper;

}
