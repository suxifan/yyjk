package com.cictec.yyjk.timingtask.model.viewdata;

import java.math.BigDecimal;

public class PersonDetailValue {
	private BigDecimal totalOnPersonCount;// 总的上车人数
	private BigDecimal totalOffPersonCount;// 总的下车人数
	private Object pageInfo;// 分页数据
	private Object noPageInfo;// 非分页数据

	public BigDecimal getTotalOnPersonCount() {
		return totalOnPersonCount;
	}

	public void setTotalOnPersonCount(BigDecimal totalOnPersonCount) {
		this.totalOnPersonCount = totalOnPersonCount;
	}

	public BigDecimal getTotalOffPersonCount() {
		return totalOffPersonCount;
	}

	public void setTotalOffPersonCount(BigDecimal totalOffPersonCount) {
		this.totalOffPersonCount = totalOffPersonCount;
	}

	public Object getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(Object pageInfo) {
		this.pageInfo = pageInfo;
	}

	public Object getNoPageInfo() {
		return noPageInfo;
	}

	public void setNoPageInfo(Object noPageInfo) {
		this.noPageInfo = noPageInfo;
	}

}
