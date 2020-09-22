package com.cictec.yyjk.report.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.vo.BusSysOrgVo;
import com.cictec.yyjk.base.model.vo.BusVo;
import com.cictec.yyjk.base.service.BusService;
import com.cictec.yyjk.base.service.BusSysOrgService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.RestUtils;
import com.cictec.yyjk.report.model.vo.DispatchInfoVo;
import com.cictec.yyjk.report.model.vo.QueryCondition;
import com.cictec.yyjk.report.service.DispatchInfoService;

/**
 * 调度相关Http获取实时数据控制类
 * 
 * @author gxp
 *
 */
@RestController
@RequestMapping(value = "/zhfxpt/")
public class HttpDispatchController {
	private static final Logger logger = LoggerFactory.getLogger(HttpDispatchController.class);
	@Autowired
	private Environment env;
	
	@Autowired
	private DispatchInfoService dispatchInfoService;

	@Autowired
	private BusService busService;

	@Resource
	private BusSysOrgService busSysOrgService;
	
	/**
	 * 在线车辆数
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getOnlineBusNumber")
	public Result getOnlineBusNumber(@RequestBody QueryCondition queryCondition) {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getOnlineBusNumber";
		String result = RestUtils.getPostData(httpUrl, queryCondition.toString(), false);
		logger.info("在线车辆数  url:{},result:{}", httpUrl, result);
		BusVo busVo = new BusVo();
		busVo.setOrgId(queryCondition.getOrgId());
		Integer busNum = busService.getTotalBus(queryCondition.getOrgId());// getBusByExample(busVo);
		JSONObject obj = null;
		if (PMSUtils.isNotEmpty(result)) {
			obj = JSON.parseObject(result);
			obj.put("totalBusNumber", busNum);
			return ResultUtil.getSuccessResult(obj);
		} else {
			JSONObject obj2 = new JSONObject();
			obj2.put("onlineBusNumber", 0);
			obj2.put("totalBusNumber", busNum);
			return ResultUtil.getSuccessResult(obj2);
		}
	}

	/**
	 * 运营(待发)车辆数
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getOperateBusNumber")
	public Result getOperateBusNumber(@RequestBody QueryCondition queryCondition) {
		String httpUrl = env.getProperty("gjdd.http.url") + "/getOperateBusNumber";
		String result = RestUtils.getPostData(httpUrl, queryCondition.toString(), false);
		logger.info("运营(待发)车辆数 url:{},result:{}", httpUrl, result);
		JSONObject obj = null;
		if (PMSUtils.isNotEmpty(result)) {
			obj = JSON.parseObject(result);
		}
		return ResultUtil.getSuccessResult(obj);
	}


	/**
	 * 实时里程
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getRealtimeMileage")
	public Result getRealtimeMileage(@RequestBody QueryCondition queryCondition) {
		long startTime = System.currentTimeMillis();
		String httpUrl = env.getProperty("gjdd.http.url") + "/getRealtimeMileage";
		String result = RestUtils.getPostData(httpUrl, queryCondition.toString(), false);
		long httpTime = System.currentTimeMillis();
		logger.debug("http 实时里程时间:" + (httpTime - startTime) + "");
		logger.info("实时里程 url:{},result:{}", httpUrl, result.toString());
		try {
			List<DispatchInfoVo> realList = parseJsons(result);
			return ResultUtil.getSuccessResult(filtData(realList));
		} catch (Exception ex) {
			logger.error("获取实时里程异常！{}", ex);
		}
		return ResultUtil.getErrorResult();
	}
	
	/**
	 * 实时趟次
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "getRealtimeTrips")
	public Result getRealtimeTrips(@RequestBody QueryCondition queryCondition) {
		long startTime = System.currentTimeMillis();
		String httpUrl = env.getProperty("gjdd.http.url") + "/getRealtimeTrips";
		String result = RestUtils.getPostData(httpUrl, queryCondition.toString(), false);
		long httpTime = System.currentTimeMillis();
		logger.debug("http 实时趟次时间:" + (httpTime - startTime) + "");
		logger.info("实时趟次 url:{},result:{}", httpUrl, result.toString());
		try {
			List<DispatchInfoVo> realList = parseJsons(result);
			return ResultUtil.getSuccessResult(filtData(realList));
		} catch (Exception ex) {
			logger.error("获取实时趟次异常！{}", ex);
		}
		return ResultUtil.getErrorResult();
	}

	private List<DispatchInfoVo> parseJsons(String result) {
		if (StringUtils.isEmpty(result)) {
			return Collections.emptyList();
		}
		List<DispatchInfoVo> realList = new ArrayList<>();
		JSONArray arrays = JSON.parseArray(result);
		Iterator<Object> iterator = arrays.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
			realList.add(JSON.parseObject(JSON.toJSONString(next), DispatchInfoVo.class));
		}
		return realList;
	}

	private List<DispatchInfoVo> filtData(List<DispatchInfoVo> arrys) {
		if (arrys == null) {
			return Collections.emptyList();
		}
		List<DispatchInfoVo> result = new ArrayList<>();
		for(DispatchInfoVo item :arrys){
			if (!item.getOrgId().equals("1")) {
				// 设置displayLable
				if (item.getLineId() == null) {
					item.setDisplyLabel(item.getOrgName());
				} else {
					item.setDisplyLabel(item.getLineName());
				}
				result.add(item);
			}
		}
		return result;
	}
}
