package com.cictec.yyjk.timingtask.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.timingtask.mapper.TSafeDeviceRidControlMapper;
import com.cictec.yyjk.timingtask.model.entity.TSafeDeviceRidControl;
import com.cictec.yyjk.timingtask.model.viewdata.TSafeDeviceRidControlValue;
import com.cictec.yyjk.timingtask.model.vo.TSafeDeviceRidControlVo;
import com.cictec.yyjk.timingtask.service.TSafeDeviceRidControlService;

/**
 * Created by xpguo on 2020/07/09.
 */
@Service
@Transactional
public class TSafeDeviceRidControlServiceImpl extends AbstractService<TSafeDeviceRidControl>
		implements TSafeDeviceRidControlService {

	@Resource
	private TSafeDeviceRidControlMapper tSafeDeviceRidControlMapper;

	/**
	 * 更新所有车辆掉线
	 */
	public void updateBusState() {
		tSafeDeviceRidControlMapper.updateBusState();
	}

	public TSafeDeviceRidControl getBusDetailByBusUuid(String busUuid) {
		return tSafeDeviceRidControlMapper.getBusDetailByBusUuid(busUuid);
	}

	public List<TSafeDeviceRidControlValue> getDeviceRidControlData(TSafeDeviceRidControlVo tSafeDeviceRidControlVo) {
		List<TSafeDeviceRidControlValue> list = tSafeDeviceRidControlMapper
				.getDeviceRidControlData(tSafeDeviceRidControlVo);
		for (TSafeDeviceRidControlValue bean : list) {
			if (PMSUtils.isNotEmpty(bean.getWarnTimes())) {
				int warnTimes = Integer.parseInt(bean.getWarnTimes());
				int day = warnTimes / (60 * 24);
				int hour = (warnTimes - day * (60 * 24)) / (60);
				int min = warnTimes - day * (60 * 24) - hour * (60);
				String warnTimesStr = day + "天" + hour + "小时" + min + "分钟";
				bean.setWarnTimes(warnTimesStr);
			}
		}
		return list;
	}

}
