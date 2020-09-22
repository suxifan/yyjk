package com.cictec.yyjk.timingtask.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.timingtask.model.entity.AnalysisArriveVolumeDay;
import com.cictec.yyjk.timingtask.service.AnalysisArriveVolumeDayService;

/**
 * 补排班定时任务(根据车辆的到站时间，站序计算班次)
 * 
 */
// @Component
public class CompleteAnalysisArriveVolumeDayTask {
	private static Logger LOG = LoggerFactory.getLogger(CompleteAnalysisArriveVolumeDayTask.class);
	@Autowired
	private AnalysisArriveVolumeDayService analysisArriveVolumeDayService;

	@Scheduled(cron = "${jobs.schedule.dispatch.arrivestation.completeclass}")
	public void start() throws Exception {
		LOG.info("补排班定时任务开始...");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String dateTime = DateUtils.formatDate(calendar.getTime());
		List<String> lineIds = analysisArriveVolumeDayService.getLineIds(dateTime);

		for (String lineId : lineIds) {
			// 以车牌号为key进行分组
			Map<String, List<AnalysisArriveVolumeDay>> map = new HashMap<>();
			List<AnalysisArriveVolumeDay> queryList = analysisArriveVolumeDayService
					.getAnalysisArriveVolumeDatas(lineId, dateTime);
			for (AnalysisArriveVolumeDay item : queryList) {
				String key = item.getBusPlateNumber();
				if (!map.containsKey(key)) {
					List<AnalysisArriveVolumeDay> list = new ArrayList<>();
					list.add(item);
					map.put(key, list);
				} else {
					map.get(key).add(item);
				}
			}
			// 处理mapList，对每个车牌号数据按照站序分割，给出趟次
			for (String key : map.keySet()) {
				List<AnalysisArriveVolumeDay> list = map.get(key);
				Short classIndex = 1;
				Map<Short, List<AnalysisArriveVolumeDay>> busMap = new HashMap<>();
				List<AnalysisArriveVolumeDay> tempList = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					AnalysisArriveVolumeDay first = null;
					AnalysisArriveVolumeDay next = null;
					if (i == list.size() - 1) {
						first = list.get(i);
						next = list.get(i);
					} else {
						first = list.get(i);
						next = list.get(i + 1);
					}

					if (Short.valueOf(first.getStaSeq()) < Short.valueOf(next.getStaSeq())) {
						tempList.add(first);
					} else {
						tempList.add(first);
						List<AnalysisArriveVolumeDay> subList = new ArrayList<>();
						subList.addAll(tempList);
						busMap.put(classIndex, subList);
						tempList.clear();
						classIndex++;
					}
				}

				// 更新数据库
				for (Short classKey : busMap.keySet()) {
					List<AnalysisArriveVolumeDay> classBus = busMap.get(classKey);
					if (classBus == null || (classBus != null && classBus.size() == 1)) {// 排除一趟只有一个站的情况
						continue;
					}
					// 如果同一趟次，第一个站点距第二个站点或者最后俩个站点超出10钟，说明在场站停靠，过滤掉第一个站点或最后一个站点
					List<AnalysisArriveVolumeDay> tempDatas = new ArrayList<>();
					if (isGt10Minite(classBus.get(0).getUploadTimeIn(), classBus.get(1).getUploadTimeIn())) {
						tempDatas.addAll(classBus.subList(1, classBus.size()));
					} else if (isGt10Minite(classBus.get(classBus.size() - 2).getUploadTimeIn(),
							classBus.get(classBus.size() - 1).getUploadTimeIn())) {
						tempDatas.addAll(classBus.subList(0, classBus.size() - 1));
					} else {
						tempDatas.addAll(classBus);
					}
					for (AnalysisArriveVolumeDay bean: tempDatas) {
						bean.setBusClass(classKey);
						analysisArriveVolumeDayService.updateByPrimaryKeySelective(bean);
					}
				}
			}
		}
		LOG.info("补排班定时任务结束...");
	}

	private boolean isGt10Minite(Date firstDate, Date lastDate) {
		long between = lastDate.getTime() - firstDate.getTime();
		return (between / (60 * 1000)) > 10;
	}
	
	
}
