package com.cictec.yyjk.timingtask.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.PassengerFlowResult;
import com.cictec.yyjk.timingtask.model.viewdata.OnOffPsersonNumberValue;
import com.cictec.yyjk.timingtask.model.vo.PassengerFlowResultVo;

public interface PassengerFlowResultMapper extends Mapper<PassengerFlowResult> {
	/**
	 * 清空表
	 */
	void clearTabel();

	/**
	 * 删除表
	 */
	void dropTabel();

	/**
	 * 拷贝表
	 */
	void copyTable();

	/**
	 * 根据条件清楚数据
	 * 
	 * @param month
	 */
	void deletePassengerDatas(@Param(value = "month") String month);

	/**
	 * 获取客流信息
	 * 
	 * @return
	 */
	List<PassengerFlowResult> getPassengerFlow();

	/**
	 * 获取当天的客流明细
	 * 
	 * @param passengerFlowResultVo
	 * @return
	 */
	List<PassengerFlowResult> getTodayPassengerFlow(PassengerFlowResultVo passengerFlowResultVo);

	/**
	 * 根据条件查询当天总的上下车客流
	 * 
	 * @param passengerFlowResultVo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map getTodayTotalOnOffPassengerFlow(PassengerFlowResultVo passengerFlowResultVo);

	/**
	 * 客流最热站点top10
	 * 
	 * @param orgId
	 * @param staUuids
	 * @return
	 */
	List<PassengerFlowResult> getHortStationTopTen(@Param(value = "orgId") String orgId,
			@Param(value = "staUuids") List<String> staUuids, @Param(value = "lineUuids") List<String> lineUuids);

	/**
	 * 客流最热线路top10
	 * 
	 * @param orgId
	 * @param lineUuids
	 * @return
	 */
	List<PassengerFlowResult> getHortLineTopTen(@Param(value = "orgId") String orgId,
			@Param(value = "lineUuids") List<String> lineUuids);

	/**
	 * 根据机构、线路和日期统计上下车人数
	 * 
	 * @return
	 */
	List<OnOffPsersonNumberValue> getOnOffPersonCount(PassengerFlowResultVo passengerFlowResultVo);

	/**
	 * 根据机构和日期统计上下车人数
	 * 
	 * @return
	 */
	List<OnOffPsersonNumberValue> getOnOffPersonCountByCompany(PassengerFlowResultVo passengerFlowResultVo);

	/**
	 * 根据机构，线路及时间查询当天的上下车人数
	 * 
	 * @return
	 */
	List<OnOffPsersonNumberValue> getTodayOnOffPersonCount(PassengerFlowResultVo passengerFlowResultVo);

	/**
	 * 查询当天的上下车人数，按公司求和
	 * 
	 * @return
	 */
	List<OnOffPsersonNumberValue> getTodayOnOffPersonCountByCompany(PassengerFlowResultVo passengerFlowResultVo);

	/**
	 * 单车客流上下车人数 当天
	 * 
	 * @param passengerFlowResultVo
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getTodayTotalPassengerFlowByBus(PassengerFlowResultVo passengerFlowResultVo);

	/**
	 * 单车客流上下车人数 历史
	 * 
	 * @param passengerFlowResultVo
	 */
	@SuppressWarnings("rawtypes")
	List<Map> getHistoryTotalPassengerFlowByBus(PassengerFlowResultVo passengerFlowResultVo);
}