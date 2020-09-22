package com.cictec.yyjk.timingtask.tasks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.base.mapper.DwDimOtherBusDeviceMapper;
import com.cictec.yyjk.base.model.entity.DwDimOtherBusDevice;
import com.cictec.yyjk.timingtask.model.entity.DwDimBus;
import com.cictec.yyjk.timingtask.service.DwDimBusService;

/**
 * 根据车辆基础信息同步车辆设备绑定关系表
 * 
 * 当车辆信息删除后，同步将车辆设备关系表里的关系删除
 * 
 * 因为当车辆删除后，设备配置系统中车辆绑定关系列表不显示已删除车辆，导致绑定的设备无法解绑
 * 
 * @author xpguo
 *
 */
@Component
public class SynchronizingDevBusRelationByBusTask {
	private static Logger LOG = LoggerFactory.getLogger(SynchronizingDevBusRelationByBusTask.class);
	@Autowired
	private DwDimOtherBusDeviceMapper dwDimOtherBusDeviceMapper;
	@Autowired
	private DwDimBusService dwDimBusService;

	@Scheduled(cron = "0 27 5 * * ?")
	public void start() {
		try {
			List<DwDimBus> list = dwDimBusService.selectAll();
			for (DwDimBus dwDimBus : list) {
				if ("1".equals(dwDimBus.getBusDropFlag())) {
					DwDimOtherBusDevice bean = new DwDimOtherBusDevice();
					bean.setBusUuid(dwDimBus.getBusUuid());
					dwDimOtherBusDeviceMapper.delete(bean);
				}
			}
		} catch (Exception ex) {
			LOG.error("根据车辆基础信息同步车辆设备绑定关系表任务执行失败！{}", ex);
		}
	}
}
