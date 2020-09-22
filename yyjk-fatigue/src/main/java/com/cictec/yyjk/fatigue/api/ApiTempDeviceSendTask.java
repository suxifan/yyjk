package com.cictec.yyjk.fatigue.api;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTask;
import com.cictec.yyjk.fatigue.service.TempDeviceSendTaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 疲劳设备参数下发任务 Created by Rwq on 2019/11/21.
 */
@RestController
@RequestMapping("/api/temp/device/send/task")
public class ApiTempDeviceSendTask extends BaseController{
	private static final Logger LOG = LoggerFactory.getLogger(ApiTempDeviceSendTask.class);
    @Resource
    private TempDeviceSendTaskService tempDeviceSendTaskService;

    @PostMapping("/add")
	public Result add(@RequestBody TempDeviceSendTask tempDeviceSendTask, HttpServletRequest request) {
		Result result = null;
		try {
	    	tempDeviceSendTask.setTaskUuid(UUIDGenerator.genUuidStr());
	    	tempDeviceSendTask.setTaskCreateUser(getUserIdByToken(request).getUserAccount());
	    	tempDeviceSendTask.setTaskCreateTime(new Date());
	        tempDeviceSendTaskService.saveTask(tempDeviceSendTask);
	        result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			result = ResultUtil.getFailResult();
		}
        return result;
    }

    
    @PostMapping("/add2")
    public Result add2(@RequestBody TempDeviceSendTask tempDeviceSendTask) {
		Result result = null;
		try {
			tempDeviceSendTaskService.saveTask2(tempDeviceSendTask);
			result = ResultUtil.getSuccessResult();
		} catch (Exception e) {
			LOG.error("报警类型管理--下拉查询异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
    }
    
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tempDeviceSendTaskService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TempDeviceSendTask tempDeviceSendTask) {
        tempDeviceSendTaskService.updateByPrimaryKeySelective(tempDeviceSendTask);
        return ResultUtil.getSuccessResult();
    }

	/**
	 * 参数下发-下发任务列表（分页）
	 */
	@AccessLogInfo(modelName = "系统管理", pageName = "设备参数下发")
	@PostMapping("/taskPage/get")
	public Result pageList (@RequestBody TempDeviceSendTask vo) {
		Result result = null;
		try {
			PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
			List<TempDeviceSendTask> list = tempDeviceSendTaskService.selectTaskPage(vo);
			result = ResultUtil.getSuccessResult(new PageInfo<TempDeviceSendTask>(list));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}
    
	
	/**
	 * 参数下发-组织结构线路树结构
	 */
	@PostMapping("/orgLineBusTree/get")
	public Result orgLineBusTree(@RequestBody TempDeviceSendTask tempDeviceSendTask) {
		Result result = null;
		try {
			List<TreeNode2> list = tempDeviceSendTaskService.orgLineBusTreeGet();
			result = ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}

	
	
	
}
