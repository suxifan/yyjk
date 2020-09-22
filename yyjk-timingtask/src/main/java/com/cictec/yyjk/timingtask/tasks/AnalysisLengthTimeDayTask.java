package com.cictec.yyjk.timingtask.tasks;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.commons.utils.StringUtils;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeDay;
import com.cictec.yyjk.timingtask.service.AnalysisLengthTimeDayService;
import com.cictec.yyjk.timingtask.service.DwDimLineStationService;

@Component
public class AnalysisLengthTimeDayTask {
	private static Logger LOG = LoggerFactory.getLogger(AnalysisLengthTimeDayTask.class);
	@Resource(name = "client")
	private Client client;
	@Autowired
	private Environment env;

	@Autowired
	private AnalysisLengthTimeDayService analysisLengthTimeDayService;
	@Autowired
	private DwDimLineStationService dwDimLineStationService;

	@Scheduled(cron = "${jobs.schedule.passengerflow.lengthtime.day}")
	public void start() {
		LOG.info("线路站间运行时间分析定时任务开始(日报)...");
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, -1);
		String dateTime = new SimpleDateFormat("yyyy-MM-dd").format(calender.getTime());
		List<AnalysisLengthTimeDay> queryList = analysisLengthTimeDayService.getAnalysisLengthTimeDayDatas(dateTime);
		if (CollectionUtils.isEmpty(queryList)) {
			return;
		}
		// 站间距字典
		Map<String, String> disc = dwDimLineStationService.getLineStationBetweenDistanceDisc();
		// 设置站间距
		List<AnalysisLengthTimeDay> datas = new ArrayList<>();
		for (AnalysisLengthTimeDay bean : queryList) {
			String key = bean.getLineUuid() + bean.getLineType() + bean.getStaSeq();
			String value = disc.get(key);
			BigDecimal staBetweenDistance = (StringUtils.isNotEmpty(value)) ? new BigDecimal(value)
					: new BigDecimal("0");
			bean.setStaBetweenDistance(staBetweenDistance);
			datas.add(bean);
		}
		if (datas.size() > 0) {
			// 插入数据到DB
			insertDB(datas);
			// 插入数据到ES
			String index = env.getProperty("elasticsearch.cluster.businoutstation.index");
			insertES(client, index, "analysis_length_time_day", datas);
		}
		LOG.info("线路站间运行时间分析定时任务结束(日报)...");
	}

	private void insertDB(List<AnalysisLengthTimeDay> queryList) {
		int pageSize = 1000;
		int total = queryList.size();
		int pages = (total % pageSize) == 0 ? (total / pageSize) : (total / pageSize + 1);
		int currentPage = 1;
		try {
			if (total <= pageSize) {
				analysisLengthTimeDayService.insertList(queryList);
			} else {
				while (currentPage <= pages) {
					int startIndex = (currentPage - 1) * pageSize;
					int endIndex = (currentPage * pageSize) > total ? total : (currentPage * pageSize);
					analysisLengthTimeDayService.insertList(queryList.subList(startIndex, endIndex));
					currentPage++;
				}
			}
		} catch (Exception ex) {
			LOG.error("线路站间运行时间分析插入数据失败(日报)！{}", ex);
		}
	}

	/**
	 * 将数据入ES
	 * 
	 * @param queryList
	 */
	private void insertES(Client client, String index, String type, List<AnalysisLengthTimeDay> queryList) {
		try {
			LOG.info("进出站数据入库开始...");
			int pageSize = 5;
			int curentPage = 1;
			int total = queryList.size();
			int pageNumber = (total % pageSize) == 0 ? total / pageSize : (total / pageSize + 1);
			if (total <= pageSize) {
				BulkRequestBuilder bulkRequest = createESbulk(client, index, type, queryList);
				BulkResponse bulkResponse = bulkRequest.get();
				if (bulkResponse.hasFailures()) {
					LOG.error("进出站插入ES操作失败！");
				}
			} else {
				while (curentPage <= pageNumber) {
					int startIndex = (curentPage - 1) * pageSize;
					int endIndex = (curentPage * pageSize) > total ? total : (curentPage * pageSize);
					BulkRequestBuilder bulkRequest = createESbulk(client, index, type,
							queryList.subList(startIndex, endIndex));
					BulkResponse bulkResponse = bulkRequest.get();
					if (bulkResponse.hasFailures()) {
						LOG.error("第" + curentPage + "进出站数据插入ES操作失败！");
					}
					curentPage++;
				}
			}
			LOG.info("进出站数据入库结束...");
		} catch (Exception ex) {
			LOG.error("进出站数据导入失败！{}", ex);
		}
	}

	private BulkRequestBuilder createESbulk(Client client, String index, String type,
			List<AnalysisLengthTimeDay> queryList) {
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		if (queryList == null || queryList.size() == 0) {
			return bulkRequest;
		}

		Iterator<AnalysisLengthTimeDay> iterator = queryList.iterator();
		while (iterator.hasNext()) {
			JSONObject bean = JSONObject.parseObject(JSONObject.toJSONString(iterator.next()));
			bulkRequest.add(client.prepareIndex(index, type).setSource(bean));
		}
		return bulkRequest;
	}
}
