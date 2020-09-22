package com.cictec.yyjk.timingtask.tasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.cictec.yyjk.timingtask.service.AnalysisLengthTimeDayService;

//@Component
public class AnalysisLengthTimeDayDeleteTask {
	private static final Logger LOG = LoggerFactory.getLogger(AnalysisLengthTimeDayDeleteTask.class);

	@Autowired
	private AnalysisLengthTimeDayService analysisLengthTimeDayService;

	/**
	 * 到站数据日统计表保留前2个月数，每月1日5点30执行
	 */
	@Scheduled(cron = "0 30 5 1 * ?")
	public void start() {
		LOG.info("删除到站日数据表数据定时开始...");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -2);
		String month = new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
		try {
			analysisLengthTimeDayService.deleteLenthTimeDayDatas(month);
		} catch (Throwable ex) {
			LOG.error("删除到站日数据表数据异常！{}", ex);
		}
		LOG.info("删除到站日数据表数据定时结束...");
	}
}