package com.cictec.yyjk.base.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.BaseAccessPageLog;
import com.cictec.yyjk.base.model.vo.BaseAccessPageLogVo;
import com.cictec.yyjk.base.service.BaseAccessPageLogService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2020/04/13.
*/
@RestController
@RequestMapping("/api/base/accesspagelog")
public class ApiBaseAccessPageLog {
    @Resource
    private BaseAccessPageLogService baseAccessPageLogService;

    @PostMapping("/add")
    public Result add(@RequestBody BaseAccessPageLog baseAccessPageLog) {
        baseAccessPageLogService.insertSelective(baseAccessPageLog);
        return ResultUtil.getSuccessResult();
    }

	@PostMapping("/list")
    public Result list(@RequestBody BaseAccessPageLogVo baseAccessPageLogVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseAccessPageLogVo.getPageSize() != null && baseAccessPageLogVo.getPageSize() != 0){
    		return pageList(baseAccessPageLogVo);
    	}
		List<BaseAccessPageLog> list = baseAccessPageLogService.getAccessPageLogs(baseAccessPageLogVo);
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseAccessPageLogVo baseAccessPageLogVo) {
		// 分页数据请求处理
		PageHelper.startPage(baseAccessPageLogVo.getPageNumber(), baseAccessPageLogVo.getPageSize());
		List<BaseAccessPageLog> list = baseAccessPageLogService.getAccessPageLogs(baseAccessPageLogVo);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseAccessPageLog>(list));
	}
	
}
