package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseAccessLog;
import com.cictec.yyjk.base.model.view.GridChartOption;
import com.cictec.yyjk.base.model.vo.BaseAccessLogVo;
import com.cictec.yyjk.base.service.BaseAccessLogService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2020/04/02.
*/
@RestController
@RequestMapping("/api/base/accesslog")
public class ApiBaseAccessLog {
    @Resource
    private BaseAccessLogService baseAccessLogService;

	@PostMapping("/list")
    public Result list(@RequestBody BaseAccessLogVo baseAccessLogVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseAccessLogVo.getPageSize() != null && baseAccessLogVo.getPageSize() != 0){
    		return pageList(baseAccessLogVo);
    	}
		// 根据具体业务重写
		List<BaseAccessLog> list = baseAccessLogService.getAccsessLogs(baseAccessLogVo);
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseAccessLogVo baseAccessLogVo) {
		// 分页数据请求处理
		PageHelper.startPage(baseAccessLogVo.getPageNumber(), baseAccessLogVo.getPageSize());
		// 根据具体业务重写
		List<BaseAccessLog> list = baseAccessLogService.getAccsessLogs(baseAccessLogVo);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseAccessLog>(list));
	}
	
	/**
	 * 分公司访问日志分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "/accessLogStatisticAnalysis")
	public Result accessLogStatisticAnalysis(@RequestBody Map<String, Object> queryCondition) {
		String startDate = (String) queryCondition.get("startTime");
		String endDate = (String) queryCondition.get("endTime");
		String orgId = (String) queryCondition.get("orgId");
		Date startTime = DateUtils.parseDateTime(startDate + " 00:00:00");
		Date endTime = DateUtils.parseDateTime(endDate + " 23:59:59");
		GridChartOption barChartOption = baseAccessLogService.accessLogStatisticAnalysis(startTime, endTime, orgId);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 页面访问日志分析
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "/pageLogStatisticAnalysis")
	public Result pageLogStatisticAnalysis(@RequestBody Map<String, Object> queryCondition) {
		String startDate = (String) queryCondition.get("startTime");
		String endDate = (String) queryCondition.get("endTime");
		String orgId = (String) queryCondition.get("orgId");
		Date startTime = DateUtils.parseDateTime(startDate + " 00:00:00");
		Date endTime = DateUtils.parseDateTime(endDate + " 23:59:59");
		GridChartOption barChartOption = baseAccessLogService.pageLogStatisticAnalysis(startTime, endTime, orgId);
		return ResultUtil.getSuccessResult(barChartOption);
	}

	/**
	 * 根据用户id获取用户权限（用户所有角色权限）
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/getModelAndPageInfoByUserId")
	public Result getModelAndPageInfoByUserId(@RequestBody Map<String, Object> paramMap) {
		Map<String, List<String>> result = baseAccessLogService
				.getModelAndPageInfoByUserId((String) paramMap.get("userId"));
		return ResultUtil.getSuccessResult(result);
	}
}
