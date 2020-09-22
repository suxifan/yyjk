package com.cictec.yyjk.timingtask.tasks;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.fatigue.service.TempPlTakePhotoSetService;


/**
 * 设备抓拍任务加载  定时任务
 * 
 * @author Rwq
 *
 */
@Component
public class TakePhotoScheduledTask {
	private static Logger LOG = LoggerFactory.getLogger(TakePhotoScheduledTask.class);
	
    @Resource
    private TempPlTakePhotoSetService tempPlTakePhotoSetService;
    
    
    @Scheduled(cron = "0 0 2 * * ?")
    public void start() {
    	LOG.info("凌晨2点执行加载设备抓拍任务定时器加载");
    	tempPlTakePhotoSetService.loadTakePhotoScheduledTask();
    }
    
}
