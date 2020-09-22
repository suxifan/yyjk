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
import com.cictec.yyjk.linenet.model.entity.NetDataLineGeo;
import com.cictec.yyjk.linenet.model.vo.NetDataLineGeoVo;
import com.cictec.yyjk.linenet.service.NetDataLineGeoService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2019/10/08.
*/
@RestController
@RequestMapping("/api/net/data/line/geo")
public class ApiNetDataLineGeo {
    @Resource
    private NetDataLineGeoService netDataLineGeoService;

    @PostMapping("/add")
    public Result add(@RequestBody NetDataLineGeo netDataLineGeo) {
        netDataLineGeoService.insertSelective(netDataLineGeo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        netDataLineGeoService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody NetDataLineGeo netDataLineGeo) {
        netDataLineGeoService.updateByPrimaryKeySelective(netDataLineGeo);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        NetDataLineGeo netDataLineGeo = netDataLineGeoService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(netDataLineGeo);
    }

	@PostMapping("/list")
    public Result list(@RequestBody NetDataLineGeoVo netDataLineGeoVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(netDataLineGeoVo.getPageSize() != null && netDataLineGeoVo.getPageSize() != 0){
    		return pageList(netDataLineGeoVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<NetDataLineGeo> list = netDataLineGeoService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody NetDataLineGeoVo netDataLineGeoVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netDataLineGeoVo.getPageNumber(), netDataLineGeoVo.getPageSize());
		// TODO 根据具体业务重写
    	List<NetDataLineGeo> list = netDataLineGeoService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<NetDataLineGeo>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<NetDataLineGeo> pageInfo = netDataLineGeoService.selectPage(netDataLineGeoVo.getPageNumber(), netDataLineGeoVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
