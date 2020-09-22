package com.cictec.yyjk.commons.utils.baseMessage;

public class BaseMessageModel {
    private String $bus;//车辆
    private String $drv;//司机
    private String $startTime;//开始时间
    private String $endTime;//结束时间
    private String $alarmName;//报警名称
    private String $position;//实时位置（只到路）
    private String $duration;//持续时长
    private String $applyName;//调度申请
	public String get$bus() {
		return $bus;
	}
	public void set$bus(String $bus) {
		this.$bus = $bus;
	}
	public String get$drv() {
		return $drv;
	}
	public void set$drv(String $drv) {
		this.$drv = $drv;
	}
	public String get$startTime() {
		return $startTime;
	}
	public void set$startTime(String $startTime) {
		this.$startTime = $startTime;
	}
	public String get$endTime() {
		return $endTime;
	}
	public void set$endTime(String $endTime) {
		this.$endTime = $endTime;
	}
	public String get$alarmName() {
		return $alarmName;
	}
	public void set$alarmName(String $alarmName) {
		this.$alarmName = $alarmName;
	}
	public String get$position() {
		return $position;
	}
	public void set$position(String $position) {
		this.$position = $position;
	}
	public String get$duration() {
		return $duration;
	}
	public void set$duration(String $duration) {
		this.$duration = $duration;
	}
	public String get$applyName() {
		return $applyName;
	}
	public void set$applyName(String $applyName) {
		this.$applyName = $applyName;
	}
}
