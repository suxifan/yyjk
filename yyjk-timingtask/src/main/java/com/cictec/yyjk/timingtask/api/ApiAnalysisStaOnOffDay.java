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
import com.cictec.yyjk.timingtask.model.entity.AnalysisStaOnOffDay;
import com.cictec.yyjk.timingtask.model.vo.AnalysisStaOnOffDayVo;
import com.cictec.yyjk.timingtask.service.AnalysisStaOnOffDayService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/05/22.
*/
@RestController
@RequestMapping("/api/analysis/sta/on/off/day")
public class ApiAnalysisStaOnOffDay {
    @Resource
    private AnalysisStaOnOffDayService analysisStaOnOffDayService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisStaOnOffDay analysisStaOnOffDay) {
        analysisStaOnOffDayService.insertSelective(analysisStaOnOffDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisStaOnOffDayService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisStaOnOffDay analysisStaOnOffDay) {
        analysisStaOnOffDayService.updateByPrimaryKeySelective(analysisStaOnOffDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisStaOnOffDay analysisStaOnOffDay = analysisStaOnOffDayService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisStaOnOffDay);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisStaOnOffDayVo analysisStaOnOffDayVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisStaOnOffDayVo.getPageSize() != null && analysisStaOnOffDayVo.getPageSize() != 0){
    		return pageList(analysisStaOnOffDayVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<AnalysisStaOnOffDay> list = analysisStaOnOffDayService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisStaOnOffDayVo analysisStaOnOffDayVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisStaOnOffDayVo.getPageNumber(), analysisStaOnOffDayVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisStaOnOffDay> list = analysisStaOnOffDayService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisStaOnOffDay>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisStaOnOffDay> pageInfo = analysisStaOnOffDayService.selectPage(analysisStaOnOffDayVo.getPageNumber(), analysisStaOnOffDayVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
