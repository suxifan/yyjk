package com.cictec.yyjk.timingtask.tasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.timingtask.model.entity.AnalysisPeakMonth;
import com.cictec.yyjk.timingtask.service.AnalysisPeakMonthService;

/**
 * 总体客流高峰时刻月数据定时任务
 * 
 * @author xpguo
 *
 */
@Component
public class AnalysisPeakMonthTask {
	private static Logger LOG = LoggerFactory.getLogger(AnalysisPeakMonthTask.class);
	@Autowired
	private AnalysisPeakMonthService analysisPeakMonthService;

	@Scheduled(cron = "${jobs.schedule.passengerflow.peak.month}")
	public void start() {
		LOG.info("总体客流高峰时刻定时任务开始(月报)...");
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.MONTH, -1);
		String month = new SimpleDateFormat("yyyy-MM").format(calender.getTime());
		List<AnalysisPeakMonth> queryList = analysisPeakMonthService.getAnalysisPeakMonthDatas(month);
		if (queryList != null && queryList.size() > 0) {
			int pageSize = 1000;
			int total = queryList.size();
			int pages = (total % pageSize) == 0 ? (total / pageSize) : (total / pageSize + 1);
			int currentPage = 1;
			try {
				if (total <= pageSize) {
					analysisPeakMonthService.insertList(queryList);
				} else {
					while (currentPage <= pages) {
						int startIndex = (currentPage - 1) * pageSize;
						int endIndex = (currentPage * pageSize) > total ? total : (currentPage * pageSize);
						analysisPeakMonthService.insertList(queryList.subList(startIndex, endIndex));
						currentPage++;
					}
				}
			} catch (Exception ex) {
				LOG.error("总体客流高峰时刻插入数据失败(月报)！{}", ex);
			}
		}
		LOG.info("总体客流高峰时刻定时任务结束(月报)...");
	}
}
