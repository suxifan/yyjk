package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.BaseRoleLineresourceMapper;
import com.cictec.yyjk.base.model.entity.BaseRoleLineresource;
import com.cictec.yyjk.base.service.BaseRoleLineresourceService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2020/04/14.
 */
@Service
@Transactional
public class BaseRoleLineresourceServiceImpl extends AbstractService<BaseRoleLineresource> implements BaseRoleLineresourceService {

    @Resource
    private BaseRoleLineresourceMapper baseRoleLineresourceMapper;

}
