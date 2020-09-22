package com.cictec.yyjk.fatigue.model.vo;

/**
 * <p>Description: 报警分析返回值对象</p>
 * <p>Title: TWarnsAnalysisDto.java</p>
 * <p> </p>
 * <p>Company: 北京中航讯科技股份公司西安研发中心</p>
 * @author Rwq
 * <pre>Histroy:
 *          2019年5月28日 上午10:28:25  Rwq  Create
 *</pre>
 */
public class TWarnsAnalysisDto{
	
    private String warnLevel; //报警级别
    
    private String warnNum;//报警数量

    private String busUuid;//车牌号
    
    private String busPlateNumber;//车牌号
    
    private String busSelfCode;//自编号
    
    private String warnLevel1Num;//一级报警级别数量
    
    private String warnLevel2Num;//二级报警级别数量
    
    private String warnLevel3Num;//三级报警级别数量
    
    private String warnUuid;//报警类型主键
    
    private String warnTypeName;//报警名称
    
    private String count;//报警数量
    
    private String contrastCount;//报警环比数量
    
    private String xdate;//x轴日期
    
	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getWarnNum() {
		return warnNum;
	}

	public void setWarnNum(String warnNum) {
		this.warnNum = warnNum;
	}

	public String getBusUuid() {
		return busUuid;
	}

	public void setBusUuid(String busUuid) {
		this.busUuid = busUuid;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public String getBusSelfCode() {
		return busSelfCode;
	}

	public void setBusSelfCode(String busSelfCode) {
		this.busSelfCode = busSelfCode;
	}

	public String getWarnLevel1Num() {
		return warnLevel1Num;
	}

	public void setWarnLevel1Num(String warnLevel1Num) {
		this.warnLevel1Num = warnLevel1Num;
	}

	public String getWarnLevel2Num() {
		return warnLevel2Num;
	}

	public void setWarnLevel2Num(String warnLevel2Num) {
		this.warnLevel2Num = warnLevel2Num;
	}

	public String getWarnLevel3Num() {
		return warnLevel3Num;
	}

	public void setWarnLevel3Num(String warnLevel3Num) {
		this.warnLevel3Num = warnLevel3Num;
	}

	public String getWarnUuid() {
		return warnUuid;
	}

	public void setWarnUuid(String warnUuid) {
		this.warnUuid = warnUuid;
	}

	public String getWarnTypeName() {
		return warnTypeName;
	}

	public void setWarnTypeName(String warnTypeName) {
		this.warnTypeName = warnTypeName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getContrastCount() {
		return contrastCount;
	}

	public void setContrastCount(String contrastCount) {
		this.contrastCount = contrastCount;
	}

	public String getXdate() {
		return xdate;
	}

	public void setXdate(String xdate) {
		this.xdate = xdate;
	}
    
	
    
}
