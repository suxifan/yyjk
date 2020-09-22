package com.cictec.yyjk.report.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.report.model.entity.PassengerFlow;
import com.cictec.yyjk.report.model.vo.HeatmapVo;
import com.cictec.yyjk.report.model.vo.PassengerFlowVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.model.vo.WarnDetailInfoVo;

public interface PassengerFlowMapper extends Mapper<PassengerFlow> {

	/**
	 * 总实时载客（人）、实时满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	PassengerFlowVo getRealTimePersoncountAndFullLoadRate(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询当日累计客流
	 * 
	 * @param queryCondition
	 * @return
	 */
	PassengerFlowVo getTotalPassengerFlow(QueryCondition queryCondition);

	/**
	 * 当日机构累计客流
	 * 
	 * @param queryCondition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getCompanyTotalPassengerFlow();

	/**
	 * 查询与当前时间的昨日客流数据量
	 * 
	 * @param busPlateNumber
	 * @param busPlateNumber
	 * @return
	 */
	PassengerFlowVo getYesterdayTotalPassengerFlow(@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime, @Param(value = "orgId") String orgId,
			@Param(value = "lineUuids") List<String> lineUuids);

	/**
	 * 获取当天线路累计客流人数
	 * 
	 * @return
	 */
	List<PassengerFlowVo> getLineTotalPassengerFlow(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询实时客流人次
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getRealTimePassengerFlow(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询实时满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getRealTimeFullLoadRate(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询线路满载率排行top10
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getRealTimeFullLoadRateTop10(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询某一时刻车辆满载率
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<PassengerFlowVo> getBusFullLoadRate(QueryCondition queryCondition);

	/**
	 * 根据查询条件查询某一时刻前五分钟站点等降量（热力图数据）[[lng,lat,value]...]
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<HeatmapVo> getBusHeatmapDatas(QueryCondition queryCondition);

	/**
	 * 获取当日累计客流
	 * 
	 * @param warnDetailInfoVo
	 * @return
	 */
	Integer getTotalPerson(WarnDetailInfoVo warnDetailInfoVo);

	/**
	 * 获取当前累计客流
	 * 
	 * @param warnDetailInfoVo
	 * @return
	 */
	Integer getCurrentPerson(WarnDetailInfoVo warnDetailInfoVo);

	/**
	 * 获取单车车内人数及荷载人数
	 * 
	 * @param warnDetailInfoVo
	 * @return
	 */
	PassengerFlowVo getPersionCountAndLoadNumber(WarnDetailInfoVo warnDetailInfoVo);
}
