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
import com.cictec.yyjk.timingtask.model.entity.AnalysisStaOnOffDay;
import com.cictec.yyjk.timingtask.service.AnalysisStaOnOffDayService;

/**
 * 站点登降量查询(日期区间)定时任务
 * 
 * @author xpguo
 *
 */
@Component
public class AnalysisStaOnOffDayTask {
	private static Logger LOG = LoggerFactory.getLogger(AnalysisStaOnOffDayTask.class);
	@Autowired
	private AnalysisStaOnOffDayService analysisStaOnOffDayService;

	@Scheduled(cron = "${jobs.schedule.passengerflow.staonoff.day}")
	public void start() {
		LOG.info("站点登降量任务开始(日报)...");
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, -1);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(calender.getTime());
		Date startTime = DateUtils.parseDateTime(date + " 00:00:00");
		Date endTime = DateUtils.parseDateTime(date + " 23:59:59");
		List<AnalysisStaOnOffDay> queryList = analysisStaOnOffDayService.getAnalysisStaOnOffDayDatas(startTime,
				endTime);
		if (queryList != null && queryList.size() > 0) {
			int pageSize = 1000;
			int total = queryList.size();
			int pages = (total % pageSize) == 0 ? (total / pageSize) : (total / pageSize + 1);
			int currentPage = 1;
			try {
				if (total <= pageSize) {
					analysisStaOnOffDayService.insertList(queryList);
				} else {
					while (currentPage <= pages) {
						int startIndex = (currentPage - 1) * pageSize;
						int endIndex = (currentPage * pageSize) > total ? total : (currentPage * pageSize);
						analysisStaOnOffDayService.insertList(queryList.subList(startIndex, endIndex));
						currentPage++;
					}
				}
			} catch (Exception ex) {
				LOG.error("站点登降量插入数据失败(日报)！{}", ex);
			}
		}
		LOG.info("站点登降量日报任务结束(日报)...");
	}
}
