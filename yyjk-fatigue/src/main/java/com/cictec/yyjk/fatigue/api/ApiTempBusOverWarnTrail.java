package com.cictec.yyjk.fatigue.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.fatigue.model.entity.TempBusOverWarnTrail;
import com.cictec.yyjk.fatigue.model.vo.TempBusOverWarnTrailTempVo;
import com.cictec.yyjk.fatigue.service.TempBusOverWarnTrailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2020/02/13.
*/
@RestController
@RequestMapping("/api/temp/bus/over/warn/trail/temp")
public class ApiTempBusOverWarnTrail {
    @Resource
	private TempBusOverWarnTrailService tempBusOverWarnTrailService;

    @PostMapping("/add")
	public Result add(@RequestBody TempBusOverWarnTrail tempBusOverWarnTrailTemp) {
		tempBusOverWarnTrailService.insertSelective(tempBusOverWarnTrailTemp);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
		tempBusOverWarnTrailService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
	public Result update(@RequestBody TempBusOverWarnTrail tempBusOverWarnTrailTemp) {
		tempBusOverWarnTrailService.updateByPrimaryKeySelective(tempBusOverWarnTrailTemp);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
		TempBusOverWarnTrail tempBusOverWarnTrailTemp = tempBusOverWarnTrailService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(tempBusOverWarnTrailTemp);
    }

	@PostMapping("/list")
    public Result list(@RequestBody TempBusOverWarnTrailTempVo tempBusOverWarnTrailTempVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(tempBusOverWarnTrailTempVo.getPageSize() != null && tempBusOverWarnTrailTempVo.getPageSize() != 0){
    		return pageList(tempBusOverWarnTrailTempVo);
    	}
    	
    	// TODO 根据具体业务重写
		List<TempBusOverWarnTrail> list = tempBusOverWarnTrailService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody TempBusOverWarnTrailTempVo tempBusOverWarnTrailTempVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(tempBusOverWarnTrailTempVo.getPageNumber(), tempBusOverWarnTrailTempVo.getPageSize());
		// TODO 根据具体业务重写
		List<TempBusOverWarnTrail> list = tempBusOverWarnTrailService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<TempBusOverWarnTrail>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<TempBusOverWarnTrailTemp> pageInfo = tempBusOverWarnTrailTempService.selectPage(tempBusOverWarnTrailTempVo.getPageNumber(), tempBusOverWarnTrailTempVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
