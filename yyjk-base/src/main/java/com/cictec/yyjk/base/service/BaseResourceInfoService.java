package com.cictec.yyjk.base.service;

import java.util.List;

import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.vo.BaseResourceInfoVo;
import com.cictec.yyjk.commons.core.Service;


/**
 * Created by xpguo on 2019/05/28.
 */
public interface BaseResourceInfoService extends Service<BaseResourceInfo> {
	/**
	 * 根据条件查询
	 * 
	 * @param baseRoleInfoVo
	 * @return
	 */
	public List<BaseResourceInfo> getResourceInfoByVo(BaseResourceInfoVo baseResourceInfoVo);

	/**
	 * 新增资源
	 * 
	 * @param baseResourceInfo
	 */
	public void addResource(BaseResourceInfo baseResourceInfo);
}
