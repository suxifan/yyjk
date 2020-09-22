package com.cictec.yyjk.base.model.vo;

import java.util.Date;

import com.cictec.yyjk.commons.core.AbstractVo;


/**
 * 值对象 Created by xpguo on 2019/09/10.
 */
public class ExcelImportLogVo extends AbstractVo {
	// 实体名称
	private String xlsLogModel;
	// 开始时间
	private Date mdStartDate;
	// 结束时间
	private Date mdEndDate;

	public String getXlsLogModel() {
		return xlsLogModel;
	}

	public void setXlsLogModel(String xlsLogModel) {
		this.xlsLogModel = xlsLogModel;
	}

	public Date getMdStartDate() {
		return mdStartDate;
	}

	public void setMdStartDate(Date mdStartDate) {
		this.mdStartDate = mdStartDate;
	}

	public Date getMdEndDate() {
		return mdEndDate;
	}

	public void setMdEndDate(Date mdEndDate) {
		this.mdEndDate = mdEndDate;
	}
}
