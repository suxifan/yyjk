package com.cictec.yyjk.timingtask.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.timingtask.model.entity.AnalysisArriveVolumeDay;
import com.cictec.yyjk.timingtask.model.vo.AnalysisArriveVolumeDayVo;
import com.cictec.yyjk.timingtask.service.AnalysisArriveVolumeDayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/05/23.
*/
@RestController
@RequestMapping("/api/analysis/arrive/volume/day")
public class ApiAnalysisArriveVolumeDay {
    @Resource
    private AnalysisArriveVolumeDayService analysisArriveVolumeDayService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisArriveVolumeDay analysisArriveVolumeDay) {
        analysisArriveVolumeDayService.insertSelective(analysisArriveVolumeDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisArriveVolumeDayService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisArriveVolumeDay analysisArriveVolumeDay) {
        analysisArriveVolumeDayService.updateByPrimaryKeySelective(analysisArriveVolumeDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        AnalysisArriveVolumeDay analysisArriveVolumeDay = analysisArriveVolumeDayService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(analysisArriveVolumeDay);
    }

	@PostMapping("/list")
    public Result list(@RequestBody AnalysisArriveVolumeDayVo analysisArriveVolumeDayVo) {
    
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(analysisArriveVolumeDayVo.getPageSize() != null && analysisArriveVolumeDayVo.getPageSize() != 0){
    		return pageList(analysisArriveVolumeDayVo);
    	}
    	
		// TODO 根据具体业务重写
    	List<AnalysisArriveVolumeDay> list = analysisArriveVolumeDayService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody AnalysisArriveVolumeDayVo analysisArriveVolumeDayVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(analysisArriveVolumeDayVo.getPageNumber(), analysisArriveVolumeDayVo.getPageSize());
		// TODO 根据具体业务重写
    	List<AnalysisArriveVolumeDay> list = analysisArriveVolumeDayService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<AnalysisArriveVolumeDay>(list));
    	
    	/*
		 * 方法二：
		 */
//		String orderBy = sort + " " + order;
// 		PageInfo<AnalysisArriveVolumeDay> pageInfo = analysisArriveVolumeDayService.selectPage(analysisArriveVolumeDayVo.getPageNumber(), analysisArriveVolumeDayVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
