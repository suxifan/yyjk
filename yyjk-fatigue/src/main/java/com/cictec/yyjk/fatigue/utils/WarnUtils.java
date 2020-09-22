package com.cictec.yyjk.fatigue.utils;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.model.entity.PositionInfo;
import com.cictec.yyjk.fatigue.model.entity.TWarn;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;
import com.cictec.yyjk.fatigue.model.view.Recorder;
import com.cictec.yyjk.fatigue.service.TWarnService;
import com.cictec.yyjk.fatigue.service.TempBusOverWarnTrailService;

public class WarnUtils{
	private static final Logger LOG = LoggerFactory.getLogger(WarnUtils.class);

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
			PositionInfo positionInfo, Map<String, String> devInfoDisc, Integer noOverSpeedNodeNumber,
			TWarnService warnService, TempBusOverWarnTrailService overWarnTrailService) throws Exception {

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
						// 将轨迹列表中的数据插入轨迹表
						for (TWarn tWarn : list) {
							TempBusOverWarnTrail overWarnTrail = new TempBusOverWarnTrail();
							BeanUtils.copyProperties(tWarn, overWarnTrail);
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
						// 将轨迹列表中的数据插入轨迹表
						for (TWarn tWarn : list) {
							TempBusOverWarnTrail overWarnTrail = new TempBusOverWarnTrail();
							BeanUtils.copyProperties(tWarn, overWarnTrail);
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
						busTimesMap.put(deviceId, new Recorder((list.size() - 1), 1, 0, 0));
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

}
