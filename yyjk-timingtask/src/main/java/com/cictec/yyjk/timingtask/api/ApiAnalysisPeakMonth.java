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
import com.cictec.yyjk.timingtask.model.entity.AnalysisPeakMonth;
import com.cictec.yyjk.timingtask.model.vo.AnalysisPeakMonthVo;
import com.cictec.yyjk.timingtask.service.AnalysisPeakMonthService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/05/22.
*/
@RestController
@RequestMapping("/api/analysis/peak/month")
public class ApiAnalysisPeakMonth {
    @Resource
    private AnalysisPeakMonthService analysisPeakMonthService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisPeakMonth analysisPeakMonth) {
        analysisPeakMonthService.insertSelective(analysisPeakMonth);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisPeakMonthService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisPeakMonth analysisPeakMonth) {
        analysisPeakMonthService.updateByPrimaryKeySelective(analysisPeakMonth);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisPeakMonth analysisPeakMonth = analysisPeakMonthService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisPeakMonth);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisPeakMonthVo analysisPeakMonthVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisPeakMonthVo.getPageSize() != null && analysisPeakMonthVo.getPageSize() != 0){
    		return pageList(analysisPeakMonthVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<AnalysisPeakMonth> list = analysisPeakMonthService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisPeakMonthVo analysisPeakMonthVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisPeakMonthVo.getPageNumber(), analysisPeakMonthVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisPeakMonth> list = analysisPeakMonthService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisPeakMonth>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisPeakMonth> pageInfo = analysisPeakMonthService.selectPage(analysisPeakMonthVo.getPageNumber(), analysisPeakMonthVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
