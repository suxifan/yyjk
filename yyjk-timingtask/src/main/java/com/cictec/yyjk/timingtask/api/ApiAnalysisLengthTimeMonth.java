package com.cictec.yyjk.timingtask.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeMonth;
import com.cictec.yyjk.timingtask.model.vo.AnalysisLengthTimeMonthVo;
import com.cictec.yyjk.timingtask.service.AnalysisLengthTimeMonthService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/05/22.
*/
@RestController
@RequestMapping("/api/analysis/length/time/month")
public class ApiAnalysisLengthTimeMonth {
    @Resource
    private AnalysisLengthTimeMonthService analysisLengthTimeMonthService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisLengthTimeMonth analysisLengthTimeMonth) {
        analysisLengthTimeMonthService.insertSelective(analysisLengthTimeMonth);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisLengthTimeMonthService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisLengthTimeMonth analysisLengthTimeMonth) {
        analysisLengthTimeMonthService.updateByPrimaryKeySelective(analysisLengthTimeMonth);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisLengthTimeMonth analysisLengthTimeMonth = analysisLengthTimeMonthService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisLengthTimeMonth);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisLengthTimeMonthVo analysisLengthTimeMonthVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisLengthTimeMonthVo.getPageSize() != null && analysisLengthTimeMonthVo.getPageSize() != 0){
    		return pageList(analysisLengthTimeMonthVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<AnalysisLengthTimeMonth> list = analysisLengthTimeMonthService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisLengthTimeMonthVo analysisLengthTimeMonthVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisLengthTimeMonthVo.getPageNumber(), analysisLengthTimeMonthVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisLengthTimeMonth> list = analysisLengthTimeMonthService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisLengthTimeMonth>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisLengthTimeMonth> pageInfo = analysisLengthTimeMonthService.selectPage(analysisLengthTimeMonthVo.getPageNumber(), analysisLengthTimeMonthVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
