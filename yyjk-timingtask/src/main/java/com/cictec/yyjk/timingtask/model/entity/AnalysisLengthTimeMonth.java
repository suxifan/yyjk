package com.cictec.yyjk.timingtask.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "analysis_length_time_month")
public class AnalysisLengthTimeMonth {
	@Id
    @Column(name = "length_uuid")
    private String lengthUuid;

    @Column(name = "org_uuid")
    private String orgUuid;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "line_uuid")
    private String lineUuid;

    @Column(name = "line_name")
    private String lineName;

    @Column(name = "line_type")
    private String lineType;

    @Column(name = "sta_uuid")
    private String staUuid;

    @Column(name = "sta_seq")
    private String staSeq;

    @Column(name = "sta_name")
    private String staName;

    @Column(name = "upload_time_month")
    private String uploadTimeMonth;

    @Column(name = "upload_time_hour")
    private Integer uploadTimeHour;

    @Column(name = "sta_length_time")
    private BigDecimal staLengthTime;

    /**
     * @return length_uuid
     */
    public String getLengthUuid() {
        return lengthUuid;
    }

    /**
     * @param lengthUuid
     */
    public void setLengthUuid(String lengthUuid) {
        this.lengthUuid = lengthUuid;
    }

    /**
     * @return org_uuid
     */
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
     * @param orgUuid
     */
    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    /**
     * @return org_name
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return line_uuid
     */
    public String getLineUuid() {
        return lineUuid;
    }

    /**
     * @param lineUuid
     */
    public void setLineUuid(String lineUuid) {
        this.lineUuid = lineUuid;
    }

    /**
     * @return line_name
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * @param lineName
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
     * @return line_type
     */
    public String getLineType() {
        return lineType;
    }

    /**
     * @param lineType
     */
    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    /**
     * @return sta_uuid
     */
    public String getStaUuid() {
        return staUuid;
    }

    /**
     * @param staUuid
     */
    public void setStaUuid(String staUuid) {
        this.staUuid = staUuid;
    }

    /**
     * @return sta_seq
     */
    public String getStaSeq() {
        return staSeq;
    }

    /**
     * @param staSeq
     */
    public void setStaSeq(String staSeq) {
        this.staSeq = staSeq;
    }

    /**
     * @return sta_name
     */
    public String getStaName() {
        return staName;
    }

    /**
     * @param staName
     */
    public void setStaName(String staName) {
        this.staName = staName;
    }

    /**
     * @return upload_time_month
     */
    public String getUploadTimeMonth() {
        return uploadTimeMonth;
    }

    /**
     * @param uploadTimeMonth
     */
    public void setUploadTimeMonth(String uploadTimeMonth) {
        this.uploadTimeMonth = uploadTimeMonth;
    }

    /**
     * @return upload_time_hour
     */
    public Integer getUploadTimeHour() {
        return uploadTimeHour;
    }

    /**
     * @param uploadTimeHour
     */
    public void setUploadTimeHour(Integer uploadTimeHour) {
        this.uploadTimeHour = uploadTimeHour;
    }

    /**
     * @return sta_length_time
     */
    public BigDecimal getStaLengthTime() {
        return staLengthTime;
    }

    /**
     * @param staLengthTime
     */
    public void setStaLengthTime(BigDecimal staLengthTime) {
        this.staLengthTime = staLengthTime;
    }
}