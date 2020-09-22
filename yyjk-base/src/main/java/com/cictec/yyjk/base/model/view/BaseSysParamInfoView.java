package com.cictec.yyjk.base.model.view;

import javax.persistence.Column;
import java.util.Date;

public class BaseSysParamInfoView {

    private String sysUuid;

    private String paramName;

    private String paramValue;

    private String paramIsvalid;

    private Date crateTime;

    private String remark;

    private String warnType;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public String getParamIsvalid() {
        return paramIsvalid;
    }

    public void setParamIsvalid(String paramIsvalid) {
        this.paramIsvalid = paramIsvalid;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getSysUuid() {
        return sysUuid;
    }

    public void setSysUuid(String sysUuid) {
        this.sysUuid = sysUuid;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }
}
