package com.cictec.yyjk.fatigue.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.mapper.TempPlTakePhotoSetMapper;
import com.cictec.yyjk.fatigue.model.entity.TDevice;
import com.cictec.yyjk.fatigue.model.entity.TempPlTakePhotoSet;
import com.cictec.yyjk.fatigue.model.vo.TempPlTakePhotoSetVo;
import com.cictec.yyjk.fatigue.rabbitmq.sender.JsxwTakePhotoService;
import com.cictec.yyjk.fatigue.service.TempPlTakePhotoSetService;

/**
 * Created by Rwq on 2020/03/10.
 */
@Service
@Transactional
public class TempPlTakePhotoSetServiceImpl extends AbstractService<TempPlTakePhotoSet>
		implements TempPlTakePhotoSetService {
	private static final Logger LOG = LoggerFactory.getLogger(TempPlTakePhotoSetServiceImpl.class);
	@Resource
	private TempPlTakePhotoSetMapper tempPlTakePhotoSetMapper;

	@Resource
	private JsxwTakePhotoService jsxwTakePhotoService; // 设备抓拍MQ推送server

	@Resource(name = "threadPoolTaskScheduler")
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	public static Map<String, ScheduledFuture<?>> taskmap = new HashMap<>();

	@Override
	public List<TempPlTakePhotoSet> selectTakePhotoSetPage(TempPlTakePhotoSetVo vo) {
		return tempPlTakePhotoSetMapper.selectTakePhotoSetPage(vo);
	}

	@Override
	public void devByManual(TempPlTakePhotoSetVo vo) {
		List<String> devCodes = new ArrayList<String>();
		List<TDevice> devList = vo.getDevList();
		for (TDevice dev : devList) {
			devCodes.add(dev.getDevCode());
		}
		putMsgToMQ(devCodes);
	}

	@Override
	public void saveDevTakePhoto(TempPlTakePhotoSet vo) {
		// List<String> devCodes = new ArrayList<String>();
		List<TDevice> devList = vo.getDevList();
		String cronExp = createCronExpression(vo.getTimingClass(), vo.getTimingRemark(), vo.getStartTime(),
				vo.getEndTime(), vo.getDuration());
		for (TDevice dev : devList) {
			TempPlTakePhotoSet param = new TempPlTakePhotoSet();
			BeanUtils.copyProperties(vo, param);
			// devCodes.add(dev.getDevCode());
			String uuid = UUIDGenerator.genUuidStr();
			param.setTakePhotoUuid(uuid);
			param.setDeviceCode(dev.getDevCode());
			param.setDeviceId(dev.getDevUuid());
			param.setCron(cronExp);
			tempPlTakePhotoSetMapper.insertSelective(param); // 保存
			if (DateUtils.isSystemDay(vo.getStartDate())) { // 判断添加是否是当前时间
				ScheduledFuture future = threadPoolTaskScheduler.schedule(new MyRunnable(dev.getDevCode()),
						new CronTrigger(cronExp));
				taskmap.put(uuid, future);
			}
		}
	}

	@Override
	public void updateDevTakePhoto(TempPlTakePhotoSet vo) {
		String cronExp = createCronExpression(vo.getTimingClass(), vo.getTimingRemark(), vo.getStartTime(),
				vo.getEndTime(), vo.getDuration());
		vo.setCron(cronExp);
		tempPlTakePhotoSetMapper.updateByPrimaryKeySelective(vo);
		if (vo.getIsvalid().equals("1")) { // 启用状态
			stopTask(vo.getTakePhotoUuid());
			ScheduledFuture future = threadPoolTaskScheduler.schedule(new MyRunnable(vo.getDeviceCode()),
					new CronTrigger(cronExp));
			taskmap.put(vo.getTakePhotoUuid(), future);
		} else {
			stopTask(vo.getTakePhotoUuid());
		}
	}

	@Override
	public void deleteDevTakePhoto(String takePhotoUuid) {
		// 1、删表数据
		tempPlTakePhotoSetMapper.deleteByPrimaryKey(takePhotoUuid);
		// 2、停止存在的定时任务
		stopTask(takePhotoUuid);
		// 3、删除内存中记录
		taskmap.remove(takePhotoUuid);
	}

	/**
	 * 推送MQ消息 json 结构
	 * ；{"messageType":"takephoto","jsonData":"","devCodes":["13912345670",
	 * "13800000000"]}
	 *
	 **/
	private void putMsgToMQ(List<String> devCodes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("messageType", "takePhoto");
		map.put("jsonData", "");
		map.put("devCodes", devCodes);
		try {
			jsxwTakePhotoService.takeJsxwPhotoTask(map);
		} catch (Exception e) {
			LOG.error("推送MQ消息异常，原因{}", e);
		}

	}

	/**
	 * 
	 * 方法摘要：构建Cron表达式
	 * 
	 * @param taskScheduleClass
	 *            定时任务类型 1 每天 2 每周 3 每月
	 * @param taskScheduleStr
	 *            每天 为 1 每周 1,2,3,4,5,6,7 每月 1,2,3......29,30,31
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束日期
	 * @return duration 采集间隔
	 */
	private String createCronExpression(String taskScheduleClass, String taskScheduleStr, String startTime,
			String endTime, String duration) {
		if (StringUtils.isEmpty(taskScheduleClass)) {
			return "";
		}

		/*
		 * //获取开始日期的年， 月 ，日 Calendar start_calendar = Calendar.getInstance();
		 * start_calendar.setTime(startDate); int start_year =
		 * start_calendar.get(Calendar.YEAR); int start_month =
		 * start_calendar.get(Calendar.MONTH) + 1; int start_day =
		 * start_calendar.get(Calendar.DAY_OF_MONTH);
		 * 
		 * //获取结束日期的年， 月 ，日 Calendar end_calendar = Calendar.getInstance();
		 * end_calendar.setTime(endDate); int end_year =
		 * end_calendar.get(Calendar.YEAR); int end_month =
		 * end_calendar.get(Calendar.MONTH) + 1; int end_day =
		 * end_calendar.get(Calendar.DAY_OF_MONTH);
		 */

		String startHour = startTime.substring(0, 2);
		String endHour = endTime.substring(0, 2);

		StringBuffer cronExp = new StringBuffer("");
		cronExp.append("0 ");// 设置秒
		cronExp.append("0/").append(duration).append(" ");// 设置分钟间隔
		cronExp.append(startHour).append("-").append(endHour).append(" ");// 设置小时
		if (taskScheduleClass.equals("1")) { // 每天
			cronExp.append("* * ?");
		}
		if (taskScheduleClass.equals("2")) { // 每周
			cronExp.append("? * ");
			cronExp.append(taskScheduleStr).append(" ");
		}
		if (taskScheduleClass.equals("3")) { // 每月
			cronExp.append(taskScheduleStr).append(" ");
			cronExp.append("* ? ");
		}

		return cronExp.toString();
	}

	@Override
	public void loadTakePhotoScheduledTask() {
		List<TempPlTakePhotoSet> list = tempPlTakePhotoSetMapper.selectScheduledList();
		if (list != null && list.size() > 0) {
			for (TempPlTakePhotoSet vo : list) {
				stopTask(vo.getTakePhotoUuid());
				ScheduledFuture future = threadPoolTaskScheduler.schedule(new MyRunnable(vo.getDeviceCode()),
						new CronTrigger(vo.getCron()));
				taskmap.put(vo.getTakePhotoUuid(), future);
			}
		}
	}

	private class MyRunnable implements Runnable {
		private String devCode;

		public MyRunnable(String devCode) {
			this.devCode = devCode;
		}

		@Override
		public void run() {
			List<String> devCodes = new ArrayList<String>();
			devCodes.add(devCode);
			// 向中间件MQ发送消息
			putMsgToMQ(devCodes);
		}
	}

	/**
	 * 方法摘要：停止线程池定时任务
	 * 
	 * @param key
	 *            存储键值
	 */
	private boolean stopTask(String key) {
		LOG.info("停止内存线程池定时任务temp_pl_take_photo_set表key:{}", key);
		ScheduledFuture<?> future = taskmap.get(key);
		if (future != null) {
			LOG.info("停止key:{}", key);
			future.cancel(true);
			return true;
		}
		return false;
	}

}
