package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "analysis_passenger_month_trend")
public class AnalysisPassengerFlowMonthTrend {
    @Id
    @Column(name = "trend_uuid")
    private String trendUuid;

    @Column(name = "org_uuid")
    private String orgUuid;

    @Column(name = "upload_time_month")
    private String uploadTimeMonth;

    @Column(name = "upload_time_date")
    private Date uploadTimeDate;

    @Column(name = "person_count")
    private Integer personCount;

    /**
     * @return trend_uuid
     */
    public String getTrendUuid() {
        return trendUuid;
    }

    /**
     * @param trendUuid
     */
    public void setTrendUuid(String trendUuid) {
        this.trendUuid = trendUuid;
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
     * @return person_count
     */
    public Integer getPersonCount() {
        return personCount;
    }

    /**
     * @param personCount
     */
    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }
}