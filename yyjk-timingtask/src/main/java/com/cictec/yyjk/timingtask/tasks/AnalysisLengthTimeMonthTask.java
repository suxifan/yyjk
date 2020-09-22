package com.cictec.yyjk.timingtask.tasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeMonth;
import com.cictec.yyjk.timingtask.service.AnalysisLengthTimeMonthService;

/**
 * 线路站间运行时间分析（月报）定时任务
 * 
 * @author xpguo
 *
 */
// @Component
public class AnalysisLengthTimeMonthTask {
	private static Logger LOG = LoggerFactory.getLogger(AnalysisLengthTimeMonthTask.class);
	@Autowired
	private AnalysisLengthTimeMonthService analysisLengthTimeMonthService;

	@Scheduled(cron = "${jobs.schedule.passengerflow.lengthtime.month}")
	public void start() {
		LOG.info("线路站间运行时间分析定时任务开始(月报)...");
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.MONTH, -1);
		String month = new SimpleDateFormat("yyyy-MM").format(calender.getTime());
		List<AnalysisLengthTimeMonth> queryList = analysisLengthTimeMonthService
				.getAnalysisLengthTimeMonthDatas(month);
		if (queryList != null && queryList.size() > 0) {
			int pageSize = 1000;
			int total = queryList.size();
			int pages = (total % pageSize) == 0 ? (total / pageSize) : (total / pageSize + 1);
			int currentPage = 1;
			try {
				if (total <= pageSize) {
					analysisLengthTimeMonthService.insertList(queryList);
				} else {
					while (currentPage <= pages) {
						int startIndex = (currentPage - 1) * pageSize;
						int endIndex = (currentPage * pageSize) > total ? total : (currentPage * pageSize);
						analysisLengthTimeMonthService.insertList(queryList.subList(startIndex, endIndex));
						currentPage++;
					}
				}
			} catch (Exception ex) {
				LOG.error("线路站间运行时间分析插入数据失败(月报)！{}", ex);
			}
		}
		LOG.info("线路站间运行时间分析定时任务结束(月报)...");
	}
}
