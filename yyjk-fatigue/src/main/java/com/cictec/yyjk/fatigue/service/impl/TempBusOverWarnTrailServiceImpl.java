package com.cictec.yyjk.fatigue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.fatigue.mapper.TempBusOverWarnTrailMapper;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;
import com.cictec.yyjk.fatigue.service.TempBusOverWarnTrailService;


/**
 * Created by xpguo on 2020/02/13.
 */
@Service
@Transactional
public class TempBusOverWarnTrailServiceImpl extends AbstractService<TempBusOverWarnTrail>
		implements TempBusOverWarnTrailService {

    @Resource
	private TempBusOverWarnTrailMapper tempBusOverWarnTrailTempMapper;

	/**
	 * 获取超速报警数据
	 * 
	 * @return
	 */
	public List<TempBusOverWarnTrail> getOverSpeedInfos(){
		return tempBusOverWarnTrailTempMapper.getOverSpeedInfos();
	}
}
