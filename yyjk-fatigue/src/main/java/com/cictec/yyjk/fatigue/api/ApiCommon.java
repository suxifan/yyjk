package com.cictec.yyjk.fatigue.api;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.api.BaseController;
import com.cictec.yyjk.base.model.entity.BaseUserInfo;
import com.cictec.yyjk.base.service.BaseUserInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.fatigue.model.vo.CommonVo;
import com.cictec.yyjk.fatigue.model.vo.TSysDatadictVo;
import com.cictec.yyjk.fatigue.service.TSysDatadictService;

/**
 * 通用接口管理Control Created by Rwq on 2019/05/22.
 */
@RestController
@RequestMapping("/common")
public class ApiCommon extends BaseController {
	private static Logger LOG = LoggerFactory.getLogger(ApiCommon.class);
    @Resource
	private TSysDatadictService tSysDatadictService; // 报警管理server
	@Resource
	private BaseUserInfoService baseUserInfoService;
    
    /**
	 * 报警类型管理--下拉查询
	 */
	@PostMapping("/warntypes/get")
	public Result List(@RequestBody TSysDatadictVo vo, HttpServletRequest request) {
    	Result result = null;
        try {
			BaseUserInfo userInfo = getUserIdByToken(request);
			LOG.info("登录用户Id:{}", userInfo.getUserId());
        	vo.setPlIsvalid("1");
			List<CommonVo> list = tSysDatadictService.selectList(vo, userInfo);
        	result = ResultUtil.getSuccessResult(list);
		} catch (Exception e) {
			LOG.error("查询报警类型失败，原因：{}", e);
			result = ResultUtil.getFailResult();
		}
        return result;
	}
	
	
}
