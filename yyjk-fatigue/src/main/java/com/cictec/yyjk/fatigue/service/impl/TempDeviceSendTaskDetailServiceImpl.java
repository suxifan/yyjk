package com.cictec.yyjk.fatigue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.fatigue.mapper.TempDeviceSendTaskDetailMapper;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTaskDetail;
import com.cictec.yyjk.fatigue.service.TempDeviceSendTaskDetailService;


/**
 * Created by xpguo on 2019/11/21.
 */
@Service
@Transactional
public class TempDeviceSendTaskDetailServiceImpl extends AbstractService<TempDeviceSendTaskDetail> implements TempDeviceSendTaskDetailService {

    @Resource
    private TempDeviceSendTaskDetailMapper tempDeviceSendTaskDetailMapper;

	@Override
	public List<TempDeviceSendTaskDetail> selectTaskDetailPage(TempDeviceSendTaskDetail vo) {
		// TODO Auto-generated method stub
		return tempDeviceSendTaskDetailMapper.selectTaskDetailPage(vo);
	}

}
