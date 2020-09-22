package com.cictec.yyjk.report.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class PassengerFlow {
	@Id
	@Column(name = "id")
	private String id;

	@Transient
	private String lineName;

	@Transient
	private String timeInterval;

	@Transient
	private String personCount;

	@Transient
	private String fullLoadRate;

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getPersonCount() {
		return personCount;
	}

	public void setPersonCount(String personCount) {
		this.personCount = personCount;
	}

	public String getFullLoadRate() {
		return fullLoadRate;
	}

	public void setFullLoadRate(String fullLoadRate) {
		this.fullLoadRate = fullLoadRate;
	}

}
