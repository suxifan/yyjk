package com.cictec.yyjk.base.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2019/05/28.
 */
public class BaseRoleInfoVo extends AbstractVo {
	private String roleName;
	private String enabled;
	private String tokenUserAccount;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getTokenUserAccount() {
		return tokenUserAccount;
	}

	public void setTokenUserAccount(String tokenUserAccount) {
		this.tokenUserAccount = tokenUserAccount;
	}

}
