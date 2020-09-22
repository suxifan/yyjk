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
import com.cictec.yyjk.timingtask.model.entity.AnalysisCapacityVolumeDay;
import com.cictec.yyjk.timingtask.model.vo.AnalysisCapacityVolumeDayVo;
import com.cictec.yyjk.timingtask.service.AnalysisCapacityVolumeDayService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/05/22.
*/
@RestController
@RequestMapping("/api/analysis/capacity/volume/day")
public class ApiAnalysisCapacityVolumeDay {
    @Resource
    private AnalysisCapacityVolumeDayService analysisCapacityVolumeDayService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisCapacityVolumeDay analysisCapacityVolumeDay) {
        analysisCapacityVolumeDayService.insertSelective(analysisCapacityVolumeDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisCapacityVolumeDayService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisCapacityVolumeDay analysisCapacityVolumeDay) {
        analysisCapacityVolumeDayService.updateByPrimaryKeySelective(analysisCapacityVolumeDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisCapacityVolumeDay analysisCapacityVolumeDay = analysisCapacityVolumeDayService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisCapacityVolumeDay);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisCapacityVolumeDayVo analysisCapacityVolumeDayVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisCapacityVolumeDayVo.getPageSize() != null && analysisCapacityVolumeDayVo.getPageSize() != 0){
    		return pageList(analysisCapacityVolumeDayVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<AnalysisCapacityVolumeDay> list = analysisCapacityVolumeDayService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisCapacityVolumeDayVo analysisCapacityVolumeDayVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisCapacityVolumeDayVo.getPageNumber(), analysisCapacityVolumeDayVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisCapacityVolumeDay> list = analysisCapacityVolumeDayService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisCapacityVolumeDay>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisCapacityVolumeDay> pageInfo = analysisCapacityVolumeDayService.selectPage(analysisCapacityVolumeDayVo.getPageNumber(), analysisCapacityVolumeDayVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
