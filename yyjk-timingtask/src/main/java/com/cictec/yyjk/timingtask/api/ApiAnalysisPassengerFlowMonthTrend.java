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
import com.cictec.yyjk.timingtask.model.entity.AnalysisPassengerFlowMonthTrend;
import com.cictec.yyjk.timingtask.model.vo.AnalysisPassengerFlowMonthTrendVo;
import com.cictec.yyjk.timingtask.service.AnalysisPassengerFlowMonthTrendService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/11/16.
*/
@RestController
@RequestMapping("/api/analysis/passenger/flow/month/trend")
public class ApiAnalysisPassengerFlowMonthTrend {
    @Resource
    private AnalysisPassengerFlowMonthTrendService analysisPassengerFlowMonthTrendService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisPassengerFlowMonthTrend analysisPassengerFlowMonthTrend) {
        analysisPassengerFlowMonthTrendService.insertSelective(analysisPassengerFlowMonthTrend);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisPassengerFlowMonthTrendService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisPassengerFlowMonthTrend analysisPassengerFlowMonthTrend) {
        analysisPassengerFlowMonthTrendService.updateByPrimaryKeySelective(analysisPassengerFlowMonthTrend);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisPassengerFlowMonthTrend analysisPassengerFlowMonthTrend = analysisPassengerFlowMonthTrendService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisPassengerFlowMonthTrend);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisPassengerFlowMonthTrendVo analysisPassengerFlowMonthTrendVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisPassengerFlowMonthTrendVo.getPageSize() != null && analysisPassengerFlowMonthTrendVo.getPageSize() != 0){
    		return pageList(analysisPassengerFlowMonthTrendVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<AnalysisPassengerFlowMonthTrend> list = analysisPassengerFlowMonthTrendService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisPassengerFlowMonthTrendVo analysisPassengerFlowMonthTrendVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisPassengerFlowMonthTrendVo.getPageNumber(), analysisPassengerFlowMonthTrendVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisPassengerFlowMonthTrend> list = analysisPassengerFlowMonthTrendService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisPassengerFlowMonthTrend>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisPassengerFlowMonthTrend> pageInfo = analysisPassengerFlowMonthTrendService.selectPage(analysisPassengerFlowMonthTrendVo.getPageNumber(), analysisPassengerFlowMonthTrendVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
