package com.cictec.yyjk.fatigue.mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.model.vo.TWarnVo;
import com.cictec.yyjk.fatigue.model.vo.TWarnsAnalysisDto;

public interface TWarnMapper extends Mapper<TWarn> {

	/**
	 * <p>
	 * Description: 查询报警信息
	 * </p>
	 * <p>
	 * Function: selectWarnInfo
	 * </p>
	 * <p>
	 * return value:List<WarnDto>
	 * </p>
	 * <p>
	 * 
	 * @param vo
	 *            <p>
	 * @return
	 *         </p>
	 *         <p>
	 *         throws Exception:
	 *         </p>
	 *         <p>
	 *         History: 2019年5月24日 下午1:50:24 Rwq
	 *         </p>
	 *
	 */
	List<TWarn> selectWarnInfo(TWarnVo vo);

	/**
	 * <p>
	 * Description: 报警中心列表详情
	 * </p>
	 * <p>
	 * Function: warnInfoDetailGet
	 * </p>
	 *
	 */
	TWarn warnInfoDetailGet(TWarnVo vo);

	/**
	 * <p>
	 * Description: 根据报警uuid获取报警时间
	 * </p>
	 * <p>
	 * Function: warnInfoDetailGet
	 * </p>
	 *
	 */
	Date getWarnTimeByUuid(String warnUuid);

	/**
	 * <p>
	 * Description: 报警等级占比
	 * </p>
	 * <p>
	 * Function: getWarnLevelPie
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnLevelPie(TWarnVo vo);

	/**
	 * <p>
	 * Description: 查询各车辆的报警级别数量
	 * </p>
	 * <p>
	 * Function: getWarnLevelNumToBus
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnLevelNumToBus(TWarnVo vo);

	/**
	 * <p>
	 * Description: 查询报警类型数量
	 * </p>
	 * <p>
	 * Function: getWarnTypeNum
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnTypeNum(TWarnVo vo);

	/**
	 * <p>
	 * Description: 报警次数趋势环比
	 * </p>
	 * <p>
	 * Function: getWarnNumByDate
	 * </p>
	 *
	 */
	List<TWarnsAnalysisDto> getWarnNumByDate(TWarnVo vo);

	/**
	 * 获取报警信息
	 * 
	 * @return
	 */
	List<TWarn> getWarnInfo();

	/**
	 * 根据设备号获取指定记录数
	 * 
	 * @param deviceCode
	 * @param total
	 * @return
	 */
	List<TWarn> getWarnInfoBy(@Param(value = "deviceCode") String deviceCode,
			@Param(value = "auditStatus") List<String> auditStatus,
			@Param(value = "handleResults") List<String> handleResults, @Param(value = "total") Integer total);

	/**
	 * 根据车牌号查车辆设备号
	 * 
	 * @param busPlateNumber
	 */
	String getDevCodeByBusPlateNumber(@Param(value = "busPlateNumber") String busPlateNumber);

	void updateWarnCc(TWarn vo);

	/**
	 * 根据设备号查找抓拍 图片
	 * 
	 * 
	 */
	List<TWarn> getWarnFigndetail(@Param(value = "devCode") String devCode,
			@Param(value = "warnTime") Timestamp warnTime);

	/***
	 * 车辆设备状态
	 */
	List<Map> selectDevstatus();

	/**
	 * 查询当日车辆客流累积
	 */
	public Integer getTotalPerson(@Param(value = "busNumber") String busNumber,
			@Param(value = "samplingTime") String samplingTime);

	/**
	 * 查询趟次车辆客流累积
	 */
	public Integer getCurrentPerson(@Param(value = "busNumber") String busNumber,
			@Param(value = "samplingTime") String samplingTime, @Param(value = "currenttrip") String currenttrip);

}