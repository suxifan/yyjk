package com.cictec.yyjk.base.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "base_video_param_info")
public class BaseVideoParamInfo {
    /**
     * 车辆视频位置uuid
     */
    @Id
    @Column(name = "video_uuid")
    private Integer videoUuid;

    /**
     * 车辆视频位置名称
     */
    @Column(name = "video_name")
    private String videoName;

    /**
     * 车辆视频位置取值
     */
    @Column(name = "video_value")
    private String videoValue;

    /**
     * 车辆视频位置分组
     */
    @Column(name = "video_group_number")
    private Short videoGroupNumber;

    /**
     * 是否有效，1：有效，0：无效
     */
    @Column(name = "video_isvalid")
    private String videoIsvalid;

    @Column(name = "video_create_time")
    private Date videoCreateTime;

    /**
     * 获取车辆视频位置uuid
     *
     * @return video_uuid - 车辆视频位置uuid
     */
    public Integer getVideoUuid() {
        return videoUuid;
    }

    /**
     * 设置车辆视频位置uuid
     *
     * @param videoUuid 车辆视频位置uuid
     */
    public void setVideoUuid(Integer videoUuid) {
        this.videoUuid = videoUuid;
    }

    /**
     * 获取车辆视频位置名称
     *
     * @return video_name - 车辆视频位置名称
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * 设置车辆视频位置名称
     *
     * @param videoName 车辆视频位置名称
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    /**
     * 获取车辆视频位置取值
     *
     * @return video_value - 车辆视频位置取值
     */
    public String getVideoValue() {
        return videoValue;
    }

    /**
     * 设置车辆视频位置取值
     *
     * @param videoValue 车辆视频位置取值
     */
    public void setVideoValue(String videoValue) {
        this.videoValue = videoValue;
    }

    /**
     * 获取车辆视频位置分组
     *
     * @return video_group_number - 车辆视频位置分组
     */
    public Short getVideoGroupNumber() {
        return videoGroupNumber;
    }

    /**
     * 设置车辆视频位置分组
     *
     * @param videoGroupNumber 车辆视频位置分组
     */
    public void setVideoGroupNumber(Short videoGroupNumber) {
        this.videoGroupNumber = videoGroupNumber;
    }

    /**
     * 获取是否有效，1：有效，0：无效
     *
     * @return video_isvalid - 是否有效，1：有效，0：无效
     */
    public String getVideoIsvalid() {
        return videoIsvalid;
    }

    /**
     * 设置是否有效，1：有效，0：无效
     *
     * @param videoIsvalid 是否有效，1：有效，0：无效
     */
    public void setVideoIsvalid(String videoIsvalid) {
        this.videoIsvalid = videoIsvalid;
    }

    /**
     * @return video_create_time
     */
    public Date getVideoCreateTime() {
        return videoCreateTime;
    }

    /**
     * @param videoCreateTime
     */
    public void setVideoCreateTime(Date videoCreateTime) {
        this.videoCreateTime = videoCreateTime;
    }
}