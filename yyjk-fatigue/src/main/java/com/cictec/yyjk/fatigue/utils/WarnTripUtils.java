package com.cictec.yyjk.fatigue.utils;

import java.util.Map;

public class WarnTripUtils {

	/**
	 * 
	 * @param positionInfo
	 * @param devMap
	 * @param devTripsDisc
	 * @throws Exception
	 */

	private static void positionInfoHandle(WarnInfo warnInfo, Map<String, WarnInfo> devMap,
			Map<String, Integer> devTripsDisc) throws Exception {

		String deviceId = warnInfo.getDevCode();
		// 当前站序数
		Integer currentstanSeq = warnInfo.getStaSqn();
		// 设备对应的最大站序编号
		Integer maxStanSeq = devTripsDisc.get(deviceId);

		// 根据设备号将车辆报警存入字典中
		if (devMap.containsKey(deviceId)) {
			// 前一个节点信息
			WarnInfo perBean = devMap.get(deviceId);
			Integer perStaSqn = perBean.getStaSqn();

			// 比对： 当前节点的站序小于最大站序且等于前一个节点的站序，重置当前节点的上下车人数
			if (currentstanSeq < maxStanSeq) {
				if (currentstanSeq == perStaSqn) {
					// update
				} else if (currentstanSeq > perStaSqn) {
					// insert
				}
			}
			// 替换
			devMap.put(deviceId, warnInfo);
		} else {
			// 保存第一个节点
			devMap.put(deviceId, warnInfo);
		}

	}
}
