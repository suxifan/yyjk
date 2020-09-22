package com.cictec.yyjk.linenet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.linenet.mapper.NetIndexPfLineDayMapper;
import com.cictec.yyjk.linenet.model.entity.NetIndexPfLineDay;
import com.cictec.yyjk.linenet.model.view.NetIndexPfLineDayValue;
import com.cictec.yyjk.linenet.model.vo.NetIndexPfBaseVo;
import com.cictec.yyjk.linenet.service.NetIndexPfLineDayService;

/**
 * Created by mao on 2019/10/16.
 */
@Service
@Transactional
public class NetIndexPfLineDayServiceImpl extends AbstractService<NetIndexPfLineDay>
		implements NetIndexPfLineDayService {

	@Resource
	private NetIndexPfLineDayMapper netIndexPfLineDayMapper;

	@Override
	public List<NetIndexPfLineDayValue> getIndexPfLineDayListData(NetIndexPfBaseVo vo) {
		// bar
		String arrow = vo.getArrow();
		if (PMSUtils.isNotEmpty(arrow)) {
			if ("1".equals(arrow)) {
				vo.setArrow("上行");
			} else if ("2".equals(arrow)) {
				vo.setArrow("下行");
			} else {
				vo.setArrow("");
			}
		}
		List<NetIndexPfLineDayValue> list = netIndexPfLineDayMapper.getIndexPfLineDay(vo);
		return list;
	}

	@Override
	public List<NetIndexPfLineDayValue> getDayPfTOP10ListData(NetIndexPfBaseVo vo) {
		List<NetIndexPfLineDayValue> list = netIndexPfLineDayMapper.getDayPfTOP10List(vo);
		return list;
	}
}
