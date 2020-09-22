package com.cictec.yyjk.timingtask.tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.service.BusLineService;
import com.cictec.yyjk.base.service.DwDimOtherDeviceService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.timingtask.model.entity.TSafeDeviceRidControl;
import com.cictec.yyjk.timingtask.service.TSafeDeviceRidControlService;

/**
 * 车辆设备脱管信息数据定时任务
 * 
 * @author xpguo
 *
 */
@Component
public class TSafeDeviceRidControlTask {
	private static Logger LOG = LoggerFactory.getLogger(AnalysisCapacityVolumeDayTask.class);
	@Autowired
	private Environment env;
	@Autowired
	private DwDimOtherDeviceService dwDimOtherDeviceService;

	@Autowired
	private TSafeDeviceRidControlService tSafeDeviceRidControlService;

	@Autowired
	private BusLineService busLineService;

	@Scheduled(cron = "${jobs.device.rid.control.datas}")
	public void start() throws ParseException {
		LOG.info("车辆设备脱管信息数据定时任务开始...");
		String httpUrl = env.getProperty("gjdd.http.url") + "/getBusPosition";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("车辆实时位置信息url:{},result:{}", httpUrl, result.length());
		JSONArray arrys = null;
		if (PMSUtils.isNotEmpty(result)) {
			TSafeDeviceRidControl record = new TSafeDeviceRidControl();
			// 修改车辆状态和报警状态为null
			tSafeDeviceRidControlService.updateBusState();
			arrys = JSON.parseArray(result);
			Iterator<Object> iterator = arrys.iterator();
			while (iterator.hasNext()) {
				JSONObject next = (JSONObject) iterator.next();
				String busId = next.getString("busId");
				String busSelfcode = next.getString("busSelfcode");
				String busNumber = next.getString("busNumber");
				// 不能直接用转发的线路，转发的线路是子线路，宜宾运营监控只存了父线路
				// String lineId = next.getString("lineId");
				// String lineName = next.getString("lineName");
				TSafeDeviceRidControl busDetail = tSafeDeviceRidControlService.getBusDetailByBusUuid(busId);
				String orgUuid = busDetail.getOrgUuid();// 需要反查
				String orgName = busDetail.getOrgName();// 需要反查
				String lineId = busDetail.getLineUuid();// 需要反查
				String lineName = busDetail.getLineName();// 需要反查
				String posUploadTimeStr = next.getString("posUploadTime");// 车辆在线时间
				Date posUploadTime = null;
				if (PMSUtils.isNotEmpty(posUploadTimeStr)) {
					posUploadTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(posUploadTimeStr);
				}
				Date busUpdateTime = new Date();
				// 车辆id不为空
				if (PMSUtils.isNotEmpty(busId)) {
					// 根据车辆id查询车辆的所有设备
					List<DwDimOtherDevice> deviceList = dwDimOtherDeviceService.getDeviceInfoByBusUuid(busId);
					for (DwDimOtherDevice dwDimOtherDevice : deviceList) {
						TSafeDeviceRidControl bean = new TSafeDeviceRidControl();
						bean.setBusUuid(busId);
						bean.setDevUuid(dwDimOtherDevice.getDevUuid());
						List<TSafeDeviceRidControl> iControl = tSafeDeviceRidControlService.select(bean);
						bean.setBusOnlineTime(posUploadTime);
						bean.setBusUpdateTime(new Date());
						bean.setBusState("1");
						String currentState = "0";// 当前状态(异常0；正常1)
						String devState = dwDimOtherDevice.getDevOnlineStatus();
						// 如果设备状态在线，当前状态修改为正常并修改异常时间
						if ("1".equals(devState)) {
							currentState = "1";
							bean.setWarnTime(new Date());
						}
						bean.setCurrentState(currentState);
						bean.setDevOnlineTime(dwDimOtherDevice.getDevOnlineTime());
						bean.setDevUpdateTime(new Date());
						bean.setDevState(devState);
						// 同时更新车辆的信息防止变化引起的问题
						bean.setBusSelfCode(busSelfcode);
						bean.setBusNumber(busNumber);
						bean.setOrgUuid(orgUuid);
						bean.setOrgName(orgName);
						bean.setLineUuid(lineId);
						bean.setLineName(lineName);
						if (iControl.size() == 0) {
							bean.setUuid(PMSUtils.getUUID());
							bean.setWarnTime(new Date());
							bean.setDevUuid(dwDimOtherDevice.getDevUuid());
							bean.setDevCode(dwDimOtherDevice.getDevCode());
							bean.setDevModel(dwDimOtherDevice.getDevClassName());
							tSafeDeviceRidControlService.insert(bean);
						} else {
							bean.setUuid(iControl.get(0).getUuid());
							tSafeDeviceRidControlService.updateByPrimaryKeySelective(bean);
						}
					}

				}
			}

		}
		LOG.info("车辆设备脱管信息数据定时任务结束...");
	}
}
