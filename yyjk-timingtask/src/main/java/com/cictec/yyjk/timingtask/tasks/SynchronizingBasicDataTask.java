package com.cictec.yyjk.timingtask.tasks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.model.entity.DwDimBusDriver;
import com.cictec.yyjk.fatigue.service.DwDimBusDriverService;
import com.cictec.yyjk.timingtask.model.entity.DwDimBus;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLine;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLineDeviceId;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusStation;
import com.cictec.yyjk.timingtask.model.entity.DwDimBusSysOrg;
import com.cictec.yyjk.timingtask.model.entity.DwDimDevice;
import com.cictec.yyjk.timingtask.model.entity.DwDimLineStation;
import com.cictec.yyjk.timingtask.model.entity.DwDimMapLine;
import com.cictec.yyjk.timingtask.model.entity.TempBusSchedule;
import com.cictec.yyjk.timingtask.model.entity.TempBusScheduleDay;
import com.cictec.yyjk.timingtask.service.DwDimBusLineDeviceIdService;
import com.cictec.yyjk.timingtask.service.DwDimBusLineService;
import com.cictec.yyjk.timingtask.service.DwDimBusService;
import com.cictec.yyjk.timingtask.service.DwDimBusStationService;
import com.cictec.yyjk.timingtask.service.DwDimBusSysOrgService;
import com.cictec.yyjk.timingtask.service.DwDimDeviceService;
import com.cictec.yyjk.timingtask.service.DwDimLineStationService;
import com.cictec.yyjk.timingtask.service.DwDimMapLineService;
import com.cictec.yyjk.timingtask.service.TempBusScheduleDayService;
import com.cictec.yyjk.timingtask.service.TempBusScheduleService;

/**
 * 基础数据同步定时任务
 * 
 * 测试模式下只同步排班信息，否则同步所有基础数据
 * 
 * @author lenovo
 *
 */
@Component
public class SynchronizingBasicDataTask {
	private static final Logger LOG = LoggerFactory.getLogger(SynchronizingBasicDataTask.class);
	@Autowired
	private Environment env;
	@Autowired
	private DwDimBusSysOrgService dwDimBusSysOrgService;
	@Autowired
	private DwDimDeviceService dwDimDeviceService;
	@Autowired
	private DwDimBusService dwDimBusService;
	@Autowired
	private DwDimBusDriverService dwDimBusDriverService;
	@Autowired
	private DwDimBusStationService dwDimBusStationService;
	@Autowired
	private DwDimBusLineService dwDimBusLineService;
	@Autowired
	private TempBusScheduleService tempBusScheduleService;
	@Autowired
	private TempBusScheduleDayService tempBusScheduleDayService;
	@Autowired
	private DwDimMapLineService dwDimMapLineService;
	@Autowired
	private DwDimLineStationService dwDimLineStationService;
	@Autowired
	private DwDimBusLineDeviceIdService dwDimBusLineDeviceIdService;

	@Scheduled(cron = "${jobs.synchro.basedata}")
	public void start() {
		// 同步数据
		boolean res = SynchronizingDb();
		if (res) {
			LOG.info("数据同步成功！");
		} else {
			LOG.info("数据同步失败！");
		}

	}

	private boolean SynchronizingDb() {
		boolean res = true;
		String isInitBase = env.getProperty("is.init.basedata");
		// 如果true全部同步，否则只同步排班
		if ("true".equals(isInitBase)) {
			try {
				SynchronizingLineStationMapService();
			} catch (Exception ex) {
				LOG.error("同步线路站点及线网关系出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingBusScheduleService();
			} catch (Exception ex) {
				LOG.error("同步排班信息表出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingBusLineService();
			} catch (Exception ex) {
				LOG.error("同步线路信息表出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingBusStationService();
			} catch (Exception ex) {
				LOG.error("同步站点信息表出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingBusOrgService();
			} catch (Exception ex) {
				LOG.error("同步机构信息表出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingBusService();
			} catch (Exception ex) {
				LOG.error("同步车辆信息表出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingDriverService();
			} catch (Exception ex) {
				LOG.error("同步司机信息表出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingDeviceService();
			} catch (Exception ex) {
				LOG.error("同步车辆设备信息表出错!{}", ex);
				res = false;
			}
			try {
				SynchronizingLineDeviceIdsService();
			} catch (Exception ex) {
				LOG.error("同步线路设备信息关系表出错!{}", ex);
				res = false;
			}
		} else {
			try {
				SynchronizingBusScheduleService();
			} catch (Exception ex) {
				LOG.error("同步排班信息表出错!{}", ex);
				res = false;
			}
		}
		return res;
	}

	/**
	 * 同步线路站点及线网关系
	 */
	private void SynchronizingLineStationMapService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getLineStationList";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取线路站点及线网关系信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONObject obj = JSON.parseObject(result);
			if (obj == null) {
				LOG.info("没有获取到任何线路站点及线网关系信息 ");
			}
			// 解析线路机构信息
			if (obj != null && !obj.isEmpty()) {
				// 处理线网信息
				String lineMapStr = obj.getString("beanLineList");
				if (PMSUtils.isNotEmpty(lineMapStr)) {
					Map<String, DwDimMapLine> mapLineDisc = dwDimMapLineService.getMapLineDisc();
					Set<String> allMapLineInDb = mapLineDisc.keySet();
					// 保存同步源数据结构数据
					Set<String> srcMapLineSet = new HashSet<>();

					JSONArray lineMapList = JSON.parseArray(lineMapStr);
					if (lineMapList != null && lineMapList.size() > 0) {
						Iterator<Object> lineMap = lineMapList.iterator();
						while (lineMap.hasNext()) {
							String children = JSON.toJSONString(lineMap.next());
							DwDimMapLine dwDimMapLine = JSON.parseObject(children, DwDimMapLine.class);
							String mlUuid = dwDimMapLine.getMlUuid();
							// 如果待同步数据在数据库中存在
							srcMapLineSet.add(mlUuid);
							if (allMapLineInDb.contains(mlUuid)) {
								if (dwDimMapLine.equals(mapLineDisc.get(mlUuid))) {// 且内容相同，直接跳过
									continue;
								} else {
									dwDimMapLineService.updateByPrimaryKey(dwDimMapLine);
								}
							} else {// 如果待同步数据数据库中还没有，则直接插入
								try {
									dwDimMapLineService.insertSelective(dwDimMapLine);
								} catch (DuplicateKeyException ex) {
									LOG.info("拐点信息主键冲突！冲突主键{}", mlUuid);
								}
							}
						}
						// 删除源数据表已删除的记录
						if (allMapLineInDb != null && allMapLineInDb.size() > 0) {
							if (allMapLineInDb.removeAll(srcMapLineSet)) {
								Iterator<String> iterator = allMapLineInDb.iterator();
								while (iterator.hasNext()) {
									String mlUuid = iterator.next();
									dwDimMapLineService.deleteByPrimaryKey(mlUuid);
								}
							}
						}
					}
				}

				// 处理线路站点信息
				String lineStationStr = obj.getString("beanStationList");
				JSONArray downList = JSON.parseArray(lineStationStr);
				if (downList != null && downList.size() > 0) {
					Map<String, DwDimLineStation> lineStaDisc = dwDimLineStationService.getLineStaDisc();
					Set<String> allLineStaInDb = lineStaDisc.keySet();
					// 保存同步源数据结构数据
					Set<String> srcLineStaSet = new HashSet<>();

					Iterator<Object> childrens = downList.iterator();
					while (childrens.hasNext()) {
						String children = JSON.toJSONString(childrens.next());
						DwDimLineStation dwDimLineStation = JSON.parseObject(children, DwDimLineStation.class);
						String lsUuid = dwDimLineStation.getLsUuid();
						// 如果待同步数据在数据库中存在
						srcLineStaSet.add(lsUuid);
						if (allLineStaInDb.contains(lsUuid)) {
							if (dwDimLineStation.equals(lineStaDisc.get(lsUuid))) {// 且内容相同，直接跳过
								continue;
							} else {
								dwDimLineStationService.updateByPrimaryKey(dwDimLineStation);
							}
						} else {// 如果待同步数据数据库中还没有，则直接插入
							try {
								dwDimLineStationService.insertSelective(dwDimLineStation);
							} catch (DuplicateKeyException ex) {
								LOG.info("线路站点信息主键冲突！冲突主键{}", lsUuid);
							}
						}
					}

					// 删除源数据表已删除的记录
					if (allLineStaInDb != null && allLineStaInDb.size() > 0) {
						if (allLineStaInDb.removeAll(srcLineStaSet)) {
							Iterator<String> iterator = allLineStaInDb.iterator();
							while (iterator.hasNext()) {
								String lsUuid = iterator.next();
								dwDimLineStationService.deleteByPrimaryKey(lsUuid);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 同步排班数据
	 */
	private void SynchronizingBusScheduleService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getBusschdule";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取排班信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONObject obj = (JSONObject) JSONObject.parse(result);
			if (obj == null) {
				LOG.info("没有获取到任何排班信息 ");
			}
			Map<String, TempBusSchedule> scheduleDisc = tempBusScheduleService.getScheduleDisc();
			Set<String> allScheduleInDb = scheduleDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcScheduleSet = new HashSet<>();
			// 保存排班计划主表信息
			String busScheduleStr = obj.getString("tempBusSchedule");
			if (PMSUtils.isNotEmpty(busScheduleStr)) {
				JSONArray arrys = JSON.parseArray(busScheduleStr);
				if (arrys != null && arrys.size() > 0) {
					Iterator<Object> iterator = arrys.iterator();
					while (iterator.hasNext()) {
						String next = JSON.toJSONString(iterator.next());
						TempBusSchedule tempBusSchedule = JSON.parseObject(next, TempBusSchedule.class);
						String scheduleUuid = tempBusSchedule.getBsUuid();
						// 如果待同步数据在数据库中存在
						srcScheduleSet.add(scheduleUuid);
						if (allScheduleInDb.contains(scheduleUuid)) {
							if (tempBusSchedule.equals(scheduleDisc.get(scheduleUuid))) {// 且内容相同，直接跳过
								continue;
							} else {
								tempBusScheduleService.updateByPrimaryKey(tempBusSchedule);
							}
						} else {// 如果待同步数据数据库中还没有，则直接插入
							tempBusScheduleService.insertSelective(tempBusSchedule);
						}
					}
				}
				// 删除源数据表已删除的记录
				if (allScheduleInDb != null && allScheduleInDb.size() > 0) {
					if (allScheduleInDb.removeAll(srcScheduleSet)) {
						Iterator<String> iterator = allScheduleInDb.iterator();
						while (iterator.hasNext()) {
							String scheduleUuid = iterator.next();
							tempBusScheduleService.deleteByPrimaryKey(scheduleUuid);
						}
					}
				}
			}
			// 保存排班计划子表信息
			String busScheduleDayStr = obj.getString("tempBusScheduleDay");
			if (PMSUtils.isNotEmpty(busScheduleDayStr)) {
				JSONArray arrys = JSON.parseArray(busScheduleDayStr);
				if (arrys != null && arrys.size() > 0) {
					// 排班计划表子表由于没有主键，每次都是先清空表，后插入
					tempBusScheduleDayService.clearTabel();

					Iterator<Object> iterator = arrys.iterator();
					while (iterator.hasNext()) {
						String children = JSON.toJSONString(iterator.next());
						TempBusScheduleDay tempBusScheduleDay = JSON.parseObject(children, TempBusScheduleDay.class);
						tempBusScheduleDay.setBsdUuid(UUIDGenerator.genUuidStr());
						// 直接插入
						tempBusScheduleDayService.insertSelective(tempBusScheduleDay);
					}
				}
			}
		}
	}

	/**
	 * 同步线路信息表
	 * 
	 * 注意：线路的发车类型从排班信息中实时获取
	 */
	private void SynchronizingBusLineService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getLineList";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取线路信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONArray arrys = JSON.parseArray(result);
			if (arrys == null || (arrys != null && arrys.size() == 0)) {
				LOG.info("没有获取到任何线路信息 ");
			}
			Map<String, DwDimBusLine> lineDisc = dwDimBusLineService.getLineDisc();
			Set<String> allLineInDb = lineDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcLineSet = new HashSet<>();
			if (arrys != null && !arrys.isEmpty()) {
				Iterator<Object> iterator = arrys.iterator();
				while (iterator.hasNext()) {
					String next = JSON.toJSONString(iterator.next());
					DwDimBusLine dwDimBusLine = JSON.parseObject(next, DwDimBusLine.class);
					String lineUuid = dwDimBusLine.getLineUuid();
					// 如果待同步数据在数据库中存在
					srcLineSet.add(lineUuid);
					if (allLineInDb.contains(lineUuid)) {
						if (dwDimBusLine.equals(lineDisc.get(lineUuid))) {// 且内容相同，直接跳过
							continue;
						} else {
							dwDimBusLineService.updateByPrimaryKey(dwDimBusLine);
						}
					} else {// 如果待同步数据数据库中还没有，则直接插入
						dwDimBusLineService.insertSelective(dwDimBusLine);
					}
				}
			}
			// 删除源数据表已删除的记录
			if (allLineInDb != null && allLineInDb.size() > 0) {
				if (allLineInDb.removeAll(srcLineSet)) {
					Iterator<String> iterator = allLineInDb.iterator();
					while (iterator.hasNext()) {
						String lineUuid = iterator.next();
						dwDimBusLineService.deleteByPrimaryKey(lineUuid);
					}
				}
			}
		}
	}

	/**
	 * 同步站点信息表
	 */
	private void SynchronizingBusStationService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getStationsList";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取站点信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONArray arrys = JSON.parseArray(result);
			if (arrys == null || (arrys != null && arrys.size() == 0)) {
				LOG.info("没有获取到任何站点信息 ");
			}
			Map<String, DwDimBusStation> staDisc = dwDimBusStationService.getStationDisc();
			Set<String> allStaInDb = staDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcStaSet = new HashSet<>();
			if (arrys != null && !arrys.isEmpty()) {
				Iterator<Object> iterator = arrys.iterator();
				while (iterator.hasNext()) {
					String next = JSON.toJSONString(iterator.next());
					DwDimBusStation record = JSON.parseObject(next, DwDimBusStation.class);
					String staUuid = record.getStaUuid();
					// 如果待同步数据在数据库中存在
					srcStaSet.add(staUuid);
					if (allStaInDb.contains(staUuid)) {
						if (record.equals(staDisc.get(staUuid))) {// 且内容相同，直接跳过
							continue;
						} else {
							dwDimBusStationService.updateByPrimaryKey(record);
						}
					} else {// 如果待同步数据数据库中还没有，则直接插入
						dwDimBusStationService.insertSelective(record);
					}
				}
			}
			// 删除源数据表已删除的记录
			if (allStaInDb != null && allStaInDb.size() > 0) {
				if (allStaInDb.removeAll(srcStaSet)) {
					Iterator<String> iterator = allStaInDb.iterator();
					while (iterator.hasNext()) {
						String staUuid = iterator.next();
						dwDimBusStationService.deleteByPrimaryKey(staUuid);
					}
				}
			}
		}
	}

	/**
	 * 同步机构信息表
	 */
	private void SynchronizingBusOrgService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getOrgList";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取车辆到站时刻信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONArray arrys = JSON.parseArray(result);
			if (arrys == null || (arrys != null && arrys.size() == 0)) {
				LOG.info("没有获取到任何机构信息 ");
			}
			Map<String, DwDimBusSysOrg> orgDisc = dwDimBusSysOrgService.getBusSysOrgDisc();
			Set<String> allOrgInDb = orgDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcOrgSet = new HashSet<>();
			if (arrys != null && !arrys.isEmpty()) {
				Iterator<Object> iterator = arrys.iterator();
				while (iterator.hasNext()) {
					String next = JSON.toJSONString(iterator.next());
					DwDimBusSysOrg record = JSON.parseObject(next, DwDimBusSysOrg.class);
					String orgUuid = record.getOrgUuid();
					// 如果待同步数据在数据库中存在
					srcOrgSet.add(orgUuid);
					if (allOrgInDb.contains(orgUuid)) {
						if (record.equals(orgDisc.get(orgUuid))) {// 且内容相同，直接跳过
							continue;
						} else {
							dwDimBusSysOrgService.updateByPrimaryKey(record);
						}
					} else {// 如果待同步数据数据库中还没有，则直接插入
						dwDimBusSysOrgService.insertSelective(record);
					}
				}
			}
			// 删除源数据表已删除的记录
			if (allOrgInDb != null && allOrgInDb.size() > 0) {
				if (allOrgInDb.removeAll(srcOrgSet)) {
					Iterator<String> iterator = allOrgInDb.iterator();
					while (iterator.hasNext()) {
						String orgUuid = iterator.next();
						dwDimBusSysOrgService.deleteByPrimaryKey(orgUuid);
					}
				}
			}
		}
	}

	/**
	 * 同步车辆信息表
	 */
	private void SynchronizingBusService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getBusList";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取车辆信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONArray arrys = JSON.parseArray(result);
			if (arrys == null || (arrys != null && arrys.size() == 0)) {
				LOG.info("没有获取到任何车辆信息 ");
			}
			Map<String, DwDimBus> busDisc = dwDimBusService.getBusDisc();
			Set<String> allBusInDb = busDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcBusSet = new HashSet<>();
			if (arrys != null && !arrys.isEmpty()) {
				Iterator<Object> iterator = arrys.iterator();
				while (iterator.hasNext()) {
					String next = JSON.toJSONString(iterator.next());
					DwDimBus record = JSON.parseObject(next, DwDimBus.class);
					String busUuid = record.getBusUuid();
					// 如果待同步数据在数据库中存在
					srcBusSet.add(busUuid);
					if (allBusInDb.contains(busUuid)) {
						if (record.equals(busDisc.get(busUuid))) {// 且内容相同，直接跳过
							continue;
						} else {
							dwDimBusService.updateByPrimaryKey(record);
						}
					} else {// 如果待同步数据数据库中还没有，则直接插入
						dwDimBusService.insertSelective(record);
					}
				}
			}
			// 删除源数据表已删除的记录
			if (allBusInDb != null && allBusInDb.size() > 0) {
				if (allBusInDb.removeAll(srcBusSet)) {
					Iterator<String> iterator = allBusInDb.iterator();
					while (iterator.hasNext()) {
						String busUuid = iterator.next();
						dwDimBusService.deleteByPrimaryKey(busUuid);
					}
				}
			}
		}
	}

	/**
	 * 同步司机信息表
	 */
	private void SynchronizingDriverService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getDrvList";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取司机信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONArray arrys = JSON.parseArray(result);
			if (arrys == null || (arrys != null && arrys.size() == 0)) {
				LOG.info("没有获取到任何司机信息 ");
			}
			Map<String, DwDimBusDriver> driverDisc = dwDimBusDriverService.getDriverDisc();
			Set<String> allDriverInDb = driverDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcDriverSet = new HashSet<>();
			if (arrys != null && !arrys.isEmpty()) {
				Iterator<Object> iterator = arrys.iterator();
				while (iterator.hasNext()) {
					String next = JSON.toJSONString(iterator.next());
					DwDimBusDriver record = JSON.parseObject(next, DwDimBusDriver.class);
					String drvUuid = record.getDrvUuid();
					// 如果待同步数据在数据库中存在
					srcDriverSet.add(drvUuid);
					if (allDriverInDb.contains(drvUuid)) {
						if (record.equals(driverDisc.get(drvUuid))) {// 且内容相同，直接跳过
							continue;
						} else {
							dwDimBusDriverService.updateByPrimaryKey(record);
						}
					} else {// 如果待同步数据数据库中还没有，则直接插入
						dwDimBusDriverService.insertSelective(record);
					}
				}
			}
			// 删除源数据表已删除的记录
			if (allDriverInDb != null && allDriverInDb.size() > 0) {
				if (allDriverInDb.removeAll(srcDriverSet)) {
					Iterator<String> iterator = allDriverInDb.iterator();
					while (iterator.hasNext()) {
						String drvUuid = iterator.next();
						dwDimBusDriverService.deleteByPrimaryKey(drvUuid);
					}
				}
			}
		}
	}

	/**
	 * 同步车辆设备信息表
	 */
	private void SynchronizingDeviceService() throws Exception {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getDevList";
		String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取车辆设备信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONArray arrys = JSON.parseArray(result);
			if (arrys == null || (arrys != null && arrys.size() == 0)) {
				LOG.info("没有获取到任何车辆设备信息 ");
			}
			Map<String, DwDimDevice> deviceDisc = dwDimDeviceService.getDeviceDisc();
			Set<String> allDeviceInDb = deviceDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcDeviceSet = new HashSet<>();
			if (arrys != null && !arrys.isEmpty()) {
				Iterator<Object> iterator = arrys.iterator();
				while (iterator.hasNext()) {
					String next = JSON.toJSONString(iterator.next());
					DwDimDevice record = JSON.parseObject(next, DwDimDevice.class);
					String devUuid = record.getDevUuid();
					// 如果待同步数据在数据库中存在
					srcDeviceSet.add(devUuid);
					if (allDeviceInDb.contains(devUuid)) {
						if (record.equals(deviceDisc.get(devUuid))) {// 且内容相同，直接跳过
							continue;
						} else {
							dwDimDeviceService.updateByPrimaryKey(record);
						}
					} else {// 如果待同步数据数据库中还没有，则直接插入
						dwDimDeviceService.insertSelective(record);
					}
				}
			}
			// 删除源数据表已删除的记录
			if (allDeviceInDb != null && allDeviceInDb.size() > 0) {
				if (allDeviceInDb.removeAll(srcDeviceSet)) {
					Iterator<String> iterator = allDeviceInDb.iterator();
					while (iterator.hasNext()) {
						String devUuid = iterator.next();
						dwDimDeviceService.deleteByPrimaryKey(devUuid);
					}
				}
			}
		}
	}

	/**
	 * 同步线路设备关系表
	 */
	private void SynchronizingLineDeviceIdsService() {
		String httpUrl = env.getProperty("gjdd.http.url") + "/deviceNumMultiYb";
		String result = RestUtils.getRestData(httpUrl);
		// String result = RestUtils.getPostData(httpUrl, null, false);
		LOG.info("通过http获取线路设备关系信息 url:{},result:{}", httpUrl, result.length());
		if (PMSUtils.isNotEmpty(result)) {
			JSONArray arrys = JSON.parseArray(result);
			if (arrys == null || (arrys != null && arrys.size() == 0)) {
				LOG.info("没有获取到任何线路设备关系信息 ");
			}
			Map<String, DwDimBusLineDeviceId> deviceDisc = dwDimBusLineDeviceIdService.getLineDeviceIdDisc();
			Set<String> allLineDeviceIdInDb = deviceDisc.keySet();
			// 保存同步源数据结构数据
			Set<String> srcLineDeviceIdSet = new HashSet<>();
			if (arrys != null && !arrys.isEmpty()) {
				Iterator<Object> iterator = arrys.iterator();
				while (iterator.hasNext()) {
					String next = JSON.toJSONString(iterator.next());
					DwDimBusLineDeviceId record = JSON.parseObject(next, DwDimBusLineDeviceId.class);
					String bldUuid = record.getBldUuid();
					// 如果待同步数据在数据库中存在
					srcLineDeviceIdSet.add(bldUuid);
					if (allLineDeviceIdInDb.contains(bldUuid)) {
						if (record.equals(deviceDisc.get(bldUuid))) {// 且内容相同，直接跳过
							continue;
						} else {
							dwDimBusLineDeviceIdService.updateByPrimaryKey(record);
						}
					} else {// 如果待同步数据数据库中还没有，则直接插入
						dwDimBusLineDeviceIdService.insertSelective(record);
					}
				}
			}
			// 删除源数据表已删除的记录
			if (allLineDeviceIdInDb != null && allLineDeviceIdInDb.size() > 0) {
				if (allLineDeviceIdInDb.removeAll(srcLineDeviceIdSet)) {
					Iterator<String> iterator = allLineDeviceIdInDb.iterator();
					while (iterator.hasNext()) {
						String bldUuid = iterator.next();
						dwDimBusLineDeviceIdService.deleteByPrimaryKey(bldUuid);
					}
				}
			}
		}
	}

}
