package com.cictec.yyjk.report.model.data;

import java.io.Serializable;

public class HandleAnalysisValue implements Serializable{
	private static final long serialVersionUID = 5191908194426710585L;
	/**
	 *角色id
	 */
	private String roleId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 应处理报警总数
	 */
	private String alarmSum;
	/**
	 * 已处理
	 */
	private String processed;
	/**
	 * 未处理
	 */
	private String untreated;
	/**
	 * 已处理误差
	 */
	private String processedErro;
	/**
	 * 误报误差
	 */
	private String falseAlarmErro;
	// /**
	// * 未处理占比
	// */
	// private String untreatedRatio;
	// /**
	// * 误差占比
	// */
	// private String errorRatio;
	
	public String getRoleId() {
		return roleId;
	}
	public HandleAnalysisValue setRoleId(String roleId) {
		this.roleId = roleId;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public HandleAnalysisValue setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public String getAlarmSum() {
		return alarmSum;
	}
	public HandleAnalysisValue setAlarmSum(String alarmSum) {
		this.alarmSum = alarmSum;
		return this;
	}
	public String getProcessed() {
		return processed;
	}
	public HandleAnalysisValue setProcessed(String processed) {
		this.processed = processed;
		return this;
	}
	public String getUntreated() {
		return untreated;
	}
	public HandleAnalysisValue setUntreated(String untreated) {
		this.untreated = untreated;
		return this;
	}
	public String getProcessedErro() {
		return processedErro;
	}
	public HandleAnalysisValue setProcessedErro(String processedErro) {
		this.processedErro = processedErro;
		return this;
	}
	public String getFalseAlarmErro() {
		return falseAlarmErro;
	}
	public HandleAnalysisValue setFalseAlarmErro(String falseAlarmErro) {
		this.falseAlarmErro = falseAlarmErro;
		return this;
	}
	// public String getUntreatedRatio() {
	// return untreatedRatio;
	// }
	// public HandleAnalysisValue setUntreatedRatio(String untreatedRatio) {
	// this.untreatedRatio = untreatedRatio;
	// return this;
	// }
	// public String getErrorRatio() {
	// return errorRatio;
	// }
	// public HandleAnalysisValue setErrorRatio(String errorRatio) {
	// this.errorRatio = errorRatio;
	// return this;
	// }
	

	// ;
	


}
