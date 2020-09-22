package com.cictec.yyjk.base.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.base.model.entity.BaseVideoParamInfo;
import com.cictec.yyjk.base.model.vo.BaseVideoParamInfoVo;
import com.cictec.yyjk.base.service.BaseVideoParamInfoService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/11/12.
*/
@RestController
@RequestMapping("/api/base/video/param/info")
public class ApiBaseVideoParamInfo {
    @Resource
    private BaseVideoParamInfoService baseVideoParamInfoService;

    @PostMapping("/add")
    public Result add(@RequestBody BaseVideoParamInfo baseVideoParamInfo) {
        baseVideoParamInfoService.insertSelective(baseVideoParamInfo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        baseVideoParamInfoService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody BaseVideoParamInfo baseVideoParamInfo) {
        baseVideoParamInfoService.updateByPrimaryKeySelective(baseVideoParamInfo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        BaseVideoParamInfo baseVideoParamInfo = baseVideoParamInfoService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(baseVideoParamInfo);
    }

	@PostMapping("/list")
    public Result list(@RequestBody BaseVideoParamInfoVo baseVideoParamInfoVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(baseVideoParamInfoVo.getPageSize() != null && baseVideoParamInfoVo.getPageSize() != 0){
    		return pageList(baseVideoParamInfoVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<BaseVideoParamInfo> list = baseVideoParamInfoService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody BaseVideoParamInfoVo baseVideoParamInfoVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(baseVideoParamInfoVo.getPageNumber(), baseVideoParamInfoVo.getPageSize());
		// TODO 根据具体业务重写
    	List<BaseVideoParamInfo> list = baseVideoParamInfoService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<BaseVideoParamInfo>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<BaseVideoParamInfo> pageInfo = baseVideoParamInfoService.selectPage(baseVideoParamInfoVo.getPageNumber(), baseVideoParamInfoVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
