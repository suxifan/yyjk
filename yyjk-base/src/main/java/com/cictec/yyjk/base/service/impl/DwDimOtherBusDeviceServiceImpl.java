package com.cictec.yyjk.base.service.impl;

import com.cictec.yyjk.base.mapper.DwDimOtherBusDeviceMapper;
import com.cictec.yyjk.base.model.entity.DwDimOtherBusDevice;
import com.cictec.yyjk.base.service.DwDimOtherBusDeviceService;
import com.cictec.yyjk.commons.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xpguo on 2019/09/03.
 */
@Service
@Transactional
public class DwDimOtherBusDeviceServiceImpl extends AbstractService<DwDimOtherBusDevice> implements DwDimOtherBusDeviceService {

    @Resource
    private DwDimOtherBusDeviceMapper dwDimOtherBusDeviceMapper;

}
