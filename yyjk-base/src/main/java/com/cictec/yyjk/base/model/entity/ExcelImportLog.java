package com.cictec.yyjk.base.model.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "base_excel_import_log")
public class ExcelImportLog {
    @Id
    @Column(name = "xls_log_uuid")
    private String xlsLogUuid;

    /**
     * 日志所属模块
     */
    @Column(name = "xls_log_model")
    private String xlsLogModel;

    /**
     * excel文件名
     */
    @Column(name = "xls_filename")
    private String xlsFilename;

    /**
     * 错误码
     */
    @Column(name = "xls_err_code")
    private String xlsErrCode;

    /**
     * 错误信息
     */
    @Column(name = "xls_err_msg")
    private String xlsErrMsg;

    /**
     * 创建日期
     */
    @Column(name = "xls_log_date")
    private Date xlsLogDate;

    /**
     * 创建时间
     */
    @Column(name = "xls_log_create_time")
    private Date xlsLogCreateTime;

    /**
     * 创建人
     */
    @Column(name = "xls_log_create_user")
    private String xlsLogCreateUser;

    /**
     * 更新时间
     */
    @Column(name = "xls_log_update_time")
    private Date xlsLogUpdateTime;

    /**
     * @return xls_log_uuid
     */
    public String getXlsLogUuid() {
        return xlsLogUuid;
    }

    /**
     * @param xlsLogUuid
     */
    public void setXlsLogUuid(String xlsLogUuid) {
        this.xlsLogUuid = xlsLogUuid;
    }

    /**
     * 获取日志所属模块
     *
     * @return xls_log_model - 日志所属模块
     */
    public String getXlsLogModel() {
        return xlsLogModel;
    }

    /**
     * 设置日志所属模块
     *
     * @param xlsLogModel 日志所属模块
     */
    public void setXlsLogModel(String xlsLogModel) {
        this.xlsLogModel = xlsLogModel;
    }

    /**
     * 获取excel文件名
     *
     * @return xls_filename - excel文件名
     */
    public String getXlsFilename() {
        return xlsFilename;
    }

    /**
     * 设置excel文件名
     *
     * @param xlsFilename excel文件名
     */
    public void setXlsFilename(String xlsFilename) {
        this.xlsFilename = xlsFilename;
    }

    /**
     * 获取错误码
     *
     * @return xls_err_code - 错误码
     */
    public String getXlsErrCode() {
        return xlsErrCode;
    }

    /**
     * 设置错误码
     *
     * @param xlsErrCode 错误码
     */
    public void setXlsErrCode(String xlsErrCode) {
        this.xlsErrCode = xlsErrCode;
    }

    /**
     * 获取错误信息
     *
     * @return xls_err_msg - 错误信息
     */
    public String getXlsErrMsg() {
        return xlsErrMsg;
    }

    /**
     * 设置错误信息
     *
     * @param xlsErrMsg 错误信息
     */
    public void setXlsErrMsg(String xlsErrMsg) {
        this.xlsErrMsg = xlsErrMsg;
    }

    /**
     * 获取创建日期
     *
     * @return xls_log_date - 创建日期
     */
    public Date getXlsLogDate() {
        return xlsLogDate;
    }

    /**
     * 设置创建日期
     *
     * @param xlsLogDate 创建日期
     */
    public void setXlsLogDate(Date xlsLogDate) {
        this.xlsLogDate = xlsLogDate;
    }

    /**
     * 获取创建时间
     *
     * @return xls_log_create_time - 创建时间
     */
    public Date getXlsLogCreateTime() {
        return xlsLogCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param xlsLogCreateTime 创建时间
     */
    public void setXlsLogCreateTime(Date xlsLogCreateTime) {
        this.xlsLogCreateTime = xlsLogCreateTime;
    }

    /**
     * 获取创建人
     *
     * @return xls_log_create_user - 创建人
     */
    public String getXlsLogCreateUser() {
        return xlsLogCreateUser;
    }

    /**
     * 设置创建人
     *
     * @param xlsLogCreateUser 创建人
     */
    public void setXlsLogCreateUser(String xlsLogCreateUser) {
        this.xlsLogCreateUser = xlsLogCreateUser;
    }

    /**
     * 获取更新时间
     *
     * @return xls_log_update_time - 更新时间
     */
    public Date getXlsLogUpdateTime() {
        return xlsLogUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param xlsLogUpdateTime 更新时间
     */
    public void setXlsLogUpdateTime(Date xlsLogUpdateTime) {
        this.xlsLogUpdateTime = xlsLogUpdateTime;
    }
}