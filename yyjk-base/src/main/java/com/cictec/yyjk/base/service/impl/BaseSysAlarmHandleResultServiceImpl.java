package com.cictec.yyjk.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseSysAlarmHandleResultMapper;
import com.cictec.yyjk.base.model.entity.BaseSysAlarmHandleResult;
import com.cictec.yyjk.base.model.vo.BaseSysAlarmHandleResultVo;
import com.cictec.yyjk.base.service.BaseSysAlarmHandleResultService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * Created by xpguo on 2020/04/13.
 */
@Service
@Transactional
public class BaseSysAlarmHandleResultServiceImpl extends AbstractService<BaseSysAlarmHandleResult> implements BaseSysAlarmHandleResultService {

    @Resource
    private BaseSysAlarmHandleResultMapper baseSysAlarmHandleResultMapper;

	@Override
	public List<BaseSysAlarmHandleResult> getBaseSysAlarmHandleResultByExample(BaseSysAlarmHandleResultVo baseSysAlarmHandleResultVo) {
		Example example = new Example(BaseSysAlarmHandleResult.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(baseSysAlarmHandleResultVo.getHandleContext())) {
			criteria.andLike("handleContext", "%" + baseSysAlarmHandleResultVo.getHandleContext() + "%");
		}

		if (PMSUtils.isNotEmpty(baseSysAlarmHandleResultVo.getHandleIsvalid())) {
			criteria.andEqualTo("handleIsvalid", baseSysAlarmHandleResultVo.getHandleIsvalid());
		}
		
		if (PMSUtils.isNotEmpty(baseSysAlarmHandleResultVo.getHandleStatus())) {
			criteria.andEqualTo("handleStatus", baseSysAlarmHandleResultVo.getHandleStatus());
		}
		if (PMSUtils.isNotEmpty(baseSysAlarmHandleResultVo.getHandleType())) {
			criteria.andEqualTo("handleType", baseSysAlarmHandleResultVo.getHandleType());
		}
		example.setOrderByClause(" handle_type,crate_time ");
		return baseSysAlarmHandleResultMapper.selectByExample(example);
	}

}
