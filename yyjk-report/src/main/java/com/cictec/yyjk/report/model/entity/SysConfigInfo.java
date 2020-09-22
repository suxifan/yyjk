package com.cictec.yyjk.report.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

/**
 * 系统配置信息表实体类
 * 
 * @author gxp
 *
 */
@Table(name = "t_sys_config_info")
public class SysConfigInfo {
	@Id
	@KeySql(sql = "select nextval('zhfxpt_info_id_seq'::regclass)", order = ORDER.BEFORE)
	@Column(name = "id")
	private String id;

	@Column(name = "code_name")
	private String codeName;

	@Column(name = "code_value")
	private String codeValue;

	@Column(name = "code_value_explain")
	private String codeValueExplain;

	@Column(name = "code_name_explain")
	private String codeNameExplain;

	@Column(name = "sfqy")
	private String sfqy;

	@Column(name = "create_time")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeValueExplain() {
		return codeValueExplain;
	}

	public void setCodeValueExplain(String codeValueExplain) {
		this.codeValueExplain = codeValueExplain;
	}

	public String getCodeNameExplain() {
		return codeNameExplain;
	}

	public void setCodeNameExplain(String codeNameExplain) {
		this.codeNameExplain = codeNameExplain;
	}

	public String getSfqy() {
		return sfqy;
	}

	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
