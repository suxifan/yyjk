package com.cictec.yyjk.timingtask.tasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.timingtask.model.entity.AnalysisFullloadDay;
import com.cictec.yyjk.timingtask.service.AnalysisFullloadDayService;

/**
 * 区间满载率查询(日报)定时任务
 * 
 * @author xpguo
 *
 */
@Component
public class AnalysisFullloadDayTask {
	private static Logger LOG = LoggerFactory.getLogger(AnalysisFullloadDayTask.class);
	@Autowired
	private AnalysisFullloadDayService analysisFullloadDayService;

	@Scheduled(cron = "${jobs.schedule.passengerflow.fullload.day}")
	public void start() {
		LOG.info("区间满载率查询定时任务开始(日报)...");
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, -1);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(calender.getTime());
		Date startTime = DateUtils.parseDateTime(date + " 00:00:00");
		Date endTime = DateUtils.parseDateTime(date + " 23:59:59");
		List<AnalysisFullloadDay> queryList = analysisFullloadDayService.getAnalysisFullload(startTime, endTime);
		if (queryList != null && queryList.size() > 0) {
			int pageSize = 1000;
			int total = queryList.size();
			int pages = (total % pageSize) == 0 ? (total / pageSize) : (total / pageSize + 1);
			int currentPage = 1;
			try {
				if (total <= pageSize) {
					analysisFullloadDayService.insertList(queryList);
				} else {
					while (currentPage <= pages) {
						int startIndex = (currentPage - 1) * pageSize;
						int endIndex = (currentPage * pageSize) > total ? total : (currentPage * pageSize);
						analysisFullloadDayService.insertList(queryList.subList(startIndex, endIndex));
						currentPage++;
					}
				}
			} catch (Exception ex) {
				LOG.error("区间满载率查询插入数据失败(日报)！{}", ex);
			}
		}
		LOG.info("区间满载率查询定时任务结束(日报)...");
	}

}
