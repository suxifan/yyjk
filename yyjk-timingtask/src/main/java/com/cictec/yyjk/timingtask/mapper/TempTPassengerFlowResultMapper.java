package com.cictec.yyjk.timingtask.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cictec.yyjk.commons.core.Mapper;
import com.cictec.yyjk.timingtask.model.entity.TempTPassengerFlowResult;
import com.cictec.yyjk.timingtask.model.vo.TempTPassengerFlowResultVo;

public interface TempTPassengerFlowResultMapper extends Mapper<TempTPassengerFlowResult> {
	List<TempTPassengerFlowResult> getAllByCondition(TempTPassengerFlowResultVo entity);

	/**
	 * 获取当天客流表中所有线路UUIDS
	 * 
	 * @return
	 */
	List<String> getLineIds();

	/**
	 * 获取线路客流数据
	 * 
	 * @param lineUuid
	 * @return
	 */
	List<TempTPassengerFlowResult> getKlDataByLineUuid(@Param(value = "lineUuid") String lineUuid);

	/**
	 * 根据线路UUID及lineType获取线站站序
	 * 
	 * @param lineUuid
	 * @param lineType
	 * @return
	 */
	List<String> getLineStaSeqs(@Param(value = "lineUuid") String lineUuid, @Param(value = "lineType") String lineType);

	/**
	 * 修改为无效趟次
	 * 
	 * @param uuid
	 * @return
	 */
	void updateQuality(@Param(value = "uuid") String uuid);
}