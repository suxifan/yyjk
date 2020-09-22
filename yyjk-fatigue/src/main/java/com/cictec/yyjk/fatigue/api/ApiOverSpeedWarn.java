package com.cictec.yyjk.fatigue.api;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.mapper.TWarnMediaMapper;
import com.cictec.yyjk.fatigue.model.entity.PositionInfo;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.model.entity.TWarnMedia;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;
import com.cictec.yyjk.fatigue.model.view.Recorder;
import com.cictec.yyjk.fatigue.service.TWarnService;
import com.cictec.yyjk.fatigue.service.TempBusOverWarnTrailService;

@RestController
@RequestMapping("/warns")
public class ApiOverSpeedWarn{
	private static final Logger LOG = LoggerFactory.getLogger(ApiOverSpeedWarn.class);

	@Autowired
	private TWarnService warnService;

	@Autowired
	private TempBusOverWarnTrailService overWarnTrailService;
	@Autowired
	private TWarnMediaMapper tWarnMediaMapper;

	/**
	 * test1
	 */
	@PostMapping("/overSpeed/test1")
	public Result overSpeedTest1() {
		Map<String, String> devInfoDisc = new HashMap<>();
		devInfoDisc.put("1000", "00308900679");
		devInfoDisc.put("1002", "00308900527");
		devInfoDisc.put("1004", "00308900699");
		devInfoDisc.put("1005", "00308900616");
		devInfoDisc.put("1007", "00308900335");
		devInfoDisc.put("999", "00308900123");
		devInfoDisc.put("982", "00308900678");

		String deviceId = "982";
		List<PositionInfo> list = initDatas1(deviceId);
		Map<String, List<TWarn>> busMap = new HashMap<>();
		Map<String, Recorder> busTimesMap = new HashMap<>();
		try {
			for (PositionInfo positionInfo : list) {
				positionInfoHandle2(busTimesMap, busMap, positionInfo, devInfoDisc, 6, warnService,
						overWarnTrailService, tWarnMediaMapper);
			}
		} catch (Exception ex) {
			LOG.error("处理超速报警异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/overSpeed/test2")
	public Result overSpeedTest2() {
		Map<String, String> devInfoDisc = new HashMap<>();
		devInfoDisc.put("1000", "00308900679");
		devInfoDisc.put("1002", "00308900527");
		devInfoDisc.put("1004", "00308900699");
		devInfoDisc.put("1005", "00308900616");
		devInfoDisc.put("1007", "00308900335");
		devInfoDisc.put("999", "00308900123");

		String deviceId = "999";
		List<PositionInfo> list = initDatas2(deviceId);
		Map<String, List<TWarn>> busMap = new HashMap<>();
		Map<String, Recorder> busTimesMap = new HashMap<>();
		try {
			for (PositionInfo positionInfo : list) {
				positionInfoHandle2(busTimesMap, busMap, positionInfo, devInfoDisc, 6, warnService,
						overWarnTrailService, tWarnMediaMapper);
			}
		} catch (Exception ex) {
			LOG.error("处理超速报警异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/overSpeed/test3")
	public Result overSpeedTest3() {
		Map<String, String> devInfoDisc = new HashMap<>();
		devInfoDisc.put("1000", "00308900679");
		devInfoDisc.put("1002", "00308900527");
		devInfoDisc.put("1004", "00308900699");
		devInfoDisc.put("1005", "00308900616");
		devInfoDisc.put("1007", "00308900335");
		devInfoDisc.put("999", "00308900123");

		String deviceId = "999";
		List<PositionInfo> list = initDatas3(deviceId);
		Map<String, List<TWarn>> busMap = new HashMap<>();
		Map<String, Recorder> busTimesMap = new HashMap<>();
		try {
			for (PositionInfo positionInfo : list) {
				positionInfoHandle2(busTimesMap, busMap, positionInfo, devInfoDisc, 6, warnService,
						overWarnTrailService, tWarnMediaMapper);
			}
		} catch (Exception ex) {
			LOG.error("处理超速报警异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/overSpeed/test4")
	public Result overSpeedTest4() {
		Map<String, String> devInfoDisc = new HashMap<>();
		devInfoDisc.put("1000", "00308900679");
		devInfoDisc.put("1002", "00308900527");
		devInfoDisc.put("1004", "00308900699");
		devInfoDisc.put("1005", "00308900616");
		devInfoDisc.put("1007", "00308900335");

		String deviceId = "1000";
		List<PositionInfo> list = initDatas4(deviceId);
		Map<String, List<TWarn>> busMap = new HashMap<>();
		Map<String, Recorder> busTimesMap = new HashMap<>();
		try {
			for (PositionInfo positionInfo : list) {
				positionInfoHandle2(busTimesMap, busMap, positionInfo, devInfoDisc, 6, warnService,
						overWarnTrailService, tWarnMediaMapper);
			}
		} catch (Exception ex) {
			LOG.error("处理超速报警异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/overSpeed/test5")
	public Result overSpeedTest5() {
		Map<String, String> devInfoDisc = new HashMap<>();
		devInfoDisc.put("1000", "00308900679");
		devInfoDisc.put("1002", "00308900527");
		devInfoDisc.put("1004", "00308900699");
		devInfoDisc.put("1005", "00308900616");
		devInfoDisc.put("1007", "00308900335");

		String deviceId = "1000";
		List<PositionInfo> list = initDatas5(deviceId);
		Map<String, List<TWarn>> busMap = new HashMap<>();
		Map<String, Recorder> busTimesMap = new HashMap<>();
		try {
			for (PositionInfo positionInfo : list) {
				positionInfoHandle2(busTimesMap, busMap, positionInfo, devInfoDisc, 6, warnService,
						overWarnTrailService, tWarnMediaMapper);
			}
		} catch (Exception ex) {
			LOG.error("处理超速报警异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/overSpeed/test6")
	public Result overSpeedTest6() {
		Map<String, String> devInfoDisc = new HashMap<>();
		devInfoDisc.put("1000", "00308900679");
		devInfoDisc.put("1002", "00308900527");
		devInfoDisc.put("1004", "00308900699");
		devInfoDisc.put("1005", "00308900616");
		devInfoDisc.put("1007", "00308900335");

		String deviceId = "1000";
		List<PositionInfo> list = initDatas6(deviceId);
		Map<String, List<TWarn>> busMap = new HashMap<>();
		Map<String, Recorder> busTimesMap = new HashMap<>();
		try {
			for (PositionInfo positionInfo : list) {
				positionInfoHandle2(busTimesMap, busMap, positionInfo, devInfoDisc, 6, warnService,
						overWarnTrailService, tWarnMediaMapper);
			}
		} catch (Exception ex) {
			LOG.error("处理超速报警异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult();
	}

	
	@PostMapping("/overSpeed/test7")
	public Result overSpeedTest7() {
		Map<String, String> devInfoDisc = new HashMap<>();
		devInfoDisc.put("1000", "00308900679");
		devInfoDisc.put("1002", "00308900527");
		devInfoDisc.put("1004", "00308900699");
		devInfoDisc.put("1005", "00308900616");
		devInfoDisc.put("127", "00308900383");

		List<PositionInfo> list = initDatas7();
		Map<String, List<TWarn>> busMap = new HashMap<>();
		Map<String, Recorder> busTimesMap = new HashMap<>();
		try {
			for (PositionInfo positionInfo : list) {
				positionInfoHandle2(busTimesMap, busMap, positionInfo, devInfoDisc, 6, warnService,
						overWarnTrailService, tWarnMediaMapper);
			}
		} catch (Exception ex) {
			LOG.error("处理超速报警异常，原因{}", ex);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult();
	}
	
	
	/**
	 * 报警信息处理器
	 * 
	 * @param positionInfo
	 *            解析的一个位置信息
	 * @param devInfoDisc
	 *            设备字典信息
	 * @param noOverSpeedNodeNumber
	 *            30秒内 非超速报警位置点个数
	 * @param Map<String,
	 *            Recorder> busTimesMap 超速报警次数字典，记录前30秒非超速报警点个数及超速报警点个数
	 * 
	 *            String 车牌号
	 * 
	 *            recorder
	 *            两个属性，startNoOverTimes:记录超速前30秒中内位置点个数；overTimes：记录超速报警点个数
	 * @param Map<String,
	 *            List<TWarn>> busMap
	 * 
	 *            超速报警字典，记录车辆超速报警明细
	 * 
	 *            String 设备号
	 * 
	 *            List 车辆位置点报警信息（转换后TWarn）前30位置信息+报警信息+后30秒位置信息，也就是保存一条报警完整轨迹信息
	 * 
	 * @param warnService
	 * 
	 * @param overWarnTrailService
	 * 
	 *            注：由于是静态方法，非静态方法需要参数传递，如果改为非静态方法，这2个service方法参数可以删除
	 * 
	 * @throws ParseException
	 * 
	 */

	private static void positionInfoHandle(Map<String, Recorder> busTimesMap, Map<String, List<TWarn>> busMap,
			PositionInfo positionInfo, Map<String, String> devInfoDisc,
			Integer noOverSpeedNodeNumber, TWarnService warnService,
			TempBusOverWarnTrailService overWarnTrailService, TWarnMediaMapper tWarnMediaMapper) throws Exception {

		
		String deviceId = positionInfo.getTerminalId();
		String deviceCode = devInfoDisc.get(positionInfo.getTerminalId());
		
		// 将位置点信息转换为报警信息
		TWarn warn = new TWarn(UUIDGenerator.genUuidStr(), deviceId, deviceCode, "OVERSPEED",
				positionInfo.getSendtime(), positionInfo.getCreatetime(), positionInfo.getLat() + "",
				positionInfo.getLng() + "", positionInfo.getSpeed() + "",
				DateUtils.parseDate(DateUtils.formatDate(positionInfo.getCreatetime())), "1");
		// 根据设备号将车辆报警存入字典中
		if (busMap.containsKey(deviceId)) {
			List<TWarn> list = busMap.get(deviceId);
			int startNoOverTimes = busTimesMap.get(deviceId).getStartNoOverTimes();
			int overTimes = busTimesMap.get(deviceId).getOverTimes();
			int endNoOverTimes = busTimesMap.get(deviceId).getEndNoOverTimes();
			if (!positionInfo.isOverSpeed()) {// 非超速报警
				// 处理第一段非超速位置点
				if (overTimes == 0) {
					// 轨迹数组长度小于30秒内 非超速报警位置点个数，直接插入
					if ((startNoOverTimes + 1) <= noOverSpeedNodeNumber) {
						list.add(warn);
						busTimesMap.get(deviceId).setStartNoOverTimes(startNoOverTimes + 1);
					}
					if ((startNoOverTimes + 1) > noOverSpeedNodeNumber) {// 否则删除第一个报警信息，再插入新的报警信息
						list.remove(0);
						list.add(warn);
						busTimesMap.get(deviceId).setStartNoOverTimes(noOverSpeedNodeNumber);
					}
				} else {// 处理第二段非超速报警位置点
					// 第二段非超速开始位置
					int secondNoOverSpeedStartIndex = startNoOverTimes + overTimes;
					// 第二段非超速结束位置
					int secondNoOverSpeedEndIndex = startNoOverTimes + overTimes + noOverSpeedNodeNumber;
					// 将最后一个节点插入轨迹列表，计算超速报警起止时间并插入报警表，将轨迹列表中的数据插入轨迹表，清空字典中该设备号信息

					// 注意，这两个if位置不能调，先判断等于
					if ((list.size() + 1) > secondNoOverSpeedStartIndex
							&& (list.size() + 1) == secondNoOverSpeedEndIndex) {
						list.add(warn);
						// 计算超速报警起止时间并插入报警表
						TWarn startOverSpeedBean = list.get(startNoOverTimes);
						TWarn endOverSpeedBean = list.get(secondNoOverSpeedStartIndex - 1);
						startOverSpeedBean.setWarnEndTime(endOverSpeedBean.getWarnTime());
						startOverSpeedBean.setWarnEndLat(endOverSpeedBean.getLat());
						startOverSpeedBean.setWarnEndLng(endOverSpeedBean.getLng());
						warnService.insertSelective(startOverSpeedBean);
						// TODO 插入附件表，方便疲劳报警统计逻辑
						TWarnMedia mediaBean = new TWarnMedia(UUIDGenerator.genUuidStr(),
								startOverSpeedBean.getWarnUuid(), startOverSpeedBean.getCreateTime(),
								startOverSpeedBean.getWarnDate());
						tWarnMediaMapper.insertSelective(mediaBean);
						// 将轨迹列表中的数据插入轨迹表
						for (TWarn tWarn : list) {
							TempBusOverWarnTrail overWarnTrail = new TempBusOverWarnTrail();
							BeanUtils.copyProperties(tWarn, overWarnTrail);
							// TODO添加外键
							overWarnTrail.setFkWarnUuid(startOverSpeedBean.getWarnUuid());
							overWarnTrailService.insertSelective(overWarnTrail);
						}
						// 清空字典中该设备号信息
						busMap.remove(deviceId);
					}
					if ((list.size() + 1) > secondNoOverSpeedStartIndex
							&& (list.size() + 1) < secondNoOverSpeedEndIndex) {
						list.add(warn);
						busTimesMap.get(deviceId).setEndNoOverTimes(endNoOverTimes + 1);
					}
				}
			} else {// 超速报警
				// 没有第二段非超速报警,直接插入超速报警点
				if (endNoOverTimes == 0) {
					list.add(warn);
					busTimesMap.get(deviceId).setOverTimes(overTimes + 1);
				} else {
					// 如果第二段超速开始了，且第二段非超速报警小时设置的非超速报警阈值
					if (endNoOverTimes < noOverSpeedNodeNumber) {
						// 第二段非超速开始位置
						int secondNoOverSpeedStartIndex = startNoOverTimes + overTimes;
						// 计算超速报警起止时间并插入报警表
						TWarn startOverSpeedBean = list.get(startNoOverTimes);
						TWarn endOverSpeedBean = list.get(secondNoOverSpeedStartIndex - 1);
						startOverSpeedBean.setWarnEndTime(endOverSpeedBean.getWarnTime());
						startOverSpeedBean.setWarnEndLat(endOverSpeedBean.getLat());
						startOverSpeedBean.setWarnEndLng(endOverSpeedBean.getLng());
						warnService.insertSelective(startOverSpeedBean);
						// TODO 插入附件表，方便疲劳报警统计逻辑
						TWarnMedia mediaBean = new TWarnMedia(UUIDGenerator.genUuidStr(),
								startOverSpeedBean.getWarnUuid(), startOverSpeedBean.getCreateTime(),
								startOverSpeedBean.getWarnDate());
						tWarnMediaMapper.insertSelective(mediaBean);
						// 将轨迹列表中的数据插入轨迹表
						for (TWarn tWarn : list) {
							TempBusOverWarnTrail overWarnTrail = new TempBusOverWarnTrail();
							BeanUtils.copyProperties(tWarn, overWarnTrail);
							// TODO添加外键
							overWarnTrail.setFkWarnUuid(startOverSpeedBean.getWarnUuid());
							overWarnTrailService.insertSelective(overWarnTrail);
						}
						// 将轨迹表前面非超速报警及超速报警数据删除，保留第二段非超速报警，作为下一次报警的第一段非超速报警
						for (int i = 0; i < secondNoOverSpeedStartIndex; i++) {
							list.remove(0);
						}
						// 重新设置主键
						for (TWarn tWarn : list) {
							tWarn.setWarnUuid(UUIDGenerator.genUuidStr());
						}
						// 插入超速点
						list.add(warn);
						// 重置计数器（下一次轨迹开始）
						busTimesMap.put(deviceId, new Recorder((list.size() - 1), 1, 0,0));
					}
				}
			}
		} else {
			List<TWarn> list = new LinkedList<>();
			list.add(warn);
			// 初始化计数器
			if (positionInfo.isOverSpeed()) {
				busTimesMap.put(deviceId, new Recorder(0, 1, 0, 0));
			} else {
				busTimesMap.put(deviceId, new Recorder(1, 0, 0, 0));
			}
			busMap.put(deviceId, list);
		}

	}

	private static void positionInfoHandle2(Map<String, Recorder> busTimesMap, Map<String, List<TWarn>> busMap,
			PositionInfo positionInfo, Map<String, String> devInfoDisc, Integer noOverSpeedNodeNumber,
			TWarnService warnService, TempBusOverWarnTrailService overWarnTrailService,
			TWarnMediaMapper tWarnMediaMapper) throws Exception {

		String deviceId = positionInfo.getTerminalId();
		String deviceCode = devInfoDisc.get(positionInfo.getTerminalId());

		// 将位置点信息转换为报警信息
		TWarn warn = new TWarn(UUIDGenerator.genUuidStr(), deviceId, deviceCode, "OVERSPEED",
				positionInfo.getSendtime(),
				positionInfo.getCreatetime(), positionInfo.getLat() + "",
				positionInfo.getLng() + "", positionInfo.getSpeed() + "",
				DateUtils.parseDate(DateUtils.formatDate(positionInfo.getCreatetime())), "1");
		// 根据设备号将车辆报警存入字典中
		if (busMap.containsKey(deviceId)) {
			List<TWarn> list = busMap.get(deviceId);
			int startNoOverTimes = busTimesMap.get(deviceId).getStartNoOverTimes();
			int overTimes = busTimesMap.get(deviceId).getOverTimes();
			int endNoOverTimes = busTimesMap.get(deviceId).getEndNoOverTimes();
			int endOverTimes = busTimesMap.get(deviceId).getEndOverTimes();
			if (!positionInfo.isOverSpeed()) {// 非超速报警
				// 处理第一段非超速位置点
				if (overTimes == 0) {
					// 轨迹数组长度小于30秒内 非超速报警位置点个数，直接插入
					if ((startNoOverTimes + 1) <= noOverSpeedNodeNumber) {
						list.add(warn);
						busTimesMap.get(deviceId).setStartNoOverTimes(startNoOverTimes + 1);
					}
					if ((startNoOverTimes + 1) > noOverSpeedNodeNumber) {// 否则删除第一个报警信息，再插入新的报警信息
						list.remove(0);
						list.add(warn);
						busTimesMap.get(deviceId).setStartNoOverTimes(noOverSpeedNodeNumber);
					}
				} else {// 处理第二段非超速报警位置点
					// 将最后一个节点插入轨迹列表，计算超速报警起止时间并插入报警表，将轨迹列表中的数据插入轨迹表，清空字典中该设备号信息
					if (endNoOverTimes == noOverSpeedNodeNumber) {
						// 第二段非超速开始位置
						int secondNoOverSpeedStartIndex = startNoOverTimes + overTimes;
						// 计算超速报警起止时间并插入报警表
						TWarn startOverSpeedBean = list.get(startNoOverTimes);
						TWarn endOverSpeedBean = list.get(secondNoOverSpeedStartIndex - 1);
						startOverSpeedBean.setWarnEndTime(endOverSpeedBean.getWarnTime());
						startOverSpeedBean.setWarnEndLat(endOverSpeedBean.getLat());
						startOverSpeedBean.setWarnEndLng(endOverSpeedBean.getLng());
						warnService.insertSelective(startOverSpeedBean);
						// 插入附件表，方便疲劳报警统计逻辑
						TWarnMedia mediaBean = new TWarnMedia(UUIDGenerator.genUuidStr(),
								startOverSpeedBean.getWarnUuid(), startOverSpeedBean.getCreateTime(),
								startOverSpeedBean.getWarnDate());
						tWarnMediaMapper.insertSelective(mediaBean);
						// 将轨迹列表中的数据插入轨迹表
						for (TWarn tWarn : list) {
							TempBusOverWarnTrail overWarnTrail = new TempBusOverWarnTrail();
							BeanUtils.copyProperties(tWarn, overWarnTrail);
							// 添加外键
							overWarnTrail.setFkWarnUuid(startOverSpeedBean.getWarnUuid());
							overWarnTrailService.insertSelective(overWarnTrail);
						}
						// 清空轨迹列表，为开启第二次轨迹做准备
						// list.clear();
						// 将轨迹表前面非超速报警及超速报警数据删除，保留第二段非超速报警，作为下一次报警的第一段非超速报警
						for (int i = 0; i < secondNoOverSpeedStartIndex; i++) {
							list.remove(0);
						}
						// 重新设置主键
						for (TWarn tWarn : list) {
							tWarn.setWarnUuid(UUIDGenerator.genUuidStr());
						}
						// 插入非超速点
						list.add(warn);
						// 删除第一个非报警点，保证非超速报警个数等于阈值
						list.remove(0);
						// 重置计数器（下一次轨迹开始）
						busTimesMap.put(deviceId, new Recorder((list.size()), 0, 0, 0));
					}

					// 如果第二段非超速位置点个数小于非超速阈值，将超速也当做非超速进行轨迹点补全
					if (endNoOverTimes < noOverSpeedNodeNumber) {
						list.add(warn);
						busTimesMap.get(deviceId).setEndNoOverTimes(endNoOverTimes + 1);
					}
				}
			} else {// 超速报警
				// 没有第二段非超速报警,直接插入超速报警点
				if (endNoOverTimes == 0) {
					list.add(warn);
					busTimesMap.get(deviceId).setOverTimes(overTimes + 1);
				} else {
					// 括号里面的2个if条件顺序不能调
					
					// 如果第二段超速开始了，且第二段非超速报警等于设置的非超速报警阈值
					if (endNoOverTimes == noOverSpeedNodeNumber) {
						// 第二段非超速开始位置
						int secondNoOverSpeedStartIndex = startNoOverTimes + overTimes;
						// 计算超速报警起止时间并插入报警表
						TWarn startOverSpeedBean = list.get(startNoOverTimes);
						TWarn endOverSpeedBean = list.get(secondNoOverSpeedStartIndex - 1);
						startOverSpeedBean.setWarnEndTime(endOverSpeedBean.getWarnTime());
						startOverSpeedBean.setWarnEndLat(endOverSpeedBean.getLat());
						startOverSpeedBean.setWarnEndLng(endOverSpeedBean.getLng());
						warnService.insertSelective(startOverSpeedBean);
						// 插入附件表，方便疲劳报警统计逻辑
						TWarnMedia mediaBean = new TWarnMedia(UUIDGenerator.genUuidStr(),
								startOverSpeedBean.getWarnUuid(), startOverSpeedBean.getCreateTime(),
								startOverSpeedBean.getWarnDate());
						tWarnMediaMapper.insertSelective(mediaBean);
						// 将轨迹列表中的数据插入轨迹表
						for (TWarn tWarn : list) {
							TempBusOverWarnTrail overWarnTrail = new TempBusOverWarnTrail();
							BeanUtils.copyProperties(tWarn, overWarnTrail);
							// 添加外键
							overWarnTrail.setFkWarnUuid(startOverSpeedBean.getWarnUuid());
							overWarnTrailService.insertSelective(overWarnTrail);
						}
						// 将轨迹表前面非超速报警及超速报警数据删除，保留第二段非超速报警，作为下一次报警的第一段非超速报警
						// 第二段非超速包含由于补全可能包含超速报警，这里的超速报警与下段超速报警合并，由于前面需要补全6个点，需要往前补齐
						if (endOverTimes > 0) {
							secondNoOverSpeedStartIndex = secondNoOverSpeedStartIndex - endOverTimes;
						}
						for (int i = 0; i < secondNoOverSpeedStartIndex; i++) {
							list.remove(0);
						}
						// 重新设置主键
						for (TWarn tWarn : list) {
							tWarn.setWarnUuid(UUIDGenerator.genUuidStr());
						}
						// 插入超速点
						list.add(warn);
						// 重置计数器（下一次轨迹开始）
						busTimesMap.put(deviceId,
								new Recorder((list.size() - endOverTimes - 1), (endOverTimes + 1), 0, 0));
					}
					// 如果第二段非超速位置点个数小于非超速阈值，将超速也当做非超速进行轨迹点补全
					if (endNoOverTimes < noOverSpeedNodeNumber) {
						list.add(warn);
						busTimesMap.get(deviceId).setEndOverTimes(endOverTimes + 1);
						busTimesMap.get(deviceId).setEndNoOverTimes(endNoOverTimes + 1);
					}
				}
			}
		} else {
			List<TWarn> list = new LinkedList<>();
			list.add(warn);
			// 初始化计数器
			if (positionInfo.isOverSpeed()) {
				busTimesMap.put(deviceId, new Recorder(0, 1, 0, 0));
			} else {
				busTimesMap.put(deviceId, new Recorder(1, 0, 0, 0));
			}
			busMap.put(deviceId, list);
		}

	}

	/**
	 * Test1
	 * 
	 * 非超速 + 超速 + 非超速情况
	 * 
	 * 超速报警前后有大于规定非超速报警位置点信息
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<PositionInfo> initDatas1(String deviceId) {
		List<PositionInfo> list = new LinkedList<>();
		try {
			for (int i = 0; i < 10; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第一部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 6; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 10; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			LOG.error("{}", ex);
		}
		return list;
	}

	/**
	 * Test2
	 * 
	 * 非超速 + 超速 + 非超速情况
	 * 
	 * 超速报警前没有大于规定非超速报警位置点信息，后有大于规定的位置点信息
	 * 
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<PositionInfo> initDatas2(String deviceId) {
		List<PositionInfo> list = new LinkedList<>();
		try {
			for (int i = 0; i < 3; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第一部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 6; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 10; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			LOG.error("{}", ex);
		}
		return list;
	}

	/**
	 * Test3 超速报警前没有有大于规定非超速报警位置点信息，后有大于规定的位置点信息
	 * 
	 * 超速+非超速情况
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<PositionInfo> initDatas3(String deviceId) {
		List<PositionInfo> list = new LinkedList<>();
		try {
			for (int i = 0; i < 6; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 10; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			LOG.error("{}", ex);
		}
		return list;
	}

	/**
	 * Test4 超速报警前有大于规定非超速报警位置点信息，后有小于规定非超速报警后又接着正常报警
	 * 
	 * 非超速情况+超速+非超速情况 + 超速+非超速情况 (且第2段报警中间的非报警位置点小于设置的费报警点)
	 * 
	 * 
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<PositionInfo> initDatas4(String deviceId) {
		List<PositionInfo> list = new LinkedList<>();
		try {
			for (int i = 0; i < 10; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第一部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
			for (int i = 0; i < 6; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (2000000), i + (2000002), (i + 40),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 3; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (3000000), i + (3000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
			for (int i = 0; i < 6; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (4000000), i + (4000002), (i + 40),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 15; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (5000000), i + (5000002), (i + 40),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			LOG.error("{}", ex);
		}
		return list;
	}

	/**
	 * Test5 超速报警前有大于规定非超速报警位置点信息，后有大于规定非超速报警后又接着超速报警，接着费报警
	 * 
	 * 非超速情况 + 超速 + 非超速情况 + 超速 + 非超速情况 (多段完整报警)
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<PositionInfo> initDatas5(String deviceId) {
		List<PositionInfo> list = new LinkedList<>();
		try {
			for (int i = 0; i < 10; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (1000000), i + (1000001), (i + 10),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第一部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
			for (int i = 0; i < 6; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (2000000), i + (2000002), (i + 35),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
			for (int i = 0; i < 13; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (3000000), i + (3000002), (i + 15),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
			for (int i = 0; i < 6; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (4000000), i + (4000002), (i + 60),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 3; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (5000000), i + (5000002), (i + 30),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
			for (int i = 0; i < 16; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (6000000), i + (6000002), (i + 80),
						new Date(), new Date(), true);
				list.add(positionInfo);
				LOG.info("生成第{}条超速报警位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}

			for (int i = 0; i < 10; i++) {
				PositionInfo positionInfo = new PositionInfo(deviceId, i + (7000000), i + (7000002), (i + 10),
						new Date(), new Date(), false);
				list.add(positionInfo);
				LOG.info("第二部分费报警生成第{}条位置点信息记录", (i + 1));
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			LOG.error("{}", ex);
		}
		return list;
	}

	
	/**
	 * Test5 超速报警前有大于规定非超速报警位置点信息，后有大于规定非超速报警后又接着超速报警，接着费报警
	 * 
	 * 非超速情况 + 超速 + 非超速情况 + 超速 + 非超速情况 (多段完整报警)
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<PositionInfo> initDatas6(String deviceId) {
		List<PositionInfo> list = new LinkedList<>();
		try {
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 45,
					DateUtils.parseDateTime("2020-03-25 08:04:17"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 43,
					DateUtils.parseDateTime("2020-03-25 08:04:22"), null,
					false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 41, DateUtils.parseDateTime("2020-03-25 08:04:27"),
							null, false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 39, DateUtils.parseDateTime("2020-03-25 08:04:33"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 18,
					DateUtils.parseDateTime("2020-02-19 15:37:30"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 28,
					DateUtils.parseDateTime("2020-02-19 15:37:40"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:37:50"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 45,
					DateUtils.parseDateTime("2020-02-19 15:38:00"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 45,
					DateUtils.parseDateTime("2020-02-19 15:38:10"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:38:20"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:38:30"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:38:40"), null,
					true));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 24,
					DateUtils.parseDateTime("2020-02-19 15:38:50"), null,
					false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 0, DateUtils.parseDateTime("2020-02-19 15:39:00"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 15,
					DateUtils.parseDateTime("2020-02-19 15:39:10"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 26,
					DateUtils.parseDateTime("2020-02-19 15:39:20"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 38,
					DateUtils.parseDateTime("2020-02-19 15:39:30"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 38,
					DateUtils.parseDateTime("2020-02-19 15:39:40"), null,
					true));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 40,
					DateUtils.parseDateTime("2020-02-19 15:39:50"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 39,
					DateUtils.parseDateTime("2020-02-19 15:40:00"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 39,
					DateUtils.parseDateTime("2020-02-19 15:40:10"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 38,
					DateUtils.parseDateTime("2020-02-19 15:40:20"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 37,
					DateUtils.parseDateTime("2020-02-19 15:40:30"), null,
					true));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 4, DateUtils.parseDateTime("2020-02-19 15:40:40"),
							null, false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 1, DateUtils.parseDateTime("2020-02-19 15:40:50"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 30,
					DateUtils.parseDateTime("2020-02-19 15:41:00"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 40,
					DateUtils.parseDateTime("2020-02-19 15:41:10"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 41,
					DateUtils.parseDateTime("2020-02-19 15:41:20"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 43,
					DateUtils.parseDateTime("2020-02-19 15:41:30"), null,
					true));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 43,
					DateUtils.parseDateTime("2020-02-19 15:41:40"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:41:50"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:42:00"), null,
					true));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 25,
					DateUtils.parseDateTime("2020-02-19 15:42:10"), null,
					false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 2, DateUtils.parseDateTime("2020-02-19 15:42:20"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 23,
					DateUtils.parseDateTime("2020-02-19 15:42:30"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 30,
					DateUtils.parseDateTime("2020-02-19 15:42:40"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 37,
					DateUtils.parseDateTime("2020-02-19 15:42:50"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:43:00"), null,
					true));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 42,
					DateUtils.parseDateTime("2020-02-19 15:43:10"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 43,
					DateUtils.parseDateTime("2020-02-19 15:43:20"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 43,
					DateUtils.parseDateTime("2020-02-19 15:43:30"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 39,
					DateUtils.parseDateTime("2020-02-19 15:43:40"), null,
					true));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 20,
					DateUtils.parseDateTime("2020-02-19 15:43:50"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 35,
					DateUtils.parseDateTime("2020-02-19 15:44:00"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 40,
					DateUtils.parseDateTime("2020-02-19 15:44:10"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 31,
					DateUtils.parseDateTime("2020-02-19 15:44:20"), null,
					false));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 23,
					DateUtils.parseDateTime("2020-02-19 15:44:30"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 0,
					DateUtils.parseDateTime("2020-02-19 15:44:40"), null,
					false));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 0,
					DateUtils.parseDateTime("2020-02-19 15:44:50"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 33,
					DateUtils.parseDateTime("2020-02-19 15:45:00"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 38,
					DateUtils.parseDateTime("2020-02-19 15:45:10"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 34,
					DateUtils.parseDateTime("2020-02-19 15:45:20"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 41,
					DateUtils.parseDateTime("2020-02-19 15:45:30"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 44,
					DateUtils.parseDateTime("2020-02-19 15:45:40"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 45,
					DateUtils.parseDateTime("2020-02-19 15:45:50"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 40,
					DateUtils.parseDateTime("2020-02-19 15:46:00"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 41,
					DateUtils.parseDateTime("2020-02-19 15:46:10"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 39,
					DateUtils.parseDateTime("2020-02-19 15:46:20"), null,
					true));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 8, DateUtils.parseDateTime("2020-02-19 15:46:30"),
							null, false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 0, DateUtils.parseDateTime("2020-02-19 15:46:40"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 18,
					DateUtils.parseDateTime("2020-02-19 15:46:50"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 30,
					DateUtils.parseDateTime("2020-02-19 15:47:00"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 37,
					DateUtils.parseDateTime("2020-02-19 15:47:10"), null,
					true));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 2, DateUtils.parseDateTime("2020-02-19 15:47:20"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 16,
					DateUtils.parseDateTime("2020-02-19 15:47:30"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 40,
					DateUtils.parseDateTime("2020-02-19 15:47:40"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 42,
					DateUtils.parseDateTime("2020-02-19 15:47:50"), null,
					true));

			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 43,
					DateUtils.parseDateTime("2020-02-19 15:48:00"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 22,
					DateUtils.parseDateTime("2020-02-19 15:48:10"), null,
					false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 8, DateUtils.parseDateTime("2020-02-19 15:48:20"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 29,
					DateUtils.parseDateTime("2020-02-19 15:48:30"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 35,
					DateUtils.parseDateTime("2020-02-19 15:48:40"), null,
					true));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 0, DateUtils.parseDateTime("2020-02-19 15:48:50"),
							null, false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 3, DateUtils.parseDateTime("2020-02-19 15:49:00"),
							null, false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 22,
					DateUtils.parseDateTime("2020-02-19 15:49:10"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 33,
					DateUtils.parseDateTime("2020-02-19 15:49:20"), null,
					false));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 35,
					DateUtils.parseDateTime("2020-02-19 15:49:30"), null,
					true));
			list.add(new PositionInfo(deviceId, 28.760365, 104.605031, 19,
					DateUtils.parseDateTime("2020-02-19 15:49:40"), null,
					false));
			list.add(
					new PositionInfo(deviceId, 28.760365, 104.605031, 0, DateUtils.parseDateTime("2020-02-19 15:49:50"),
							null,
					false));
		} catch (Exception ex) {
			LOG.error("{}", ex);
		}
		return list;
	}
	
	
	/**
	 * 根据数据库数据构建测试数据
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<PositionInfo> initDatas7() {
		List<PositionInfo> list = new ArrayList<>();
		List<TempBusOverWarnTrail> queryList = overWarnTrailService.getOverSpeedInfos();
		for (TempBusOverWarnTrail bean : queryList) {
			boolean isOverSpeed = Integer.parseInt(bean.getSpeed()) >= 50;
			list.add(new PositionInfo(bean.getDeviceId(), Double.parseDouble(bean.getLat()), Double.parseDouble(bean.getLng()), Integer.parseInt(bean.getSpeed()),
					bean.getWarnTime(), bean.getWarnTime(),
					isOverSpeed));
		}
		return list;
	}
}
