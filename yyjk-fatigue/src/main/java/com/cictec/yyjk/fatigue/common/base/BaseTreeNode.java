package com.cictec.yyjk.fatigue.common.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class BaseTreeNode implements Serializable {

    
	/**
		 * 
		 */
	private static final long serialVersionUID = -7959637470919292378L;
	/**
	 * 时间原因，现实现简单的
	 */
	private String id;// 树节点id
	private String pId;// 树父节点id
	private String name;// 树节点id
	boolean checked; // 节点是否被选中
	boolean open;// 节点是否打开
    private String levelsType; //节点值
    private Integer onLines;
    private Integer unLines;
    private String busStatus;
    private JSONObject busPosition;
    private String orgName;
    private String lineName;
    private String DevRefId;//设备ID
    private Integer busLoadNumber;//和载人数
    private String busFuelType;//燃料类型
    private String busProductUse;//车辆用途
    private String busState;//车辆状态
    private String devUuid;//设备ID
    private String devCode;//客流设备号
    public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	private Object[] pigePicList;// 图片集合 抓拍
	public Object[] getPigePicList() {
		return pigePicList;
	}

	public void setPigePicList(Object[] pigePicList) {
		this.pigePicList = pigePicList;
	}

	public String getDevUuid() {
		return devUuid;
	}

	public void setDevUuid(String devUuid) {
		this.devUuid = devUuid;
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

	public String getDevRefId() {
		return DevRefId;
	}

	public void setDevRefId(String devRefId) {
		DevRefId = devRefId;
	}


	public Integer getBusLoadNumber() {
		return busLoadNumber;
	}

	public void setBusLoadNumber(Integer busLoadNumber) {
		this.busLoadNumber = busLoadNumber;
	}

	public String getBusFuelType() {
		return busFuelType;
	}

	public void setBusFuelType(String busFuelType) {
		this.busFuelType = busFuelType;
	}

	public String getBusProductUse() {
		return busProductUse;
	}

	public void setBusProductUse(String busProductUse) {
		this.busProductUse = busProductUse;
	}

	public String getBusState() {
		return busState;
	}

	public void setBusState(String busState) {
		this.busState = busState;
	}

	public JSONObject getBusPosition() {
		return busPosition;
	}

	public void setBusPosition(JSONObject busPosition) {
		this.busPosition = busPosition;
	}

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	public Integer getOnLines() {
		return onLines;
	}

	public void setOnLines(Integer onLines) {
		this.onLines = onLines;
	}

	public Integer getUnLines() {
		return unLines;
	}

	public void setUnLines(Integer unLines) {
		this.unLines = unLines;
	}

	public BaseTreeNode() {
		super();

	}

	public BaseTreeNode(String id, String name, String pId) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getLevelsType() {
		return levelsType;
	}

	public void setLevelsType(String levelsType) {
		this.levelsType = levelsType;
	}

	



     
	
}
