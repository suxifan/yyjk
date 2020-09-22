package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "analysis_prf_fullload_day")
public class AnalysisFullloadDay {
	@Id
    @Column(name = "fullload_uuid")
    private String fullloadUuid;

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

    @Column(name = "upload_time_date")
    private Date uploadTimeDate;

    @Column(name = "upload_time_hour")
    private Integer uploadTimeHour;

    @Column(name = "pfr_get_on_number")
    private Integer pfrGetOnNumber;

    @Column(name = "pfr_get_off_number")
    private Integer pfrGetOffNumber;

    @Column(name = "prf_get_person_count")
    private Integer prfGetPersonCount;

    @Column(name = "bus_load_number")
    private Integer busLoadNumber;

    /**
     * @return fullload_uuid
     */
    public String getFullloadUuid() {
        return fullloadUuid;
    }

    /**
     * @param fullloadUuid
     */
    public void setFullloadUuid(String fullloadUuid) {
        this.fullloadUuid = fullloadUuid;
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
     * @return upload_time_date
     */
    public Date getUploadTimeDate() {
        return uploadTimeDate;
    }

    /**
     * @param uploadTimeDate
     */
    public void setUploadTimeDate(Date uploadTimeDate) {
        this.uploadTimeDate = uploadTimeDate;
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

    /**
     * @return prf_get_person_count
     */
    public Integer getPrfGetPersonCount() {
        return prfGetPersonCount;
    }

    /**
     * @param prfGetPersonCount
     */
    public void setPrfGetPersonCount(Integer prfGetPersonCount) {
        this.prfGetPersonCount = prfGetPersonCount;
    }

    /**
     * @return bus_load_number
     */
    public Integer getBusLoadNumber() {
        return busLoadNumber;
    }

    /**
     * @param busLoadNumber
     */
    public void setBusLoadNumber(Integer busLoadNumber) {
        this.busLoadNumber = busLoadNumber;
    }
}