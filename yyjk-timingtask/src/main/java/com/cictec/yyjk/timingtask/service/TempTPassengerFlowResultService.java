package com.cictec.yyjk.timingtask.service;

import java.util.List;

import com.cictec.yyjk.commons.core.Service;
import com.cictec.yyjk.timingtask.model.entity.TempTPassengerFlowResult;
import com.cictec.yyjk.timingtask.model.vo.TempTPassengerFlowResultVo;

/**
 * Created by xpguo on 2020/08/25.
 */
public interface TempTPassengerFlowResultService extends Service<TempTPassengerFlowResult> {

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
	List<TempTPassengerFlowResult> getKlDataByLineUuid(String lineUuid);

	/**
	 * 根据线路UUID及lineType获取线站站序
	 * 
	 * @param lineUuid
	 * @param lineType
	 * @return
	 */
	public List<String> getLineStaSeqs(String lineUuid, String lineType);

	/**
	 * 修改为无效趟次
	 * 
	 * @param uuid
	 * @return
	 */
	void updateQuality(String uuid);
}
