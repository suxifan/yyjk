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
import com.cictec.yyjk.timingtask.model.entity.DwDimBusLineDeviceId;
import com.cictec.yyjk.timingtask.model.vo.DwDimBusLineDeviceIdVo;
import com.cictec.yyjk.timingtask.service.DwDimBusLineDeviceIdService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/12/26.
*/
@RestController
@RequestMapping("/api/dw/dim/bus/line/device/id")
public class ApiDwDimBusLineDeviceId {
    @Resource
    private DwDimBusLineDeviceIdService dwDimBusLineDeviceIdService;

    @PostMapping("/add")
    public Result add(@RequestBody DwDimBusLineDeviceId dwDimBusLineDeviceId) {
        dwDimBusLineDeviceIdService.insertSelective(dwDimBusLineDeviceId);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        dwDimBusLineDeviceIdService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DwDimBusLineDeviceId dwDimBusLineDeviceId) {
        dwDimBusLineDeviceIdService.updateByPrimaryKeySelective(dwDimBusLineDeviceId);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DwDimBusLineDeviceId dwDimBusLineDeviceId = dwDimBusLineDeviceIdService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(dwDimBusLineDeviceId);
    }

	@PostMapping("/list")
    public Result list(@RequestBody DwDimBusLineDeviceIdVo dwDimBusLineDeviceIdVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(dwDimBusLineDeviceIdVo.getPageSize() != null && dwDimBusLineDeviceIdVo.getPageSize() != 0){
    		return pageList(dwDimBusLineDeviceIdVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<DwDimBusLineDeviceId> list = dwDimBusLineDeviceIdService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody DwDimBusLineDeviceIdVo dwDimBusLineDeviceIdVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(dwDimBusLineDeviceIdVo.getPageNumber(), dwDimBusLineDeviceIdVo.getPageSize());
		// TODO 根据具体业务重写
    	List<DwDimBusLineDeviceId> list = dwDimBusLineDeviceIdService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<DwDimBusLineDeviceId>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<DwDimBusLineDeviceId> pageInfo = dwDimBusLineDeviceIdService.selectPage(dwDimBusLineDeviceIdVo.getPageNumber(), dwDimBusLineDeviceIdVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
