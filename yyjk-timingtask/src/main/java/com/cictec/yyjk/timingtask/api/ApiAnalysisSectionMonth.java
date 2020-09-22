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
import com.cictec.yyjk.timingtask.model.entity.AnalysisSectionMonth;
import com.cictec.yyjk.timingtask.model.vo.AnalysisSectionMonthVo;
import com.cictec.yyjk.timingtask.service.AnalysisSectionMonthService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/05/22.
*/
@RestController
@RequestMapping("/api/analysis/section/month")
public class ApiAnalysisSectionMonth {
    @Resource
    private AnalysisSectionMonthService analysisSectionMonthService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisSectionMonth analysisSectionMonth) {
        analysisSectionMonthService.insertSelective(analysisSectionMonth);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisSectionMonthService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisSectionMonth analysisSectionMonth) {
        analysisSectionMonthService.updateByPrimaryKeySelective(analysisSectionMonth);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisSectionMonth analysisSectionMonth = analysisSectionMonthService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisSectionMonth);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisSectionMonthVo analysisSectionMonthVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisSectionMonthVo.getPageSize() != null && analysisSectionMonthVo.getPageSize() != 0){
    		return pageList(analysisSectionMonthVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<AnalysisSectionMonth> list = analysisSectionMonthService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisSectionMonthVo analysisSectionMonthVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisSectionMonthVo.getPageNumber(), analysisSectionMonthVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisSectionMonth> list = analysisSectionMonthService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisSectionMonth>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisSectionMonth> pageInfo = analysisSectionMonthService.selectPage(analysisSectionMonthVo.getPageNumber(), analysisSectionMonthVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
