package com.cictec.yyjk.commons.core;

import java.util.Date;

import javax.persistence.Transient;

/**
 * 抽象VO对象，公共字段存储（分页对象参数）
 */
public abstract class AbstractVo {

	/** 当前页 默认 0 */
	protected Integer pageNum;
	/** 当前页 默认 0 */
	protected Integer pageNumber;
	/** 页大小 默认 10 */
	protected Integer pageSize;
	/** 排序字段 */
	protected String sort;
	/** 排序方式 ASC 、DESC */
	protected String order;
	protected Date startTime; // 开始时间
	protected Date endTime; // 结束时间
	@Transient
	private String personId;
	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
