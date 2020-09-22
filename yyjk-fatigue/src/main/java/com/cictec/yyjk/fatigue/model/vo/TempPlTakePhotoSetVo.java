package com.cictec.yyjk.fatigue.model.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.cictec.yyjk.commons.core.AbstractVo;
import com.cictec.yyjk.fatigue.model.entity.TDevice;


/**
 * 值对象
 * Created by Rwq on 2020/03/10.
 */
public class TempPlTakePhotoSetVo extends AbstractVo {
	
	// 车牌号
    private String busPlateNumber;
    
	// 车辆编号
  	private String busUuid;
  	
	// 机构编号
    private String orgId;
    
	// 线路编号
    private String lineId;
    
	// 设备编号
    private String devCode;
    
	// 车辆编号
    private String busSelfCode;
    
    private Date startDate; // 开始日期
    private Date endDate; // 结束日期
    
    
	private List<TDevice> devList; //设备集合
	
	private String[] takePhotoUuids;
    
	public String getBusPlateNumber() {
		return busPlateNumber;
	}
	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}
	public String getBusUuid() {
		return busUuid;
	}
	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public String getBusSelfCode() {
		return busSelfCode;
	}
	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<TDevice> getDevList() {
		return devList;
	}
	public void setDevList(List<TDevice> devList) {
		this.devList = devList;
	}
	public String[] getTakePhotoUuids() {
		return takePhotoUuids;
	}
	public void setTakePhotoUuids(String[] takePhotoUuids) {
		this.takePhotoUuids = takePhotoUuids;
	}
    
    
}
