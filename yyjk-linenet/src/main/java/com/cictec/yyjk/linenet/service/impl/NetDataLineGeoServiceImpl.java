package com.cictec.yyjk.linenet.service.impl;

import com.cictec.yyjk.linenet.mapper.NetDataLineGeoMapper;
import com.cictec.yyjk.linenet.model.entity.NetDataLineGeo;
import com.cictec.yyjk.linenet.service.NetDataLineGeoService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2019/10/08.
 */
@Service
@Transactional
public class NetDataLineGeoServiceImpl extends AbstractService<NetDataLineGeo> implements NetDataLineGeoService {

    @Resource
    private NetDataLineGeoMapper netDataLineGeoMapper;

}
