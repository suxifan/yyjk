package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_xml_dea_base_config")
public class NetXmlDeaBaseConfig {
    @Id
    private Integer uuid;

    @Column(name = "dea_table_name")
    private String deaTableName;

    @Column(name = "p_key")
    private String pKey;

    @Column(name = "col_name")
    private String colName;

    @Column(name = "o_type")
    private String oType;

    @Column(name = "n_type")
    private String nType;

    @Column(name = "min_v")
    private String minV;

    @Column(name = "max_v")
    private String maxV;

    @Column(name = "opt_v")
    private String optV;

    @Column(name = "dea_index")
    private String deaIndex;

    /**
     * @return uuid
     */
    public Integer getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    /**
     * @return dea_table_name
     */
    public String getDeaTableName() {
        return deaTableName;
    }

    /**
     * @param deaTableName
     */
    public void setDeaTableName(String deaTableName) {
        this.deaTableName = deaTableName;
    }

    /**
     * @return p_key
     */
    public String getpKey() {
        return pKey;
    }

    /**
     * @param pKey
     */
    public void setpKey(String pKey) {
        this.pKey = pKey;
    }

    /**
     * @return col_name
     */
    public String getColName() {
        return colName;
    }

    /**
     * @param colName
     */
    public void setColName(String colName) {
        this.colName = colName;
    }

    /**
     * @return o_type
     */
    public String getoType() {
        return oType;
    }

    /**
     * @param oType
     */
    public void setoType(String oType) {
        this.oType = oType;
    }

    /**
     * @return n_type
     */
    public String getnType() {
        return nType;
    }

    /**
     * @param nType
     */
    public void setnType(String nType) {
        this.nType = nType;
    }

    /**
     * @return min_v
     */
    public String getMinV() {
        return minV;
    }

    /**
     * @param minV
     */
    public void setMinV(String minV) {
        this.minV = minV;
    }

    /**
     * @return max_v
     */
    public String getMaxV() {
        return maxV;
    }

    /**
     * @param maxV
     */
    public void setMaxV(String maxV) {
        this.maxV = maxV;
    }

    /**
     * @return opt_v
     */
    public String getOptV() {
        return optV;
    }

    /**
     * @param optV
     */
    public void setOptV(String optV) {
        this.optV = optV;
    }

    /**
     * @return dea_index
     */
    public String getDeaIndex() {
        return deaIndex;
    }

    /**
     * @param deaIndex
     */
    public void setDeaIndex(String deaIndex) {
        this.deaIndex = deaIndex;
    }
}