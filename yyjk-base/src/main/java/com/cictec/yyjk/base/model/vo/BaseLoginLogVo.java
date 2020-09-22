package com.cictec.yyjk.base.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2020/04/02.
 */
public class BaseLoginLogVo extends AbstractVo {
	private String orgId;
	private String userId;
	private String accessModel;
	private String accessIp;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccessModel() {
		return accessModel;
	}

	public void setAccessModel(String accessModel) {
		this.accessModel = accessModel;
	}

	public String getAccessIp() {
		return accessIp;
	}

	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}

}
