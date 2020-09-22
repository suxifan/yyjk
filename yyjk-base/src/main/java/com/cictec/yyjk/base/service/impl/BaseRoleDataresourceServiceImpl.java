package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.BaseRoleDataresourceMapper;
import com.cictec.yyjk.base.model.entity.BaseRoleDataresource;
import com.cictec.yyjk.base.service.BaseRoleDataresourceService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2019/11/20.
 */
@Service
@Transactional
public class BaseRoleDataresourceServiceImpl extends AbstractService<BaseRoleDataresource> implements BaseRoleDataresourceService {

    @Resource
    private BaseRoleDataresourceMapper baseRoleDataresourceMapper;

}
