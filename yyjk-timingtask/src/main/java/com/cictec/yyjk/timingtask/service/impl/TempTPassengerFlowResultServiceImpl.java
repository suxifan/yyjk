package com.cictec.yyjk.timingtask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.timingtask.mapper.TempTPassengerFlowResultMapper;
import com.cictec.yyjk.timingtask.model.entity.TempTPassengerFlowResult;
import com.cictec.yyjk.timingtask.model.vo.TempTPassengerFlowResultVo;
import com.cictec.yyjk.timingtask.service.TempTPassengerFlowResultService;

/**
 * Created by xpguo on 2020/08/25.
 */
@Service
@Transactional
public class TempTPassengerFlowResultServiceImpl extends AbstractService<TempTPassengerFlowResult>
		implements TempTPassengerFlowResultService {

	@Resource
	private TempTPassengerFlowResultMapper tempTPassengerFlowResultMapper;

	@Override
	public List<TempTPassengerFlowResult> getAllByCondition(TempTPassengerFlowResultVo entity) {
		return tempTPassengerFlowResultMapper.getAllByCondition(entity);
	}

	@Override
	public List<String> getLineIds() {
		return tempTPassengerFlowResultMapper.getLineIds();
	}

	@Override
	public List<TempTPassengerFlowResult> getKlDataByLineUuid(String lineUuid) {
		return tempTPassengerFlowResultMapper.getKlDataByLineUuid(lineUuid);
	}

	@Override
	public List<String> getLineStaSeqs(String lineUuid, String lineType) {
		return tempTPassengerFlowResultMapper.getLineStaSeqs(lineUuid, lineType);
	}

	@Override
	public void updateQuality(String uuid) {
		tempTPassengerFlowResultMapper.updateQuality(uuid);

	}
}
