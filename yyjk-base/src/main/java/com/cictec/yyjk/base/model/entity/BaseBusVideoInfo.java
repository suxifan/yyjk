package com.cictec.yyjk.base.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

@Table(name = "base_bus_video_info")
public class BaseBusVideoInfo {
    @Id
    private String uuid;

    @Column(name = "bus_uuid")
    private String busUuid;

    private String video1;

    private String video2;

    private String video3;

    private String video4;

    private String video5;

    private String video6;

    private String video7;

    private String video8;

    private String video9;

    private String video10;

    private String video11;

    private String video12;

    @Column(name = "create_time")
    private Date createTime;

	@Transient
	private String busPlateNumber;
    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return bus_uuid
     */
    public String getBusUuid() {
        return busUuid;
    }

    /**
     * @param busUuid
     */
    public void setBusUuid(String busUuid) {
        this.busUuid = busUuid;
    }

    /**
     * @return video1
     */
    public String getVideo1() {
        return video1;
    }

    /**
     * @param video1
     */
    public void setVideo1(String video1) {
    	if(StringUtils.isEmpty(video1)){
    		 this.video1 = "通道1";
    	}else{
    		this.video1 = video1;
    	}
    }

    /**
     * @return video2
     */
    public String getVideo2() {
        return video2;
    }

    /**
     * @param video2
     */
    public void setVideo2(String video2) {
		if(StringUtils.isEmpty(video2)){
		    this.video2 = "通道2";
	   	}else{
	   		this.video2 = video2;
	   	}
    }

    /**
     * @return video3
     */
    public String getVideo3() {
        return video3;
    }

    /**
     * @param video3
     */
    public void setVideo3(String video3) {
    	if(StringUtils.isEmpty(video3)){
		    this.video3 = "通道3";
	   	}else{
	   		this.video3 = video3;
	   	}
    }

    /**
     * @return video4
     */
    public String getVideo4() {
        return video4;
    }

    /**
     * @param video4
     */
    public void setVideo4(String video4) {
    	if(StringUtils.isEmpty(video4)){
		    this.video4 = "通道4";
	   	}else{
	   		this.video4 = video4;
	   	}
    }

    /**
     * @return video5
     */
    public String getVideo5() {
        return video5;
    }

    /**
     * @param video5
     */
    public void setVideo5(String video5) {
    	if(StringUtils.isEmpty(video5)){
		    this.video5 = "通道5";
	   	}else{
	   		this.video5 = video5;
	   	}
    }

    /**
     * @return video6
     */
    public String getVideo6() {
        return video6;
    }

    /**
     * @param video6
     */
    public void setVideo6(String video6) {
    	if(StringUtils.isEmpty(video6)){
		    this.video6 = "通道6";
	   	}else{
	   		this.video6 = video6;
	   	}
    }

    /**
     * @return video7
     */
    public String getVideo7() {
        return video7;
    }

    /**
     * @param video7
     */
    public void setVideo7(String video7) {
        this.video7 = video7;
    }

    /**
     * @return video8
     */
    public String getVideo8() {
        return video8;
    }

    /**
     * @param video8
     */
    public void setVideo8(String video8) {
        this.video8 = video8;
    }

    /**
     * @return video9
     */
    public String getVideo9() {
        return video9;
    }

    /**
     * @param video9
     */
    public void setVideo9(String video9) {
        this.video9 = video9;
    }

    /**
     * @return video10
     */
    public String getVideo10() {
        return video10;
    }

    /**
     * @param video10
     */
    public void setVideo10(String video10) {
        this.video10 = video10;
    }

    /**
     * @return video11
     */
    public String getVideo11() {
        return video11;
    }

    /**
     * @param video11
     */
    public void setVideo11(String video11) {
        this.video11 = video11;
    }

    /**
     * @return video12
     */
    public String getVideo12() {
        return video12;
    }

    /**
     * @param video12
     */
    public void setVideo12(String video12) {
        this.video12 = video12;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

}