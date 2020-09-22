package com.cictec.yyjk.fatigue.api;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTaskDetail;
import com.cictec.yyjk.fatigue.service.TempDeviceSendTaskDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 疲劳设备参数下发任务详情 Created by Rwq on 2019/11/21.
 */
@RestController
@RequestMapping("/api/temp/device/send/task/detail")
public class ApiTempDeviceSendTaskDetail {
	private static final Logger LOG = LoggerFactory.getLogger(ApiTempDeviceSendTaskDetail.class);
    @Resource
    private TempDeviceSendTaskDetailService tempDeviceSendTaskDetailService;

    
	/**
	 * 参数下发-下发任务列表（分页）
	 */
	@PostMapping("/taskDetailPage/get")
	public Result pageList (@RequestBody TempDeviceSendTaskDetail vo) {
		Result result = null;
		try {
			PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
			List<TempDeviceSendTaskDetail> list = tempDeviceSendTaskDetailService.selectTaskDetailPage(vo);
			result = ResultUtil.getSuccessResult(new PageInfo<TempDeviceSendTaskDetail>(list));
		} catch (Exception e) {
			LOG.error("分页查询下发任务列表异常，原因{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}


	
}
