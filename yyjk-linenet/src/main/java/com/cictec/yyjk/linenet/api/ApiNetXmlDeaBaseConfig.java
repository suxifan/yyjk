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
import com.cictec.yyjk.linenet.model.entity.NetXmlDeaBaseConfig;
import com.cictec.yyjk.linenet.model.vo.NetXmlDeaBaseConfigVo;
import com.cictec.yyjk.linenet.service.NetXmlDeaBaseConfigService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by mao on 2019/10/22.
*/
@RestController
@RequestMapping("/api/net/xml/dea/base/config")
public class ApiNetXmlDeaBaseConfig {
    @Resource
    private NetXmlDeaBaseConfigService netXmlDeaBaseConfigService;

    @PostMapping("/add")
    public Result add(@RequestBody NetXmlDeaBaseConfig netXmlDeaBaseConfig) {
        netXmlDeaBaseConfigService.insertSelective(netXmlDeaBaseConfig);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        netXmlDeaBaseConfigService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody NetXmlDeaBaseConfig netXmlDeaBaseConfig) {
        netXmlDeaBaseConfigService.updateByPrimaryKeySelective(netXmlDeaBaseConfig);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        NetXmlDeaBaseConfig netXmlDeaBaseConfig = netXmlDeaBaseConfigService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(netXmlDeaBaseConfig);
    }

	@PostMapping("/list")
    public Result list(@RequestBody NetXmlDeaBaseConfigVo netXmlDeaBaseConfigVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(netXmlDeaBaseConfigVo.getPageSize() != null && netXmlDeaBaseConfigVo.getPageSize() != 0){
    		return pageList(netXmlDeaBaseConfigVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<NetXmlDeaBaseConfig> list = netXmlDeaBaseConfigService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody NetXmlDeaBaseConfigVo netXmlDeaBaseConfigVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(netXmlDeaBaseConfigVo.getPageNumber(), netXmlDeaBaseConfigVo.getPageSize());
		// TODO 根据具体业务重写
    	List<NetXmlDeaBaseConfig> list = netXmlDeaBaseConfigService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<NetXmlDeaBaseConfig>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<NetXmlDeaBaseConfig> pageInfo = netXmlDeaBaseConfigService.selectPage(netXmlDeaBaseConfigVo.getPageNumber(), netXmlDeaBaseConfigVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
