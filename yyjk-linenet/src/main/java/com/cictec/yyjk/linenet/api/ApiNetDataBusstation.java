package com.cictec.yyjk.linenet.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.linenet.model.entity.NetDataBusstation;
import com.cictec.yyjk.linenet.model.vo.NetDataBusstationVo;
import com.cictec.yyjk.linenet.service.NetDataBusstationService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by mao on 2019/10/12.
*/
@RestController
@RequestMapping("/api/net/data/busstation")
public class ApiNetDataBusstation {
    @Resource
    private NetDataBusstationService netDataBusstationService;

    @PostMapping("/add")
    public Result add(@RequestBody NetDataBusstation netDataBusstation) {
        netDataBusstationService.insertSelective(netDataBusstation);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        netDataBusstationService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody NetDataBusstation netDataBusstation) {
        netDataBusstationService.updateByPrimaryKeySelective(netDataBusstation);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        NetDataBusstation netDataBusstation = netDataBusstationService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(netDataBusstation);
    }

	@PostMapping("/list")
    public Result list(@RequestBody NetDataBusstationVo netDataBusstationVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(netDataBusstationVo.getPageSize() != null && netDataBusstationVo.getPageSize() != 0){
    		return pageList(netDataBusstationVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<NetDataBusstation> list = netDataBusstationService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody NetDataBusstationVo netDataBusstationVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netDataBusstationVo.getPageNumber(), netDataBusstationVo.getPageSize());
		// TODO 根据具体业务重写
    	List<NetDataBusstation> list = netDataBusstationService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<NetDataBusstation>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<NetDataBusstation> pageInfo = netDataBusstationService.selectPage(netDataBusstationVo.getPageNumber(), netDataBusstationVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
