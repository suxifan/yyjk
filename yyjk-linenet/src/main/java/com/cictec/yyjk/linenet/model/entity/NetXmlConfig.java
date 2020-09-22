package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_xml_config")
public class NetXmlConfig {
    @Id
    private String uuid;

    /**
     * 父类型
     */
    @Column(name = "code_type")
    private String codeType;

    /**
     * 父类型名称
     */
    @Column(name = "code_type_name")
    private String codeTypeName;

    /**
     * 类型
     */
    private String code;

    /**
     * 类型名称
     */
    @Column(name = "code_value")
    private String codeValue;

    /**
     * 序号
     */
    @Column(name = "code_index")
    private String codeIndex;

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
     * 获取父类型
     *
     * @return code_type - 父类型
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置父类型
     *
     * @param codeType 父类型
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取父类型名称
     *
     * @return code_type_name - 父类型名称
     */
    public String getCodeTypeName() {
        return codeTypeName;
    }

    /**
     * 设置父类型名称
     *
     * @param codeTypeName 父类型名称
     */
    public void setCodeTypeName(String codeTypeName) {
        this.codeTypeName = codeTypeName;
    }

    /**
     * 获取类型
     *
     * @return code - 类型
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置类型
     *
     * @param code 类型
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取类型名称
     *
     * @return code_value - 类型名称
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 设置类型名称
     *
     * @param codeValue 类型名称
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * 获取序号
     *
     * @return code_index - 序号
     */
    public String getCodeIndex() {
        return codeIndex;
    }

    /**
     * 设置序号
     *
     * @param codeIndex 序号
     */
    public void setCodeIndex(String codeIndex) {
        this.codeIndex = codeIndex;
    }
}