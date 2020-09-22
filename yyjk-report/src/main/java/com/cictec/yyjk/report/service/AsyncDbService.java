package com.cictec.yyjk.report.service;

import java.util.List;

import com.cictec.yyjk.report.model.entity.TempPltwarn;

public interface AsyncDbService {
	/**
	 * 批量插入驾驶员行为数据
	 * 
	 * @param jSONArray
	 */
	void insertBadDrivingBehaviorInfo(List<TempPltwarn> list);

}
