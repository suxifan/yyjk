package com.cictec.yyjk.base.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.base.model.entity.DwDimOtherBusDevice;
import com.cictec.yyjk.base.model.vo.DwDimOtherBusDeviceVo;
import com.cictec.yyjk.base.service.DwDimOtherBusDeviceService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/09/03.
*/
@RestController
@RequestMapping("/api/dw/dim/other/bus/device")
public class ApiDwDimOtherBusDevice {
    @Resource
    private DwDimOtherBusDeviceService dwDimOtherBusDeviceService;

    @PostMapping("/add")
    public Result add(@RequestBody DwDimOtherBusDevice dwDimOtherBusDevice) {
        dwDimOtherBusDeviceService.insertSelective(dwDimOtherBusDevice);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        dwDimOtherBusDeviceService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody DwDimOtherBusDevice dwDimOtherBusDevice) {
        dwDimOtherBusDeviceService.updateByPrimaryKeySelective(dwDimOtherBusDevice);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DwDimOtherBusDevice dwDimOtherBusDevice = dwDimOtherBusDeviceService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(dwDimOtherBusDevice);
    }

	@PostMapping("/list")
    public Result list(@RequestBody DwDimOtherBusDeviceVo dwDimOtherBusDeviceVo) {
    
		// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(dwDimOtherBusDeviceVo.getPageSize() != null && dwDimOtherBusDeviceVo.getPageSize() != 0){
    		return pageList(dwDimOtherBusDeviceVo);
    	}
    	
		// TODO 根据具体业务重写
    	List<DwDimOtherBusDevice> list = dwDimOtherBusDeviceService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody DwDimOtherBusDeviceVo dwDimOtherBusDeviceVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(dwDimOtherBusDeviceVo.getPageNumber(), dwDimOtherBusDeviceVo.getPageSize());
		// TODO 根据具体业务重写
    	List<DwDimOtherBusDevice> list = dwDimOtherBusDeviceService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<DwDimOtherBusDevice>(list));
    	
    	/*
		 * 方法二：
		 */
//		String orderBy = sort + " " + order;
// 		PageInfo<DwDimOtherBusDevice> pageInfo = dwDimOtherBusDeviceService.selectPage(dwDimOtherBusDeviceVo.getPageNumber(), dwDimOtherBusDeviceVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
