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
import com.cictec.yyjk.linenet.model.entity.NetXmlConfig;
import com.cictec.yyjk.linenet.model.vo.NetXmlConfigVo;
import com.cictec.yyjk.linenet.service.NetXmlConfigService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by mao on 2019/10/18.
*/
@RestController
@RequestMapping("/api/net/xml/config")
public class ApiNetXmlConfig {
    @Resource
    private NetXmlConfigService netXmlConfigService;

    @PostMapping("/add")
    public Result add(@RequestBody NetXmlConfig netXmlConfig) {
        netXmlConfigService.insertSelective(netXmlConfig);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        netXmlConfigService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody NetXmlConfig netXmlConfig) {
        netXmlConfigService.updateByPrimaryKeySelective(netXmlConfig);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        NetXmlConfig netXmlConfig = netXmlConfigService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(netXmlConfig);
    }

	@PostMapping("/list")
    public Result list(@RequestBody NetXmlConfigVo netXmlConfigVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(netXmlConfigVo.getPageSize() != null && netXmlConfigVo.getPageSize() != 0){
    		return pageList(netXmlConfigVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<NetXmlConfig> list = netXmlConfigService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody NetXmlConfigVo netXmlConfigVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netXmlConfigVo.getPageNumber(), netXmlConfigVo.getPageSize());
		// TODO 根据具体业务重写
    	List<NetXmlConfig> list = netXmlConfigService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<NetXmlConfig>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<NetXmlConfig> pageInfo = netXmlConfigService.selectPage(netXmlConfigVo.getPageNumber(), netXmlConfigVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
