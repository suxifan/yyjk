package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "analysis_prf_capacity_volume_day")
public class AnalysisCapacityVolumeDay {
	@Id
    @Column(name = "capacity_uuid")
    private String capacityUuid;

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

    @Column(name = "upload_time_date")
    private Date uploadTimeDate;

    @Column(name = "upload_time_quarter")
    private String uploadTimeQuarter;

    @Column(name = "pfr_get_on_number")
    private Integer pfrGetOnNumber;

    @Column(name = "pfr_get_off_number")
    private Integer pfrGetOffNumber;

    @Column(name = "prf_get_person_count")
    private Integer prfGetPersonCount;

    @Column(name = "bus_load_number")
    private Integer busLoadNumber;

    /**
     * @return capacity_uuid
     */
    public String getCapacityUuid() {
        return capacityUuid;
    }

    /**
     * @param capacityUuid
     */
    public void setCapacityUuid(String capacityUuid) {
        this.capacityUuid = capacityUuid;
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
     * @return upload_time_quarter
     */
    public String getUploadTimeQuarter() {
        return uploadTimeQuarter;
    }

    /**
     * @param uploadTimeQuarter
     */
    public void setUploadTimeQuarter(String uploadTimeQuarter) {
        this.uploadTimeQuarter = uploadTimeQuarter;
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