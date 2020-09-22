package com.cictec.yyjk.timingtask.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "analysis_prf_peak_month")
public class AnalysisPeakMonth {
	@Id
    @Column(name = "peak_uuid")
    private String peakUuid;

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

    @Column(name = "upload_time_month")
    private String uploadTimeMonth;

    @Column(name = "upload_time_week")
    private String uploadTimeWeek;

    @Column(name = "upload_time_hour")
    private Integer uploadTimeHour;

    @Column(name = "pfr_get_on_number")
    private Integer pfrGetOnNumber;

    @Column(name = "pfr_get_off_number")
    private Integer pfrGetOffNumber;

    /**
     * @return peak_uuid
     */
    public String getPeakUuid() {
        return peakUuid;
    }

    /**
     * @param peakUuid
     */
    public void setPeakUuid(String peakUuid) {
        this.peakUuid = peakUuid;
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
     * @return upload_time_week
     */
    public String getUploadTimeWeek() {
        return uploadTimeWeek;
    }

    /**
     * @param uploadTimeWeek
     */
    public void setUploadTimeWeek(String uploadTimeWeek) {
        this.uploadTimeWeek = uploadTimeWeek;
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
     * @return pfr_get_on_number
     */
    public Integer getPfrGetOnNumber() {
        return pfrGetOnNumber;
    }

    /**
     * @param pfrGetOnNumber
     */
    public void setPfrGetOnNumber(Integer pfrGetOnNumber) {
        this.pfrGetOnNumber = pfrGetOnNumber;
    }

    /**
     * @return pfr_get_off_number
     */
    public Integer getPfrGetOffNumber() {
        return pfrGetOffNumber;
    }

    /**
     * @param pfrGetOffNumber
     */
    public void setPfrGetOffNumber(Integer pfrGetOffNumber) {
        this.pfrGetOffNumber = pfrGetOffNumber;
    }
}