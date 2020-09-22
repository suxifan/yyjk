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
import com.cictec.yyjk.timingtask.model.entity.AnalysisFullloadDay;
import com.cictec.yyjk.timingtask.model.vo.AnalysisFullloadDayVo;
import com.cictec.yyjk.timingtask.service.AnalysisFullloadDayService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/05/22.
*/
@RestController
@RequestMapping("/api/analysis/fullload/day")
public class ApiAnalysisFullloadDay {
    @Resource
    private AnalysisFullloadDayService analysisFullloadDayService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisFullloadDay analysisFullloadDay) {
        analysisFullloadDayService.insertSelective(analysisFullloadDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisFullloadDayService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisFullloadDay analysisFullloadDay) {
        analysisFullloadDayService.updateByPrimaryKeySelective(analysisFullloadDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisFullloadDay analysisFullloadDay = analysisFullloadDayService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisFullloadDay);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisFullloadDayVo analysisFullloadDayVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisFullloadDayVo.getPageSize() != null && analysisFullloadDayVo.getPageSize() != 0){
    		return pageList(analysisFullloadDayVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<AnalysisFullloadDay> list = analysisFullloadDayService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisFullloadDayVo analysisFullloadDayVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisFullloadDayVo.getPageNumber(), analysisFullloadDayVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisFullloadDay> list = analysisFullloadDayService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisFullloadDay>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisFullloadDay> pageInfo = analysisFullloadDayService.selectPage(analysisFullloadDayVo.getPageNumber(), analysisFullloadDayVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
