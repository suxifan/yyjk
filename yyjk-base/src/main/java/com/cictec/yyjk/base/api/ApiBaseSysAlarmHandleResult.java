package com.cictec.yyjk.base.api;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseSysAlarmHandleResult;
import com.cictec.yyjk.base.model.vo.BaseSysAlarmHandleResultVo;
import com.cictec.yyjk.base.service.BaseSysAlarmHandleResultService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2020/04/13.
*/
@RestController
@RequestMapping("/api/base/sys/alarm/handle/result")
public class ApiBaseSysAlarmHandleResult {
	private static final Logger LOG = LoggerFactory.getLogger(ApiBaseSysAlarmHandleResult.class);
    @Resource
    private BaseSysAlarmHandleResultService baseSysAlarmHandleResultService;

    @PostMapping("/add")
    public Result add(@RequestBody BaseSysAlarmHandleResult baseSysAlarmHandleResult) {
    	Result result = null;
    	try {
    		baseSysAlarmHandleResult.setUuid(PMSUtils.getUUID());
    		baseSysAlarmHandleResult.setCrateTime(new Date());
    		baseSysAlarmHandleResultService.insertSelective(baseSysAlarmHandleResult);
    		result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error("删除报警处理结果设置失败，原因{}", e);
			result = ResultUtil.getErrorResult();
		}
        return result;
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseSysAlarmHandleResult baseSysAlarmHandleResult) {
    	Result result = null;
		try {
			baseSysAlarmHandleResultService.deleteByPrimaryKey(baseSysAlarmHandleResult.getUuid());
			result = ResultUtil.getSuccessResult();
		} catch (Exception ex) {
			LOG.error("删除报警处理结果设置失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
        return result;
    }

    @PostMapping("/update")
    public Result update(@RequestBody BaseSysAlarmHandleResult baseSysAlarmHandleResult) {
    	Result result=null;
    	try {
    		baseSysAlarmHandleResultService.updateByPrimaryKey(baseSysAlarmHandleResult);
    		result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error("更新报警处理结果设置失败，原因{}", e);
			result = ResultUtil.getErrorResult();
		}
        return result;
    }

	@PostMapping("/getByStatus")
	public Result getByStatus (@RequestBody BaseSysAlarmHandleResultVo baseSysAlarmHandleResultVo) {
    	Result result=null;
    	try {
    		List<BaseSysAlarmHandleResult> list = baseSysAlarmHandleResultService.getBaseSysAlarmHandleResultByExample(baseSysAlarmHandleResultVo);
    		return ResultUtil.getSuccessResult(list);
		} catch (Exception ex) {
			LOG.error("分页查询报警处理结果设置失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
    	return result;
	}
	
	@AccessLogInfo(modelName = "系统管理", pageName = "报警处理结果设置")
	@PostMapping("/get")
	public Result get(@RequestBody BaseSysAlarmHandleResultVo baseSysAlarmHandleResultVo) {
    	Result result=null;
    	try {
    		PageHelper.startPage(baseSysAlarmHandleResultVo.getPageNumber(), baseSysAlarmHandleResultVo.getPageSize());
    		List<BaseSysAlarmHandleResult> list = baseSysAlarmHandleResultService.getBaseSysAlarmHandleResultByExample(baseSysAlarmHandleResultVo);
    		return ResultUtil.getSuccessResult(new PageInfo<BaseSysAlarmHandleResult>(list));
		} catch (Exception ex) {
			LOG.error("分页查询报警处理结果设置失败，原因{}", ex);
			result = ResultUtil.getErrorResult();
		}
    	return result;
	}
	
}
