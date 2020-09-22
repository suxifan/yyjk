package com.cictec.yyjk.timingtask.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "analysis_prf_section_month")
public class AnalysisSectionMonth {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "section_uuid")
    private String sectionUuid;

    /**
	 * 机构ID
	 */
    @Column(name = "org_uuid")
    private String orgUuid;

    /**
	 * 机构名称
	 */
    @Column(name = "org_name")
    private String orgName;

    /**
	 * 线路id
	 */
    @Column(name = "line_uuid")
    private String lineUuid;

    /**
	 * 线路名称
	 */
    @Column(name = "line_name")
    private String lineName;

    /**
	 * 线路类型
	 */
    @Column(name = "line_type")
    private String lineType;

    /**
	 * 站点ID
	 */
    @Column(name = "line_sta_uuid")
    private String lineStaUuid;

    /**
	 * 站序
	 */
    @Column(name = "sta_seq")
    private String staSeq;

    /**
	 * 站点名称
	 */
    @Column(name = "sta_name")
    private String staName;

    /**
	 * 月份
	 */
    @Column(name = "upload_time_month")
    private String uploadTimeMonth;

    /**
	 * 小时
	 */
    @Column(name = "upload_time_hour")
    private Integer uploadTimeHour;

    /**
	 * 平均上车人数
	 */
    @Column(name = "pfr_get_on_number")
    private Integer pfrGetOnNumber;

    /**
	 * 平均下车人数
	 */
    @Column(name = "pfr_get_off_number")
    private Integer pfrGetOffNumber;

    /**
	 * 车内人数
	 */
    @Column(name = "prf_get_person_count")
    private Integer prfGetPersonCount;

    /**
	 * 获取主键
	 *
	 * @return section_uuid - 主键
	 */
    public String getSectionUuid() {
        return sectionUuid;
    }

    /**
	 * 设置主键
	 *
	 * @param sectionUuid
	 *            主键
	 */
    public void setSectionUuid(String sectionUuid) {
        this.sectionUuid = sectionUuid;
    }

    /**
	 * 获取机构ID
	 *
	 * @return org_uuid - 机构ID
	 */
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
	 * 设置机构ID
	 *
	 * @param orgUuid
	 *            机构ID
	 */
    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    /**
	 * 获取机构名称
	 *
	 * @return org_name - 机构名称
	 */
    public String getOrgName() {
        return orgName;
    }

    /**
	 * 设置机构名称
	 *
	 * @param orgName
	 *            机构名称
	 */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
	 * 获取线路id
	 *
	 * @return line_uuid - 线路id
	 */
    public String getLineUuid() {
        return lineUuid;
    }

    /**
	 * 设置线路id
	 *
	 * @param lineUuid
	 *            线路id
	 */
    public void setLineUuid(String lineUuid) {
        this.lineUuid = lineUuid;
    }

    /**
	 * 获取线路名称
	 *
	 * @return line_name - 线路名称
	 */
    public String getLineName() {
        return lineName;
    }

    /**
	 * 设置线路名称
	 *
	 * @param lineName
	 *            线路名称
	 */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**
	 * 获取线路类型
	 *
	 * @return line_type - 线路类型
	 */
    public String getLineType() {
        return lineType;
    }

    /**
	 * 设置线路类型
	 *
	 * @param lineType
	 *            线路类型
	 */
    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    /**
	 * 获取站点ID
	 *
	 * @return line_sta_uuid - 站点ID
	 */
    public String getLineStaUuid() {
        return lineStaUuid;
    }

    /**
	 * 设置站点ID
	 *
	 * @param lineStaUuid
	 *            站点ID
	 */
    public void setLineStaUuid(String lineStaUuid) {
        this.lineStaUuid = lineStaUuid;
    }

    /**
	 * 获取站序
	 *
	 * @return sta_seq - 站序
	 */
    public String getStaSeq() {
        return staSeq;
    }

    /**
	 * 设置站序
	 *
	 * @param staSeq
	 *            站序
	 */
    public void setStaSeq(String staSeq) {
        this.staSeq = staSeq;
    }

    /**
	 * 获取站点名称
	 *
	 * @return sta_name - 站点名称
	 */
    public String getStaName() {
        return staName;
    }

    /**
	 * 设置站点名称
	 *
	 * @param staName
	 *            站点名称
	 */
    public void setStaName(String staName) {
        this.staName = staName;
    }

    /**
	 * 获取月份
	 *
	 * @return upload_time_month - 月份
	 */
    public String getUploadTimeMonth() {
        return uploadTimeMonth;
    }

    /**
	 * 设置月份
	 *
	 * @param uploadTimeMonth
	 *            月份
	 */
    public void setUploadTimeMonth(String uploadTimeMonth) {
        this.uploadTimeMonth = uploadTimeMonth;
    }

    /**
	 * 获取小时
	 *
	 * @return upload_time_hour - 小时
	 */
    public Integer getUploadTimeHour() {
        return uploadTimeHour;
    }

    /**
	 * 设置小时
	 *
	 * @param uploadTimeHour
	 *            小时
	 */
    public void setUploadTimeHour(Integer uploadTimeHour) {
        this.uploadTimeHour = uploadTimeHour;
    }

    /**
	 * 获取平均上车人数
	 *
	 * @return pfr_get_on_number - 平均上车人数
	 */
    public Integer getPfrGetOnNumber() {
        return pfrGetOnNumber;
    }

    /**
	 * 设置平均上车人数
	 *
	 * @param pfrGetOnNumber
	 *            平均上车人数
	 */
    public void setPfrGetOnNumber(Integer pfrGetOnNumber) {
        this.pfrGetOnNumber = pfrGetOnNumber;
    }

    /**
	 * 获取平均下车人数
	 *
	 * @return pfr_get_off_number - 平均下车人数
	 */
    public Integer getPfrGetOffNumber() {
        return pfrGetOffNumber;
    }

    /**
	 * 设置平均下车人数
	 *
	 * @param pfrGetOffNumber
	 *            平均下车人数
	 */
    public void setPfrGetOffNumber(Integer pfrGetOffNumber) {
        this.pfrGetOffNumber = pfrGetOffNumber;
    }

    /**
	 * 获取车内人数
	 *
	 * @return prf_get_person_count - 车内人数
	 */
    public Integer getPrfGetPersonCount() {
        return prfGetPersonCount;
    }

    /**
	 * 设置车内人数
	 *
	 * @param prfGetPersonCount
	 *            车内人数
	 */
    public void setPrfGetPersonCount(Integer prfGetPersonCount) {
        this.prfGetPersonCount = prfGetPersonCount;
    }
}