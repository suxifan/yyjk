package com.cictec.yyjk.base.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2020/04/13.
 */
public class BaseAccessPageLogVo extends AbstractVo {
	private String orgId;
	private String userId;
	private String accessModelName;
	private String accessPageName;
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

	public String getAccessModelName() {
		return accessModelName;
	}

	public void setAccessModelName(String accessModelName) {
		this.accessModelName = accessModelName;
	}

	public String getAccessPageName() {
		return accessPageName;
	}

	public void setAccessPageName(String accessPageName) {
		this.accessPageName = accessPageName;
	}

	public String getAccessIp() {
		return accessIp;
	}

	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}

}
