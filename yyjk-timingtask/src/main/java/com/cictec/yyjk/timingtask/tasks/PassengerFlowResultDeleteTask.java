package com.cictec.yyjk.timingtask.tasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.timingtask.service.PassengerFlowResultService;


@Component
public class PassengerFlowResultDeleteTask {
	private static final Logger LOG = LoggerFactory.getLogger(PassengerFlowResultDeleteTask.class);
	
	@Autowired
	private PassengerFlowResultService passengerFlowResultService;

	/**
	 * 客流中间表保留前2个月数，每月1日5点执行
	 */
	@Scheduled(cron = "0 0 5 1 * ?")
	public void start() {
		LOG.info("删除客流数据表数据定时开始...");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -2);
		String month = new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
		try {
			passengerFlowResultService.deletePassengerDatas(month);
		} catch (Throwable ex) {
			LOG.error("删除客流数据表数据异常！{}", ex);
		}
		LOG.info("删除客流数据表数据定时结束...");
	}
}
