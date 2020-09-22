package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseLoginLog;
import com.cictec.yyjk.base.model.view.GridChartOption;
import com.cictec.yyjk.base.model.vo.BaseLoginLogVo;
import com.cictec.yyjk.base.service.BaseLoginLogService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2020/04/02.
*/
@RestController
@RequestMapping("/api/base/loginlog")
public class ApiBaseLoginLog {
    @Resource
    private BaseLoginLogService baseLoginLogService;

	@PostMapping("/list")
    public Result list(@RequestBody BaseLoginLogVo baseLoginLogVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseLoginLogVo.getPageSize() != null && baseLoginLogVo.getPageSize() != 0){
    		return pageList(baseLoginLogVo);
    	}
    	
		// 根据具体业务重写
		List<BaseLoginLog> list = baseLoginLogService.getLoginLogs(baseLoginLogVo);
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseLoginLogVo baseLoginLogVo) {
		// 分页数据请求处理
		PageHelper.startPage(baseLoginLogVo.getPageNumber(), baseLoginLogVo.getPageSize());
		List<BaseLoginLog> list = baseLoginLogService.getLoginLogs(baseLoginLogVo);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseLoginLog>(list));
	}
	
	/**
	 * 每天登录情况统计
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "/loginLogStatisticAnalysis")
	public Result getUpLineCapacityChartDatas(@RequestBody Map<String, Object> queryCondition) {
		String startDate = (String) queryCondition.get("startTime");
		String endDate = (String) queryCondition.get("endTime");
		Date startTime = DateUtils.parseDateTime(startDate + " 00:00:00");
		Date endTime = DateUtils.parseDateTime(endDate + " 23:59:59");
		GridChartOption barChartOption = baseLoginLogService.loginLogStatisticAnalysis(startTime, endTime);
		return ResultUtil.getSuccessResult(barChartOption);
	}
}
