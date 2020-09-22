package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.BaseUserRoleMapper;
import com.cictec.yyjk.base.model.entity.BaseUserRole;
import com.cictec.yyjk.base.service.BaseUserRoleService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2019/05/28.
 */
@Service
@Transactional
public class BaseUserRoleServiceImpl extends AbstractService<BaseUserRole> implements BaseUserRoleService {

    @Resource
    private BaseUserRoleMapper baseUserRoleMapper;

}
