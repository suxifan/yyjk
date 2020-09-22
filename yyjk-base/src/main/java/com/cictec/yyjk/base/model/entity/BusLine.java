package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_bus_line")
public class BusLine {
    /**
	 * 主键
	 */
    @Id
    @Column(name = "line_uuid")
    private String lineUuid;

    /**
	 * 所属机构
	 */
    @Column(name = "line_org_uuid")
    private String lineOrgUuid;

    /**
	 * 线路名称
	 */
    @Column(name = "line_name")
    private String lineName;

    /**
	 * 删除标记 1：启用 0：禁用
	 */
    @Column(name = "line_isvalid")
    private String lineIsvalid;

    /**
	 * 是否环线车；0：否；1：是
	 */
    @Column(name = "line_isloop")
    private Integer lineIsloop;

    /**
	 * 发车类型（0单向 ，1双向，2环线）
	 */
    @Column(name = "line_bf_type")
    private Integer lineBfType;

    /**
	 * 删除标示 0：否；1：是
	 */
    @Column(name = "line_drop_flag")
	private String lineDropFlag;

    /**
	 * 上行首班时间
	 */
	@Column(name = "line_up_first_date")
	private String lineUpFirstDate;

    /**
	 * 上行末班时间
	 */
	@Column(name = "line_up_last_date")
	private String lineUpLastDate;

    /**
	 * 修改时间
	 */
    @Column(name = "line_create_time")
    private Date lineCreateTime;

    /**
	 * 上行计划
	 */
    @Column(name = "line_up_plan")
    private String lineUpPlan;

    /**
	 * 下行计划
	 */
    @Column(name = "line_down_plan")
    private String lineDownPlan;

    /**
	 * 线路上行站点的数量，默认为0
	 */
    @Column(name = "line_up_station_count")
    private Short lineUpStationCount;

    /**
	 * 线路下行站点的数量，默认为0
	 */
    @Column(name = "line_down_station_count")
    private Short lineDownStationCount;

    /**
	 * 线路类型;0:一般1包车3支线
	 */
    @Column(name = "line_type")
    private String lineType;

    /**
	 * 下行首班时间
	 */
	@Column(name = "line_down_first_date")
	private String lineDownFirstDate;

    /**
	 * 下行末班时间
	 */
	@Column(name = "line_down_last_date")
	private String lineDownLastDate;

	@Column(name = "par_line_uuid")
	private String parLineUuid;

	/**
	 * 获取主键
	 *
	 * @return line_uuid - 主键
	 */
    public String getLineUuid() {
        return lineUuid;
    }

    /**
	 * 设置主键
	 *
	 * @param lineUuid
	 *            主键
	 */
    public void setLineUuid(String lineUuid) {
        this.lineUuid = lineUuid;
    }

    /**
	 * 获取所属机构
	 *
	 * @return line_org_uuid - 所属机构
	 */
    public String getLineOrgUuid() {
        return lineOrgUuid;
    }

    /**
	 * 设置所属机构
	 *
	 * @param lineOrgUuid
	 *            所属机构
	 */
    public void setLineOrgUuid(String lineOrgUuid) {
        this.lineOrgUuid = lineOrgUuid;
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
	 * 获取删除标记 1：启用 0：禁用
	 *
	 * @return line_isvalid - 删除标记 1：启用 0：禁用
	 */
    public String getLineIsvalid() {
        return lineIsvalid;
    }

    /**
	 * 设置删除标记 1：启用 0：禁用
	 *
	 * @param lineIsvalid
	 *            删除标记 1：启用 0：禁用
	 */
    public void setLineIsvalid(String lineIsvalid) {
        this.lineIsvalid = lineIsvalid;
    }

    /**
	 * 获取是否环线车；0：否；1：是
	 *
	 * @return line_isloop - 是否环线车；0：否；1：是
	 */
    public Integer getLineIsloop() {
        return lineIsloop;
    }

    /**
	 * 设置是否环线车；0：否；1：是
	 *
	 * @param lineIsloop
	 *            是否环线车；0：否；1：是
	 */
    public void setLineIsloop(Integer lineIsloop) {
        this.lineIsloop = lineIsloop;
    }

    /**
	 * 获取发车类型（0单向 ，1双向，2环线）
	 *
	 * @return line_bf_type - 发车类型（0单向 ，1双向，2环线）
	 */
    public Integer getLineBfType() {
        return lineBfType;
    }

    /**
	 * 设置发车类型（0单向 ，1双向，2环线）
	 *
	 * @param lineBfType
	 *            发车类型（0单向 ，1双向，2环线）
	 */
    public void setLineBfType(Integer lineBfType) {
        this.lineBfType = lineBfType;
    }

    /**
	 * 获取删除标示 0：否；1：是
	 *
	 * @return line_drop_flag - 删除标示 0：否；1：是
	 */
	public String getLineDropFlag() {
        return lineDropFlag;
    }

    /**
	 * 设置删除标示 0：否；1：是
	 *
	 * @param lineDropFlag
	 *            删除标示 0：否；1：是
	 */
	public void setLineDropFlag(String lineDropFlag) {
        this.lineDropFlag = lineDropFlag;
    }

    /**
	 * 获取上行首班时间
	 *
	 * @return line_up_first_date - 上行首班时间
	 */
	public String getLineUpFirstDate() {
		return lineUpFirstDate;
    }

    /**
	 * 设置上行首班时间
	 *
	 * @param lineUpFirstDate
	 *            上行首班时间
	 */
	public void setLineUpFirstDate(String lineUpFirstDate) {
		this.lineUpFirstDate = lineUpFirstDate;
    }

    /**
	 * 获取上行末班时间
	 *
	 * @return line_up_last_date - 上行末班时间
	 */
	public String getLineUpLastDate() {
		return lineUpLastDate;
    }

    /**
	 * 设置上行末班时间
	 *
	 * @param lineUpLastDate
	 *            上行末班时间
	 */
	public void setLineUpLastDate(String lineUpLastDate) {
		this.lineUpLastDate = lineUpLastDate;
    }

    /**
	 * 获取修改时间
	 *
	 * @return line_create_time - 修改时间
	 */
    public Date getLineCreateTime() {
        return lineCreateTime;
    }

    /**
	 * 设置修改时间
	 *
	 * @param lineCreateTime
	 *            修改时间
	 */
    public void setLineCreateTime(Date lineCreateTime) {
        this.lineCreateTime = lineCreateTime;
    }

    /**
	 * 获取上行计划
	 *
	 * @return line_up_plan - 上行计划
	 */
    public String getLineUpPlan() {
        return lineUpPlan;
    }

    /**
	 * 设置上行计划
	 *
	 * @param lineUpPlan
	 *            上行计划
	 */
    public void setLineUpPlan(String lineUpPlan) {
        this.lineUpPlan = lineUpPlan;
    }

    /**
	 * 获取下行计划
	 *
	 * @return line_down_plan - 下行计划
	 */
    public String getLineDownPlan() {
        return lineDownPlan;
    }

    /**
	 * 设置下行计划
	 *
	 * @param lineDownPlan
	 *            下行计划
	 */
    public void setLineDownPlan(String lineDownPlan) {
        this.lineDownPlan = lineDownPlan;
    }

    /**
	 * 获取线路上行站点的数量，默认为0
	 *
	 * @return line_up_station_count - 线路上行站点的数量，默认为0
	 */
    public Short getLineUpStationCount() {
        return lineUpStationCount;
    }

    /**
	 * 设置线路上行站点的数量，默认为0
	 *
	 * @param lineUpStationCount
	 *            线路上行站点的数量，默认为0
	 */
    public void setLineUpStationCount(Short lineUpStationCount) {
        this.lineUpStationCount = lineUpStationCount;
    }

    /**
	 * 获取线路下行站点的数量，默认为0
	 *
	 * @return line_down_station_count - 线路下行站点的数量，默认为0
	 */
    public Short getLineDownStationCount() {
        return lineDownStationCount;
    }

    /**
	 * 设置线路下行站点的数量，默认为0
	 *
	 * @param lineDownStationCount
	 *            线路下行站点的数量，默认为0
	 */
    public void setLineDownStationCount(Short lineDownStationCount) {
        this.lineDownStationCount = lineDownStationCount;
    }

    /**
	 * 获取线路类型;0:一般1包车3支线
	 *
	 * @return line_type - 线路类型;0:一般1包车3支线
	 */
    public String getLineType() {
        return lineType;
    }

    /**
	 * 设置线路类型;0:一般1包车3支线
	 *
	 * @param lineType
	 *            线路类型;0:一般1包车3支线
	 */
    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    /**
	 * 获取下行首班时间
	 *
	 * @return line_down_first_date - 下行首班时间
	 */
	public String getLineDownFirstDate() {
		return lineDownFirstDate;
    }

    /**
	 * 设置下行首班时间
	 *
	 * @param lineDownFirstDate
	 *            下行首班时间
	 */
	public void setLineDownFirstDate(String lineDownFirstDate) {
		this.lineDownFirstDate = lineDownFirstDate;
    }

    /**
	 * 获取下行末班时间
	 *
	 * @return line_down_last_date - 下行末班时间
	 */
	public String getLineDownLastDate() {
		return lineDownLastDate;
    }

    /**
	 * 设置下行末班时间
	 *
	 * @param lineDownLastDate
	 *            下行末班时间
	 */
	public void setLineDownLastDate(String lineDownLastDate) {
		this.lineDownLastDate = lineDownLastDate;
    }

	public String getParLineUuid() {
		return parLineUuid;
	}

	public void setParLineUuid(String parLineUuid) {
		this.parLineUuid = parLineUuid;
	}

}