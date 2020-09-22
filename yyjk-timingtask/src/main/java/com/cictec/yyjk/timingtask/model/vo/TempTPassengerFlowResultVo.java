package com.cictec.yyjk.timingtask.model.vo;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象
 * Created by xpguo on 2020/08/25.
 */
public class TempTPassengerFlowResultVo extends AbstractVo {
	
	private String pfrLineUuid;
	
	private String prfDevCode;

	public String getPfrLineUuid() {
		return pfrLineUuid;
	}

	public void setPfrLineUuid(String pfrLineUuid) {
		this.pfrLineUuid = pfrLineUuid;
	}

	public String getPrfDevCode() {
		return prfDevCode;
	}

	public void setPrfDevCode(String prfDevCode) {
		this.prfDevCode = prfDevCode;
	}
	
	

}
