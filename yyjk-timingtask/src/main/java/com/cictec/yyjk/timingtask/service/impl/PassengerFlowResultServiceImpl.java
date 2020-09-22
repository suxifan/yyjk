package com.cictec.yyjk.timingtask.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.elasticsearch.search.aggregations.metrics.sum.SumBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.timingtask.mapper.PassengerFlowResultMapper;
import com.cictec.yyjk.timingtask.model.entity.PassengerFlowResult;
import com.cictec.yyjk.timingtask.model.viewdata.OnOffPsersonNumberValue;
import com.cictec.yyjk.timingtask.model.vo.PassengerFlowResultVo;
import com.cictec.yyjk.timingtask.service.PassengerFlowResultService;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/05/21.
 */
@Service
@Transactional
public class PassengerFlowResultServiceImpl extends AbstractService<PassengerFlowResult>
		implements PassengerFlowResultService {
	@Resource(name = "client")
	private Client client;
	@Autowired
	private Environment env;

	@Resource
	private PassengerFlowResultMapper passengerFlowResultMapper;

	@Override
	public void clearTabel() {
		passengerFlowResultMapper.clearTabel();
	}

	@Override
	public void dropTabel() {
		passengerFlowResultMapper.dropTabel();
	}

	@Override
	public void copyTable() {
		passengerFlowResultMapper.copyTable();
	}

	@Override
	public List<PassengerFlowResult> getPassengerFlow() {
		return passengerFlowResultMapper.getPassengerFlow();
	}

	@Override
	public List<PassengerFlowResult> getPassengerFlowFromESNoPageExport(PassengerFlowResultVo passengerFlowResultVo) {
		SearchResponse response = queryDatasFromES(passengerFlowResultVo, false, true);
		SearchHits hits = response.getHits();
		List<PassengerFlowResult> result = new ArrayList<>();
		for (SearchHit hit : hits) {
			PassengerFlowResult bean = JSONObject.parseObject(hit.getSourceAsString(), PassengerFlowResult.class);
			result.add(bean);
		}
		return result;
	}

	@Override
	public List<PassengerFlowResult> getPassengerFlowFromESNoPageStatic(PassengerFlowResultVo passengerFlowResultVo) {
		SearchResponse response = queryDatasFromES(passengerFlowResultVo, false, false);
		SearchHits hits = response.getHits();
		List<PassengerFlowResult> result = new ArrayList<>();
		for (SearchHit hit : hits) {
			PassengerFlowResult bean = JSONObject.parseObject(hit.getSourceAsString(), PassengerFlowResult.class);
			result.add(bean);
		}
		return result;
	}

	@Override
	public PageInfo<PassengerFlowResult> getPassengerFlowFromES(PassengerFlowResultVo passengerFlowResultVo) {
		SearchResponse response = queryDatasFromES(passengerFlowResultVo, true, true);
		SearchHits hits = response.getHits();
		List<PassengerFlowResult> result = new ArrayList<>();
		for (SearchHit hit : hits) {
			PassengerFlowResult bean = JSONObject.parseObject(hit.getSourceAsString(), PassengerFlowResult.class);
			result.add(bean);
		}
		PageInfo<PassengerFlowResult> pageInfo = new PageInfo<>();
		pageInfo.setPageNum(passengerFlowResultVo.getPageNumber());
		pageInfo.setPageSize(passengerFlowResultVo.getPageSize());
		pageInfo.setTotal(hits.getTotalHits());
		pageInfo.setList(result);
		return pageInfo;
	}

	@SuppressWarnings("deprecation")
	private SearchResponse queryDatasFromES(PassengerFlowResultVo passengerFlowResultVo, boolean isPage,
			boolean isExport) {
		// 排序方式
		SortBuilder orgName = SortBuilders.fieldSort("orgName").order(SortOrder.ASC).ignoreUnmapped(true);
		SortBuilder pfrLineName = SortBuilders.fieldSort("pfrLineName").order(SortOrder.ASC).ignoreUnmapped(true);
		SortBuilder prfBusPlateNumber = SortBuilders.fieldSort("prfBusPlateNumber").order(SortOrder.ASC)
				.ignoreUnmapped(true);
		// SortBuilder pfrLineType =
		// SortBuilders.fieldSort("pfrLineType").order(SortOrder.ASC).ignoreUnmapped(true);
		SortBuilder pfrUploadTime = SortBuilders.fieldSort("pfrUploadTime").order(SortOrder.ASC).ignoreUnmapped(true);
		SortBuilder pfrStationSeq = SortBuilders.fieldSort("pfrStationSeq").order(SortOrder.ASC).ignoreUnmapped(true);
		// 查询条件
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getOrgId()) && !"1".equals(passengerFlowResultVo.getOrgId())) {
			boolQuery.must(QueryBuilders.matchPhraseQuery("orgUuid", passengerFlowResultVo.getOrgId()));
		}
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getLineId())) {
			boolQuery.must(QueryBuilders.matchPhraseQuery("pfrLineUuid", passengerFlowResultVo.getLineId()));
		}
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getLineType())) {
			boolQuery.must(QueryBuilders.termQuery("pfrLineType", passengerFlowResultVo.getLineType()));
		}
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getBusNumber())) {
			boolQuery.must(
					// QueryBuilders.wildcardQuery("prfBusPlateNumber", "
					// passengerFlowResultVo.getBusNumber()"));
					QueryBuilders.matchPhraseQuery("prfBusPlateNumber", passengerFlowResultVo.getBusNumber()));
		}
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getBusSelfCode())) {
			boolQuery.must(QueryBuilders.matchPhraseQuery("busSelfCode", passengerFlowResultVo.getBusSelfCode()));
		}
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getStartTime())) {
			boolQuery.must(
					QueryBuilders.rangeQuery("pfrUploadTime").gte(passengerFlowResultVo.getStartTime().getTime()));
		}
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getEndTime())) {
			boolQuery.must(QueryBuilders.rangeQuery("pfrUploadTime").lte(passengerFlowResultVo.getEndTime().getTime()));
		}
		// 客流明细添加趟次范围条件
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getStartTrips())) {
			boolQuery.must(QueryBuilders.rangeQuery("pfrTripTime").gte(passengerFlowResultVo.getStartTrips()));
		}
		if (PMSUtils.isNotEmpty(passengerFlowResultVo.getEndTrips())) {
			boolQuery.must(QueryBuilders.rangeQuery("pfrTripTime").lte(passengerFlowResultVo.getEndTrips()));
		}
		String index = env.getProperty("elasticsearch.cluster.index");
		SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index)//
				.setTypes("mid_passenger_flow_result").setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(boolQuery).addSort(orgName).addSort(pfrLineName).addSort(prfBusPlateNumber)// .addSort(pfrLineType)
				.addSort(pfrUploadTime).addSort(pfrStationSeq);
		if (isPage) {
			searchRequestBuilder
					.setFrom((passengerFlowResultVo.getPageNumber() - 1) * passengerFlowResultVo.getPageSize())
					.setSize(passengerFlowResultVo.getPageSize());
		} else {
			if (isExport) {
				searchRequestBuilder.setFrom(0).setSize(65540);
			} else {
				searchRequestBuilder.setFrom(0).setSize(10000000);
			}
		}
		return searchRequestBuilder.execute().actionGet();

	}

	@Override
	public void deletePassengerDatas(String month) {
		passengerFlowResultMapper.deletePassengerDatas(month);
	}

	@Override
	public List<PassengerFlowResult> getHortStationTopTen(String orgId, List<String> staUuids, List<String> lineUuids) {
		return passengerFlowResultMapper.getHortStationTopTen(orgId, staUuids, lineUuids);
	}

	@Override
	public List<PassengerFlowResult> getHortLineTopTen(String orgId, List<String> lineUuids) {
		return passengerFlowResultMapper.getHortLineTopTen(orgId, lineUuids);
	}

	@Override
	public List<OnOffPsersonNumberValue> getOnOffPersonCount(PassengerFlowResultVo passengerFlowResultVo) {
		return passengerFlowResultMapper.getOnOffPersonCount(passengerFlowResultVo);
	}

	@Override
	public List<OnOffPsersonNumberValue> getOnOffPersonCountByCompany(PassengerFlowResultVo passengerFlowResultVo) {
		return passengerFlowResultMapper.getOnOffPersonCountByCompany(passengerFlowResultVo);
	}

	@Override
	public List<PassengerFlowResult> getTodayPassengerFlow(PassengerFlowResultVo passengerFlowResultVo) {
		return passengerFlowResultMapper.getTodayPassengerFlow(passengerFlowResultVo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getTodayTotalOnOffPassengerFlow(PassengerFlowResultVo passengerFlowResultVo) {
		return passengerFlowResultMapper.getTodayTotalOnOffPassengerFlow(passengerFlowResultVo);
	}

	@Override
	public List<OnOffPsersonNumberValue> getTodayOnOffPersonCount(PassengerFlowResultVo passengerFlowResultVo) {
		return passengerFlowResultMapper.getTodayOnOffPersonCount(passengerFlowResultVo);
	}

	@Override
	public List<OnOffPsersonNumberValue> getTodayOnOffPersonCountByCompany(
			PassengerFlowResultVo passengerFlowResultVo) {
		return passengerFlowResultMapper.getTodayOnOffPersonCountByCompany(passengerFlowResultVo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getBusKlStatisticalFromDb(PassengerFlowResultVo passengerFlowResultVo) {
		return passengerFlowResultMapper.getTodayTotalPassengerFlowByBus(passengerFlowResultVo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getBusKlStatisticalFromES(PassengerFlowResultVo vo, boolean isPage) {
		List<Map> datas = new ArrayList<>();
		SearchResponse response = queryBusKlDatasFromES(vo, isPage);
		Terms orgNameTerms = response.getAggregations().get("orgName");
		for (Terms.Bucket orgName : orgNameTerms.getBuckets()) {
			Terms lineNameTerms = orgName.getAggregations().get("pfrLineName");
			for (Terms.Bucket lineName : lineNameTerms.getBuckets()) {
				Terms busPlanteNumberTerms = lineName.getAggregations().get("prfBusPlateNumber");
				for (Terms.Bucket busPlanteNumber : busPlanteNumberTerms.getBuckets()) {
					Terms busSelfCodeTerms = busPlanteNumber.getAggregations().get("busSelfCode");
					for (Terms.Bucket busSelfCode : busSelfCodeTerms.getBuckets()) {
						Terms devCodeTerms = busSelfCode.getAggregations().get("prfDevCode");
						for (Terms.Bucket devCode : devCodeTerms.getBuckets()) {
							Sum getOnNumber = devCode.getAggregations().get("pfrGetOnNumber");
							Sum getOffNumber = devCode.getAggregations().get("pfrGetOffNumber");
							Map<String, Object> map = new HashMap<>();
							map.put("orgName", (String) orgName.getKey());
							map.put("pfrLineName", (String) lineName.getKey());
							map.put("prfBusPlateNumber", (String) busPlanteNumber.getKey());
							map.put("busSelfCode", (String) busSelfCode.getKey());
							map.put("prfDevCode", (String) devCode.getKey());
							map.put("pfrGetOnNumber", (int) getOnNumber.getValue());
							map.put("pfrGetOffNumber", (int) getOffNumber.getValue());
							datas.add(map);
						}
					}
				}
			}
		}
		return datas;
	}

	@SuppressWarnings({ "rawtypes" })
	private SearchResponse queryBusKlDatasFromES(PassengerFlowResultVo vo, boolean isPage) {
		String index = env.getProperty("elasticsearch.cluster.index");
		// 查询条件
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		// 客流明细添加趟次范围条件
		if (PMSUtils.isNotEmpty(vo.getStartTime())) {
			boolQuery.must(QueryBuilders.rangeQuery("pfrUploadTime").gte(vo.getStartTime().getTime()));
		}
		if (PMSUtils.isNotEmpty(vo.getEndTime())) {
			boolQuery.must(QueryBuilders.rangeQuery("pfrUploadTime").lte(vo.getEndTime().getTime()));
		}
		SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index).setTypes("mid_passenger_flow_result")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(boolQuery);
		AggregationBuilder orgNameBuilder = AggregationBuilders.terms("orgName").field("orgName").size(0);
		AggregationBuilder lineNameBuilder = AggregationBuilders.terms("pfrLineName").field("pfrLineName").size(0);
		AggregationBuilder busPlateNumberBuilder = AggregationBuilders.terms("prfBusPlateNumber")
				.field("prfBusPlateNumber").size(0);
		AggregationBuilder busSelfCodeBuilder = AggregationBuilders.terms("busSelfCode").field("busSelfCode").size(0);
		AggregationBuilder devCodeBuilder = AggregationBuilders.terms("prfDevCode").field("prfDevCode").size(0);
		SumBuilder getOnNumberBuilder = AggregationBuilders.sum("pfrGetOnNumber").field("pfrGetOnNumber");
		SumBuilder getOffNumberBuilder = AggregationBuilders.sum("pfrGetOffNumber").field("pfrGetOffNumber");
		searchRequestBuilder.addAggregation(orgNameBuilder.subAggregation(
				lineNameBuilder.subAggregation(busPlateNumberBuilder.subAggregation(busSelfCodeBuilder.subAggregation(
						devCodeBuilder.subAggregation(getOnNumberBuilder).subAggregation(getOffNumberBuilder))))));
		if (isPage) {
			searchRequestBuilder.setFrom((vo.getPageNumber() - 1) * vo.getPageSize()).setSize(vo.getPageSize());
		} else {
			searchRequestBuilder.setFrom(0).setSize(65540);
		}
		return searchRequestBuilder.execute().actionGet();
	}
}
