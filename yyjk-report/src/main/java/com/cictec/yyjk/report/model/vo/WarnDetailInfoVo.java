package com.cictec.yyjk.report.model.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.fatigue.model.entity.TWarn;

public class WarnDetailInfoVo {
	private String busId;
	private String busNumber;// 车牌号
	private String busSelfcode;// 自编号
	private String devRefId;// 终端Id(视频设备)
	private String samplingTime;
	private String warnSpeed;// 报警时速
	private String warnDeviceCode;// 报警设备号
	private String orgName;// 机构名
	private String lineName;// 线路名
	private String lineType;// 线路类型
	private String drvName;// 司机姓名
	private String drvIccard;// 司机工号
	private String positionSpeed;// 位置点速度
	private String planTrips;// 计划趟次
	private String currenttrip;// 当前趟次
	private String tripPercent;// 趟次百分比
	private Integer totalPersonFlow;// 当日累计客流
	private Integer currentPersonFlow;// 当前累计客流
	private Integer personNumberInCar;// 车内人数
	private Integer busLoadNumber;// 车辆荷载人数
	// 2019-08-20新增需求
	private boolean showVideo;// 是否显示车辆视频
	private List<TWarn> warnInfos = new ArrayList<TWarn>();// 报警详情
	private List<String> videoPaths = new ArrayList<String>(); // 获取视频流地址
	// 2019-11-03新增需求根据配置的车辆自编号来显示视频的位置信息顺序
	private List<String> busVideoOrder;
	private String personId;// 用户UUID
	// 线路uuids
	private List<String> lineUuids = new ArrayList<>();

	public List<String> getLineUuids() {
		return lineUuids;
	}

	public void setLineUuids(List<String> lineUuids) {
		this.lineUuids = lineUuids;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public List<String> getBusVideoOrder() {
		return busVideoOrder;
	}

	public void setBusVideoOrder(List<String> busVideoOrder) {
		this.busVideoOrder = busVideoOrder;
	}

	public void setTripPercent(String tripPercent) {
		this.tripPercent = tripPercent;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusSelfcode() {
		return busSelfcode;
	}

	public void setBusSelfcode(String busSelfcode) {
		this.busSelfcode = busSelfcode;
	}

	public String getDevRefId() {
		return devRefId;
	}

	public void setDevRefId(String devRefId) {
		this.devRefId = devRefId;
	}

	public String getWarnSpeed() {
		return warnSpeed;
	}

	public void setWarnSpeed(String warnSpeed) {
		this.warnSpeed = warnSpeed;
	}

	public String getWarnDeviceCode() {
		return warnDeviceCode;
	}

	public void setWarnDeviceCode(String warnDeviceCode) {
		this.warnDeviceCode = warnDeviceCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getDrvName() {
		return drvName;
	}

	public void setDrvName(String drvName) {
		this.drvName = drvName;
	}

	public String getDrvIccard() {
		return drvIccard;
	}

	public void setDrvIccard(String drvIccard) {
		this.drvIccard = drvIccard;
	}

	public String getPlanTrips() {
		return planTrips;
	}

	public void setPlanTrips(String planTrips) {
		this.planTrips = planTrips;
	}

	public String getCurrenttrip() {
		return currenttrip;
	}

	public void setCurrenttrip(String currenttrip) {
		this.currenttrip = currenttrip;
	}

	public String getPositionSpeed() {
		return positionSpeed;
	}

	public void setPositionSpeed(String positionSpeed) {
		this.positionSpeed = positionSpeed;
	}

	public String getTripPercent() {
		return tripPercent;
	}

	public void setTripPercent() {
		if (StringUtils.isEmpty(this.getPlanTrips()) || "0".equals(this.getPlanTrips())) {
			this.tripPercent = "0";
			return;
		}
		float currenttrip = (StringUtils.isEmpty(this.currenttrip) || this.currenttrip == null) ? 0f
				: Float.parseFloat(this.currenttrip);
		float planTrips = (StringUtils.isEmpty(this.planTrips)) ? 0f : Float.parseFloat(this.planTrips);
		float result = (currenttrip / planTrips) * 100;
		BigDecimal bg = new BigDecimal(result);
		this.tripPercent = bg.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue() + "";
	}

	public Integer getTotalPersonFlow() {
		return totalPersonFlow;
	}

	public void setTotalPersonFlow(Integer totalPersonFlow) {
		this.totalPersonFlow = totalPersonFlow;
	}

	public Integer getCurrentPersonFlow() {
		return currentPersonFlow;
	}

	public void setCurrentPersonFlow(Integer currentPersonFlow) {
		this.currentPersonFlow = currentPersonFlow;
	}

	public Integer getPersonNumberInCar() {
		return personNumberInCar;
	}

	public void setPersonNumberInCar(Integer personNumberInCar) {
		this.personNumberInCar = personNumberInCar;
	}

	public Integer getBusLoadNumber() {
		return busLoadNumber;
	}

	public void setBusLoadNumber(Integer busLoadNumber) {
		this.busLoadNumber = busLoadNumber;
	}

	public String getSamplingTime() {
		return samplingTime;
	}

	public void setSamplingTime(String samplingTime) {
		if (samplingTime != null && samplingTime.length() > 19) {
			this.samplingTime = samplingTime.substring(0, 19);
		} else {
			this.samplingTime = DateUtils.formatDateTime(new Date());
		}
	}

	public boolean isShowVideo() {
		return showVideo;
	}

	public void setShowVideo(boolean showVideo) {
		this.showVideo = showVideo;
	}

	public List<TWarn> getWarnInfos() {
		return warnInfos;
	}

	public void setWarnInfos(List<TWarn> warnInfos) {
		this.warnInfos = warnInfos;
	}

	public List<String> getVideoPaths() {
		return videoPaths;
	}

	public void setVideoPaths(List<String> videoPaths) {
		this.videoPaths = videoPaths;
	}

}
