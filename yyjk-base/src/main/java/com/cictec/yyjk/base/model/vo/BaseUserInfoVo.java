package com.cictec.yyjk.base.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2019/05/28.
 */
public class BaseUserInfoVo extends AbstractVo {
	private String userName;
	private String gender;
	private String userAccount;
	private String enabled;
	private String orgId;
	private String tokenUserAccount;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getTokenUserAccount() {
		return tokenUserAccount;
	}

	public void setTokenUserAccount(String tokenUserAccount) {
		this.tokenUserAccount = tokenUserAccount;
	}

}
