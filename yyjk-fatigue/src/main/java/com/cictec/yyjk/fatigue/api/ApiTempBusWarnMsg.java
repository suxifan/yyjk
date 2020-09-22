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
import com.cictec.yyjk.fatigue.model.entity.TempBusWarnMsg;
import com.cictec.yyjk.fatigue.model.vo.TempBusWarnMsgVo;
import com.cictec.yyjk.fatigue.service.TempBusWarnMsgService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by xpguo on 2020/01/15.
*/
@RestController
@RequestMapping("/api/temp/bus/warn/msg")
public class ApiTempBusWarnMsg {
    @Resource
    private TempBusWarnMsgService tempBusWarnMsgService;

    @PostMapping("/add")
    public Result add(@RequestBody TempBusWarnMsg tempBusWarnMsg) {
        tempBusWarnMsgService.insertSelective(tempBusWarnMsg);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        tempBusWarnMsgService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TempBusWarnMsg tempBusWarnMsg) {
        tempBusWarnMsgService.updateByPrimaryKeySelective(tempBusWarnMsg);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TempBusWarnMsg tempBusWarnMsg = tempBusWarnMsgService.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(tempBusWarnMsg);
    }

	@PostMapping("/list")
    public Result list(@RequestBody TempBusWarnMsgVo tempBusWarnMsgVo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(tempBusWarnMsgVo.getPageSize() != null && tempBusWarnMsgVo.getPageSize() != 0){
    		return pageList(tempBusWarnMsgVo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<TempBusWarnMsg> list = tempBusWarnMsgService.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody TempBusWarnMsgVo tempBusWarnMsgVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(tempBusWarnMsgVo.getPageNumber(), tempBusWarnMsgVo.getPageSize());
		// TODO 根据具体业务重写
    	List<TempBusWarnMsg> list = tempBusWarnMsgService.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<TempBusWarnMsg>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<TempBusWarnMsg> pageInfo = tempBusWarnMsgService.selectPage(tempBusWarnMsgVo.getPageNumber(), tempBusWarnMsgVo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
