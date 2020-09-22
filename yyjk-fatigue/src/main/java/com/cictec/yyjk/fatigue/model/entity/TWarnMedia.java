package com.cictec.yyjk.fatigue.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "temp_pl_t_warn_media")
public class TWarnMedia {
    @Id
    @Column(name = "media_uuid")
    private String mediaUuid;

    @Column(name = "warn_uuid")
    private String warnUuid;

    @Column(name = "media_name")
    private String mediaName;

    @Column(name = "media_url")
    private String mediaUrl;

    @Column(name = "media_type")
    private Integer mediaType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "download_url")
    private String downloadUrl;

    @Column(name = "download_time")
    private Date downloadTime;

    @Column(name = "download_type")
    private Integer downloadType;

    @Column(name = "media_encoding")
    private String mediaEncoding;

    @Column(name = "hex_media_id")
    private String hexMediaId;

    @Column(name = "hex_localtion_buf")
    private String hexLocaltionBuf;

    @Column(name = "save_type")
    private Short saveType;

    @Column(name = "save_path")
    private String savePath;

    private String index;

	/**
	 * 告警日期
	 */
	@Column(name = "warn_date")
	private Date warnDate;

	public TWarnMedia() {
		super();
	}

	public TWarnMedia(String mediaUuid, String warnUuid, Date createTime, Date warnDate) {
		super();
		this.mediaUuid = mediaUuid;
		this.warnUuid = warnUuid;
		this.createTime = createTime;
		this.warnDate = warnDate;
	}

	/**
	 * @return media_uuid
	 */
    public String getMediaUuid() {
        return mediaUuid;
    }

    /**
     * @param mediaUuid
     */
    public void setMediaUuid(String mediaUuid) {
        this.mediaUuid = mediaUuid;
    }

    /**
     * @return warn_uuid
     */
    public String getWarnUuid() {
        return warnUuid;
    }

    /**
     * @param warnUuid
     */
    public void setWarnUuid(String warnUuid) {
        this.warnUuid = warnUuid;
    }

    /**
     * @return media_name
     */
    public String getMediaName() {
        return mediaName;
    }

    /**
     * @param mediaName
     */
    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    /**
     * @return media_url
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * @param mediaUrl
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    /**
     * @return media_type
     */
    public Integer getMediaType() {
        return mediaType;
    }

    /**
     * @param mediaType
     */
    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
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

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return download_url
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * @param downloadUrl
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * @return download_time
     */
    public Date getDownloadTime() {
        return downloadTime;
    }

    /**
     * @param downloadTime
     */
    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }

    /**
     * @return download_type
     */
    public Integer getDownloadType() {
        return downloadType;
    }

    /**
     * @param downloadType
     */
    public void setDownloadType(Integer downloadType) {
        this.downloadType = downloadType;
    }

    /**
     * @return media_encoding
     */
    public String getMediaEncoding() {
        return mediaEncoding;
    }

    /**
     * @param mediaEncoding
     */
    public void setMediaEncoding(String mediaEncoding) {
        this.mediaEncoding = mediaEncoding;
    }

    /**
     * @return hex_media_id
     */
    public String getHexMediaId() {
        return hexMediaId;
    }

    /**
     * @param hexMediaId
     */
    public void setHexMediaId(String hexMediaId) {
        this.hexMediaId = hexMediaId;
    }

    /**
     * @return hex_localtion_buf
     */
    public String getHexLocaltionBuf() {
        return hexLocaltionBuf;
    }

    /**
     * @param hexLocaltionBuf
     */
    public void setHexLocaltionBuf(String hexLocaltionBuf) {
        this.hexLocaltionBuf = hexLocaltionBuf;
    }

    /**
     * @return save_type
     */
    public Short getSaveType() {
        return saveType;
    }

    /**
     * @param saveType
     */
    public void setSaveType(Short saveType) {
        this.saveType = saveType;
    }

    /**
     * @return save_path
     */
    public String getSavePath() {
        return savePath;
    }

    /**
     * @param savePath
     */
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    /**
     * @return index
     */
    public String getIndex() {
        return index;
    }

    /**
     * @param index
     */
    public void setIndex(String index) {
        this.index = index;
    }

	public Date getWarnDate() {
		return warnDate;
	}

	public void setWarnDate(Date warnDate) {
		this.warnDate = warnDate;
	}

}