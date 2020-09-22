package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.vo.BusSysOrgVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/05/20.
 */
public interface BusSysOrgService extends Service<BusSysOrg> {

	public List<BusSysOrg> getBusSysOrgByExample(BusSysOrgVo busSysOrVo);
}
