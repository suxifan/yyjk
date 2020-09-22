package com.cictec.yyjk.timingtask.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_bus_line")
public class DwDimBusLine {
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

	public DwDimBusLine() {
		super();
	}

	public DwDimBusLine(String lineUuid, String lineOrgUuid, String lineName, String lineIsvalid, Integer lineIsloop,
			Integer lineBfType, String lineDropFlag, String lineUpFirstDate, String lineUpLastDate, Date lineCreateTime,
			String lineUpPlan, String lineDownPlan, Short lineUpStationCount, Short lineDownStationCount,
			String lineType, String lineDownFirstDate, String lineDownLastDate, String parLineUuid) {
		super();
		this.lineUuid = lineUuid;
		this.lineOrgUuid = lineOrgUuid;
		this.lineName = lineName;
		this.lineIsvalid = lineIsvalid;
		this.lineIsloop = lineIsloop;
		this.lineBfType = lineBfType;
		this.lineDropFlag = lineDropFlag;
		this.lineUpFirstDate = lineUpFirstDate;
		this.lineUpLastDate = lineUpLastDate;
		this.lineCreateTime = lineCreateTime;
		this.lineUpPlan = lineUpPlan;
		this.lineDownPlan = lineDownPlan;
		this.lineUpStationCount = lineUpStationCount;
		this.lineDownStationCount = lineDownStationCount;
		this.lineType = lineType;
		this.lineDownFirstDate = lineDownFirstDate;
		this.lineDownLastDate = lineDownLastDate;
		this.parLineUuid = parLineUuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineBfType == null) ? 0 : lineBfType.hashCode());
		result = prime * result + ((lineCreateTime == null) ? 0 : lineCreateTime.hashCode());
		result = prime * result + ((lineDownFirstDate == null) ? 0 : lineDownFirstDate.hashCode());
		result = prime * result + ((lineDownLastDate == null) ? 0 : lineDownLastDate.hashCode());
		result = prime * result + ((lineDownPlan == null) ? 0 : lineDownPlan.hashCode());
		result = prime * result + ((lineDownStationCount == null) ? 0 : lineDownStationCount.hashCode());
		result = prime * result + ((lineDropFlag == null) ? 0 : lineDropFlag.hashCode());
		result = prime * result + ((lineIsloop == null) ? 0 : lineIsloop.hashCode());
		result = prime * result + ((lineIsvalid == null) ? 0 : lineIsvalid.hashCode());
		result = prime * result + ((lineName == null) ? 0 : lineName.hashCode());
		result = prime * result + ((lineOrgUuid == null) ? 0 : lineOrgUuid.hashCode());
		result = prime * result + ((lineType == null) ? 0 : lineType.hashCode());
		result = prime * result + ((lineUpFirstDate == null) ? 0 : lineUpFirstDate.hashCode());
		result = prime * result + ((lineUpLastDate == null) ? 0 : lineUpLastDate.hashCode());
		result = prime * result + ((lineUpPlan == null) ? 0 : lineUpPlan.hashCode());
		result = prime * result + ((lineUpStationCount == null) ? 0 : lineUpStationCount.hashCode());
		result = prime * result + ((lineUuid == null) ? 0 : lineUuid.hashCode());
		result = prime * result + ((parLineUuid == null) ? 0 : parLineUuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DwDimBusLine other = (DwDimBusLine) obj;
		if (lineBfType == null) {
			if (other.lineBfType != null)
				return false;
		} else if (!lineBfType.equals(other.lineBfType))
			return false;
		if (lineCreateTime == null) {
			if (other.lineCreateTime != null)
				return false;
		} else if (!lineCreateTime.equals(other.lineCreateTime))
			return false;
		if (lineDownFirstDate == null) {
			if (other.lineDownFirstDate != null)
				return false;
		} else if (!lineDownFirstDate.equals(other.lineDownFirstDate))
			return false;
		if (lineDownLastDate == null) {
			if (other.lineDownLastDate != null)
				return false;
		} else if (!lineDownLastDate.equals(other.lineDownLastDate))
			return false;
		if (lineDownPlan == null) {
			if (other.lineDownPlan != null)
				return false;
		} else if (!lineDownPlan.equals(other.lineDownPlan))
			return false;
		if (lineDownStationCount == null) {
			if (other.lineDownStationCount != null)
				return false;
		} else if (!lineDownStationCount.equals(other.lineDownStationCount))
			return false;
		if (lineDropFlag == null) {
			if (other.lineDropFlag != null)
				return false;
		} else if (!lineDropFlag.equals(other.lineDropFlag))
			return false;
		if (lineIsloop == null) {
			if (other.lineIsloop != null)
				return false;
		} else if (!lineIsloop.equals(other.lineIsloop))
			return false;
		if (lineIsvalid == null) {
			if (other.lineIsvalid != null)
				return false;
		} else if (!lineIsvalid.equals(other.lineIsvalid))
			return false;
		if (lineName == null) {
			if (other.lineName != null)
				return false;
		} else if (!lineName.equals(other.lineName))
			return false;
		if (lineOrgUuid == null) {
			if (other.lineOrgUuid != null)
				return false;
		} else if (!lineOrgUuid.equals(other.lineOrgUuid))
			return false;
		if (lineType == null) {
			if (other.lineType != null)
				return false;
		} else if (!lineType.equals(other.lineType))
			return false;
		if (lineUpFirstDate == null) {
			if (other.lineUpFirstDate != null)
				return false;
		} else if (!lineUpFirstDate.equals(other.lineUpFirstDate))
			return false;
		if (lineUpLastDate == null) {
			if (other.lineUpLastDate != null)
				return false;
		} else if (!lineUpLastDate.equals(other.lineUpLastDate))
			return false;
		if (lineUpPlan == null) {
			if (other.lineUpPlan != null)
				return false;
		} else if (!lineUpPlan.equals(other.lineUpPlan))
			return false;
		if (lineUpStationCount == null) {
			if (other.lineUpStationCount != null)
				return false;
		} else if (!lineUpStationCount.equals(other.lineUpStationCount))
			return false;
		if (lineUuid == null) {
			if (other.lineUuid != null)
				return false;
		} else if (!lineUuid.equals(other.lineUuid))
			return false;
		if (parLineUuid == null) {
			if (other.parLineUuid != null)
				return false;
		} else if (!parLineUuid.equals(other.parLineUuid))
			return false;
		return true;
	}

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