package com.cictec.yyjk.base.mapper;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.commons.core.Mapper;

public interface BusSysOrgMapper extends Mapper<BusSysOrg> {
	
	//机构下拉列表
	List<BusSysOrg> selectTBusSysOrgList(BusSysOrg vo);
}