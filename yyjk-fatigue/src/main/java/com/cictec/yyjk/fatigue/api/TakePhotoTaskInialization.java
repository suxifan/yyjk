package com.cictec.yyjk.fatigue.api;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.fatigue.service.TempPlTakePhotoSetService;
/**
 * 设备抓拍定时任务平台初始化处理
 * 
 * @author Administrator
 *
 */
@Component
public class TakePhotoTaskInialization implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    @Resource
    private TempPlTakePhotoSetService tempPlTakePhotoSetService;
	
	@Override
	public void run(String... arg0) throws Exception {
		logger.warn("系统启动设备抓拍定时任务平台初始化...");
		tempPlTakePhotoSetService.loadTakePhotoScheduledTask();
		logger.warn("系统启动设备抓拍定时任务平台初始化结束");
	}

}
