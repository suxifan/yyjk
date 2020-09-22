package com.cictec.yyjk.linenet.model.entity;

import javax.persistence.*;

@Table(name = "net_index_dea_transfordata")
public class NetIndexDeaTransfordata {
    @Id
    private Integer uuid;

    /**
     * 线路号
     */
    @Column(name = "line_number")
    private String lineNumber;

    /**
     * 运营车辆数（原始值）
     */
    private Float ovehiclecou;

    /**
     * 运营车辆数（转换后值）
     */
    private Float nvehiclecou;

    /**
     * 运营时间（原始值）
     */
    private Float oworktime;

    /**
     * 运营时间（转换后值）
     */
    private Float nworktime;

    /**
     * 线长偏差（原始值）
     */
    private Float opjpc;

    /**
     * 线长偏差（转换后值）
     */
    private Float npjpc;

    /**
     * 非直线系数（原始值）
     */
    private Float ofzx;

    /**
     * 非直线系数（转换后值）
     */
    private Float nfzx;

    /**
     * 站点个数（原始值）
     */
    private Float ositecount;

    /**
     * 站点个数（转换后值）
     */
    private Float nsitecount;

    /**
     * 线长（原始值）
     */
    private Float olength;

    /**
     * 线长（转换后值）
     */
    private Float nlength;

    /**
     * 是否空调车（原始值）
     */
    private Float oiskt;

    /**
     * 是否空调车（转换后值）
     */
    private Float niskt;

    /**
     * 运送速度（原始值）
     */
    private Float ospeed;

    /**
     * 运送速度（转换后值）
     */
    private Float nspeed;

    /**
     * 刷卡量（原始值）
     */
    private Float obrushcount;

    /**
     * 刷卡量（转换后值）
     */
    private Float nbrushcount;

    /**
     * 连通度（原始值）
     */
    private Float oltd;

    /**
     * 连通度（转换后值）
     */
    private Float nltd;

    /**
     * 便利度（原始值）
     */
    private Float obld;

    /**
     * 便利度（转换后值）
     */
    private Float nbld;

    /**
     * 交替系数（原始值）
     */
    private Float ojtxs;

    /**
     * 交替系数（转换后值）
     */
    private Float njtxs;

    /**
     * 满载率（原始值）
     */
    private Float omzl;

    /**
     * 满载率（转换后值）
     */
    private Float nmzl;

    /**
     * 平均站距（原始值）
     */
    @Column(name = "op_distance")
    private Float opDistance;

    /**
     * 平均站距（转换后值）
     */
    @Column(name = "np_distance")
    private Float npDistance;

    /**
     * 线路负荷（原始值）
     */
    private Float ofh;

    /**
     * 线路负荷（转换后值）
     */
    private Float nfh;

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
     * 获取线路号
     *
     * @return line_number - 线路号
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * 设置线路号
     *
     * @param lineNumber 线路号
     */
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * 获取运营车辆数（原始值）
     *
     * @return ovehiclecou - 运营车辆数（原始值）
     */
    public Float getOvehiclecou() {
        return ovehiclecou;
    }

    /**
     * 设置运营车辆数（原始值）
     *
     * @param ovehiclecou 运营车辆数（原始值）
     */
    public void setOvehiclecou(Float ovehiclecou) {
        this.ovehiclecou = ovehiclecou;
    }

    /**
     * 获取运营车辆数（转换后值）
     *
     * @return nvehiclecou - 运营车辆数（转换后值）
     */
    public Float getNvehiclecou() {
        return nvehiclecou;
    }

    /**
     * 设置运营车辆数（转换后值）
     *
     * @param nvehiclecou 运营车辆数（转换后值）
     */
    public void setNvehiclecou(Float nvehiclecou) {
        this.nvehiclecou = nvehiclecou;
    }

    /**
     * 获取运营时间（原始值）
     *
     * @return oworktime - 运营时间（原始值）
     */
    public Float getOworktime() {
        return oworktime;
    }

    /**
     * 设置运营时间（原始值）
     *
     * @param oworktime 运营时间（原始值）
     */
    public void setOworktime(Float oworktime) {
        this.oworktime = oworktime;
    }

    /**
     * 获取运营时间（转换后值）
     *
     * @return nworktime - 运营时间（转换后值）
     */
    public Float getNworktime() {
        return nworktime;
    }

    /**
     * 设置运营时间（转换后值）
     *
     * @param nworktime 运营时间（转换后值）
     */
    public void setNworktime(Float nworktime) {
        this.nworktime = nworktime;
    }

    /**
     * 获取线长偏差（原始值）
     *
     * @return opjpc - 线长偏差（原始值）
     */
    public Float getOpjpc() {
        return opjpc;
    }

    /**
     * 设置线长偏差（原始值）
     *
     * @param opjpc 线长偏差（原始值）
     */
    public void setOpjpc(Float opjpc) {
        this.opjpc = opjpc;
    }

    /**
     * 获取线长偏差（转换后值）
     *
     * @return npjpc - 线长偏差（转换后值）
     */
    public Float getNpjpc() {
        return npjpc;
    }

    /**
     * 设置线长偏差（转换后值）
     *
     * @param npjpc 线长偏差（转换后值）
     */
    public void setNpjpc(Float npjpc) {
        this.npjpc = npjpc;
    }

    /**
     * 获取非直线系数（原始值）
     *
     * @return ofzx - 非直线系数（原始值）
     */
    public Float getOfzx() {
        return ofzx;
    }

    /**
     * 设置非直线系数（原始值）
     *
     * @param ofzx 非直线系数（原始值）
     */
    public void setOfzx(Float ofzx) {
        this.ofzx = ofzx;
    }

    /**
     * 获取非直线系数（转换后值）
     *
     * @return nfzx - 非直线系数（转换后值）
     */
    public Float getNfzx() {
        return nfzx;
    }

    /**
     * 设置非直线系数（转换后值）
     *
     * @param nfzx 非直线系数（转换后值）
     */
    public void setNfzx(Float nfzx) {
        this.nfzx = nfzx;
    }

    /**
     * 获取站点个数（原始值）
     *
     * @return ositecount - 站点个数（原始值）
     */
    public Float getOsitecount() {
        return ositecount;
    }

    /**
     * 设置站点个数（原始值）
     *
     * @param ositecount 站点个数（原始值）
     */
    public void setOsitecount(Float ositecount) {
        this.ositecount = ositecount;
    }

    /**
     * 获取站点个数（转换后值）
     *
     * @return nsitecount - 站点个数（转换后值）
     */
    public Float getNsitecount() {
        return nsitecount;
    }

    /**
     * 设置站点个数（转换后值）
     *
     * @param nsitecount 站点个数（转换后值）
     */
    public void setNsitecount(Float nsitecount) {
        this.nsitecount = nsitecount;
    }

    /**
     * 获取线长（原始值）
     *
     * @return olength - 线长（原始值）
     */
    public Float getOlength() {
        return olength;
    }

    /**
     * 设置线长（原始值）
     *
     * @param olength 线长（原始值）
     */
    public void setOlength(Float olength) {
        this.olength = olength;
    }

    /**
     * 获取线长（转换后值）
     *
     * @return nlength - 线长（转换后值）
     */
    public Float getNlength() {
        return nlength;
    }

    /**
     * 设置线长（转换后值）
     *
     * @param nlength 线长（转换后值）
     */
    public void setNlength(Float nlength) {
        this.nlength = nlength;
    }

    /**
     * 获取是否空调车（原始值）
     *
     * @return oiskt - 是否空调车（原始值）
     */
    public Float getOiskt() {
        return oiskt;
    }

    /**
     * 设置是否空调车（原始值）
     *
     * @param oiskt 是否空调车（原始值）
     */
    public void setOiskt(Float oiskt) {
        this.oiskt = oiskt;
    }

    /**
     * 获取是否空调车（转换后值）
     *
     * @return niskt - 是否空调车（转换后值）
     */
    public Float getNiskt() {
        return niskt;
    }

    /**
     * 设置是否空调车（转换后值）
     *
     * @param niskt 是否空调车（转换后值）
     */
    public void setNiskt(Float niskt) {
        this.niskt = niskt;
    }

    /**
     * 获取运送速度（原始值）
     *
     * @return ospeed - 运送速度（原始值）
     */
    public Float getOspeed() {
        return ospeed;
    }

    /**
     * 设置运送速度（原始值）
     *
     * @param ospeed 运送速度（原始值）
     */
    public void setOspeed(Float ospeed) {
        this.ospeed = ospeed;
    }

    /**
     * 获取运送速度（转换后值）
     *
     * @return nspeed - 运送速度（转换后值）
     */
    public Float getNspeed() {
        return nspeed;
    }

    /**
     * 设置运送速度（转换后值）
     *
     * @param nspeed 运送速度（转换后值）
     */
    public void setNspeed(Float nspeed) {
        this.nspeed = nspeed;
    }

    /**
     * 获取刷卡量（原始值）
     *
     * @return obrushcount - 刷卡量（原始值）
     */
    public Float getObrushcount() {
        return obrushcount;
    }

    /**
     * 设置刷卡量（原始值）
     *
     * @param obrushcount 刷卡量（原始值）
     */
    public void setObrushcount(Float obrushcount) {
        this.obrushcount = obrushcount;
    }

    /**
     * 获取刷卡量（转换后值）
     *
     * @return nbrushcount - 刷卡量（转换后值）
     */
    public Float getNbrushcount() {
        return nbrushcount;
    }

    /**
     * 设置刷卡量（转换后值）
     *
     * @param nbrushcount 刷卡量（转换后值）
     */
    public void setNbrushcount(Float nbrushcount) {
        this.nbrushcount = nbrushcount;
    }

    /**
     * 获取连通度（原始值）
     *
     * @return oltd - 连通度（原始值）
     */
    public Float getOltd() {
        return oltd;
    }

    /**
     * 设置连通度（原始值）
     *
     * @param oltd 连通度（原始值）
     */
    public void setOltd(Float oltd) {
        this.oltd = oltd;
    }

    /**
     * 获取连通度（转换后值）
     *
     * @return nltd - 连通度（转换后值）
     */
    public Float getNltd() {
        return nltd;
    }

    /**
     * 设置连通度（转换后值）
     *
     * @param nltd 连通度（转换后值）
     */
    public void setNltd(Float nltd) {
        this.nltd = nltd;
    }

    /**
     * 获取便利度（原始值）
     *
     * @return obld - 便利度（原始值）
     */
    public Float getObld() {
        return obld;
    }

    /**
     * 设置便利度（原始值）
     *
     * @param obld 便利度（原始值）
     */
    public void setObld(Float obld) {
        this.obld = obld;
    }

    /**
     * 获取便利度（转换后值）
     *
     * @return nbld - 便利度（转换后值）
     */
    public Float getNbld() {
        return nbld;
    }

    /**
     * 设置便利度（转换后值）
     *
     * @param nbld 便利度（转换后值）
     */
    public void setNbld(Float nbld) {
        this.nbld = nbld;
    }

    /**
     * 获取交替系数（原始值）
     *
     * @return ojtxs - 交替系数（原始值）
     */
    public Float getOjtxs() {
        return ojtxs;
    }

    /**
     * 设置交替系数（原始值）
     *
     * @param ojtxs 交替系数（原始值）
     */
    public void setOjtxs(Float ojtxs) {
        this.ojtxs = ojtxs;
    }

    /**
     * 获取交替系数（转换后值）
     *
     * @return njtxs - 交替系数（转换后值）
     */
    public Float getNjtxs() {
        return njtxs;
    }

    /**
     * 设置交替系数（转换后值）
     *
     * @param njtxs 交替系数（转换后值）
     */
    public void setNjtxs(Float njtxs) {
        this.njtxs = njtxs;
    }

    /**
     * 获取满载率（原始值）
     *
     * @return omzl - 满载率（原始值）
     */
    public Float getOmzl() {
        return omzl;
    }

    /**
     * 设置满载率（原始值）
     *
     * @param omzl 满载率（原始值）
     */
    public void setOmzl(Float omzl) {
        this.omzl = omzl;
    }

    /**
     * 获取满载率（转换后值）
     *
     * @return nmzl - 满载率（转换后值）
     */
    public Float getNmzl() {
        return nmzl;
    }

    /**
     * 设置满载率（转换后值）
     *
     * @param nmzl 满载率（转换后值）
     */
    public void setNmzl(Float nmzl) {
        this.nmzl = nmzl;
    }

    /**
     * 获取平均站距（原始值）
     *
     * @return op_distance - 平均站距（原始值）
     */
    public Float getOpDistance() {
        return opDistance;
    }

    /**
     * 设置平均站距（原始值）
     *
     * @param opDistance 平均站距（原始值）
     */
    public void setOpDistance(Float opDistance) {
        this.opDistance = opDistance;
    }

    /**
     * 获取平均站距（转换后值）
     *
     * @return np_distance - 平均站距（转换后值）
     */
    public Float getNpDistance() {
        return npDistance;
    }

    /**
     * 设置平均站距（转换后值）
     *
     * @param npDistance 平均站距（转换后值）
     */
    public void setNpDistance(Float npDistance) {
        this.npDistance = npDistance;
    }

    /**
     * 获取线路负荷（原始值）
     *
     * @return ofh - 线路负荷（原始值）
     */
    public Float getOfh() {
        return ofh;
    }

    /**
     * 设置线路负荷（原始值）
     *
     * @param ofh 线路负荷（原始值）
     */
    public void setOfh(Float ofh) {
        this.ofh = ofh;
    }

    /**
     * 获取线路负荷（转换后值）
     *
     * @return nfh - 线路负荷（转换后值）
     */
    public Float getNfh() {
        return nfh;
    }

    /**
     * 设置线路负荷（转换后值）
     *
     * @param nfh 线路负荷（转换后值）
     */
    public void setNfh(Float nfh) {
        this.nfh = nfh;
    }
}