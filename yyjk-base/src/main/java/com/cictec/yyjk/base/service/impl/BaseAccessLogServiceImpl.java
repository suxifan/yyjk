package com.cictec.yyjk.base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BaseAccessLogMapper;
import com.cictec.yyjk.base.mapper.BaseUserInfoMapper;
import com.cictec.yyjk.base.model.entity.BaseAccessLog;
import com.cictec.yyjk.base.model.entity.BaseResourceInfo;
import com.cictec.yyjk.base.model.view.GridChartOption;
import com.cictec.yyjk.base.model.vo.BaseAccessLogVo;
import com.cictec.yyjk.base.service.BaseAccessLogService;
import com.cictec.yyjk.commons.core.AbstractService;


/**
 * Created by xpguo on 2020/04/02.
 */
@Service
@Transactional
public class BaseAccessLogServiceImpl extends AbstractService<BaseAccessLog> implements BaseAccessLogService {

    @Resource
    private BaseAccessLogMapper baseAccessLogMapper;

	@Autowired
	private BaseUserInfoMapper baseUserInfoMapper;

	/**
	 * 根据条件获取用户访问日志信息
	 * 
	 * @param vo
	 * @return
	 */
	public List<BaseAccessLog> getAccsessLogs(BaseAccessLogVo vo) {
		return baseAccessLogMapper.getAccsessLogs(vo);
	}

	public GridChartOption accessLogStatisticAnalysis(Date startTime, Date endTime, String orgId) {
		List<Map<String, Object>> loginLogs = baseAccessLogMapper.accessLogStatisticAnalysis(startTime, endTime, orgId);
		if (CollectionUtils.isEmpty(loginLogs)) {
			return new GridChartOption();
		}
		List<String> xAxisNames = new ArrayList<String>();
		List<Object> accessCount = new ArrayList<>();
		for (Map<String, Object> logMap : loginLogs) {
			xAxisNames.add((String) logMap.get("orgName"));
			accessCount.add(logMap.get("accessCount"));
		}

		List<List<Object>> datas = new ArrayList<>();
		datas.add(accessCount);
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		return option;
	}

	public GridChartOption pageLogStatisticAnalysis(Date startTime, Date endTime, String orgId) {
		List<Map<String, Object>> loginLogs = baseAccessLogMapper.pageLogStatisticAnalysis(startTime, endTime, orgId);
		if (CollectionUtils.isEmpty(loginLogs)) {
			return new GridChartOption();
		}
		List<String> xAxisNames = new ArrayList<String>();
		List<Object> accessCount = new ArrayList<>();
		for (Map<String, Object> logMap : loginLogs) {
			xAxisNames.add((String) logMap.get("pageName"));
			accessCount.add(logMap.get("accessCount"));
		}

		List<List<Object>> datas = new ArrayList<>();
		datas.add(accessCount);
		GridChartOption option = new GridChartOption();
		option.setDatas(datas);
		option.setxAxisNames(xAxisNames);
		return option;
	}

	@Override
	public Map<String, List<String>> getModelAndPageInfoByUserId(String userId) {
		List<BaseResourceInfo> queryList = baseUserInfoMapper.getPermissionsByUserId(userId);
		if (CollectionUtils.isEmpty(queryList)) {
			return Collections.emptyMap();
		}
		Map<String, List<String>> result = new HashMap<>();
		List<String> models = new ArrayList<>();
		List<String> pages = new ArrayList<>();
		for (BaseResourceInfo bean : queryList) {
			if ("1".equals(bean.getResourceType())) {
				models.add(bean.getResourceTitle());
			}
			if ("3".equals(bean.getResourceType())) {
				pages.add(bean.getResourceTitle());
			}
		}
		result.put("models", models);
		result.put("pages", pages);
		return result;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] splits=input.split(" ");
        int length=splits.length;
        System.out.println(splits[length-1].length());
	}
}
