package com.cictec.yyjk.base.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BusLineMapper;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.vo.BusLineStationVo;
import com.cictec.yyjk.base.model.vo.BusLineVo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.base.service.BusLineService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * Created by xpguo on 2019/05/21.
 */
@Service
@Transactional
public class BusLineServiceImpl extends AbstractService<BusLine> implements BusLineService {

	@Resource
	private BusLineMapper busLineMapper;
	@Resource
	private BaseUserInfoService baseUserInfoService;

	@Override
	public List<BusLine> getBusLineByExample(BusLineVo busLineVo) {
		Example example = new Example(BusLine.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(busLineVo.getLineId())) {
			criteria.andEqualTo("lineUuid", busLineVo.getLineId());
		}
		if (busLineVo.getLineUuids() != null && busLineVo.getLineUuids().size() > 0) {
			criteria.andIn("lineUuid", busLineVo.getLineUuids());
		}
		if (PMSUtils.isNotEmpty(busLineVo.getLineName())) {
			criteria.andLike("lineName", "%" + busLineVo.getLineName() + "%");
		}
		if (PMSUtils.isNotEmpty(busLineVo.getOrgId())) {
			criteria.andEqualTo("lineOrgUuid", busLineVo.getOrgId());
		}
		if (PMSUtils.isNotEmpty(busLineVo.getIsvalid())) {
			criteria.andEqualTo("lineIsvalid", busLineVo.getIsvalid());
		} else {
			criteria.andEqualTo("lineIsvalid", "1");
		}
		if (PMSUtils.isNotEmpty(busLineVo.getDropFlag())) {
			criteria.andEqualTo("lineDropFlag", busLineVo.getDropFlag());
		} else {
			criteria.andEqualTo("lineDropFlag", "0");
		}
		example.setOrderByClause("line_name");
		return busLineMapper.selectByExample(example);
	}

	@Override
	public List<BusLine> getBusLineByUserAuths(BaseUserInfo userInfo) {
		List<BusLine> lineAuths = baseUserInfoService.getLineAuthByUserId(userInfo);
		if (CollectionUtils.isNotEmpty(lineAuths)) {
			return lineAuths;
		}
		return Collections.emptyList();
	}

	@Override
	public List<BusLineStationVo> getAllLineStations() {
		return busLineMapper.getAllLineStations();
	}

	@Override
	public List<BusLineVo> getAllBusLines() {
		return busLineMapper.getAllBusLines();
	}

	@Override
	public Integer getLineCount(String orgId) {
		return busLineMapper.getLineCount(orgId);
	}

}
