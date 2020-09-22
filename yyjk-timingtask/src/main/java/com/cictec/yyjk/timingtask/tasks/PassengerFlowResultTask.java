package com.cictec.yyjk.timingtask.tasks;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

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
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.timingtask.model.entity.AnalysisPassengerFlowMonthTrend;
import com.cictec.yyjk.timingtask.model.entity.PassengerFlowResult;
import com.cictec.yyjk.timingtask.service.AnalysisPassengerFlowMonthTrendService;
import com.cictec.yyjk.timingtask.service.PassengerFlowResultService;

/**
 * 客流数据定时任务，将当天的客流数据补充相关信息后插入到中心库中和大数据库ES
 * 
 * @author xpguo
 *
 */
@Component
public class PassengerFlowResultTask {
	private static final Logger LOG = LoggerFactory.getLogger(PassengerFlowResultTask.class);
	@Resource(name = "client")
	private Client client;
	@Autowired
	private Environment env;

	@Autowired
	private PassengerFlowResultService passengerFlowResultService;

	@Autowired
	private AnalysisPassengerFlowMonthTrendService monthTrendService;

	/**
	 * 按线路获取车辆到站时刻信息(获取前一天数据) pg批量插入时参数个数有限制，目前的版本最大限制50132
	 */
	@Scheduled(cron = "${jobs.schedule.passengerflow}")
	public void start() {
		List<PassengerFlowResult> queryList = null;
		try {
			queryList = passengerFlowResultService.getPassengerFlow();
		} catch (Exception e) {
			LOG.error("获取前一天客流数据业务数据异常，错误原因：{}", e);
		}
		if (queryList != null && queryList.size() > 0) {
			insertDB(queryList);
			// insertES(queryList);
		}

		// 将客流数据按公司统计后插入客流月趋势表
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		String date = DateUtils.formatDate(calendar.getTime());
		Date startTime = DateUtils.parseDateTime(date + " 00:00:00");
		Date endTime = DateUtils.parseDateTime(date + " 23:59:59");
		List<AnalysisPassengerFlowMonthTrend> list = monthTrendService.countPassengerNumber(startTime, endTime);
		if (list != null && list.size() > 0) {
			LOG.info("统计月趋势表开始...");
			for (AnalysisPassengerFlowMonthTrend bean : list) {
				monthTrendService.insertSelective(bean);
			}
			LOG.info("统计月趋势表结束...");
		}

		// 备份当天客流数据表，避免异常导致前天数据被清空
		// 删除临时表
		LOG.info("删除临时表开始...");
		passengerFlowResultService.dropTabel();
		LOG.info("删除临时表结束...");
		// 备份当天客流数据
		LOG.info("备份当天客流数据开始...");
		passengerFlowResultService.copyTable();
		LOG.info("备份当天客流数据结束...");
		// 清空客流数据源表
		LOG.info("清空客流数据源表开始...");
		passengerFlowResultService.clearTabel();
		LOG.info("清空客流数据源表结束...");

		insertES(queryList);
	}

	/**
	 * 将数据入库
	 * 
	 * @param queryList
	 */
	private void insertDB(List<PassengerFlowResult> queryList) {
		// pageSize定为1000；表有28个字段，插入时一个批量传参1000*28 = 28000 ，小于50000，保证插入成功
		try {
			LOG.info("客流数据入库开始...");
			int total = queryList.size();
			int pageSize = 1000;
			int currentPage = 1;
			int pages = (total % pageSize) == 0 ? (total / pageSize) : (total / pageSize + 1);
			if (total < pageSize) {
				passengerFlowResultService.insertList(queryList);
			} else {
				while (currentPage <= pages) {
					int startIndex = (currentPage - 1) * pageSize;
					int endInde = (currentPage * pageSize) > total ? total : (currentPage * pageSize);
					passengerFlowResultService.insertList(queryList.subList(startIndex, endInde));
					currentPage++;
				}
			}
			LOG.info("客流数据入库结束...");
		} catch (Exception ex) {
			LOG.error("批量导入前一天客流数据失败!{}", ex);
		}
	}

	/**
	 * 将数据入ES
	 * 
	 * @param queryList
	 */
	private void insertES(List<PassengerFlowResult> queryList) {
		try {
			LOG.info("客流数据入库开始...");
			int pageSize = 5;
			int curentPage = 1;
			int total = queryList.size();
			int pageNumber = (total % pageSize) == 0 ? total / pageSize : (total / pageSize + 1);
			if (total <= pageSize) {
				BulkRequestBuilder bulkRequest = createESbulk(queryList);
				BulkResponse bulkResponse = bulkRequest.get();
				if (bulkResponse.hasFailures()) {
					LOG.error("客流数据插入ES操作失败！");
				}
			} else {
				while (curentPage <= pageNumber) {
					int startIndex = (curentPage - 1) * pageSize;
					int endIndex = (curentPage * pageSize) > total ? total : (curentPage * pageSize);
					BulkRequestBuilder bulkRequest = createESbulk(queryList.subList(startIndex, endIndex));
					BulkResponse bulkResponse = bulkRequest.get();
					if (bulkResponse.hasFailures()) {
						LOG.error("第" + curentPage + "批次客流数据插入ES操作失败！");
					}
					curentPage++;
				}
			}
			LOG.info("客流数据入库结束...");
		} catch (Exception ex) {
			LOG.error("客流数据导入失败！{}", ex);
		}
	}

	private BulkRequestBuilder createESbulk(List<PassengerFlowResult> queryList) {
		String index = env.getProperty("elasticsearch.cluster.index");
		BulkRequestBuilder bulkRequest = client.prepareBulk();
		if (queryList == null || queryList.size() == 0) {
			return bulkRequest;
		}

		Iterator<PassengerFlowResult> iterator = queryList.iterator();
		while (iterator.hasNext()) {
			JSONObject bean = JSONObject.parseObject(JSONObject.toJSONString(iterator.next()));
			bulkRequest.add(client.prepareIndex(index, "mid_passenger_flow_result").setSource(bean));
		}
		return bulkRequest;
	}
}
