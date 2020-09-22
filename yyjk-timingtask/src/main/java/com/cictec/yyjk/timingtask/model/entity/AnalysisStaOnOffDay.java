package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "analysis_prf_sta_on_off_day")
public class AnalysisStaOnOffDay {
    @Id
    @Column(name = "sta_on_off_uuid")
    private String staOnOffUuid;

    @Column(name = "sta_uuid")
    private String staUuid;

    @Column(name = "sta_name")
    private String staName;

    @Column(name = "upload_time_date")
    private Date uploadTimeDate;

    @Column(name = "upload_time_hour")
    private Short uploadTimeHour;

    @Column(name = "pfr_get_on_number")
	private Integer pfrGetOnNumber;

    @Column(name = "pfr_get_off_number")
	private Integer pfrGetOffNumber;

    /**
     * @return sta_on_off_uuid
     */
    public String getStaOnOffUuid() {
        return staOnOffUuid;
    }

    /**
     * @param staOnOffUuid
     */
    public void setStaOnOffUuid(String staOnOffUuid) {
        this.staOnOffUuid = staOnOffUuid;
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
    public Short getUploadTimeHour() {
        return uploadTimeHour;
    }

    /**
     * @param uploadTimeHour
     */
    public void setUploadTimeHour(Short uploadTimeHour) {
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