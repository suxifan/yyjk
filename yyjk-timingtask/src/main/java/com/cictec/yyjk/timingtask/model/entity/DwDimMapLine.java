package com.cictec.yyjk.timingtask.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dw_dim_map_line")
public class DwDimMapLine {
    @Id
    @Column(name = "ml_uuid")
    private String mlUuid;

    @Column(name = "ml_line_uuid")
    private String mlLineUuid;

    @Column(name = "ml_sta_uuid")
    private String mlStaUuid;

    @Column(name = "ml_lng")
    private String mlLng;

    @Column(name = "ml_lat")
    private String mlLat;

    @Column(name = "ml_sequence")
    private Integer mlSequence;

    @Column(name = "ml_line_type")
    private String mlLineType;

    @Column(name = "ml_distance")
    private Double mlDistance;

    @Column(name = "ml_whichstop")
    private String mlWhichstop;

	public DwDimMapLine() {
		super();
	}

	public DwDimMapLine(String mlUuid, String mlLineUuid, String mlStaUuid, String mlLng, String mlLat,
			Integer mlSequence, String mlLineType, Double mlDistance, String mlWhichstop) {
		super();
		this.mlUuid = mlUuid;
		this.mlLineUuid = mlLineUuid;
		this.mlStaUuid = mlStaUuid;
		this.mlLng = mlLng;
		this.mlLat = mlLat;
		this.mlSequence = mlSequence;
		this.mlLineType = mlLineType;
		this.mlDistance = mlDistance;
		this.mlWhichstop = mlWhichstop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mlDistance == null) ? 0 : mlDistance.hashCode());
		result = prime * result + ((mlLat == null) ? 0 : mlLat.hashCode());
		result = prime * result + ((mlLineType == null) ? 0 : mlLineType.hashCode());
		result = prime * result + ((mlLineUuid == null) ? 0 : mlLineUuid.hashCode());
		result = prime * result + ((mlLng == null) ? 0 : mlLng.hashCode());
		result = prime * result + ((mlSequence == null) ? 0 : mlSequence.hashCode());
		result = prime * result + ((mlStaUuid == null) ? 0 : mlStaUuid.hashCode());
		result = prime * result + ((mlUuid == null) ? 0 : mlUuid.hashCode());
		result = prime * result + ((mlWhichstop == null) ? 0 : mlWhichstop.hashCode());
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
		DwDimMapLine other = (DwDimMapLine) obj;
		if (mlDistance == null) {
			if (other.mlDistance != null)
				return false;
		} else if (!mlDistance.equals(other.mlDistance))
			return false;
		if (mlLat == null) {
			if (other.mlLat != null)
				return false;
		} else if (!mlLat.equals(other.mlLat))
			return false;
		if (mlLineType == null) {
			if (other.mlLineType != null)
				return false;
		} else if (!mlLineType.equals(other.mlLineType))
			return false;
		if (mlLineUuid == null) {
			if (other.mlLineUuid != null)
				return false;
		} else if (!mlLineUuid.equals(other.mlLineUuid))
			return false;
		if (mlLng == null) {
			if (other.mlLng != null)
				return false;
		} else if (!mlLng.equals(other.mlLng))
			return false;
		if (mlSequence == null) {
			if (other.mlSequence != null)
				return false;
		} else if (!mlSequence.equals(other.mlSequence))
			return false;
		if (mlStaUuid == null) {
			if (other.mlStaUuid != null)
				return false;
		} else if (!mlStaUuid.equals(other.mlStaUuid))
			return false;
		if (mlUuid == null) {
			if (other.mlUuid != null)
				return false;
		} else if (!mlUuid.equals(other.mlUuid))
			return false;
		if (mlWhichstop == null) {
			if (other.mlWhichstop != null)
				return false;
		} else if (!mlWhichstop.equals(other.mlWhichstop))
			return false;
		return true;
	}

	/**
	 * @return ml_uuid
	 */
    public String getMlUuid() {
        return mlUuid;
    }

    /**
     * @param mlUuid
     */
    public void setMlUuid(String mlUuid) {
        this.mlUuid = mlUuid;
    }

    /**
     * @return ml_line_uuid
     */
    public String getMlLineUuid() {
        return mlLineUuid;
    }

    /**
     * @param mlLineUuid
     */
    public void setMlLineUuid(String mlLineUuid) {
        this.mlLineUuid = mlLineUuid;
    }

    /**
     * @return ml_sta_uuid
     */
    public String getMlStaUuid() {
        return mlStaUuid;
    }

    /**
     * @param mlStaUuid
     */
    public void setMlStaUuid(String mlStaUuid) {
        this.mlStaUuid = mlStaUuid;
    }

    /**
     * @return ml_lng
     */
    public String getMlLng() {
        return mlLng;
    }

    /**
     * @param mlLng
     */
    public void setMlLng(String mlLng) {
        this.mlLng = mlLng;
    }

    /**
     * @return ml_lat
     */
    public String getMlLat() {
        return mlLat;
    }

    /**
     * @param mlLat
     */
    public void setMlLat(String mlLat) {
        this.mlLat = mlLat;
    }

    /**
     * @return ml_sequence
     */
    public Integer getMlSequence() {
        return mlSequence;
    }

    /**
     * @param mlSequence
     */
    public void setMlSequence(Integer mlSequence) {
        this.mlSequence = mlSequence;
    }

    /**
     * @return ml_line_type
     */
    public String getMlLineType() {
        return mlLineType;
    }

    /**
     * @param mlLineType
     */
    public void setMlLineType(String mlLineType) {
        this.mlLineType = mlLineType;
    }

    /**
     * @return ml_distance
     */
    public Double getMlDistance() {
        return mlDistance;
    }

    /**
     * @param mlDistance
     */
    public void setMlDistance(Double mlDistance) {
        this.mlDistance = mlDistance;
    }

    /**
     * @return ml_whichstop
     */
    public String getMlWhichstop() {
        return mlWhichstop;
    }

    /**
     * @param mlWhichstop
     */
    public void setMlWhichstop(String mlWhichstop) {
        this.mlWhichstop = mlWhichstop;
    }
}