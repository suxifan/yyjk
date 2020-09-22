package com.cictec.yyjk.fatigue.model.vo;
import com.cictec.yyjk.commons.core.AbstractVo;




/**
 * 值对象
 * Created by Rwq on 2019/05/22.
 */
public class TSysDatadictVo extends AbstractVo {
	private String warnLevel; //报警等级
	
	private String plIsvalid; //启禁用

	public String getWarnLevel() {
		return warnLevel;
	}

	public void setWarnLevel(String warnLevel) {
		this.warnLevel = warnLevel;
	}

	public String getPlIsvalid() {
		return plIsvalid;
	}

	public void setPlIsvalid(String plIsvalid) {
		this.plIsvalid = plIsvalid;
	}
	
	
	
}
