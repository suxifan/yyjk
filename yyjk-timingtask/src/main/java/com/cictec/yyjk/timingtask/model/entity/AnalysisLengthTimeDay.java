package com.cictec.yyjk.timingtask.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "analysis_length_time_day")
public class AnalysisLengthTimeDay {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "day_uuid")
    private String dayUuid;

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
	 * 线路站点ID
	 */
    @Column(name = "sta_uuid")
    private String staUuid;

    /**
	 * 站序
	 */
    @Column(name = "sta_seq")
    private String staSeq;

    /**
	 * 线路站点名称
	 */
    @Column(name = "sta_name")
    private String staName;

    /**
	 * 月份
	 */
    @Column(name = "upload_time_day")
    private String uploadTimeDay;

    /**
	 * 小时
	 */
    @Column(name = "upload_time_hour")
    private Integer uploadTimeHour;

    /**
	 * 时长（秒）
	 */
    @Column(name = "sta_length_time")
    private BigDecimal staLengthTime;

	/**
	 * 站间距离(米)
	 */
	@Column(name = "sta_between_distance")
	private BigDecimal staBetweenDistance;

    /**
	 * 获取主键
	 *
	 * @return day_uuid - 主键
	 */
    public String getDayUuid() {
        return dayUuid;
    }

    /**
	 * 设置主键
	 *
	 * @param dayUuid
	 *            主键
	 */
    public void setDayUuid(String dayUuid) {
        this.dayUuid = dayUuid;
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
	 * 获取线路站点ID
	 *
	 * @return sta_uuid - 线路站点ID
	 */
    public String getStaUuid() {
        return staUuid;
    }

    /**
	 * 设置线路站点ID
	 *
	 * @param staUuid
	 *            线路站点ID
	 */
    public void setStaUuid(String staUuid) {
        this.staUuid = staUuid;
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
	 * 获取线路站点名称
	 *
	 * @return sta_name - 线路站点名称
	 */
    public String getStaName() {
        return staName;
    }

    /**
	 * 设置线路站点名称
	 *
	 * @param staName
	 *            线路站点名称
	 */
    public void setStaName(String staName) {
        this.staName = staName;
    }

    /**
	 * 获取月份
	 *
	 * @return upload_time_day - 月份
	 */
    public String getUploadTimeDay() {
        return uploadTimeDay;
    }

    /**
	 * 设置月份
	 *
	 * @param uploadTimeDay
	 *            月份
	 */
    public void setUploadTimeDay(String uploadTimeDay) {
        this.uploadTimeDay = uploadTimeDay;
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
	 * 获取时长（秒）
	 *
	 * @return sta_length_time - 时长（秒）
	 */
    public BigDecimal getStaLengthTime() {
        return staLengthTime;
    }

    /**
	 * 设置时长（秒）
	 *
	 * @param staLengthTime
	 *            时长（秒）
	 */
    public void setStaLengthTime(BigDecimal staLengthTime) {
        this.staLengthTime = staLengthTime;
    }

	public BigDecimal getStaBetweenDistance() {
		return staBetweenDistance;
	}

	public void setStaBetweenDistance(BigDecimal staBetweenDistance) {
		this.staBetweenDistance = staBetweenDistance;
	}

}