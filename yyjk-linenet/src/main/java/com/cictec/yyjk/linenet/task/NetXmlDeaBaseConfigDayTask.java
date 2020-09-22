package com.cictec.yyjk.linenet.task;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.linenet.model.entity.NetDataConfig;
import com.cictec.yyjk.linenet.model.entity.NetXmlDeaBaseConfig;
import com.cictec.yyjk.linenet.model.view.NetDataConfigValue;
import com.cictec.yyjk.linenet.service.NetDataConfigService;
import com.cictec.yyjk.linenet.service.NetXmlDeaBaseConfigService;
import com.cictec.yyjk.linenet.util.XmlUtils;

@Component
public class NetXmlDeaBaseConfigDayTask {
	private static Logger LOG = LoggerFactory.getLogger(NetXmlDeaBaseConfigDayTask.class);
	@Resource
	private NetDataConfigService netDataConfigService;
	@Resource
	private NetXmlDeaBaseConfigService netXmlDeaBaseConfigService;

	@Scheduled(cron = "${jobs.schedule.linenet.netdeabaseconfig.day}")
	public void start() {
		LOG.info("线网XML基础数据定时任务开始...");
		try {
			// 清空表
			netXmlDeaBaseConfigService.clearTabel();
			NetDataConfig net = new NetDataConfig();
			net.setConfigName("deabaseindexconfig.xml");
			NetDataConfigValue naConfigValue = netDataConfigService.getDeareslutConfigXMLData(net);
			String xmlStr = naConfigValue.getConfigFile();
			List<Map<String, String>> maps = XmlUtils.xmlElementsBaseIndex(xmlStr);
			for (Map<String, String> map : maps) {
				NetXmlDeaBaseConfig obj = JSON.parseObject(JSON.toJSONString(map), NetXmlDeaBaseConfig.class);
				netXmlDeaBaseConfigService.insertSelective(obj);
			}
			LOG.info("获取线网评分基础xmldata数据：{}", naConfigValue.toString());
		} catch (Exception e) {
			LOG.error("获取线网评分基础xmldata异常，原因：{}", e);
		}

		LOG.info("线网XML数据定时任务结束...");
	}
}
