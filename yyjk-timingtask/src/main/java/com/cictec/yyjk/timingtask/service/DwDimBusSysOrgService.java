package com.cictec.yyjk.timingtask.service;

import java.util.Map;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusSysOrg;


/**
 * Created by xpguo on 2019/09/25.
 */
public interface DwDimBusSysOrgService extends Service<DwDimBusSysOrg> {
	/**
	 * 清空表
	 */
	public void clearTabel();

	/**
	 * 机构字典
	 * 
	 * @return
	 */
	public Map<String, DwDimBusSysOrg> getBusSysOrgDisc();
}
