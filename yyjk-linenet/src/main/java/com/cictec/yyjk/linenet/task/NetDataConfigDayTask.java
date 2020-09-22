package com.cictec.yyjk.linenet.task;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.linenet.model.entity.NetDataConfig;
import com.cictec.yyjk.linenet.model.entity.NetXmlConfig;
import com.cictec.yyjk.linenet.model.view.NetDataConfigValue;
import com.cictec.yyjk.linenet.service.NetDataConfigService;
import com.cictec.yyjk.linenet.service.NetXmlConfigService;
import com.cictec.yyjk.linenet.util.XmlUtils;

@Component
public class NetDataConfigDayTask {
	private static Logger LOG = LoggerFactory.getLogger(NetDataConfigDayTask.class);
	@Resource
	private NetDataConfigService netDataConfigService;

	@Autowired
	private NetXmlConfigService netXmlConfigService;

	@Scheduled(cron = "${jobs.schedule.linenet.netdataconfig.day}")
	public void start() {
		LOG.info("线网XML数据定时任务开始...");
		try {
			// 清空表
			netDataConfigService.clearTabel();
			NetDataConfig net = new NetDataConfig();
			net.setConfigName("deareslutconfig.xml");
			NetDataConfigValue naConfigValue = netDataConfigService.getDeareslutConfigXMLData(net);
			String xmlStr = naConfigValue.getConfigFile();

			// XML中字段名是N打头的也是转换之前的数据，页面需要的是转换后的数据也就是O打头的，所以解析XML时存库直接存入了O打头数据
			List<Map<String, String>> maps = XmlUtils.xmlElementDeaReslut(xmlStr);
			for (Map<String, String> map : maps) {
				NetXmlConfig obj = JSON.parseObject(JSON.toJSONString(map), NetXmlConfig.class);
				netXmlConfigService.insertSelective(obj);
			}
			LOG.info("获取线网评分xmldata数据：{}", naConfigValue.toString());
		} catch (Exception e) {
			LOG.error("获取线网评分xmldata异常，原因：{}", e);
		}

		LOG.info("线网XML数据定时任务结束...");
	}
}
