package com.cictec.yyjk.fatigue.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.fatigue.model.entity.MidBusWarnMsg;
import com.cictec.yyjk.fatigue.model.vo.MidBusWarnMsgVo;
import com.cictec.yyjk.fatigue.service.MidBusWarnMsgService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2020/01/15.
*/
@RestController
@RequestMapping("/api/mid/bus/warn/msg")
public class ApiMidBusWarnMsg {
    @Resource
    private MidBusWarnMsgService midBusWarnMsgService;

    @PostMapping("/add")
    public Result add(@RequestBody MidBusWarnMsg midBusWarnMsg) {
        midBusWarnMsgService.insertSelective(midBusWarnMsg);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        midBusWarnMsgService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody MidBusWarnMsg midBusWarnMsg) {
        midBusWarnMsgService.updateByPrimaryKeySelective(midBusWarnMsg);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MidBusWarnMsg midBusWarnMsg = midBusWarnMsgService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(midBusWarnMsg);
    }

	@PostMapping("/list")
    public Result list(@RequestBody MidBusWarnMsgVo midBusWarnMsgVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(midBusWarnMsgVo.getPageSize() != null && midBusWarnMsgVo.getPageSize() != 0){
    		return pageList(midBusWarnMsgVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<MidBusWarnMsg> list = midBusWarnMsgService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody MidBusWarnMsgVo midBusWarnMsgVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(midBusWarnMsgVo.getPageNumber(), midBusWarnMsgVo.getPageSize());
		// TODO 根据具体业务重写
    	List<MidBusWarnMsg> list = midBusWarnMsgService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<MidBusWarnMsg>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<MidBusWarnMsg> pageInfo = midBusWarnMsgService.selectPage(midBusWarnMsgVo.getPageNumber(), midBusWarnMsgVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
