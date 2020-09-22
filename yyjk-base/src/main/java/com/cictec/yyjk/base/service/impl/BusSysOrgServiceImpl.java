package com.cictec.yyjk.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BusSysOrgMapper;
import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.vo.BusSysOrgVo;
import com.cictec.yyjk.base.service.BusSysOrgService;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * Created by xpguo on 2019/05/20.
 */
@Service
@Transactional
public class BusSysOrgServiceImpl extends AbstractService<BusSysOrg> implements BusSysOrgService {

    @Resource
	private BusSysOrgMapper busSysOrgMapper;

	@Override
	public List<BusSysOrg> getBusSysOrgByExample(BusSysOrgVo busSysOrVo) {
		Example example = new Example(BusSysOrg.class);
		Criteria criteria = example.createCriteria();
		if (PMSUtils.isNotEmpty(busSysOrVo.getOrgId())) {
			criteria.andEqualTo("orgId", busSysOrVo.getOrgId());
		}
		if (PMSUtils.isNotEmpty(busSysOrVo.getOrgName())) {
			criteria.andEqualTo("orgName", busSysOrVo.getOrgName());
		}
		if (PMSUtils.isNotEmpty(busSysOrVo.getEnabled())) {
			criteria.andEqualTo("orgEnabled", busSysOrVo.getEnabled());
		} else {
			criteria.andEqualTo("orgEnabled", "1");
		}
		if (PMSUtils.isNotEmpty(busSysOrVo.getDropFlag())) {
			criteria.andEqualTo("orgDropFlag", busSysOrVo.getDropFlag());
		} else {
			criteria.andEqualTo("orgDropFlag", "0");
		}
		if (PMSUtils.isNotEmpty(busSysOrVo.getOrgType())) {
			criteria.andEqualTo("orgType", Integer.parseInt(busSysOrVo.getOrgType()));
		} else {
			criteria.andEqualTo("orgType", 1);
		}
		example.setOrderByClause(" org_sort_index ");
		return busSysOrgMapper.selectByExample(example);
	}

}
